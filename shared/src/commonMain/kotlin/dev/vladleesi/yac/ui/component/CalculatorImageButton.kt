package dev.vladleesi.yac.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp


@Composable
fun CalculatorImageButton(
    imageVector: ImageVector,
    tintColor: Color,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .clickable { onClick.invoke() }
            .then(modifier)
    ) {
        Image(
            imageVector = imageVector,
            contentDescription = imageVector.name,
            modifier = Modifier.size(44.dp),
            colorFilter = ColorFilter.tint(tintColor)
        )
    }
}