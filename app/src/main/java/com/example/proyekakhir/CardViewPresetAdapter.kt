package com.example.proyekakhir

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewPresetAdapter(private val listPreset: ArrayList<Preset>) : RecyclerView.Adapter<CardViewPresetAdapter.CardViewHolder>(){
    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var btnFavorite: Button = itemView.findViewById(R.id.btn_favorite)
        var btnShare: Button = itemView.findViewById(R.id.btn_share)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_preset, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val preset = listPreset[position]

        // Glide : Library untuk menampikan foto secara asynchronous dari url yang diberikan
        // Baik itu dari drawable maupun URL
        // with: digunakan untuk memasukkan context.
        Glide.with(holder.itemView.context)
            //load: digunakan untuk memasukkan sumber gambar, contohnya menggunakan url atau asset dari Drawable.
            .load(preset.photo)
            //apply: digunakan untuk melakukan memanipulasi gambar, contohnya menggunakan RequestOption untuk me-override ukuran gambar.
            .apply(RequestOptions().override(210, 250))
            //into: digunakan untuk memasukkan imageView sebagai obyek penampil gambar.
            .into(holder.imgPhoto)

        holder.tvName.text = preset.name
        holder.tvDetail.text = preset.detail

        holder.btnFavorite.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Favorite " + listPreset[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        }
        holder.btnShare.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Share " + listPreset[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        }
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Kamu memilih item " + listPreset[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
            var tvName : String = preset.name
            var tvDetail : String = preset.detail

            var imgPhoto: Int = preset.photo

            val moveWithDetailIntent = Intent(holder.itemView.context, DetailActivity::class.java)
            /*moveWithDetailIntent.putExtra("nama_preset", tvName)
            moveWithDetailIntent.putExtra("detail_preset", tvDetail)
            moveWithDetailIntent.putExtra("img_photo", imgPhoto)
            holder.itemView.context.startActivity(moveWithDetailIntent)*/
            moveWithDetailIntent.putExtra(DetailActivity.EXTRA_NAME, tvName)
            moveWithDetailIntent.putExtra(DetailActivity.EXTRA_DETAIL, tvDetail)
            moveWithDetailIntent.putExtra(DetailActivity.EXTRA_IMAGE, imgPhoto)
            holder.itemView.context.startActivity(moveWithDetailIntent)
        }
    }


    override fun getItemCount(): Int {
        return listPreset.size
    }
}