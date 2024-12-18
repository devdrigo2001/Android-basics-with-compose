package com.example.artgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
                    Home()
                }
            }
        }
    }
}

@Composable
fun Home(modifier: Modifier = Modifier) {
    var currentImage by remember { mutableStateOf(1) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(20.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        when(currentImage){
            1 ->
                Art(
                    title = stringResource(R.string.vasco_art_title),
                    description = stringResource(R.string.vasco_art_desc),
                    drawableResource = R.drawable.vasco,
                    onImageClick = {currentImage = 2},
                    onImagePreviousClick = {}
                )
            2 ->
                Art(
                    title = "Android",
                    description = "GreenAndroid(2024)",
                    drawableResource = R.drawable.ic_launcher_background,
                    onImageClick = {currentImage = 2},
                    onImagePreviousClick = {currentImage = 1}
                )
            3 ->
                Art(
                title = "Visão geral",
                description = "Visão geral do Museu do Banco do Brasil",
                drawableResource = R.drawable.overview,
                onImageClick = {currentImage = 3},
                onImagePreviousClick = {currentImage = 2}
            )

        }



    }
}

@Composable
fun Art(
    title: String,
    description: String,
    drawableResource : Int,
    onImageClick : () -> Unit,
    onImagePreviousClick : () -> Unit,
    modifier: Modifier = Modifier) {
    Box(modifier = Modifier
        .size(width = 250.dp, height = 250.dp)
        .background(Color.White)
        
    )
    {
        Image(
            painter = painterResource(drawableResource),
            contentDescription = "museum image",
            modifier = Modifier.size(width = 200.dp, height = 200.dp).align(Alignment.Center)



        )
    }

    Spacer(modifier = Modifier.height(30.dp))

    Column(
        modifier = Modifier
            .background(color= Color(0xabdefafa))
            .size(250.dp, 100.dp)
            .fillMaxSize()
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
    Spacer(Modifier.height(200.dp))

    Row(modifier = Modifier.size(250.dp))
    {
        Button(
            onClick = onImagePreviousClick,
            modifier = Modifier
                .padding(15.dp)
                .size(width = 105.dp, height = 40.dp)

        ) {
            Text("Previous")
        }
        Button(
            onClick = onImageClick,
            modifier = Modifier
                .padding(15.dp)
                .size(width = 105.dp, height = 40.dp)
        )
        {
            Text("Next")
        }
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtGalleryTheme {
        Home()
    }
}