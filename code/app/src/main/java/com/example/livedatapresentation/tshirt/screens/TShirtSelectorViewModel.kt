package com.example.livedatapresentation.tshirt.screens

import android.app.Application
import androidx.lifecycle.*
import com.example.livedatapresentation.tshirt.TShirt
import timber.log.Timber

class TShirtSelectorViewModel(application: Application) : AndroidViewModel(application) {
    init {
        Timber.d("onCreate : ${this::class.java}")
    }

    // List of T-shirts
    // index of the selected T-shirt
    // the color of the selected T-shirt
    val allTShirts = listOf<TShirt>(
        TShirt("#aaaaaa", "L"),
        TShirt("#00aa00", "XL")
    )
    val selectedIndex = MutableLiveData<Int>().also { it.value = 0 }
    val selectedTShirt = Transformations.map(selectedIndex, { allTShirts.get(it) })

    override fun onCleared() {
        Timber.d("onCleared : ${this::class.java}")
        super.onCleared()
    }
}