package com.workbook.liuwb.workbook.commondialog

import com.workbook.liuwb.workbook.commondialog.base.BasePresenter
import com.workbook.liuwb.workbook.commondialog.base.BaseView

class Contract {

    interface View:BaseView{

    }

    interface Presenter:BasePresenter {
        fun onLeftClick()
        fun onRightClick()
    }
}