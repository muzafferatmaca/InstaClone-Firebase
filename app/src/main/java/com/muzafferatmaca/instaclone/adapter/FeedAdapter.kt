package com.muzafferatmaca.instaclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muzafferatmaca.instaclone.databinding.ActivityUploadBinding
import com.muzafferatmaca.instaclone.databinding.RecyclerRowBinding
import com.muzafferatmaca.instaclone.model.Post
import com.squareup.picasso.Picasso

/**
 * Created by Muzaffer Atmaca on 26.05.2022.
 */
class FeedAdapter(private val postList : ArrayList<Post>) : RecyclerView.Adapter<FeedAdapter.PostHolder>(){

    class PostHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return PostHolder(binding)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {

        holder.binding.userEmailTextView.text = postList.get(position).email
        holder.binding.commentTextView.text = postList.get(position).comment
        Picasso.get().load(postList.get(position).downloadUrl).into(holder.binding.postImageView)

    }

    override fun getItemCount(): Int {

        return postList.size
    }

}