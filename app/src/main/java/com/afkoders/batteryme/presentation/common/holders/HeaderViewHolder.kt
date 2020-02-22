package com.afkoders.batteryme.presentation.common.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_header.view.*

class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvTitle = itemView.tvHeader

    fun bindTitle(title: String) {
        tvTitle.text = title
    }
}