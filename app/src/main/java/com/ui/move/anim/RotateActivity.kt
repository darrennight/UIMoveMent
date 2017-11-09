package com.ui.move.anim

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.transitionseverywhere.Rotate
import com.transitionseverywhere.TransitionManager
import com.ui.move.R
import kotlinx.android.synthetic.main.activity_rotate.*

/**
 * TODO
 * @author zenghao
 * @since 2017/11/8 下午8:29
 */
class RotateActivity:AppCompatActivity() {

  var flag = false

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_rotate)

    iv_logo.setOnClickListener {
      flag = !flag

      TransitionManager.beginDelayedTransition(layout_container,Rotate())

      iv_logo.rotation = if (flag) 135f else 0f
    }
  }
}