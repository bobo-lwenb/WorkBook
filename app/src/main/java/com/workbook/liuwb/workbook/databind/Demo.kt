package com.workbook.liuwb.workbook.databind

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.workbook.liuwb.workbook.BR

class Demo(name: String, age: Int) : BaseObservable() {

    @get:Bindable
    var name: String = name
        set(name) {
            field = name
            notifyPropertyChanged(BR.name)
        }
    @get:Bindable
    var age: Int = age
        set(age) {
            field = age
            notifyPropertyChanged(BR.age)
        }
}
