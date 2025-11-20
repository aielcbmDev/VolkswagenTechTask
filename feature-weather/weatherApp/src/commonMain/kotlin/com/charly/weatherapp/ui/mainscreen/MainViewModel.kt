package com.charly.weatherapp.ui.mainscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.charly.domain.usecases.GetDailyWeatherForecastListUseCase
import com.charly.weatherapp.formatdata.TimeFormatter
import com.charly.weatherapp.mappers.mapToDailyForecastModelList
import com.charly.weatherapp.model.DailyForecastModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val getDailyWeatherForecastListUseCase: GetDailyWeatherForecastListUseCase,
    private val timeFormatter: TimeFormatter
) : ViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
        _state.update { it.copy(mainUiState = MainUiState.Error) }
    }

    private val _state = MutableStateFlow(MainScreenState())
    val state: StateFlow<MainScreenState> = _state.asStateFlow()

    init {
        fetchDailyWeatherForecast()
    }

    fun handleIntent(viewIntent: ViewIntent) {
        when (viewIntent) {
            is ViewIntent.FetchDailyWeatherForecast -> fetchDailyWeatherForecast()
        }
    }

    private fun fetchDailyWeatherForecast() {
        _state.update { it.copy(mainUiState = MainUiState.Loading) }
        viewModelScope.launch(exceptionHandler) {
            getDailyWeatherForecastListUseCase.execute()
                .map { it.mapToDailyForecastModelList(timeFormatter, "n/a") }
                .flowOn(Dispatchers.IO)
                .collect { dailyForecastModelList ->
                    _state.update { it.copy(mainUiState = MainUiState.Success(dailyForecastModelList = dailyForecastModelList)) }
                }
        }
    }
}

data class MainScreenState(
    val mainUiState: MainUiState = MainUiState.Loading
)

sealed interface MainUiState {
    data class Success(
        val dailyForecastModelList: List<DailyForecastModel>,
    ) : MainUiState

    object Loading : MainUiState
    object Error : MainUiState
}

sealed interface ViewIntent {
    object FetchDailyWeatherForecast : ViewIntent
}
