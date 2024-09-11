package org.reringuy.kmmproject.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import kotlinx.serialization.Serializable
import org.reringuy.kmmproject.navigation.childComponents.bComponent.ScreenBComponent
import org.reringuy.kmmproject.navigation.childComponents.homeComponent.ScreenHomeComponent

class RootComponent(
    componentContext: ComponentContext
): ComponentContext by componentContext {

    private val navigation = StackNavigation<Configuration>()

    val childStack = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.ScreenHome,
        handleBackButton = true,
        childFactory = ::createChild
    )

    @OptIn(ExperimentalDecomposeApi::class)
    private fun createChild(
        config: Configuration,
        context: ComponentContext
    ): Child {
        return when (config){
            Configuration.ScreenHome -> Child.ScreenHome(
                ScreenHomeComponent(
                    componentContext = context,
                    onNavigateToScreenB = {
                        navigation.pushNew(Configuration.ScreenB(it))
                    }
                )
            )
            is Configuration.ScreenB -> Child.ScreenB(
                ScreenBComponent(
                    text = config.text,
                    componentContext = context,
                    onGoBack = {
                        navigation.pop()
                    }
                )
            )
        }
    }

    sealed class Child {
        data class ScreenHome(val comoponent: ScreenHomeComponent): Child()
        data class ScreenB(val comoponent: ScreenBComponent): Child()
    }

    @Serializable
    sealed class Configuration {
        @Serializable
        data object ScreenHome: Configuration()
        @Serializable
        data class ScreenB(val text: String): Configuration()
    }
}