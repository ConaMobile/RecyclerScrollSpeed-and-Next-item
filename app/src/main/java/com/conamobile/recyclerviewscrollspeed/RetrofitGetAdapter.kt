package com.conamobile.recyclerviewscrollspeed

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class RetrofitGetAdapter(private val context: Context, private val lists: List<Model>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.scroll_item, parent, false)
        return MyViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val list = lists[position]
        PositionObject.position = position

        if (holder is MyViewHolder) {

            holder.apply {
                itemName.text = list.name
                itemImage.setImageResource(R.drawable.ic_launcher_background)

            }

        }
    }


    override fun getItemCount(): Int {
        return lists.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemImage: ShapeableImageView = view.findViewById(R.id.item_image)
        val itemName: AppCompatTextView = view.findViewById(R.id.itemName)
    }
}