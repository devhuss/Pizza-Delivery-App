package com.example.hw2pizzaorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // global variables
    var priceToppings = 0.0
    var priceSize = 0.0
    var priceDelivery = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pizzaList = listOf("Pepperoni", "Margherita", "Hawaiian", "BBQ Chicken")

        val pizzaAdapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pizzaList)

        val pizzaListView = findViewById<ListView>(R.id.pizza_list)

        pizzaListView.adapter = pizzaAdapter

        pizzaListView.setOnItemClickListener { list, item, position, id ->


            val imageId = when (position) {
                0 -> R.drawable.pepperoni
                1 -> R.drawable.margheritta
                2 -> R.drawable.hawaiian
                else -> R.drawable.bbq_chicken
            }

            findViewById<ImageView>(R.id.pizza_image).setImageResource(imageId)

        }


    }

    fun radioButtonClick(view: View) {
        if(view == radioButton_medium ){
            priceSize = 9.99
        } else if(view == radioButton_large){
            priceSize = 13.99
        }else if(view == radioButton_XLarge){
            priceSize = 15.99
        }else{
            // none
        }
        calculateTotal()
    }

    fun checkBoxClick(view: View) {

        if (view is CheckBox) {
            val checked: Boolean = view.isChecked
            when (view.id) {
                R.id.extra_cheese ->{
                    if (checked) {
                        priceToppings += 1.69
                    } else {
                        priceToppings -= 1.69
                    }
                }
                R.id.spinach -> {
                    if (checked) {
                        priceToppings += 1.69
                    } else {
                        priceToppings -= 1.69
                    }


                }
                R.id.mushroom -> {
                    if (checked) {
                        priceToppings += 1.69
                    } else {
                        priceToppings -= 1.69
                    }
                }
                R.id.onions -> {
                    if (checked) {
                        priceToppings += 1.69
                    } else {
                        priceToppings -= 1.69
                    }

                }
                R.id.broccoli -> {
                    if (checked) {
                        priceToppings += 1.69
                    } else {
                        priceToppings -= 1.69
                    }

                }
                R.id.tomatoes->{
                    if (checked) {
                        priceToppings += 1.69
                    } else {
                        priceToppings -= 1.69
                    }
                }
                R.id.blackOlives->
                    if (checked) {
                        priceToppings += 1.69
                    } else {
                        priceToppings -= 1.69
                    }
             }
            }

            calculateTotal()
        }

   fun deliverySwitch(view: View){
        if(delivery.isChecked)
        {
            delivery.text ="Yes($2.00)"
            priceDelivery = 2.00
        } else{
            delivery.text = "No($0.00)"
            priceDelivery -= 2.00
        }
        calculateTotal()
    }
    private fun calculateTotal(){
        val totalPrice = priceSize + priceToppings + priceDelivery
        val totalPriceNum:Double = String.format("%.2f", totalPrice).toDouble()

        var total = findViewById(R.id.Total) as TextView
        total.text = "Total Price: $totalPriceNum"
    }
}