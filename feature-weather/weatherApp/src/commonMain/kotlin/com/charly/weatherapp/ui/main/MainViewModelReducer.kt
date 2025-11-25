package com.charly.weatherapp.ui.main

import com.charly.weatherapp.OpenClassForMocking
import com.charly.weatherapp.ui.main.model.DailyForecastMainModel

@OpenClassForMocking
class MainViewModelReducer {

    fun reduce(state: MainScreenState, action: Action): MainScreenState {
        return when (action) {
            is Action.Fetching -> processFetching(state)
            is Action.FetchSuccess -> processFetchSuccess(state, action)
            is Action.FetchError -> processFetchError(state)
        }
    }

    private fun processFetching(state: MainScreenState): MainScreenState {
        val currentUiState = state.mainUiState
        return if (currentUiState is MainUiState.Success) {
            state.copy(mainUiState = currentUiState.copy(isRefreshing = true))
        } else {
            state.copy(mainUiState = MainUiState.Loading)
        }
    }

    private fun processFetchSuccess(
        state: MainScreenState,
        action: Action.FetchSuccess
    ): MainScreenState {
        return state.copy(
            mainUiState = MainUiState.Success(
                dailyForecastMainModelList = action.dailyForecastMainModelList
            )
        )
    }

    private fun processFetchError(state: MainScreenState): MainScreenState {
        val currentUiState = state.mainUiState
        return if (currentUiState is MainUiState.Success) {
            state.copy(
                mainUiState = currentUiState.copy(
                    isSnackBarVisible = true,
                    isRefreshing = false
                )
            )
        } else {
            state.copy(mainUiState = MainUiState.Error)
        }
    }
}

sealed interface Action {
    object Fetching : Action
    data class FetchSuccess(
        val dailyForecastMainModelList: List<DailyForecastMainModel>
    ) : Action

    object FetchError : Action
}
