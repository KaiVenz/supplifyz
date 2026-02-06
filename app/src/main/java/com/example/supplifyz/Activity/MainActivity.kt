package com.example.supplifyz.Activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.supplifyz.R
import com.example.supplifyz.ViewModel.MainViewModel
import com.example.supplifyz.databinding.ActivityMainBinding
import com.bumptech.glide.Glide
import com.example.supplifyz.Adapter.CategoryAdapter

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel= MainViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initBanner()
        initCategory()

    }

    private fun initCategory() {
        binding.progressBarCat.visibility = View.VISIBLE
        viewModel.loadCategory().observeForever {
            binding.recyclerViewCat.layoutManager =
                LinearLayoutManager(
                    this@MainActivity, LinearLayoutManager.HORIZONTAL,
                    false

                )
            binding.recyclerViewCat.adapter=CategoryAdapter(it)
            binding.progressBarCat.visibility=View.GONE
        }
        viewModel.loadCategory()
    }

    private fun initBanner() {
        binding.progressBarBanner.visibility=View.VISIBLE
        viewModel.loadBanner().observeForever {
            Glide.with(this@MainActivity)
                .load(it[0].url)
                .into(binding.banner)
            binding.progressBarBanner.visibility=View.GONE
        }

        viewModel.loadBanner()
    }
}