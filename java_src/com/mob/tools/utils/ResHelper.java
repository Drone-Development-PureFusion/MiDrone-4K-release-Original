package com.mob.tools.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Point;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.fimi.kernel.C2172a;
import com.fimi.kernel.utils.C2258f;
import com.mob.tools.MobLog;
import com.mob.tools.network.KVPair;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import p004b.p005a.p006a.p028b.p054o.AbstractC0517a;
/* loaded from: classes.dex */
public class ResHelper {
    private static float density;
    private static int deviceWidth;
    private static Uri mediaUri;

    /* renamed from: rp */
    private static Object f17341rp;

    public static void clearCache(Context context) {
        deleteFileAndFolder(new File(getCachePath(context, null)));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0098 A[Catch: Throwable -> 0x00be, TryCatch #0 {Throwable -> 0x00be, blocks: (B:10:0x0018, B:12:0x001e, B:14:0x0051, B:16:0x0098, B:18:0x00a8, B:20:0x00ae, B:21:0x00b8), top: B:9:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a8 A[Catch: Throwable -> 0x00be, TryCatch #0 {Throwable -> 0x00be, blocks: (B:10:0x0018, B:12:0x001e, B:14:0x0051, B:16:0x0098, B:18:0x00a8, B:20:0x00ae, B:21:0x00b8), top: B:9:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String contentUriToPath(Context context, Uri uri) {
        String str;
        Cursor cursor;
        Cursor query;
        if (uri == null) {
            return null;
        }
        if (new File(uri.getPath()).exists()) {
            return uri.getPath();
        }
        try {
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            str = null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            Class<?> cls = Class.forName("android.provider.DocumentsContract");
            Method method = cls.getMethod("isDocumentUri", Context.class, Uri.class);
            method.setAccessible(true);
            if (Boolean.TRUE.equals(method.invoke(null, context, uri))) {
                Method method2 = cls.getMethod("getDocumentId", Uri.class);
                method2.setAccessible(true);
                cursor = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_data"}, "_id=?", new String[]{String.valueOf(method2.invoke(null, uri)).split(":")[1]}, null);
                query = cursor != null ? context.getContentResolver().query(uri, null, null, null, null) : cursor;
                if (query == null) {
                    str = query.moveToFirst() ? query.getString(query.getColumnIndex("_data")) : null;
                    query.close();
                } else {
                    str = null;
                }
                return str;
            }
        }
        cursor = null;
        if (cursor != null) {
        }
        if (query == null) {
        }
        return str;
    }

    public static void copyFile(FileInputStream fileInputStream, FileOutputStream fileOutputStream) {
        byte[] bArr = new byte[65536];
        int read = fileInputStream.read(bArr);
        while (read > 0) {
            fileOutputStream.write(bArr, 0, read);
            read = fileInputStream.read(bArr);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    public static boolean copyFile(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !new File(str).exists()) {
            return false;
        }
        try {
            copyFile(new FileInputStream(str), new FileOutputStream(str2));
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static int[] covertTimeInYears(long j) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        if (currentTimeMillis <= 0) {
            return new int[]{0, 0};
        }
        long j2 = currentTimeMillis / 1000;
        if (j2 < 60) {
            return new int[]{(int) j2, 0};
        }
        long j3 = j2 / 60;
        if (j3 < 60) {
            return new int[]{(int) j3, 1};
        }
        long j4 = j3 / 60;
        if (j4 < 24) {
            return new int[]{(int) j4, 2};
        }
        long j5 = j4 / 24;
        if (j5 < 30) {
            return new int[]{(int) j5, 3};
        }
        long j6 = j5 / 30;
        return j6 < 12 ? new int[]{(int) j6, 4} : new int[]{(int) (j6 / 12), 5};
    }

    public static long dateStrToLong(String str) {
        return new SimpleDateFormat("yyyy-MM-dd").parse(str, new ParsePosition(0)).getTime();
    }

    public static long dateToLong(String str) {
        try {
            Date date = new Date(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.getTimeInMillis();
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            return 0L;
        }
    }

    public static Bundle decodeUrl(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                if (split.length < 2 || split[1] == null) {
                    bundle.putString(URLDecoder.decode(split[0]), "");
                } else {
                    bundle.putString(URLDecoder.decode(split[0]), URLDecoder.decode(split[1]));
                }
            }
        }
        return bundle;
    }

    public static void deleteFileAndFolder(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        String[] list = file.list();
        if (list == null || list.length <= 0) {
            file.delete();
            return;
        }
        for (String str : list) {
            File file2 = new File(file, str);
            if (file2.isDirectory()) {
                deleteFileAndFolder(file2);
            } else {
                file2.delete();
            }
        }
        file.delete();
    }

    public static void deleteFilesInFolder(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        String[] list = file.list();
        if (list == null || list.length <= 0) {
            return;
        }
        for (String str : list) {
            File file2 = new File(file, str);
            if (file2.isDirectory()) {
                deleteFilesInFolder(file2);
            } else {
                file2.delete();
            }
        }
    }

    public static int designToDevice(Context context, float f, int i) {
        if (density <= 0.0f) {
            density = context.getResources().getDisplayMetrics().density;
        }
        return (int) (((i * density) / f) + 0.5f);
    }

    public static int designToDevice(Context context, int i, int i2) {
        if (deviceWidth == 0) {
            int[] screenSize = getScreenSize(context);
            deviceWidth = screenSize[0] < screenSize[1] ? screenSize[0] : screenSize[1];
        }
        return (int) (((i2 * deviceWidth) / i) + 0.5f);
    }

    public static int dipToPx(Context context, int i) {
        if (density <= 0.0f) {
            density = context.getResources().getDisplayMetrics().density;
        }
        return (int) ((i * density) + 0.5f);
    }

    public static String encodeUrl(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj == null) {
                obj = "";
            }
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            sb.append(Data.urlEncode(str) + "=" + Data.urlEncode(String.valueOf(obj)));
        }
        return sb.toString();
    }

    public static String encodeUrl(ArrayList<KVPair<String>> arrayList) {
        if (arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<KVPair<String>> it2 = arrayList.iterator();
        int i = 0;
        while (it2.hasNext()) {
            KVPair<String> next = it2.next();
            if (i > 0) {
                sb.append('&');
            }
            String str = next.name;
            String str2 = next.value;
            if (str != null) {
                if (str2 == null) {
                    str2 = "";
                }
                sb.append(Data.urlEncode(str) + "=" + Data.urlEncode(str2));
                i++;
            }
        }
        return sb.toString();
    }

    public static <T> T forceCast(Object obj) {
        return (T) forceCast(obj, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T forceCast(Object obj, T t) {
        boolean z = true;
        if (obj == 0) {
            return t;
        }
        if (obj instanceof Byte) {
            byte byteValue = ((Byte) obj).byteValue();
            if (t instanceof Boolean) {
                return (T) Boolean.valueOf(byteValue != 0);
            } else if (t instanceof Short) {
                return (T) Short.valueOf(byteValue);
            } else {
                if (t instanceof Character) {
                    return (T) Character.valueOf((char) byteValue);
                }
                if (t instanceof Integer) {
                    return (T) Integer.valueOf(byteValue);
                }
                if (t instanceof Float) {
                    return (T) Float.valueOf(byteValue);
                }
                if (t instanceof Long) {
                    return (T) Long.valueOf(byteValue);
                }
                if (t instanceof Double) {
                    return (T) Double.valueOf(byteValue);
                }
            }
        } else if (obj instanceof Character) {
            char charValue = ((Character) obj).charValue();
            if (t instanceof Byte) {
                return (T) Byte.valueOf((byte) charValue);
            }
            if (t instanceof Boolean) {
                if (charValue == 0) {
                    z = false;
                }
                return (T) Boolean.valueOf(z);
            } else if (t instanceof Short) {
                return (T) Short.valueOf((short) charValue);
            } else {
                if (t instanceof Integer) {
                    return (T) Integer.valueOf(charValue);
                }
                if (t instanceof Float) {
                    return (T) Float.valueOf(charValue);
                }
                if (t instanceof Long) {
                    return (T) Long.valueOf(charValue);
                }
                if (t instanceof Double) {
                    return (T) Double.valueOf(charValue);
                }
            }
        } else if (obj instanceof Short) {
            short shortValue = ((Short) obj).shortValue();
            if (t instanceof Byte) {
                return (T) Byte.valueOf((byte) shortValue);
            }
            if (t instanceof Boolean) {
                if (shortValue == 0) {
                    z = false;
                }
                return (T) Boolean.valueOf(z);
            } else if (t instanceof Character) {
                return (T) Character.valueOf((char) shortValue);
            } else {
                if (t instanceof Integer) {
                    return (T) Integer.valueOf(shortValue);
                }
                if (t instanceof Float) {
                    return (T) Float.valueOf(shortValue);
                }
                if (t instanceof Long) {
                    return (T) Long.valueOf(shortValue);
                }
                if (t instanceof Double) {
                    return (T) Double.valueOf(shortValue);
                }
            }
        } else if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            if (t instanceof Byte) {
                return (T) Byte.valueOf((byte) intValue);
            }
            if (t instanceof Boolean) {
                if (intValue == 0) {
                    z = false;
                }
                return (T) Boolean.valueOf(z);
            } else if (t instanceof Character) {
                return (T) Character.valueOf((char) intValue);
            } else {
                if (t instanceof Short) {
                    return (T) Short.valueOf((short) intValue);
                }
                if (t instanceof Float) {
                    return (T) Float.valueOf(intValue);
                }
                if (t instanceof Long) {
                    return (T) Long.valueOf(intValue);
                }
                if (t instanceof Double) {
                    return (T) Double.valueOf(intValue);
                }
            }
        } else if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            if (t instanceof Byte) {
                return (T) Byte.valueOf((byte) floatValue);
            }
            if (t instanceof Boolean) {
                if (floatValue == 0.0f) {
                    z = false;
                }
                return (T) Boolean.valueOf(z);
            } else if (t instanceof Character) {
                return (T) Character.valueOf((char) floatValue);
            } else {
                if (t instanceof Short) {
                    return (T) Short.valueOf((short) floatValue);
                }
                if (t instanceof Integer) {
                    return (T) Integer.valueOf((int) floatValue);
                }
                if (t instanceof Long) {
                    return (T) Long.valueOf(floatValue);
                }
                if (t instanceof Double) {
                    return (T) Double.valueOf(floatValue);
                }
            }
        } else if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            if (t instanceof Byte) {
                return (T) Byte.valueOf((byte) longValue);
            }
            if (t instanceof Boolean) {
                if (longValue == 0) {
                    z = false;
                }
                return (T) Boolean.valueOf(z);
            } else if (t instanceof Character) {
                return (T) Character.valueOf((char) longValue);
            } else {
                if (t instanceof Short) {
                    return (T) Short.valueOf((short) longValue);
                }
                if (t instanceof Integer) {
                    return (T) Integer.valueOf((int) longValue);
                }
                if (t instanceof Float) {
                    return (T) Float.valueOf((float) longValue);
                }
                if (t instanceof Double) {
                    return (T) Double.valueOf(longValue);
                }
            }
        } else if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            if (t instanceof Byte) {
                return (T) Byte.valueOf((byte) doubleValue);
            }
            if (t instanceof Boolean) {
                if (doubleValue == 0.0d) {
                    z = false;
                }
                return (T) Boolean.valueOf(z);
            } else if (t instanceof Character) {
                return (T) Character.valueOf((char) doubleValue);
            } else {
                if (t instanceof Short) {
                    return (T) Short.valueOf((short) doubleValue);
                }
                if (t instanceof Integer) {
                    return (T) Integer.valueOf((int) doubleValue);
                }
                if (t instanceof Float) {
                    return (T) Float.valueOf((float) doubleValue);
                }
                if (t instanceof Long) {
                    return (T) Long.valueOf((long) doubleValue);
                }
            }
        }
        return obj;
    }

    public static int getAnimRes(Context context, String str) {
        return getResId(context, "anim", str);
    }

    public static int getBitmapRes(Context context, String str) {
        return getResId(context, "drawable", str);
    }

    public static String getCachePath(Context context, String str) {
        DeviceHelper deviceHelper;
        String str2 = context.getFilesDir().getAbsolutePath() + "/Mob/cache/";
        try {
            if (DeviceHelper.getInstance(context).getSdcardState()) {
                str2 = deviceHelper.getSdcardPath() + "/Mob/" + deviceHelper.getPackageName() + "/cache/";
            }
        } catch (Throwable th) {
            MobLog.getInstance().m5971d(th);
        }
        if (!TextUtils.isEmpty(str)) {
            str2 = str2 + str + "/";
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2;
    }

    public static String getCacheRoot(Context context) {
        DeviceHelper deviceHelper;
        String str = context.getFilesDir().getAbsolutePath() + "/Mob/";
        if (DeviceHelper.getInstance(context).getSdcardState()) {
            str = deviceHelper.getSdcardPath() + "/Mob/";
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static int getColorRes(Context context, String str) {
        return getResId(context, "color", str);
    }

    public static long getFileSize(File file) {
        if (!file.exists()) {
            return 0L;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        int i = 0;
        for (String str : file.list()) {
            i = (int) (i + getFileSize(new File(file, str)));
        }
        return i;
    }

    public static long getFileSize(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return getFileSize(new File(str));
    }

    public static int getIdRes(Context context, String str) {
        return getResId(context, "id", str);
    }

    public static String getImageCachePath(Context context) {
        return getCachePath(context, C2172a.f7286b);
    }

    public static int getLayoutRes(Context context, String str) {
        return getResId(context, "layout", str);
    }

    public static synchronized Uri getMediaUri(Context context, String str, String str2) {
        Uri uri;
        synchronized (ResHelper.class) {
            final Object obj = new Object();
            mediaUri = null;
            MediaScannerConnection.scanFile(context, new String[]{str}, new String[]{str2}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.mob.tools.utils.ResHelper.1
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public void onScanCompleted(String str3, Uri uri2) {
                    Uri unused = ResHelper.mediaUri = uri2;
                    synchronized (obj) {
                        obj.notifyAll();
                    }
                }
            });
            try {
                if (mediaUri == null) {
                    synchronized (obj) {
                        obj.wait(AbstractC0517a.f1169e);
                    }
                }
            } catch (InterruptedException e) {
            }
            uri = mediaUri;
            mediaUri = null;
        }
        return uri;
    }

    public static int getPluralsRes(Context context, String str) {
        return getResId(context, "plurals", str);
    }

    public static int getRawRes(Context context, String str) {
        return getResId(context, "raw", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getResId(Context context, String str, String str2) {
        int intValue;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        if (f17341rp != null) {
            try {
                Method method = f17341rp.getClass().getMethod("getResId", Context.class, String.class, String.class);
                method.setAccessible(true);
                intValue = ((Integer) method.invoke(f17341rp, context, str, str2)).intValue();
            } catch (Throwable th) {
                MobLog.getInstance().m5971d(th);
            }
            if (intValue <= 0) {
                return intValue;
            }
            String packageName = context.getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                return intValue;
            }
            if (intValue <= 0 && (intValue = context.getResources().getIdentifier(str2, str, packageName)) <= 0) {
                intValue = context.getResources().getIdentifier(str2.toLowerCase(), str, packageName);
            }
            if (intValue > 0) {
                return intValue;
            }
            Log.w("MobTools", "failed to parse " + str + " resource \"" + str2 + "\"");
            return intValue;
        }
        intValue = 0;
        if (intValue <= 0) {
        }
    }

    public static int getScreenHeight(Context context) {
        return getScreenSize(context)[1];
    }

    public static int[] getScreenSize(Context context) {
        WindowManager windowManager;
        try {
            windowManager = (WindowManager) context.getSystemService("window");
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            windowManager = null;
        }
        if (windowManager == null) {
            return new int[]{0, 0};
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (Build.VERSION.SDK_INT < 13) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
        }
        try {
            Point point = new Point();
            Method method = defaultDisplay.getClass().getMethod("getRealSize", Point.class);
            method.setAccessible(true);
            method.invoke(defaultDisplay, point);
            return new int[]{point.x, point.y};
        } catch (Throwable th2) {
            MobLog.getInstance().m5959w(th2);
            return new int[]{0, 0};
        }
    }

    public static int getScreenWidth(Context context) {
        return getScreenSize(context)[0];
    }

    public static int getStringArrayRes(Context context, String str) {
        return getResId(context, "array", str);
    }

    public static int getStringRes(Context context, String str) {
        return getResId(context, "string", str);
    }

    public static int getStyleRes(Context context, String str) {
        return getResId(context, "style", str);
    }

    public static int getTextLengthInWord(String str) {
        int i = 0;
        for (char c : str == null ? new char[0] : str.toCharArray()) {
            i += c < 256 ? 1 : 2;
        }
        return i;
    }

    public static Date longToDate(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return calendar.getTime();
    }

    public static String longToTime(long j, int i) {
        String str = "yyyy-MM-dd kk:mm:ss";
        switch (i) {
            case 1:
                str = "yyyy";
                break;
            case 2:
                str = C2258f.f7528c;
                break;
            case 5:
                str = "yyyy-MM-dd";
                break;
            case 10:
                str = "yyyy-MM-dd kk";
                break;
            case 12:
                str = "yyyy-MM-dd kk:mm";
                break;
        }
        return new SimpleDateFormat(str).format(Long.valueOf(j));
    }

    public static int parseInt(String str) {
        return parseInt(str, 10);
    }

    public static int parseInt(String str, int i) {
        return Integer.parseInt(str, i);
    }

    public static long parseLong(String str) {
        return parseLong(str, 10);
    }

    public static long parseLong(String str, int i) {
        return Long.parseLong(str, i);
    }

    public static Uri pathToContentUri(Context context, String str) {
        Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (query == null || !query.moveToFirst()) {
            if (!new File(str).exists()) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("_data", str);
            return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        }
        return Uri.withAppendedPath(Uri.parse("content://media/external/images/media"), "" + query.getInt(query.getColumnIndex("_id")));
    }

    public static int pxToDip(Context context, int i) {
        if (density <= 0.0f) {
            density = context.getResources().getDisplayMetrics().density;
        }
        return (int) ((i / density) + 0.5f);
    }

    public static Object readObjectFromFile(String str) {
        File file;
        if (!TextUtils.isEmpty(str)) {
            try {
                file = new File(str);
                if (!file.exists()) {
                    file = null;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                file = null;
            }
            if (file == null) {
                return null;
            }
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new GZIPInputStream(new FileInputStream(file)));
                Object readObject = objectInputStream.readObject();
                objectInputStream.close();
                return readObject;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static boolean saveObjectToFile(String str, Object obj) {
        File file;
        if (!TextUtils.isEmpty(str)) {
            try {
                file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            } catch (Throwable th) {
                th.printStackTrace();
                file = null;
            }
            if (file != null) {
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream(file)));
                    objectOutputStream.writeObject(obj);
                    objectOutputStream.flush();
                    objectOutputStream.close();
                    return true;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
        return false;
    }

    public static void setResourceProvider(Object obj) {
        try {
            if (obj.getClass().getMethod("getResId", Context.class, String.class, String.class) == null) {
                return;
            }
            f17341rp = obj;
        } catch (Throwable th) {
            MobLog.getInstance().m5971d(th);
        }
    }

    public static long strToDate(String str) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str, new ParsePosition(0)).getTime();
    }

    public static String toString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static String toWordText(String str, int i) {
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int length = charArray.length;
        int i2 = i * 2;
        for (int i3 = 0; i3 < length; i3++) {
            char c = charArray[i3];
            i2 -= c < 256 ? 1 : 2;
            if (i2 < 0) {
                return sb.toString();
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static Bundle urlToBundle(String str) {
        int indexOf = str.indexOf("://");
        try {
            URL url = new URL(indexOf >= 0 ? "http://" + str.substring(indexOf + 1) : "http://" + str);
            Bundle decodeUrl = decodeUrl(url.getQuery());
            decodeUrl.putAll(decodeUrl(url.getRef()));
            return decodeUrl;
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            return new Bundle();
        }
    }

    public static Uri videoPathToContentUri(Context context, String str) {
        Cursor query = context.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (query == null || !query.moveToFirst()) {
            if (!new File(str).exists()) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("_data", str);
            return context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
        }
        return Uri.withAppendedPath(Uri.parse("content://media/external/video/media"), "" + query.getInt(query.getColumnIndex("_id")));
    }
}
