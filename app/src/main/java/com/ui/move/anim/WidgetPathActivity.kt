package com.ui.move.anim

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.FrameLayout
import com.transitionseverywhere.ArcMotion
import com.transitionseverywhere.ChangeBounds
import com.transitionseverywhere.TransitionManager
import com.ui.move.R
import kotlinx.android.synthetic.main.activity_widget_path.*

/**
 * TODO
 * @author zenghao
 * @since 2017/11/7 下午6:13
 */
class WidgetPathActivity:AppCompatActivity() {

  var flag = false
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_widget_path)


    btn_path_click.setOnClickListener {

      flag = !flag
      var bounds = ChangeBounds()
      bounds.pathMotion = ArcMotion()
      bounds.duration = 500

      TransitionManager.beginDelayedTransition(transitions_container,bounds)

      var params = btn_path_click.layoutParams as FrameLayout.LayoutParams

      if(flag){
        params.gravity = Gravity.LEFT.or(Gravity.TOP)
        params.width = 500
        params.height = 500
      }else{

        params.gravity = Gravity.BOTTOM.or(Gravity.RIGHT)
        params.width = 100
        params.height = 100

      }

      btn_path_click.layoutParams = params
    }

    /*btn_path_click.setOnClickListener {

      flag = !flag
      var bounds = ChangeBounds()
      bounds.pathMotion = ArcMotion()
      bounds.duration = 500

      TransitionManager.beginDelayedTransition(transitions_container,bounds)

      var params = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT,ConstraintLayout.LayoutParams.WRAP_CONTENT)

      if(!flag){
        params.leftToLeft = ConstraintLayout.LayoutParams.LEFT
        params.topToTop = ConstraintLayout.LayoutParams.TOP
      }else{

        params.bottomToBottom = ConstraintLayout.LayoutParams.BOTTOM
        params.rightToRight = ConstraintLayout.LayoutParams.RIGHT

      }

      btn_path_click.layoutParams = params
    }*/
  }
}