package com.example.lolgg.presentation.homeFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.lolgg.R
import com.example.lolgg.databinding.FragmentHomeBinding
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
                name = binding.textviewFirst.text.toString(),
                region =  binding.spinnerRegions.selectedItem.toString()
            )
            //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

    }
}