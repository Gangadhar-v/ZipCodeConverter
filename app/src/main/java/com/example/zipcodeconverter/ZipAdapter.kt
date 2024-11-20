package com.example.zipcodeconverter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.zipcodeconverter.model.Place

class ZipAdapter( val places:List<Place>) : Adapter<ZipAdapter.ZipViewHolder>() {

    inner class ZipViewHolder(item: View):ViewHolder(item){
        val placeNameTv = item.findViewById<TextView>(R.id.placeName)
        val stateTv = item.findViewById<TextView>(R.id.state)
        val longiDetailsTv = item.findViewById<TextView>(R.id.longiDetails)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZipViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ZipViewHolder(item)
    }

    override fun getItemCount(): Int {
        return places.size
    }

    override fun onBindViewHolder(holder: ZipViewHolder, position: Int) {

        val data = places[position]
        holder.placeNameTv.text = data.place_name
        holder.stateTv.text = data.state
        holder.longiDetailsTv.text = "logi:${data.longitude} lati:${data.latitude}"
    }
}