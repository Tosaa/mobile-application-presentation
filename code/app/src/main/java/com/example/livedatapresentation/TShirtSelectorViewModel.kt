package com.example.livedatapresentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import timber.log.Timber

class TShirtSelectorViewModel(application: Application) : AndroidViewModel(application) {
    init {
        Timber.d("onCreate : ${this::class.java}")
    }
    // List of T-shirts
    // index of the selected T-shirt
    // the color of the selected T-shirt
    val allTShirts = listOf<TShirt>(TShirt("#aaaaaa", "L"), TShirt("#00aa00", "XL"))

    override fun onCleared() {
        Timber.d("onCleared : ${this::class.java}")
        super.onCleared()
    }
}