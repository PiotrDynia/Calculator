package com.example.calculator

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class ButtonsRowTests {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun buttonsRowTest_areAllButtonsCreated() {
        composeTestRule.setContent {
            ButtonsContent()
        }

        composeTestRule.onNodeWithText("AC").assertExists()
        composeTestRule.onNodeWithText("+/-").assertExists()
        composeTestRule.onNodeWithText("%").assertExists()
        composeTestRule.onNodeWithText("÷").assertExists()
        composeTestRule.onNodeWithText("7").assertExists()
        composeTestRule.onNodeWithText("8").assertExists()
        composeTestRule.onNodeWithText("9").assertExists()
        composeTestRule.onNodeWithText("X").assertExists()
        composeTestRule.onNodeWithText("4").assertExists()
        composeTestRule.onNodeWithText("5").assertExists()
        composeTestRule.onNodeWithText("6").assertExists()
        composeTestRule.onNodeWithText("-").assertExists()
        composeTestRule.onNodeWithText("1").assertExists()
        composeTestRule.onNodeWithText("2").assertExists()
        composeTestRule.onNodeWithText("3").assertExists()
        composeTestRule.onNodeWithText("+").assertExists()
        composeTestRule.onNodeWithText("0").assertExists()
        composeTestRule.onNodeWithText(".").assertExists()
        composeTestRule.onNodeWithText("=").assertExists()
    }
}