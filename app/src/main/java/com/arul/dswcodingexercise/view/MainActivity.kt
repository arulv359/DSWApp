package com.arul.dswcodingexercise.view

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.arul.dswcodingexercise.R
import com.arul.dswcodingexercise.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var context: Context

    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this@MainActivity
        spinnerLoading.hide()
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        btnClick.setOnClickListener {

            // To show network activity
            spinnerLoading.show()

            mainActivityViewModel.getBag()!!.observe(this, Observer { serviceSetterGetter ->

                //Spinner will be hidden once the network request complete.
                spinnerLoading.hide()

                val msg = serviceSetterGetter.products?.get(0)?.displayName
                var products: String = ""
                for (product in serviceSetterGetter.products!!) {
                    products = products + "\n" + product
                }

                //Toast can be replaced to show the list in Recycler View
                Toast.makeText(context, products, Toast.LENGTH_SHORT).show()
                lblResponse.text = msg

            })

        }
    }
}
