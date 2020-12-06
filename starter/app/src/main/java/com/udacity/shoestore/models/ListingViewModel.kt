package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.ui.login.LoginViewModel
import timber.log.Timber

class ListingViewModel : ViewModel() {
    private var _shoesListing : MutableLiveData<MutableList<Shoe>> = MutableLiveData(mutableListOf())
    /*private var _shoesListing: MutableLiveData<MutableList<Shoe>> = MutableLiveData(
        mutableListOf(
            Shoe(
                name = "Sneaker",
                size = 15.0,
                company = "Weird Company",
                description = "A nice sneaker",
                images = listOf("all of these", "tools", "documentation", "libraries")
            ),
            Shoe(
                name = "Flat",
                size = 15.0,
                company = "Weird Company",
                description = "A nice sneaker",
                images = listOf("all of these", "tools", "documentation", "libraries")
            ),
            Shoe(
                name = "Wedge",
                size = 15.0,
                company = "Weird Company",
                description = "A nice sneaker",
                images = listOf("all of these", "tools", "documentation", "libraries")
            ),
            Shoe(
                name = "Heels",
                size = 15.0,
                company = "Weird Company",
                description = "A nice sneaker",
                images = listOf("all of these", "tools", "documentation", "libraries")
            ),
            Shoe(
                name = "Flat",
                size = 15.0,
                company = "Weird Company",
                description = "A nice sneaker",
                images = listOf("all of these", "tools", "documentation", "libraries")
            ),
            Shoe(
                name = "Wedge",
                size = 15.0,
                company = "Weird Company",
                description = "A nice sneaker",
                images = listOf("all of these", "tools", "documentation", "libraries")
            ),
            Shoe(
                name = "Flat",
                size = 15.0,
                company = "Weird Company",
                description = "A nice sneaker",
                images = listOf("all of these", "tools", "documentation", "libraries")
            ),
            Shoe(
                name = "Wedge",
                size = 15.0,
                company = "Weird Company",
                description = "A nice sneaker",
                images = listOf("all of these", "tools", "documentation", "libraries")
            ),
            Shoe(
                name = "Flat",
                size = 15.0,
                company = "Weird Company",
                description = "A nice sneaker",
                images = listOf("all of these", "tools", "documentation", "libraries")
            ),
            Shoe(
                name = "Wedge",
                size = 15.0,
                company = "Weird Company",
                description = "A nice sneaker",
                images = listOf("all of these", "tools", "documentation", "libraries")
            ),
            Shoe(
                name = "Flat",
                size = 15.0,
                company = "Weird Company",
                description = "A nice sneaker",
                images = listOf("all of these", "tools", "documentation", "libraries")
            ),
            Shoe(
                name = "Wedge",
                size = 15.0,
                company = "Weird Company",
                description = "A nice sneaker",
                images = listOf("all of these", "tools", "documentation", "libraries")
            ),
            Shoe(
                name = "Flat",
                size = 15.0,
                company = "Weird Company",
                description = "A nice sneaker",
                images = listOf("all of these", "tools", "documentation", "libraries")
            ),
            Shoe(
                name = "Wedge",
                size = 15.0,
                company = "Weird Company",
                description = "A nice sneaker",
                images = listOf("all of these", "tools", "documentation", "libraries")
            ),
            Shoe(
                name = "Flat",
                size = 15.0,
                company = "Weird Company",
                description = "A nice sneaker",
                images = listOf("all of these", "tools", "documentation", "libraries")
            ),
            Shoe(
                name = "Wedge",
                size = 15.0,
                company = "Weird Company",
                description = "A nice sneaker",
                images = listOf("all of these", "tools", "documentation", "libraries")
            ),
            Shoe(
                name = "Flat",
                size = 15.0,
                company = "Weird Company",
                description = "A nice sneaker",
                images = listOf("all of these", "tools", "documentation", "libraries")
            ),
            Shoe(
                name = "Wedge",
                size = 15.0,
                company = "Weird Company",
                description = "A nice sneaker",
                images = listOf("all of these", "tools", "documentation", "libraries")
            ),
            Shoe(
                name = "Flat",
                size = 15.0,
                company = "Weird Company",
                description = "A nice sneaker",
                images = listOf("all of these", "tools", "documentation", "libraries")
            ),
            Shoe(
                name = "Wedge",
                size = 15.0,
                company = "Weird Company",
                description = "A nice sneaker",
                images = listOf("all of these", "tools", "documentation", "libraries")
            ),
            Shoe(
                name = "Flat",
                size = 15.0,
                company = "Weird Company",
                description = "A nice sneaker",
                images = listOf("all of these", "tools", "documentation", "libraries")
            ),
            Shoe(
                name = "Wedge",
                size = 15.0,
                company = "Weird Company",
                description = "A nice sneaker",
                images = listOf("all of these", "tools", "documentation", "libraries")
            )
        )
    )*/

    val shoesListing : LiveData<MutableList<Shoe>> = _shoesListing

    init {
        if (_shoesListing.value.isNullOrEmpty()){
            Timber.i("Initializing your shoe store!")
            setInitialListing()
        }
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("Shoe store got destroyed!")
    }

    fun addShoe(name: String, size: Double, company: String, description: String){
        val shoe = Shoe(name = name, size = size, company = company, description = description, images = mutableListOf())
        _shoesListing.value?.add(shoe)
        Timber.i("Shoe added")
        Timber.i(_shoesListing.value?.count().toString())
    }

     private fun setInitialListing(){
        _shoesListing?.value = MutableLiveData(mutableListOf(
            Shoe(
                name = "Sneaker",
                size = 15.0,
                company = "Weird Company",
                description = "A nice pair of sneakers",
                images = listOf("all of these", "tools", "documentation", "libraries")
            ),
            Shoe(
                name = "Flat",
                size = 15.0,
                company = "Weird Company",
                description = "Cute sandals",
                images = listOf("all of these", "tools", "documentation", "libraries")
            ),
            Shoe(
                name = "Wedge",
                size = 15.0,
                company = "Weird Company",
                description = "Very confusing shoe",
                images = listOf("all of these", "tools", "documentation", "libraries")
            ),
            Shoe(
                name = "Heels",
                size = 15.0,
                company = "For the office",
                description = "A nice sneaker",
                images = listOf("all of these", "tools", "documentation", "libraries")
            )
            )).value
         Timber.i("Finished initializing")
    }
}