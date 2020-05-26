package com.ctl.permission_library.listener;

import androidx.annotation.NonNull;

/**
 * created by : chentl
 * Date: 2020/05/25
 */
public interface RequestPermission<T> {
    // 请求权限组
    void requestPermission(T target, String[] permissions);

    // 授权结果返回
    void onRequestPermissionsResult(T target, int requestCode, @NonNull int[] grantResults);
}
