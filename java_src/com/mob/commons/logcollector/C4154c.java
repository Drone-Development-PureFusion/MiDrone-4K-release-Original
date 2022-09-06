package com.mob.commons.logcollector;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.mob.tools.MobLog;
import com.mob.tools.SSDKHandlerThread;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.GZIPOutputStream;
import p004b.p005a.p006a.p028b.p044i.p045a.C0413a;
/* renamed from: com.mob.commons.logcollector.c */
/* loaded from: classes.dex */
public class C4154c extends SSDKHandlerThread {

    /* renamed from: a */
    private static C4154c f17325a;

    /* renamed from: b */
    private static String f17326b = "http://api.exc.mob.com:80";

    /* renamed from: d */
    private Context f17328d;

    /* renamed from: f */
    private C4155d f17330f;

    /* renamed from: g */
    private File f17331g;

    /* renamed from: e */
    private NetworkHelper f17329e = new NetworkHelper();

    /* renamed from: c */
    private HashMap<String, Integer> f17327c = new HashMap<>();

    /* renamed from: h */
    private FileLocker f17332h = new FileLocker();

    private C4154c(Context context) {
        this.f17328d = context.getApplicationContext();
        this.f17330f = C4155d.m5986a(context);
        this.f17331g = new File(context.getFilesDir(), ".lock");
        if (!this.f17331g.exists()) {
            try {
                this.f17331g.createNewFile();
            } catch (Exception e) {
                MobLog.getInstance().m5959w(e);
            }
        }
        NLog.setContext(context);
        startThread();
    }

    /* renamed from: a */
    public static synchronized C4154c m6000a(Context context) {
        C4154c c4154c;
        synchronized (C4154c.class) {
            if (f17325a == null) {
                f17325a = new C4154c(context);
            }
            c4154c = f17325a;
        }
        return c4154c;
    }

    /* renamed from: a */
    private String m5998a(String str) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = byteArrayInputStream.read(bArr, 0, 1024);
            if (read == -1) {
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                byteArrayInputStream.close();
                return Base64.encodeToString(byteArray, 2);
            }
            gZIPOutputStream.write(bArr, 0, read);
        }
    }

    /* renamed from: a */
    private void m6001a(int i, String str, String str2, String[] strArr) {
        try {
            if (!this.f17330f.m5983b()) {
                return;
            }
            if ("none".equals((String) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f17328d), "getDetailNetworkTypeForStatic", new Object[0]))) {
                throw new IllegalStateException("network is disconnected!");
            }
            ArrayList<C4156e> m5973a = C4157f.m5973a(this.f17328d, strArr);
            for (int i2 = 0; i2 < m5973a.size(); i2++) {
                C4156e c4156e = m5973a.get(i2);
                HashMap<String, Object> m5991c = m5991c(i, str, str2);
                m5991c.put("errmsg", c4156e.f17335a);
                if (m5997a(m5998a(new Hashon().fromHashMap(m5991c)), true)) {
                    C4157f.m5974a(this.f17328d, c4156e.f17336b);
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().m5965i(th);
        }
    }

    /* renamed from: a */
    private void m5999a(Message message) {
        this.handler.sendMessageDelayed(message, 1000L);
    }

    /* renamed from: a */
    private boolean m5997a(String str, boolean z) {
        try {
            if ("none".equals((String) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f17328d), "getDetailNetworkTypeForStatic", new Object[0]))) {
                throw new IllegalStateException("network is disconnected!");
            }
            ArrayList<KVPair<String>> arrayList = new ArrayList<>();
            arrayList.add(new KVPair<>(C0413a.f922b, str));
            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
            networkTimeOut.readTimout = 10000;
            networkTimeOut.connectionTimeout = 10000;
            this.f17329e.httpPost(m5992c(), arrayList, null, null, networkTimeOut);
            return true;
        } catch (Throwable th) {
            MobLog.getInstance().m5965i(th);
            return false;
        }
    }

    /* renamed from: b */
    private String m5996b() {
        return f17326b + "/errconf";
    }

    /* renamed from: b */
    private void m5994b(int i, String str, String str2) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f17328d);
        arrayList.add(new KVPair<>("key", str2));
        arrayList.add(new KVPair<>("sdk", str));
        arrayList.add(new KVPair<>("apppkg", String.valueOf(ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getPackageName", new Object[0]))));
        arrayList.add(new KVPair<>("appver", String.valueOf(ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getAppVersion", new Object[0]))));
        arrayList.add(new KVPair<>("sdkver", String.valueOf(i)));
        arrayList.add(new KVPair<>("plat", String.valueOf(ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getPlatformCode", new Object[0]))));
        try {
            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
            networkTimeOut.readTimout = 10000;
            networkTimeOut.connectionTimeout = 10000;
            String httpPost = this.f17329e.httpPost(m5996b(), arrayList, null, null, networkTimeOut);
            MobLog.getInstance().m5966i("get server config == %s", httpPost);
            HashMap fromJson = new Hashon().fromJson(httpPost);
            if ("-200".equals(String.valueOf(fromJson.get("status")))) {
                MobLog.getInstance().m5966i("error log server config response fail !!", new Object[0]);
                return;
            }
            Object obj = fromJson.get("result");
            if (obj == null || !(obj instanceof HashMap)) {
                return;
            }
            HashMap hashMap = (HashMap) obj;
            if (hashMap.containsKey("timestamp")) {
                this.f17330f.m5987a(System.currentTimeMillis() - ResHelper.parseLong(String.valueOf(hashMap.get("timestamp"))));
            }
            if ("1".equals(String.valueOf(hashMap.get("enable")))) {
                this.f17330f.m5984a(true);
            } else {
                this.f17330f.m5984a(false);
            }
            Object obj2 = hashMap.get("upconf");
            if (obj2 != null && (obj2 instanceof HashMap)) {
                HashMap hashMap2 = (HashMap) obj2;
                String valueOf = String.valueOf(hashMap2.get("crash"));
                String valueOf2 = String.valueOf(hashMap2.get("sdkerr"));
                String valueOf3 = String.valueOf(hashMap2.get("apperr"));
                this.f17330f.m5988a(Integer.parseInt(valueOf));
                this.f17330f.m5982b(Integer.parseInt(valueOf2));
                this.f17330f.m5980c(Integer.parseInt(valueOf3));
            }
            if (hashMap.containsKey("requesthost") && hashMap.containsKey("requestport")) {
                String valueOf4 = String.valueOf(hashMap.get("requesthost"));
                String valueOf5 = String.valueOf(hashMap.get("requestport"));
                if (!TextUtils.isEmpty(valueOf4) && !TextUtils.isEmpty(valueOf5)) {
                    f17326b = "http://" + valueOf4 + ":" + valueOf5;
                }
            }
            Object obj3 = hashMap.get("filter");
            if (obj3 == null || !(obj3 instanceof ArrayList)) {
                return;
            }
            ArrayList arrayList2 = (ArrayList) obj3;
            if (arrayList2.size() <= 0) {
                return;
            }
            HashMap hashMap3 = new HashMap();
            hashMap3.put("fakelist", arrayList2);
            this.f17330f.m5985a(new Hashon().fromHashMap(hashMap3));
        } catch (Throwable th) {
            MobLog.getInstance().m5971d(th);
        }
    }

    /* renamed from: b */
    private void m5993b(Message message) {
        try {
            int i = message.arg1;
            Object[] objArr = (Object[]) message.obj;
            String str = (String) objArr[0];
            String str2 = (String) objArr[1];
            m5994b(i, str, str2);
            m6001a(i, str, str2, null);
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
        }
    }

    /* renamed from: c */
    private String m5992c() {
        return f17326b + "/errlog";
    }

    /* renamed from: c */
    private HashMap<String, Object> m5991c(int i, String str, String str2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f17328d);
        hashMap.put("key", str2);
        hashMap.put("plat", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getPlatformCode", new Object[0]));
        hashMap.put("sdk", str);
        hashMap.put("sdkver", Integer.valueOf(i));
        hashMap.put("appname", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getAppName", new Object[0]));
        hashMap.put("apppkg", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getPackageName", new Object[0]));
        hashMap.put("appver", String.valueOf(ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getAppVersion", new Object[0])));
        hashMap.put("deviceid", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getDeviceKey", new Object[0]));
        hashMap.put(C3947a.f16893d, ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getModel", new Object[0]));
        hashMap.put("mac", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getMacAddress", new Object[0]));
        hashMap.put("udid", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getDeviceId", new Object[0]));
        hashMap.put("sysver", String.valueOf(ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getOSVersionInt", new Object[0])));
        hashMap.put("networktype", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getDetailNetworkTypeForStatic", new Object[0]));
        return hashMap;
    }

    /* renamed from: c */
    private void m5990c(Message message) {
        ArrayList arrayList;
        try {
            int i = message.arg1;
            Object[] objArr = (Object[]) message.obj;
            String str = (String) objArr[0];
            String str2 = (String) objArr[1];
            String str3 = (String) objArr[2];
            int i2 = 1;
            if (message.arg2 == 0) {
                i2 = 2;
            } else if (message.arg2 == 2) {
                i2 = 1;
            }
            String m5977f = this.f17330f.m5977f();
            if (!TextUtils.isEmpty(m5977f) && (arrayList = (ArrayList) new Hashon().fromJson(m5977f).get("fakelist")) != null && arrayList.size() > 0) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    String str4 = (String) it2.next();
                    if (!TextUtils.isEmpty(str4) && str3.contains(str4)) {
                        return;
                    }
                }
            }
            int m5981c = this.f17330f.m5981c();
            int m5979d = this.f17330f.m5979d();
            int m5978e = this.f17330f.m5978e();
            if (3 == i2 && -1 == m5978e) {
                return;
            }
            if (1 == i2 && -1 == m5981c) {
                return;
            }
            if (2 == i2 && -1 == m5979d) {
                return;
            }
            String MD5 = Data.MD5(str3);
            this.f17332h.setLockFile(this.f17331g.getAbsolutePath());
            if (this.f17332h.lock(false)) {
                C4157f.m5976a(this.f17328d, System.currentTimeMillis() - this.f17330f.m5989a(), str3, i2, MD5);
            }
            this.f17332h.release();
            this.f17327c.remove(MD5);
            if (3 == i2 && 1 == m5978e) {
                m6001a(i, str, str2, new String[]{String.valueOf(3)});
            } else if (1 == i2 && 1 == m5981c) {
                m6001a(i, str, str2, new String[]{String.valueOf(1)});
            } else if (2 != i2 || 1 != m5979d) {
            } else {
                m6001a(i, str, str2, new String[]{String.valueOf(2)});
            }
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
        }
    }

    /* renamed from: a */
    public Context m6004a() {
        return this.f17328d;
    }

    /* renamed from: a */
    public void m6003a(int i, int i2, String str, String str2, String str3) {
        Message message = new Message();
        message.what = 101;
        message.arg1 = i;
        message.arg2 = i2;
        message.obj = new Object[]{str, str2, str3};
        this.handler.sendMessage(message);
    }

    /* renamed from: a */
    public void m6002a(int i, String str, String str2) {
        Message message = new Message();
        message.what = 100;
        message.arg1 = i;
        message.obj = new Object[]{str, str2};
        this.handler.sendMessage(message);
    }

    /* renamed from: b */
    public void m5995b(int i, int i2, String str, String str2, String str3) {
        m6003a(i, i2, str, str2, str3);
        try {
            this.handler.wait();
        } catch (Throwable th) {
        }
    }

    @Override // com.mob.tools.SSDKHandlerThread
    protected void onMessage(Message message) {
        switch (message.what) {
            case 100:
                m5993b(message);
                return;
            case 101:
                m5990c(message);
                return;
            default:
                return;
        }
    }
}
