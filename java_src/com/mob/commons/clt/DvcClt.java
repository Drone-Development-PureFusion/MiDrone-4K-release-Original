package com.mob.commons.clt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import com.mob.commons.C4125a;
import com.mob.commons.C4131b;
import com.mob.commons.C4145d;
import com.mob.commons.C4151f;
import com.mob.commons.LockAction;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import com.tencent.p227mm.sdk.platformtools.Util;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
/* loaded from: classes.dex */
public class DvcClt implements Handler.Callback {

    /* renamed from: a */
    private static DvcClt f17283a;

    /* renamed from: b */
    private Context f17284b;

    /* renamed from: d */
    private Handler f17286d;

    /* renamed from: f */
    private BroadcastReceiver f17288f;

    /* renamed from: c */
    private Hashon f17285c = new Hashon();

    /* renamed from: e */
    private Random f17287e = new Random();

    private DvcClt(Context context) {
        this.f17284b = context.getApplicationContext();
    }

    /* renamed from: a */
    private void m6087a() {
        MobHandlerThread mobHandlerThread = new MobHandlerThread() { // from class: com.mob.commons.clt.DvcClt.1
            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: a */
            public void m6075a() {
                super.run();
            }

            @Override // com.mob.tools.MobHandlerThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                C4145d.m6037a(new File(ResHelper.getCacheRoot(DvcClt.this.f17284b), "comm/locks/.dic_lock"), new LockAction() { // from class: com.mob.commons.clt.DvcClt.1.1
                    @Override // com.mob.commons.LockAction
                    public boolean run(FileLocker fileLocker) {
                        m6075a();
                        return false;
                    }
                });
            }
        };
        mobHandlerThread.start();
        this.f17286d = new Handler(mobHandlerThread.getLooper(), this);
        this.f17286d.sendEmptyMessage(1);
        this.f17286d.sendEmptyMessage(2);
        this.f17286d.sendEmptyMessage(3);
        this.f17286d.sendEmptyMessage(5);
    }

    /* renamed from: a */
    private void m6086a(Location location, int i) {
        if (location != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("accuracy", Float.valueOf(location.getAccuracy()));
            hashMap.put("latitude", Double.valueOf(location.getLatitude()));
            hashMap.put("longitude", Double.valueOf(location.getLongitude()));
            hashMap.put("location_type", Integer.valueOf(i));
            HashMap<String, Object> hashMap2 = new HashMap<>();
            hashMap2.put("type", "LOCATION");
            hashMap2.put("data", hashMap);
            hashMap2.put("datetime", Long.valueOf(C4125a.m6143a(this.f17284b)));
            C4131b.m6103a(this.f17284b).m6104a(C4125a.m6143a(this.f17284b), hashMap2);
        }
    }

    /* renamed from: b */
    private void m6084b() {
        try {
            HashMap hashMap = new HashMap();
            Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f17284b);
            hashMap.put("phonename", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getBluetoothName", new Object[0]));
            hashMap.put("signmd5", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getSignMD5", new Object[0]));
            String MD5 = Data.MD5(this.f17285c.fromHashMap(hashMap));
            String m6026a = C4151f.m6026a(this.f17284b);
            if (m6026a != null && m6026a.equals(MD5)) {
                return;
            }
            HashMap<String, Object> hashMap2 = new HashMap<>();
            hashMap2.put("type", "DEVEXT");
            hashMap2.put("data", hashMap);
            hashMap2.put("datetime", Long.valueOf(C4125a.m6143a(this.f17284b)));
            C4131b.m6103a(this.f17284b).m6104a(C4125a.m6143a(this.f17284b), hashMap2);
            C4151f.m6024a(this.f17284b, MD5);
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
        }
    }

    /* renamed from: c */
    private boolean m6082c() {
        long m6023b = C4151f.m6023b(this.f17284b);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(m6023b);
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i3 = calendar.get(5);
        long m6143a = C4125a.m6143a(this.f17284b);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(m6143a);
        return (i == calendar2.get(1) && i2 == calendar2.get(2) && i3 == calendar2.get(5)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m6080d() {
        synchronized (f17283a) {
            HashMap hashMap = new HashMap();
            Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f17284b);
            hashMap.put("ssid", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getSSID", new Object[0]));
            hashMap.put("bssid", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getBssid", new Object[0]));
            HashMap<String, Object> hashMap2 = new HashMap<>();
            hashMap2.put("type", "WIFI_INFO");
            hashMap2.put("data", hashMap);
            long m6143a = C4125a.m6143a(this.f17284b);
            hashMap2.put("datetime", Long.valueOf(m6143a));
            C4131b.m6103a(this.f17284b).m6104a(C4125a.m6143a(this.f17284b), hashMap2);
            C4151f.m6025a(this.f17284b, m6143a);
            C4151f.m6021b(this.f17284b, Data.MD5(this.f17285c.fromHashMap(hashMap)));
        }
    }

    /* renamed from: e */
    private void m6079e() {
        if (this.f17288f == null) {
            this.f17288f = new BroadcastReceiver() { // from class: com.mob.commons.clt.DvcClt.2
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    Parcelable parcelableExtra;
                    try {
                        if (!"android.net.wifi.STATE_CHANGE".equals(intent.getAction()) || (parcelableExtra = intent.getParcelableExtra("networkInfo")) == null || !((NetworkInfo) parcelableExtra).isAvailable()) {
                            return;
                        }
                        HashMap hashMap = new HashMap();
                        Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", context);
                        hashMap.put("ssid", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getSSID", new Object[0]));
                        hashMap.put("bssid", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getBssid", new Object[0]));
                        String MD5 = Data.MD5(DvcClt.this.f17285c.fromHashMap(hashMap));
                        String m6020c = C4151f.m6020c(context);
                        if ((m6020c != null && m6020c.equals(MD5)) || !C4125a.m6126n(context)) {
                            return;
                        }
                        DvcClt.this.m6080d();
                    } catch (Throwable th) {
                        MobLog.getInstance().m5959w(th);
                    }
                }
            };
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        try {
            this.f17284b.registerReceiver(this.f17288f, intentFilter);
        } catch (Throwable th) {
        }
    }

    /* renamed from: f */
    private void m6078f() {
        if (this.f17288f != null) {
            try {
                this.f17284b.unregisterReceiver(this.f17288f);
            } catch (Throwable th) {
            }
            this.f17288f = null;
        }
    }

    /* renamed from: g */
    private void m6077g() {
        int i;
        HashMap hashMap = new HashMap();
        Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f17284b);
        try {
            i = Integer.parseInt((String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getCarrier", new Object[0]));
        } catch (Throwable th) {
            i = -1;
        }
        hashMap.put("carrier", Integer.valueOf(i));
        hashMap.put("simopname", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getCarrierName", new Object[0]));
        hashMap.put("lac", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getCellLac", new Object[0]));
        hashMap.put("cell", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getCellId", new Object[0]));
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("type", "BSINFO");
        hashMap2.put("data", hashMap);
        hashMap2.put("datetime", Long.valueOf(C4125a.m6143a(this.f17284b)));
        C4131b.m6103a(this.f17284b).m6104a(C4125a.m6143a(this.f17284b), hashMap2);
        C4151f.m6019c(this.f17284b, Data.MD5(this.f17285c.fromHashMap(hashMap)));
        C4151f.m6022b(this.f17284b, C4125a.m6143a(this.f17284b) + (C4125a.m6129k(this.f17284b) * 1000));
    }

    /* renamed from: h */
    private boolean m6076h() {
        int i;
        HashMap hashMap = new HashMap();
        Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f17284b);
        try {
            i = Integer.parseInt((String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getCarrier", new Object[0]));
        } catch (Throwable th) {
            i = -1;
        }
        hashMap.put("carrier", Integer.valueOf(i));
        hashMap.put("simopname", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getCarrierName", new Object[0]));
        hashMap.put("lac", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getCellLac", new Object[0]));
        hashMap.put("cell", ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getCellId", new Object[0]));
        String MD5 = Data.MD5(this.f17285c.fromHashMap(hashMap));
        String m6018d = C4151f.m6018d(this.f17284b);
        return m6018d == null || !m6018d.equals(MD5);
    }

    public static synchronized void startCollector(Context context) {
        synchronized (DvcClt.class) {
            if (f17283a == null) {
                f17283a = new DvcClt(context);
                f17283a.m6087a();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0084, code lost:
        if (m6076h() != false) goto L28;
     */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (C4125a.m6131i(this.f17284b)) {
                    m6084b();
                    break;
                }
                break;
            case 2:
                if (C4125a.m6126n(this.f17284b)) {
                    if (m6082c()) {
                        m6080d();
                    }
                    m6079e();
                } else {
                    m6078f();
                }
                this.f17286d.sendEmptyMessageDelayed(2, Util.MILLSECONDS_OF_HOUR);
                break;
            case 3:
                if (C4125a.m6130j(this.f17284b)) {
                    try {
                        m6077g();
                    } catch (Throwable th) {
                        MobLog.getInstance().m5959w(th);
                    }
                    this.f17286d.sendEmptyMessageDelayed(4, (this.f17287e.nextInt(120) + Opcodes.GETFIELD) * 1000);
                    break;
                }
                break;
            case 4:
                if (C4125a.m6130j(this.f17284b)) {
                    if (C4125a.m6143a(this.f17284b) + (C4125a.m6129k(this.f17284b) * 1000) >= C4125a.m6143a(this.f17284b)) {
                        try {
                            break;
                        } catch (Throwable th2) {
                            MobLog.getInstance().m5959w(th2);
                        }
                    }
                    m6077g();
                    this.f17286d.sendEmptyMessageDelayed(4, (this.f17287e.nextInt(120) + Opcodes.GETFIELD) * 1000);
                    break;
                }
                break;
            case 5:
                if (C4125a.m6128l(this.f17284b)) {
                    try {
                        Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f17284b);
                        m6086a((Location) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getLocation", 30, 0, true), 1);
                        m6086a((Location) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "getLocation", 15, 0, true), 2);
                    } catch (Throwable th3) {
                        MobLog.getInstance().m5959w(th3);
                    }
                }
                this.f17286d.sendEmptyMessageDelayed(5, C4125a.m6127m(this.f17284b) * 1000);
                break;
        }
        return false;
    }
}
