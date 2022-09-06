package cn.sharesdk.framework.p075b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import cn.sharesdk.framework.p075b.p076a.C0653e;
import cn.sharesdk.framework.p075b.p077b.AbstractC0657c;
import cn.sharesdk.framework.p075b.p077b.C0659e;
import cn.sharesdk.framework.p075b.p077b.C0662g;
import cn.sharesdk.framework.utils.C0683d;
import com.mob.commons.SHARESDK;
import com.mob.commons.clt.DvcClt;
import com.mob.commons.clt.PkgClt;
import com.mob.commons.clt.RtClt;
import com.mob.commons.iosbridge.UDPServer;
import com.mob.tools.SSDKHandlerThread;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.FileLocker;
import com.tencent.p227mm.sdk.platformtools.Util;
import java.io.File;
import java.util.Calendar;
import p004b.p005a.p006a.p028b.p054o.AbstractC0517a;
/* renamed from: cn.sharesdk.framework.b.d */
/* loaded from: classes.dex */
public class C0664d extends SSDKHandlerThread {

    /* renamed from: a */
    private static C0664d f1550a;

    /* renamed from: b */
    private Context f1551b;

    /* renamed from: c */
    private DeviceHelper f1552c;

    /* renamed from: d */
    private C0648a f1553d;

    /* renamed from: e */
    private String f1554e;

    /* renamed from: f */
    private Handler f1555f;

    /* renamed from: g */
    private boolean f1556g;

    /* renamed from: h */
    private int f1557h;

    /* renamed from: i */
    private boolean f1558i;

    /* renamed from: j */
    private long f1559j;

    /* renamed from: k */
    private boolean f1560k;

    /* renamed from: l */
    private File f1561l;

    /* renamed from: m */
    private FileLocker f1562m = new FileLocker();

    private C0664d(Context context, String str) {
        this.f1551b = context;
        this.f1554e = str;
        this.f1552c = DeviceHelper.getInstance(context);
        this.f1553d = C0648a.m19708a(context, str);
        this.f1561l = new File(context.getFilesDir(), ".statistics");
        if (!this.f1561l.exists()) {
            try {
                this.f1561l.createNewFile();
            } catch (Exception e) {
                C0683d.m19513a().m5971d(e);
            }
        }
    }

    /* renamed from: a */
    public static synchronized C0664d m19618a(Context context, String str) {
        C0664d c0664d = null;
        synchronized (C0664d.class) {
            if (f1550a == null) {
                if (context != null && !TextUtils.isEmpty(str)) {
                    f1550a = new C0664d(context.getApplicationContext(), str);
                }
            }
            c0664d = f1550a;
        }
        return c0664d;
    }

    /* renamed from: a */
    private void m19620a() {
        boolean m19614b = m19614b();
        if (m19614b) {
            if (this.f1560k) {
                return;
            }
            this.f1560k = m19614b;
            this.f1559j = System.currentTimeMillis();
            m19616a(new C0662g());
        } else if (!this.f1560k) {
        } else {
            this.f1560k = m19614b;
            long currentTimeMillis = System.currentTimeMillis() - this.f1559j;
            C0659e c0659e = new C0659e();
            c0659e.f1522a = currentTimeMillis;
            m19616a(c0659e);
        }
    }

    /* renamed from: b */
    private void m19613b(AbstractC0657c abstractC0657c) {
        abstractC0657c.f1507f = this.f1552c.getDeviceKey();
        abstractC0657c.f1508g = this.f1554e;
        abstractC0657c.f1509h = this.f1552c.getPackageName();
        abstractC0657c.f1510i = this.f1552c.getAppVersion();
        abstractC0657c.f1511j = String.valueOf(60000 + this.f1557h);
        abstractC0657c.f1512k = this.f1552c.getPlatformCode();
        abstractC0657c.f1513l = this.f1552c.getDetailNetworkTypeForStatic();
        if (TextUtils.isEmpty(this.f1554e)) {
            Log.w("ShareSDKCore", "Your appKey of ShareSDK is null , this will cause its data won't be count!");
        } else if (!"cn.sharesdk.demo".equals(abstractC0657c.f1509h) && ("api20".equals(this.f1554e) || "androidv1101".equals(this.f1554e))) {
            Log.w("ShareSDKCore", "Your app is using the appkey of ShareSDK Demo, this will cause its data won't be count!");
        }
        abstractC0657c.f1514m = this.f1552c.getDeviceData();
    }

    /* renamed from: b */
    private boolean m19614b() {
        DeviceHelper deviceHelper = DeviceHelper.getInstance(this.f1551b);
        String topTaskPackageName = deviceHelper.getTopTaskPackageName();
        String packageName = deviceHelper.getPackageName();
        return packageName != null && packageName.equals(topTaskPackageName);
    }

    /* renamed from: c */
    private void m19612c(AbstractC0657c abstractC0657c) {
        try {
            this.f1553d.m19704a(abstractC0657c);
            abstractC0657c.mo19649b(this.f1551b);
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
            C0683d.m19513a().m5972d(abstractC0657c.toString(), new Object[0]);
        }
    }

    /* renamed from: a */
    public void m19619a(int i) {
        this.f1557h = i;
    }

    /* renamed from: a */
    public void m19617a(Handler handler) {
        this.f1555f = handler;
    }

    /* renamed from: a */
    public void m19616a(AbstractC0657c abstractC0657c) {
        if (this.f1558i) {
            m19613b(abstractC0657c);
            if (!abstractC0657c.mo19651a(this.f1551b)) {
                C0683d.m19513a().m5972d("Drop event: " + abstractC0657c.toString(), new Object[0]);
                return;
            }
            Message message = new Message();
            message.what = 3;
            message.obj = abstractC0657c;
            try {
                this.handler.sendMessage(message);
            } catch (Throwable th) {
                C0683d.m19513a().m5971d(th);
            }
        }
    }

    /* renamed from: a */
    public void m19615a(boolean z) {
        this.f1556g = z;
    }

    @Override // com.mob.tools.SSDKHandlerThread
    protected void onMessage(Message message) {
        switch (message.what) {
            case 1:
                m19620a();
                try {
                    this.handler.sendEmptyMessageDelayed(1, 5000L);
                    return;
                } catch (Throwable th) {
                    C0683d.m19513a().m5971d(th);
                    return;
                }
            case 2:
                try {
                    this.f1553d.m19693c();
                    return;
                } catch (Throwable th2) {
                    C0683d.m19513a().m5971d(th2);
                    return;
                }
            case 3:
                if (message.obj == null) {
                    return;
                }
                m19612c((AbstractC0657c) message.obj);
                this.handler.removeMessages(2);
                this.handler.sendEmptyMessageDelayed(2, AbstractC0517a.f1169e);
                return;
            case 4:
                long longValue = C0653e.m19677a(this.f1551b).m19660f().longValue();
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(longValue);
                int i = calendar.get(1);
                int i2 = calendar.get(2);
                int i3 = calendar.get(5);
                calendar.setTimeInMillis(System.currentTimeMillis());
                int i4 = calendar.get(1);
                int i5 = calendar.get(2);
                int i6 = calendar.get(5);
                if (i != i4 || i2 != i5 || i3 != i6) {
                    this.f1553d.m19695b();
                }
                this.handler.sendEmptyMessageDelayed(4, Util.MILLSECONDS_OF_HOUR);
                return;
            default:
                return;
        }
    }

    @Override // com.mob.tools.SSDKHandlerThread
    protected void onStart(Message message) {
        if (!this.f1558i) {
            this.f1558i = true;
            try {
                this.f1562m.setLockFile(this.f1561l.getAbsolutePath());
                if (!this.f1562m.lock(false)) {
                    return;
                }
                this.f1553d.m19709a();
                this.f1553d.m19695b();
                SHARESDK.setAppKey(this.f1554e);
                new SHARESDK().getDuid(this.f1551b);
                DvcClt.startCollector(this.f1551b);
                PkgClt.startCollector(this.f1551b);
                RtClt.startCollector(this.f1551b);
                UDPServer.start(this.f1551b);
                this.handler.sendEmptyMessageDelayed(4, Util.MILLSECONDS_OF_HOUR);
                this.f1553d.m19696a(this.f1556g);
                this.handler.sendEmptyMessage(1);
                this.handler.sendEmptyMessage(2);
            } catch (Throwable th) {
                C0683d.m19513a().m5971d(th);
            }
        }
    }

    @Override // com.mob.tools.SSDKHandlerThread
    protected void onStop(Message message) {
        if (this.f1558i) {
            long currentTimeMillis = System.currentTimeMillis() - this.f1559j;
            C0659e c0659e = new C0659e();
            c0659e.f1522a = currentTimeMillis;
            m19616a(c0659e);
            this.f1558i = false;
            try {
                this.f1555f.sendEmptyMessage(1);
            } catch (Throwable th) {
                C0683d.m19513a().m5971d(th);
            }
            f1550a = null;
            this.handler.getLooper().quit();
        }
    }
}
