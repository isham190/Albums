package com.app.albums.ui.album

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.fragment.app.testing.withFragment
import androidx.lifecycle.Lifecycle
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class AlbumListFragmentTest {

    @Before
    fun setUp() {
    }

    @Test
    fun onCreateView() {
        val scenario = launchFragmentInContainer<AlbumListFragment>()
        scenario.moveToState(Lifecycle.State.RESUMED)
        assertThat(scenario).isNotNull()
        scenario.withFragment {
            //Assert data binding is successful
            assertThat(this.view).isNotNull()
            assertThat(this.dataBinding).isNotNull()
        }
    }

    @Test
    fun onActivityCreated() {

        val scenario = launchFragmentInContainer<AlbumListFragment>()
        scenario.moveToState(Lifecycle.State.RESUMED)
        assertThat(scenario).isNotNull()

        scenario.withFragment {
            //Assert view model is successfully created
            assertThat(this.viewModel).isNotNull()
        }
    }

    @After
    fun tearDown() {
    }
}