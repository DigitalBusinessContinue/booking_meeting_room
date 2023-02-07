package com.example.myk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(val usersList:ArrayList<Save>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    class  MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val tvRoom:TextView = itemView.findViewById(R.id.tv1)
        val tvTime:TextView = itemView.findViewById(R.id.tv2)
        val dateTextView:TextView = itemView.findViewById(R.id.dateTextView)
        val tvHade:TextView = itemView.findViewById(R.id.tv6)
        val tvPerson:TextView = itemView.findViewById(R.id.tv7)
        val tvDepertment:TextView = itemView.findViewById(R.id.tv8)
        val tvItem:TextView = itemView.findViewById(R.id.tv9)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvRoom.text = usersList[position].aroom
        holder.dateTextView.text = usersList[position].date
        holder.tvHade.text = usersList[position].fhead
        holder.tvPerson.text = usersList[position].gperson
        holder.tvDepertment.text = usersList[position].hdepertment
        holder.tvItem.text = usersList[position].iitem
        holder.tvTime.text = usersList[position].itime

    }

    override fun getItemCount(): Int {
        return usersList.size
    }





//    private val bkList = ArrayList<Save>()


//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val itemView = LayoutInflater.from(parent.context).inflate(
//            R.layout.item_layout,
//            parent,false
//        )
//        return MyViewHolder(itemView)
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val currentitem = bkList[position]
//
//        holder.room.text = currentitem.aroom
//        holder.time.text = currentitem.bgrouptime
//        holder.dd.text = currentitem.cddd
//        holder.mm.text = currentitem.dmmm
//        holder.yy.text = currentitem.eyyy
//        holder.head.text = currentitem.fhead
//        holder.name.text = currentitem.gperson
//        holder.HR.text = currentitem.hdpm
//        holder.equi.text = currentitem.igroupitem
//    }
//
//    override fun getItemCount(): Int {
//        return bkList.size
//    }
//
//    fun updateSaveList(bkList: List<Save>){
//        this.bkList.clear()
//        this.bkList.addAll(bkList)
//
//
//    }
//
//    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//
//        //val no : TextView = itemView.findViewById(R.id.tvno)
//        val room : TextView = itemView.findViewById(R.id.tv1)
//        val time : TextView = itemView.findViewById(R.id.tv2)
//        val dd : TextView = itemView.findViewById(R.id.tv3)
//        val mm : TextView = itemView.findViewById(R.id.tv4)
//        val yy : TextView = itemView.findViewById(R.id.tv5)
//        val head : TextView = itemView.findViewById(R.id.tv6)
//        val name : TextView = itemView.findViewById(R.id.tv7)
//        val HR : TextView = itemView.findViewById(R.id.tv8)
//        val equi : TextView = itemView.findViewById(R.id.tv9)
//    }
}

