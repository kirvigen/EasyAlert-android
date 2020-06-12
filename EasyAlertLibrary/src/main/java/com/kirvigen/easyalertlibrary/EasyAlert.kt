package com.kirvigen.easyalertlibrary


import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlinx.android.synthetic.main.alert.*
import kotlinx.android.synthetic.main.alert.view.*



class EasyAlert (context: Context): Dialog(context) {

    var inputText:String = ""
    private val mView: View = LayoutInflater.from(context).inflate(R.layout.alert, null, false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(mView)

    }
    fun setTitle(t:String):EasyAlert{
        mView.title.visibility = View.VISIBLE
        mView.title.text = t
        return this
    }
    fun setTextBody(t:String):EasyAlert{
        mView.text.visibility = View.VISIBLE
        mView.text.text = t
        return this
    }
    fun setEditText(hint:String, listener: ((String) -> Unit)? = null):EasyAlert{
        mView.editBlock.visibility = View.VISIBLE
        mView.editText.hint = hint
        mView.editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                inputText = charSequence.toString()
                listener?.let { it(charSequence.toString()) }
            }
            override fun afterTextChanged(editable: Editable) {}
        })
        return this
    }
    fun setNeutral(text:String,a:(EasyAlert)->Unit,
                   color:Int = context.resources.getColor(R.color.GrayLight)):EasyAlert{
        mView.neutral.setTextColor(color)
        mView.neutral.visibility = View.VISIBLE
        mView.neutral.text = text
        mView.neutral.setOnClickListener{a(this)}
        return this
    }
    fun setNegative(text:String,a:(EasyAlert)->Unit):EasyAlert{
        mView.negative.visibility = View.VISIBLE
        mView.negative_text.text = text
        mView.negative.setOnClickListener{a(this)}
        return this
    }
    fun setPositive(text:String,a:(EasyAlert)->Unit):EasyAlert{
        mView.positive.visibility = View.VISIBLE
        mView.positive_text.text = text
        mView.positive.setOnClickListener{a(this)}
        return this
    }
    fun setTopImage(obj:Any):EasyAlert{
        if(obj::class == Int::class){
            mView.topImage.visibility = View.VISIBLE
            mView.topImage.setImageResource(obj as Int)
        }else if(obj.javaClass == String::class.java){
            mView.topImage.visibility = View.VISIBLE
            Glide.with(context).load(obj as String).placeholder(R.color.GrayLight)
                .transition(DrawableTransitionOptions.withCrossFade()).into(mView.topImage)
        }
        return this
    }
    fun setListItems(data:Array<String>,itemClick:(EasyAlert,Int)->Unit):EasyAlert{
        mView.recycler.visibility = View.VISIBLE
        mView.recycler.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        val adapter = AdapterList(data){pos->
            itemClick(this,pos)
        }
        mView.recycler.adapter = adapter
        return this
    }
}