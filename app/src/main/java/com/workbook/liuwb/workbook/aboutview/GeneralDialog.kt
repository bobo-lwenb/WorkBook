package com.workbook.liuwb.workbook.aboutview

import android.content.Context
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.fragment.app.DialogFragment

typealias ClickListener = (dialog: GeneralDialog, view: View) -> Unit

class GeneralDialog(private val params: DialogParams) : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)

        return params.contentView
    }

    override fun onStart() {
        super.onStart()

//        val point = Point()
//        activity?.windowManager?.defaultDisplay?.getSize(point)
//
//        val attr = dialog?.window?.attributes
//
//        attr?.width = (point.x * 1).toInt()
//
//        dialog?.window?.attributes = attr

        dialog?.window?.setLayout(-1, -2)
    }

    class Builder(private val context: Context) {

        private val params: DialogParams = DialogParams(context)
        private lateinit var dialog: GeneralDialog

        fun setContentView(layoutId: Int): Builder {
            val view: View = LayoutInflater.from(context).inflate(layoutId, null)
            setContentView(view)
            return this
        }

        fun setContentView(view: View): Builder {
            params.contentView = view
            return this
        }

        fun setText(id: Int, textId: Int): Builder {
            setText(id, context.getString(textId))
            return this
        }

        fun setText(id: Int, text: String): Builder {
            val textView: TextView = getView(id)
            textView.text = text
            return this
        }

        fun setCLickListener(id: Int, clickListener: ClickListener): Builder {
            val view: View = getView(id)
            view.setOnClickListener { clickListener(dialog, it) }
            return this
        }

        fun build(): GeneralDialog {
            dialog = GeneralDialog(params)
            return dialog
        }

        fun <V : View> getView(id: Int): V {
            val view: View = params.contentView.findViewById(id)
            return view as V
        }
    }
}

class DialogParams(private val context: Context) {
    var contentView: View = View(context)

}