package com.example.livedatapresentation

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import timber.log.Timber

open class LoggedFragment() : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.d("onCreate : ${this::class.java}")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("onCreateView : ${this::class.java}")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        Timber.d("onAttach : ${this::class.java}")
        super.onAttach(context)
    }

    override fun onPause() {
        Timber.d("onPause : ${this::class.java}")
        super.onPause()
    }

    override fun onStart() {
        Timber.d("onStart: ${this::class.java}")
        super.onStart()
    }

    override fun onResume() {
        Timber.d("onResume : ${this::class.java}")
        super.onResume()
    }

    override fun onDestroyView() {
        Timber.d("onDestroyView : ${this::class.java}")
        super.onDestroyView()
    }

    override fun onStop() {
        Timber.d("onStop : ${this::class.java}")
        super.onStop()
    }

    override fun onDestroy() {
        Timber.d("onDestroy : ${this::class.java}")
        super.onDestroy()
    }

}