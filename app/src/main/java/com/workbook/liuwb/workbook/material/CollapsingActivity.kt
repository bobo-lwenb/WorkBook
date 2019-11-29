package com.workbook.liuwb.workbook.material

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.workbook.liuwb.workbook.R
import kotlinx.android.synthetic.main.activity_collapsing.*

class CollapsingActivity : AppCompatActivity() {

    val mTitle = listOf("index", "home")
    val mDatas = listOf(
            "assorted1", "assorted2", "assorted3", "assorted4", "assorted5",
            "assorted", "assorted", "assorted", "assorted", "assorted", "assorted",
            "assorted", "assorted", "assorted", "assorted", "assorted", "assorted",
            "assorted", "assorted", "assorted", "assorted", "assorted", "assorted",
            "assorted", "assorted", "assorted", "assorted", "assorted", "assorted",
            "assorted", "assorted", "assorted", "assorted"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing)

        val toolbar = toolbar
        val tabLayout = tablayout
        val viewPager = viewpager

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

        viewPager.adapter = MyAdapter()
        tabLayout.setupWithViewPager(viewPager)
    }

    inner class MyAdapter : PagerAdapter() {

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val recyclerView = RecyclerView(this@CollapsingActivity)
            recyclerView.layoutParams =
                    ViewGroup.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            val manager = LinearLayoutManager(this@CollapsingActivity)
            manager.orientation = RecyclerView.VERTICAL
            recyclerView.layoutManager = manager
            val itemDecoration = DividerItemDecoration(this@CollapsingActivity, DividerItemDecoration.VERTICAL)
            recyclerView.addItemDecoration(itemDecoration)
            recyclerView.adapter = RecyclerAdapter()
            container.addView(recyclerView)
            return recyclerView
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mTitle[position]
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view == `object`
        }

        override fun getCount(): Int {
            return mTitle.size
        }
    }

    inner class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerHolder {
            val textView = TextView(this@CollapsingActivity)
            val layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(0, 60, 0, 60)
            textView.layoutParams = layoutParams
            textView.textSize = 20f
            textView.top
            textView.gravity = Gravity.CENTER
            return RecyclerHolder(textView)
        }

        override fun getItemCount(): Int = mDatas.size

        override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
            holder.textView.text = mDatas[position]
        }

        inner class RecyclerHolder(view: View) : RecyclerView.ViewHolder(view) {
            val textView = view as TextView
        }
    }
}