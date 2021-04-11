package com.miftahuraziz.tugas3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miftahuraziz.tugas3.adapter.ListGithubUserAdapter
import com.miftahuraziz.tugas3.model.GithubUser
import com.miftahuraziz.tugas3.model.UserData

class MainActivity : AppCompatActivity() {
    private lateinit var rvGithubUser: RecyclerView
    private var list: ArrayList<GithubUser> = arrayListOf()
    private var title: String = "Github User's"

    private fun setActionBarTittle(title: String) {
        supportActionBar?.title = title
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTittle(title)

        rvGithubUser = findViewById(R.id.rv_github_user)
        rvGithubUser.setHasFixedSize(true)

        list.addAll(UserData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvGithubUser.layoutManager = LinearLayoutManager(this)
        val listFoodAdapter = ListGithubUserAdapter(list)
        rvGithubUser.adapter = listFoodAdapter
    }
}