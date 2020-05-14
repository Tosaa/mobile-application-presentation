package com.example.livedatapresentation.tshirt.screens

import android.app.Application
import androidx.lifecycle.*
import com.example.livedatapresentation.tshirt.TShirt
import com.example.livedatapresentation.tshirt.repository.TshirtRepository
import timber.log.Timber

class TShirtSelectorViewModel(application: Application) : AndroidViewModel(application) {
    init {
        Timber.d("onCreate : ${this::class.java}")
    }

    // List of T-shirts
    // index of the selected T-shirt
    // the color of the selected T-shirt
    val repo = TshirtRepository
    val allTShirts = repo.allTshirts
    val selectedIndex = MutableLiveData<Int>().also { it.value = 0 }
    val selectedTShirt = Transformations.map(selectedIndex, {
        // Using allTshirts.value in if and in return value, will show you a notification,
        // that the reference to the object could have changed in the time between if and return
        val allTshirtsValue =allTShirts.value
        // the allTshirts.value could be Null.
        // The compiler does not know if you have set any value by default,
        // but to be sure, you allways should check about Null
        if (allTshirtsValue.isNullOrEmpty()) {
            // export any Default value
            TShirt("#000","L")
        } else {
            allTshirtsValue.get(it)
        }
    })

    override fun onCleared() {
        Timber.d("onCleared : ${this::class.java}")
        super.onCleared()
    }
}