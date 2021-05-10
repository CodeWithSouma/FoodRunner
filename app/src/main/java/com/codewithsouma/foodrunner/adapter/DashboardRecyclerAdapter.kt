package com.codewithsouma.foodrunner.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codewithsouma.foodrunner.R
import com.codewithsouma.foodrunner.model.Restaurants

class DashboardRecyclerAdapter(val context: Context, private val listOfRestaurants: List<Restaurants>) :
    RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>() {

    class DashboardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val restaurantImageView: ImageView = view.findViewById(R.id.imgRestaurantImage)
        val restaurantName: TextView = view.findViewById(R.id.txtRestaurantName)
        val price: TextView = view.findViewById(R.id.txtPrice)
        val favorite: ImageView = view.findViewById(R.id.imgFavorite)
        val rating: TextView = view.findViewById(R.id.txtRating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_dashboard_single_row, parent, false)
        return DashboardViewHolder(view)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val restaurant = listOfRestaurants[position]
        holder.restaurantImageView.setImageResource(restaurant.image)
        holder.restaurantName.text = restaurant.name
        holder.price.text = restaurant.price
        holder.rating.text = restaurant.rating

    }

    override fun getItemCount(): Int {
        return listOfRestaurants.size
    }
}