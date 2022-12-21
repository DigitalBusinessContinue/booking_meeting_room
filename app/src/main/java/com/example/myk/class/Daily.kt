package com.example.myk.`class`

class Daily
{
    var id: String = ""
        get() = field
        set(value) {
            field = value
        }

    var empname: String = ""
        get() = field
        set(value) {
            field = value
        }

    var dailydate: String = ""
        get() = field
        set(value) {
            field = value
        }

    var dailyreport: String = ""
        get() = field
        set(value) {
            field = value
        }

    var dailytitle: String = ""
        get() = field
        set(value) {
            field = value
        }



    fun printInfo() {
        println("ID: $id")
        println("Daily Date: $dailydate")
        println("Daily User: $empname")
        println("Daily Report: $dailyreport")
        println("Daily Title: $dailytitle")

    }
}