package com.example.livedatapresentation.tshirt.screens.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.livedatapresentation.R
import com.example.livedatapresentation.databinding.FragmentDetailWithBindingBinding
import com.example.livedatapresentation.tshirt.screens.TShirtSelectorViewModel

class DetailFragmentWithDataBinding : Fragment() {
    private lateinit var viewModel: TShirtSelectorViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val modelTMP =
            activity?.let { ViewModelProvider(it).get(TShirtSelectorViewModel::class.java) }
        if (modelTMP != null) {
            viewModel = modelTMP
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil
            .inflate<FragmentDetailWithBindingBinding>(inflater,
                R.layout.fragment_detail_with_binding,
                container,
                false)
        binding.model = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }
}