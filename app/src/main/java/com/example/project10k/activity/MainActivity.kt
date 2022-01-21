package com.example.project10k.activity

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.project10k.R
import com.example.project10k.adapter.CustomAdapter
import com.example.project10k.model.Member
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName.toString()
    private lateinit var context: Context
    private lateinit var members: ArrayList<Member>
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        refreshAdapter(prepareMemberList())

    }

    private fun initViews() {
        context = this
        recyclerView = main_recycler_view

        recyclerView.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL, false
        )

        val snapHelper = PagerSnapHelper() // recycler view as view pager
        snapHelper.attachToRecyclerView(recyclerView)
    }

    private fun refreshAdapter(members: ArrayList<Member>) {
        val customAdapter = CustomAdapter(context, prepareMemberList(), MainActivity())
        recyclerView.adapter = customAdapter
    }

    private fun prepareMemberList(): ArrayList<Member> {
        members = ArrayList()
        for (i in 1..30) members.add(Member("Muhammadrizo$i", "Nurullaxo'jayev$i"))
        return members
    }

    // this fun is for item click
    fun openDetails(position: Int) {
        Log.d(TAG, "openDetails: $position")
    }
}

