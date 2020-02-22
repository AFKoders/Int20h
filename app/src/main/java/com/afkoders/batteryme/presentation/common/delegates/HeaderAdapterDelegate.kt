package com.afkoders.batteryme.presentation.common.delegates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.common.holders.HeaderViewHolder
import com.afkoders.batteryme.presentation.common.models.AdapterDelegateItem
import com.afkoders.batteryme.presentation.common.models.HeaderItem
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import javax.inject.Inject

class HeaderAdapterDelegate @Inject constructor() :
    AdapterDelegate<MutableList<@JvmSuppressWildcards AdapterDelegateItem>>() {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val context = parent.context
        val itemView = LayoutInflater.from(context)
            .inflate(R.layout.item_header, parent, false)
        return HeaderViewHolder(itemView)
    }

    override fun isForViewType(items: MutableList<AdapterDelegateItem>, position: Int): Boolean {
        val item = items[position]
        return item is HeaderItem
    }

    override fun onBindViewHolder(
        items: MutableList<AdapterDelegateItem>, position: Int,
        holder: RecyclerView.ViewHolder, payloads: MutableList<Any>
    ) {
        val dateStr = (items[position] as HeaderItem).title
        if (holder is HeaderViewHolder) {
            holder.bindTitle(dateStr)
        }
    }
}