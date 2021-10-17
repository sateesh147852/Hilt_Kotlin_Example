package com.app.hilt.viewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
public class MainViewModel
@Inject
constructor(randomNumber: Int,isActive: Boolean) : ViewModel() {

  init {
    Timber.i("$randomNumber $isActive")
  }

}