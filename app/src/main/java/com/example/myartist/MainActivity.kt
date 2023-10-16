package com.example.myartist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
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

        list.addAll(getListArtist())
        showRecyclerList()
    }

    private fun getListArtist(): ArrayList<Artists> {
        val name = resources.getStringArray(R.array.data_name)
        val description = resources.getStringArray(R.array.data_description)
        val photo = resources.obtainTypedArray(R.array.data_photo)
        val listArtists = ArrayList<Artists>()

        for (i in name.indices) {
            val artists = Artists(name[i], description[i], photo.getResourceId(i, -1))
            listArtists.add(artists)
        }
        return listArtists
    }

    private fun showRecyclerList() {
        rvArtist.layoutManager = LinearLayoutManager(this)
        val listArtistsAdapter = ListArtistsAdapter(list)
        rvArtist.adapter = listArtistsAdapter

        listArtistsAdapter.setOnItemClickCallback(object : ListArtistsAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Artists) {
                showSelectedAritsts(data)
            }
        })
    }
    private fun showSelectedAritsts(data: Artists) {
        Toast.makeText(this, "Kamu memilih " + data.name, Toast.LENGTH_SHORT).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action
        }
        return super.onOptionsItemSelected(item)
    }
}