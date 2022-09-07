package com.bhaskar.internetcheck

/**
 * Connectivity change callback listener
 */
interface InternetCheckListener {
    fun onInternetGone()
    fun onInternetActive()
}