package ir.arefdev.crashreporter.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.Log;

import java.util.TimeZone;
import java.util.UUID;

public class AppUtils {

	private static String getCurrentLauncherApp(Context context) {
		String str = "";
		PackageManager localPackageManager = context.getPackageManager();
		Intent intent = new Intent("android.intent.action.MAIN");
		intent.addCategory("android.intent.category.HOME");
		try {
			ResolveInfo resolveInfo = localPackageManager.resolveActivity(intent,
					PackageManager.MATCH_DEFAULT_ONLY);
			if (resolveInfo != null && resolveInfo.activityInfo != null) {
				str = resolveInfo.activityInfo.packageName;
			}
		} catch (Exception e) {
			Log.e("AppUtils", "Exception : " + e.getMessage());
		}
		return str;
	}

	public static String getDeviceDetails(Context context) {
		return "Device Information\n"
				+ "\nDEVICE.ID : " + getDeviceId(context)
				+ "\nAPP.VERSION_NAME : " + getAppVersionName(context)
				+ "\nAPP.VERSION_CODE : " + getAppVersionCode(context)
				+ "\nLAUNCHER.APP : " + getCurrentLauncherApp(context)
				+ "\nTIMEZONE : " + timeZone()
				+ "\nVERSION.RELEASE : " + Build.VERSION.RELEASE
				+ "\nVERSION.INCREMENTAL : " + Build.VERSION.INCREMENTAL
				+ "\nVERSION.SDK.NUMBER : " + Build.VERSION.SDK_INT
				+ "\nBOARD : " + Build.BOARD
				+ "\nBOOTLOADER : " + Build.BOOTLOADER
				+ "\nBRAND : " + Build.BRAND
				+ "\nCPU_ABI : " + Build.CPU_ABI
				+ "\nCPU_ABI2 : " + Build.CPU_ABI2
				+ "\nDISPLAY : " + Build.DISPLAY
				+ "\nFINGERPRINT : " + Build.FINGERPRINT
				+ "\nHARDWARE : " + Build.HARDWARE
				+ "\nHOST : " + Build.HOST
				+ "\nID : " + Build.ID
				+ "\nMANUFACTURER : " + Build.MANUFACTURER
				+ "\nMODEL : " + Build.MODEL
				+ "\nPRODUCT : " + Build.PRODUCT
				+ "\nSERIAL : " + Build.SERIAL
				+ "\nTAGS : " + Build.TAGS
				+ "\nTIME : " + Build.TIME
				+ "\nTYPE : " + Build.TYPE
				+ "\nUNKNOWN : " + Build.UNKNOWN
				+ "\nUSER : " + Build.USER;
	}

	private static String timeZone() {
		TimeZone tz = TimeZone.getDefault();
		return tz.getID();
	}

	private static String getDeviceId(Context context) {
		String androidDeviceId = getAndroidDeviceId(context);
		if (androidDeviceId == null)
			androidDeviceId = UUID.randomUUID().toString();
		return androidDeviceId;

	}

	private static String getAndroidDeviceId(Context context) {
		final String INVALID_ANDROID_ID = "UNKNOWN";
		final String androidId = android.provider.Settings.Secure.getString(
				context.getContentResolver(),
				android.provider.Settings.Secure.ANDROID_ID);
		if (androidId == null || androidId.toLowerCase().equalsIgnoreCase(INVALID_ANDROID_ID)) {
			return null;
		}
		return androidId;
	}

	private static String getAppVersionName(Context context) {
		try {
			PackageInfo packageInfo = context.getPackageManager()
					.getPackageInfo(context.getPackageName(), 0);
			return packageInfo.versionName;
		} catch (PackageManager.NameNotFoundException e) {
			return "UNKNOWN";
		}
	}

	private static int getAppVersionCode(Context context) {
		try {
			PackageInfo packageInfo = context.getPackageManager()
					.getPackageInfo(context.getPackageName(), 0);
			return packageInfo.versionCode;
		} catch (PackageManager.NameNotFoundException e) {
			return -1;
		}
	}
}
