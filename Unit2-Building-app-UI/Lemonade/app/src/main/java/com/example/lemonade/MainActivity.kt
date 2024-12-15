package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonApp()

            }
        }
    }
}

@Composable
fun LemonApp(
    modifier: Modifier = Modifier
        .fillMaxSize()

){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        var result by remember { mutableStateOf(1) }
        val imageResource = when (result) {
            1 -> R.drawable.lemon_tree
            2 -> R.drawable.lemon_squeeze
            3 -> R.drawable.lemon_drink
            else -> R.drawable.lemon_restart

        }
        val contentDesc = when (result) {
            1 -> R.string.step1
            2 -> R.string.step2
            3 -> R.string.step3
            else -> R.string.step4


        }

        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Button(
                onClick = {
                    result = when (result) {
                        1 -> 2
                        2 -> 3
                        3 -> 4
                        else -> 1
                    }
                }

            ) {
                Image(

                    painter = painterResource(imageResource),
                    contentDescription = stringResource(contentDesc)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(contentDesc),
                fontSize = 18.sp
            )


        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    LemonadeTheme{
        LemonApp()
    }
}
