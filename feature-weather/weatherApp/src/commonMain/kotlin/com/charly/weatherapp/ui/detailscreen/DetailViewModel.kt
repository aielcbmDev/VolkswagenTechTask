package com.charly.weatherapp.ui.detailscreen

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.charly.domain.usecases.GetDailyWeatherForecastByIdUseCase
import com.charly.weatherapp.formatdata.datetime.DateFormatter
import com.charly.weatherapp.formatdata.datetime.TimeFormatter
import com.charly.weatherapp.formatdata.degrees.DegreesFormatter
import com.charly.weatherapp.formatdata.speed.SpeedFormatter
import com.charly.weatherapp.formatdata.temperature.TemperatureFormatter
import com.charly.weatherapp.mappers.mapToDailyForecastDetailModel
import com.charly.weatherapp.model.DailyForecastDetailModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.compose.resources.getString
import volkswagentechtask.feature_weather.weatherapp.generated.resources.Res
import volkswagentechtask.feature_weather.weatherapp.generated.resources.data_not_available_text

class DetailViewModel(
    private val itemId: Long,
    private val getDailyWeatherForecastByIdUseCase: GetDailyWeatherForecastByIdUseCase,
    private val dateFormatter: DateFormatter,
    private val timeFormatter: TimeFormatter,
    private val speedFormatter: SpeedFormatter,
    private val temperatureFormatter: TemperatureFormatter,
    private val degreesFormatter: DegreesFormatter
) : ViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
        _state.update { it.copy(detailUiState = DetailUiState.Error) }
    }

    private val _state = MutableStateFlow(DetailScreenState())
    val state: StateFlow<DetailScreenState> = _state.asStateFlow()

    init {
        fetchDailyWeatherForecastById()
    }

    fun handleIntent(viewIntent: DetailViewIntent) {
        when (viewIntent) {
            is DetailViewIntent.FetchDailyWeatherForecastById -> fetchDailyWeatherForecastById()
        }
    }

    private fun fetchDailyWeatherForecastById() {
        _state.update { it.copy(detailUiState = DetailUiState.Loading) }
        viewModelScope.launch(exceptionHandler) {
            val dailyForecastModel = withContext(Dispatchers.IO) {
                getDailyWeatherForecastByIdUseCase.execute(itemId)
                    .mapToDailyForecastDetailModel(
                        dateFormatter = dateFormatter,
                        timeFormatter = timeFormatter,
                        speedFormatter = speedFormatter,
                        temperatureFormatter = temperatureFormatter,
                        degreesFormatter = degreesFormatter,
                        noDataAvailable = getString(Res.string.data_not_available_text)
                    )
            }
            _state.update {
                it.copy(detailUiState = DetailUiState.Success(dailyForecastDetailModel = dailyForecastModel))
            }
        }
    }
}

@Immutable
data class DetailScreenState(
    val detailUiState: DetailUiState = DetailUiState.Loading
)

@Immutable
sealed interface DetailUiState {
    data class Success(
        val dailyForecastDetailModel: DailyForecastDetailModel,
    ) : DetailUiState

    object Loading : DetailUiState
    object Error : DetailUiState
}

sealed interface DetailViewIntent {
    object FetchDailyWeatherForecastById : DetailViewIntent
}
