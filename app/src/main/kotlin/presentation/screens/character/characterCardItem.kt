package presentation.screens.character

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.onClick
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import domain.models.Status

@Composable
fun characterCardItem(
    image: Painter, name: String, status: Status, type: String, onClick: () -> Unit
) {
    val textColor = Color.White

    Card(
        modifier = Modifier
            .aspectRatio(1f)
            .sizeIn(minWidth = 300.dp, maxWidth = 400.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(15.dp),
        backgroundColor = Color.Gray
    ) {
        Image(
            painter = image,
            contentDescription = "Photo of $name"
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.7f)
                .background(
                    Brush.verticalGradient(
                        0.4f to Color.Transparent,
                        0.9f to Color.Black
                    )
                )
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = name,
                color = textColor,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold
            )
            Row(
                modifier = Modifier.padding(bottom = 5.dp)
            ) {
                val statusColor = when (status) {
                    Status.alive -> Color.Green
                    Status.dead -> Color.Red
                    Status.unknown -> Color.Yellow
                }

                Text(
                    text = "● ", color = statusColor
                )
                Text(
                    text = "${status.name.capitalize()} - $type",
                    color = textColor
                )
            }
        }
    }
}

@Composable
@Preview
fun characterCardItemPreview() {
    characterCardItem(
        image = painterResource("2.png"),
        name = "Mr. Needful", status = Status.unknown,
        type = "Humanoid"
    ) {

    }
}