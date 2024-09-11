package org.reringuy.kmmproject.navigation.childComponents.homeComponent

sealed interface ScreenHomeEvent {
    data object ClickButton: ScreenHomeEvent
    data class UpdateText(val text: String): ScreenHomeEvent
}