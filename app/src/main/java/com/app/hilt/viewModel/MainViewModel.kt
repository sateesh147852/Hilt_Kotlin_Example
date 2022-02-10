package com.app.hilt.viewModel

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.bumptech.glide.RequestManager
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
public class MainViewModel
@Inject
constructor(
    randomNumber: Int,
    isActive: Boolean,
    requestManager: RequestManager,
    context: Context
) : ViewModel() {

    init {
        Timber.i("$randomNumber $isActive")
        Handler(Looper.myLooper()!!).postDelayed({
            Toast.makeText(context, "ViewModel is running", Toast.LENGTH_SHORT).show()
        }, 3000)

    }

}