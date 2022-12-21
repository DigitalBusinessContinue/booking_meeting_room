package com.example.myk.`class`

class Admin {
        var id: String = ""
            get() = field
            set(value) {
                field = value
            }

        var adminid: String = ""
            get() = field
            set(value) {
                field = value
            }

        var adminname: String = ""
            get() = field
            set(value) {
                field = value
            }






        fun printInfo() {
            println("ID: $id")
            println("Trainer ID: $adminid")
            println("Trainer Company: $adminname")
        }
    }