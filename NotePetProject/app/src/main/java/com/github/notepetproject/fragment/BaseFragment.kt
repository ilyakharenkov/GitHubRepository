package com.github.notepetproject.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.github.notepetproject.daoMVVM.MainViewModel
import com.github.notepetproject.daoMVVM.MainViewModelFactory
import com.github.notepetproject.database.MainApp

abstract class BaseFragment: Fragment() {

     abstract fun onClickNew()

     val mainViewModel: MainViewModel by activityViewModels{
          MainViewModelFactory((context?.applicationContext as MainApp).dataBase)
     }
}