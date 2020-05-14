package com.example.livedatapresentation.common

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
        Timber.d("onCreate : $this")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Timber.d("onCreateView : $this")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        //Timber.d("onAttach : $this")
        super.onAttach(context)
    }

    override fun onPause() {
        //Timber.d("onPause : $this")
        super.onPause()
    }

    override fun onStart() {
        Timber.d("onStart: $this")
        super.onStart()
    }

    override fun onResume() {
        //Timber.d("onResume : $this")
        super.onResume()
    }

    override fun onDestroyView() {
        //Timber.d("onDestroyView : $this")
        super.onDestroyView()
    }

    override fun onStop() {
        Timber.d("onStop : $this")
        super.onStop()
    }

    override fun onDestroy() {
        //Timber.d("onDestroy : $this")
        super.onDestroy()
    }

}