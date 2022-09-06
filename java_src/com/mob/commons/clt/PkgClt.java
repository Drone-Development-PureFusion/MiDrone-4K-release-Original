package com.mob.commons.clt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.mob.commons.C4125a;
import com.mob.commons.C4131b;
import com.mob.commons.C4145d;
import com.mob.commons.LockAction;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import com.tencent.p227mm.sdk.platformtools.Util;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes.dex */
public class PkgClt {

    /* renamed from: a */
    private static final String[] f17292a = {"android.intent.action.PACKAGE_ADDED", "android.intent.action.PACKAGE_CHANGED", "android.intent.action.PACKAGE_REMOVED", "android.intent.action.PACKAGE_REPLACED"};

    /* renamed from: b */
    private static PkgClt f17293b;

    /* renamed from: c */
    private BroadcastReceiver f17294c;

    /* renamed from: d */
    private Context f17295d;

    /* renamed from: e */
    private Hashon f17296e = new Hashon();

    /* renamed from: f */
    private Handler f17297f;

    private PkgClt(Context context) {
        this.f17295d = context.getApplicationContext();
    }

    /* renamed from: a */
    private ArrayList<HashMap<String, String>> m6066a(ArrayList<HashMap<String, String>> arrayList, ArrayList<HashMap<String, String>> arrayList2) {
        boolean z;
        ArrayList<HashMap<String, String>> arrayList3 = new ArrayList<>();
        Iterator<HashMap<String, String>> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            HashMap<String, String> next = it2.next();
            String str = next.get("pkg");
            if (!TextUtils.isEmpty(str)) {
                Iterator<HashMap<String, String>> it3 = arrayList2.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        z = false;
                        break;
                    } else if (str.equals(it3.next().get("pkg"))) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    arrayList3.add(next);
                }
            }
        }
        return arrayList3;
    }

    /* renamed from: a */
    private void m6073a() {
        MobHandlerThread mobHandlerThread = new MobHandlerThread() { // from class: com.mob.commons.clt.PkgClt.1
            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: a */
            public void m6056a() {
                super.run();
            }

            @Override // com.mob.tools.MobHandlerThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                C4145d.m6037a(new File(ResHelper.getCacheRoot(PkgClt.this.f17295d), "comm/locks/.pkg_lock"), new LockAction() { // from class: com.mob.commons.clt.PkgClt.1.1
                    @Override // com.mob.commons.LockAction
                    public boolean run(FileLocker fileLocker) {
                        if (C4125a.m6135e(PkgClt.this.f17295d)) {
                            PkgClt.this.m6065b();
                        }
                        m6056a();
                        return false;
                    }
                });
            }
        };
        mobHandlerThread.start();
        this.f17297f = new Handler(mobHandlerThread.getLooper(), new Handler.Callback() { // from class: com.mob.commons.clt.PkgClt.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        PkgClt.this.m6057f();
                        return false;
                    case 2:
                        PkgClt.this.m6059e();
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.f17297f.sendEmptyMessage(2);
    }

    /* renamed from: a */
    private void m6072a(long j) {
        File file = new File(ResHelper.getCacheRoot(this.f17295d), "comm/dbs/.nulal");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            dataOutputStream.writeLong(j);
            dataOutputStream.flush();
            dataOutputStream.close();
        } catch (Throwable th) {
            MobLog.getInstance().m5971d(th);
        }
    }

    /* renamed from: a */
    private void m6071a(long j, String str, ArrayList<HashMap<String, String>> arrayList) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("type", str);
        hashMap.put("list", arrayList);
        hashMap.put("datetime", Long.valueOf(C4125a.m6143a(this.f17295d)));
        C4131b.m6103a(this.f17295d).m6104a(j, hashMap);
    }

    /* renamed from: a */
    private void m6067a(ArrayList<HashMap<String, String>> arrayList) {
        File file = new File(ResHelper.getCacheRoot(this.f17295d), "comm/dbs/.al");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(file)), "utf-8");
            Iterator<HashMap<String, String>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                outputStreamWriter.append((CharSequence) this.f17296e.fromHashMap(it2.next())).append('\n');
            }
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (Throwable th) {
            MobLog.getInstance().m5971d(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m6068a(String str) {
        for (String str2 : f17292a) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6065b() {
        ArrayList<HashMap<String, String>> arrayList;
        ArrayList<HashMap<String, String>> arrayList2;
        ArrayList<HashMap<String, String>> m6063c = m6063c();
        if (m6063c == null || m6063c.isEmpty()) {
            try {
                arrayList = (ArrayList) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f17295d), "getInstalledApp", false);
            } catch (Throwable th) {
                MobLog.getInstance().m5959w(th);
                arrayList = new ArrayList<>();
            }
            m6071a(C4125a.m6125o(this.f17295d), "APPS_ALL", arrayList);
            m6067a(arrayList);
            m6072a(C4125a.m6143a(this.f17295d) + (C4125a.m6133g(this.f17295d) * 1000));
            return;
        }
        long m6143a = C4125a.m6143a(this.f17295d);
        if (m6143a < m6061d()) {
            m6057f();
            return;
        }
        try {
            arrayList2 = (ArrayList) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f17295d), "getInstalledApp", false);
        } catch (Throwable th2) {
            MobLog.getInstance().m5959w(th2);
            arrayList2 = new ArrayList<>();
        }
        m6071a(C4125a.m6125o(this.f17295d), "APPS_ALL", arrayList2);
        m6067a(arrayList2);
        m6072a((C4125a.m6133g(this.f17295d) * 1000) + m6143a);
    }

    /* renamed from: c */
    private ArrayList<HashMap<String, String>> m6063c() {
        File file = new File(ResHelper.getCacheRoot(this.f17295d), "comm/dbs/.al");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (file.exists()) {
            try {
                ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(file)), "utf-8"));
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    HashMap<String, String> fromJson = this.f17296e.fromJson(readLine);
                    if (fromJson != null) {
                        arrayList.add(fromJson);
                    }
                }
                bufferedReader.close();
                return arrayList;
            } catch (Throwable th) {
                MobLog.getInstance().m5971d(th);
            }
        }
        return new ArrayList<>();
    }

    /* renamed from: d */
    private long m6061d() {
        File file = new File(ResHelper.getCacheRoot(this.f17295d), "comm/dbs/.nulal");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (file.exists()) {
            try {
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
                long readLong = dataInputStream.readLong();
                dataInputStream.close();
                return readLong;
            } catch (Throwable th) {
                MobLog.getInstance().m5971d(th);
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m6059e() {
        if (C4125a.m6136d(this.f17295d) && C4125a.m6134f(this.f17295d)) {
            if (this.f17294c == null) {
                this.f17294c = new BroadcastReceiver() { // from class: com.mob.commons.clt.PkgClt.3
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        String str = null;
                        if (intent != null) {
                            str = intent.getAction();
                        }
                        if (!PkgClt.this.m6068a(str) || PkgClt.this.f17297f == null) {
                            return;
                        }
                        PkgClt.this.f17297f.removeMessages(1);
                        PkgClt.this.f17297f.sendEmptyMessageDelayed(1, 5000L);
                    }
                };
            }
            IntentFilter intentFilter = new IntentFilter();
            for (int i = 0; i < f17292a.length; i++) {
                intentFilter.addAction(f17292a[i]);
            }
            intentFilter.addDataScheme("package");
            try {
                this.f17295d.registerReceiver(this.f17294c, intentFilter);
            } catch (Throwable th) {
            }
        } else if (this.f17294c != null) {
            this.f17297f.removeMessages(1);
            try {
                this.f17295d.unregisterReceiver(this.f17294c);
            } catch (Throwable th2) {
            }
            this.f17294c = null;
        }
        this.f17297f.sendEmptyMessageDelayed(2, Util.MILLSECONDS_OF_HOUR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m6057f() {
        ArrayList<HashMap<String, String>> arrayList;
        ArrayList<HashMap<String, String>> m6063c = m6063c();
        try {
            arrayList = (ArrayList) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f17295d), "getInstalledApp", false);
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            arrayList = new ArrayList<>();
        }
        if (m6063c == null || m6063c.isEmpty()) {
            m6071a(C4125a.m6125o(this.f17295d), "APPS_ALL", arrayList);
            m6067a(arrayList);
            m6072a(C4125a.m6143a(this.f17295d) + (C4125a.m6133g(this.f17295d) * 1000));
            return;
        }
        ArrayList<HashMap<String, String>> m6066a = m6066a(arrayList, m6063c);
        if (!m6066a.isEmpty()) {
            m6071a(C4125a.m6143a(this.f17295d), "APPS_INCR", m6066a);
        }
        ArrayList<HashMap<String, String>> m6066a2 = m6066a(m6063c, arrayList);
        if (!m6066a2.isEmpty()) {
            m6071a(C4125a.m6143a(this.f17295d), "UNINSTALL", m6066a2);
        }
        m6067a(arrayList);
        m6072a(C4125a.m6143a(this.f17295d) + (C4125a.m6133g(this.f17295d) * 1000));
    }

    public static synchronized boolean register(Context context, String str) {
        synchronized (PkgClt.class) {
            startCollector(context);
        }
        return true;
    }

    public static synchronized void startCollector(Context context) {
        synchronized (PkgClt.class) {
            if (f17293b == null) {
                f17293b = new PkgClt(context);
                f17293b.m6073a();
            }
        }
    }
}
