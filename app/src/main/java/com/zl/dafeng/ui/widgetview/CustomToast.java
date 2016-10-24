package com.zl.dafeng.ui.widgetview;

import android.content.Context;
import android.widget.Toast;

/**
 * 自定义Toast :多次点击只显示一次
 * 
 * @author tt100_Allen
 * @version [版本号, 2015年8月21日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class CustomToast {

	private static String oldMsg;
	protected static Toast toast = null;
	private static long oneTime = 0;
	private static long twoTime = 0;

	public static void showShortToast(Context context, String s) {
		if (toast == null) {
			toast = Toast.makeText(context, s, Toast.LENGTH_SHORT);
			toast.show();
			oneTime = System.currentTimeMillis();
		} else {
			twoTime = System.currentTimeMillis();
			if (s.equals(oldMsg)) {
				if (twoTime - oneTime > Toast.LENGTH_SHORT) {
					toast.show();
				}
			} else {
				oldMsg = s;
				toast.setText(s);
				toast.show();
			}
		}
		oneTime = twoTime;
	}

	public static void showLongToast(Context context, String s) {
		if (toast == null) {
			toast = Toast.makeText(context, s, Toast.LENGTH_LONG);
			toast.show();
			oneTime = System.currentTimeMillis();
		} else {
			twoTime = System.currentTimeMillis();
			if (s.equals(oldMsg)) {
				if (twoTime - oneTime > Toast.LENGTH_LONG) {
					toast.show();
				}
			} else {
				oldMsg = s;
				toast.setText(s);
				toast.show();
			}
		}
		oneTime = twoTime;
	}

	public static void showShortToast(Context context, int resId) {
		showShortToast(context, context.getString(resId));
	}

	public static void showLongToast(Context context, int resId) {
		showLongToast(context, context.getString(resId));
	}

}
