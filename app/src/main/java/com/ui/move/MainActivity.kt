package com.ui.move

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ui.move.anim.AnimMainActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * TODO
 * @author zenghao
 * @since 2017/11/7 上午11:27
 *
 * Android Transition Framework可以实现三种效果:

  不同Activity之间切换时,Activityc的内容(contentView)转场动画
  不同Activity之间切换时，如果使用了Shared Element动画，也可以使用Transition FrameWork来实现不同的过渡动画效果
  同一个Activity内View变化的过渡动画(Scene)

  作者：DamonZh
  链接：http://www.jianshu.com/p/1b5212d84a15
  來源：简书
  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class MainActivity:AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    btn_go_anim.setOnClickListener {

      startActivity(Intent(this@MainActivity,AnimMainActivity::class.java))
    }

    btn_go_ments.setOnClickListener {
      
    }
  }
}