package com.rohitraut.newsapp.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.rohitraut.newsapp.R
import com.rohitraut.newsapp.adapters.NewsAdapter
import com.rohitraut.newsapp.databinding.FragmentArticleBinding
import com.rohitraut.newsapp.databinding.FragmentFavouriteBinding
import com.rohitraut.newsapp.ui.NewsActivity
import com.rohitraut.newsapp.ui.NewsViewModel


class FavouriteFragment : Fragment() {
   lateinit var newsViewModel : NewsViewModel
   lateinit var newsAdapter : NewsAdapter
   lateinit var binding: FragmentFavouriteBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFavouriteBinding.bind(view)

        newsViewModel = (activity as NewsActivity).newsviewModel
        setupFavouriteRecycler()

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article", it)
            }
            findNavController().
            navigate(R.id.action_favouriteFragment_to_articleFragment, bundle)
        }

        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT or  ItemTouchHelper.RIGHT)
        {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ):Boolean{
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val article = newsAdapter.differ.currentList[position]
                newsViewModel.deleteArticle(article)
                Snackbar.make(view, "Removed From Favourites", Snackbar.LENGTH_SHORT).apply {
                    setAction("Undo"){
                        newsViewModel.addFavourites(article)
                    }
                    show()
                }


            }
        }

        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(binding.recyclerFavourites)

        }




    }

    private fun setupFavouriteRecycler(){
        newsAdapter = NewsAdapter()
        binding.recyclerFavourites.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
        }
    }

}