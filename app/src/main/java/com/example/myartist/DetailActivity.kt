package com.example.myartist

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myartist.databinding.ActivityDetailBinding

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val dataArtists = if (Build.VERSION.SDK_INT >= 35) {
            intent.getParcelableExtra("key_artists", Artists::class.java)
        } else intent.getParcelableExtra("key_artists")

        binding.tvDetailName.text = dataArtists?.name
        binding.tvDetailDescription.text = dataArtists?.desription
        binding.tvDetailPhoto.setImageResource(dataArtists!!.photo)
    }
}