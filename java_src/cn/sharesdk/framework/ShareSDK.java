package cn.sharesdk.framework;

import android.content.Context;
import android.graphics.Bitmap;
import com.mob.tools.utils.DeviceHelper;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ShareSDK {
    public static final String SDK_TAG = "SHARESDK";
    public static final int SDK_VERSION_INT = 70;

    /* renamed from: a */
    private static C0673f f1437a;

    /* renamed from: b */
    private static boolean f1438b = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m19765a(int i, String str) {
        m19759b();
        return f1437a.m19561a(i, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m19764a(Bitmap bitmap) {
        m19759b();
        return f1437a.m19560a(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m19763a(String str) {
        m19759b();
        return f1437a.m19539c(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m19761a(String str, boolean z, int i, String str2) {
        m19759b();
        return f1437a.m19552a(str, z, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m19766a(int i, int i2) {
        m19759b();
        f1437a.m19563a(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m19762a(String str, String str2) {
        m19759b();
        f1437a.m19554a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m19767a() {
        m19759b();
        return f1437a.m19538d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m19760a(HashMap<String, Object> hashMap) {
        m19759b();
        return f1437a.m19551a(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static String m19758b(String str, String str2) {
        m19759b();
        return f1437a.m19545b(str, str2);
    }

    /* renamed from: b */
    private static void m19759b() {
        if (f1437a == null) {
            throw new RuntimeException("Please call ShareSDK.initSDK(Context) in the main process before any action.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static boolean m19757b(HashMap<String, Object> hashMap) {
        m19759b();
        return f1437a.m19544b(hashMap);
    }

    public static void closeDebug() {
        f1438b = false;
    }

    public static void deleteCache() {
        m19759b();
        f1437a.m19536e();
    }

    @Deprecated
    public static Platform getPlatform(Context context, String str) {
        m19759b();
        return f1437a.m19556a(str);
    }

    public static Platform getPlatform(String str) {
        m19759b();
        return f1437a.m19556a(str);
    }

    public static synchronized Platform[] getPlatformList() {
        Platform[] m19565a;
        synchronized (ShareSDK.class) {
            m19759b();
            m19565a = f1437a.m19565a();
        }
        return m19565a;
    }

    @Deprecated
    public static synchronized Platform[] getPlatformList(Context context) {
        Platform[] platformList;
        synchronized (ShareSDK.class) {
            platformList = getPlatformList();
        }
        return platformList;
    }

    public static int getSDKVersionCode() {
        return 70;
    }

    public static String getSDKVersionName() {
        m19759b();
        return f1437a.m19549b();
    }

    public static <T extends Service> T getService(Class<T> cls) {
        m19759b();
        return (T) f1437a.m19540c(cls);
    }

    public static void initSDK(Context context) {
        initSDK(context, null, true);
    }

    public static void initSDK(Context context, String str) {
        initSDK(context, str, true);
    }

    public static void initSDK(Context context, String str, boolean z) {
        if (DeviceHelper.getInstance(context) == null) {
            throw new RuntimeException("The param of context is null which in ShareSDK.initSDK(context)!");
        }
        if (f1437a != null) {
            return;
        }
        C0673f c0673f = new C0673f(context, str);
        c0673f.m19550a(z);
        c0673f.startThread();
        f1437a = c0673f;
    }

    public static void initSDK(Context context, boolean z) {
        initSDK(context, null, z);
    }

    public static boolean isDebug() {
        return f1438b;
    }

    public static boolean isRemoveCookieOnAuthorize() {
        m19759b();
        return f1437a.m19542c();
    }

    public static void logApiEvent(String str, int i) {
        m19759b();
        f1437a.m19555a(str, i);
    }

    public static void logDemoEvent(int i, Platform platform) {
        m19759b();
        f1437a.m19562a(i, platform);
    }

    public static String platformIdToName(int i) {
        m19759b();
        return f1437a.m19541c(i);
    }

    public static int platformNameToId(String str) {
        m19759b();
        return f1437a.m19546b(str);
    }

    public static void registerPlatform(Class<? extends CustomPlatform> cls) {
        m19759b();
        f1437a.m19537d(cls);
    }

    public static void registerService(Class<? extends Service> cls) {
        m19759b();
        f1437a.m19557a(cls);
    }

    public static void removeCookieOnAuthorize(boolean z) {
        m19759b();
        f1437a.m19543b(z);
    }

    public static void setConnTimeout(int i) {
        m19759b();
        f1437a.m19564a(i);
    }

    public static void setPlatformDevInfo(String str, HashMap<String, Object> hashMap) {
        m19759b();
        f1437a.m19553a(str, hashMap);
    }

    public static void setReadTimeout(int i) {
        m19759b();
        f1437a.m19548b(i);
    }

    public static void stopSDK() {
    }

    public static void stopSDK(Context context) {
        stopSDK();
    }

    public static void unregisterPlatform(Class<? extends CustomPlatform> cls) {
        m19759b();
        f1437a.m19535e(cls);
    }

    public static void unregisterService(Class<? extends Service> cls) {
        m19759b();
        f1437a.m19547b(cls);
    }
}
