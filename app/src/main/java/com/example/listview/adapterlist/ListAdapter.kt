package com.example.listview.adapterlist

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.listview.R

class ListAdapter (
    private val context: Activity,
    private val title: Array<String>,
    private val desc: Array<String>,
    private val imgid: Array<Int>

    ) : ArrayAdapter<String>(context, R.layout.custom_list_view, title) {

    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

    val inflater : LayoutInflater = LayoutInflater.from(context)
    val view : View = inflater.inflate(R.layout.custom_list_view,null)

        // Populate the row view with data
        val detailTitleTextView = view.findViewById<TextView>(R.id.detailTitleTextView)
        val detailDescriptionTextView = view.findViewById<TextView>(R.id.detailDescriptionTextView)
        val lvCsImage = view.findViewById<ImageView>(R.id.lv_cs_image)

        detailTitleTextView.text = title[position]
        detailDescriptionTextView.text = desc[position]
        lvCsImage.setImageResource(imgid[position])


        return view
    }

}