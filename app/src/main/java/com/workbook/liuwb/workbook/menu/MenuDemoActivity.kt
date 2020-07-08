package com.workbook.liuwb.workbook.menu

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.workbook.liuwb.workbook.R
import kotlinx.android.synthetic.main.activity_menu_demo.*

class MenuDemoActivity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {
    private var actionMode: ActionMode? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_demo)

        val toolbar = menu_toolbar
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val change: TextView = menu_change
        change.setOnClickListener(this)

        val context: TextView = menu_context
        registerForContextMenu(context)

        val single: TextView = single_context
        single_context.setOnLongClickListener(this)
    }

    override fun onClick(v: View?) = when (v?.id) {
        R.id.menu_change -> {
            invalidateOptionsMenu()
        }
        else -> {
        }
    }

    override fun onLongClick(v: View?): Boolean = when (v?.id) {
        R.id.single_context -> {
            if (actionMode != null) {
                false
            } else {
                actionMode = startActionMode(callback)
                v.isSelected = true
                true
            }
        }
        else -> {
            false
        }
    }


    /**
     * 创建toolbar选项菜单
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_demo, menu)

        val searchItem = menu?.findItem(R.id.menu_main_search)
        val searchView = searchItem?.actionView as SearchView

        /**
         * actionView展开收起监听
         */
        val expandListener = object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                return true
            }

        }
        searchItem.setOnActionExpandListener(expandListener)
        return true
    }

    /**
     * 动态修改选项菜单
     *
     * 在 Android 2.3.x 及更低版本中，每当用户打开选项菜单时（按“菜单”按钮），系统均会调用 onPrepareOptionsMenu()。
     * 在 Android 3.0 及更高版本中，当菜单项显示在应用栏中时，选项菜单被视为始终处于打开状态。 发生事件时，如果您要执行菜单更新，则必须调用 invalidateOptionsMenu() 来请求系统调用 onPrepareOptionsMenu()。
     *
     * 然而有些手机不管版本是多少，每当打开选项菜单式都会调用 onPrepareOptionsMenu()。
     */
    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menu?.removeItem(R.id.menu_demo_other)
        menu?.add(0, R.id.menu_demo_other, 0, "other")
        return super.onPrepareOptionsMenu(menu)
    }

    /**
     * toolbar选项菜单点击
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item?.itemId) {
        R.id.menu_main_add -> {
            true
        }
        R.id.menu_main_setting -> {
            true
        }
        R.id.menu_main_about -> {
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    /**
     * 创建上下文浮动菜单
     */
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_demo_context, menu)
    }

    /**
     * 上下文浮动菜单点击事件
     */
    override fun onContextItemSelected(item: MenuItem): Boolean = when (item?.itemId) {
        R.id.context_about -> {
            true
        }
        R.id.context_setting -> {
            true
        }
        R.id.context_share -> {
            true
        }
        else -> {
            super.onContextItemSelected(item)
        }
    }

    /**
     * 为单个视图创建上下文操作模式回调
     */
    private val callback: ActionMode.Callback = object : ActionMode.Callback {
        override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
            return false
        }

        override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            mode?.menuInflater?.inflate(R.menu.menu_demo_context, menu)
            supportActionBar?.hide()
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            return false
        }

        override fun onDestroyActionMode(mode: ActionMode?) {
            actionMode = null
            supportActionBar?.show()
        }

    }

}