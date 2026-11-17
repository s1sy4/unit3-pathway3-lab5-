package com.example.thirtydays.ui.theme

import androidx.compose.ui.graphics.Color

/**
 * Accent palettes available in the app. Changing the accent demonstrates Material Theming:
 * the whole Material 3 color scheme is rebuilt from these seed colours.
 */
enum class AppAccent(
    val label: String,
    val primary: Color,
    val onPrimary: Color,
    val primaryContainer: Color,
    val onPrimaryContainer: Color,
    val primaryDark: Color,
    val onPrimaryDark: Color,
    val primaryContainerDark: Color,
    val onPrimaryContainerDark: Color,
) {
    Indigo(
        label = "Индиго",
        primary = Color(0xFF4355B9),
        onPrimary = Color(0xFFFFFFFF),
        primaryContainer = Color(0xFFDEE0FF),
        onPrimaryContainer = Color(0xFF00105C),
        primaryDark = Color(0xFFBAC3FF),
        onPrimaryDark = Color(0xFF08218A),
        primaryContainerDark = Color(0xFF293CA0),
        onPrimaryContainerDark = Color(0xFFDEE0FF),
    ),
    Emerald(
        label = "Изумруд",
        primary = Color(0xFF006C4C),
        onPrimary = Color(0xFFFFFFFF),
        primaryContainer = Color(0xFF89F8C7),
        onPrimaryContainer = Color(0xFF002114),
        primaryDark = Color(0xFF6DDBAC),
        onPrimaryDark = Color(0xFF003825),
        primaryContainerDark = Color(0xFF005138),
        onPrimaryContainerDark = Color(0xFF89F8C7),
    ),
    Amber(
        label = "Янтарь",
        primary = Color(0xFF7A5900),
        onPrimary = Color(0xFFFFFFFF),
        primaryContainer = Color(0xFFFFDF9A),
        onPrimaryContainer = Color(0xFF261A00),
        primaryDark = Color(0xFFF3BF48),
        onPrimaryDark = Color(0xFF412D00),
        primaryContainerDark = Color(0xFF5D4300),
        onPrimaryContainerDark = Color(0xFFFFDF9A),
    ),
    Rose(
        label = "Роза",
        primary = Color(0xFF984061),
        onPrimary = Color(0xFFFFFFFF),
        primaryContainer = Color(0xFFFFD9E2),
        onPrimaryContainer = Color(0xFF3E001D),
        primaryDark = Color(0xFFFFB1C8),
        onPrimaryDark = Color(0xFF5E1133),
        primaryContainerDark = Color(0xFF7B2949),
        onPrimaryContainerDark = Color(0xFFFFD9E2),
    ),
}

internal object ColorTokens {
    val White = Color(0xFFFFFFFF)
    val LightSurfaceLow = Color(0xFFF5F2FA)
    val LightSurfaceContainer = Color(0xFFEFEDF4)
    val LightSurfaceHigh = Color(0xFFE9E7EF)
    val LightOutlineVariant = Color(0xFFC7C5D0)
    val DarkSurfaceLowest = Color(0xFF0D0E13)
    val DarkSurfaceLow = Color(0xFF1A1B21)
    val DarkSurfaceContainer = Color(0xFF1E1F25)
    val DarkSurfaceHigh = Color(0xFF292A30)
    val DarkOutlineVariant = Color(0xFF46464F)
}

// Neutral supporting colours shared by all accents.
internal val LightSecondary = Color(0xFF565E71)
internal val LightOnSecondary = Color(0xFFFFFFFF)
internal val LightSecondaryContainer = Color(0xFFDAE2F9)
internal val LightOnSecondaryContainer = Color(0xFF131C2B)
internal val LightTertiary = Color(0xFF6F5575)
internal val LightOnTertiary = Color(0xFFFFFFFF)
internal val LightTertiaryContainer = Color(0xFFF9D8FD)
internal val LightOnTertiaryContainer = Color(0xFF28132F)
internal val LightBackground = Color(0xFFFBF8FF)
internal val LightOnBackground = Color(0xFF1A1B21)
internal val LightSurfaceVariant = Color(0xFFE3E1EC)
internal val LightOnSurfaceVariant = Color(0xFF46464F)
internal val LightOutline = Color(0xFF777680)

internal val DarkSecondary = Color(0xFFBEC6DC)
internal val DarkOnSecondary = Color(0xFF283141)
internal val DarkSecondaryContainer = Color(0xFF3E4759)
internal val DarkOnSecondaryContainer = Color(0xFFDAE2F9)
internal val DarkTertiary = Color(0xFFDCBCE1)
internal val DarkOnTertiary = Color(0xFF3E2845)
internal val DarkTertiaryContainer = Color(0xFF573E5E)
internal val DarkOnTertiaryContainer = Color(0xFFF9D8FD)
internal val DarkBackground = Color(0xFF121318)
internal val DarkOnBackground = Color(0xFFE4E1E9)
internal val DarkSurfaceVariant = Color(0xFF46464F)
internal val DarkOnSurfaceVariant = Color(0xFFC7C5D0)
internal val DarkOutline = Color(0xFF918F9A)
