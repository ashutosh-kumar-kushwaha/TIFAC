package `in`.silive.tifac.croppedImageView

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView

class CropImageView(context: Context, attrs: AttributeSet?=null, defStyleAttr: Int = 0) : AppCompatImageView(context, attrs, defStyleAttr) {
    override fun onDraw(canvas: Canvas?) {
        val drawable = drawable
        if(drawable == null){
            super.onDraw(canvas)
            return
        }

        val croppedDrawable = CroppedDrawable(drawable, height/8)
        croppedDrawable.bounds = drawable.bounds
        canvas?.let { croppedDrawable.draw(it) }
    }
}