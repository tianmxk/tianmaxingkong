import android.os.Build;

Build.BOARD //主板
Build.BRAND //android系统定制商
Build.CPU_ABI //cpu指令集
Build.DEVICE //设备参数
Build.DISPLAY //显示屏参数
Build.FINGERPRINT //硬件名称
Build.HOST
Build.ID //修订版本列表
Build.MANUFACTURER //硬件制造商
Build.MODEL //版本
Build.PRODUCT //手机制造商
Build.TAGS //描述build的标签
Build.TIME
Build.TYPE //builder类型
Build.USER

//当前开发代号
Build.VERSION.CODENAME
//源码控制版本号
Build.VERSION.INCREMENTAL
//版本字符串
Build.VERSION.RELEASE
//版本号
Build.VERSION.SDK
//版本号
Build.VERSION.SDK_INT


// 获取当前系统版本号
int currentapiVersion = android.os.Build.VERSION.SDK_INT;



import android.os.SystemClock;

//在当前线程中已运行的时间
SystemClock.currentThreadTimeMillis();
//从开机到现在的毫秒数（手机睡眠(sleep)的时间也包括在内）
SystemClock.elapsedRealtime();
//从开机到现在的毫秒数（手机睡眠的时间不包括在内）
SystemClock.uptimeMillis();
//类似Thread.sleep(100);但是该方法会忽略InterruptedException
SystemClock.sleep(100);
//设置时钟的时间，和System.setCurrentTimeMillis类似
SystemClock.setCurrentTimeMillis(1000);
//时间间隔
longtimeInterval=SystemClock.uptimeMillis()-lastTime;
