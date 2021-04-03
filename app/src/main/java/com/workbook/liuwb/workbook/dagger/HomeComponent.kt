package com.workbook.liuwb.workbook.dagger

import dagger.Component

@Component
interface HomeComponent {
    fun inject(Activity: DaggerActivity1)
}