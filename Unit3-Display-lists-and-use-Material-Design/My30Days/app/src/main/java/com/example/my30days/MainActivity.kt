package com.example.my30days

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.my30days.ui.theme.model.Day
import com.example.my30days.ui.theme.model.Day.DaysRespository.days
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            My30DaysTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    DayApp()
                }

            }
        }
    }
}


@Composable
fun DayApp() {
Scaffold(
    modifier = Modifier.fillMaxSize(),
    topBar = {TopAppBar()}
) { it ->
    LazyColumn(
        contentPadding = it,
        state = rememberLazyListState(),
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)) {
       items(days) { it
           DayItem(day = it)
       }
    }


}





}

@Composable
fun DayItem(day: Day, modifier: Modifier = Modifier) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    )
    {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            DayTitle(day.day, day.dayNumber, day.title)
            DayImage(day.image)
            Spacer(Modifier.height(20.dp))
            DayDescription(day.description,Modifier.width(300.dp))

        }

    }
    Spacer(Modifier.height(20.dp))

}

@Composable
fun DayTitle(day: Int, dayNumber: Int, title: Int) {
    Text(
        "${stringResource(day)} ${dayNumber}",
        style = MaterialTheme.typography.displaySmall,
        fontWeight = FontWeight.Bold,

    )
    Text(
        stringResource(title),
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.primary
    )
}


@Composable
fun DayDescription(desc: Int, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = stringResource(desc),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.bodyMedium
    )
}

@Composable
fun DayImage(img: Int) {
    Box(
        modifier = Modifier.clip(RoundedCornerShape(16.dp))

    ) {
        Image(
            painter = painterResource(img),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(200.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                stringResource(R.string.dayof),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold
            )
        }

    )
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    My30DaysTheme {
        DayApp()
    }
}