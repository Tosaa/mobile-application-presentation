package com.example.livedatapresentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

class DetailFragment : LoggedFragment() {
    private lateinit var model : TShirtSelectorViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val modelTMP = activity?.let { ViewModelProvider(it).get(TShirtSelectorViewModel::class.java) }
        if (modelTMP != null){
            model = modelTMP
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_detail, container, false)
        // change view of fragment
        // and/or pass model to view
        return view
    }
}
