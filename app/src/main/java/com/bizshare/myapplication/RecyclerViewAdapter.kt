package com.bizshare.myapplication

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

/**
 * Created by Rakesh.Kumar on 15-03-2018.
 */
class RecyclerViewAdapter(private val activity: Activity, val userList: ArrayList<User>, val onItemClicked1: OnItemClicked) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    companion object {
        var onItemClicked: OnItemClicked? = null
    }

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return MyViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        onItemClicked = onItemClicked1
        holder.bindItems(userList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener, View.OnLongClickListener {

        fun bindItems(user: User) {
            val textViewName = itemView.findViewById<TextView>(R.id.txtview)
            textViewName.text = user.name

            textViewName.setOnClickListener(this)
            textViewName.setOnLongClickListener(this)
        }

        override fun onClick(v: View?) {
            if (v?.id == R.id.txtview) {
                Log.e("RecyclerViewAdapter", "Inside onClick")
                if (onItemClicked != null)
                    onItemClicked?.onClick()
            }
        }

        override fun onLongClick(v: View?): Boolean {
            if (v?.id == R.id.txtview) {
                Log.e("RecyclerViewAdapter", "Inside onLongClick")
                if (onItemClicked != null)
                    onItemClicked?.onLongClick()
                return true
            }
            return false
        }
    }

    interface OnItemClicked {
        fun onLongClick()
        fun onClick()
    }
}
