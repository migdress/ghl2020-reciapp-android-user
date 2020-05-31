package com.reciapp.user.presentation.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.reciapp.user.R
import com.reciapp.user.presentation.adapters.RecycleTypeAdapter
import com.reciapp.user.presentation.di.adaptersModule
import com.reciapp.user.presentation.states.OpenShiftState
import com.reciapp.user.presentation.viewModels.OpenShiftViewModel
import com.reciapp.user.presentation.viewModels.RecycleTypeViewModel
import com.reciapp.user.utils.viewExtensions.showMessage
import kotlinx.android.synthetic.main.content_home.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val recycleTypeViewModel: RecycleTypeViewModel by viewModel()
    private val openShiftViewModel: OpenShiftViewModel by viewModel()
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
        initListeners()

        recycleTypeViewModel.getRecycleTypes()
        openShiftViewModel.getOpenShifts()
    }

    private fun initObservers() {
        recycleTypeViewModel.getRecycleTypeLiveData.observe(viewLifecycleOwner, Observer {
            rcvRecyclerTypes.adapter = recycleTypeAdapter
            rcvRecyclerTypes.setHasFixedSize(true)
            recycleTypeAdapter.setTypes(it)
        })

        openShiftViewModel.getOpenShiftLiveData.observe(viewLifecycleOwner, Observer {
            renderOpenShiftState(it)
        })
    }

    private fun renderOpenShiftState(openShiftState: OpenShiftState) {
        when (openShiftState) {
            is OpenShiftState.Success -> {
                with(openShiftState.openShiftsResponse.shifts[0]) {
                    txvPickupDateValue.text = formattedDate
                    txvNextDateValue.text = shift
                }
            }
            is OpenShiftState.Failure -> {
                showMessage(getString(R.string.error_open_shifts_failure))
            }
        }
    }

    private fun initListeners() {
        btnRequestPickup.setOnClickListener {

        }
    }
}
