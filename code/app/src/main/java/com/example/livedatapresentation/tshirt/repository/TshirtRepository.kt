package com.example.livedatapresentation.tshirt.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.livedatapresentation.tshirt.TShirt
import timber.log.Timber


class TshirtRepository private constructor(){
    private val initialList = mutableListOf<TShirt>(
        TShirt("#aaaaaa", "L"),
        TShirt("#00aa00", "XL")
    )
    // MutableLiveData has setter and getter
    private val _allTshirts = MutableLiveData<List<TShirt>>().apply {
        value = initialList
    }

    // LiveData has getter only
    val allTshirts: LiveData<List<TShirt>> = _allTshirts

    fun addTshirt(tShirt: TShirt) {
        Timber.d("addTshirt is called")
        // when initialList is updated, the MutableLiveData wont be updated automatically
        // thats why you have to post the Value to the Mutable LiveData (it is similar to a setter)
        initialList.add(tShirt)
        _allTshirts.postValue(initialList)
        Timber.d("initalList: $initialList")
        Timber.d("${_allTshirts.hasObservers()}")
        Timber.d("${allTshirts.hasObservers()}")
    }

    private object HOLDER {
        val INSTANCE = TshirtRepository()
    }

    companion object {
        val instance: TshirtRepository by lazy { HOLDER.INSTANCE }
    }
}