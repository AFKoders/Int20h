package com.afkoders.batteryme.presentation.custom

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.afkoders.batteryme.R
import com.afkoders.batteryme.utils.extensions.dpToPx

class BatteryMini @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val displayMetrics by lazy { context.resources.displayMetrics }

    // SmallPiece
    private val smallPiecePaint = Paint().apply {
        color = ContextCompat.getColor(context, R.color.battery_body)
        style = Paint.Style.FILL_AND_STROKE
        flags = Paint.ANTI_ALIAS_FLAG
    }

    private val smallPieceRect = RectF()
    private var smallPiecePaintHeightPercent = 40
    private var smallPiecePaintWidthPercent = 3

    // Outer block
    private val outerPaint = Paint().apply {
        color = ContextCompat.getColor(context, R.color.battery_body)
        style = Paint.Style.FILL_AND_STROKE
        flags = Paint.ANTI_ALIAS_FLAG
    }
    private val outerRect = RectF()

    // Progress
    private val progressPaint = Paint().apply {
        flags = Paint.ANTI_ALIAS_FLAG
    }
    private val progressRect = RectF()
    private var progress: Int = 0
    var textSize: Int = 16

    private var progressTextPaint: Paint = Paint().apply {
        color = ContextCompat.getColor(context, R.color.battery_progress)
        flags = Paint.ANTI_ALIAS_FLAG
        textAlign = Paint.Align.CENTER
        textSize = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP,
            this@BatteryMini.textSize.toFloat(),
            displayMetrics
        )
        typeface = ResourcesCompat.getFont(context, R.font.rubik_bold)
    }

    var radius = 4.dpToPx(context).toFloat()
    private var cacheMeasuredWidth: Int = 0

    var innerCoeficient = 4.dpToPx(context).toFloat()

    init {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.BatteryView)
        try {
            progress = ta.getInt(R.styleable.BatteryView_percentage, 0)
            radius = ta.getInt(R.styleable.BatteryView_radius, 4).dpToPx(context).toFloat()
            innerCoeficient = ta.getInt(R.styleable.BatteryView_inner_coeficient, 4).dpToPx(context).toFloat()
            textSize = ta.getInt(R.styleable.BatteryView_text_size, 16)

            progressTextPaint = Paint().apply {
                color = ContextCompat.getColor(context, R.color.battery_progress)
                flags = Paint.ANTI_ALIAS_FLAG
                textAlign = Paint.Align.CENTER
                textSize = TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_SP,
                    this@BatteryMini.textSize.toFloat(),
                    displayMetrics
                )
                typeface = ResourcesCompat.getFont(context, R.font.rubik_bold)
            }
        } finally {
            ta.recycle()
        }
    }

    override fun onDraw(canvas: Canvas) {
        drawTop(canvas)
        drawBody(canvas)
        drawProgress(canvas)
        drawProgressText(canvas)
    }

    private fun drawTop(canvas: Canvas) {
        canvas.drawRoundRect(smallPieceRect, 4.dpToPx(context).toFloat(), 4.dpToPx(context).toFloat(),smallPiecePaint)
    }

    private fun drawBody(canvas: Canvas) {
        canvas.drawRoundRect(outerRect, radius, radius, outerPaint)
    }

    private fun drawProgress(canvas: Canvas) {
        val progressWidth = cacheMeasuredWidth - smallPieceRect.right - 2 * innerCoeficient

        progressPaint.color = getPercentColor()
        progressRect.left = cacheMeasuredWidth - innerCoeficient - progressWidth * progress / 100

        canvas.drawRoundRect(progressRect, radius, radius, progressPaint)
    }

    private fun drawProgressText(canvas: Canvas) {
        canvas.drawText(
            "$progress%",
            outerRect.centerX(),
            outerRect.centerY() + 5.dpToPx(context).toFloat(),
            progressTextPaint
        )
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val measureHeight = getDefaultSize(suggestedMinimumHeight, heightMeasureSpec)
        val measureWidth = getDefaultSize(suggestedMinimumWidth, widthMeasureSpec)
        cacheMeasuredWidth = if (measuredWidth != 0) measuredWidth else cacheMeasuredWidth
        setMeasuredDimension(measureWidth, measureHeight)

        // Top
        val smallPieceRight = smallPiecePaintWidthPercent * measuredWidth / 100
        val smallPieceTop = measureHeight * ((100 - smallPiecePaintHeightPercent) / 2) / 100
        val smallPieceBottom = measureHeight - smallPieceTop
        smallPieceRect.set(0.0f, smallPieceTop.toFloat(), smallPieceRight.toFloat() + 16.dpToPx(context).toFloat(), smallPieceBottom.toFloat())

        // Outer
        val outerLeft = smallPieceRight.toFloat()
        val outerTop = 0.toFloat()
        val outerRight = measuredWidth.toFloat()
        val outerBottom = measureHeight.toFloat()
        outerRect.set(outerLeft, outerTop, outerRight, outerBottom)

        // Progress
        val progressWidth = measuredWidth - smallPieceRight - 2 * innerCoeficient
        val progressLeft = measureWidth - innerCoeficient - progressWidth / progress
        val progressRight = measureWidth - innerCoeficient
        val progressBottom = measureHeight - innerCoeficient
        val progressTop = innerCoeficient
        progressRect.set(progressLeft, progressTop, progressRight, progressBottom)
    }

    private fun getPercentColor(): Int {
        if (progress >= 90) {
            return ContextCompat.getColor(context, R.color.battery_90)
        }
        if (progress >= 70) {
            return ContextCompat.getColor(context, R.color.battery_70)
        }
        if (progress >= 50) {
            return ContextCompat.getColor(context, R.color.battery_50)
        }
        if (progress >= 20) {
            return ContextCompat.getColor(context, R.color.battery_20)
        }
        return ContextCompat.getColor(context, R.color.battery_20)
    }

    fun update(percent: Int) {
        if (percent > 100 || percent < 0) {
            return
        }
        this.progress = percent
        invalidate()
    }

    fun getCurrentPercentage(): Int {
        return progress
    }
}