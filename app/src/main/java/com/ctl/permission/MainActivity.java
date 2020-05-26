package com.ctl.permission;

import android.Manifest;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.ctl.permission_annotations.OnPermissionNeeds;
import com.ctl.permission_annotations.OnPermissionNeverAskAgain;
import com.ctl.permission_annotations.OnPermissionDenied;
import com.ctl.permission_annotations.OnPermissionShowRationale;
import com.ctl.permission_library.PermissionManager;
import com.ctl.permission_library.listener.PermissionRequest;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void requestPermission(View view) {
        PermissionManager.request(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE});
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.e(TAG, "onRequestPermissionsResult()");
        PermissionManager.onRequestPermissionsResult(this, requestCode, grantResults);
    }


    // 在需要获取权限的地方注释（授权通过之后的执行代码！！！）
    @OnPermissionNeeds()
    void showCamera() {
        Log.e(TAG, "showCamera()");
    }

    // 提示用户为何要开启权限
    @OnPermissionShowRationale()
    void showRationaleForCamera(final PermissionRequest request) {
        Log.e(TAG, "showRationaleForCamera()");
        new AlertDialog.Builder(this)
                .setMessage("提示用户为何要开启权限")
                .setPositiveButton("知道了", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        // 再次执行权限请求
                        request.proceed();
                    }
                })
                .show();
    }

    // 用户选择拒绝时的提示
    @OnPermissionDenied()
    void showDeniedForCamera() {
        Log.e(TAG, "showDeniedForCamera()");
    }

    // 用户选择不再询问后的提示
    @OnPermissionNeverAskAgain()
    void showNeverAskForCamera() {
        Log.e(TAG, "showNeverAskForCamera()");
        new AlertDialog.Builder(this)
                .setMessage("用户选择不再询问后的提示")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Log.e(TAG, "showNeverAskForCamera() >>> Dialog");
                    }
                })
                .show();
    }

}
