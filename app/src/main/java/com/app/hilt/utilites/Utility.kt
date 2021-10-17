package com.app.hilt.utilites

import android.content.Context
import android.net.ConnectivityManager


object Utility {

  fun isNetworkAvailable(context: Context): Boolean {
    val connectivityManager: ConnectivityManager =
      context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = connectivityManager.activeNetworkInfo
    return networkInfo != null && networkInfo.isConnected

  }

  fun getNames() : ArrayList<String>{
    val names: ArrayList<String> = ArrayList()
    names.add("Dhoni")
    names.add("Ruturaj")
    names.add("faf")
    names.add("Robbin")
    names.add("asif")
    names.add("Ali")
    names.add("Raidu")
    names.add("Raina")
    names.add("Jadeja")
    names.add("Bravo")
    names.add("Curun")
    names.add("Chahar")
    names.add("Thakur")
    names.add("Josh")

    return names
  }

}