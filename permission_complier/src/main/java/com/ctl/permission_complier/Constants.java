package com.ctl.permission_complier;

/**
 * 常量类
 */
public class Constants {


    // 每个子模块的模块名
    public static final String MODULE_NAME = "moduleName";
    // 包名，用于存放APT生成的类文件
    public static final String APT_PACKAGE = "packageNameForAPT";

    public static final String CLASS_SUFFIX = "$Permissions";
    // String全类名
    public static final String STRING = "java.lang.String";
    // Activity全类名
    public static final String ACTIVITY = "android.app.Activity";

    public static final String ActivityCompat = "androidx.core.app.ActivityCompat";
    public static final String PermissionUtils = "com.ctl.permission_library.utils.PermissionUtils";
    public static final String RequestPermission = "com.ctl.permission_library.listener.RequestPermission";
    public static final String PermissionRequest = "com.ctl.permission_library.listener.PermissionRequest";

}
