package com.afkoders.batteryme.utils.extensions

import android.graphics.RectF

/**
 * Set the rectangle's coordinates to the specified values. Note: no range
 * checking is performed, so it is up to the caller to ensure that
 * left <= right and top <= bottom.
 *
 * @param left   The X coordinate of the left side of the rectangle
 * @param top    The Y coordinate of the top of the rectangle
 * @param right  The X coordinate of the right side of the rectangle
 * @param bottom The Y coordinate of the bottom of the rectangle
 */
fun RectF.update(left: Float = -1f, top: Float = -1f, right: Float = -1f, bottom: Float = -1f) {
    if (left != -1f) this.left = left
    if (top != -1f) this.top = top
    if (right != -1f) this.right = right
    if (bottom != -1f) this.bottom = bottom
}