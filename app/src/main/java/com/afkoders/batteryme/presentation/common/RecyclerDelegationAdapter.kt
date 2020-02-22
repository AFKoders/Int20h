package com.afkoders.batteryme.presentation.common

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

abstract class RecyclerDelegationAdapter<T> : ListDelegationAdapter<MutableList<T>>() {
    init {
        if (items == null) {
            items = mutableListOf()
        }
    }

    fun clearAndAddAll(entities: List<T>) {
        setItems(entities.toMutableList())
        notifyDataSetChanged()
    }

    fun clearAndAdd(entity: T) {
        clear()
        add(entity)
    }

    fun addAll(entities: List<T>) {
        val startPosition = items.size - 1
        items.addAll(entities)
        notifyItemRangeChanged(startPosition, startPosition + entities.size)
    }

    fun addAll(position: Int, entities: List<T>) {
        items.addAll(position, entities)
        notifyItemRangeInserted(position, entities.size)
    }

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }

    fun add(entity: T) {
        items.add(entity)
        notifyItemInserted(items.size)
    }

    fun add(position: Int, entity: T) {
        items.add(position, entity)
        notifyItemInserted(position)
    }

    fun remove(position: Int) {
        if (!items.isNullOrEmpty() && (position >= 0) && (position < items.size)) {
            items.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun remove(entity: T) {
        if (!items.isNullOrEmpty()) {
            items.remove(entity)
        }
    }

    fun update(position: Int, entity: T) {
        if (!items.isNullOrEmpty() && (position >= 0) && (position < items.size))
            items[position] = entity
        notifyItemChanged(position)
    }

    fun getItem(position: Int): T {
        return items[position]
    }
}