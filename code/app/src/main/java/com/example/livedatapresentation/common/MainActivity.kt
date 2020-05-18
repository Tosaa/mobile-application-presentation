package com.example.livedatapresentation.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedatapresentation.R
import com.example.livedatapresentation.tshirt.TShirt
import com.example.livedatapresentation.tshirt.repository.TshirtRepository
import com.example.livedatapresentation.tshirt.screens.TShirtSelectorViewModel
import timber.log.Timber
import timber.log.Timber.DebugTree


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Timber.treeCount() == 0) {
            Timber.plant(DebugTree())
        }
        Timber.d("onCreate: ${this::class.java.simpleName}")
        val model = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory(application)
        ).get(TShirtSelectorViewModel::class.java)
        setContentView(R.layout.activity_main)
        TshirtRepository.instance.allTshirts.observe(
            this,
            Observer { Timber.d("MainActivity observes Repo: $it") })
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
