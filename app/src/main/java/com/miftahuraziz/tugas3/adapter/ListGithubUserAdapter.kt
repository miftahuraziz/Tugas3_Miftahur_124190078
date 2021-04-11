package com.miftahuraziz.tugas3.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.miftahuraziz.tugas3.DetailActivity
import com.miftahuraziz.tugas3.R
import com.miftahuraziz.tugas3.model.GithubUser

class ListGithubUserAdapter(private val listGithubUser: ArrayList<GithubUser>): RecyclerView.Adapter<ListGithubUserAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_github_user, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listGithubUser.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val githubUser = listGithubUser[position]
        Glide.with(holder.itemView.context)
            .load(githubUser.avatar)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)

        holder.tvUsername.text = githubUser.username
        holder.tvDetail.text = githubUser.company

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_GITHUB_USER, githubUser)
            it.context.startActivity(intent)
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvUsername: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}