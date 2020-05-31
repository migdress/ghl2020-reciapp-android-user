package com.reciapp.user.presentation.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.reciapp.user.R
import com.reciapp.user.presentation.adapters.RecycleTypeAdapter
import com.reciapp.user.presentation.viewModels.RecycleTypeViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val recycleTypeViewModel: RecycleTypeViewModel by viewModel()
    private val recycleTypeAdapter: RecycleTypeAdapter by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()
        //initListeners()

        recycleTypeViewModel.getRecycleTypes()
    }

    private fun initObservers() {
        recycleTypeViewModel.getRecycleTypeLiveData.observe(viewLifecycleOwner, Observer {
            rcvRecyclerTypes.adapter = recycleTypeAdapter
            rcvRecyclerTypes.setHasFixedSize(true)
            recycleTypeAdapter.setData(it)
        })
    }

    private fun initListeners() {
    }
}
