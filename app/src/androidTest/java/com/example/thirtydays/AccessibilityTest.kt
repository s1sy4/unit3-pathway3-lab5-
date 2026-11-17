package com.example.thirtydays

import androidx.compose.ui.test.assertHeightIsAtLeast
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertWidthIsAtLeast
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.unit.dp
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Accessibility checks from the "Testing for Accessibility" codelab:
 * every icon-only action has a description, touch targets are at least 48 dp,
 * and state changes are exposed to accessibility services.
 */
@RunWith(AndroidJUnit4::class)
class AccessibilityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun themeButton_hasDescriptionAndLargeEnoughTouchTarget() {
        composeTestRule
            .onNodeWithContentDescription(
                composeTestRule.activity.getString(R.string.choose_theme_cd),
            )
            .assertExists()

        composeTestRule
            .onNodeWithTag("theme_button")
            .assertHeightIsAtLeast(48.dp)
            .assertWidthIsAtLeast(48.dp)
    }

    @Test
    fun superheroesButton_opensAccessibleScreen() {
        composeTestRule
            .onNodeWithContentDescription(
                composeTestRule.activity.getString(R.string.open_superheroes),
            )
            .performClick()

        composeTestRule
            .onNodeWithText(composeTestRule.activity.getString(R.string.superheroes))
            .assertExists()

        composeTestRule
            .onNodeWithContentDescription(composeTestRule.activity.getString(R.string.back))
            .assertExists()
            .performClick()
    }

    @Test
    fun tipCard_expandsAndMarksDayCompleted() {
        composeTestRule.onNodeWithText("Начните с Compose").performClick()

        composeTestRule
            .onNodeWithTag("complete_day_1")
            .assertExists()
            .performClick()
            .assertTextContains(composeTestRule.activity.getString(R.string.completed))

        composeTestRule.onNodeWithText("Выполнено 1 из 30").assertExists()
    }

    @Test
    fun favouriteButton_changesItsDescription() {
        composeTestRule
            .onNodeWithContentDescription(
                composeTestRule.activity.getString(R.string.open_superheroes),
            )
            .performClick()

        composeTestRule
            .onNodeWithTag("favorite_Человек-паук")
            .performClick()

        composeTestRule
            .onNodeWithContentDescription(
                composeTestRule.activity.getString(R.string.favorite_remove),
            )
            .assertExists()
    }
}
