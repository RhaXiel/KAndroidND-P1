package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.databinding.FragmentListingBinding
import com.udacity.shoestore.models.ListingViewModel
import timber.log.Timber

class fragment_detail : Fragment() {
    private lateinit var shoeViewModel : ListingViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        shoeViewModel = ViewModelProvider(this).get(ListingViewModel::class.java)

        //binding.listingViewModel = shoeViewModel
        //binding.lifecycleOwner = this
        Timber.i(shoeViewModel.shoesListing.toString())
        binding.saveButton.setOnClickListener { view : View ->
            shoeViewModel.addShoe(binding.shoeNameTextedit.text.toString(),
                binding.shoeSizeTextedit.text.toString().toDouble(),
                binding.shoeCompanyTextedit.text.toString(),
                binding.shoeDescriptionTextedit.text.toString()
            )
            view.findNavController().navigate(R.id.action_fragment_detail_to_listingFragment)
        }

        /*(activity as MainActivity).supportActionBar?.title = getString(R.string.shoe_details_text)
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as MainActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
*/
        return binding.root
    }
}