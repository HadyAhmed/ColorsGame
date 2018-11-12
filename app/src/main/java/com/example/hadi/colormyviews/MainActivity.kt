package com.example.hadi.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.hadi.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Creating Binding Object to handle the findByView()
    // A Layer Between The Layout and views created in the compile time.
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setListeners()
    }

    /**
     * Method to handle the click listeners for the views
     */
    private fun setListeners() {
        val clickableViews = listOf(
            binding.boxOneText,
            binding.boxTwoText,
            binding.boxThreeText,
            binding.boxFourText,
            binding.boxFiveText,
            binding.greenBtn,
            binding.yellowBtn,
            binding.redBtn,
            binding.constraintLayout
        )// List of views id
        for (item in clickableViews) {
            item.setOnClickListener {
                makeColor(it)
            }
        }// adding listeners for the whole list
    }

    /**
     * Handle the view click listener
     * @param view is the view clicked with id
     */
    private fun makeColor(view: View) {
        binding.apply {
            when (view) {
                binding.boxOneText -> view.setBackgroundColor(Color.DKGRAY)
                binding.boxTwoText -> view.setBackgroundColor(Color.GRAY)

                binding.boxThreeText -> view.setBackgroundResource(android.R.color.holo_green_light)
                binding.boxFourText -> view.setBackgroundResource(android.R.color.holo_green_dark)
                binding.boxFiveText -> view.setBackgroundResource(android.R.color.holo_green_light)

                binding.yellowBtn -> view.setBackgroundResource(R.color.yellow_color)
                binding.redBtn -> view.setBackgroundResource(R.color.red_color)
                binding.greenBtn -> view.setBackgroundResource(R.color.green_color)


                else -> view.setBackgroundColor(Color.LTGRAY)
            }
            invalidateAll()
        }
    }
}
