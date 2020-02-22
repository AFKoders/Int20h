package com.afkoders.batteryme.presentation.common.models


sealed class AdapterDelegateItem {
  open class Model<T>(val model: T? = null) : AdapterDelegateItem()
  open class Empty : AdapterDelegateItem()
  open class Header : AdapterDelegateItem()
}
