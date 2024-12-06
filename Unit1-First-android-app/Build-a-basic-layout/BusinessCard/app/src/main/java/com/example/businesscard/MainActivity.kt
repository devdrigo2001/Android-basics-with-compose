package com.example.businesscard

import android.graphics.ColorSpace.Rgb
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    BusinessCard()
                }
            }
        }
    }
}
@Composable
fun BusinessCard(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color(154, 185, 158))//laurel green
            .fillMaxSize()

    ) {
        LogoSection()
        ContactSection()
    }
}

@Composable
fun LogoSection(){
    val image = painterResource(R.drawable.android_logo)
    Column(
        modifier = Modifier
            .height(400.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Box(
            Modifier
                .background(Color(0,83,101))
        ){
            Image(
                modifier = Modifier.size(width = 300.dp, height = 200.dp),
                painter = image,
                contentDescription = "android imagem")
        }
        Text(
            modifier = Modifier.padding(2.dp),
            textAlign = TextAlign.Center,
            text = stringResource(R.string.nome),
            fontSize = 26.sp,
            fontWeight = FontWeight.W400,
            color = colorResource(R.color.black)

        )
        Text(

            textAlign = TextAlign.Center,
            text = stringResource(R.string.profissao),
            fontWeight = FontWeight.W500,
            color = colorResource(R.color.white)
        )
    }
}

@Composable
fun ContactSection(){
    Column {
        Row(verticalAlignment = Alignment.CenterVertically){
              Icon(
                  Icons.Rounded.Email,
                  contentDescription = "email icon",
                  Modifier.padding(1.dp)
              )
            Text(
                text = stringResource(R.string.email),
                color = colorResource(R.color.black)
            )

        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painterResource(R.drawable.instagram),
                contentDescription = "account icon",
                Modifier
                    .padding(1.dp)
                    .size(width = 25.dp, height = 20.dp)
            )
            Text(
                text = stringResource(R.string.instagram),
                color = colorResource(R.color.black)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}