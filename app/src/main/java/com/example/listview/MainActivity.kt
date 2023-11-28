package com.example.listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ListView
import android.widget.Toast
import com.example.listview.adapterlist.ListAdapter
import com.example.listview.adapterlist.ListReguler
import com.example.listview.databinding.ActivityMainBinding
import com.example.listview.datalistview.Userpost

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var postArrayList: ArrayList<Userpost>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //custom list view content
        val nama_post = arrayOf<String>(
            "Goal",
            "SPORTbible",
            "BBC Sport",
            "Fox Soccer"
        )

        val desc_post = arrayOf<String>(
            "Bernardo Silva recently opened up about offers he'd received from the Saudi Pro League",
            "Sir Alex had five transfer targets that season, and he managed to sign three of them ",
            "He's the first Englishman to score 18 times in a Bundesliga season!",
            "The 2023 Major League Soccer (MLS) Cup Playoffs are back starting tomorrow"
        )

        val avatar_post = arrayOf<Int>(
            R.drawable.avatar_post_1,
            R.drawable.avatar_post_2,
            R.drawable.avatar_post_3,
            R.drawable.avatar_post_4
        )

        val image_post = arrayOf<Int>(
            R.drawable.post_image_1,
            R.drawable.post_image_2,
            R.drawable.post_image_3,
            R.drawable.post_image_4
        )

        postArrayList = ArrayList()

        // definisi list view
        val _list = findViewById<ListView>(R.id.custom_list_view)
        _list.adapter = ListAdapter(this, nama_post, desc_post, avatar_post)

        binding.customListView.isClickable = true
        binding.customListView.adapter = ListAdapter(this, nama_post, desc_post, avatar_post)
        binding.customListView.setOnItemClickListener { adapterView, view, position, id ->

            val title = nama_post[position]
            val desc = desc_post[position]
            val imgid = avatar_post[position]
            val postid = image_post[position]

            val i = Intent(this, Postcustomdetail::class.java)
            i.putExtra("title", title)
            i.putExtra("desc", desc)
            i.putExtra("imgid", imgid)
            i.putExtra("postid", postid)

            startActivity(i)

            val itemAtPos = adapterView.getItemAtPosition(position)
            Toast.makeText(this, "View $itemAtPos Post", Toast.LENGTH_LONG).show()


        }

        val _reglist = findViewById<ListView>(R.id.regular_list_view)
        _reglist.adapter = ListReguler(this, nama_post, desc_post)

        binding.regularListView.isClickable = true
        binding.regularListView.adapter = ListReguler(this, nama_post, desc_post)
        binding.regularListView.setOnItemClickListener { adapterView, view, position, id ->

            val title = nama_post[position]
            val desc = desc_post[position]
            val imgid = avatar_post[position]
            val postid = image_post[position]

            val i = Intent(this, Postcustomdetail::class.java)
            i.putExtra("title", title)
            i.putExtra("desc", desc)
            i.putExtra("imgid", imgid)
            i.putExtra("postid", postid)

            startActivity(i)

            val itemAtPos = adapterView.getItemAtPosition(position)
            Toast.makeText(this, "View $itemAtPos Post", Toast.LENGTH_LONG).show()

        }
    }
}