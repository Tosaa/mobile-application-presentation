package com.example.livedatapresentation

import android.content.res.ColorStateList
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_detail.view.*
import kotlinx.android.synthetic.main.tshirt_button.view.*
import timber.log.Timber
import java.lang.Exception

class DetailFragment : LoggedFragment() {
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
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        // this is a example how the Fragment observes the View Model to change the value in the xml file
        // not the best approach !
        // refactor this in liveCoding
        model.selectedTShirt.observe(
            activity!!,
            Observer {
                changeTShirtColor(view.t_shirt_image, it.color)
                view.size_value.text = it.size
                view.color_value.text = it.color
            })
        return view
    }

    // this shows how complicated it can be, to set a value of an xml file programaticly
    private fun changeTShirtColor(tshirtView: ImageView, tshirtNewColor: String) {
        try {
            val colorAsInt = android.graphics.Color.parseColor(tshirtNewColor)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                tshirtView.imageTintList = ColorStateList.valueOf(colorAsInt)
            } else {
                Log.w("TShirtAdapter", "The API Version is to low: ${Build.VERSION.SDK_INT}")
            }
        } catch (exception: Exception) {
            Log.w("TShirtAdapter", "could not assign Color of T-Shirt to button image")
        }
    }
}
