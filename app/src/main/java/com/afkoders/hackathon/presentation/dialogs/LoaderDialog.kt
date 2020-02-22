package com.afkoders.hackathon.presentation.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.afkoders.hackathon.R
import com.afkoders.hackathon.presentation.dialogs.builders.LoaderDialogBuilder
import com.afkoders.hackathon.utils.extensions.inflateWithoutAttach


class LoaderDialog : BaseDialog() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, state: Bundle?) =
        inflater.inflateWithoutAttach(container, R.layout.dialog_loader)

    override fun bind() {
        // Not implemented
    }

    companion object {
        fun createDialog(block: LoaderDialogBuilder.() -> Unit) =
            LoaderDialog().importSettings(LoaderDialogBuilder().apply(block))
    }
}