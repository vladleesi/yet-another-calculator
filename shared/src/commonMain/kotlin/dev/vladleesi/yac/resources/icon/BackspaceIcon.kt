package dev.vladleesi.yac.resources.icon

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Composable
fun rememberBackspace(): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "backspace",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 24.0f,
            viewportHeight = 24.0f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(10.7f, 15.3f)
                quadToRelative(0.275f, 0.275f, 0.7f, 0.275f)
                quadToRelative(0.425f, 0f, 0.7f, -0.275f)
                lineToRelative(1.9f, -1.9f)
                lineToRelative(1.9f, 1.9f)
                quadToRelative(0.275f, 0.275f, 0.7f, 0.275f)
                quadToRelative(0.425f, 0f, 0.7f, -0.275f)
                quadToRelative(0.275f, -0.275f, 0.275f, -0.7f)
                quadToRelative(0f, -0.425f, -0.275f, -0.7f)
                lineTo(15.4f, 12f)
                lineToRelative(1.9f, -1.9f)
                quadToRelative(0.275f, -0.275f, 0.275f, -0.7f)
                quadToRelative(0f, -0.425f, -0.275f, -0.7f)
                quadToRelative(-0.275f, -0.275f, -0.7f, -0.275f)
                quadToRelative(-0.425f, 0f, -0.7f, 0.275f)
                lineTo(14f, 10.6f)
                lineToRelative(-1.9f, -1.9f)
                quadToRelative(-0.275f, -0.275f, -0.7f, -0.275f)
                quadToRelative(-0.425f, 0f, -0.7f, 0.275f)
                quadToRelative(-0.275f, 0.275f, -0.275f, 0.7f)
                quadToRelative(0f, 0.425f, 0.275f, 0.7f)
                lineToRelative(1.9f, 1.9f)
                lineToRelative(-1.9f, 1.9f)
                quadToRelative(-0.275f, 0.275f, -0.275f, 0.7f)
                quadToRelative(0f, 0.425f, 0.275f, 0.7f)
                close()
                moveTo(9f, 19f)
                quadToRelative(-0.5f, 0f, -0.938f, -0.225f)
                quadToRelative(-0.437f, -0.225f, -0.712f, -0.625f)
                lineToRelative(-3.525f, -5f)
                quadToRelative(-0.35f, -0.525f, -0.35f, -1.15f)
                quadToRelative(0f, -0.625f, 0.35f, -1.15f)
                lineToRelative(3.525f, -5f)
                quadToRelative(0.275f, -0.4f, 0.712f, -0.625f)
                quadTo(8.5f, 5f, 9f, 5f)
                horizontalLineToRelative(10f)
                quadToRelative(0.825f, 0f, 1.413f, 0.588f)
                quadTo(21f, 6.175f, 21f, 7f)
                verticalLineToRelative(10f)
                quadToRelative(0f, 0.825f, -0.587f, 1.413f)
                quadTo(19.825f, 19f, 19f, 19f)
                close()
                moveToRelative(-3.55f, -7f)
                lineTo(9f, 17f)
                horizontalLineToRelative(10f)
                verticalLineTo(7f)
                horizontalLineTo(9f)
                close()
                moveTo(19f, 12f)
                verticalLineTo(7f)
                verticalLineToRelative(10f)
                close()
            }
        }.build()
    }
}