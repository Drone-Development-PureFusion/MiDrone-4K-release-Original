package com.p080b;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.amap.api.fence.Fence;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.APSService;
import com.amap.api.location.LocationManagerBase;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.aps.amapapi.model.AmapLoc;
import com.tencent.p227mm.sdk.plugin.MMPluginProviderConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import p004b.p005a.p006a.p028b.p054o.AbstractC0517a;
/* renamed from: com.b.a */
/* loaded from: classes.dex */
public class C1390a implements LocationManagerBase {

    /* renamed from: t */
    public static boolean f4767t = false;

    /* renamed from: a */
    AMapLocationClientOption f4773a;

    /* renamed from: b */
    HandlerC1395c f4774b;

    /* renamed from: e */
    C1524dg f4777e;

    /* renamed from: g */
    C1527di f4779g;

    /* renamed from: j */
    C1394b f4782j;

    /* renamed from: k */
    Intent f4783k;

    /* renamed from: u */
    private Context f4792u;

    /* renamed from: c */
    C1525dh f4775c = null;

    /* renamed from: v */
    private boolean f4793v = false;

    /* renamed from: w */
    private boolean f4794w = true;

    /* renamed from: d */
    ArrayList<AMapLocationListener> f4776d = new ArrayList<>();

    /* renamed from: f */
    boolean f4778f = false;

    /* renamed from: x */
    private long f4795x = 0;

    /* renamed from: y */
    private boolean f4796y = true;

    /* renamed from: z */
    private boolean f4797z = false;

    /* renamed from: A */
    private boolean f4768A = false;

    /* renamed from: h */
    Messenger f4780h = null;

    /* renamed from: i */
    Messenger f4781i = null;

    /* renamed from: l */
    int f4784l = 0;

    /* renamed from: m */
    int f4785m = 0;

    /* renamed from: n */
    boolean f4786n = false;

    /* renamed from: o */
    long f4787o = 0;

    /* renamed from: p */
    long f4788p = 0;

    /* renamed from: q */
    AMapLocation f4789q = null;

    /* renamed from: r */
    long f4790r = 0;

    /* renamed from: s */
    long f4791s = 0;

    /* renamed from: B */
    private ServiceConnection f4769B = new ServiceConnectionC1396d();

    /* renamed from: C */
    private ArrayList<C1393a> f4770C = new ArrayList<>();

    /* renamed from: D */
    private int f4771D = 0;

    /* renamed from: E */
    private AMapLocation f4772E = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.b.a$a */
    /* loaded from: classes.dex */
    public class C1393a {

        /* renamed from: a */
        double f4800a;

        /* renamed from: b */
        double f4801b;

        /* renamed from: c */
        long f4802c;

        /* renamed from: d */
        float f4803d;

        /* renamed from: e */
        float f4804e;

        /* renamed from: f */
        int f4805f;

        /* renamed from: g */
        String f4806g;

        C1393a(AMapLocation aMapLocation, int i) {
            this.f4800a = aMapLocation.getLatitude();
            this.f4801b = aMapLocation.getLongitude();
            this.f4802c = aMapLocation.getTime();
            this.f4803d = aMapLocation.getAccuracy();
            this.f4804e = aMapLocation.getSpeed();
            this.f4805f = i;
            this.f4806g = aMapLocation.getProvider();
        }

        public boolean equals(Object obj) {
            try {
                C1393a c1393a = (C1393a) obj;
                if (this.f4800a != c1393a.f4800a) {
                    return false;
                }
                return this.f4801b == c1393a.f4801b;
            } catch (Throwable th) {
                return false;
            }
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.f4800a);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuffer.append(this.f4801b);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuffer.append(this.f4803d);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuffer.append(this.f4802c);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuffer.append(this.f4804e);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuffer.append(this.f4805f);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuffer.append(this.f4806g);
            return stringBuffer.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.b.a$b */
    /* loaded from: classes.dex */
    public class C1394b extends Thread {

        /* renamed from: a */
        boolean f4808a = false;

        public C1394b(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f4808a = true;
            while (this.f4808a && !Thread.interrupted()) {
                try {
                    if (C1390a.this.f4768A) {
                        if (!C1390a.this.f4797z) {
                            C1390a.this.f4775c.m15692a(C1390a.this.f4773a);
                            C1390a.this.f4797z = true;
                        }
                    } else if (C1390a.this.f4797z) {
                        C1390a.this.f4775c.m15694a();
                        C1390a.this.f4797z = false;
                    }
                    if (AMapLocationClientOption.AMapLocationMode.Device_Sensors.equals(C1390a.this.f4773a.getLocationMode())) {
                        try {
                            Thread.sleep(2000L);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    } else if (!AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.equals(C1390a.this.f4773a.getLocationMode()) || (C1390a.this.m16468d() && (!C1390a.this.f4773a.isGpsFirst() || !C1390a.this.f4773a.isOnceLocation() || C1390a.this.m16466e() || C1390a.this.f4786n))) {
                        while (true) {
                            if (C1390a.this.f4780h != null) {
                                break;
                            }
                            try {
                                C1390a.this.f4784l++;
                            } catch (InterruptedException e2) {
                                Thread.currentThread().interrupt();
                            }
                            if (C1390a.this.f4784l > 100) {
                                Message obtain = Message.obtain();
                                Bundle bundle = new Bundle();
                                AmapLoc amapLoc = new AmapLoc();
                                amapLoc.m16538b(10);
                                amapLoc.m16537b("请检查配置文件是否配置服务");
                                bundle.putParcelable("location", amapLoc);
                                obtain.setData(bundle);
                                obtain.what = 1;
                                if (C1390a.this.f4774b != null) {
                                    C1390a.this.f4774b.sendMessage(obtain);
                                }
                            } else {
                                Thread.sleep(50L);
                            }
                        }
                        C1390a.this.f4788p = 0L;
                        C1390a.this.f4793v = true;
                        Message obtain2 = Message.obtain();
                        obtain2.what = 1;
                        Bundle bundle2 = new Bundle();
                        bundle2.putBoolean("isfirst", C1390a.this.f4796y);
                        bundle2.putBoolean("wifiactivescan", C1390a.this.f4773a.isWifiActiveScan());
                        bundle2.putBoolean("isNeedAddress", C1390a.this.f4773a.isNeedAddress());
                        bundle2.putBoolean("isKillProcess", C1390a.this.f4773a.isKillProcess());
                        bundle2.putBoolean("isOffset", C1390a.this.f4773a.isOffset());
                        bundle2.putLong("httptimeout", C1390a.this.f4773a.getHttpTimeOut());
                        obtain2.setData(bundle2);
                        obtain2.replyTo = C1390a.this.f4781i;
                        if (C1390a.this.f4780h != null) {
                            C1390a.this.f4780h.send(obtain2);
                        }
                        C1390a.this.f4796y = false;
                        try {
                            Thread.sleep(C1390a.this.f4773a.getInterval());
                        } catch (InterruptedException e3) {
                            Thread.currentThread().interrupt();
                        }
                    } else {
                        try {
                            if (C1390a.this.f4773a.isOnceLocation() && C1390a.this.f4788p == 0) {
                                C1390a.this.f4788p = C1477bs.m15997b();
                            }
                            Thread.sleep(2000L);
                        } catch (InterruptedException e4) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } catch (Throwable th) {
                    C1514cx.m15728a(th, "AMapLocationManager", "run part6");
                }
                C1514cx.m15728a(th, "AMapLocationManager", "run part6");
            }
            C1390a.this.f4793v = false;
        }
    }

    /* renamed from: com.b.a$c */
    /* loaded from: classes.dex */
    public static class HandlerC1395c extends Handler {

        /* renamed from: a */
        C1390a f4810a;

        public HandlerC1395c(C1390a c1390a) {
            this.f4810a = null;
            this.f4810a = c1390a;
        }

        public HandlerC1395c(C1390a c1390a, Looper looper) {
            super(looper);
            this.f4810a = null;
            this.f4810a = c1390a;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0043 A[Catch: Throwable -> 0x0233, TRY_LEAVE, TryCatch #6 {Throwable -> 0x0233, blocks: (B:21:0x003d, B:23:0x0043), top: B:20:0x003d }] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:70:0x0134 A[Catch: Throwable -> 0x013b, TRY_LEAVE, TryCatch #12 {Throwable -> 0x013b, blocks: (B:68:0x012a, B:70:0x0134), top: B:67:0x012a }] */
        /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(Message message) {
            AMapLocation aMapLocation;
            AMapLocation aMapLocation2;
            super.handleMessage(message);
            AMapLocation aMapLocation3 = null;
            switch (message.what) {
                case 1:
                    try {
                        Bundle data = message.getData();
                        if (data != null) {
                            data.setClassLoader(AmapLoc.class.getClassLoader());
                            AMapLocation m15730a = C1514cx.m15730a((AmapLoc) data.getParcelable("location"));
                            if (m15730a == null) {
                                try {
                                    aMapLocation3 = new AMapLocation("");
                                    aMapLocation3.setErrorCode(8);
                                    aMapLocation = aMapLocation3;
                                } catch (Throwable th) {
                                    th = th;
                                    aMapLocation3 = m15730a;
                                    C1514cx.m15728a(th, "AMapLocationManager", "handleMessage LBS_LOCATIONSUCCESS");
                                    if (this.f4810a.f4777e != null) {
                                    }
                                    if (aMapLocation3 != null) {
                                    }
                                    if (this.f4810a.f4773a.isOnceLocation()) {
                                    }
                                }
                            } else {
                                aMapLocation = m15730a;
                            }
                            try {
                                aMapLocation.setProvider("lbs");
                            } catch (Throwable th2) {
                                aMapLocation3 = aMapLocation;
                                th = th2;
                                C1514cx.m15728a(th, "AMapLocationManager", "handleMessage LBS_LOCATIONSUCCESS");
                                if (this.f4810a.f4777e != null) {
                                }
                                if (aMapLocation3 != null) {
                                }
                                if (this.f4810a.f4773a.isOnceLocation()) {
                                }
                            }
                        } else {
                            aMapLocation = null;
                        }
                        aMapLocation3 = aMapLocation;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    break;
                case 2:
                    try {
                        aMapLocation2 = (AMapLocation) message.obj;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                    try {
                        if (aMapLocation2.getErrorCode() == 0) {
                            this.f4810a.f4787o = C1477bs.m15997b();
                            this.f4810a.f4786n = true;
                        }
                        if (!C1390a.f4767t && this.f4810a.f4780h != null) {
                            Message obtain = Message.obtain();
                            obtain.what = 0;
                            obtain.replyTo = this.f4810a.f4781i;
                            this.f4810a.f4780h.send(obtain);
                            C1390a.f4767t = true;
                        }
                        aMapLocation3 = aMapLocation2;
                    } catch (Throwable th5) {
                        aMapLocation3 = aMapLocation2;
                        th = th5;
                        C1514cx.m15728a(th, "AMapLocationManager", "handleMessage GPS_LOCATIONSUCCESS");
                        if (this.f4810a.f4777e != null) {
                        }
                        if (aMapLocation3 != null) {
                        }
                        if (this.f4810a.f4773a.isOnceLocation()) {
                        }
                    }
                    break;
                case 5:
                    this.f4810a.f4787o = C1477bs.m15997b();
                    this.f4810a.f4786n = true;
                    return;
                case 6:
                default:
                    return;
                case 100:
                    try {
                        this.f4810a.m16464f();
                        return;
                    } catch (Throwable th6) {
                        C1514cx.m15728a(th6, "AMapLocationManager", "handleMessage FASTSKY");
                        return;
                    }
                case 101:
                    try {
                        Message obtain2 = Message.obtain();
                        obtain2.what = 2;
                        if (this.f4810a.f4780h != null) {
                            this.f4810a.f4785m = 0;
                            this.f4810a.f4780h.send(obtain2);
                        } else {
                            this.f4810a.f4785m++;
                            if (this.f4810a.f4785m < 10) {
                                this.f4810a.f4774b.sendEmptyMessageDelayed(101, 50L);
                            }
                        }
                        return;
                    } catch (Throwable th7) {
                        C1514cx.m15728a(th7, "AMapLocationManager", "handleMessage START_SOCKET");
                        return;
                    }
                case 102:
                    try {
                        Message obtain3 = Message.obtain();
                        obtain3.what = 3;
                        if (this.f4810a.f4780h != null) {
                            this.f4810a.f4785m = 0;
                            this.f4810a.f4780h.send(obtain3);
                        } else {
                            this.f4810a.f4785m++;
                            if (this.f4810a.f4785m < 10) {
                                this.f4810a.f4774b.sendEmptyMessageDelayed(102, 50L);
                            }
                        }
                        return;
                    } catch (Throwable th8) {
                        C1514cx.m15728a(th8, "AMapLocationManager", "handleMessage STOP_SOCKET");
                        return;
                    }
            }
            try {
                if (this.f4810a.f4777e != null) {
                    this.f4810a.f4777e.m15697a(aMapLocation3);
                }
            } catch (Throwable th9) {
                C1514cx.m15728a(th9, "AMapLocationManager", "handleMessage part6");
            }
            if (aMapLocation3 != null) {
                try {
                    if (!this.f4810a.f4794w) {
                        if (aMapLocation3.getErrorCode() == 0) {
                            long time = aMapLocation3.getTime();
                            aMapLocation3 = this.f4810a.m16479a(this.f4810a.f4789q, aMapLocation3);
                            aMapLocation3.setTime(time);
                            if (this.f4810a.f4771D == 0) {
                                C1393a m16480a = this.f4810a.m16480a(aMapLocation3, this.f4810a.f4771D);
                                if (this.f4810a.f4770C.size() > 1) {
                                    this.f4810a.f4770C.add(m16480a);
                                } else if (this.f4810a.f4770C.size() == 1) {
                                    this.f4810a.f4770C.set(0, m16480a);
                                } else {
                                    this.f4810a.f4770C.add(m16480a);
                                }
                            } else {
                                C1393a m16480a2 = this.f4810a.m16480a(this.f4810a.f4772E, this.f4810a.f4771D);
                                if (!this.f4810a.f4770C.contains(m16480a2) && this.f4810a.f4770C.size() <= 9) {
                                    this.f4810a.f4770C.add(m16480a2);
                                }
                            }
                            if (this.f4810a.f4770C.size() >= 10) {
                                StringBuffer stringBuffer = new StringBuffer();
                                Iterator it2 = this.f4810a.f4770C.iterator();
                                while (it2.hasNext()) {
                                    stringBuffer.append(((C1393a) it2.next()).toString());
                                    stringBuffer.append("#");
                                }
                                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                                C1514cx.m15724b(stringBuffer.toString());
                                this.f4810a.f4770C.clear();
                            }
                        }
                        this.f4810a.f4790r = C1477bs.m15997b();
                        this.f4810a.f4789q = aMapLocation3;
                        if (GeocodeSearch.GPS.equals(aMapLocation3.getProvider()) || this.f4810a.m16468d()) {
                            if (this.f4810a.f4779g != null) {
                                this.f4810a.f4779g.m15689a(aMapLocation3);
                            }
                            Iterator<AMapLocationListener> it3 = this.f4810a.f4776d.iterator();
                            while (it3.hasNext()) {
                                it3.next().onLocationChanged(aMapLocation3);
                            }
                        }
                    }
                } catch (Throwable th10) {
                    C1514cx.m15728a(th10, "AMapLocationManager", "handleMessage part7");
                }
            }
            try {
                if (this.f4810a.f4773a.isOnceLocation()) {
                    return;
                }
                this.f4810a.stopLocation();
            } catch (Throwable th11) {
                C1514cx.m15728a(th11, "AMapLocationManager", "handleMessage part8");
            }
        }
    }

    /* renamed from: com.b.a$d */
    /* loaded from: classes.dex */
    class ServiceConnectionC1396d implements ServiceConnection {
        ServiceConnectionC1396d() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C1390a.this.f4780h = new Messenger(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C1390a.this.f4780h = null;
        }
    }

    public C1390a(Context context, Intent intent) {
        this.f4783k = null;
        this.f4792u = context;
        this.f4783k = intent;
        m16474b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public AMapLocation m16479a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        this.f4772E = aMapLocation2;
        long m15997b = C1477bs.m15997b();
        if (aMapLocation == null) {
            this.f4791s = 0L;
            this.f4771D = 0;
            return aMapLocation2;
        } else if (aMapLocation.getLocationType() != 1) {
            this.f4791s = 0L;
            this.f4771D = 0;
            return aMapLocation2;
        } else if (aMapLocation2.getLocationType() != 1) {
            this.f4791s = 0L;
            this.f4771D = 0;
            return aMapLocation2;
        } else if (m15997b - this.f4790r >= 5000) {
            this.f4791s = 0L;
            this.f4771D = 0;
            return aMapLocation2;
        } else if (C1477bs.m15998a(new double[]{aMapLocation.getLatitude(), aMapLocation.getLongitude(), aMapLocation2.getLatitude(), aMapLocation2.getLongitude()}) <= (((aMapLocation.getSpeed() + aMapLocation2.getSpeed()) * ((float) (aMapLocation2.getTime() - aMapLocation.getTime()))) / 2000.0f) + (2.0f * (aMapLocation.getAccuracy() + aMapLocation2.getAccuracy())) + 3000.0f) {
            this.f4791s = 0L;
            this.f4771D = 0;
            return aMapLocation2;
        } else {
            if (this.f4791s == 0) {
                this.f4791s = C1477bs.m15997b();
            }
            if (m15997b - this.f4791s < 30000) {
                this.f4771D = 1;
                return aMapLocation;
            }
            this.f4791s = 0L;
            this.f4771D = 0;
            return aMapLocation2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public C1393a m16480a(AMapLocation aMapLocation, int i) {
        return new C1393a(aMapLocation, i);
    }

    /* renamed from: a */
    private void m16481a(Intent intent) {
        if (intent == null) {
            try {
                intent = new Intent(this.f4792u, APSService.class);
            } catch (Throwable th) {
                C1514cx.m15728a(th, "AMapLocationManager", "startService");
                return;
            }
        }
        intent.putExtra(MMPluginProviderConstants.OAuth.API_KEY, C1514cx.f5406a);
        String m15663e = C1533dm.m15663e(this.f4792u);
        intent.putExtra("packageName", this.f4792u.getPackageName());
        intent.putExtra("sha1AndPackage", m15663e);
        this.f4792u.bindService(intent, this.f4769B, 1);
    }

    /* renamed from: b */
    private void m16474b() {
        m16481a(this.f4783k);
        this.f4779g = C1527di.m15690a(this.f4792u);
        if (Looper.myLooper() == null) {
            this.f4774b = new HandlerC1395c(this, this.f4792u.getMainLooper());
        } else {
            this.f4774b = new HandlerC1395c(this);
        }
        this.f4781i = new Messenger(this.f4774b);
        this.f4775c = new C1525dh(this.f4792u, this.f4774b);
        try {
            this.f4777e = new C1524dg(this.f4792u);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "AMapLocationManager", "init");
        }
    }

    /* renamed from: c */
    private void m16471c() {
        if (this.f4782j == null) {
            this.f4782j = new C1394b("locationThread");
            this.f4782j.setPriority(5);
            this.f4782j.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public boolean m16468d() {
        return C1477bs.m15997b() - this.f4787o > AbstractC0517a.f1169e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public boolean m16466e() {
        return this.f4788p != 0 && C1477bs.m15997b() - this.f4788p > 30000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m16464f() {
        boolean z = true;
        boolean z2 = false;
        try {
            if (this.f4792u.checkCallingOrSelfPermission("android.permission.SYSTEM_ALERT_WINDOW") == 0) {
                z2 = true;
            } else if (this.f4792u instanceof Activity) {
                z2 = true;
                z = false;
            } else {
                z = false;
            }
            if (!z2) {
                m16462g();
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f4792u);
            builder.setMessage(C1473bp.m16039j());
            if (!"".equals(C1473bp.m16038k()) && C1473bp.m16038k() != null) {
                builder.setPositiveButton(C1473bp.m16038k(), new DialogInterface.OnClickListener() { // from class: com.b.a.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C1390a.this.m16462g();
                        dialogInterface.cancel();
                    }
                });
            }
            builder.setNegativeButton(C1473bp.m16037l(), new DialogInterface.OnClickListener() { // from class: com.b.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            AlertDialog create = builder.create();
            if (z) {
                create.getWindow().setType(2003);
            }
            create.setCanceledOnTouchOutside(false);
            create.show();
        } catch (Throwable th) {
            m16462g();
            C1514cx.m15728a(th, "AMapLocationManager", "showDialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m16462g() {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.autonavi.minimap", C1473bp.m16034o()));
            intent.setFlags(268435456);
            intent.setData(Uri.parse(C1473bp.m16036m()));
            this.f4792u.startActivity(intent);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "AMapLocationManager", "callAMap part1");
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(C1473bp.m16035n()));
                intent2.setFlags(268435456);
                this.f4792u.startActivity(intent2);
            } catch (Throwable th2) {
                C1514cx.m15728a(th2, "AMapLocationManager", "callAMap part2");
            }
        }
    }

    /* renamed from: a */
    void m16482a() {
        if (this.f4782j != null) {
            this.f4782j.f4808a = false;
            this.f4782j.interrupt();
        }
        this.f4782j = null;
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void addGeoFenceAlert(String str, double d, double d2, float f, long j, PendingIntent pendingIntent) {
        Fence fence = new Fence();
        fence.f1954b = str;
        fence.f1956d = d;
        fence.f1955c = d2;
        fence.f1957e = f;
        fence.f1953a = pendingIntent;
        fence.m19124a(j);
        if (this.f4777e != null) {
            this.f4777e.m15698a(fence, fence.f1953a);
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public AMapLocation getLastKnownLocation() {
        try {
            return this.f4779g.m15691a();
        } catch (Throwable th) {
            C1514cx.m15728a(th, "AMapLocationManager", "getLastKnownLocation");
            return null;
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public String getVersion() {
        return "2.4.1";
    }

    @Override // com.amap.api.location.LocationManagerBase
    public boolean isStarted() {
        return this.f4793v;
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void onDestroy() {
        this.f4796y = true;
        stopLocation();
        if (this.f4777e != null) {
            this.f4777e.m15704a();
        }
        if (this.f4769B != null) {
            this.f4792u.unbindService(this.f4769B);
        }
        if (this.f4776d != null) {
            this.f4776d.clear();
            this.f4776d = null;
        }
        this.f4769B = null;
        if (this.f4774b != null) {
            this.f4774b.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void removeGeoFenceAlert(PendingIntent pendingIntent) {
        if (this.f4777e != null) {
            this.f4777e.m15703a(pendingIntent);
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void removeGeoFenceAlert(PendingIntent pendingIntent, String str) {
        if (this.f4777e != null) {
            this.f4777e.m15701a(pendingIntent, str);
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void setLocationListener(AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener == null) {
            throw new IllegalArgumentException("listener参数不能为null");
        }
        if (this.f4776d == null) {
            this.f4776d = new ArrayList<>();
        }
        if (this.f4776d.contains(aMapLocationListener)) {
            return;
        }
        this.f4776d.add(aMapLocationListener);
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void setLocationOption(AMapLocationClientOption aMapLocationClientOption) {
        this.f4773a = aMapLocationClientOption;
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void startAssistantLocation() {
        if (this.f4774b != null) {
            this.f4774b.sendEmptyMessage(101);
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void startLocation() {
        if (this.f4773a == null) {
            this.f4773a = new AMapLocationClientOption();
        }
        this.f4794w = false;
        switch (this.f4773a.getLocationMode()) {
            case Battery_Saving:
                this.f4768A = false;
                break;
            case Hight_Accuracy:
            case Device_Sensors:
                this.f4768A = true;
                break;
            default:
                this.f4768A = false;
                break;
        }
        m16471c();
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void stopAssistantLocation() {
        if (this.f4774b != null) {
            this.f4774b.sendEmptyMessage(102);
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void stopLocation() {
        this.f4768A = false;
        m16482a();
        if (this.f4797z) {
            this.f4775c.m15694a();
            this.f4797z = false;
        }
        this.f4786n = false;
        this.f4793v = false;
        this.f4794w = true;
        this.f4788p = 0L;
        this.f4787o = 0L;
        this.f4785m = 0;
        this.f4784l = 0;
        this.f4789q = null;
        this.f4790r = 0L;
        this.f4770C.clear();
        this.f4771D = 0;
        this.f4772E = null;
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void unRegisterLocationListener(AMapLocationListener aMapLocationListener) {
        if (!this.f4776d.isEmpty() && this.f4776d.contains(aMapLocationListener)) {
            this.f4776d.remove(aMapLocationListener);
        }
        if (this.f4776d.isEmpty()) {
            stopLocation();
        }
    }
}
