package com.example.livedatapresentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_all_in_one.view.*
import timber.log.Timber

class AllInOne : LoggedFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_all_in_one, container, false)
        // change view of fragment
        // and/or pass model to view
        view.button_detail.setOnClickListener {
            Timber.d("click : DetailButton\n")
            view.findNavController().navigate(R.id.action_allInOne_to_detailFragment3)
        }
        view.button_overview.setOnClickListener {
            Timber.d("click : OverviewButton\n")
            view.findNavController().navigate(R.id.action_allInOne_to_overviewFragment2)
        }
        return view
    }
}