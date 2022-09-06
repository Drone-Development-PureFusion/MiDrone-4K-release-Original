package com.p080b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import com.amap.api.location.APSServiceBase;
import com.autonavi.aps.amapapi.model.AmapLoc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;
import org.p248a.p249a.C5083e;
/* renamed from: com.b.bw */
/* loaded from: classes.dex */
public class C1481bw implements APSServiceBase {

    /* renamed from: a */
    Context f5196a;

    /* renamed from: m */
    AmapLoc f5208m;

    /* renamed from: p */
    AmapLoc f5211p;

    /* renamed from: u */
    C1484c f5216u;

    /* renamed from: b */
    boolean f5197b = false;

    /* renamed from: c */
    Messenger f5198c = null;

    /* renamed from: v */
    private volatile boolean f5217v = false;

    /* renamed from: w */
    private boolean f5218w = false;

    /* renamed from: x */
    private boolean f5219x = false;

    /* renamed from: d */
    String f5199d = null;

    /* renamed from: e */
    HandlerC1483b f5200e = new HandlerC1483b(this);

    /* renamed from: f */
    C1482a f5201f = null;

    /* renamed from: g */
    boolean f5202g = false;

    /* renamed from: h */
    Vector<Messenger> f5203h = new Vector<>();

    /* renamed from: i */
    Vector<Messenger> f5204i = new Vector<>();

    /* renamed from: y */
    private int f5220y = 0;

    /* renamed from: z */
    private boolean f5221z = false;

    /* renamed from: A */
    private boolean f5192A = false;

    /* renamed from: B */
    private C1430as f5193B = null;

    /* renamed from: j */
    volatile boolean f5205j = false;

    /* renamed from: k */
    boolean f5206k = false;

    /* renamed from: l */
    Object f5207l = new Object();

    /* renamed from: n */
    long f5209n = C1477bs.m15997b();

    /* renamed from: C */
    private boolean f5194C = true;

    /* renamed from: D */
    private String f5195D = "";

    /* renamed from: o */
    JSONObject f5210o = new JSONObject();

    /* renamed from: q */
    ServerSocket f5212q = null;

    /* renamed from: r */
    boolean f5213r = false;

    /* renamed from: s */
    Socket f5214s = null;

    /* renamed from: t */
    boolean f5215t = false;

    /* renamed from: com.b.bw$a */
    /* loaded from: classes.dex */
    class C1482a extends Thread {
        C1482a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Messenger messenger;
            try {
                C1481bw.this.m15946f();
            } catch (Throwable th) {
                try {
                    try {
                        C1481bw.this.f5195D = th.getMessage();
                        C1481bw.this.f5194C = false;
                        C1514cx.m15728a(th, "APSServiceCore", "run part1");
                    } catch (RemoteException e) {
                        C1514cx.m15728a(e, "APSServiceCore", "run part3");
                        if (C1481bw.this.m15953c()) {
                            return;
                        }
                        C1481bw.this.m15942h();
                        return;
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                        if (C1481bw.this.m15953c()) {
                            return;
                        }
                        C1481bw.this.m15942h();
                        return;
                    }
                } catch (Throwable th2) {
                    if (!C1481bw.this.m15953c()) {
                        C1481bw.this.m15942h();
                    }
                    throw th2;
                }
            }
            while (C1481bw.this.f5205j) {
                Messenger messenger2 = null;
                if (C1481bw.this.f5206k) {
                    if (C1481bw.this.f5194C) {
                        try {
                            C1481bw.this.f5208m = C1481bw.this.m15957a(C1481bw.this.f5202g);
                            if (C1481bw.this.f5193B != null) {
                                long m16516k = C1481bw.this.f5208m.m16516k();
                                C1481bw.this.f5208m = C1481bw.this.f5193B.m16303a(C1481bw.this.f5208m, new String[0]);
                                C1481bw.this.f5208m.m16545a(m16516k);
                            }
                        } catch (Throwable th3) {
                            C1481bw.this.f5208m = C1481bw.this.m15968a(8, th3.getMessage());
                            C1514cx.m15728a(th3, "APSServiceCore", "run part2");
                        }
                    } else {
                        C1481bw.this.f5208m = C1481bw.this.m15968a(9, C1481bw.this.f5195D);
                    }
                    synchronized (C1481bw.this.f5207l) {
                        if (C1481bw.this.f5208m != null && C1481bw.this.f5208m.m16549a() == 0) {
                            C1481bw.this.f5209n = C1477bs.m15997b();
                        }
                        C1481bw.this.f5206k = false;
                        if (C1481bw.this.f5203h == null || C1481bw.this.f5203h.size() <= 0) {
                            messenger = null;
                        } else {
                            int size = C1481bw.this.f5203h.size();
                            while (0 < size) {
                                Message obtain = Message.obtain();
                                Bundle bundle = new Bundle();
                                bundle.putParcelable("location", C1481bw.this.f5208m);
                                obtain.setData(bundle);
                                obtain.what = 1;
                                Messenger messenger3 = C1481bw.this.f5203h.get(0);
                                messenger3.send(obtain);
                                C1481bw.this.f5203h.remove(0);
                                size--;
                                messenger2 = messenger3;
                            }
                            messenger = messenger2;
                        }
                    }
                } else {
                    synchronized (C1481bw.this.f5207l) {
                        if (C1481bw.this.m15953c()) {
                            C1481bw.this.f5207l.wait();
                        }
                    }
                    messenger = null;
                }
                if (C1481bw.this.f5219x) {
                    C1481bw.this.m15948e();
                    C1481bw.this.m15950d();
                    C1481bw.this.m15967a(messenger);
                    C1481bw.this.m15940i();
                }
            }
            if (!C1481bw.this.m15953c()) {
                C1481bw.this.m15942h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.b.bw$b */
    /* loaded from: classes.dex */
    public class HandlerC1483b extends Handler {

        /* renamed from: a */
        C1481bw f5223a;

        /* renamed from: c */
        private boolean f5225c = true;

        /* renamed from: d */
        private boolean f5226d = true;

        public HandlerC1483b(C1481bw c1481bw) {
            this.f5223a = null;
            this.f5223a = c1481bw;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        synchronized (C1481bw.this.f5207l) {
                            C1481bw.this.f5219x = true;
                            C1481bw.this.f5198c = message.replyTo;
                            this.f5223a.f5207l.notify();
                        }
                        break;
                    case 1:
                        synchronized (C1481bw.this.f5207l) {
                            C1481bw.this.f5219x = true;
                            Bundle data = message.getData();
                            C1481bw.this.f5202g = data.getBoolean("isfirst");
                            Messenger messenger = message.replyTo;
                            long m15997b = C1477bs.m15997b();
                            boolean z = data.getBoolean("isNeedAddress");
                            boolean z2 = data.getBoolean("isOffset");
                            if (z != this.f5225c || z2 != this.f5226d) {
                                this.f5223a.f5209n = 0L;
                            }
                            this.f5225c = z;
                            this.f5226d = z2;
                            if (C1481bw.this.f5208m == null || C1481bw.this.f5208m.m16549a() != 0 || m15997b - this.f5223a.f5209n >= 800) {
                                if (!C1481bw.this.f5203h.contains(messenger)) {
                                    C1481bw.this.f5203h.add(messenger);
                                }
                                C1481bw.this.f5206k = true;
                                this.f5223a.f5207l.notify();
                            } else {
                                Message obtain = Message.obtain();
                                Bundle bundle = new Bundle();
                                bundle.putParcelable("location", C1481bw.this.f5208m);
                                obtain.setData(bundle);
                                obtain.what = 1;
                                messenger.send(obtain);
                            }
                            boolean z3 = data.getBoolean("wifiactivescan");
                            C1481bw.this.f5197b = data.getBoolean("isKillProcess");
                            long j = data.getLong("httptimeout");
                            if (C1481bw.this.f5210o != null) {
                                C1481bw.this.f5210o.put("reversegeo", z);
                                C1481bw.this.f5210o.put("isOffset", z2);
                                C1481bw.this.f5210o.put("wifiactivescan", z3 ? "1" : "0");
                                C1481bw.this.f5210o.put("httptimeout", j);
                            }
                            this.f5223a.m15958a(C1481bw.this.f5210o);
                        }
                        break;
                    case 2:
                        C1481bw.this.m15969a();
                        break;
                    case 3:
                        C1481bw.this.m15956b();
                        break;
                    case 4:
                        synchronized (C1481bw.this.f5207l) {
                            if (C1473bp.m16045d() && C1481bw.this.f5220y < C1473bp.m16044e()) {
                                C1481bw.m15955b(C1481bw.this);
                                C1481bw.this.f5206k = true;
                                this.f5223a.f5207l.notify();
                                C1481bw.this.f5200e.sendEmptyMessageDelayed(4, 2000L);
                            }
                        }
                        break;
                    case 5:
                        synchronized (C1481bw.this.f5207l) {
                            if (C1473bp.m16043f() && C1473bp.m16042g() > 2) {
                                C1481bw.this.f5206k = true;
                                if (C1473bp.m16041h()) {
                                    this.f5223a.f5207l.notify();
                                } else if (!C1477bs.m15984d(C1481bw.this.f5196a)) {
                                    this.f5223a.f5207l.notify();
                                }
                                C1481bw.this.f5200e.sendEmptyMessageDelayed(5, C1473bp.m16042g() * 1000);
                            }
                        }
                        break;
                }
                super.handleMessage(message);
            } catch (Throwable th) {
                C1514cx.m15728a(th, "APSServiceCore", "handleMessage STARTCOLL");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.b.bw$c */
    /* loaded from: classes.dex */
    public class C1484c extends Thread {
        C1484c() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                if (!C1481bw.this.f5217v) {
                    C1481bw.this.m15944g();
                }
                if (!C1481bw.this.f5213r) {
                    C1481bw.this.f5213r = true;
                    C1481bw.this.f5212q = new ServerSocket(43689);
                }
                while (C1481bw.this.f5213r) {
                    C1481bw.this.f5214s = C1481bw.this.f5212q.accept();
                    C1481bw.this.m15959a(C1481bw.this.f5214s);
                }
            } catch (Throwable th) {
                C1514cx.m15728a(th, "APSServiceCore", "run");
            }
            super.run();
        }
    }

    public C1481bw(Context context) {
        this.f5196a = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public AmapLoc m15968a(int i, String str) {
        try {
            AmapLoc amapLoc = new AmapLoc();
            amapLoc.m16538b(i);
            amapLoc.m16537b(str);
            return amapLoc;
        } catch (Throwable th) {
            C1514cx.m15728a(th, "APSServiceCore", "newInstanceAMapLoc");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public AmapLoc m15957a(boolean z) {
        return this.f5193B.m16289a(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15967a(Messenger messenger) {
        try {
            if (C1473bp.m16031r() && messenger != null) {
                C1473bp.m16052a("0");
                Message obtain = Message.obtain();
                obtain.what = 100;
                messenger.send(obtain);
            }
            if (this.f5198c != null) {
                Message obtain2 = Message.obtain();
                obtain2.what = 6;
                this.f5198c.send(obtain2);
                this.f5198c = null;
            }
            if (C1473bp.m16055a()) {
                this.f5193B.m16310a();
            }
            if (C1473bp.m16045d() && !this.f5221z) {
                this.f5221z = true;
                this.f5200e.sendEmptyMessage(4);
            }
            if (!C1473bp.m16043f() || this.f5192A) {
                return;
            }
            this.f5192A = true;
            this.f5200e.sendEmptyMessage(5);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "APSServiceCore", "checkConfig");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15959a(Socket socket) {
        BufferedReader bufferedReader;
        String[] split;
        String[] split2;
        String[] split3;
        String str = null;
        if (socket == null) {
            return;
        }
        int i = 30000;
        try {
            String str2 = "jsonp1";
            System.currentTimeMillis();
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null && readLine.length() > 0 && (split = readLine.split(" ")) != null && split.length > 1 && (split2 = split[1].split("\\?")) != null && split2.length > 1 && (split3 = split2[1].split("&")) != null && split3.length > 0) {
                        int i2 = 30000;
                        String str3 = str2;
                        for (String str4 : split3) {
                            try {
                                String[] split4 = str4.split("=");
                                if (split4 != null && split4.length > 1) {
                                    if ("to".equals(split4[0])) {
                                        i2 = Integer.parseInt(split4[1]);
                                    }
                                    if ("callback".equals(split4[0])) {
                                        str3 = split4[1];
                                    }
                                    if ("_".equals(split4[0])) {
                                        Long.parseLong(split4[1]);
                                    }
                                }
                            } catch (Throwable th) {
                                str2 = str3;
                                th = th;
                                String str5 = str2 + "&&" + str2 + "({'package':'" + this.f5199d + "','error_code':1,'error':'params error'})";
                                C1514cx.m15728a(th, "APSServiceCore", "invoke part2");
                                PrintStream printStream = new PrintStream(socket.getOutputStream(), true, "UTF-8");
                                printStream.println("HTTP/1.0 200 OK");
                                printStream.println("Content-Length:" + str5.getBytes("UTF-8").length);
                                printStream.println();
                                printStream.println(str5);
                                printStream.close();
                                bufferedReader.close();
                                socket.close();
                            }
                        }
                        String str6 = str3;
                        i = i2;
                        str2 = str6;
                    }
                    int i3 = C1514cx.f5415j;
                    C1514cx.f5415j = i;
                    long currentTimeMillis = System.currentTimeMillis();
                    if ((this.f5211p == null || currentTimeMillis - this.f5211p.m16516k() > 5000) && !C1477bs.m15984d(this.f5196a)) {
                        try {
                            this.f5211p = this.f5193B.m16289a(false);
                            if (this.f5211p.m16549a() != 0) {
                                str = str2 + "&&" + str2 + "({'package':'" + this.f5199d + "','error_code':" + this.f5211p.m16549a() + ",'error':'" + this.f5211p.m16535c() + "'})";
                            }
                            C1514cx.f5415j = i3;
                        } catch (Exception e) {
                            C1514cx.m15728a(e, "APSServiceCore", "invoke part1");
                            C1514cx.f5415j = i3;
                        }
                    }
                    if (str == null) {
                        if (this.f5211p == null) {
                            str = str2 + "&&" + str2 + "({'package':'" + this.f5199d + "','error_code':8,'error':'unknown error'})";
                        } else {
                            AmapLoc amapLoc = this.f5211p;
                            str = str2 + "&&" + str2 + "({'package':'" + this.f5199d + "','error_code':0,'error':'','location':{'y':" + amapLoc.m16520i() + ",'precision':" + amapLoc.m16518j() + ",'x':" + amapLoc.m16522h() + "},'version_code':'2.4.1','version':'2.4.1'})";
                        }
                        if (C1477bs.m15984d(this.f5196a)) {
                            str = str2 + "&&" + str2 + "({'package':'" + this.f5199d + "','error_code':36,'error':'app is background'})";
                        }
                    }
                    PrintStream printStream2 = new PrintStream(socket.getOutputStream(), true, "UTF-8");
                    printStream2.println("HTTP/1.0 200 OK");
                    printStream2.println("Content-Length:" + str.getBytes("UTF-8").length);
                    printStream2.println();
                    printStream2.println(str);
                    printStream2.close();
                    bufferedReader.close();
                    socket.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            C1514cx.m15728a(th4, "APSServiceCore", "invoke part5");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15958a(JSONObject jSONObject) {
        try {
            if (this.f5193B == null) {
                return;
            }
            this.f5193B.m16290a(jSONObject);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "APSServiceCore", "setExtra");
        }
    }

    /* renamed from: b */
    static /* synthetic */ int m15955b(C1481bw c1481bw) {
        int i = c1481bw.f5220y;
        c1481bw.f5220y = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public boolean m15953c() {
        boolean z;
        synchronized (this.f5207l) {
            z = this.f5205j;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m15950d() {
        try {
            this.f5193B.m16270g();
        } catch (Throwable th) {
            C1514cx.m15728a(th, "APSServiceCore", "bindService");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m15948e() {
        try {
            if (this.f5218w) {
                return;
            }
            this.f5218w = true;
            this.f5193B.m16285b(this.f5196a);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "APSServiceCore", "initAuth");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m15946f() {
        try {
            if (this.f5217v) {
                return;
            }
            m15944g();
        } catch (Throwable th) {
            this.f5194C = false;
            this.f5195D = th.getMessage();
            C1514cx.m15728a(th, "APSServiceCore", "init");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m15944g() {
        try {
            C1514cx.m15731a(this.f5196a);
            this.f5193B.m16295a("api_serverSDK_130905##S128DF1572465B890OE3F7A13167KLEI##" + C1533dm.m15666c(this.f5196a) + "##" + C1533dm.m15662f(this.f5196a));
            String m15651a = C1535do.m15651a(this.f5196a, C1514cx.m15729a("2.4.1"), null, true);
            try {
                this.f5210o.put("key", C1533dm.m15662f(this.f5196a));
                this.f5210o.put("X-INFO", m15651a);
                this.f5210o.put(C5083e.f21661Y, "AMAP_Location_SDK_Android 2.4.1");
                this.f5210o.put("netloc", "0");
                this.f5210o.put("gpsstatus", "0");
                this.f5210o.put("nbssid", "0");
                if (!this.f5210o.has("reversegeo")) {
                    this.f5210o.put("reversegeo", true);
                }
                if (!this.f5210o.has("isOffset")) {
                    this.f5210o.put("isOffset", true);
                }
                this.f5210o.put("wait1stwifi", "0");
                this.f5210o.put("autoup", "0");
                this.f5210o.put("upcolmobile", 1);
                this.f5210o.put("enablegetreq", 1);
                if (!this.f5210o.has("wifiactivescan")) {
                    this.f5210o.put("wifiactivescan", 1);
                }
            } catch (JSONException e) {
                this.f5195D = e.getMessage();
                this.f5194C = false;
                C1514cx.m15728a(e, "APSServiceCore", "doInit part2");
            }
            this.f5217v = true;
            this.f5193B.m16290a(this.f5210o);
            this.f5193B.m16306a(this.f5196a);
        } catch (Throwable th) {
            this.f5195D = th.getMessage();
            this.f5194C = false;
            C1514cx.m15728a(th, "APSServiceCore", "doInit part3");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m15942h() {
        try {
            m15956b();
            this.f5217v = false;
            this.f5218w = false;
            this.f5219x = false;
            this.f5221z = false;
            this.f5192A = false;
            this.f5220y = 0;
            this.f5193B.m16287b();
            this.f5203h.clear();
            C1488c.m15880a();
            if (this.f5197b) {
                Process.killProcess(Process.myPid());
            }
            if (this.f5200e == null) {
                return;
            }
            this.f5200e.removeCallbacksAndMessages(null);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "APSServiceCore", "threadDestroy");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m15940i() {
        try {
            if (this.f5193B == null) {
                return;
            }
            this.f5193B.m16268h();
        } catch (Throwable th) {
            C1514cx.m15728a(th, "APSServiceCore", "startColl");
        }
    }

    /* renamed from: a */
    public synchronized void m15969a() {
        try {
            if (!this.f5215t) {
                this.f5216u = new C1484c();
                this.f5216u.setPriority(5);
                this.f5216u.start();
                this.f5215t = true;
            }
        } finally {
        }
    }

    /* renamed from: b */
    public synchronized void m15956b() {
        if (this.f5212q != null) {
            this.f5212q.close();
        }
        if (this.f5214s != null) {
            this.f5214s.close();
        }
        this.f5212q = null;
        this.f5216u = null;
        this.f5215t = false;
        this.f5213r = false;
    }

    @Override // com.amap.api.location.APSServiceBase
    public Handler getHandler() {
        return this.f5200e;
    }

    @Override // com.amap.api.location.APSServiceBase
    public void onCreate() {
        try {
            this.f5193B = new C1430as();
            this.f5199d = this.f5196a.getApplicationContext().getPackageName();
            this.f5205j = true;
            this.f5201f = new C1482a();
            this.f5201f.setPriority(5);
            this.f5201f.setName("serviceThread");
            this.f5201f.start();
        } catch (Throwable th) {
            C1514cx.m15728a(th, "APSServiceCore", "onCreate");
        }
    }

    @Override // com.amap.api.location.APSServiceBase
    public void onDestroy() {
        try {
            synchronized (this.f5207l) {
                this.f5205j = false;
                this.f5207l.notify();
            }
        } catch (Throwable th) {
            C1514cx.m15728a(th, "APSServiceCore", "onDestroy");
        }
    }

    @Override // com.amap.api.location.APSServiceBase
    public int onStartCommand(Intent intent, int i, int i2) {
        return 0;
    }
}
