package com.fimi.soul.drone.droneconnection.connection;

import android.os.Looper;
import android.os.SystemClock;
import com.fimi.soul.biz.p175d.C2430b;
import com.fimi.soul.drone.p193d.C2774b;
import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.utils.C3681j;
import com.fimi.soul.utils.C3695s;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.codehaus.jackson.smile.SmileConstants;
import org.p318d.AbstractC5744c;
import org.p318d.C5748d;
/* renamed from: com.fimi.soul.drone.droneconnection.connection.e */
/* loaded from: classes.dex */
public abstract class AbstractC2799e {

    /* renamed from: a */
    private static final String f10370a = AbstractC2799e.class.getSimpleName();

    /* renamed from: b */
    public static final int f10371b = 0;

    /* renamed from: c */
    public static final int f10372c = 1;

    /* renamed from: d */
    public static final int f10373d = 2;

    /* renamed from: j */
    private static final int f10374j = 4096;

    /* renamed from: f */
    BufferedWriter f10376f;

    /* renamed from: i */
    private File f10379i;

    /* renamed from: p */
    private Thread f10385p;

    /* renamed from: q */
    private long f10386q;

    /* renamed from: r */
    private long f10387r;

    /* renamed from: k */
    private List<Integer> f10380k = new ArrayList();

    /* renamed from: e */
    protected volatile boolean f10375e = false;

    /* renamed from: l */
    private final ConcurrentHashMap<String, AbstractC2803f> f10381l = new ConcurrentHashMap<>();

    /* renamed from: m */
    private C2430b f10382m = C2430b.m12212a();

    /* renamed from: n */
    private final AtomicInteger f10383n = new AtomicInteger(0);

    /* renamed from: o */
    private final Runnable f10384o = new Runnable() { // from class: com.fimi.soul.drone.droneconnection.connection.e.1
        /* renamed from: a */
        private void m10924a(C2774b c2774b, int i, byte[] bArr) {
            if (i < 1) {
                return;
            }
            if (AbstractC2799e.this.f10389t) {
                System.arraycopy(bArr, 0, new byte[i], 0, i);
            }
            for (int i2 = 0; i2 < i; i2++) {
                C2770c m11034a = c2774b.m11034a(bArr[i2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
                if (m11034a != null) {
                    C2796d m10980a = C2796d.m10980a();
                    m10980a.m10972a(AbstractC2799e.this.f10375e);
                    AbstractC2799e.this.f10382m.m12204b(AbstractC2799e.this.f10375e);
                    AbstractC2799e.this.m10944b(m11034a.f10263c);
                    if (m11034a.f10263c == 211) {
                        AbstractC2799e.this.f10382m.m12208a(m11034a);
                    } else {
                        if (AbstractC2799e.this.f10375e) {
                            if (m10980a.m10966f()) {
                                m10980a.m10965g();
                            }
                            if (!m10980a.m10967e()) {
                                m10980a.m10971b();
                            } else {
                                m10980a.m10979a(m11034a);
                            }
                        } else {
                            if (!m10980a.m10966f()) {
                                m10980a.m10969c();
                            } else if (m10980a.m10961k()) {
                                m10980a.m10965g();
                                return;
                            } else {
                                m10980a.m10979a(m11034a);
                            }
                            if (m10980a.m10967e()) {
                                m10980a.m10968d();
                            }
                        }
                        AbstractC2799e.this.m10957a(m11034a.m11065g());
                    }
                }
            }
        }

        /* renamed from: a */
        public String m10923a(byte[] bArr) {
            StringBuilder sb = new StringBuilder("");
            if (bArr == null || bArr.length <= 0) {
                return "";
            }
            for (byte b : bArr) {
                String hexString = Integer.toHexString(b & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
                if (hexString.length() < 2) {
                    sb.append(0);
                }
                sb.append(hexString);
                sb.append(" ");
            }
            return sb.toString().toUpperCase();
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.prepare();
            Thread thread = null;
            try {
                try {
                    AbstractC2799e.this.mo10937d();
                    AbstractC2799e.this.f10383n.set(2);
                    AbstractC2799e.this.m10959a();
                    C2774b c2774b = new C2774b();
                    c2774b.f10277c.m11037b();
                    byte[] bArr = new byte[4096];
                    AbstractC2799e.this.f10386q = SystemClock.uptimeMillis();
                    AbstractC2799e.this.f10387r = SystemClock.uptimeMillis();
                    while (AbstractC2799e.this.f10383n.get() == 2) {
                        int mo10940b = AbstractC2799e.this.mo10940b(bArr);
                        if (mo10940b > 0) {
                            try {
                                m10924a(c2774b, mo10940b, bArr);
                            } catch (Exception e) {
                                AbstractC2799e.this.m10946a(bArr, e.toString());
                            }
                        }
                    }
                    if (0 != 0 && thread.isAlive()) {
                        thread.interrupt();
                    }
                    AbstractC2799e.this.m10928h();
                } catch (Throwable th) {
                    if (0 != 0 && thread.isAlive()) {
                        thread.interrupt();
                    }
                    AbstractC2799e.this.m10928h();
                    throw th;
                }
            } catch (IOException e2) {
                C2779b.m11016b(false);
                if (AbstractC2799e.this.f10383n.get() != 0) {
                    AbstractC2799e.this.m10941b(e2.getMessage());
                }
                if (0 != 0 && thread.isAlive()) {
                    thread.interrupt();
                }
                AbstractC2799e.this.m10928h();
            }
            Looper.loop();
        }
    };

    /* renamed from: g */
    boolean f10377g = true;

    /* renamed from: s */
    private EnumC2802a f10388s = EnumC2802a.IDLE;

    /* renamed from: t */
    private boolean f10389t = false;

    /* renamed from: u */
    private boolean f10390u = true;

    /* renamed from: h */
    AbstractC5744c f10378h = C5748d.m48a("log_linkconntect");

    /* renamed from: v */
    private final Runnable f10391v = new Runnable() { // from class: com.fimi.soul.drone.droneconnection.connection.e.2
        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!AbstractC2799e.this.f10381l.isEmpty()) {
                    if (SystemClock.uptimeMillis() - AbstractC2799e.this.f10386q > 3000) {
                        for (AbstractC2803f abstractC2803f : AbstractC2799e.this.f10381l.values()) {
                            abstractC2803f.mo10871b(false);
                            abstractC2803f.mo10873a(false);
                        }
                    } else if (SystemClock.uptimeMillis() - AbstractC2799e.this.f10387r > 3000) {
                        AbstractC2799e.this.f10388s = EnumC2802a.DISCONNECT;
                        for (AbstractC2803f abstractC2803f2 : AbstractC2799e.this.f10381l.values()) {
                            abstractC2803f2.mo10871b(true);
                            abstractC2803f2.mo10873a(false);
                        }
                    } else {
                        for (AbstractC2803f abstractC2803f3 : AbstractC2799e.this.f10381l.values()) {
                            abstractC2803f3.mo10871b(true);
                            abstractC2803f3.mo10873a(true);
                        }
                    }
                }
            }
        }
    };

    /* renamed from: com.fimi.soul.drone.droneconnection.connection.e$a */
    /* loaded from: classes.dex */
    public enum EnumC2802a {
        IDLE,
        CONNECTED,
        DISCONNECT
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10959a() {
        for (AbstractC2803f abstractC2803f : this.f10381l.values()) {
            abstractC2803f.mo10876a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10957a(AbstractC2769b abstractC2769b) {
        if (this.f10381l.isEmpty()) {
            return;
        }
        if (this.f10377g) {
            this.f10377g = false;
            new Thread(this.f10391v).start();
        }
        for (AbstractC2803f abstractC2803f : this.f10381l.values()) {
            abstractC2803f.mo10875a(abstractC2769b);
        }
    }

    /* renamed from: b */
    private void m10945b() {
        if (this.f10381l.isEmpty()) {
            return;
        }
        for (AbstractC2803f abstractC2803f : this.f10381l.values()) {
            abstractC2803f.mo10872b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m10944b(int i) {
        if (m10958a(i)) {
            if (!this.f10389t || SystemClock.uptimeMillis() - this.f10387r <= 2000) {
            }
            this.f10386q = SystemClock.uptimeMillis();
            this.f10387r = SystemClock.uptimeMillis();
        } else if (i == 99 || i == 98 || i == 100 || i == 105) {
            if (EnumC2802a.CONNECTED != this.f10388s) {
                this.f10388s = EnumC2802a.CONNECTED;
                for (AbstractC2803f abstractC2803f : this.f10381l.values()) {
                    abstractC2803f.mo10871b(true);
                }
            }
            this.f10386q = SystemClock.uptimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m10941b(String str) {
        if (this.f10381l.isEmpty()) {
            return;
        }
        for (AbstractC2803f abstractC2803f : this.f10381l.values()) {
            abstractC2803f.mo10874a(str);
        }
    }

    /* renamed from: a */
    public void m10956a(C2770c c2770c) {
        byte[] m11068d;
        if (c2770c == null || (m11068d = c2770c.m11068d()) == null) {
            return;
        }
        try {
            mo10935d(m11068d);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m10955a(C2770c c2770c, boolean z) {
        byte[] m11071a = c2770c.m11071a(z);
        try {
            if (c2770c.f10263c == 18) {
                return;
            }
            if (c2770c.f10263c != 129 && c2770c.f10263c != 131 && c2770c.f10263c != 133 && c2770c.f10263c != 147 && c2770c.f10263c != 130 && c2770c.f10263c != 132 && c2770c.f10263c != 134 && c2770c.f10263c != 291 && c2770c.f10263c != 148 && c2770c.f10263c != 149) {
                return;
            }
            if (this.f10376f == null) {
                this.f10376f = m10932f();
            }
            if (this.f10376f == null) {
                return;
            }
            this.f10376f.write(C3695s.m7432a());
            if (z) {
                this.f10376f.write("  send  ");
            } else {
                this.f10376f.write("  read  ");
            }
            StringBuffer stringBuffer = new StringBuffer(m11071a.length * 2);
            for (int i = 0; i < m11071a.length; i++) {
                stringBuffer.append(Character.forDigit((m11071a[i] & 240) >> 4, 16));
                stringBuffer.append(Character.forDigit(m11071a[i] & 15, 16));
                stringBuffer.append(" ");
            }
            this.f10376f.write(stringBuffer.toString());
            this.f10376f.write("\n");
            this.f10376f.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m10948a(String str) {
        this.f10381l.remove(str);
    }

    /* renamed from: a */
    public void m10947a(String str, AbstractC2803f abstractC2803f) {
        this.f10381l.put(str, abstractC2803f);
        if (m10927i() == 2) {
            abstractC2803f.mo10876a();
        }
    }

    /* renamed from: a */
    public void m10946a(byte[] bArr, String str) {
    }

    /* renamed from: a */
    public boolean m10958a(int i) {
        return i == 2 || i == 3 || i == 4 || i == 5 || i == 11 || i == 7 || i == 9 || i == 10 || i == 134 || i == 135 || i == 49 || i == 52 || i == 50 || i == 51 || i == 106 || i == 16 || i == 122 || i == 128 || i == 129 || i == 130 || i == 131 || i == 132 || i == 133 || i == 136 || i == 137 || i == 144 || i == 145 || i == 146 || i == 147 || i == 148 || i == 152 || i == 153 || i == 154 || i == 51 || i == 106 || i == 193 || i == 194 || i == 198 || i == 199 || i == 201 || i == 202 || i == 203 || i == 12 || i == 211 || i == 8;
    }

    /* renamed from: b */
    protected abstract int mo10940b(byte[] bArr);

    /* renamed from: c */
    public void m10938c(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            mo10935d(bArr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    protected abstract void mo10937d();

    /* renamed from: d */
    protected abstract void mo10935d(byte[] bArr);

    /* renamed from: e */
    protected abstract void mo10934e();

    /* renamed from: f */
    public BufferedWriter m10932f() {
        File file = new File(C3681j.m7482a() + "/updateLog/");
        file.mkdirs();
        File file2 = new File(file, C3695s.m7432a() + ".txt");
        if (file2.exists()) {
            file2.delete();
        }
        new BufferedOutputStream(new FileOutputStream(file2));
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2)));
    }

    /* renamed from: g */
    public void m10930g() {
        if (this.f10383n.compareAndSet(0, 1)) {
            this.f10385p = new Thread(this.f10384o, "MiLinkConnection-Connecting Thread");
            this.f10385p.start();
        }
    }

    /* renamed from: h */
    public void m10928h() {
        if (this.f10383n.get() == 0 || this.f10385p == null) {
            return;
        }
        try {
            this.f10383n.set(0);
            if (this.f10385p.isAlive() && !this.f10385p.isInterrupted()) {
                this.f10385p.interrupt();
            }
            mo10934e();
            m10945b();
        } catch (IOException e) {
            m10941b(e.getMessage());
        }
    }

    /* renamed from: i */
    public int m10927i() {
        return this.f10383n.get();
    }

    /* renamed from: j */
    public abstract int mo10926j();

    /* renamed from: k */
    public void m10925k() {
        this.f10383n.set(0);
    }
}
