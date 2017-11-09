package com.ui.move.customTransition

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.transition.Transition
import android.transition.TransitionValues
import android.util.AttributeSet
import android.util.IntProperty
import android.view.ViewGroup
import android.widget.TextView

/**
 * TODO
 * @author zenghao
 * @since 2017/11/8 上午11:00
 *
 * https://github.com/andkulikov/Transitions-Everywhere
 * 将transiton效果动画从源代码copy处理
 */
class RecolorTest :Transition {

  constructor() : super()
  constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)


  companion object {
    const val PROPNAME_BACKGROUND = "android:recolor:background"
    const val PROPNAME_TEXT_COLOR = "android:recolor:textColor"

    var TEXTVIEW_TEXT_COLOR = object :IntProperty<TextView>(""){
      override fun get(`object`: TextView?): Int {
        return 0
      }

      override fun setValue(`object`: TextView?, value: Int) {
        `object`?.setTextColor(value)
      }
    }

  }


  private fun captureValues(transitionValues:TransitionValues?){
    transitionValues?.let {
      transitionValues.values.put(
          PROPNAME_BACKGROUND, transitionValues.view.background)
      if (transitionValues.view is TextView){
        transitionValues.values.put(
            PROPNAME_TEXT_COLOR,(transitionValues.view as TextView).currentTextColor)
      }

    }

  }


  override fun captureStartValues(transitionValues: TransitionValues?) {
    captureValues(transitionValues)
  }

  override fun captureEndValues(transitionValues: TransitionValues?) {
    captureValues(transitionValues)
  }

  override fun createAnimator(sceneRoot: ViewGroup?, startValues: TransitionValues?,
      endValues: TransitionValues?): Animator? {
    if(startValues == null || endValues == null){
      return null
    }

    val view = endValues.view
    var startBackground = startValues.values.get(
        PROPNAME_BACKGROUND) as Drawable
    var endBackground = endValues.values.get(
        PROPNAME_BACKGROUND) as Drawable

    if(startBackground is ColorDrawable && endBackground is ColorDrawable){
      var startColor = startBackground as ColorDrawable
      var endColor = endBackground as ColorDrawable

      if(startColor.color != endColor.color){
        endColor.color = startColor.color
        return ObjectAnimator.ofArgb(endBackground,"color",startColor.color,endColor.color)
      }

    }

    if (view is TextView){

      var start = startValues.values.get(
          PROPNAME_TEXT_COLOR) as Int
      var end = endValues.values.get(
          PROPNAME_TEXT_COLOR) as Int

      if (start != end){
        view.setTextColor(end)
        return ObjectAnimator.ofArgb(view,"textColor",start,end)
      }
    }

    return null
  }
}