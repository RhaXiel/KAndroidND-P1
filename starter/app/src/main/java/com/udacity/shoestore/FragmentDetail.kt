package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.models.ListingViewModel

class FragmentDetail : Fragment() {
    private lateinit var listingViewModel: ListingViewModel
    private lateinit var logoutButton: MenuItem
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        activity?.let {
            listingViewModel = ViewModelProvider(it).get(ListingViewModel::class.java)
        }

        binding.saveButton.setOnClickListener { view: View ->
            listingViewModel.addShoe(
                binding.shoeNameTextedit.text.toString(),
                binding.shoeSizeTextedit.text.toString().toDouble(),
                binding.shoeCompanyTextedit.text.toString(),
                binding.shoeDescriptionTextedit.text.toString()
            )
            view.findNavController().navigate(R.id.action_fragment_detail_to_listingFragment)
        }

        binding.cancelButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_fragment_detail_to_listingFragment)
        }

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