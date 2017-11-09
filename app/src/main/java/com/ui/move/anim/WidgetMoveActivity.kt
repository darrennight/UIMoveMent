package com.ui.move.anim

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.TransitionManager
import android.view.View
import com.ui.move.R
import kotlinx.android.synthetic.main.activity_widget_move.*

/**
 * TODO
 * @author zenghao
 * @since 2017/11/7 下午3:59
 */
class WidgetMoveActivity:AppCompatActivity() {

  var isVisi = true
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_widget_move)

    btn_click.setOnClickListener {
      //下面这句加上有动画缓慢效果 不加没有效果 直接移动 隐藏
      TransitionManager.beginDelayedTransition(transitions_container)
      isVisi = !isVisi

      tv_hah.visibility = if (isVisi) View.VISIBLE else View.GONE
    }
  }
}