package ro.andreip.socialplayground.ui.compose

import androidx.annotation.DimenRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ro.andreip.socialplayground.R

@Composable
fun CustomButton(
    onClick: () -> Unit,
    enabled: Boolean = true,
    text: String = stringResource(id = R.string.default_button_text),
    @DimenRes minHeight: Int = R.dimen.minHeight,
) {
    Button(
        modifier = Modifier
            .defaultMinSize(dimensionResource(id = minHeight))
            .wrapContentWidth(),
        enabled = enabled,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.teal),
            contentColor = Color.White,
            disabledContainerColor = Color.LightGray,
            disabledContentColor = Color.DarkGray
        ),
        onClick = { onClick() },
        contentPadding = PaddingValues(all = 8.dp)
    )
    {
        Text(
            text = text
        )
    }
}

// Enabled button
@Preview
@Composable
fun CustomButtonEnabledPreview() {
    CustomButton(onClick = {})
}


// Disabled button
@Preview
@Composable
fun CustomButtonDisabledPreview() {
    CustomButton(onClick = {}, enabled = false)
}