package com.example.myartist

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.AnticipateInterpolator
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.animation.doOnEnd
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myartist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvArtist: RecyclerView
    private var list = ArrayList<Artists>()
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvArtist = findViewById(R.id.rv_artist)
        rvArtist.setHasFixedSize(true)

        list.addAll(getListArtist())
        showRecyclerList()

        // Aktifkan Animasi
        animation()
    }

    @SuppressLint("Recycle")
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
    private fun showSelectedAritsts(artists: Artists) {
        Toast.makeText(this, "Kamu memilih " + artists.name, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> rvArtist.layoutManager = LinearLayoutManager(this)
            R.id.action_grid -> rvArtist.layoutManager = GridLayoutManager(this, 2)
//            R.id.action_about -> {
//
//            }
        }
        return super.onOptionsItemSelected(item)
    }

    @RequiresApi(Build.VERSION_CODES.S)
    private fun animation() {
        splashScreen.setOnExitAnimationListener { splashScreenView ->
            // Create your custom animation.
            val slideUp = ObjectAnimator.ofFloat(
                splashScreenView,
                View.TRANSLATION_Y,
                0f,
                -splashScreenView.height.toFloat()
            )
            slideUp.interpolator = AnticipateInterpolator()
            slideUp.duration = 1000L

            // Call SplashScreenView.remove at the end of your custom animation.
            slideUp.doOnEnd { splashScreenView.remove() }

            // Run your animation.
            slideUp.start()
        }
    }
}