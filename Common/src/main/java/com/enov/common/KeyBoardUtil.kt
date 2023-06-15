package com.enov.common

import android.app.Activity
import android.app.Instrumentation
import android.content.Context
import android.view.KeyEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * @description 软键盘工具类
 * @author enovira
 * @date 2023.6.15
 */
class KeyBoardUtil {
    companion object {

        fun hideSoftKeyBoard(activity: Activity) {
            val view = activity.window.decorView
            val imm: InputMethodManager = activity.getSystemService(InputMethodManager::class.java)
            imm.hideSoftInputFromWindow(view.windowToken, InputMethodManager.RESULT_HIDDEN)
        }

        fun hideSoftKeyBoard(context: Context, editText: EditText) {
            val imm = context.getSystemService(InputMethodManager::class.java)
            imm.hideSoftInputFromWindow(editText.windowToken, InputMethodManager.RESULT_HIDDEN)
        }

        fun hideSoftKeyBoard() {
            val instrumentation = Instrumentation()
            instrumentation.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK)
        }

        fun openSoftKeyBoard(context: Context, editText: EditText) {
            val imm: InputMethodManager = context.getSystemService(InputMethodManager::class.java)
            imm.showSoftInput(editText, InputMethodManager.RESULT_SHOWN)
        }
    }
}