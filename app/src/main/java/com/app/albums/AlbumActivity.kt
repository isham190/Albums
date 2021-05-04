package com.app.albums

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.albums.ui.album.AlbumListFragment

/**
 * Container activity for [AlbumListFragment]
 *
 * @author Muhammed Isham
 */
class AlbumActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, AlbumListFragment.newInstance())
                    .commitNow()
        }
    }
}