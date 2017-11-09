package com.ui.move

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * TODO
 * @author zenghao
 * @since 2017/11/7 上午11:20
 */
class SplashActivity:AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splash)

    btn_go_main.setOnClickListener {
      startActivity(Intent(this@SplashActivity,MainActivity::class.java))
    }
  }
}