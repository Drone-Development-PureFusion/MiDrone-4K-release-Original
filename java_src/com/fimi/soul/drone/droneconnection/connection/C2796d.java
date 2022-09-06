package com.fimi.soul.drone.droneconnection.connection;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.fimi.kernel.p163c.C2241c;
import com.fimi.kernel.utils.C2273r;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.biz.p175d.C2429a;
import com.fimi.soul.biz.p175d.C2434c;
import com.fimi.soul.biz.p178g.C2444a;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.entity.HistoryFileInfo;
import com.fimi.soul.utils.C3681j;
import com.github.moduth.blockcanary.p215b.C3947a;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import p004b.p005a.p006a.p028b.p051m.C0501h;
/* renamed from: com.fimi.soul.drone.droneconnection.connection.d */
/* loaded from: classes.dex */
public class C2796d {

    /* renamed from: c */
    private static final String f10352c = C2434c.m12195a().m12194b();

    /* renamed from: a */
    HandlerThread f10353a;

    /* renamed from: b */
    StringBuffer f10354b;

    /* renamed from: d */
    private Handler f10355d;

    /* renamed from: e */
    private SimpleDateFormat f10356e;

    /* renamed from: f */
    private SimpleDateFormat f10357f;

    /* renamed from: g */
    private SimpleDateFormat f10358g;

    /* renamed from: h */
    private BufferedWriter f10359h;

    /* renamed from: i */
    private File f10360i;

    /* renamed from: j */
    private File f10361j;

    /* renamed from: k */
    private StringBuilder f10362k;

    /* renamed from: l */
    private boolean f10363l;

    /* renamed from: m */
    private boolean f10364m;

    /* renamed from: n */
    private Runnable f10365n;

    /* renamed from: o */
    private boolean f10366o;

    /* renamed from: p */
    private C2241c f10367p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fimi.soul.drone.droneconnection.connection.d$a */
    /* loaded from: classes.dex */
    public static class C2798a {

        /* renamed from: a */
        private static final C2796d f10369a = new C2796d();

        C2798a() {
        }
    }

    private C2796d() {
        this.f10354b = new StringBuffer();
        this.f10362k = new StringBuilder();
        this.f10363l = false;
        this.f10365n = new Runnable() { // from class: com.fimi.soul.drone.droneconnection.connection.d.1
            @Override // java.lang.Runnable
            public void run() {
                C2796d.this.f10363l = false;
                C2796d.this.f10355d.postDelayed(this, 400L);
            }
        };
        this.f10367p = C2241c.m13122a();
        if (this.f10353a == null && this.f10355d == null) {
            this.f10353a = new HandlerThread("LogHandler");
            this.f10353a.start();
            this.f10355d = new Handler(this.f10353a.getLooper());
        }
    }

    /* renamed from: a */
    public static C2796d m10980a() {
        return C2798a.f10369a;
    }

    /* renamed from: a */
    private void m10978a(C2770c c2770c, String str) {
        byte[] m11066f = c2770c.m11066f();
        this.f10354b.append(str).append("    ");
        for (int i = 0; i < m11066f.length; i++) {
            this.f10354b.append(Character.forDigit((m11066f[i] & 240) >> 4, 16));
            this.f10354b.append(Character.forDigit(m11066f[i] & 15, 16));
            this.f10354b.append(" ");
        }
        this.f10362k.append(C2273r.m12836b(this.f10354b.toString(), f10352c));
        this.f10362k.append("\n");
        this.f10354b = this.f10354b.delete(0, this.f10354b.length());
        if (this.f10364m && this.f10360i != null) {
            m10973a(this.f10362k, this.f10360i);
            m10970b(true);
        } else if (!this.f10364m && this.f10361j != null) {
            m10973a(this.f10362k, this.f10361j);
            m10970b(false);
        }
    }

    /* renamed from: a */
    private void m10973a(StringBuilder sb, File file) {
        try {
            this.f10359h.write(sb.toString());
            this.f10359h.flush();
            sb.delete(0, sb.length());
            this.f10363l = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m10970b(boolean z) {
        if (TextUtils.isEmpty(C2444a.m12164a().m12161b()) || this.f10366o) {
            return;
        }
        this.f10366o = true;
        File file = z ? this.f10360i : this.f10361j;
        if (file == null) {
            return;
        }
        m10975a(file);
    }

    /* renamed from: a */
    public void m10979a(C2770c c2770c) {
        if (c2770c.f10263c != 105 || this.f10363l) {
            m10978a(c2770c, m10962j());
        } else {
            this.f10363l = true;
        }
    }

    /* renamed from: a */
    public void m10975a(File file) {
        HistoryFileInfo historyFileInfo = new HistoryFileInfo();
        historyFileInfo.setDeviceType(C2367d.m12459a().m12438k() ? "1" : "0");
        historyFileInfo.setFcId(C2444a.m12164a().m12161b());
        this.f10367p.mo13117a(file.getName(), historyFileInfo);
    }

    /* renamed from: a */
    public void m10974a(String str) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(C3681j.m7467l() + "log.txt");
                if (file == null || !file.exists()) {
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file, true);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            fileOutputStream.write((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " : " + str).getBytes());
            fileOutputStream.write(C3947a.f16890a.getBytes());
            try {
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            try {
                fileOutputStream2.flush();
                fileOutputStream2.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            try {
                fileOutputStream2.flush();
                fileOutputStream2.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public void m10972a(boolean z) {
        if (this.f10364m != z) {
            this.f10364m = z;
        }
    }

    /* renamed from: b */
    public void m10971b() {
        String format = m10964h().format(Long.valueOf(System.currentTimeMillis()));
        File file = new File(C3681j.m7482a() + "/LOGDOWN/" + m10963i() + "/AirFly");
        file.mkdirs();
        if (this.f10360i == null || !this.f10360i.exists()) {
            this.f10360i = new File(file, format + ".pb");
        }
        if (this.f10359h == null) {
            try {
                this.f10359h = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f10360i, true)));
                for (Map.Entry<Integer, C2770c> entry : C2429a.m12215a().m12213b().entrySet()) {
                    m10978a(entry.getValue(), m10962j());
                }
                this.f10355d.postDelayed(this.f10365n, 200L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.f10366o = false;
    }

    /* renamed from: c */
    public void m10969c() {
        String format = m10964h().format(new Date());
        File file = new File(C3681j.m7482a() + "/LOGDOWN/" + m10963i() + "/NoFly");
        file.mkdirs();
        if (this.f10361j == null || !this.f10361j.exists()) {
            this.f10361j = new File(file, format + ".pb");
        }
        if (this.f10359h == null) {
            try {
                this.f10359h = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f10361j, true)));
                for (Map.Entry<Integer, C2770c> entry : C2429a.m12215a().m12213b().entrySet()) {
                    m10978a(entry.getValue(), m10962j());
                }
                this.f10355d.postDelayed(this.f10365n, 200L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.f10366o = false;
    }

    /* renamed from: d */
    public void m10968d() {
        if (this.f10359h != null) {
            try {
                this.f10359h.close();
                this.f10359h = null;
                this.f10360i = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: e */
    public boolean m10967e() {
        return (this.f10359h == null || this.f10360i == null) ? false : true;
    }

    /* renamed from: f */
    public boolean m10966f() {
        return (this.f10359h == null || this.f10361j == null) ? false : true;
    }

    /* renamed from: g */
    public void m10965g() {
        if (this.f10359h != null) {
            try {
                this.f10359h.close();
                this.f10359h = null;
                this.f10361j = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: h */
    public SimpleDateFormat m10964h() {
        if (this.f10356e == null) {
            this.f10356e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        }
        return this.f10356e;
    }

    /* renamed from: i */
    public String m10963i() {
        if (this.f10357f == null) {
            this.f10357f = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        }
        return this.f10357f.format(Long.valueOf(System.currentTimeMillis()));
    }

    /* renamed from: j */
    public String m10962j() {
        if (this.f10358g == null) {
            this.f10358g = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss-SSS", Locale.US);
        }
        return this.f10358g.format(Long.valueOf(System.currentTimeMillis()));
    }

    /* renamed from: k */
    public boolean m10961k() {
        return this.f10361j != null && this.f10361j.length() > C0501h.f1123b;
    }
}
