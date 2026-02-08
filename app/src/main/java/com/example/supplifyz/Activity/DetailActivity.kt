package com.example.supplifyz.Activity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.supplifyz.Adapter.PicsAdapter
import com.example.supplifyz.Domain.ItemsModel
import com.example.supplifyz.R
import com.example.supplifyz.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    private lateinit var item: ItemsModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bundle()


    }

    private fun bundle() {
        binding.apply {
            item = intent.getSerializableExtra("object") as ItemsModel

            val imageUrl = item.thumbnail
            Log.d("ImageDebug", "Image URL: '$imageUrl', Length: ${imageUrl.length}")

            Glide.with(this@DetailActivity)
                .load(item.thumbnail)
                .into(binding.img)

            titleTXT.text = item.title
            descriptionTXT.text = item.description
            priceTXT.text = "₱" + item.price
            ratingTXT.text = item.rating.toString()

            backBTN.setOnClickListener { finish() }
        }
    }
}