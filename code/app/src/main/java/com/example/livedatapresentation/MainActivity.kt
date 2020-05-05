package com.example.livedatapresentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory(application)).get(TShirtSelectorViewModel::class.java)
        setContentView(R.layout.activity_main)
    }
}
