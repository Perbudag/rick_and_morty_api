package presentation.screens.character.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.ImageBitmap
import domain.models.Character

data class CharacterState(
    val character: Character,
    val image: MutableState<ImageBitmap?> = mutableStateOf(null)
)
