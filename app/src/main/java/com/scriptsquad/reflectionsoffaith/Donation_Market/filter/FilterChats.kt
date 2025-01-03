package com.scriptsquad.reflectionsoffaith.Donation_Market.filter

import android.widget.Filter
import com.scriptsquad.reflectionsoffaith.Donation_Market.adapter.AdapterChats
import com.scriptsquad.reflectionsoffaith.Donation_Market.model.ModelChats

class FilterChats : Filter {

    private val adapterChats: AdapterChats
    private val filterList:ArrayList<ModelChats>

    constructor(adapterChats: AdapterChats, filterList: ArrayList<ModelChats>) : super() {
        this.adapterChats = adapterChats
        this.filterList = filterList
    }


    override fun performFiltering(constraint: CharSequence?): FilterResults {

        var constraint:CharSequence? = constraint
        val results = FilterResults()

        if (!constraint.isNullOrEmpty()){

            constraint = constraint.toString().uppercase()

            val filteredModels = ArrayList<ModelChats>()
            for (i in filterList.indices){

                if (filterList[i].name.uppercase().contains(constraint)){

                    filteredModels.add(filterList[i])
                }

            }

            results.count = filteredModels.size
            results.values = filteredModels

        }else{
            results.count = filterList.size
            results.values = filterList
        }

        return  results
    }

    override fun publishResults(constraint: CharSequence?, results: FilterResults) {
        // publish the filtered result

        adapterChats.chatsArrayList = results.values as ArrayList<ModelChats>
        adapterChats.notifyDataSetChanged()
    }

}
//method used from YouTube
//https://youtu.be/4a3nKOyqDmY?si=M-d5mokUeFO9gm4m
//channel: The Android Factory