package com.example.my30days.ui.theme.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.my30days.R

class Day(
    @StringRes val day: Int,
    @StringRes val title: Int,
    @DrawableRes val image: Int,
    @StringRes val description: Int
) {

    object DaysRespository {
        val days = listOf(
            Day(R.string.day, R.string.day1_title, R.drawable.dia, R.string.day1_desc),
            Day(R.string.day, R.string.day2_title, R.drawable.dia2, R.string.day2_desc),
            Day(R.string.day, R.string.day3_title, R.drawable.dia3, R.string.day3_desc),
            Day(R.string.day, R.string.day4_title, R.drawable.dia4, R.string.day4_desc),
            Day(R.string.day, R.string.day5_title, R.drawable.dia5, R.string.day5_desc),
            Day(R.string.day, R.string.day6_title, R.drawable.dia6, R.string.day6_desc),
            Day(R.string.day, R.string.day7_title, R.drawable.dia7, R.string.day7_desc),
            Day(R.string.day, R.string.day8_title, R.drawable.dia8, R.string.day8_desc),
            Day(R.string.day, R.string.day9_title, R.drawable.dia9, R.string.day9_desc),
            Day(R.string.day, R.string.day10_title, R.drawable.dia10, R.string.day10_desc),
            Day(R.string.day, R.string.day11_title, R.drawable.dia11, R.string.day11_desc),
            Day(R.string.day, R.string.day12_title, R.drawable.dia12, R.string.day12_desc),
            Day(R.string.day, R.string.day13_title, R.drawable.dia13, R.string.day13_desc),
            Day(R.string.day, R.string.day14_title, R.drawable.dia14, R.string.day14_desc),
            Day(R.string.day, R.string.day15_title, R.drawable.dia15, R.string.day15_desc),
            Day(R.string.day, R.string.day16_title, R.drawable.dia16, R.string.day16_desc),
            Day(R.string.day, R.string.day17_title, R.drawable.dia17, R.string.day17_desc),
            Day(R.string.day, R.string.day18_title, R.drawable.dia18, R.string.day18_desc),
            Day(R.string.day, R.string.day19_title, R.drawable.dia19, R.string.day19_desc),
            Day(R.string.day, R.string.day20_title, R.drawable.dia20, R.string.day20_desc),
            Day(R.string.day, R.string.day21_title, R.drawable.dia21, R.string.day21_desc),
            Day(R.string.day, R.string.day22_title, R.drawable.dia22, R.string.day22_desc),
            Day(R.string.day, R.string.day23_title, R.drawable.dia23, R.string.day23_desc),
            Day(R.string.day, R.string.day24_title, R.drawable.dia24, R.string.day24_desc),
            Day(R.string.day, R.string.day25_title, R.drawable.dia25, R.string.day25_desc),
            Day(R.string.day, R.string.day26_title, R.drawable.dia26, R.string.day26_desc),
            Day(R.string.day, R.string.day27_title, R.drawable.dia27, R.string.day27_desc),
            Day(R.string.day, R.string.day28_title, R.drawable.dia28, R.string.day28_desc),
            Day(R.string.day, R.string.day29_title, R.drawable.dia29, R.string.day29_desc),
            Day(R.string.day, R.string.day30_title, R.drawable.dia30, R.string.day30_desc)
        )
    }




}