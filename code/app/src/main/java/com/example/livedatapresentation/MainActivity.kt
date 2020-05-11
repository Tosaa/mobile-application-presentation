package com.example.livedatapresentation

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import timber.log.Timber.DebugTree


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Timber.treeCount() == 0) {
            Timber.plant(DebugTree())
        }
        Timber.d("onCreate: ${this::class.java.simpleName}")
        val model =
            ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(
                TShirtSelectorViewModel::class.java
            )
        setContentView(R.layout.activity_main)
    }


    override fun onPause() {
        super.onPause()
        Timber.d("onPause: ${this::class.java.simpleName}")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("onResume: ${this::class.java.simpleName}")
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        Timber.d("onResumeFragments: ${this::class.java.simpleName}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("onDestroy: ${this::class.java.simpleName}")
    }
}
