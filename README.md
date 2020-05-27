# permission
权限管理

## Installing
```gradle
allprojects {
 repositories {
    jcenter()
    maven { url "https://jitpack.io" }
 }
}
```
and:

```gradle
dependencies {
    implementation 'com.github.chentl666.permission:permission_library:1.0.0'
    implementation 'com.github.chentl666.permission:permission_annotations:1.0.0'
    annotationProcessor 'com.github.chentl666.permission:permission_complier:1.0.0'
}
```

## About coding
```java
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
```
