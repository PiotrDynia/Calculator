package com.example.calculator.buttons

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color

data class ButtonData(
    @StringRes val text: Int,
    val onClick: () -> Unit,
    val textColor: Color,
    val backgroundColor: Color,
    val isActionButton: Boolean = false
)
