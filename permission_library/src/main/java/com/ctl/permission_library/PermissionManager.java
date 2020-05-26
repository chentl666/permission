package com.ctl.permission_library;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.ctl.permission_library.listener.RequestPermission;

/**
 * created by : chentl
 * Date: 2020/05/25
 */
public class PermissionManager {

    /*
     * 请求权限
     */
    public static void request(Activity activity, String[] permissions) {
        String classname = activity.getClass().getName() + "$Permissions";
        try {
            Class<?> aClass = Class.forName(classname);
            RequestPermission requestPermission = (RequestPermission) aClass.newInstance();
            requestPermission.requestPermission(activity, permissions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void onRequestPermissionsResult(Activity activity, int requestCode, @NonNull int[] grantResults) {
        String className = activity.getClass().getName() + "$Permissions";

        try {
            Class<?> clazz = Class.forName(className);
            RequestPermission rPermission = (RequestPermission) clazz.newInstance();
            rPermission.onRequestPermissionsResult(activity, requestCode, grantResults);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
