package com.example.kotlinpocintentsandactivities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.kotlinpocintentsandactivities.ui.theme.KotlinPoCIntentsAndActivitiesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinPoCIntentsAndActivitiesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Greeting(
                            name = "Android", modifier = Modifier.padding(innerPadding)
                        )
                        Button(onClick = {
                            Intent(
                                applicationContext,
                                WordDetailActivity::class.java
                            ).also { startActivity(it) }
                        }) {
                            Text("Open word detail")
                        }
                        OutlinedButton(
                            onClick = {
                                Intent(Intent.ACTION_MAIN).also {
                                    it.`package` = "com.google.android.youtube"
                                    startActivity(it)
                                }
                            }
                        ) {
                            Text("Open YouTube")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}
