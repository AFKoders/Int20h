package com.afkoders.hackathon.presentation.base

interface BasePresenter<in V : BaseView> {
    fun bindView(view: V)
    fun unbindView()
}