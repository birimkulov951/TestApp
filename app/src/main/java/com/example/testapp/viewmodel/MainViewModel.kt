package com.example.testapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapp.impl.ApiService
import com.example.testapp.impl.RetroInstance
import com.example.testapp.model.BookApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel : ViewModel() {
    lateinit var recyclerListData: MutableLiveData<BookApi>


    init {
        recyclerListData = MutableLiveData()
    }


    fun getRecyclerListDataObserver(): MutableLiveData<BookApi> {
        return recyclerListData
    }

    fun makeApiCall(input: String) {
        val retroInstance = RetroInstance.getRetroInstance().create(ApiService::class.java)
        val call = retroInstance.getBooks(input)
        call.enqueue(object : Callback<BookApi>{
            override fun onResponse(call: Call<BookApi>, response: Response<BookApi>) {
                if(response.isSuccessful) {
                    //recyclerViewAdapter.setListData(response.body()?.items!!)
                    //recyclerViewAdapter.notifyDataSetChanged()
                    recyclerListData.postValue(response.body())
                } else {
                    recyclerListData.postValue(null)
                }
            }

            override fun onFailure(call: Call<BookApi>, t: Throwable) {
                // Toast.makeText(this@RecyclerViewActivity, "Error in getting data from api.", Toast.LENGTH_LONG).show()

                recyclerListData.postValue(null)
            }
        })
    }
}