package com.example.livedatapresentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import timber.log.Timber
import timber.log.Timber.DebugTree


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.plant(DebugTree())
        Timber.d("onCreate: ${this::class.java}")
        val model = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory(application)).get(TShirtSelectorViewModel::class.java)
        setContentView(R.layout.activity_main)
    }

    override fun onPause() {
        super.onPause()
        Timber.d("onPause: ${this::class.java}")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("onResume: ${this::class.java}")
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        Timber.d("onResumeFragments: ${this::class.java}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("onDestroy: ${this::class.java}")
    }
}
