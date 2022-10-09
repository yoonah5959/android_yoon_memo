package heenu.moon.yoon_memo_android.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import timber.log.Timber

private val DarkColorPalette = darkColors(
    primary = Yellow300,
    primaryVariant = Yellow300,
    secondary = Yellow300
)

private val LightColorPalette = lightColors(
    primary = Yellow300,
    primaryVariant = Yellow300,
    secondary = Yellow300
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