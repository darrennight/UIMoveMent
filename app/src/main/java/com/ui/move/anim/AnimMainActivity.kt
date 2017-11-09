package com.ui.move.anim

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.ui.move.R
import kotlinx.android.synthetic.main.activity_anim_main.*

/**
 * TODO
 * @author zenghao
 * @since 2017/11/7 下午3:06
 *
 * http://www.jianshu.com/p/98f2ec280945
 * https://github.com/andkulikov/Transitions-Everywhere
 *
 * 位移 缩放 渐入渐出 改变颜色 大小变化(ChangeBounds) 旋转  更换文本
 */
class AnimMainActivity :AppCompatActivity(){

  private val list = ArrayList<String>()
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_anim_main)
    addItems()
    lv_anims.adapter = MyAnimAdapter(list)

    lv_anims.setOnItemClickListener { parent, view, position, id ->
      when(position){
        0->{
          startActivity(Intent(this@AnimMainActivity,WidgetMoveActivity::class.java))
        }
        1->{
          startActivity(Intent(this@AnimMainActivity,WidgetSildeActivity::class.java))
        }
        2->{
          startActivity(Intent(this@AnimMainActivity,WidgetPathActivity::class.java))
        }
        3->{
          startActivity(Intent(this@AnimMainActivity,FadeScaleActivity::class.java))
        }

        4->{
          startActivity(Intent(this@AnimMainActivity,RecolorActivity::class.java))
        }

        5->{
          startActivity(Intent(this@AnimMainActivity,RotateActivity::class.java))
        }

        6->{
          startActivity(Intent(this@AnimMainActivity,ChangeTextActivity::class.java))
        }

        else ->{

        }
      }
    }
  }

  private fun addItems(){
    list.add("0隐藏显示移动")
    list.add("1滑行")
    list.add("2path")
    list.add("3fade_scale")
    list.add("4变颜色")
    list.add("5旋转")
    list.add("6change文字")
  }




  inner class MyAnimAdapter(var list:ArrayList<String>) :BaseAdapter(){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

      var holder:AnimHolder? = null
      var view:View ? = null

      if(convertView == null){

        view = LayoutInflater.from(this@AnimMainActivity).inflate(R.layout.item_anim_main,parent,false)
        holder = AnimHolder()
        holder?.txt = view.findViewById(R.id.tv_text) as TextView
        view.tag = holder
      }else{

        view = convertView
        holder = view?.tag as AnimHolder
      }

      holder?.txt?.text = list[position]

      return view!!
    }

    override fun getItem(position: Int): Any {
      return list[position]
    }

    override fun getItemId(position: Int): Long {
     return position.toLong()
    }

    override fun getCount(): Int {
      return list.size
    }

    inner class AnimHolder{
      var txt:TextView? = null

    }
  }
}