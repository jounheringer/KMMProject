package org.reringuy.kmmproject.navigation.childComponents.homeComponent

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue

class ScreenHomeComponent(
    componentContext: ComponentContext,
    private val onNavigateToScreenB: (String) -> Unit
): ComponentContext by componentContext {

    private var _text = MutableValue("")
    val text get() = _text

    fun onEvent(event: ScreenHomeEvent) {
        when (event){
            ScreenHomeEvent.ClickButton -> onNavigateToScreenB(text.value)
            is ScreenHomeEvent.UpdateText -> {
                _text.value = event.text
            }
        }

    }
}