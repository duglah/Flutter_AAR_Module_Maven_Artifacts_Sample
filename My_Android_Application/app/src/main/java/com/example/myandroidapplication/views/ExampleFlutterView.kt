package com.example.myandroidapplication.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.FragmentActivity
import io.flutter.embedding.android.FlutterFragment
import io.flutter.embedding.android.RenderMode

class ExampleFlutterView : FrameLayout {

    private val fragmentManager by lazy {
        (context as? FragmentActivity)?.supportFragmentManager
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    override fun onFinishInflate() {
        super.onFinishInflate()
        showFragment()
    }

    private fun showFragment() {
        if (id != View.NO_ID) {
            val fragment = FlutterFragment.withNewEngine()
                .renderMode(RenderMode.texture)
                .build<FlutterFragment>()

            fragmentManager?.beginTransaction()
                ?.replace(id, fragment)
                ?.commit()
        }
    }
}