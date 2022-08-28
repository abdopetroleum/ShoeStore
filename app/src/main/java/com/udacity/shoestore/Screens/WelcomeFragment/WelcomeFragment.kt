package com.udacity.shoestore.Screens.WelcomeFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentSignInBinding
import com.udacity.shoestore.databinding.FragmentWelcomeBinding


/**
 * A simple [Fragment] subclass.
 * Use the [WelcomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WelcomeFragment : Fragment() {
    private lateinit var fragmentWelcomeBinding: FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentWelcomeBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_welcome,
            container,
            false
        )
        fragmentWelcomeBinding.welcomeNextButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_welcomeFragment_to_instructionsFragment)
        }
        (activity as AppCompatActivity).supportActionBar?.hide()
        return fragmentWelcomeBinding.root
    }
}

