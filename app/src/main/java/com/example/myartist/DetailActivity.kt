package com.example.myartist

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myartist.databinding.ActivityDetailBinding

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val artists = if (Build.VERSION.SDK_INT >= 35) {
            intent.getParcelableExtra("key_artits", Artists::class.java)
        } else intent.getParcelableExtra("key_artits")

        binding.tvDetailName.text = artists?.name
        binding.tvDetailDescription.text = artists?.name
        binding.tvDetailPhoto.setImageResource(artists!!.photo)
    }
}