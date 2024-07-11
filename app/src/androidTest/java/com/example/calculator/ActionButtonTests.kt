package com.example.calculator

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.semantics.getOrNull
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import org.junit.Rule
import org.junit.Test
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
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
}