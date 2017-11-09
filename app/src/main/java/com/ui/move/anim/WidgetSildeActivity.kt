package com.ui.move.anim

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.View
import com.ui.move.R
import kotlinx.android.synthetic.main.activity_widget_slide.*

/**
 * TODO
 * @author zenghao
 * @since 2017/11/7 下午5:50
 */
class WidgetSildeActivity:AppCompatActivity() {

  var isFlag = false
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_widget_slide)

    btn_slide_click.setOnClickListener {
      TransitionManager.beginDelayedTransition(transitions_container,Slide(Gravity.RIGHT))
      isFlag = !isFlag
      tv_text_slide.visibility = if (isFlag) View.VISIBLE else View.GONE
    }
  }
}