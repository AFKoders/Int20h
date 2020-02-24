package com.afkoders.batteryme.presentation.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.afkoders.batteryme.R
import com.afkoders.batteryme.utils.extensions.dp
import com.afkoders.batteryme.utils.extensions.sp
import com.afkoders.batteryme.utils.extensions.update


class BatteryView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val topPartRect = RectF()
    private val topPartPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.battery_top_detail)
        style = Paint.Style.FILL_AND_STROKE
    }

    private val bodyRect = RectF()
    private val bodyPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.battery_body)
        style = Paint.Style.FILL_AND_STROKE
    }

    private val progressRect = RectF()
    private val progressPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val progressTextPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.battery_progress)
        textAlign = Paint.Align.CENTER
        typeface = ResourcesCompat.getFont(context, R.font.rubik_bold)
    }

    private val greenColor = ContextCompat.getColor(context, R.color.battery_90)
    private val yellowColor = ContextCompat.getColor(context, R.color.battery_70)
    private val orangeColor = ContextCompat.getColor(context, R.color.battery_50)
    private val redColor = ContextCompat.getColor(context, R.color.battery_20)

    private var startingProgressPosition = 0f
    private var minProgressPosition = 0f
    private val topPartWidthPercent = 5
    private var cornerRadius: Float = 0f
    private var progress: Int = 0


    init {
        parseAttributes(attrs)
    }

    private fun parseAttributes(attrs: AttributeSet?) {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.BatteryView)
        try {
            progress = attributes.getInt(R.styleable.BatteryView_percentage, 0)
            cornerRadius = attributes.getInt(R.styleable.BatteryView_radius, 12)
                .dp(context).toFloat()
            progressTextPaint.textSize = attributes.getInt(R.styleable.BatteryView_textSize, 16)
                .sp(context).toFloat()
        } finally {
            attributes.recycle()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val measureHeight = getDefaultSize(suggestedMinimumHeight, heightMeasureSpec)
        val measureWidth = (measureHeight * 2.3f).toInt()
        setMeasuredDimension(measureWidth, measureHeight)

        measureTopPart(measureWidth, measureHeight)
        measureBodyPart(measureWidth, measureHeight)
        measureProgressPart(measureHeight)
    }

    private fun measureTopPart(measureWidth: Int, measureHeight: Int) {
        val top = measureHeight * ((100 - topPartWidthPercent) / 3) / 100f

        topPartRect.update(
            right = topPartWidthPercent * measureWidth / 100f,
            bottom = measureHeight - top,
            top = top
        )
    }

    private fun measureBodyPart(measureWidth: Int, measureHeight: Int) {
        bodyRect.update(
            left = topPartRect.right / 2,
            right = measureWidth.toFloat(),
            bottom = measureHeight.toFloat()
        )
    }

    private fun measureProgressPart(measureHeight: Int) {
        val bound = (7 * measureHeight) / 100f
        startingProgressPosition = bodyRect.left + bound
        minProgressPosition = bodyRect.right - bound * 4

        progressRect.update(
            top = bodyRect.top + bound,
            bottom = bodyRect.bottom - bound,
            right = bodyRect.right - bound,
            left = startingProgressPosition
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        drawTop(canvas)
        drawBody(canvas)
        drawProgress(canvas)
        drawProgressText(canvas)
    }

    private fun drawTop(canvas: Canvas) {
        canvas.drawRoundRect(topPartRect, cornerRadius, cornerRadius, topPartPaint)
    }

    private fun drawBody(canvas: Canvas) {
        canvas.drawRoundRect(bodyRect, cornerRadius, cornerRadius, bodyPaint)
    }

    private fun drawProgress(canvas: Canvas) {
        progressPaint.color = getColorFromProgress()
        val newPosition = startingProgressPosition + minProgressPosition * (100 - progress) / 100

        progressRect.left = newPosition
        canvas.drawRoundRect(progressRect, cornerRadius / 1.2f, cornerRadius / 1.2f, progressPaint)
    }

    private fun drawProgressText(canvas: Canvas) {
        canvas.drawText(
            "$progress%",
            bodyRect.centerX(),
            bodyRect.centerY() + bodyRect.height() / 12,
            progressTextPaint
        )
    }

    private fun getColorFromProgress(): Int {
        if (progress >= 90) return greenColor
        if (progress >= 70) return yellowColor
        if (progress >= 50) return orangeColor

        return redColor
    }

    fun setProgress(percent: Int) {
        if (percent < 0 || percent > 100) return

        this.progress = percent
        invalidate()
    }

    fun getCurrentPercentage(): Int {
        return progress
    }
}