package com.example.livedatapresentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class TShirtSelectorViewModel(application: Application) : AndroidViewModel(application) {

    // List of T-shirts
    // index of the selected T-shirt
    // the color of the selected T-shirt
    val allTShirts = listOf<TShirt>(TShirt("#aaaaaa", "L"), TShirt("#00aa00", "XL"))
}