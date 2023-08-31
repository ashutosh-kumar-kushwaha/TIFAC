package `in`.silive.tifac.common

import android.view.View

object Utils {
    fun View.hide(){
        this.visibility = View.GONE
    }

    fun View.show(){
        this.visibility = View.VISIBLE
    }
}