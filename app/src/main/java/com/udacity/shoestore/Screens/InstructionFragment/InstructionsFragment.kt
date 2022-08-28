package com.udacity.shoestore.Screens.InstructionFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import com.udacity.shoestore.databinding.FragmentWelcomeBindingImpl

class InstructionsFragment : Fragment() {
        private lateinit var fragmentInstructionsBinding: FragmentInstructionsBinding
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            fragmentInstructionsBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_instructions,
                container,
                false
            )
            fragmentInstructionsBinding.instructionsNextButton.setOnClickListener {
                it.findNavController().navigate(R.id.action_instructionsFragment_to_listingFragment)
            }
            (activity as AppCompatActivity).supportActionBar?.hide()

            // Inflate the layouet for this fragment
            return fragmentInstructionsBinding.root
        }
    }