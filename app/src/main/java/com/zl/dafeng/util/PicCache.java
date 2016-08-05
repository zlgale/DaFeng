package com.zl.dafeng.util;

import android.graphics.Bitmap;

import java.lang.ref.SoftReference;
import java.util.HashMap;

public class PicCache {
	public static HashMap<String, SoftReference<Bitmap>> imageCache = 
									new HashMap<String, SoftReference<Bitmap>>();

	/*
	 * 获取缓存中的图片，可以考虑到sd卡上搜索
	 */
	public static Bitmap loadBitmap(String mark) {
		Bitmap bitmap = null;
		if (imageCache.containsKey(mark)) {
			SoftReference<Bitmap> reference = imageCache.get(mark);
			bitmap = reference.get();
		}
		return bitmap;
	}
	/*
	 * 将图片加入软缓存，可以考虑保存到sd卡上
	 */
	public static void saveBitmap(String mark,Bitmap bitmap){
		imageCache.clear();
		if(bitmap==null){
			return;
		}
		imageCache.put(mark, new SoftReference<Bitmap>(bitmap)); 
       
	}
}
