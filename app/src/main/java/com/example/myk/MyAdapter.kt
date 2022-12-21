package com.example.myk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val newList: ArrayList<News>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView =LayoutInflater.from(parent.context).inflate(R.layout.list_room,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currenItem = newList[position]
        holder.titleImage.setImageResource(currenItem.titleImage)
        holder.tvHeading.text=currenItem.heading
    }

    override fun getItemCount(): Int {
        return newList.size
    }
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val titleImage: ShapeableImageView=itemView.findViewById(R.id.title_image)
        val tvHeading : TextView=itemView.findViewById(R.id.tvHeading)
    }

}