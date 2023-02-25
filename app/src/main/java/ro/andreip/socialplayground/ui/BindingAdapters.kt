package ro.andreip.socialplayground.ui

import androidx.databinding.BindingAdapter
import ro.andreip.socialplayground.ui.compose.ButtonComposable

@BindingAdapter("android:onClick")
fun ButtonComposable.setOnClick(onClick: () -> Unit) {
    setOnClick(onClick)
}