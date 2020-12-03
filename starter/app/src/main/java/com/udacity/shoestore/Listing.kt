package com.udacity.shoestore

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.databinding.FragmentListingBinding
import com.udacity.shoestore.models.ListingViewModel
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_listing.view.*
import kotlinx.android.synthetic.main.fragment_listing_item.view.*
import timber.log.Timber
import java.sql.Time

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
        binding.lifecycleOwner = this

        binding.addElementButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_listingFragment_to_fragment_detail)
        }

        // Add observer for shoes
        listingViewModel.shoesListing.observe(viewLifecycleOwner, Observer { shoes ->
            for (item in shoes) {
                Timber.i(item.toString())
                val child: View = layoutInflater.inflate(R.layout.fragment_listing_item, null)
                child.shoeName_textview.text = item.name
                child.shoeSize_textview.text = item.size.toString()
                child.shoeCompany_textview.text = item.company
                child.shoeDescription_textview.text = item.description
                binding.shoesLinearlayout.addView(child)
            }
        })

        return binding.root
    }
}