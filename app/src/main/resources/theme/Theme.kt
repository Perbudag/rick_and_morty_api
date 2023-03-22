import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import theme.ThemeTypography
import theme.darkColors
import theme.lightColors

@Composable
fun Theme(isDarkTheme: Boolean = false, content: @Composable () -> Unit) {

    val colors = if (isDarkTheme) darkColors else lightColors

    MaterialTheme(
        colors = colors,
        typography = ThemeTypography,
        shapes = MaterialTheme.shapes,
        content = content
    )

}