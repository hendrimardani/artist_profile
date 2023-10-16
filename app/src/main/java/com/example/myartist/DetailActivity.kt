package com.example.myartist

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.myartist.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val artists = if (Build.VERSION.SDK_INT >= 35) {
            intent.getParcelableExtra("key_artist", Artists::class.java)
        } else
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("key_artist")

        val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
        val tvDetailDescription: TextView = findViewById(R.id.tv_detail_description)
        val tvDetailPhoto: ImageView = findViewById(R.id.tv_detail_photo)

        tvDetailName.text = artists?.name
        tvDetailDescription.text = artists?.desription
        tvDetailPhoto.setImageResource(artists!!.photo)
    }
}