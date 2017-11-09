package com.ui.move.anim

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.transitionseverywhere.Recolor
import com.transitionseverywhere.TransitionManager
import com.ui.move.R
import com.ui.move.customTransition.RecolorTest
import kotlinx.android.synthetic.main.activity_recolor.*

/**
 * TODO
 * @author zenghao
 * @since 2017/11/8 上午10:38
 */
class RecolorActivity:AppCompatActivity() {

  var flag = false
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_recolor)

    btn_recolor.setOnClickListener {

      flag = !flag
      TransitionManager.beginDelayedTransition(layout_container,
          Recolor())

      btn_recolor.setTextColor(if(flag) ContextCompat.getColor(this@RecolorActivity,R.color.color_black)
      else  ContextCompat.getColor(this@RecolorActivity,R.color.color_white))

      btn_recolor.background = ColorDrawable(if(flag) ContextCompat.getColor(this@RecolorActivity,android.R.color.holo_red_dark)
      else  ContextCompat.getColor(this@RecolorActivity,android.R.color.holo_blue_dark))

    }
  }
}