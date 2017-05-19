package com.ron.fp.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

public final class ViewUtil {

    public static float pxToDp(float px) {
        float densityDpi = Resources.getSystem().getDisplayMetrics().densityDpi;
        return px / (densityDpi / 160f);
    }

    public static int dpToPx(int dp) {
        float density = Resources.getSystem().getDisplayMetrics().density;
        return Math.round(dp * density);
    }
    
    /** It prevents the keyboard from popping. It's useful to be called at onCreate()
     * @see http://stackoverflow.com/questions/2892615/how-to-remove-auto-focus-keyboard-popup-of-a-field-when-the-screen-shows-up/4454195#4454195
     */
    public static void preventKeyPoppingKeyboard(Activity activity) {
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    /**
     * Hides the keyboard. BEWARE THE ALIEN! It don't prevent it from popping up.
     */
    public static void hideKeyboard(Context ctx, View v) {
        try {
            InputMethodManager imm = (InputMethodManager) ctx.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        } catch (Exception e) {
            Log.e("ERROR", "hideKeyboard()", e);
        }
    }

    /**
     * Hides the keyboard. BEWARE THE ALIEN! It don't prevent it from popping up.
     */
    public static void hideKeyboard(Activity a) {
        try {
            InputMethodManager imm = (InputMethodManager) a.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(a.getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            Log.e("ERROR", "hideKeyboard()", e);
        }
    }

    public static void showKeyboard(Context ctx) {
        try {
            InputMethodManager imm = (InputMethodManager) ctx.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {
            Log.e("ERROR", "showKeyboard()", e);
        }
    }

    public static boolean isSoftKeyboardShowing(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        return inputMethodManager.isActive();
    }

}
