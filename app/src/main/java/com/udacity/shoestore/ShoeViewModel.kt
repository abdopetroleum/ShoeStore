package com.udacity.shoestore

import androidx.databinding.Bindable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import kotlin.math.log

class ShoeViewModel : ViewModel() {
    var shoe = Shoe()
    //Shoes List -----------
    var shoesList = MutableLiveData<MutableList<Shoe>>(mutableListOf())

    fun saveNewShoe() {
        (shoesList.value)?.add(shoe)
        clearShoeTemplate()
    }

    fun clearShoeTemplate() {
        shoe = Shoe()
    }
}