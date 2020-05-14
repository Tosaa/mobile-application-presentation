package com.example.livedatapresentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_overview.view.*
import timber.log.Timber

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
        val onClickListener = object : OnItemClickInRecyclerView {
            override fun onClicked(position: Int) {
                model.selectedIndex.postValue(position)
            }

        }

        view.list.apply {
            adapter = TShirtAdapter(model.allTShirts, onClickListener)
            layoutManager = GridLayoutManager(inflater.context, 5)
        }
        // set view.list on item clicked
        return view
    }
}


