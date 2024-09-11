package org.reringuy.kmmproject

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ExitToApp
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.runtime.*
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.reringuy.kmmproject.navigation.RootComponent
import org.reringuy.kmmproject.screens.BScreen
import org.reringuy.kmmproject.screens.HomeScreen

@Composable
@Preview
fun App(rootComponent: RootComponent) {
    MaterialTheme {
        AppNavigation(rootComponent)
    }
}

@Composable
fun AppNavigation(rootComponent: RootComponent) {
    val childStack by rootComponent.childStack.subscribeAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Bem-Vindo")},
                actions = {
                    Row {
                        IconButton(
                            onClick = { /*TODO*/}
                        ){
                            Icon(imageVector = Icons.Rounded.Refresh, "Sync")
                        }
                        IconButton(
                            onClick = { /*TODO*/}
                        ){
                            Icon(imageVector = Icons.AutoMirrored.Rounded.ExitToApp, "LogOut")
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        Children(
            stack = childStack,
            animation = stackAnimation(slide())
        ){ child ->
            when(val instance = child.instance){
                is RootComponent.Child.ScreenB -> BScreen(instance.comoponent.text, instance.comoponent)
                is RootComponent.Child.ScreenHome -> HomeScreen(instance.comoponent)
            }
        }
    }
}