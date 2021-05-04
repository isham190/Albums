package com.app.albums.ui.album

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.app.albums.ui.album.utils.TestCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import java.io.File

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class AlbumListViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var albumAPIImpl: RepositoryImpl

    @Mock
    private lateinit var albumAPIObserver: Observer<List<Album?>>

    @Before
    fun setUp() {
    }

    @Test
    fun fetchDataFromServiceSuccess() {
        testCoroutineRule.runBlockingTest {
            doReturn(emptyList<Album>())
                .`when`(albumAPIImpl).getAlbumData(File(""))
            val viewModel = AlbumListViewModel()
            viewModel.albumData.observeForever(albumAPIObserver)
            verify(albumAPIImpl).getAlbumData(File(""))
            verify(albumAPIObserver).onChanged(emptyList<Album>())
            viewModel.albumData.removeObserver(albumAPIObserver)
        }
    }

    @Test
    fun fetchDataFromServiceFailure() {
        testCoroutineRule.runBlockingTest {
            val errorMessage = "Error"
            doThrow(RuntimeException(errorMessage))
                .`when`(albumAPIImpl).getAlbumData(File(""))
            val viewModel = AlbumListViewModel()
            viewModel.albumData.observeForever(albumAPIObserver)
            verify(albumAPIImpl).getAlbumData(File(""))
            verify(albumAPIObserver).onChanged(null)
            viewModel.albumData.removeObserver(albumAPIObserver)
        }
    }
}