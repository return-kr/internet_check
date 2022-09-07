package com.bhaskar.internetcheck

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.bhaskar.internetcheck.InternetCheckListener
import com.bhaskar.internetcheck.InternetUtil

/**
 * This is the Broadcast Receiver file which determines the connectivity of internet
 */

class InternetCheckBroadcast(): BroadcastReceiver() {
    private var internetCheckListener: InternetCheckListener? = null

    /**
     * Call for connectivity change callback
     */
    fun addOnInternetChangeListener(internetCheckListener: InternetCheckListener) {
        this.internetCheckListener = internetCheckListener
    }
    override fun onReceive(context: Context?, intent: Intent?) {
        if (InternetUtil.isNetworkAvailable(context)) {
            internetCheckListener?.onInternetActive()
        } else {
            internetCheckListener?.onInternetGone()
        }
    }
}