package com.example.myk.Adapter

import android.content.Context
import android.hardware.camera2.TotalCaptureResult
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.myk.Fragments.After
import com.example.myk.Fragments.Tomorrow
import com.example.myk.Fragments.today

internal class MyAdapter(var context: Context, fm: FragmentManager, var totalTabs: Int): FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
       return when(position){
           0 -> {
               today()
           }

           1 -> {
               Tomorrow()
           }
           2 -> {
               After()
           }
           else -> getItem(position)
       }
    }

    override fun getCount(): Int {
       return totalTabs
    }


}