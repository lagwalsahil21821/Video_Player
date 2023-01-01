package com.example.video_player

import android.net.Uri
import android.net.Uri.*
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.widget.VideoView
import android.widget.MediaController
import com.example.video_player.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val videoView = findViewById<VideoView>(binding.testView.id)

        //creating MediaController
        val mediaController =  MediaController(this)
        mediaController.setAnchorView(videoView)

        //specify the location of media file
        val uri: Uri = parse(
            "android.resource://" + packageName
                    + "/raw/farewell"
        )

        //setting MediaController and URI, then starting the videoView
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()   //immediate start

    }


}