package com.afkoders.batteryme.presentation.dialogs

import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.dialogs.builders.DialogBuilder
import com.afkoders.batteryme.utils.extensions.disposeBy
import com.afkoders.batteryme.utils.extensions.setWidthRelativeToParent
import com.afkoders.batteryme.utils.extensions.throttleFirst
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.disposables.CompositeDisposable


abstract class BaseDialog : DialogFragment(), DialogInterface.OnKeyListener {
    protected var bag = CompositeDisposable()
    private var isCancelableOnTouchOutside: Boolean = true
    private var shouldClearDim: Boolean = false
    private var widthPercentage: Int = 90

    abstract fun bind()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, R.style.FullScreenDialogStyle)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            window?.requestFeature(Window.FEATURE_NO_TITLE)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            if (shouldClearDim) window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)

            setCanceledOnTouchOutside(isCancelableOnTouchOutside)
            setOnKeyListener(this@BaseDialog)

            setWidthRelativeToParent(activity, widthPercentage)
        }
    }

    override fun onResume() {
        super.onResume()
        bind()
    }

    override fun onPause() {
        super.onPause()
        bag.clear()
    }

    override fun onKey(dialog: DialogInterface?, keyCode: Int, event: KeyEvent?): Boolean {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            return !isCancelableOnTouchOutside
        }

        return false
    }

    protected open fun importSettings(builder: DialogBuilder) = this.apply {
        arguments = builder.args
        widthPercentage = builder.widthPercentage
        isCancelableOnTouchOutside = builder.isCancelableOnTouchOutside
        shouldClearDim = builder.shouldClearDim
    }

    protected fun View.click(action: () -> Unit) {
        RxView.clicks(this)
            .throttleFirst()
            .subscribe {
                action.invoke()
                dismiss()
            }.disposeBy(bag)
    }
}