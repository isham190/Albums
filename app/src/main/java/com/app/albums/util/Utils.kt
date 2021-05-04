package com.app.albums.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

/**
 * Finds whether internet capability is available
 *
 * @param [context] context
 * @return connectivity status
 */
fun isConnectedToNetwork(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworks = connectivityManager.activeNetwork

    val capabilities = connectivityManager.getNetworkCapabilities(activeNetworks)
    return capabilities != null && capabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
}