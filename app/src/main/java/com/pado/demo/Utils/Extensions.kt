package com.pado.demo.Utils

import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.content.ContextWrapper
import android.util.DisplayMetrics
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.view.inputmethod.InputMethodManager.SHOW_IMPLICIT
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

fun EditText.showKeyboard() {
    if (requestFocus()) {
        (getActivity()?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager)
                .showSoftInput(this, SHOW_IMPLICIT)
        setSelection(text.length)
    }
}
fun View.getActivity(): AppCompatActivity?{
    var context = this.context
    while (context is ContextWrapper) {
        if (context is AppCompatActivity) {
            return context
        }
        context = context.baseContext
    }
    return null
}
fun convertDpToPixel(dp: Float, context: Context): Float {
    return dp * (context.getResources().getDisplayMetrics().densityDpi .toFloat() / DisplayMetrics.DENSITY_DEFAULT)
}
fun convertPixelsToDp(px: Float, context: Context): Float {
    return px / (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
}
fun View.visible(boolean: Boolean){
    if (boolean)
         this.visibility=View.VISIBLE
    else
        this.visibility=View.GONE

}
fun showHide(view: View?) {
    view?.visibility = if (view?.visibility == View.VISIBLE){
        View.GONE
    } else{
        View.VISIBLE
    }
}