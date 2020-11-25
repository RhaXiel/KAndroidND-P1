package com.udacity.shoestore

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ListingViewModel : ViewModel() {
    //name: String, var size: Double, var company: String, var description: String, val images: List<String> = mutableListOf()
    private var _shoes : MutableList<Shoe> = mutableListOf(
        Shoe(name = "Sneaker",
            size = 15.0,
            company = "Weird Company",
            description = "A nice sneaker",
            images = listOf("all of these", "tools", "documentation", "libraries")),
        Shoe(name = "Flat",
            size = 15.0,
            company = "Weird Company",
            description = "A nice sneaker",
            images = listOf("all of these", "tools", "documentation", "libraries")),
        Shoe(name = "Wedge",
            size = 15.0,
            company = "Weird Company",
            description = "A nice sneaker",
            images = listOf("all of these", "tools", "documentation", "libraries")),
        Shoe(name = "Heels",
            size = 15.0,
            company = "Weird Company",
            description = "A nice sneaker",
            images = listOf("all of these", "tools", "documentation", "libraries"))
    )
    private val _shoesListing =  MutableLiveData<MutableList<Shoe>>(_shoes)
    val shoesListing : LiveData<MutableList<Shoe>> = _shoesListing

    //init {
    //    setInitialListing()
    //}

    fun addShoe(name: String, size: Double, company: String, description: String, images: List<String>){
        _shoesListing.value?.add(Shoe(name = name, size = size, company = company, description = description, images = images))
    }
    fun getShoe(name : String) : Shoe? {
        return _shoesListing.value?.find { it.name == name }
    }

    private fun setInitialListing(){
        _shoes = mutableListOf(
            Shoe(name = "Sneaker",
                size = 15.0,
                company = "Weird Company",
                description = "A nice sneaker",
                images = listOf("all of these", "tools", "documentation", "libraries")),
            Shoe(name = "Sneaker",
                size = 15.0,
                company = "Weird Company",
                description = "A nice sneaker",
                images = listOf("all of these", "tools", "documentation", "libraries")),
            Shoe(name = "Sneaker",
                size = 15.0,
                company = "Weird Company",
                description = "A nice sneaker",
                images = listOf("all of these", "tools", "documentation", "libraries")),
            Shoe(name = "Sneaker",
                size = 15.0,
                company = "Weird Company",
                description = "A nice sneaker",
                images = listOf("all of these", "tools", "documentation", "libraries"))
        )
    }
}
