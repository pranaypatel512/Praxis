package com.mutualmobile.praxis.ui.home

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mutualmobile.praxis.R
import com.mutualmobile.praxis.databinding.FragmentAboutBinding
import dagger.android.DaggerDialogFragment

class AboutFragment : DaggerDialogFragment(), LifecycleOwner {

  companion object {
    fun newInstance(): AboutFragment {
      val fragment = AboutFragment()
      val args = Bundle()
      fragment.arguments = args
      return fragment
    }
  }

  private lateinit var binding: FragmentAboutBinding
  override fun getLifecycle(): Lifecycle {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
  ): View {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_about, container, false)
    binding.mutualMobileWebLink.movementMethod = LinkMovementMethod.getInstance()
    return binding.root
  }

}