package com.vtu.base.views

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vtu.base.R
import com.vtu.base.databinding.MainFragmentBinding
import com.vtu.base.viewmodels.MainFragmentViewModel
import com.vtu.base.viewmodels.MainViewModel

class MainFragment : BaseRecycleViewFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = MainFragmentViewModel(activity)

        val view = super.onCreateView(inflater, container, savedInstanceState)
        val binding = com.vtu.base.databinding.MainFragmentBinding.inflate(this.layoutInflater)
        binding.setViewModel(viewModel as MainFragmentViewModel)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}
