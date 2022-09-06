package com.fimi.soul.biz.p175d;

import com.fimi.kernel.p163c.C2241c;
import com.fimi.kernel.utils.C2273r;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.biz.p178g.C2444a;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.entity.HistoryFileInfo;
import com.fimi.soul.utils.C3681j;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* renamed from: com.fimi.soul.biz.d.d */
/* loaded from: classes.dex */
public class C2437d {

    /* renamed from: j */
    private static final String f8403j = C2434c.m12195a().m12194b();

    /* renamed from: a */
    private BufferedWriter f8404a;

    /* renamed from: b */
    private BufferedWriter f8405b;

    /* renamed from: c */
    private SimpleDateFormat f8406c;

    /* renamed from: d */
    private SimpleDateFormat f8407d;

    /* renamed from: e */
    private SimpleDateFormat f8408e;

    /* renamed from: f */
    private File f8409f;

    /* renamed from: g */
    private File f8410g;

    /* renamed from: h */
    private StringBuffer f8411h;

    /* renamed from: i */
    private StringBuilder f8412i;

    /* renamed from: k */
    private C2241c f8413k;

    /* renamed from: com.fimi.soul.biz.d.d$a */
    /* loaded from: classes.dex */
    public static class C2439a {

        /* renamed from: a */
        private static final C2437d f8414a = new C2437d();
    }

    private C2437d() {
        this.f8411h = new StringBuffer();
        this.f8412i = new StringBuilder();
        this.f8413k = C2241c.m13122a();
    }

    /* renamed from: a */
    public static C2437d m12192a() {
        return C2439a.f8414a;
    }

    /* renamed from: a */
    private void m12189a(StringBuilder sb, BufferedWriter bufferedWriter) {
        if (bufferedWriter == null) {
            return;
        }
        try {
            bufferedWriter.write(sb.toString());
            bufferedWriter.flush();
            sb.delete(0, sb.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    private StringBuilder m12185c(C2770c c2770c) {
        try {
            this.f8411h.append(m12179i()).append("    ");
            byte[] m11066f = c2770c.m11066f();
            for (int i = 0; i < m11066f.length; i++) {
                this.f8411h.append(Character.forDigit((m11066f[i] & 240) >> 4, 16));
                this.f8411h.append(Character.forDigit(m11066f[i] & 15, 16));
            }
            this.f8412i.append(C2273r.m12836b(this.f8411h.toString(), f8403j));
            this.f8412i.append("\n");
            this.f8411h = this.f8411h.delete(0, this.f8411h.length());
        } catch (Exception e) {
        }
        return this.f8412i;
    }

    /* renamed from: a */
    public void m12191a(C2770c c2770c) {
        m12189a(m12185c(c2770c), this.f8404a);
    }

    /* renamed from: a */
    public void m12190a(File file) {
        HistoryFileInfo historyFileInfo = new HistoryFileInfo();
        historyFileInfo.setDeviceType(C2367d.m12459a().m12438k() ? "1" : "0");
        historyFileInfo.setFcId(C2444a.m12164a().m12161b());
        this.f8413k.mo13117a(file.getName(), historyFileInfo);
    }

    /* renamed from: b */
    public void m12188b() {
        String format = m12181g().format(new Date());
        File file = new File(C3681j.m7482a() + "/LOGDOWN/" + m12180h() + "/DroneData");
        file.mkdirs();
        if (this.f8409f == null || !this.f8409f.exists()) {
            this.f8409f = new File(file, format + ".fc");
        }
        if (this.f8404a == null) {
            try {
                this.f8404a = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f8409f, true)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public void m12187b(C2770c c2770c) {
        m12189a(m12185c(c2770c), this.f8405b);
    }

    /* renamed from: c */
    public void m12186c() {
        String format = m12181g().format(Long.valueOf(System.currentTimeMillis()));
        File file = new File(C3681j.m7482a() + "/LOGDOWN/" + m12180h() + "/DroneData");
        file.mkdirs();
        if (this.f8410g == null || !this.f8410g.exists()) {
            this.f8410g = new File(file, format + ".fc");
        }
        if (this.f8405b == null) {
            try {
                this.f8405b = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f8410g, true)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: d */
    public boolean m12184d() {
        return (this.f8410g == null || this.f8405b == null) ? false : true;
    }

    /* renamed from: e */
    public void m12183e() {
        try {
            if (this.f8405b == null) {
                return;
            }
            this.f8405b.close();
            this.f8405b = null;
        } catch (Exception e) {
        }
    }

    /* renamed from: f */
    public void m12182f() {
        if (this.f8410g != null) {
            this.f8410g.delete();
            this.f8410g = null;
        }
    }

    /* renamed from: g */
    public SimpleDateFormat m12181g() {
        if (this.f8406c == null) {
            this.f8406c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        }
        return this.f8406c;
    }

    /* renamed from: h */
    public String m12180h() {
        if (this.f8407d == null) {
            this.f8407d = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        }
        return this.f8407d.format(Long.valueOf(System.currentTimeMillis()));
    }

    /* renamed from: i */
    public String m12179i() {
        if (this.f8408e == null) {
            this.f8408e = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss-SSS", Locale.US);
        }
        return this.f8408e.format(Long.valueOf(System.currentTimeMillis()));
    }

    /* renamed from: j */
    public boolean m12178j() {
        return (this.f8404a == null || this.f8409f == null) ? false : true;
    }

    /* renamed from: k */
    public void m12177k() {
        if (this.f8404a != null) {
            try {
                this.f8404a.close();
                this.f8404a = null;
                this.f8409f = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: l */
    public File m12176l() {
        return this.f8409f;
    }

    /* renamed from: m */
    public File m12175m() {
        return this.f8410g;
    }
}
