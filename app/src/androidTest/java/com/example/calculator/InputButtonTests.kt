package com.example.calculator

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.calculator.buttons.ActionButton
import com.example.calculator.buttons.InputButton
import org.junit.Rule
import org.junit.Test

class InputButtonTests {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun inputButtonTest_isNormalButtonCreated() {
        composeTestRule.setContent {
            InputButton(
                text = R.string.one,
                onClick = {  },
                backgroundColor = Color.White,
                textColor = Color.Black
            )
        }

        composeTestRule
            .onNodeWithText("1")
            .assertIsDisplayed()
    }

    @Test
    fun inputButtonTest_isZeroButtonCreated() {
        composeTestRule.setContent {
            InputButton(
                text = R.string.zero,
                onClick = {  },
                backgroundColor = Color.White,
                textColor = Color.Black
            )
        }

        composeTestRule
            .onNodeWithText("0")
            .assertIsDisplayed()
    }
}