package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentListingBinding
import com.udacity.shoestore.models.ListingViewModel
import kotlinx.android.synthetic.main.fragment_listing_item.view.*
import timber.log.Timber

class Listing : Fragment() {
    private lateinit var listingViewModel: ListingViewModel
    private lateinit var logoutButton: MenuItem

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentListingBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_listing, container, false)

        activity?.let {
            listingViewModel = ViewModelProvider(it).get(ListingViewModel::class.java)
        }

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

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        if (menu != null) {
            logoutButton = menu.findItem(R.id.loginFragment)
            logoutButton.isVisible = true
        }
    }
}