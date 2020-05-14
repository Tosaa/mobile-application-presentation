package com.example.livedatapresentation

import android.content.res.ColorStateList
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_detail.view.*
import kotlinx.android.synthetic.main.tshirt_button.view.*
import timber.log.Timber
import java.lang.Exception

class TShirtAdapter(
    private val tshirts: List<TShirt>,
    private val listener: OnItemClickInRecyclerView
) :
    RecyclerView.Adapter<TShirtAdapter.TShirtViewHolder>() {

    class TShirtViewHolder(tshirtView: View) : RecyclerView.ViewHolder(tshirtView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TShirtViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.tshirt_button, parent, false)
        return TShirtViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tshirts.size
    }

    override fun onBindViewHolder(holder: TShirtViewHolder, position: Int) {
        holder.itemView.tshirt_button.setOnClickListener {
            listener.onClicked(position)
        }

        try {
            val colorByTshirt = tshirts.get(position).color
            val colorAsInt = android.graphics.Color.parseColor(colorByTshirt)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                holder.itemView.tshirt_button.imageTintList = ColorStateList.valueOf(colorAsInt)
            } else {
                Log.w("TShirtAdapter", "The API Version is to low: ${Build.VERSION.SDK_INT}")
            }
        } catch (exception: Exception) {
            Log.w("TShirtAdapter", "could not assign Color of T-Shirt to button image")
        }
    }
}

// Recycler view does not provide OnItemClick, so i created a little workaround
interface OnItemClickInRecyclerView {
    fun onClicked(position: Int)
}