package com.app.hilt.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.hilt.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class ProfileFragment : Fragment() {

  @SuppressLint("FieldSiteTargetOnQualifierAnnotation")
  @field:[Inject Named("FirstName")]
  lateinit var firstName : String

  @SuppressLint("FieldSiteTargetOnQualifierAnnotation")
  @field:[Inject Named("LastName")]
  lateinit var lastName : String

  @SuppressLint("SetTextI18n")
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val fragmentProfileBinding = FragmentProfileBinding.inflate(LayoutInflater.from(context),container,false)
    fragmentProfileBinding.tvNames.text = "$firstName $lastName"
    return fragmentProfileBinding.root
  }

  companion object {

    private var profileFragment: ProfileFragment? = null

    fun newInstance(): ProfileFragment? {
      if (profileFragment == null)
        profileFragment = ProfileFragment()
      return profileFragment
    }
  }
}