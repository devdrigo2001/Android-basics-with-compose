package com.example.quadrantes

import android.icu.text.IDNA.Info
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quadrantes.ui.theme.QuadrantesTheme
import kotlin.io.encoding.Base64
import kotlin.text.HexFormat.Companion.Default

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuadrantesTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    QuadrantApp()
                }
            }
        }
    }
}

@Composable
fun QuadrantApp(){
    Column(
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       Row(modifier = Modifier.weight(1f)) {
           InfoCard(
               modifier = Modifier.weight(1f),
               text = stringResource(R.string.q1_text),
               title = stringResource(R.string.q1_title),
               backgroundColor = Color(0xFFEADDFF))
           InfoCard(
               modifier = Modifier.weight(1f),
               text = stringResource(R.string.q2_text),
               title = stringResource(R.string.q2_title),
               backgroundColor = Color(0xFFD0BCFF))

       }
        Row(modifier = Modifier.weight(1f)){
            InfoCard(
                modifier = Modifier.weight(1f),
                text = stringResource(R.string.q3_text),
                title = stringResource(R.string.q3_title),
                backgroundColor = Color(0xFFB69DF8))

            InfoCard(
                modifier = Modifier.weight(1f),
                text = stringResource(R.string.q4_text),
                title = stringResource(R.string.q4_title),
                backgroundColor = Color(0xFFF6EDFF))

        }
    }
}





@Composable
fun InfoCard(text: String, title : String, modifier: Modifier = Modifier, backgroundColor : Color) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .background(backgroundColor)

        ) {
            Text(
                modifier = Modifier.padding(bottom = 16.dp),
                text = title,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = text,
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
        }
    }



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuadrantesTheme {
       QuadrantApp()

    }
}