package com.example.listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import com.example.listview.databinding.ActivityMainBinding

class Postcustomdetail : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_postcustomdetail)


        val title_name = intent.getStringExtra("title")
        val body_post = intent.getStringExtra("desc")
        val photo = intent.getIntExtra("imgid", R.drawable.avatar_post_1)
        val post = intent.getIntExtra("postid", R.drawable.post_image_1)


        val detailTitleTextView: TextView = findViewById(R.id.isi_lv_cs_title_detail)
        val detailDescriptionTextView: TextView = findViewById(R.id.isi_lv_cs_desc_detail)
        val lvCsImage: ImageView = findViewById(R.id.isi_lv_cs_image_detail)
        val lvCsPost: ImageView = findViewById(R.id.isi_gambar_lv_cs_detail)

        detailTitleTextView.text = title_name
        detailDescriptionTextView.text = body_post
        lvCsImage.setImageResource(photo)
        lvCsPost.setImageResource(post)


        val back_from_detail = findViewById<ImageView>(R.id.back_from_detail_post_custom)

        back_from_detail.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}