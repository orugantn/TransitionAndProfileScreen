package com.omega.myapplication

import android.os.Build
import android.os.Bundle
import android.transition.Transition
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import kotlinx.android.synthetic.main.activity_2.*


class Activity2 : AppCompatActivity() {

    // Extra name for the ID parameter
    val EXTRA_PARAM_ID = "detail:_id"

    // View name of the header image. Used for activity scene transitions
    val VIEW_NAME_HEADER_IMAGE = "detail:header:image"

    // View name of the header title. Used for activity scene transitions
    val VIEW_NAME_HEADER_TITLE = "detail:header:title"

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val value = intent.getIntExtra(EXTRA_PARAM_ID, 0)

        ViewCompat.setTransitionName(imgSource, VIEW_NAME_HEADER_IMAGE)
        ViewCompat.setTransitionName(txtThumb, VIEW_NAME_HEADER_TITLE)

        imgSource.setImageResource(R.drawable.thumb)
        txtThumb.text = "This is a Full Screen Image"

        val transition = window.sharedElementEnterTransition

        val listener = transition.addListener(object: Transition.TransitionListener{
            override fun onTransitionEnd(p0: Transition?) {
                transition.removeListener(this)
            }

            override fun onTransitionResume(p0: Transition?) {
            }

            override fun onTransitionPause(p0: Transition?) {

            }

            override fun onTransitionCancel(p0: Transition?) {
                transition.removeListener(this)
            }

            override fun onTransitionStart(p0: Transition?) {

            }

        })

        imgSource.setOnClickListener {

        }
    }
}
