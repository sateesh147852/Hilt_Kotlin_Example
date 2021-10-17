package com.app.hilt.module

import timber.log.Timber
import javax.inject.Inject

class Mobile @Inject constructor(redmi: Redmi,samsung: Samsung) {

  init {
    Timber.i("Mobile init block called")
  }

  fun display(){
    Timber.i("display method is called")
  }
}