package com.example.myartist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
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
        val name = resources.getStringArray(R.array.data_name)
        val description = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listArtists = ArrayList<Artists>()

        for (i in name.indices) {
            val artists = Artists(name[i], description[i], dataPhoto.getResourceId(i, -1))
            listArtists.add(artists)
        }
        return listArtists
    }

    private fun showRecyclerList() {
        rvArtist.layoutManager = LinearLayoutManager(this)
        val listArtistsAdapter = ListArtistsAdapter(list)
    }
}