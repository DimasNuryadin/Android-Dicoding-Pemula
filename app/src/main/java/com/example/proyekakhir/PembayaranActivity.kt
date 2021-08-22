package com.example.proyekakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout

class PembayaranActivity : AppCompatActivity(), View.OnClickListener {

    private var title: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pembayaran)

        val kembali: LinearLayout = findViewById(R.id.kembali)
        kembali.setOnClickListener(this)

        setActionBar(title)

    }
    private fun setActionBar(title: String) {
        supportActionBar?.title = title
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.kembali ->{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}