package com.example.android.activityscenetransitionbasic

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

/**
 * [android.widget.FrameLayout] which forces itself to be laid out as square.
 */
class SquareFrameLayout @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    FrameLayout(context!!, attrs, defStyleAttr) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        if (widthSize == 0 && heightSize == 0) { // If there are no constraints on size, let FrameLayout measure
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
            // Now use the smallest of the measured dimensions for both dimensions
            val minSize = Math.min(measuredWidth, measuredHeight)
            setMeasuredDimension(minSize, minSize)
            return
        }
        val size: Int
        size =
            if (widthSize == 0 || heightSize == 0) { // If one of the dimensions has no restriction on size, set both dimensions to be the
                // on that does
                Math.max(widthSize, heightSize)
            } else { // Both dimensions have restrictions on size, set both dimensions to be the
                // smallest of the two
                Math.min(widthSize, heightSize)
            }
        val newMeasureSpec = MeasureSpec.makeMeasureSpec(size, MeasureSpec.EXACTLY)
        super.onMeasure(newMeasureSpec, newMeasureSpec)
    }
}