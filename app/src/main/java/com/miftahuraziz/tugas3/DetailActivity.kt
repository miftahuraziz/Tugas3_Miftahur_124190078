package com.miftahuraziz.tugas3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.miftahuraziz.tugas3.model.GithubUser
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity: AppCompatActivity() {
    companion object{
        const val EXTRA_GITHUB_USER = "extra_github_user"
    }

    lateinit var githubUser: GithubUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        githubUser = intent.getParcelableExtra<GithubUser>(EXTRA_GITHUB_USER)!!

        supportActionBar?.title = githubUser.username
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        Glide.with(githubAvatar)
            .load(githubUser.avatar)
            .into(githubAvatar)

        githubName.text = githubUser.name
        githubLocation.text = githubUser.location
        githubCompany.text = githubUser.company
        githubRepository.text = githubUser.repository
        githubFollowers.text = githubUser.followers
        githubFollowing.text = githubUser.following
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}