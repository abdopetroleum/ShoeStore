package com.udacity.shoestore.Screens.SignInFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {
    private lateinit var fragmentSignInBinding: FragmentSignInBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSignInBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_sign_in,
            container,
            false)
        fragmentSignInBinding.loginButton.setOnClickListener {
            moveToWelcomeFragment(it)
        }
        fragmentSignInBinding.signUpButton.setOnClickListener {
            moveToWelcomeFragment(it)
        }

        return fragmentSignInBinding.root
    }
    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }

    fun moveToWelcomeFragment(view: View){
        view.findNavController().navigate(R.id.action_signInFragment_to_welcomeFragment)
    }

}