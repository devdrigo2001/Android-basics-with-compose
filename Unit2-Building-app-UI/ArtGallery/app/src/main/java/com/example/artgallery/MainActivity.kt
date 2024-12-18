package com.example.artgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artgallery.ui.theme.ArtGalleryTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtGalleryTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ArtGaleryLayout()
                }
            }
        }
    }
}

@Composable
fun ArtGaleryLayout(modifier: Modifier = Modifier) {
    var currentImage by remember { mutableStateOf(1) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(20.dp)
    ) {
        when(currentImage){
            1 ->
                Art(
                    title = stringResource(R.string.vasco_art_title),
                    description = stringResource(R.string.vasco_art_desc),
                    drawableResource = R.drawable.vasco,
                    onClickNext = {currentImage = 2},
                    onClickPrevious = {}
                )
            2 ->
                Art(
                    title = "Android",
                    description = "GreenAndroid(2024)",
                    drawableResource = R.drawable.ic_launcher_background,
                    onClickNext = {currentImage = 2},
                    onClickPrevious = {currentImage = 1}
                )


        }



    }
}

@Composable
fun Art(
    title: String,
    description: String,
    drawableResource : Int,
    onClickPrevious: () -> Unit,
    onClickNext: () -> Unit,
    modifier: Modifier = Modifier) {
    Column(modifier = Modifier.background(Color.White).fillMaxWidth())
    {
        Image(
            painter = painterResource(drawableResource),
            contentDescription = "museum image",
            modifier = Modifier.width(300.dp)
                .align(Alignment.CenterHorizontally)
                .padding(20.dp)





        )
    }

    Spacer(modifier = Modifier.height(30.dp))
    TitleAndDescription(title = title, description = description)


    Spacer(modifier = Modifier.height(50.dp))
    ButtonRow(onClickPrevious = onClickPrevious, onClickNext = onClickNext, modifier.width(60.dp))


}

@Composable
fun TitleAndDescription(title: String, description: String){
    Column(
        modifier = Modifier
            .background(color= Color(0xabdefafa))
            .fillMaxWidth()



    ) {
        Text(
            text = title,
            modifier = Modifier.padding(5.dp)
        )
        Text(
            text = description,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            modifier = Modifier.padding(5.dp)

        )


    }
}

@Composable
fun ButtonRow(onClickPrevious: () -> Unit, onClickNext: () -> Unit, modifier: Modifier = Modifier){
    Row(horizontalArrangement = Arrangement.Center){
        Button(onClick = onClickPrevious) {
            Text(text = "Previous")
        }
        Spacer(modifier = modifier)
        Button(onClick = onClickNext) {
            Text(text = "Next")
        }
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtGalleryTheme {
        ArtGaleryLayout()
    }
}