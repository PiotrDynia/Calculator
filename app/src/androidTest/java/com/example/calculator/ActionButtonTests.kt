package com.example.calculator

import androidx.compose.ui.test.assertIsDisplayed
import org.junit.Rule
import org.junit.Test
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.calculator.buttons.ActionButton

class ActionButtonTests {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun actionButtonTest_isButtonCreated() {
        composeTestRule.setContent {
            ActionButton(text = R.string.plus, onClick = {  })
        }

        composeTestRule
            .onNodeWithText("+")
            .assertIsDisplayed()
    }

    @Test
    fun actionButtonTest_isButtonClickable() {
        var clickedButton = ""

        composeTestRule.setContent {
            ActionButton(text = R.string.plus, onClick = { clickedButton = "+" })
        }

        composeTestRule.onNodeWithText("+").performClick()
        assert(clickedButton == "+")
    }
}