package com.example.proyekakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvPreset: RecyclerView
    private var list: ArrayList<Preset> = arrayListOf()
    private var title: String = "Home"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi RecyclerView pada activity_main
        rvPreset = findViewById(R.id.rv_preset)
        // Jika True maka lebar dan tinggi di optimasi/konstan
        rvPreset.setHasFixedSize(true)

        // Inisialisasi data pada HeroesData
        list.addAll(PresetData.listData)
        showRecyclerCardView()

        // Panggil Tittle Untuk mengubah ActionBar
        setActionBar(title)
        
    }

    private fun showRecyclerCardView() {
        rvPreset.layoutManager = LinearLayoutManager(this)
        val cardViewPresetAdapter = CardViewPresetAdapter(list)
        rvPreset.adapter = cardViewPresetAdapter
    }

    private fun setActionBar(title: String) {


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.open_about, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.open_about -> {
                val intent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }
}