package com.medialink.kotlincoro

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.medialink.kotlincoro.databinding.ItemUserBinding

class UserAdapter: ListAdapter<Users.Item, UserAdapter.UserViewHolder> (Companion) {
    class UserViewHolder(val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root)

    companion object: DiffUtil.ItemCallback<Users.Item>() {
        override fun areItemsTheSame(oldItem: Users.Item, newItem: Users.Item): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Users.Item, newItem: Users.Item): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(layoutInflater)

        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = getItem(position)
        holder.binding.user = currentUser
        holder.binding.executePendingBindings()
    }

}