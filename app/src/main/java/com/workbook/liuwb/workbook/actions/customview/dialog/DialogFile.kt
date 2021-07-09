package com.workbook.liuwb.workbook.actions.customview.dialog

import android.app.Activity
import android.graphics.Point
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.workbook.liuwb.workbook.R

typealias OnLeftClick = () -> Unit
typealias OnRightClick = () -> Unit

fun showDialog(
    activity: Activity,
    titleText: String,
    content: String,
    leftText: String,
    rightText: String,
    leftClick: OnLeftClick,
    rightClick: OnRightClick
) {

    val view = LayoutInflater.from(activity).inflate(R.layout.fragment_common_dialog, null, false)

    val dialog = AlertDialog.Builder(activity)
        .setView(view)
        .create()

    view.findViewById<TextView>(R.id.titleT).text = titleText
    view.findViewById<TextView>(R.id.contentT).text = content
    view.findViewById<TextView>(R.id.left).text = leftText
    view.findViewById<TextView>(R.id.right).text = rightText

    view.findViewById<TextView>(R.id.left).setOnClickListener {
        dialog.dismiss()
        leftClick()
    }

    view.findViewById<TextView>(R.id.right).setOnClickListener {
        dialog.dismiss()
        rightClick()
    }
    dialog.setCanceledOnTouchOutside(false)

    dialog.show()
    val point = Point()
    activity.windowManager.defaultDisplay.getSize(point)

    val attr = dialog.window?.attributes

    attr?.width = (point.x * 0.6).toInt()

    dialog.window?.attributes = attr
}