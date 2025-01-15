package com.example.dessertclicker.data

import androidx.annotation.DrawableRes
import com.example.dessertclicker.data.Datasource.dessertList

data class DessertUiState(
var revenue: Int = 0,
var dessertsSold: Int = 0,
var currentDesertIndex: Int = 0,
val currentDessertPrice: Int = dessertList[currentDesertIndex].price,
@DrawableRes val currentDessertImageId: Int = dessertList[currentDesertIndex].imageId

)
