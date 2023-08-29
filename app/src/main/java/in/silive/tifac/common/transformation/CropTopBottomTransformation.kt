package `in`.silive.tifac.common.transformation

import android.graphics.Bitmap
import coil.size.Size
import coil.transform.Transformation

class CropTopBottomTransformation : Transformation {
    override val cacheKey: String = javaClass.name

    override suspend fun transform(input: Bitmap, size: Size): Bitmap {
        return Bitmap.createBitmap(input, 0, input.height / 8, input.width, (input.height * 0.75).toInt())
    }
}