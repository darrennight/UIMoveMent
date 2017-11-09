package com.ui.move.anim

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.LinearInterpolator
import com.transitionseverywhere.Fade
import com.transitionseverywhere.TransitionManager
import com.transitionseverywhere.TransitionSet
import com.transitionseverywhere.extra.Scale
import com.ui.move.R
import kotlinx.android.synthetic.main.activity_fade_scale.*

/**
 * TODO
 * @author zenghao
 * @since 2017/11/8 上午10:16
 */
class FadeScaleActivity:AppCompatActivity() {

  var flag = true
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_fade_scale)

    btn_fade_click.setOnClickListener {

      flag = !flag

      val Tset = TransitionSet()
      Tset.addTransition(Fade())
      Tset.addTransition(Scale())
      Tset.setInterpolator(LinearInterpolator())
      TransitionManager.beginDelayedTransition(layout_container,Tset)

      tv_test_text.visibility = if(flag) View.VISIBLE else View.INVISIBLE

    }
  }
}