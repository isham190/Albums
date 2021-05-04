package com.app.albums.ui.album

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File

/**
 * View model for the Fragment  [AlbumListFragment]
 *
 * @author Muhammed Isham
 */

class AlbumListViewModel : ViewModel() {

    private val TAG = AlbumListViewModel::class.java.simpleName

    private val _albumData = MutableLiveData<List<Album?>>()
    val albumData: LiveData<List<Album?>>
        get() = _albumData

    /**
     * Fetch the data from either cache or API based on the cache expiry.
     *
     * @param cacheDirectory location of the cache directory
     *
     * Cache has been enabled to persist the data for offline usage.
     */
    fun fetchDataFromService(cacheDirectory: File){
        val albumRepository: RepositoryImpl = RepositoryImpl()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                var response = albumRepository.getAlbumData(cacheDirectory)
                //Sort the array based on the title
                response = response.sortedBy { it?.title }
                Log.i(TAG, "fetchDataFromService: $response")
                    _albumData.postValue(response)
            } catch (e: Exception) {
                _albumData.postValue(emptyList())
            }
        }
    }
}