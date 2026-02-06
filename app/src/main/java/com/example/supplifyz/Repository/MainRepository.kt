package com.example.supplifyz.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.supplifyz.Domain.BannerModel
import com.example.supplifyz.Domain.CategoryModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import android.util.Log
import com.google.firebase.FirebaseOptions

class MainRepository {


    private val firebaseDatabase: FirebaseDatabase by lazy {
        val options = FirebaseOptions.Builder()
            .setDatabaseUrl("https://enyusupplify-default-rtdb.asia-southeast1.firebasedatabase.app")
            .setProjectId("enyusupplify")
            .build()
        FirebaseDatabase.getInstance(options)
    }


    fun loadBanner(): LiveData<MutableList<BannerModel>> {
        val liveData = MutableLiveData<MutableList<BannerModel>>()
        val ref = firebaseDatabase.getReference("Banner")
        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<BannerModel>()
                for(childSnapshot in snapshot.children) {
                    val item = childSnapshot.getValue(BannerModel::class.java)
                    item?.let{ list.add(it)}
                }
                liveData.value=list
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
        return liveData

    }

    fun loadCategory(): LiveData<MutableList<CategoryModel>> {
        val liveData = MutableLiveData<MutableList<CategoryModel>>()
        val ref = firebaseDatabase.getReference("Category")
        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<CategoryModel>()
                for(childSnapshot in snapshot.children) {
                    val item = childSnapshot.getValue(CategoryModel::class.java)
                    item?.let{ list.add(it)}
                }

                Log.d("CategoryDebug", "Loaded ${list.size} categories from Firebase")
                for (item in list) {
                    Log.d("CategoryDebug", "Category: ${item.title} (ID: ${item.id})")
                }
                liveData.value=list
            }

            override fun onCancelled(error: DatabaseError) {

                Log.e("CategoryDebug", "Firebase load failed: ${error.message}")
                TODO("Not yet implemented")  // You can remove this TODO if you handle errors differently
            }

        })
        return liveData

    }
}