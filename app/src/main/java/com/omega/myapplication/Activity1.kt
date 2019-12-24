package com.omega.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import kotlinx.android.synthetic.main.activity_1.*

class Activity1 : AppCompatActivity() {

    public val EXTRA_PARAM_ID = "detail:_id"

    // View name of the header image. Used for activity scene transitions
    public val VIEW_NAME_HEADER_IMAGE = "detail:header:image"

    // View name of the header title. Used for activity scene transitions
    public val VIEW_NAME_HEADER_TITLE = "detail:header:title"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

    }

    override fun onStart() {
        super.onStart()

        imgSource.setOnClickListener {
            // Construct an Intent as normal
            // Construct an Intent as normal
            //SDKasld;k
            val intent = Intent(this, Activity2::class.java)
            intent.putExtra(EXTRA_PARAM_ID, 123)


            val imgPair = Pair.create<View, String>(imgSource, VIEW_NAME_HEADER_IMAGE)
            val titlePair = Pair.create<View, String>(txtThumb, VIEW_NAME_HEADER_TITLE)

             val activityOptions: ActivityOptionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this@Activity1,
                    imgPair, titlePair
                )

            // Now we can start the Activity, providing the activity options as a bundle
            // Now we can start the Activity, providing the activity options as a bundle
            ActivityCompat.startActivity(this, intent, activityOptions.toBundle())
        }
    }
}
