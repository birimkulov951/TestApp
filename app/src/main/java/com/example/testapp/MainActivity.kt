package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.testapp.model.BookApi
import com.example.testapp.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getRecyclerListDataObserver().observe(this, Observer<BookApi>{

            if(it != null) {
                text.text = it.toString()

            } else {
                Toast.makeText(this@MainActivity, "Error in getting data from api.", Toast.LENGTH_LONG).show()
            }

        })

        viewModel.makeApiCall("london")


    }




   /* override fun onStart() {
        super.onStart()

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val apiService = ApiService(ConnectivityInterceptorImpl(this.baseContext!!))
        val dataSource = DataSourceImpl(apiService)

        dataSource.downloadedCurrentWeather.observe(this, Observer {
            text.text = it.toString()
        })

        GlobalScope.launch(Dispatchers.Main) {

            dataSource.fetchCurrentWeather("London")
        }

    }*/

}