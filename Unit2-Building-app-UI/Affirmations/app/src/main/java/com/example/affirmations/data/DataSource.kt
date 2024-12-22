package com.example.affirmations.data

import com.example.affirmations.R
import com.example.affirmations.model.Affirmation
class DataSource {
    fun loadAffirmations () : List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.lugar, R.drawable.lugar),
            Affirmation(R.string.momentosmuseu, R.drawable.momentosmuseu),
            Affirmation(R.string.maosdadas, R.drawable.maosdadasbiblia),
            Affirmation(R.string.caminhada, R.drawable.caminhada),
            Affirmation(R.string.cooking, R.drawable.cooking),
            Affirmation(R.string.gaming, R.drawable.gaming),
            Affirmation(R.string.couplefight, R.drawable.couplefight),
            Affirmation(R.string.comfort, R.drawable.comfort),
            Affirmation(R.string.pensar, R.drawable.pensar),
            Affirmation(R.string.futurecouple, R.drawable.futurecouple),
            Affirmation(R.string.casalfilho, R.drawable.casalfilho)
        )
    }
}