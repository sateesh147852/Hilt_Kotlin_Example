package com.app.hilt.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.app.hilt.databinding.ActivityMainBinding
import com.app.hilt.module.Mobile
import com.app.hilt.utilites.Utility
import com.app.hilt.viewModel.MainViewModel
import com.bumptech.glide.RequestManager
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.util.*
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  @SuppressLint("FieldSiteTargetOnQualifierAnnotation")
  @field:[Inject Named("FirstName")]
  lateinit var firstName: String

  @SuppressLint("FieldSiteTargetOnQualifierAnnotation")
  @field:[Inject Named("LastName")]
  lateinit var lastName: String

  @Inject
  lateinit var requestManager: RequestManager

  @Inject
  lateinit var mobile: Mobile

  private lateinit var binding: ActivityMainBinding

  private lateinit var viewModel: MainViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    printNames()
    setOnClickListener()
    loadFragment()
    loadProfileImage()
    initializeViewModel()

  }

  private fun initializeViewModel() {
    viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    Timber.i(viewModel.toString())
  }

  private fun loadProfileImage() {
    requestManager.load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFZbPduh7DVvaSplCeCQZdmv8FwlXgyqZkDw&usqp=CAU")
      .into(binding.ivProfile)
  }

  private fun loadFragment() {
    ProfileFragment.newInstance()?.let {
      supportFragmentManager.beginTransaction()
        .replace(binding.flContainer.id, it, "Profile Fragment").commit()
    }
  }

  private fun setOnClickListener() {
    binding.btClick.setOnClickListener {
      startActivity(Intent(this, SecondActivity::class.java))
    }
  }

  private fun printNames() {
    Timber.i("$firstName $lastName")
    mobile.display()
    if (Utility.isNetworkAvailable(this))
      Toast.makeText(this, "Connection is available", Toast.LENGTH_SHORT).show()
    else
      Toast.makeText(this, "Connection is not available", Toast.LENGTH_SHORT).show()
  }
}