package com.example.proyekakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.ActionBar
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        val EXTRA_NAME = "extra_name"
        val EXTRA_DETAIL = "extra_detail"
        val EXTRA_IMAGE  = "extra_image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvName: TextView = findViewById(R.id.tv_item_name)
        val tvDetail: TextView = findViewById(R.id.tv_item_detail)
        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
        val btnFavorite: Button = findViewById(R.id.btn_favorite)
        val btnShare: Button = findViewById(R.id.btn_share)
        val btnBeli: Button = findViewById(R.id.btn_beli)

        btnFavorite.setOnClickListener(this)
        btnShare.setOnClickListener(this)
        btnBeli.setOnClickListener(this)

        /*val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

        tvName = intent.getStringExtra("nama_preset")*/


        val name = intent.getStringExtra(EXTRA_NAME)
        val detail = intent.getStringExtra(EXTRA_DETAIL)
        val image = intent.getIntExtra(EXTRA_IMAGE, 0)

        Glide.with(this)
            .load(image)
            .apply(RequestOptions().override(190, 280))
            .into(imgPhoto)
        tvName.text = name.toString()
        tvDetail.text = detail.toString()

    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btn_favorite -> {
                Toast.makeText(this, "Kamu memilih Favorite", Toast.LENGTH_SHORT).show()
            }
            R.id.btn_share -> {
                Toast.makeText(this, "Kamu Memilih Share", Toast.LENGTH_SHORT).show()
            }
            R.id.btn_beli -> {
                val intent = Intent(this, PembayaranActivity::class.java)
                startActivity(intent)
            }
        }
    }


}