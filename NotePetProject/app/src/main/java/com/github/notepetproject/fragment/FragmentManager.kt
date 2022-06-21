package com.github.notepetproject.fragment

import androidx.appcompat.app.AppCompatActivity
import com.github.notepetproject.R

class FragmentManager {

    var baseFragment: BaseFragment? = null

    fun setFragment(activity: AppCompatActivity, newFrag: BaseFragment){
        activity.supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout_fragment, newFrag)
            .commit()
        baseFragment = newFrag
    }
}