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
import org.jetbrains.compose.ui.tooling.preview.Preview

import testkmm.composeapp.generated.resources.Res
import testkmm.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        AppNavigation()
    }
}

@Composable
fun AppNavigation() {
    val navController =

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

    }
}