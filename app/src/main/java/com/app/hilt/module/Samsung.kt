package com.app.hilt.module

import timber.log.Timber
import javax.inject.Inject

class Samsung @Inject constructor() {

  init {
    Timber.i("Samsung init block called")
  }
}