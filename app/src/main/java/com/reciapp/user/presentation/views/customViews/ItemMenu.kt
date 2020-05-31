package com.reciapp.user.presentation.views.customViews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.reciapp.user.R
import kotlinx.android.synthetic.main.item_main_menu.view.*

/**
 * Created by Jorge Henao on 30/05/20.
 */
class ItemMenu(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {

    private lateinit var title: String
    private var iconResourceId: Int = -1
    private var textColor: Int = -1

    init {
        setView(context)
        setValuesFromView(attrs)
        setInitValuesInView()
    }

    private fun setView(context: Context) {
        LayoutInflater.from(context).inflate(R.layout.item_main_menu, this, true)
    }

    private fun setValuesFromView(attrs: AttributeSet) {
        context.obtainStyledAttributes(attrs, R.styleable.ItemMenu, 0, 0).apply {
            title = getString(R.styleable.ItemMenu_menu_text)
                ?: context.getText(
                    getResourceId(R.styleable.ItemMenu_menu_text, R.string.general_empty)
                ).toString()

            iconResourceId = getResourceId(R.styleable.ItemMenu_menu_image, -1)

            textColor = getResourceId(R.styleable.ItemMenu_menu_text_color, -1)

            recycle()
        }
    }

    private fun setInitValuesInView() {
        txvMenuTitle.text = title
        if (iconResourceId != -1) imvMenuIcon.setImageResource(iconResourceId)
        if (textColor == -1)
            txvMenuTitle.setTextColor(ContextCompat.getColor(context, R.color.black900))
        else
            txvMenuTitle.setTextColor(ContextCompat.getColor(context, textColor))
    }

    fun setText(text: String) {
        txvMenuTitle.text = text
    }
}
