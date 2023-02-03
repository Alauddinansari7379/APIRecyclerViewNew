package com.example.apirecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apirecyclerview.R
import com.example.apirecyclerview.model.TherapyResponse



class AdapterTherapies(
    val context: Context, private val list: TherapyResponse
) :
    RecyclerView.Adapter<AdapterTherapies.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(R.layout.single_row_therapy, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // holder.SrNo.text= "${position+1}"

        holder.name.text = list.data[position].name
        holder.status.text = list.data[position].status.toString()
        Glide.with(holder.profile).load(list.data[position].profile).into(holder.profile)

        }





    override fun getItemCount(): Int {
        return list.data.size

    }

    open class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tvName)

        val profile: ImageView = itemView.findViewById(R.id.imgProfile)
        val status: TextView = itemView.findViewById(R.id.tvStatus)


    }

}