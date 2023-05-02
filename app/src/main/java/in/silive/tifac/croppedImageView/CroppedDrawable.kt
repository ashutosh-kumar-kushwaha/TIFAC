package `in`.silive.tifac.croppedImageView

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.drawable.Drawable

class CroppedDrawable(private val originalDrawable: Drawable, private val croppedHeight: Int): Drawable() {
    override fun draw(canvas: Canvas) {
        canvas.save()
        canvas.translate(0f, -croppedHeight.toFloat())
        originalDrawable.draw(canvas)
        canvas.restore()
    }

    override fun setAlpha(alpha: Int) {
        originalDrawable.alpha = alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        originalDrawable.colorFilter = colorFilter
    }

    override fun getOpacity(): Int {
        return originalDrawable.opacity
    }
}