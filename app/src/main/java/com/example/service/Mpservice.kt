package com.example.service

import android.content.ContentValues.TAG
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log
import java.security.Provider
import java.security.Provider.Service

class Mpservice: android.app.Service() {
    lateinit var mp:MediaPlayer
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mp=MediaPlayer.create(this,R.raw.song)
        mp.isLooping=true
        mp.start()
        return START_NOT_STICKY
        Log.e(TAG, "onDestroy: service start", )
    }

    override fun onDestroy() {
        super.onDestroy()
        mp.stop()
        Log.e(TAG, "onDestroy: service stop", )

    }
}