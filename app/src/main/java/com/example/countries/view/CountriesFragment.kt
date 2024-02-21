package com.example.countries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countries.viewmodel.CountriesViewModel
import com.example.countries.view.adapter.CountryAdapter
import com.example.countries.databinding.FragmentCountriesBinding

class CountriesFragment : Fragment() {

    private val viewModel: CountriesViewModel by viewModels()
    private val adapter: CountryAdapter by lazy {
        CountryAdapter(emptyList())
    }

    private var _binding: FragmentCountriesBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = CountriesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCountriesBinding.inflate(inflater, container, false)

        initObservables()
        initRecyclerView()

        return binding.root
    }

    private fun initObservables() {
        viewModel.countryData.observe(viewLifecycleOwner) {

            adapter.updateDataSet(it)
        }
    }

    private fun initRecyclerView(){
        val manager = LinearLayoutManager(requireContext().applicationContext)
        val decoration = DividerItemDecoration(requireContext().applicationContext, manager.orientation)
        binding.recyclerCountries.layoutManager = manager
        binding.recyclerCountries.adapter = adapter
        binding.recyclerCountries.addItemDecoration(decoration)
    }

}