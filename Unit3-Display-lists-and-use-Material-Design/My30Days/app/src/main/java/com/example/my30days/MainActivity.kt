package com.example.my30days

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            My30DaysTheme {
                Surface(modifier = Modifier.fillMaxSize()) {

                }

                }
            }
        }
    }


@Composable
fun DayItem(modifier: Modifier = Modifier) {
    Card { Text("Title") }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    My30DaysTheme {
       DayItem()
    }
}