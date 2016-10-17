package com.zl.dafeng.ui.base;


import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity管理器，用于维护当前内存中存在的Activity，以及负责Activity的全部销毁等功能。
 * 
 */
public class ActivityCollector {

	public static final String TAG = "ActivityCollector";

	/**
	 * 持有当前内存中所有Activity的集合。
	 */
	private static List<Activity> activities = new ArrayList<Activity>();

	/**
	 * 向Activity的集合中添加一个新的Activity，一般在Activity的onCreate方法中调用。
	 * 
	 * @param activity
	 *            新创建的Activity。
	 */
	public static void add(Activity activity) {
		if (activity != null) {
			activities.add(activity);
		}
	}

	/**
	 * 从Activity的集合中删除一个Activity，一般在Activity的onDestroy方法中调用。
	 * 
	 * @param activity
	 *            需要销毁的Activity。
	 * @return 删除成功返回true，否则返回false。
	 */
	public static boolean remove(Activity activity) {
		if (activity != null) {
			return activities.remove(activity);
		}
		return false;
	}

	/**
	 * 销毁当前集合中所有的Activity。
	 */
	public static void finishAll() {
		for (Activity activity : activities) {
			if (!activity.isChild() && !activity.isFinishing()) {
				activity.finish();
			}
		}
	}

	public static void backMainActivity(){
		
		for (int i = 1; i < activities.size(); i++) {
			if (!activities.get(i).isChild() && !activities.get(i).isFinishing()) {
				activities.get(i).finish();
			}
		}
	}
	/**
	 * 获取到栈顶的Activity。
	 */
	public static Activity getTopActivity() {
		if (activities.size() > 0) {
			return activities.get(activities.size() - 1);
		}
		return null;
	}
	
	/**
	 * 获取到栈底的Activity。
	 */
	public static Activity getBottomActivity() {
		return activities.get(0);
	}

	public static List<Activity> getActivities() {
		return activities;
	}

}
