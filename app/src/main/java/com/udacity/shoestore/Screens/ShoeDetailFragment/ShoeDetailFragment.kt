package com.udacity.shoestore.Screens.ShoeDetailFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {
    private lateinit var shoesViewModel: ShoeViewModel


    private lateinit var shoeDetailBinding: FragmentShoeDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shoeDetailBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )
        shoesViewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
        shoeDetailBinding.viewModel=shoesViewModel

        shoeDetailBinding.save.setOnClickListener {
            shoesViewModel.saveNewShoe()
            findNavController().popBackStack()
        }
        shoeDetailBinding.cancel.setOnClickListener {
            shoesViewModel.clearShoeTemplate()
            findNavController().popBackStack()
        }
        return shoeDetailBinding.root
    }


    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }
}