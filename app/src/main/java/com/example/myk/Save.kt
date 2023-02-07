package com.example.myk

data class Save(val aroom: String?=null,
                val date: String?=null,
                val fhead: String?=null,
                val gperson: String?=null,
                val hdepertment: String?=null,
                val iitem: String?=null,
                val itime: String?=null,
                var ismorning: Boolean? = false,
                var isafternoon: Boolean? = false)