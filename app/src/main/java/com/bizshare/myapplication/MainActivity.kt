package com.bizshare.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log

class MainActivity : AppCompatActivity(), RecyclerViewAdapter.OnItemClicked {
//https://github.com/rakesh2gnit/RecyclerViewKotlin.git
    private val TAG = MainActivity::class.simpleName
    private lateinit var recyclerview : RecyclerView
    private lateinit var layoutmanager : LinearLayoutManager
    private lateinit var adapter: RecyclerViewAdapter
    private val users = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        users.add(User("Your name"))

        recyclerview = findViewById(R.id.recyclerview);
        //val rv = findViewById<RecyclerView>(R.id.recyclerview)
        layoutmanager = LinearLayoutManager(this);
        recyclerview.layoutManager = layoutmanager

        Log.e(TAG, "Size::"+users.size)

        adapter = RecyclerViewAdapter(this, users, this)
        recyclerview.adapter = adapter
    }


    override fun onClick() {
        Log.e(TAG, "Inside onClick")
    }

    override fun onLongClick() {
        Log.e(TAG, "Inside onLongClick")
    }
}
