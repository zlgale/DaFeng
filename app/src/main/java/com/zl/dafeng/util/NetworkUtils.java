package com.zl.dafeng.util;
import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.telephony.TelephonyManager;

import java.util.List;

/**
 * 网络检查的辅助类
 * @author July
 *
 */
public class NetworkUtils
{
	 public static final int NETWORN_WIFI = 1;
	 public static final int NETWORN_MOBILE = 2;
	 public static final int NETWORN_NONE = -1;
	 
//	 private Context mContext = null;
//	 
//	 public NetworkUtils(Context pContext) {
//		 this.mContext = pContext;
//	 }
	
	 public static int getNetworkState(Context context){
	     ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
	
	     //Wifi
	     State state = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
	     if(state == State.CONNECTED||state == State.CONNECTING){
	         return NETWORN_WIFI;
	     }
	
	     //3G
	     state = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
	     if(state == State.CONNECTED||state == State.CONNECTING){
	         return NETWORN_MOBILE;
	     }
	     return NETWORN_NONE;
	 }
	 
	
	 /** 
	  * 网络是否可用 
	  *  
	  * @param context
	  * @return 
	  */  
	 public static boolean isNetworkAvailable(Context context) {  
	     ConnectivityManager connectivity = (ConnectivityManager) context  
	             .getSystemService(Context.CONNECTIVITY_SERVICE);  
	     if (connectivity == null) {  
	     } else {  
	         NetworkInfo[] info = connectivity.getAllNetworkInfo();  
	         if (info != null) {  
	             for (int i = 0; i < info.length; i++) {  
	                 if (info[i].getState() == State.CONNECTED) {
	                     return true;
	                 }
	             }
	         }
	     }
	     return false;
	 }


	 /**
	  * Gps是否打开
	  *
	  * @param context
	  * @return
	  */
	 public static boolean isGpsEnabled(Context context) {
	     LocationManager locationManager = ((LocationManager) context
	             .getSystemService(Context.LOCATION_SERVICE));
	     List<String> accessibleProviders = locationManager.getProviders(true);
	     return accessibleProviders != null && accessibleProviders.size() > 0;
	 }

	 /**
	  * wifi是否打开
	  */
	 public static boolean isWifiEnabled(Context context) {
	     ConnectivityManager mgrConn = (ConnectivityManager) context
	             .getSystemService(Context.CONNECTIVITY_SERVICE);
	     TelephonyManager mgrTel = (TelephonyManager) context
	             .getSystemService(Context.TELEPHONY_SERVICE);
	     return ((mgrConn.getActiveNetworkInfo() != null && mgrConn
	             .getActiveNetworkInfo().getState() == State.CONNECTED) || mgrTel
	             .getNetworkType() == TelephonyManager.NETWORK_TYPE_UMTS);  
	 }  
	
	 /** 
	  * 判断当前网络是否是wifi网络 
	  * if(activeNetInfo.getType()==ConnectivityManager.TYPE_MOBILE) {  
	  *  
	  * @param context 
	  * @return boolean 
	  */  
	 public static boolean isWifi(Context context) {  
	     ConnectivityManager connectivityManager = (ConnectivityManager) context  
	             .getSystemService(Context.CONNECTIVITY_SERVICE);  
	     NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();  
	     if (activeNetInfo != null  
	             && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {  
	         return true;  
	     }  
	     return false;  
	 }  
	
	 /** 
	  * 判断当前网络是否3G网络 
	  *  
	  * @param context 
	  * @return boolean 
	  */  
	 public static boolean is3G(Context context) {  
	     ConnectivityManager connectivityManager = (ConnectivityManager) context  
	             .getSystemService(Context.CONNECTIVITY_SERVICE);  
	     NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();  
	     if (activeNetInfo != null  
	             && activeNetInfo.getType() == ConnectivityManager.TYPE_MOBILE) {  
	         return true;  
	     }  
	     return false;  
	 }  
}
