package com.example.project10k.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project10k.R
import com.example.project10k.activity.MainActivity
import com.example.project10k.model.Member
import kotlinx.android.synthetic.main.item_custom_layout.view.*

// this is simple recycler view adapter
// recycler view with setOnItemClickListener
data class CustomAdapter(
    private val context: Context,
    private val members: ArrayList<Member>,
    private val mainActivity: MainActivity
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CustomViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_custom_layout, parent, false)
        )
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members[position]

        // set data to item
        if (holder is CustomViewHolder) {
            holder.textView.text = member.name

            // setOnItemClickListener
            holder.layoutForClick.setOnClickListener {
                mainActivity.openDetails(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }

    private data class CustomViewHolder(
        val itemView: View,
        val textView: TextView = itemView.text_view_title,
        val layoutForClick: LinearLayout = itemView.layout_for_click
    ) : RecyclerView.ViewHolder(itemView)
}
