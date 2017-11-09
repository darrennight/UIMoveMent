package com.ui.move.anim

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.transitionseverywhere.ChangeText
import com.transitionseverywhere.TransitionManager
import com.ui.move.R
import kotlinx.android.synthetic.main.activity_change_text.*

/**
 * TODO
 * @author zenghao
 * @since 2017/11/8 下午8:36
 */
class ChangeTextActivity:AppCompatActivity() {

  var flag = false
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_change_text)

    tv_change_click.setOnClickListener {

      flag = !flag

      var changeText = ChangeText()
      changeText.changeBehavior = ChangeText.CHANGE_BEHAVIOR_OUT_IN


      TransitionManager.beginDelayedTransition(layout_container,changeText)

      tv_change_click.text = if (flag) "heihei" else "hahah"
    }
  }
}