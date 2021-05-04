package com.app.albums.ui.album

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.app.albums.R
import com.app.albums.databinding.MainFragmentBinding

/**
 * Fragment which displays list of Albums
 *
 * @author Muhammed Isham
 */

class AlbumListFragment : Fragment() {
    private val TAG = AlbumListViewModel::class.java.simpleName

    companion object {
        fun newInstance() = AlbumListFragment()
    }

    lateinit var viewModel: AlbumListViewModel
    lateinit var dataBinding: MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        dataBinding = DataBindingUtil.inflate<MainFragmentBinding>(inflater, R.layout.main_fragment, container, false)
        dataBinding.lifecycleOwner = this
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AlbumListViewModel::class.java)
        viewModel.fetchDataFromService(requireContext().cacheDir)

        val albumAdapter = RecycleViewBinderAdapter()
        dataBinding.adapter = albumAdapter

        // Observe for the data from fragment View model
        viewModel.albumData.observe(viewLifecycleOwner, Observer {
            Log.e(TAG, "Data received to the Observer: ${it.toString()}")
            it.let(albumAdapter::submitList)
        })
    }
}