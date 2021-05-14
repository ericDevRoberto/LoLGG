package com.example.lolgg.utils

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.example.lolgg.R
import com.example.lolgg.databinding.DialogAlertDialogBinding

class DialogCore(
    private val baseContext: Context,
    @StringRes private val title: Int,
    @StringRes private val message: Int,
    @StringRes private val positiveBntTitle: Int? = null,
    private val onClickBntPositive: (() -> Unit)? = null,
    @StringRes private val negativeBntTitle: Int? = null,
    private val onClickNegative: (() -> Unit)? = null
) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {


        val binding: DialogAlertDialogBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.dialog_alert_dialog,
            null,
            false
        )

        val view = View.inflate(baseContext, R.layout.dialog_alert_dialog, null)

        binding.dialogTitle.setText(title)
        binding.dialogMessage.setText(message)
        negativeButton(binding.dialogButtonNegative)
        if(positiveBntTitle != null){
            positiveButton(binding.dialogButtonPositive)
        }

        val builder = AlertDialog.Builder(view.context)
        builder.setView(binding.root)

        val dialogBuilder = builder.create()
        dialogBuilder.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogBuilder.setCanceledOnTouchOutside(false)

        return dialogBuilder

    }

    private fun positiveButton(button: Button) {
        with(button) {
            visibility = View.VISIBLE
            positiveBntTitle?.let { setText(it) }
            setOnClickListener {
                onClickBntPositive?.invoke()
                dismissAllowingStateLoss()
            }
        }
    }

    private fun negativeButton(button: Button) {
        with(button) {
            visibility = View.VISIBLE
            negativeBntTitle?.let { setText(it) }
            setOnClickListener {
                onClickNegative?.invoke()
                dismissAllowingStateLoss()
            }
        }
    }
}