package com.example.superheroes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero
import com.example.superheroes.model.Hero.HeroesRepository.heroes
import com.example.superheroes.ui.theme.Shapes
import com.example.superheroes.ui.theme.SuperheroesTheme
import com.example.superheroes.ui.theme.Typography
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.sp

@Composable
fun SuperApp(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            SuperTopAppBar()
        }
    ){ it ->
        LazyColumn(
            contentPadding = it,
            state = rememberLazyListState(),
            modifier = modifier.padding(16.dp)
        ) {
            items(heroes) {
                it
                SuperHeroCard(
                    hero = it, modifier = Modifier
                        .padding(8.dp)
                )
            }
        }
    }

}


@Composable
fun SuperHeroIcon(@DrawableRes imageRes: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(72.dp)
            .clip(shape = Shapes.small)

    ) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = null,
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.FillWidth


        )
    }
}

@Composable
fun SuperHeroCard(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier,

    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 50.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                SuperHeroInfo(hero.nameRes, hero.descriptionRes)


            }
            Spacer(Modifier.width(16.dp))
            SuperHeroIcon(hero.imageRes)
        }
    }
}


@Composable
fun SuperHeroInfo(
    @StringRes name: Int,
    @StringRes description: Int,
    modifier: Modifier = Modifier
) {
        Text(text = stringResource(name), style = MaterialTheme.typography.displaySmall)
        Text(text = stringResource(description), style = MaterialTheme.typography.bodySmall)

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier

    )
}


@Composable
@Preview
fun SuperHeroIconPreview() {
    SuperHeroIcon(R.drawable.android_superhero1)
}

@Preview(showBackground = true)
@Composable
fun SuperAppPreview() {
    SuperheroesTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            SuperApp()
        }
    }
}

@Preview
@Composable
fun TopAppBarPreview() {
    SuperTopAppBar()
}

@Preview
@Composable
fun testPreview() {
    Row(
        modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
            .sizeIn(minHeight = 72.dp)
    ) {
        Column(modifier = Modifier.weight(1f)) {  }
    }
}



