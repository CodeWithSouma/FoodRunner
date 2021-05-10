package com.codewithsouma.foodrunner.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codewithsouma.foodrunner.R
import com.codewithsouma.foodrunner.adapter.DashboardRecyclerAdapter
import com.codewithsouma.foodrunner.model.Restaurants

class DashboardFragment : Fragment() {
    private lateinit var recyclerDashboard: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private val listOfRestaurants = mutableListOf<Restaurants>(
        Restaurants("Pind Tadka","280/person",R.drawable.pind_tadka,"4.5"),
        Restaurants("baco Tell","300/person",R.drawable.baco_tell,"4.4"),
        Restaurants("Five Star","350/person",R.drawable.five_star,"4.7"),
        Restaurants("Garbar","290/person",R.drawable.garbar,"4.6"),
        Restaurants("Lovely Food","280/person",R.drawable.lovely_food,"4.6")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        recyclerDashboard = view.findViewById(R.id.recyclerDashboard)
        layoutManager = LinearLayoutManager(activity)
        recyclerDashboard.layoutManager = layoutManager
        recyclerDashboard.adapter = DashboardRecyclerAdapter(activity as Context, listOfRestaurants)
        return view
    }
}