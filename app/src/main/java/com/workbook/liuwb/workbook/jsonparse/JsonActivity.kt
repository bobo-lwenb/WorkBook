package com.workbook.liuwb.workbook.jsonparse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.fastjson.JSON
import com.workbook.liuwb.workbook.R
import java.util.ArrayList

class JsonActivity : AppCompatActivity() {

    private val jsonStr: String = """{"id":0,"name":"admin","users":[{"id":2,"name":"guest"},{"id":3,"name":"root"}]}"""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json)

        val grade: Grade = JSON.parseObject(jsonStr, Grade::class.java)

        println("grade: $grade")
    }
}

class Grade {

    var id: Long? = null
    var name: String? = null
    private var users: MutableList<Student> = ArrayList()

    fun getUsers(): List<Student> {
        return users
    }

    fun setUsers(users: MutableList<Student>) {
        this.users = users
    }

    fun addStudent(student: Student) {
        users.add(student)
    }

    override fun toString(): String {
        return "Grade{" +
                "id=" + id +
                ", name='" + name + '\''.toString() +
                ", users=" + users +
                '}'.toString()
    }
}

class Student {

    var id: Long? = null
    var name: String? = null

    override fun toString(): String {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\''.toString() +
                '}'.toString()
    }
}
