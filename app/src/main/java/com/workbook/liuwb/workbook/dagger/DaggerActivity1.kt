package com.workbook.liuwb.workbook.dagger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

class DaggerActivity1 : AppCompatActivity() {

    @Inject lateinit var people: People

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerHomeComponent.builder().build().inject(this)

        people.hello()
    }

}