package heenu.moon.yoon_memo_android.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = Yellow300,
    onPrimary = White,
    secondary = Gray5,
    onSecondary = White,
    surface = Gray9,
    onSurface = White,
    background = Gray9,
    onBackground = White
)

private val LightColorPalette = lightColors(
    primary = Yellow300,
    onPrimary = Gray9,
    secondary = Gray7,
    onSecondary = Gray9,
    surface = White,
    onSurface = Gray9,
    background = White,
    onBackground = Gray9
)

@Composable
fun Yoon_memo_androidTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = colors.background
    )
    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}