package com.mob.tools.utils;

import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.fimi.soul.biz.camera.C2427e;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.mob.tools.MobLog;
import com.tencent.open.GameAppOperation;
import com.tencent.p227mm.sdk.platformtools.LocaleUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p051m.p052a.C0477f;
/* loaded from: classes.dex */
public class DeviceHelper {
    private static DeviceHelper deviceHelper;
    private Context context;

    /* loaded from: classes.dex */
    private class GSConnection implements ServiceConnection {
        boolean got;
        private final BlockingQueue<IBinder> iBinders;

        private GSConnection() {
            this.got = false;
            this.iBinders = new LinkedBlockingQueue();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.iBinders.put(iBinder);
            } catch (Throwable th) {
                MobLog.getInstance().m5959w(th);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        public IBinder takeBinder() {
            if (this.got) {
                throw new IllegalStateException();
            }
            this.got = true;
            return this.iBinders.poll(1500L, TimeUnit.MILLISECONDS);
        }
    }

    private DeviceHelper(Context context) {
        this.context = context.getApplicationContext();
    }

    private String genDeviceKey() {
        try {
            String macAddress = getMacAddress();
            String deviceId = getDeviceId();
            return Data.byteToHex(Data.SHA1(macAddress + ":" + deviceId + ":" + getModel()));
        } catch (Throwable th) {
            MobLog.getInstance().m5971d(th);
            return null;
        }
    }

    private String getCurrentNetworkHardwareAddress() {
        byte[] hardwareAddress;
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        if (networkInterfaces == null) {
            return null;
        }
        for (NetworkInterface networkInterface : Collections.list(networkInterfaces)) {
            Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
            if (inetAddresses != null) {
                for (InetAddress inetAddress : Collections.list(inetAddresses)) {
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address) && (hardwareAddress = networkInterface.getHardwareAddress()) != null) {
                        StringBuilder sb = new StringBuilder();
                        int length = hardwareAddress.length;
                        for (int i = 0; i < length; i++) {
                            sb.append(String.format("%02x:", Byte.valueOf(hardwareAddress[i])));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        return sb.toString();
                    }
                }
                continue;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002f A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String getDeviceKeyWithDuid(String str) {
        HashMap hashMap;
        HashMap hashMap2;
        String str2;
        File file;
        ObjectInputStream objectInputStream;
        try {
            file = new File(ResHelper.getCacheRoot(this.context), str);
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
        }
        if (file.exists() && file.isFile()) {
            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(file));
                try {
                    hashMap = (HashMap) objectInputStream.readObject();
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Throwable th2) {
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    MobLog.getInstance().m5959w(th);
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                            hashMap = null;
                        } catch (Throwable th4) {
                            hashMap = null;
                        }
                        if (hashMap != null) {
                        }
                    }
                    hashMap = null;
                    if (hashMap != null) {
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                objectInputStream = null;
            }
            if (hashMap != null || (hashMap2 = (HashMap) hashMap.get("deviceInfo")) == null) {
                return null;
            }
            try {
                String str3 = (String) hashMap2.get("mac");
                str2 = (String) hashMap2.get(C3947a.f16895f);
                if (TextUtils.isEmpty(str2) && Build.VERSION.SDK_INT >= 9) {
                    str2 = (String) hashMap2.get("serialno");
                }
                return Data.byteToHex(Data.SHA1(str3 + ":" + str2 + ":" + ((String) hashMap2.get(C3947a.f16893d))));
            } catch (Throwable th6) {
                MobLog.getInstance().m5971d(th6);
                return null;
            }
        }
        hashMap = null;
        if (hashMap != null) {
            return null;
        }
        String str32 = (String) hashMap2.get("mac");
        str2 = (String) hashMap2.get(C3947a.f16895f);
        if (TextUtils.isEmpty(str2)) {
            str2 = (String) hashMap2.get("serialno");
        }
        return Data.byteToHex(Data.SHA1(str32 + ":" + str2 + ":" + ((String) hashMap2.get(C3947a.f16893d))));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0078 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String getHardwareAddressFromShell(String str) {
        BufferedReader bufferedReader;
        String str2;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat /sys/class/net/" + str + "/address").getInputStream()));
            try {
                str2 = bufferedReader.readLine();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    MobLog.getInstance().m5971d(th);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            str2 = null;
                        } catch (Throwable th3) {
                            str2 = null;
                        }
                    } else {
                        str2 = null;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                    }
                } catch (Throwable th4) {
                    BufferedReader bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Throwable th5) {
                        }
                    }
                    throw th4;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedReader = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2;
    }

    public static synchronized DeviceHelper getInstance(Context context) {
        DeviceHelper deviceHelper2;
        synchronized (DeviceHelper.class) {
            if (deviceHelper == null && context != null) {
                deviceHelper = new DeviceHelper(context);
            }
            deviceHelper2 = deviceHelper;
        }
        return deviceHelper2;
    }

    private String getLocalDeviceKey() {
        if (!getSdcardState()) {
            return null;
        }
        File file = new File(getSdcardPath(), "ShareSDK");
        if (file.exists()) {
            File file2 = new File(file, ".dk");
            if (file2.exists() && file2.renameTo(new File(ResHelper.getCacheRoot(this.context), ".dk"))) {
                file2.delete();
            }
        }
        File file3 = new File(ResHelper.getCacheRoot(this.context), ".dk");
        if (!file3.exists()) {
            return null;
        }
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file3));
        Object readObject = objectInputStream.readObject();
        String valueOf = (readObject == null || !(readObject instanceof char[])) ? null : String.valueOf((char[]) readObject);
        objectInputStream.close();
        return valueOf;
    }

    private Object getSystemService(String str) {
        try {
            return this.context.getSystemService(str);
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            return null;
        }
    }

    private boolean is4GMobileNetwork() {
        Object systemService = getSystemService("phone");
        if (systemService == null) {
            return false;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("ge");
            sb.append("tN");
            sb.append("et");
            sb.append("wo");
            sb.append("rk");
            sb.append("Ty");
            sb.append("pe");
            return ((Integer) ReflectHelper.invokeInstanceMethod(systemService, sb.toString(), new Object[0])).intValue() == 13;
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            return false;
        }
    }

    private boolean isFastMobileNetwork() {
        Object systemService = getSystemService("phone");
        if (systemService == null) {
            return false;
        }
        try {
            switch (((Integer) ReflectHelper.invokeInstanceMethod(systemService, "getNetworkType", new Object[0])).intValue()) {
                case 0:
                    return false;
                case 1:
                    return false;
                case 2:
                    return false;
                case 3:
                    return true;
                case 4:
                    return false;
                case 5:
                    return true;
                case 6:
                    return true;
                case 7:
                    return false;
                case 8:
                    return true;
                case 9:
                    return true;
                case 10:
                    return true;
                case 11:
                    return false;
                case 12:
                    return true;
                case 13:
                    return true;
                case 14:
                    return true;
                case 15:
                    return true;
            }
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
        }
        return false;
    }

    private boolean isSystemApp(PackageInfo packageInfo) {
        return ((packageInfo.applicationInfo.flags & 1) == 1) || ((packageInfo.applicationInfo.flags & 128) == 1);
    }

    private String[] listNetworkHardwareAddress() {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        if (networkInterfaces == null) {
            return null;
        }
        ArrayList<NetworkInterface> list = Collections.list(networkInterfaces);
        HashMap hashMap = new HashMap();
        for (NetworkInterface networkInterface : list) {
            byte[] hardwareAddress = networkInterface.getHardwareAddress();
            if (hardwareAddress != null) {
                StringBuilder sb = new StringBuilder();
                int length = hardwareAddress.length;
                for (int i = 0; i < length; i++) {
                    sb.append(String.format("%02x:", Byte.valueOf(hardwareAddress[i])));
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                hashMap.put(networkInterface.getName(), sb.toString());
            }
        }
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        while (arrayList.size() > 0) {
            String str = (String) arrayList.remove(0);
            if (str.startsWith("wlan")) {
                arrayList2.add(str);
            } else if (str.startsWith("eth")) {
                arrayList3.add(str);
            } else if (str.startsWith("rev_rmnet")) {
                arrayList4.add(str);
            } else if (str.startsWith("dummy")) {
                arrayList5.add(str);
            } else if (str.startsWith("usbnet")) {
                arrayList6.add(str);
            } else if (str.startsWith("rmnet_usb")) {
                arrayList7.add(str);
            } else {
                arrayList8.add(str);
            }
        }
        Collections.sort(arrayList2);
        Collections.sort(arrayList3);
        Collections.sort(arrayList4);
        Collections.sort(arrayList5);
        Collections.sort(arrayList6);
        Collections.sort(arrayList7);
        Collections.sort(arrayList8);
        arrayList.addAll(arrayList2);
        arrayList.addAll(arrayList3);
        arrayList.addAll(arrayList4);
        arrayList.addAll(arrayList5);
        arrayList.addAll(arrayList6);
        arrayList.addAll(arrayList7);
        arrayList.addAll(arrayList8);
        String[] strArr = new String[arrayList.size()];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr[i2] = (String) hashMap.get(arrayList.get(i2));
        }
        return strArr;
    }

    private void saveLocalDeviceKey(String str) {
        if (!getSdcardState()) {
            return;
        }
        File file = new File(ResHelper.getCacheRoot(this.context), ".dk");
        if (file.exists()) {
            file.delete();
        }
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(str.toCharArray());
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public String Base64AES(String str, String str2) {
        Throwable th;
        String encodeToString;
        try {
            encodeToString = Base64.encodeToString(Data.AES128Encode(str2, str), 0);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            return encodeToString.contains("\n") ? encodeToString.replace("\n", "") : encodeToString;
        } catch (Throwable th3) {
            th = th3;
            MobLog.getInstance().m5959w(th);
            return null;
        }
    }

    public boolean checkPermission(String str) {
        int i;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                ReflectHelper.importClass("android.content.Context");
                StringBuilder sb = new StringBuilder();
                sb.append("ch");
                sb.append("ec");
                sb.append("kS");
                sb.append("el");
                sb.append("fP");
                sb.append("er");
                sb.append("mi");
                sb.append("ss");
                sb.append("io");
                sb.append("n");
                Integer num = (Integer) ReflectHelper.invokeInstanceMethod(this.context, sb.toString(), str);
                i = num == null ? -1 : num.intValue();
            } catch (Throwable th) {
                MobLog.getInstance().m5971d(th);
                i = -1;
            }
        } else {
            this.context.checkPermission(str, Process.myPid(), Process.myUid());
            i = this.context.getPackageManager().checkPermission(str, getPackageName());
        }
        return i == 0;
    }

    public String getAdvertisingID() {
        String str;
        Throwable th;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new Throwable("Do not call this function from the main thread !");
        }
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        GSConnection gSConnection = new GSConnection();
        try {
            this.context.bindService(intent, gSConnection, 1);
            IBinder takeBinder = gSConnection.takeBinder();
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            takeBinder.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            str = obtain2.readString();
            try {
                obtain2.recycle();
                obtain.recycle();
            } catch (Throwable th2) {
                th = th2;
                try {
                    MobLog.getInstance().m5971d(th);
                    return str;
                } finally {
                    this.context.unbindService(gSConnection);
                }
            }
        } catch (Throwable th3) {
            str = null;
            th = th3;
        }
        return str;
    }

    public String getAndroidID() {
        String string = Settings.Secure.getString(this.context.getContentResolver(), "android_id");
        MobLog.getInstance().m5966i("getAndroidID === " + string, new Object[0]);
        return string;
    }

    public String getAppLanguage() {
        return this.context.getResources().getConfiguration().locale.getLanguage();
    }

    public String getAppName() {
        String str = this.context.getApplicationInfo().name;
        if (str != null) {
            if (Build.VERSION.SDK_INT < 25 || str.endsWith(".*")) {
                return str;
            }
            try {
                ReflectHelper.importClass(str);
            } catch (Throwable th) {
            }
        }
        int i = this.context.getApplicationInfo().labelRes;
        return i > 0 ? this.context.getString(i) : String.valueOf(this.context.getApplicationInfo().nonLocalizedLabel);
    }

    public int getAppVersion() {
        try {
            return this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionCode;
        } catch (Throwable th) {
            MobLog.getInstance().m5971d(th);
            return 0;
        }
    }

    public String getAppVersionName() {
        try {
            return this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            MobLog.getInstance().m5971d(th);
            return "1.0";
        }
    }

    public String getBluetoothName() {
        try {
            ReflectHelper.importClass("android.bluetooth.BluetoothAda" + LocaleUtil.PORTUGUESE + "er");
            if (checkPermission("android.permission.BLUETOOTH")) {
                Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("BluetoothAdapter", "getDefaultAdapter", new Object[0]);
                if (invokeStaticMethod != null) {
                    return (String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getName", new Object[0]);
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().m5971d(th);
        }
        return null;
    }

    public String getBssid() {
        Object systemService;
        try {
            if (!checkPermission("android.permission.ACCESS_WIFI_STATE") || (systemService = getSystemService("wifi")) == null) {
                return null;
            }
            Object invokeInstanceMethod = ReflectHelper.invokeInstanceMethod(systemService, "getC" + C2427e.f8308cE + "nectionInfo", new Object[0]);
            if (invokeInstanceMethod == null) {
                return null;
            }
            String str = (String) ReflectHelper.invokeInstanceMethod(invokeInstanceMethod, "getBSSID", new Object[0]);
            if (str == null) {
                str = null;
            }
            return str;
        } catch (Throwable th) {
            MobLog.getInstance().m5971d(th);
            return null;
        }
    }

    public String getCarrier() {
        try {
            Object systemService = getSystemService("phone");
            if (systemService == null) {
                return "-1";
            }
            String str = (String) ReflectHelper.invokeInstanceMethod(systemService, "getSimOperator", new Object[0]);
            return TextUtils.isEmpty(str) ? "-1" : str;
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            return "-1";
        }
    }

    public String getCarrierName() {
        Object systemService = getSystemService("phone");
        if (systemService == null) {
            return null;
        }
        try {
            if (!checkPermission("android.permission.READ_PHONE_STATE")) {
                return null;
            }
            String str = (String) ReflectHelper.invokeInstanceMethod(systemService, "getSimOperatorName", new Object[0]);
            if (TextUtils.isEmpty(str)) {
                str = null;
            }
            return str;
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            return null;
        }
    }

    public int getCellId() {
        Object systemService;
        try {
            if (checkPermission("android.permission.ACCESS_COARSE_LOCATION") && (systemService = getSystemService("phone")) != null) {
                Object invokeInstanceMethod = ReflectHelper.invokeInstanceMethod(systemService, "getCellLocation", new Object[0]);
                if (invokeInstanceMethod != null) {
                    return ((Integer) ResHelper.forceCast(ReflectHelper.invokeInstanceMethod(invokeInstanceMethod, "getCid", new Object[0]), -1)).intValue();
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().m5971d(th);
        }
        return -1;
    }

    public int getCellLac() {
        Object systemService;
        try {
            if (checkPermission("android.permission.ACCESS_COARSE_LOCATION") && (systemService = getSystemService("phone")) != null) {
                Object invokeInstanceMethod = ReflectHelper.invokeInstanceMethod(systemService, "getCellLocation", new Object[0]);
                if (invokeInstanceMethod != null) {
                    return ((Integer) ResHelper.forceCast(ReflectHelper.invokeInstanceMethod(invokeInstanceMethod, "getLac", new Object[0]), -1)).intValue();
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().m5971d(th);
        }
        return -1;
    }

    public String getCharAndNumr(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(System.currentTimeMillis() ^ SystemClock.elapsedRealtime());
        Random random = new Random();
        for (int i2 = 0; i2 < i; i2++) {
            if ("char".equalsIgnoreCase(random.nextInt(2) % 2 == 0 ? "char" : "num")) {
                stringBuffer.insert(i2 + 1, (char) (random.nextInt(26) + 97));
            } else {
                stringBuffer.insert(stringBuffer.length(), random.nextInt(10));
            }
        }
        return stringBuffer.toString().substring(0, 40);
    }

    public String getDetailNetworkTypeForStatic() {
        String lowerCase = getNetworkType().toLowerCase();
        return (TextUtils.isEmpty(lowerCase) || "none".equals(lowerCase)) ? "none" : lowerCase.startsWith("wifi") ? "wifi" : lowerCase.startsWith("4g") ? "4g" : lowerCase.startsWith("3g") ? "3g" : lowerCase.startsWith("2g") ? "2g" : lowerCase.startsWith("bluetooth") ? "bluetooth" : lowerCase;
    }

    public String getDeviceData() {
        return Base64AES(getModel() + "|" + getOSVersionInt() + "|" + getManufacturer() + "|" + getCarrier() + "|" + getScreenSize(), getDeviceKey().substring(0, 16));
    }

    public String getDeviceDataNotAES() {
        return getModel() + "|" + getOSVersion() + "|" + getManufacturer() + "|" + getCarrier() + "|" + getScreenSize();
    }

    public String getDeviceId() {
        String imei = getIMEI();
        return (!TextUtils.isEmpty(imei) || Build.VERSION.SDK_INT < 9) ? imei : getSerialno();
    }

    public String getDeviceKey() {
        String str;
        String str2 = null;
        try {
            str = getDeviceKeyWithDuid("comm/dbs/.duid");
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            str = null;
        }
        if (TextUtils.isEmpty(str) || str.length() < 40) {
            str = genDeviceKey();
        }
        if (TextUtils.isEmpty(str) || str.length() < 40) {
            try {
                str2 = getLocalDeviceKey();
            } catch (Throwable th2) {
                MobLog.getInstance().m5959w(th2);
            }
            if (!TextUtils.isEmpty(str2) && str2.length() >= 40) {
                return str2.trim();
            }
            String charAndNumr = (TextUtils.isEmpty(str2) || str2.length() < 40) ? getCharAndNumr(40) : str2;
            if (charAndNumr == null) {
                return charAndNumr;
            }
            try {
                charAndNumr = charAndNumr.trim();
                saveLocalDeviceKey(charAndNumr);
                return charAndNumr;
            } catch (Throwable th3) {
                MobLog.getInstance().m5959w(th3);
                return charAndNumr;
            }
        }
        return str.trim();
    }

    public String getDeviceType() {
        UiModeManager uiModeManager = (UiModeManager) getSystemService("uimode");
        if (uiModeManager != null) {
            switch (uiModeManager.getCurrentModeType()) {
                case 1:
                    return "NO_UI";
                case 2:
                    return "DESK";
                case 3:
                    return "CAR";
                case 4:
                    return "TELEVISION";
                case 5:
                    return "APPLIANCE";
                case 6:
                    return "WATCH";
            }
        }
        return "UNDEFINED";
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getIMEI() {
        String str;
        Object systemService = getSystemService("phone");
        if (systemService == null) {
            return null;
        }
        try {
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
        }
        if (checkPermission("android.permission.READ_PHONE_STATE")) {
            str = (String) ReflectHelper.invokeInstanceMethod(systemService, "getDeviceI" + C0477f.f1054a, new Object[0]);
            if (!TextUtils.isEmpty(str)) {
                return null;
            }
            return str.trim();
        }
        str = null;
        if (!TextUtils.isEmpty(str)) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getIMSI() {
        String str;
        Object systemService = getSystemService("phone");
        if (systemService == null) {
            return null;
        }
        try {
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
        }
        if (checkPermission("android.permission.READ_PHONE_STATE")) {
            str = (String) ReflectHelper.invokeInstanceMethod(systemService, "getSubscriberI" + C0477f.f1054a, new Object[0]);
            if (!TextUtils.isEmpty(str)) {
                return null;
            }
            return str;
        }
        str = null;
        if (!TextUtils.isEmpty(str)) {
        }
    }

    public String getIPAddress() {
        try {
            if (checkPermission("android.permission.INTERNET")) {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            return nextElement.getHostAddress();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
        }
        return "0.0.0.0";
    }

    public ArrayList<HashMap<String, String>> getInstalledApp(boolean z) {
        CharSequence text;
        try {
            ArrayList arrayList = new ArrayList();
            Process exec = Runtime.getRuntime().exec("pm list packag" + LocaleUtil.SPANISH);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream(), "utf-8"));
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                String trim = readLine.toLowerCase().trim();
                if (trim.startsWith("package:")) {
                    arrayList.add(trim.substring("package:".length()).trim());
                }
            }
            bufferedReader.close();
            exec.destroy();
            ArrayList<HashMap<String, String>> arrayList2 = new ArrayList<>();
            PackageManager packageManager = this.context.getPackageManager();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                PackageInfo packageInfo = packageManager.getPackageInfo((String) it2.next(), 0);
                if (packageInfo != null && (z || !isSystemApp(packageInfo))) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("pkg", packageInfo.packageName);
                    String str = packageInfo.applicationInfo.name;
                    if (str == null) {
                        int i = packageInfo.applicationInfo.labelRes;
                        if (i > 0 && (text = packageManager.getText(packageInfo.packageName, i, packageInfo.applicationInfo)) != null) {
                            str = text.toString().trim();
                        }
                        if (str == null) {
                            str = String.valueOf(packageInfo.applicationInfo.nonLocalizedLabel);
                        }
                    }
                    hashMap.put("name", str);
                    hashMap.put(GameAppOperation.QQFAV_DATALINE_VERSION, packageInfo.versionName);
                    arrayList2.add(hashMap);
                }
            }
            return arrayList2;
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            return new ArrayList<>();
        }
    }

    public String getLine1Number() {
        try {
            Object systemService = getSystemService("phone");
            if (systemService == null) {
                return "-1";
            }
            return (String) ReflectHelper.invokeInstanceMethod(systemService, "getLine1Number", new Object[0]);
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            return "-1";
        }
    }

    public Location getLocation(int i, int i2, boolean z) {
        try {
            if (checkPermission("android.permission.ACCESS_FINE_LOCATION")) {
                return new LocationHelper().getLocation(this.context, i, i2, z);
            }
        } catch (Throwable th) {
            MobLog.getInstance().m5971d(th);
        }
        return null;
    }

    public float[] getLocation(int i, int i2) {
        Location location = getLocation(i, i2, true);
        if (location != null) {
            return new float[]{(float) location.getLatitude(), (float) location.getLongitude()};
        }
        return null;
    }

    public String getMCC() {
        String imsi = getIMSI();
        if (imsi == null || imsi.length() < 3) {
            return null;
        }
        return imsi.substring(0, 3);
    }

    public String getMNC() {
        String imsi = getIMSI();
        if (imsi == null || imsi.length() < 5) {
            return null;
        }
        return imsi.substring(3, 5);
    }

    public String getMacAddress() {
        String str;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                str = getHardwareAddressFromShell("wlan0");
            } catch (Throwable th) {
                MobLog.getInstance().m5971d(th);
                str = null;
            }
            if (str == null) {
                try {
                    str = getCurrentNetworkHardwareAddress();
                } catch (Throwable th2) {
                    MobLog.getInstance().m5971d(th2);
                    str = null;
                }
            }
            if (str == null) {
                try {
                    String[] listNetworkHardwareAddress = listNetworkHardwareAddress();
                    if (listNetworkHardwareAddress.length > 0) {
                        str = listNetworkHardwareAddress[0];
                    }
                } catch (Throwable th3) {
                    MobLog.getInstance().m5971d(th3);
                    str = null;
                }
            }
            if (str != null) {
                return str;
            }
        }
        try {
            Object systemService = getSystemService("wifi");
            if (systemService == null) {
                return null;
            }
            Object invokeInstanceMethod = ReflectHelper.invokeInstanceMethod(systemService, "getC" + C2427e.f8308cE + "nectionInfo", new Object[0]);
            if (invokeInstanceMethod == null) {
                return null;
            }
            String str2 = (String) ReflectHelper.invokeInstanceMethod(invokeInstanceMethod, "getMacAddr" + LocaleUtil.SPANISH + "s", new Object[0]);
            return str2 == null ? null : str2.trim();
        } catch (Throwable th4) {
            MobLog.getInstance().m5959w(th4);
            return null;
        }
    }

    public String getManufacturer() {
        return Build.MANUFACTURER;
    }

    public String getMime() {
        return getIMEI();
    }

    public String getModel() {
        String str = Build.MODEL;
        return !TextUtils.isEmpty(str) ? str.trim() : str;
    }

    public String getNetworkOperator() {
        Object systemService = getSystemService("phone");
        if (systemService == null) {
            return null;
        }
        try {
            return (String) ReflectHelper.invokeInstanceMethod(systemService, "getNetworkOperator", new Object[0]);
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            return null;
        }
    }

    public String getNetworkType() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
        if (connectivityManager == null) {
            return "none";
        }
        try {
            if (!checkPermission("android.permission.ACCESS_NETWORK_STATE") || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
                return "none";
            }
            int type = activeNetworkInfo.getType();
            switch (type) {
                case 0:
                    return is4GMobileNetwork() ? "4G" : isFastMobileNetwork() ? "3G" : "2G";
                case 1:
                    return "wifi";
                case 2:
                case 3:
                case 4:
                case 5:
                default:
                    return String.valueOf(type);
                case 6:
                    return "wimax";
                case 7:
                    return "bluetooth";
                case 8:
                    return "dummy";
                case 9:
                    return "ethernet";
            }
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            return "none";
        }
    }

    public String getNetworkTypeForStatic() {
        String lowerCase = getNetworkType().toLowerCase();
        return (TextUtils.isEmpty(lowerCase) || "none".equals(lowerCase)) ? "none" : (lowerCase.startsWith("4g") || lowerCase.startsWith("3g") || lowerCase.startsWith("2g")) ? "cell" : lowerCase.startsWith("wifi") ? "wifi" : "other";
    }

    public String getOSCountry() {
        return Locale.getDefault().getCountry();
    }

    public String getOSLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public String getOSVersion() {
        return String.valueOf(getOSVersionInt());
    }

    public int getOSVersionInt() {
        return Build.VERSION.SDK_INT;
    }

    public String getOSVersionName() {
        return Build.VERSION.RELEASE;
    }

    public String getPackageName() {
        return this.context.getPackageName();
    }

    public int getPlatformCode() {
        return 1;
    }

    public JSONArray getRunningApp() {
        List list;
        JSONArray jSONArray = new JSONArray();
        Object systemService = getSystemService("activity");
        if (systemService == null) {
            return jSONArray;
        }
        try {
            list = (List) ReflectHelper.invokeInstanceMethod(systemService, "getRunningAppProcess" + LocaleUtil.SPANISH, new Object[0]);
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
        }
        if (list == null) {
            return jSONArray;
        }
        for (Object obj : list) {
            jSONArray.put(ReflectHelper.getInstanceField(obj, "proc" + LocaleUtil.SPANISH + "sName"));
        }
        return jSONArray;
    }

    public String getRunningAppStr() {
        JSONArray runningApp = getRunningApp();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < runningApp.length(); i++) {
            if (i > 0) {
                sb.append(C0359h.f727x);
            }
            sb.append(String.valueOf(runningApp.get(i)));
        }
        return sb.toString();
    }

    public String getSSID() {
        Object systemService;
        try {
            if (!checkPermission("android.permission.ACCESS_WIFI_STATE") || (systemService = getSystemService("wifi")) == null) {
                return null;
            }
            Object invokeInstanceMethod = ReflectHelper.invokeInstanceMethod(systemService, "getC" + C2427e.f8308cE + "nectionInfo", new Object[0]);
            if (invokeInstanceMethod == null) {
                return null;
            }
            String str = (String) ReflectHelper.invokeInstanceMethod(invokeInstanceMethod, "getSSID", new Object[0]);
            return str == null ? null : str.replace("\"", "");
        } catch (Throwable th) {
            MobLog.getInstance().m5971d(th);
            return null;
        }
    }

    public String getScreenSize() {
        int[] screenSize = ResHelper.getScreenSize(this.context);
        return this.context.getResources().getConfiguration().orientation == 1 ? screenSize[0] + "x" + screenSize[1] : screenSize[1] + "x" + screenSize[0];
    }

    public String getSdcardPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public boolean getSdcardState() {
        try {
            if (!checkPermission("android.permission.WRITE_EXTERNAL_STORAGE")) {
                return false;
            }
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            return false;
        }
    }

    public String getSerialno() {
        String str;
        if (Build.VERSION.SDK_INT >= 9) {
            try {
                ReflectHelper.importClass("android.os.SystemProperties");
                StringBuilder sb = new StringBuilder();
                sb.append("ge");
                sb.append("t");
                str = (String) ReflectHelper.invokeStaticMethod("SystemProperties", sb.toString(), "ro.serialno", "unknown");
            } catch (Throwable th) {
                MobLog.getInstance().m5971d(th);
                str = null;
            }
        } else {
            str = null;
        }
        return !TextUtils.isEmpty(str) ? str.trim() : str;
    }

    public String getSignMD5() {
        try {
            return Data.MD5(this.context.getPackageManager().getPackageInfo(getPackageName(), 64).signatures[0].toByteArray());
        } catch (Exception e) {
            MobLog.getInstance().m5959w(e);
            return null;
        }
    }

    public String getSimSerialNumber() {
        try {
            Object systemService = getSystemService("phone");
            if (systemService == null) {
                return "-1";
            }
            return (String) ReflectHelper.invokeInstanceMethod(systemService, "getSimSerialNumber", new Object[0]);
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            return "-1";
        }
    }

    public String getTopTaskPackageName() {
        boolean z;
        String str;
        try {
            z = checkPermission("android.permission.GET_TASKS");
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            z = false;
        }
        if (z) {
            try {
                Object systemService = getSystemService("activity");
                if (systemService == null) {
                    str = null;
                } else if (Build.VERSION.SDK_INT <= 20) {
                    Object instanceField = ReflectHelper.getInstanceField(((List) ReflectHelper.invokeInstanceMethod(systemService, "getRunningTasks", 1)).get(0), "topActiv" + LocaleUtil.ITALIAN + "y");
                    StringBuilder sb = new StringBuilder();
                    sb.append("ge");
                    sb.append("tP");
                    sb.append("ac");
                    sb.append("ka");
                    sb.append("ge");
                    sb.append("Na");
                    sb.append("me");
                    str = (String) ReflectHelper.invokeInstanceMethod(instanceField, sb.toString(), new Object[0]);
                } else {
                    str = ((String) ReflectHelper.getInstanceField(((List) ReflectHelper.invokeInstanceMethod(systemService, "getRunningAppProcess" + LocaleUtil.SPANISH, new Object[0])).get(0), "proc" + LocaleUtil.SPANISH + "sName")).split(":")[0];
                }
                return str;
            } catch (Throwable th2) {
                MobLog.getInstance().m5971d(th2);
            }
        }
        return null;
    }

    public void hideSoftInput(View view) {
        Object systemService = getSystemService("input_method");
        if (systemService == null) {
            return;
        }
        ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public boolean isMainProcess(int i) {
        String str;
        try {
            List list = (List) ReflectHelper.invokeInstanceMethod(getSystemService("activity"), "getRunningAppProcess" + LocaleUtil.SPANISH, new Object[0]);
            if (list == null) {
                return i <= 0;
            }
            if (i <= 0) {
                i = Process.myPid();
            }
            Iterator it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    str = null;
                    break;
                }
                Object next = it2.next();
                if (((Integer) ReflectHelper.getInstanceField(next, "pi" + C0477f.f1054a)).intValue() == i) {
                    str = (String) ReflectHelper.getInstanceField(next, "proc" + LocaleUtil.SPANISH + "sName");
                    break;
                }
            }
            return getPackageName().equals(str);
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            return false;
        }
    }

    public boolean isRooted() {
        return false;
    }

    public HashMap<String, String> ping(String str, int i, int i2) {
        float f;
        float f2;
        float f3 = 0.0f;
        ArrayList arrayList = new ArrayList();
        try {
            int i3 = i2 + 8;
            Process exec = Runtime.getRuntime().exec("ping -c " + i + " -s " + i2 + " " + str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            String readLine = bufferedReader.readLine();
            while (readLine != null) {
                if (readLine.startsWith(i3 + " bytes from")) {
                    if (readLine.endsWith(LocaleUtil.MALAY)) {
                        readLine = readLine.substring(0, readLine.length() - 2).trim();
                    } else if (readLine.endsWith("s")) {
                        readLine = readLine.substring(0, readLine.length() - 1).trim() + "000";
                    }
                    int indexOf = readLine.indexOf("time=");
                    if (indexOf > 0) {
                        arrayList.add(Float.valueOf(Float.parseFloat(readLine.substring(indexOf + 5).trim())));
                    }
                }
                readLine = bufferedReader.readLine();
            }
            exec.waitFor();
        } catch (Throwable th) {
            MobLog.getInstance().m5971d(th);
        }
        int size = arrayList.size();
        int size2 = i - arrayList.size();
        if (size > 0) {
            float f4 = Float.MAX_VALUE;
            int i4 = 0;
            float f5 = 0.0f;
            f = 0.0f;
            while (i4 < size) {
                float floatValue = ((Float) arrayList.get(i4)).floatValue();
                if (floatValue < f4) {
                    f4 = floatValue;
                }
                i4++;
                f5 += floatValue;
                f = floatValue > f ? floatValue : f;
            }
            f3 = f5 / size;
            f2 = f4;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("address", str);
        hashMap.put("transmitted", String.valueOf(i));
        hashMap.put("received", String.valueOf(size));
        hashMap.put("loss", String.valueOf(size2));
        hashMap.put("min", String.valueOf(f2));
        hashMap.put("max", String.valueOf(f));
        hashMap.put("avg", String.valueOf(f3));
        return hashMap;
    }

    public void showSoftInput(View view) {
        Object systemService = getSystemService("input_method");
        if (systemService == null) {
            return;
        }
        ((InputMethodManager) systemService).toggleSoftInputFromWindow(view.getWindowToken(), 2, 0);
    }
}
