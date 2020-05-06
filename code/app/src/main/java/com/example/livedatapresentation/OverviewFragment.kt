package com.example.livedatapresentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_overview.view.*

class OverviewFragment : LoggedFragment() {
    private lateinit var model: TShirtSelectorViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val modelTMP =
            activity?.let { ViewModelProvider(it).get(TShirtSelectorViewModel::class.java) }
        if (modelTMP != null) {
            model = modelTMP
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_overview, container, false)
        // set view.list adapter
        view.list.apply {
            adapter = TShirtAdapter(model.allTShirts)
            layoutManager = GridLayoutManager(inflater.context, 5)
        }
        // set view.list on item clicked

        return view
    }
}


