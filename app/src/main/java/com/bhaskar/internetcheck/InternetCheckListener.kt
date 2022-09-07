package com.bhaskar.internetcheck

interface InternetCheckListener {
    fun onInternetGone()
    fun onInternetActive()
}