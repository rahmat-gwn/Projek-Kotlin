package com.example.scrollscrollapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.scrollscrollapp.databinding.ActivitySecondBinding
import com.example.scrollscrollapp.model.Produk

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    companion object{
        const val EXTRA_PRODUK = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val produk = intent.getParcelableExtra<Produk>(EXTRA_PRODUK)

        binding.civProduk2.load(produk?.image)
        binding.mtvTitle2.text = produk?.title
        binding.mtvDesc2.text = produk?.desc

    }
}