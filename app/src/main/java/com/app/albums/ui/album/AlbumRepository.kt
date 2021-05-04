package com.app.albums.ui.album

import java.io.File

/**
 * Interface to fetch data from repository i.e. remote service or local database.
 */
interface AlbumRepository {
    suspend fun getAlbumData(cacheDirectory: File): List<Album?>
}

/**
 * Implementation class for [AlbumRepository]
 */
class RepositoryImpl : AlbumRepository{

    override suspend fun getAlbumData(cacheDirectory: File): List<Album?> {
        return RemoteDataSource.createService(cacheDirectory).getAlbums()
    }

}