package com.example.lolgg.presentation.homeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.lolgg.R
import com.example.lolgg.databinding.FragmentHomeBinding
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
            viewModel.getSummoner(
                name = binding.edittextSummonerName.text.toString(),
                region = binding.spinnerRegions.selectedItem.toString()
            )
        }

        viewModel.mutableLiveData.observe(viewLifecycleOwner, Observer { action ->

            when (action) {
                is HomeAction.InternetProblem -> dialogAlert(R.string.alertdialog_message_internet_erro)
                is HomeAction.DeveloperProblem -> dialogAlert(R.string.alertdialog_message_developer_erro)
                is HomeAction.NotFound -> dialogAlert(R.string.alertdialog_message_not_found_erro)
                is HomeAction.Success -> goToLoading()
                is HomeAction.IdNotFound -> message("Não achado")
                is HomeAction.IdFound -> message("achado")
                is HomeAction.EmptyEdittext -> dialogAlert(R.string.alertdialog_message_empty_edittext)
            }
        })
    }

    private fun goToLoading() {
        //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }

    private fun message(text: String) {

        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
    }

    private fun dialogAlert(@StringRes message: Int) {
        alertDialog(message = message)
    }
}