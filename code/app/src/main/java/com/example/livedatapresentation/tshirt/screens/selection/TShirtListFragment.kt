package com.example.livedatapresentation.tshirt.screens.selection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.livedatapresentation.*
import com.example.livedatapresentation.tshirt.screens.TShirtSelectorViewModel
import kotlinx.android.synthetic.main.fragment_tshirt_list.view.*

class TShirtListFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_tshirt_list, container, false)
        // set view.list adapter
        val onClickListener = object :
            OnItemClickInRecyclerView {
            override fun onClicked(position: Int) {
                model.selectedIndex.postValue(position)
            }
        }
        model.allTShirts.observe(this, Observer {
            view.list.apply {
                adapter = TShirtAdapter(
                    model.allTShirts.value.orEmpty(),
                    onClickListener
                )
                layoutManager = GridLayoutManager(inflater.context, 5)
            }
        })
        return view
    }
}