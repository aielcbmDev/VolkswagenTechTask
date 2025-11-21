package com.charly.weatherapp.ui.main.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.charly.weatherapp.ui.main.model.DailyForecastMainModel
import org.jetbrains.compose.resources.stringResource
import volkswagentechtask.feature_weather.weatherapp.generated.resources.Res
import volkswagentechtask.feature_weather.weatherapp.generated.resources.main_screen_top_app_bar_title

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenSuccess(
    dailyForecastMainModelList: List<DailyForecastMainModel>,
    onDailyForecastModelClick: (Long) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(Res.string.main_screen_top_app_bar_title)) },
                colors = TopAppBarDefaults.topAppBarColors(titleContentColor = Color.Red)
            )
        }
    ) { padding ->
        val state = rememberLazyListState()
        LazyColumn(
            state = state,
            modifier = Modifier.padding(padding)
        ) {
            items(
                items = dailyForecastMainModelList,
                key = { item -> item.id }
            ) { dailyForecastMainModel ->
                DailyItem(
                    dailyForecastMainModel = dailyForecastMainModel,
                    onDailyForecastModelClick = onDailyForecastModelClick
                )
            }
        }
    }
}

@Composable
fun DailyItem(
    dailyForecastMainModel: DailyForecastMainModel,
    onDailyForecastModelClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = { onDailyForecastModelClick.invoke(dailyForecastMainModel.id) },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text = dailyForecastMainModel.dt,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.outline,
                modifier = modifier.padding(top = 12.dp, bottom = 8.dp),
            )

            Text(
                text = dailyForecastMainModel.summary,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}
