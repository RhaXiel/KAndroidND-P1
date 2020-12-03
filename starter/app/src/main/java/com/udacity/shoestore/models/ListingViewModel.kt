package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ListingViewModel : ViewModel() {
    //name: String, var size: Double, var company: String, var description: String, val images: List<String> = mutableListOf()
    private var _shoesListing : MutableLiveData<MutableList<Shoe>> = MutableLiveData(mutableListOf())
    /*private var _shoesListing : MutableLiveData<MutableList<Shoe>> = MutableLiveData(mutableListOf(
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
        Shoe(name = "Flat",
            size = 15.0,
            company = "Weird Company",
            description = "A nice sneaker",
            images = listOf("all of these", "tools", "documentation", "libraries")),
        Shoe(name = "Wedge",
            size = 15.0,
            company = "Weird Company",
            description = "A nice sneaker",
            images = listOf("all of these", "tools", "documentation", "libraries"))
    ))*/
    //private val _shoesListing =  MutableLiveData<MutableList<Shoe>>(_shoes)
    val shoesListing : LiveData<MutableList<Shoe>> = _shoesListing

    init {
        /*if (_shoesListing.value.isNullOrEmpty()){
            Timber.i("Initializing your shoe store!")
            setInitialListing()
        }*/
    }

    fun addShoe(name: String, size: Double, company: String, description: String){
        val shoe = Shoe(name = name, size = size, company = company, description = description, images = mutableListOf())
        //val list = _shoesListing.value
        //list?.add(shoe)
        _shoesListing.value?.add(shoe)
        //Timber.i(list.toString())
        _shoesListing.value = _shoesListing.value
    }
    fun getShoe(name : String) : Shoe? {
        return _shoesListing.value?.find { it.name == name }
    }

     private fun setInitialListing(){
        _shoesListing?.value = MutableLiveData(mutableListOf(
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
            )).value
         Timber.i("Finished initializing")
    }
}
