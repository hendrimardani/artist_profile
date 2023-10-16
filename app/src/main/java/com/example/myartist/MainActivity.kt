package com.example.myartist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.myartist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvArtist: RecyclerView
    private var list = ArrayList<Artists>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvArtist = findViewById(R.id.rv_artist)
        rvArtist.setHasFixedSize(true)
    }

    private fun getListArtist(): ArrayList<Artists> {

    }
}