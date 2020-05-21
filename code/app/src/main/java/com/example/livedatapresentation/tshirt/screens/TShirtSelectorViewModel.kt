package com.example.livedatapresentation.tshirt.screens

import android.app.Application
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.lifecycle.*
import com.example.livedatapresentation.tshirt.TShirt
import com.example.livedatapresentation.tshirt.repository.TshirtRepository
import timber.log.Timber

class TShirtSelectorViewModel(application: Application) : AndroidViewModel(application) {
    init {
        Timber.d("onCreate : ${this::class.java}")
    }

    val repo = TshirtRepository.instance
    val allTShirts = repo.allTshirts
    val selectedIndex = MutableLiveData<Int>().also { it.value = 0 }
    val selectedTShirt = Transformations.map(selectedIndex) {
        val allTshirtsValue = allTShirts.value
        if (allTshirtsValue.isNullOrEmpty()) {
            TShirt("#000", "L")
        } else {
            allTshirtsValue.get(it)
        }
    }

    val tshirtColor = Transformations.map(selectedTShirt){
        ColorStateList.valueOf(Color.parseColor(it.color))
    }

    override fun onCleared() {
        Timber.d("onCleared : ${this::class.java}")
        super.onCleared()
    }
}