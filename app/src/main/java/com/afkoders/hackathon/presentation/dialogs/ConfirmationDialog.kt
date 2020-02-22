package com.afkoders.hackathon.presentation.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.afkoders.hackathon.R
import com.afkoders.hackathon.presentation.dialogs.builders.ConfirmationDialogBuilder
import com.afkoders.hackathon.presentation.dialogs.builders.DialogBuilder
import com.afkoders.hackathon.utils.extensions.inflateWithoutAttach
import kotlinx.android.synthetic.main.dialog_confirmation.*


class ConfirmationDialog : BaseDialog() {
    private var title: String = ""
    private var message: String = ""
    private var actionPositiveText: String = ""
    private var actionNegativeText: String = ""

    private var listener: Listener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, state: Bundle?) =
        inflater.inflateWithoutAttach(container, R.layout.dialog_confirmation)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvConfirmationTitle.text = title
        tvConfirmationMessage.text = message

        ctaPositive.text = actionPositiveText
        ctaNegative.text = actionNegativeText
    }

    override fun bind() {
        ctaPositive.click {
            listener?.onActionPositive()
        }

        ctaNegative.click {
            listener?.onActionNegative()
        }
    }

    override fun importSettings(builder: DialogBuilder): BaseDialog {
        return super.importSettings(builder).also {
            (builder as? ConfirmationDialogBuilder)?.let { new ->
                listener = new.listener

                title = new.title
                message = new.message

                actionPositiveText = new.actionPositiveText
                actionNegativeText = new.actionNegativeText
            }
        }
    }

    companion object {
        fun createDialog(block: ConfirmationDialogBuilder.() -> Unit) =
            ConfirmationDialog().importSettings(ConfirmationDialogBuilder().apply(block))
    }

    interface Listener {
        fun onActionPositive()
        fun onActionNegative()
    }
}