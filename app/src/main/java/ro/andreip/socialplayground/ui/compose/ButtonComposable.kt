package ro.andreip.socialplayground.ui.compose

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.DimenRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import ro.andreip.socialplayground.R

class ButtonComposable @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ButtonComposeView(context, attrs, defStyleAttr) {

    private val onClick = mutableStateOf({})
    private val enabled = mutableStateOf(false)
    private val text = mutableStateOf("")

    @DimenRes
    private val minHeight = mutableStateOf(R.dimen.minHeight)

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ComposableSecondaryButton, 0, 0
        ).apply {
            text.value = getString(R.styleable.ComposableSecondaryButton_android_text) ?: text.value
            enabled.value = getBoolean(R.styleable.ComposableSecondaryButton_android_enabled, false)
            minHeight.value = getResourceId(
                R.styleable.ComposableSecondaryButton_android_minHeight,
                -1
            ).takeUnless { it == -1 } ?: minHeight.value
        }
        setContent {
            val onClickState by onClick
            val enabledState by enabled
            val textState by text
            val minHeightState by minHeight
            CustomButton(onClickState, enabledState, textState, minHeightState)
        }
    }


    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        this.enabled.value = enabled
    }

    fun setOnClick(onClick: () -> Unit) {
        this.onClick.value = onClick
    }

}