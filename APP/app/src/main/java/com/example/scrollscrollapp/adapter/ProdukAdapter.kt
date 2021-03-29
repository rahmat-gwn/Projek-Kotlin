package com.example.scrollscrollapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.scrollscrollapp.databinding.ItemProdukBinding
import com.example.scrollscrollapp.model.Produk

class ProdukAdapter(private val list: MutableList<Produk>):
    RecyclerView.Adapter<ProdukAdapter.ViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ViewHolder(private val binding: ItemProdukBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(produk: Produk) {
            with(binding){
                civProduk.load(produk.image)
                mtvTitle.text = produk.title
                mtvDesc.text = produk.miniDesc

                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(produk) }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Produk)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemProdukBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}