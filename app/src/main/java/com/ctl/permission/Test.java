//package com.ctl.permission;
//
//
//import androidx.annotation.NonNull;
//import androidx.core.app.ActivityCompat;
//
//import com.ctl.permission_library.listener.PermissionRequest;
//import com.ctl.permission_library.listener.RequestPermission;
//import com.ctl.permission_library.utils.PermissionUtils;
//
//import java.lang.ref.WeakReference;
//
//public class MainActivity$Permissions implements RequestPermission<com.ctl.permission.MainActivity> {
//    private static final int REQUEST_CODE = 666;
//    private static String[] PERMISSIONS;
//
//    public void requestPermission(com.ctl.permission.MainActivity target, String[] permissions) {
//        PERMISSIONS = permissions;
//        if (PermissionUtils.hasSelfPermissions(target, PERMISSIONS)) {
//            target.showCamera();
//        } else if (PermissionUtils.shouldShowRequestPermissionRationale(target, PERMISSIONS)) {
//            target.showRationaleForCamera(new PermissionRequestImpl(target));
//        } else {
//            ActivityCompat.requestPermissions(target, PERMISSIONS, REQUEST_CODE);
//        }
//    }
//
//    public void onRequestPermissionsResult(com.ctl.permission.MainActivity target, int requestCode, @NonNull int[] grantResults) {
//        switch (requestCode) {
//            case REQUEST_CODE:
//                if (PermissionUtils.verifyPermissions(grantResults)) {
//                    target.showCamera();
//                } else if (!PermissionUtils.shouldShowRequestPermissionRationale(target, PERMISSIONS)) {
//                    target.showNeverAskForCamera();
//                } else {
//                    target.showDeniedForCamera();
//                }
//                break;
//            default:
//                break;
//        }
//    }
//
//    private static final class PermissionRequestImpl implements PermissionRequest {
//        private final WeakReference<com.ctl.permission.MainActivity> weakTarget;
//
//        private PermissionRequestImpl(com.ctl.permission.MainActivity target) {
//            this.weakTarget = new WeakReference(target);
//        }
//
//        public void proceed() {
//            com.ctl.permission.MainActivity target = (com.ctl.permission.MainActivity) this.weakTarget.get();
//            if (target != null) {
//                ActivityCompat.requestPermissions(target, PERMISSIONS, REQUEST_CODE);
//            }
//        }
//    }
//
//}
