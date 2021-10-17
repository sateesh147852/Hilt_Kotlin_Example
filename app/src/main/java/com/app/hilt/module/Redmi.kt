package com.app.hilt.module

import timber.log.Timber
import javax.inject.Inject

class Redmi @Inject constructor() {

  init {
    Timber.i("Redmi init block called")
  }
}