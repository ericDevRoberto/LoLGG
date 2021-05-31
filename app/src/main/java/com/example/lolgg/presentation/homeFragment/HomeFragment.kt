package com.example.lolgg.presentation.homeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lolgg.R
import com.example.lolgg.databinding.FragmentHomeBinding
import com.example.lolgg.presentation.homeFragment.HomeAction.*
import com.example.lolgg.utils.alertDialog
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModel()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        val adapter = ArrayAdapter(
            requireContext(),
            R.layout.item_textview,
            resources.getStringArray(R.array.regions)
        )

        binding.spinnerRegions.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSearch.setOnClickListener {
            getSummonerInViewModel()
        }

        viewModel.mutableLiveData.observe(viewLifecycleOwner) { action ->

            when (action) {
                is Success -> goToLoading(puuId = action.data)
                InternetError -> dialogAlert(
                    message = R.string.alertdialog_message_internet_error,
                    title = R.string.alertdialog_title_internet_error
                )
                ApiProblem -> dialogAlert(
                    message = R.string.alertdialog_message_developer_error,
                    title = R.string.alertdialog_title_api_error
                )
                DataNotFound -> dialogAlert(
                    message = R.string.alertdialog_message_not_found_error,
                    title = R.string.alertdialog_title_not_found_error
                )
                EmptyEditText -> dialogAlert(
                    message = R.string.alertdialog_message_empty_edittext,
                    title = R.string.alertdialog_title_empty_edittext
                )
                Forbidden -> dialogAlert(
                    message = R.string.alertdialog_message_developer_error,
                    title = R.string.alertdialog_title_invalid_api_key_error
                )
                Unauthorized -> dialogAlert(
                    message = R.string.alertdialog_message_developer_error,
                    title = R.string.alertdialog_title_wrong_api_key_error
                )
                UnavailableService -> dialogAlert(
                    message = R.string.alertdialog_message_unavailable_service_error,
                    title = R.string.alertdialog_title_unavailable_service_error
                )
                GatewayTimeout -> dialogAlert(
                    message = R.string.alertdialog_message_gateway_timeout_error,
                    title = R.string.alertdialog_title_gateway_timeout_error,
                    onClickBntPositive = { getSummonerInViewModel() },
                    positiveBntTitle = R.string.dialog_text_generic_try_again,
                    negativeBntTitle = R.string.dialog_text_generic_close
                )
            }
        }
    }

    private fun getSummonerInViewModel() {
        viewModel.getSummoner(
            name = binding.edittextSummonerName.text.toString(),
            region = binding.spinnerRegions.selectedItem.toString()
        )
    }

    private fun goToLoading(puuId: String) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToResult(puuId = puuId)
        )
    }

    private fun dialogAlert(
        @StringRes message: Int,
        @StringRes title: Int,
        @StringRes positiveBntTitle: Int? = null,
        @StringRes negativeBntTitle: Int? = R.string.dialog_text_generic_negative_bnt,
        onClickBntPositive: (() -> Unit)? = null
    ) {
        alertDialog(
            message = message,
            title = title,
            onClickBntPositive = onClickBntPositive,
            positiveBntTitle = positiveBntTitle,
            negativeBntTitle = negativeBntTitle
        )
    }
}