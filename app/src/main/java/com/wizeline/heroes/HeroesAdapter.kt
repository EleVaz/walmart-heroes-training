package com.wizeline.heroes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.wizeline.heroes.databinding.ItemHeroesBinding


class HeroesAdapter : ListAdapter<Result, HeroesAdapter.HeroesViewHolder>(HEROESCOMPARATOR) {
    object HEROESCOMPARATOR : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

    }

    //Quitar la responsabilidad de este metodo (inflar)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        val binding = ItemHeroesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeroesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }


    class HeroesViewHolder(private val binding: ItemHeroesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(hero: Result) = with(binding) {
            val number = hero.comics.available
            tvName.text = hero.name
            tvDescrip.text = hero.description
            tvCuantity.text = binding.root.context.getString(R.string.comic_available, number)
            Glide.with(binding.root.context)
                .load("${hero.thumbnail.path}.${hero.thumbnail.extension}")
                .into(image)
                //.error(R.drawable.ic_launcher_foreground)
        }
    }
}