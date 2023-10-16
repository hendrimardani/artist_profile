package com.example.myartist

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myartist.databinding.ItemLayoutArtistBinding

class ListArtistsAdapter(private val listArtists: ArrayList<Artists>): RecyclerView.Adapter
        <ListArtistsAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: Artists)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(val binding: ItemLayoutArtistBinding) : RecyclerView
        .ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListArtistsAdapter
            .ListViewHolder {
        val binding = ItemLayoutArtistBinding.inflate(LayoutInflater
            .from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listArtists[position]
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description
        holder.binding.tvItemPhoto.setImageResource(photo)

        // Mengirimkan data kedalam DetailActivity
        holder.itemView.setOnClickListener {
            val intentToDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentToDetail.putExtra("key_artists", listArtists[holder.adapterPosition])
            holder.itemView.context.startActivity(intentToDetail)
        }
    }

    override fun getItemCount() = listArtists.size
}