package com.udacity.shoestore

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.databinding.FragmentListingBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class Listing : Fragment() {
    private lateinit var listingViewModel: ListingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentListingBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_listing, container, false)

        listingViewModel = ViewModelProvider(this).get(ListingViewModel::class.java)

        binding.listingViewModel = listingViewModel
        binding.setLifecycleOwner(this)

        listingViewModel.shoesListing.observe(viewLifecycleOwner, Observer { shoesListing ->
            val shoeNames = arrayOfNulls<String>(shoesListing.size)
            for (i in 0 until shoesListing.size) {
                val shoe = shoesListing[i]
                shoeNames[i] = shoe?.name
            }
            //Timber.i(shoeNames.toString())
            val adapter = ArrayAdapter(
                requireActivity(),
                android.R.layout.simple_list_item_1,
                shoeNames
            ) //listItems.toList().toString()
            binding.shoesListview.adapter = adapter
            //Timber.i(shoesListing.toString())
        })


        return binding.root
    }

}


/*
companion object {
    fun newInstance() = Listing()
}

private lateinit var viewModel: ListingViewModel

override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    return inflater.inflate(R.layout.fragment_listing, container, false)
}

override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    viewModel = ViewModelProvider(this).get(ListingViewModel::class.java)
    // TODO: Use the ViewModel
}*/
