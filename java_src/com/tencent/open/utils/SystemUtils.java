package com.tencent.open.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.view.MotionEvent;
import com.tencent.open.GameAppOperation;
import com.tencent.open.p228a.C4331f;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.security.MessageDigest;
/* loaded from: classes.dex */
public class SystemUtils {
    public static final String ACTION_LOGIN = "action_login";
    public static final String ACTION_SHARE = "action_share";
    public static final String H5_SHARE_DATA = "h5_share_data";
    public static final String IS_LOGIN = "is_login";
    public static final String IS_QQ_MOBILE_SHARE = "is_qq_mobile_share";
    public static final String QQDATALINE_CALLBACK_ACTION = "sendToMyComputer";
    public static final String QQFAVORITES_CALLBACK_ACTION = "addToQQFavorites";
    public static final String QQ_SHARE_CALLBACK_ACTION = "shareToQQ";
    public static final String QQ_VERSION_NAME_4_2_0 = "4.2.0";
    public static final String QQ_VERSION_NAME_4_3_0 = "4.3.0";
    public static final String QQ_VERSION_NAME_4_5_0 = "4.5.0";
    public static final String QQ_VERSION_NAME_4_6_0 = "4.6.0";
    public static final String QQ_VERSION_NAME_5_0_0 = "5.0.0";
    public static final String QQ_VERSION_NAME_5_1_0 = "5.1.0";
    public static final String QQ_VERSION_NAME_5_2_0 = "5.2.0";
    public static final String QQ_VERSION_NAME_5_3_0 = "5.3.0";
    public static final String QZONE_SHARE_CALLBACK_ACTION = "shareToQzone";
    public static final String TROOPBAR_CALLBACK_ACTION = "shareToTroopBar";

    /* renamed from: a */
    private static final String f18214a = C4331f.f18119d + ".SysUtils";

    /* renamed from: a */
    private static long m5350a(InputStream inputStream, OutputStream outputStream) {
        long j = 0;
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr, 0, bArr.length);
            if (read == -1) {
                C4331f.m5442c(f18214a, "-->copy, copyed size is: " + j);
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }

    public static boolean checkMobileQQ(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo("com.tencent.mobileqq", 0);
        } catch (PackageManager.NameNotFoundException e) {
            C4331f.m5445b("checkMobileQQ", XiaomiOAuthConstants.EXTRA_ERROR_CODE_2);
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            String str = packageInfo.versionName;
            try {
                C4331f.m5445b("MobileQQ verson", str);
                String[] split = str.split("\\.");
                int parseInt = Integer.parseInt(split[0]);
                return parseInt > 4 || (parseInt == 4 && Integer.parseInt(split[1]) >= 1);
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static int compareQQVersion(Context context, String str) {
        return compareVersion(getAppVersionName(context, "com.tencent.mobileqq"), str);
    }

    public static int compareVersion(String str, String str2) {
        if (str == null && str2 == null) {
            return 0;
        }
        if (str != null && str2 == null) {
            return 1;
        }
        if (str == null && str2 != null) {
            return -1;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i = 0;
        while (i < split.length && i < split2.length) {
            try {
                int parseInt = Integer.parseInt(split[i]);
                int parseInt2 = Integer.parseInt(split2[i]);
                if (parseInt < parseInt2) {
                    return -1;
                }
                if (parseInt > parseInt2) {
                    return 1;
                }
                i++;
            } catch (NumberFormatException e) {
                return str.compareTo(str2);
            }
        }
        if (split.length > i) {
            return 1;
        }
        return split2.length > i ? -1 : 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v9 */
    @SuppressLint({"SdCardPath"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean extractSecureLib(String str, String str2, int i) {
        IOException iOException;
        FileOutputStream fileOutputStream = null;
        boolean z = false;
        C4331f.m5442c(f18214a, "-->extractSecureLib, libName: " + str);
        Context context = Global.getContext();
        if (context == null) {
            C4331f.m5442c(f18214a, "-->extractSecureLib, global context is null. ");
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("secure_lib", 0);
        ?? file = new File(context.getFilesDir(), str2);
        if (!file.exists()) {
            boolean mkdirs = file.getParentFile().mkdirs();
            iOException = file;
            if (mkdirs) {
                try {
                    file.createNewFile();
                    iOException = file;
                } catch (IOException e) {
                    e.printStackTrace();
                    iOException = e;
                }
            }
        } else {
            int i2 = sharedPreferences.getInt(GameAppOperation.QQFAV_DATALINE_VERSION, 0);
            C4331f.m5442c(f18214a, "-->extractSecureLib, libVersion: " + i + " | oldVersion: " + i2);
            iOException = i2;
            if (i == i2) {
                return true;
            }
        }
        try {
            try {
                iOException = context.getAssets().open(str);
                try {
                    fileOutputStream = context.openFileOutput(str2, 0);
                    m5350a(iOException, fileOutputStream);
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putInt(GameAppOperation.QQFAV_DATALINE_VERSION, i);
                    edit.commit();
                    if (iOException != 0) {
                        try {
                            iOException.close();
                        } catch (IOException e2) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    z = true;
                } catch (Exception e4) {
                    e = e4;
                    C4331f.m5444b(f18214a, "-->extractSecureLib, when copy lib execption.", e);
                    if (iOException != null) {
                        try {
                            iOException.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    return z;
                }
            } catch (Throwable th) {
                th = th;
                if (iOException != 0) {
                    try {
                        iOException.close();
                    } catch (IOException e7) {
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e8) {
                    }
                }
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            iOException = null;
        } catch (Throwable th2) {
            th = th2;
            iOException = 0;
            if (iOException != 0) {
            }
            if (fileOutputStream != null) {
            }
            throw th;
        }
        return z;
    }

    public static int getAndroidSDKVersion() {
        try {
            return Integer.valueOf(Build.VERSION.SDK).intValue();
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static String getAppName(Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    public static String getAppSignatureMD5(Context context, String str) {
        String str2;
        Exception e;
        MessageDigest messageDigest;
        C4331f.m5448a(C4331f.f18119d, "OpenUi, getSignValidString");
        try {
            String packageName = context.getPackageName();
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(signatureArr[0].toByteArray());
            String hexString = Util.toHexString(messageDigest.digest());
            messageDigest.reset();
            C4331f.m5445b("SystemUtils", "-->sign: " + hexString);
            messageDigest.update(Util.getBytesUTF8(packageName + "_" + hexString + "_" + str + ""));
            str2 = Util.toHexString(messageDigest.digest());
        } catch (Exception e2) {
            str2 = "";
            e = e2;
        }
        try {
            messageDigest.reset();
            C4331f.m5445b("SystemUtils", "-->signEncryped: " + str2);
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            C4331f.m5444b(C4331f.f18119d, "OpenUi, getSignValidString error", e);
            return str2;
        }
        return str2;
    }

    public static String getAppVersionName(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static String getRealPathFromUri(Activity activity, Uri uri) {
        Cursor managedQuery = activity.managedQuery(uri, new String[]{"_data"}, null, null, null);
        if (managedQuery != null) {
            int columnIndexOrThrow = managedQuery.getColumnIndexOrThrow("_data");
            managedQuery.moveToFirst();
            return managedQuery.getString(columnIndexOrThrow);
        }
        return null;
    }

    public static boolean isActivityExist(Context context, Intent intent) {
        return (context == null || intent == null || context.getPackageManager().queryIntentActivities(intent, 0).size() == 0) ? false : true;
    }

    public static boolean isAppSignatureValid(Context context, String str, String str2) {
        C4331f.m5448a(C4331f.f18119d, "OpenUi, validateAppSignatureForPackage");
        try {
            for (Signature signature : context.getPackageManager().getPackageInfo(str, 64).signatures) {
                if (Util.encrypt(signature.toCharsString()).equals(str2)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    @SuppressLint({"SdCardPath"})
    public static boolean isLibExtracted(String str, int i) {
        Context context = Global.getContext();
        if (context == null) {
            C4331f.m5442c(f18214a, "-->isSecureLibExtracted, global context is null. ");
            return false;
        }
        File file = new File(context.getFilesDir(), str);
        SharedPreferences sharedPreferences = context.getSharedPreferences("secure_lib", 0);
        if (!file.exists()) {
            return false;
        }
        int i2 = sharedPreferences.getInt(GameAppOperation.QQFAV_DATALINE_VERSION, 0);
        C4331f.m5442c(f18214a, "-->extractSecureLib, libVersion: " + i + " | oldVersion: " + i2);
        if (i == i2) {
            return true;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(GameAppOperation.QQFAV_DATALINE_VERSION, i);
        edit.commit();
        return false;
    }

    public static boolean isSupportMultiTouch() {
        Method[] declaredMethods;
        boolean z = false;
        boolean z2 = false;
        for (Method method : MotionEvent.class.getDeclaredMethods()) {
            if (method.getName().equals("getPointerCount")) {
                z2 = true;
            }
            if (method.getName().equals("getPointerId")) {
                z = true;
            }
        }
        if (getAndroidSDKVersion() < 7) {
            return z2 && z;
        }
        return true;
    }
}
