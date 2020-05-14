package com.example.livedatapresentation.tshirt.screens.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.livedatapresentation.common.LoggedFragment
import com.example.livedatapresentation.R
import kotlinx.android.synthetic.main.fragment_tshirt_overview.view.*
import timber.log.Timber

class DetailWithSelectionFragment : LoggedFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_tshirt_overview, container, false)
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