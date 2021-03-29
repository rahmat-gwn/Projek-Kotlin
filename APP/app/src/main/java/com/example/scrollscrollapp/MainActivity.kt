package com.example.scrollscrollapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scrollscrollapp.adapter.ProdukAdapter
import com.example.scrollscrollapp.data.DummyDataProduk
import com.example.scrollscrollapp.databinding.ActivityMainBinding
import com.example.scrollscrollapp.model.Produk
import splitties.activities.start

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showRecycleList()
    }

    private fun showRecycleList(){
        with(binding){
            val produkAdapter = ProdukAdapter(DummyDataProduk.getAll())
            rvProduk.setHasFixedSize(true)
            rvProduk.layoutManager = LinearLayoutManager(this@MainActivity)
            rvProduk.adapter = produkAdapter

            produkAdapter.setOnItemClickCallback(object : ProdukAdapter.OnItemClickCallback{
                override fun onItemClicked(data: Produk) {
                    showSelectedProduk(data)
                }
            })

        }
    }

    private fun showSelectedProduk(produk: Produk) {
        start<SecondActivity>(){
            putExtra(SecondActivity.EXTRA_PRODUK, produk)
        }
    }
}