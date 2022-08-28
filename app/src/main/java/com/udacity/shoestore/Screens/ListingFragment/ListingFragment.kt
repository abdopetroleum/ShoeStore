package com.udacity.shoestore.Screens.ListingFragment

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentListingBinding
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import com.udacity.shoestore.databinding.ListItemBinding
import com.udacity.shoestore.models.Shoe

class ListingFragment : Fragment() {
    private lateinit var fragmentListingBinding: FragmentListingBinding
    private lateinit var shoesViewModel: ShoeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentListingBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_listing,
            container,
            false
        )
        shoesViewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)

        fragmentListingBinding.floatingActionButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_listingFragment_to_shoeDetailFragment)

        }
        shoesViewModel.shoesList.observe(viewLifecycleOwner, Observer { shoesList->
            updateShoeList(shoesList)

        })

        (activity as AppCompatActivity).supportActionBar?.show()
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(false)

        return fragmentListingBinding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(R.id.action_listingFragment_to_signInFragment)
        return super.onOptionsItemSelected(item)
    }
    private fun updateShoeList(listShoes: MutableList<Shoe>) {
        val parentLayout = fragmentListingBinding.shoeElementList
        var index = 0
        while (index < listShoes.size) {
            val shoeBinding: ListItemBinding = DataBindingUtil.inflate(
                layoutInflater,
                R.layout.list_item,
                parentLayout,
                false
            )

            val shoe = listShoes[index]
            shoeBinding.shoeName.text = shoe.name
            shoeBinding.companyName.text = shoe.company
            shoeBinding.shoeSize.text =shoe.size.toString()
            shoeBinding.description.text = shoe.description
            parentLayout.addView(shoeBinding.root)
            index++
        }
    }
}