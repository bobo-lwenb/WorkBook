package com.workbook.liuwb.workbook.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.workbook.liuwb.workbook.R
import kotlinx.android.synthetic.main.fragment_lifecycle.*

class LifeCycleFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("fragment: ", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("fragment: ", "onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.e("fragment: ", "onCreateView")
        val view = inflater.inflate(R.layout.fragment_lifecycle, container, false)
        val btn = view.findViewById<Button>(R.id.lifecycle_btn)
        btn.setOnClickListener {
            val dialog = AlertDialog.Builder(activity!!)
                    .setTitle("1111")
                    .setMessage("22222")
                    .create()
                    .show()
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("fragment: ", "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.e("fragment: ", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("fragment: ", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("fragment: ", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("fragment: ", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("fragment: ", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("fragment: ", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("fragment: ", "onDetach")
    }

}