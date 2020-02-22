package com.afkoders.batteryme.presentation.custom

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.graphics.drawable.PaintDrawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.afkoders.batteryme.R


class BatteryView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val displayMetrics by lazy { context.resources.displayMetrics }

    private var radius: Float = 0f

    // Top
    private val topPaint =
        PaintDrawable(ContextCompat.getColor(context, R.color.battery_top_detail))
    private val topRect = Rect()
    private var topPaintWidthPercent = 30
    private var topPaintHeightPercent = 3

    // Border
    private val borderPaint = Paint().apply {
        color = ContextCompat.getColor(context, R.color.battery_body)
        style = Paint.Style.FILL_AND_STROKE
        flags = Paint.ANTI_ALIAS_FLAG
    }
    private val borderRect = RectF()
    private var borderStrokeWidthPercent = 8
    private var borderStroke: Float = 0f

    // Percent
    private val percentPaint = Paint().apply {
        flags = Paint.ANTI_ALIAS_FLAG
    }
    private val percentRect = RectF()
    private var percentRectTopMin = 0f
    private var percent: Int = 0

    private val percentTextPaint = Paint().apply {
        color = ContextCompat.getColor(context, R.color.battery_progress)
        flags = Paint.ANTI_ALIAS_FLAG
        textAlign = Paint.Align.CENTER
        textSize = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP,
            DEFAULT_TEXT_SIZE.toFloat(),
            displayMetrics
        )
        typeface = ResourcesCompat.getFont(context, R.font.rubik_bold)
    }

    init {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.BatteryView)
        try {
            percent = ta.getInt(R.styleable.BatteryView_percentage, 0)
        } finally {
            ta.recycle()
        }
    }

    @SuppressLint("DrawAllocation")
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val measureWidth = getDefaultSize(suggestedMinimumWidth, widthMeasureSpec)
        val measureHeight = (measureWidth * 1.9f).toInt()
        setMeasuredDimension(measureWidth, measureHeight)

        radius = borderStroke / 2
        borderStroke = (borderStrokeWidthPercent * measureWidth).toFloat() / 100

        // Top
        val topLeft = measureWidth * ((100 - topPaintWidthPercent) / 2) / 100
        val topRight = measureWidth - topLeft
        val topBottom = topPaintHeightPercent * measureHeight / 100
        topRect.set(topLeft, 0, topRight, topBottom)

        // Border
        val borderLeft = borderStroke / 2 + borderStrokeWidthPercent * 5
        val borderTop = (topBottom.toFloat() + borderStroke / 2)
        val borderRight = (measureWidth - borderStroke / 2) - borderStrokeWidthPercent * 5
        val borderBottom = (measureHeight - borderStroke / 2)
        borderRect.set(borderLeft, borderTop, borderRight, borderBottom)

        // Progress
        val progressLeft = borderStroke - borderStrokeWidthPercent * 2 + borderStrokeWidthPercent * 5
        percentRectTopMin = topBottom + borderStroke - borderStrokeWidthPercent
        val progressRight = measureWidth - borderStroke + borderStrokeWidthPercent* 2 - borderStrokeWidthPercent * 5
        val progressBottom = measureHeight - borderStroke + borderStrokeWidthPercent
        percentRect.set(progressLeft, percentRectTopMin, progressRight, progressBottom)
    }

    override fun onDraw(canvas: Canvas) {
        drawTop(canvas)
        drawBody(canvas)
        drawProgress(canvas)
        drawProgressText(canvas)
    }

    private fun drawTop(canvas: Canvas) {
        topPaint.bounds = topRect
        topPaint.setCornerRadii(floatArrayOf(radius, radius, radius, radius, 0f, 0f, 0f, 0f))
        topPaint.draw(canvas)
    }

    private fun drawBody(canvas: Canvas) {
        borderPaint.strokeWidth = borderStroke
        canvas.drawRoundRect(borderRect, radius, radius, borderPaint)
    }

    private fun drawProgress(canvas: Canvas) {
        percentPaint.color = getPercentColor()
        percentRect.top =
            percentRectTopMin + (percentRect.bottom - percentRectTopMin) * (100 - percent) / 100
        canvas.drawRoundRect(percentRect, radius + 5, radius + 5, percentPaint)
    }

    private fun drawProgressText(canvas: Canvas) {
        canvas.save()
        canvas.rotate(90f, pivotX, pivotY)
        canvas.drawText(
            "$percent%",
            borderRect.centerX() ,
            borderRect.centerY()+ 20,
            percentTextPaint
        )
        canvas.restore()
    }

    private fun getPercentColor(): Int {
        if (percent >= 90) {
            return ContextCompat.getColor(context, R.color.battery_90)
        }
        if (percent >= 70) {
            return ContextCompat.getColor(context, R.color.battery_70)
        }
        if (percent >= 50) {
            return ContextCompat.getColor(context, R.color.battery_50)
        }
        if (percent >= 20) {
            return ContextCompat.getColor(context, R.color.battery_20)
        }
        return ContextCompat.getColor(context, R.color.battery_20)
    }

    fun update(percent: Int) {
        if (percent > 100 || percent < 0) {
            return
        }
        this.percent = percent
        invalidate()
    }

    fun getCurrentPercentage(): Int {
        return percent
    }

    companion object {
        const val DEFAULT_TEXT_SIZE = 34
    }
}