package com.example.myartist

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.example.myartist.databinding.ActivityDetailBinding
import java.sql.Array

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private var daftar = ArrayList<Artists>()
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_share, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Mengirim tombol share
        when (item.itemId) {
            R.id.share -> {
                val sendIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, binding.tvDetailName.text)
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}