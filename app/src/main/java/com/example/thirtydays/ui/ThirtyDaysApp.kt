package com.example.thirtydays.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.thirtydays.ui.theme.AppAccent
import com.example.thirtydays.ui.theme.BeautifulAppsTheme

private val CompletedDaysSaver = listSaver<Set<Int>, Int>(
    save = { it.toList() },
    restore = { it.toSet() },
)

/**
 * Root of the application. Keeps the user-visible state (accent, completed days, current screen)
 * and demonstrates a custom animated transition between the two screens.
 */
@Composable
fun ThirtyDaysApp() {
    var accent by rememberSaveable { mutableStateOf(AppAccent.Indigo) }
    var showSuperheroes by rememberSaveable { mutableStateOf(false) }
    var completedDays by rememberSaveable(stateSaver = CompletedDaysSaver) {
        mutableStateOf(emptySet<Int>())
    }

    BeautifulAppsTheme(accent = accent) {
        BackHandler(enabled = showSuperheroes) { showSuperheroes = false }

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            AnimatedContent(
                targetState = showSuperheroes,
                transitionSpec = {
                    val enter = slideInHorizontally(tween(350)) { fullWidth ->
                        if (targetState) fullWidth / 4 else -fullWidth / 4
                    } + fadeIn(tween(350))
                    val exit = slideOutHorizontally(tween(350)) { fullWidth ->
                        if (targetState) -fullWidth / 4 else fullWidth / 4
                    } + fadeOut(tween(250))
                    enter togetherWith exit
                },
                label = "screen transition",
            ) { heroesVisible ->
                if (heroesVisible) {
                    SuperheroesScreen(onBack = { showSuperheroes = false })
                } else {
                    TipsScreen(
                        accent = accent,
                        onAccentSelected = { accent = it },
                        onOpenSuperheroes = { showSuperheroes = true },
                        completedDays = completedDays,
                        onToggleCompleted = { day ->
                            completedDays = if (day in completedDays) {
                                completedDays - day
                            } else {
                                completedDays + day
                            }
                        },
                    )
                }
            }
        }
    }
}
