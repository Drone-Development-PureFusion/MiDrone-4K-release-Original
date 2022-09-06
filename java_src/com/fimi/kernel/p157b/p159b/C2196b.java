package com.fimi.kernel.p157b.p159b;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.fimi.kernel.utils.C2259g;
import com.fimi.kernel.utils.C2274s;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.media.player.FimiMediaMeta;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.kernel.b.b.b */
/* loaded from: classes.dex */
public class C2196b {

    /* renamed from: b */
    private static ExecutorService f7358b = Executors.newCachedThreadPool();

    /* renamed from: c */
    private static final int f7359c = 1;

    /* renamed from: d */
    private static final int f7360d = 1;

    /* renamed from: e */
    private static final int f7361e = 2;

    /* renamed from: f */
    private static final int f7362f = 3;

    /* renamed from: a */
    float f7363a;

    /* renamed from: g */
    private AbstractC2203e f7364g;

    /* renamed from: h */
    private AbstractC2202d f7365h;

    /* renamed from: i */
    private AbstractC2202d f7366i;

    /* renamed from: j */
    private long f7367j;

    /* renamed from: k */
    private long f7368k;

    /* renamed from: l */
    private long f7369l;

    /* renamed from: m */
    private long f7370m;

    /* renamed from: n */
    private String f7371n;

    /* renamed from: o */
    private String f7372o;

    /* renamed from: p */
    private String f7373p;

    /* renamed from: q */
    private List<C2210d> f7374q;

    /* renamed from: r */
    private List<RunnableC2200c> f7375r;

    /* renamed from: s */
    private Context f7376s;

    /* renamed from: t */
    private HandlerC2204f f7377t;

    /* renamed from: u */
    private EnumC2198a f7378u;

    /* renamed from: v */
    private Object f7379v;

    /* renamed from: w */
    private Bitmap f7380w;

    /* renamed from: x */
    private String f7381x;

    /* renamed from: y */
    private long f7382y;

    /* renamed from: com.fimi.kernel.b.b.b$a */
    /* loaded from: classes.dex */
    public enum EnumC2198a {
        Error,
        Pause,
        Wait,
        Downloading,
        Completed
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.fimi.kernel.b.b.b$b */
    /* loaded from: classes.dex */
    public class C2199b extends Thread {

        /* renamed from: a */
        Boolean f7390a;

        /* renamed from: b */
        Boolean f7391b = true;

        public C2199b() {
            this.f7390a = false;
            this.f7390a = true;
        }

        public C2199b(long j) {
            this.f7390a = false;
            C2196b.this.f7367j = j;
            this.f7390a = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Message message = new Message();
            message.what = 1;
            if (this.f7390a.booleanValue()) {
                this.f7391b = Boolean.valueOf(C2196b.this.m13242q());
            } else {
                this.f7391b = Boolean.valueOf(C2196b.this.m13240r());
            }
            if (this.f7391b.booleanValue()) {
                long j = C2196b.this.f7367j / 1;
                C2196b.this.f7374q = new ArrayList();
                for (int i = 0; i < 1; i++) {
                    C2196b.this.f7374q.add(new C2210d(i, i * j, (i + 1) * j, 0L, C2196b.this.f7372o));
                }
                C2213f m13205a = C2213f.m13205a(C2196b.this.f7376s);
                m13205a.m13201a(C2196b.this.f7374q);
                m13205a.m13203a(C2196b.this);
                C2196b.this.f7368k = 0L;
                message.arg1 = 1;
            } else {
                message.arg1 = 0;
            }
            if (C2196b.this.f7377t != null) {
                C2196b.this.f7377t.sendMessage(message);
            }
        }
    }

    /* renamed from: com.fimi.kernel.b.b.b$c */
    /* loaded from: classes.dex */
    private class RunnableC2200c implements Runnable {

        /* renamed from: b */
        private boolean f7394b = false;

        /* renamed from: c */
        private C2210d f7395c;

        public RunnableC2200c(C2210d c2210d) {
            this.f7395c = c2210d;
        }

        @Override // java.lang.Runnable
        public void run() {
            HttpURLConnection httpURLConnection;
            InputStream inputStream;
            int i;
            HttpURLConnection httpURLConnection2 = null;
            InputStream inputStream2 = null;
            long m13212e = this.f7395c.m13212e();
            try {
                long m13215c = this.f7395c.m13215c();
                long m13213d = this.f7395c.m13213d();
                HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(this.f7395c.m13221a()).openConnection();
                try {
                    try {
                        httpURLConnection3.setConnectTimeout(3000);
                        httpURLConnection3.setReadTimeout(3000);
                        httpURLConnection3.setRequestMethod("GET");
                        httpURLConnection3.setRequestProperty("Range", "bytes=" + (m13215c + m13212e) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + m13213d);
                        RandomAccessFile randomAccessFile = new RandomAccessFile(C2196b.this.m13260h(), "rwd");
                        randomAccessFile.seek(m13215c + m13212e);
                        InputStream inputStream3 = httpURLConnection3.getInputStream();
                        try {
                            byte[] bArr = new byte[5120];
                            int i2 = 0;
                            long j = 0;
                            long j2 = m13212e;
                            while (true) {
                                int i3 = i2;
                                int read = inputStream3.read(bArr);
                                if (read != -1 && !this.f7394b) {
                                    randomAccessFile.write(bArr, 0, read);
                                    j2 += read;
                                    this.f7395c.m13214c(j2);
                                    synchronized (C2196b.this.f7374q) {
                                        i = 0;
                                        for (C2210d c2210d : C2196b.this.f7374q) {
                                            i = (int) (i + c2210d.m13212e());
                                        }
                                    }
                                    C2196b.this.f7368k = i;
                                    C2196b.this.f7363a = (float) ((System.currentTimeMillis() - C2196b.this.f7382y) / 1000);
                                    if (C2196b.this.f7363a >= 1.0f) {
                                        C2196b.this.f7382y = System.currentTimeMillis();
                                        C2196b.this.f7370m = ((float) (C2196b.this.f7368k - C2196b.this.f7369l)) / C2196b.this.f7363a;
                                        C2196b.this.f7369l = C2196b.this.f7368k;
                                        C2281x.m12704a(new Runnable() { // from class: com.fimi.kernel.b.b.b.c.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                C2213f.m13205a(C2196b.this.f7376s).m13206a(RunnableC2200c.this.f7395c.m13217b(), RunnableC2200c.this.f7395c.m13212e(), RunnableC2200c.this.f7395c.m13221a());
                                            }
                                        });
                                    }
                                    Message obtain = Message.obtain();
                                    obtain.what = 2;
                                    obtain.arg1 = read;
                                    if (C2196b.this.f7368k >= C2196b.this.f7367j) {
                                        try {
                                            if (C2196b.this.f7380w == null) {
                                                if (C2259g.m12972g(C2196b.this.f7371n)) {
                                                    C2196b.this.f7380w = ThumbnailUtils.createVideoThumbnail(C2196b.this.f7371n, 1);
                                                    C2196b.this.f7381x = C2274s.m12828a(C2196b.this.f7376s, C2196b.this.f7371n);
                                                } else {
                                                    C2196b.this.f7380w = C2274s.m12827a(C2196b.this.f7376s, C2196b.this.f7371n, 160);
                                                }
                                            }
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        C2213f.m13205a(C2196b.this.f7376s).m13195d(C2196b.this.f7372o);
                                        C2196b.this.f7376s.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(C2196b.this.m13260h()))));
                                    }
                                    i2 = (int) (C2196b.this.f7368k / (C2196b.this.f7367j / 100));
                                    if (C2196b.this.f7377t != null && (i3 != i2 || j != C2196b.this.f7370m || C2196b.this.f7368k >= C2196b.this.f7367j)) {
                                        C2196b.this.f7377t.sendMessage(obtain);
                                    }
                                    j = C2196b.this.f7370m;
                                    if (C2196b.this.f7378u != EnumC2198a.Pause) {
                                    }
                                }
                                try {
                                    httpURLConnection3.disconnect();
                                    inputStream3.close();
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                        } catch (Exception e3) {
                            inputStream = inputStream3;
                            httpURLConnection = httpURLConnection3;
                            e = e3;
                            try {
                                e.printStackTrace();
                                Log.d("Good", "DOWNLOADING ERROR " + e + ",id" + this.f7395c.m13217b());
                                Message obtain2 = Message.obtain();
                                C2196b.this.f7378u = EnumC2198a.Error;
                                obtain2.what = 3;
                                if (C2196b.this.f7377t != null) {
                                    C2196b.this.f7377t.sendMessage(obtain2);
                                }
                                try {
                                    httpURLConnection.disconnect();
                                    inputStream.close();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            } catch (Throwable th) {
                                th = th;
                                InputStream inputStream4 = inputStream;
                                httpURLConnection2 = httpURLConnection;
                                inputStream2 = inputStream4;
                                try {
                                    httpURLConnection2.disconnect();
                                    inputStream2.close();
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        httpURLConnection2 = httpURLConnection3;
                        th = th2;
                        httpURLConnection2.disconnect();
                        inputStream2.close();
                        throw th;
                    }
                } catch (Exception e6) {
                    inputStream = null;
                    httpURLConnection = httpURLConnection3;
                    e = e6;
                }
            } catch (Exception e7) {
                e = e7;
                httpURLConnection = null;
                inputStream = null;
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* renamed from: com.fimi.kernel.b.b.b$d */
    /* loaded from: classes.dex */
    public interface AbstractC2202d {
        /* renamed from: a */
        void mo10038a(EnumC2198a enumC2198a, C2196b c2196b);
    }

    /* renamed from: com.fimi.kernel.b.b.b$e */
    /* loaded from: classes.dex */
    public interface AbstractC2203e {
        /* renamed from: a */
        void mo13194a(C2196b c2196b);
    }

    /* renamed from: com.fimi.kernel.b.b.b$f */
    /* loaded from: classes.dex */
    private class HandlerC2204f extends Handler {
        private HandlerC2204f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                C2196b c2196b = null;
                if (message.arg1 == 1) {
                    c2196b = C2196b.this;
                }
                C2196b.this.f7364g.mo13194a(c2196b);
            }
            if (message.what == 2) {
                if (C2196b.this.f7368k >= C2196b.this.f7367j) {
                    C2196b.this.f7378u = EnumC2198a.Completed;
                }
                if (C2196b.this.f7366i != null) {
                    C2196b.this.f7366i.mo10038a(C2196b.this.f7378u, C2196b.this);
                }
                if (C2196b.this.f7365h != null) {
                    C2196b.this.f7365h.mo10038a(C2196b.this.f7378u, C2196b.this);
                }
            }
            if (message.what != 3 || C2196b.this.f7365h == null) {
                return;
            }
            C2196b.this.f7365h.mo10038a(C2196b.this.f7378u, C2196b.this);
        }
    }

    private C2196b() {
        this.f7369l = this.f7368k;
        this.f7370m = 0L;
        this.f7375r = new ArrayList();
        this.f7378u = EnumC2198a.Wait;
        this.f7382y = System.currentTimeMillis();
        this.f7363a = 1.0f;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.f7377t = new HandlerC2204f();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C2196b(String str, String str2) {
        this();
        this.f7371n = str2;
        this.f7372o = str;
    }

    /* renamed from: a */
    protected static C2196b m13293a(Context context, String str) {
        C2196b m13199b = C2213f.m13205a(context).m13199b(str);
        if (m13199b != null) {
            m13199b.f7376s = context;
            m13199b.f7374q = C2213f.m13205a(context).m13197c(m13199b.m13250m());
            long j = 0;
            long j2 = 0;
            for (C2210d c2210d : m13199b.f7374q) {
                j2 += c2210d.m13212e();
                j = (c2210d.m13213d() - c2210d.m13215c()) + j;
            }
            m13199b.f7368k = j2;
            m13199b.f7367j = j;
        }
        return m13199b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static C2196b m13292a(Context context, String str, long j, Boolean bool, String str2, AbstractC2203e abstractC2203e) {
        if (abstractC2203e == null || context == null) {
            return null;
        }
        C2196b m13293a = m13293a(context, str);
        if (m13293a != null) {
            m13293a.f7373p = str.substring(str.lastIndexOf("/") + 1);
            m13293a.f7376s = context;
            abstractC2203e.mo13194a(m13293a);
            return m13293a;
        }
        C2196b c2196b = new C2196b();
        c2196b.f7376s = context;
        c2196b.f7372o = str;
        c2196b.f7371n = str2;
        c2196b.f7373p = str.substring(str.lastIndexOf("/") + 1);
        c2196b.f7364g = abstractC2203e;
        if (bool.booleanValue()) {
            c2196b.m13244p();
            return c2196b;
        }
        c2196b.m13281a(Long.valueOf(j));
        return c2196b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static C2196b m13291a(Context context, String str, String str2, long j, Boolean bool, String str3, AbstractC2203e abstractC2203e) {
        if (abstractC2203e == null || context == null) {
            return null;
        }
        C2196b c2196b = new C2196b();
        c2196b.f7376s = context;
        c2196b.f7372o = str;
        c2196b.f7371n = str3;
        c2196b.f7373p = str.substring(str.lastIndexOf("/") + 1);
        c2196b.f7364g = abstractC2203e;
        if (C2259g.m12972g(str3)) {
            c2196b.f7381x = str2;
        }
        if (bool.booleanValue()) {
            c2196b.m13244p();
            return c2196b;
        }
        c2196b.m13281a(Long.valueOf(j));
        return c2196b;
    }

    /* renamed from: a */
    private void m13281a(Long l) {
        new C2199b(l.longValue()).start();
    }

    /* renamed from: b */
    protected static void m13277b(Context context, String str, long j, Boolean bool, String str2, AbstractC2203e abstractC2203e) {
        if (abstractC2203e == null || context == null) {
            return;
        }
        C2196b m13293a = m13293a(context, str);
        if (m13293a != null) {
            m13293a.f7376s = context;
            abstractC2203e.mo13194a(m13293a);
            return;
        }
        C2196b c2196b = new C2196b();
        c2196b.f7376s = context;
        c2196b.f7372o = str;
        c2196b.f7371n = str2;
        c2196b.f7373p = str.substring(str.lastIndexOf("/") + 1);
        c2196b.f7364g = abstractC2203e;
        if (bool.booleanValue()) {
            c2196b.m13244p();
        } else {
            c2196b.m13281a(Long.valueOf(j));
        }
    }

    /* renamed from: p */
    private void m13244p() {
        new C2199b().start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public boolean m13242q() {
        File file = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f7372o).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            this.f7367j = httpURLConnection.getContentLength();
            Log.d("Good", "获取文件大小" + this.f7372o + ":" + this.f7367j);
            file = C2259g.m12973f(this.f7371n);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
            randomAccessFile.setLength(FimiMediaMeta.AV_CH_SIDE_RIGHT);
            randomAccessFile.close();
            httpURLConnection.disconnect();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("Good", "File 获取文件错误" + e);
            if (file != null) {
                file.delete();
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public boolean m13240r() {
        File file = null;
        try {
            file = C2259g.m12973f(this.f7371n);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
            randomAccessFile.setLength(FimiMediaMeta.AV_CH_SIDE_RIGHT);
            randomAccessFile.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("Good", "File 获取文件错误" + e);
            if (file != null) {
                file.delete();
            }
            return false;
        }
    }

    /* renamed from: a */
    public String m13294a() {
        return this.f7381x;
    }

    /* renamed from: a */
    public void m13290a(Handler handler) {
        handler.post(new Runnable() { // from class: com.fimi.kernel.b.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                C2196b.this.f7377t = new HandlerC2204f();
            }
        });
    }

    /* renamed from: a */
    public void m13289a(AbstractC2202d abstractC2202d) {
        this.f7365h = abstractC2202d;
    }

    /* renamed from: a */
    public void m13288a(C2196b c2196b) {
        if (c2196b == null || c2196b.f7375r == null || c2196b.f7375r.size() <= 0) {
            return;
        }
        for (int size = this.f7375r.size() - 1; size >= 0; size--) {
            this.f7375r.get(size).f7394b = true;
        }
        this.f7375r.clear();
    }

    /* renamed from: a */
    public void m13280a(Object obj) {
        this.f7379v = obj;
    }

    /* renamed from: a */
    public void m13279a(String str) {
        this.f7381x = str;
    }

    /* renamed from: b */
    public String m13278b() {
        return this.f7373p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void m13276b(AbstractC2202d abstractC2202d) {
        this.f7366i = abstractC2202d;
    }

    /* renamed from: c */
    public void m13273c() {
        if (this.f7374q != null) {
            if (this.f7378u == EnumC2198a.Downloading) {
                return;
            }
            this.f7378u = EnumC2198a.Downloading;
            for (C2210d c2210d : this.f7374q) {
                if (c2210d.m13215c() + c2210d.m13212e() < c2210d.m13213d()) {
                    RunnableC2200c runnableC2200c = new RunnableC2200c(c2210d);
                    f7358b.execute(runnableC2200c);
                    this.f7375r.add(runnableC2200c);
                }
            }
        }
        if (this.f7378u == EnumC2198a.Error) {
            Log.d("Good", "重新初始化任务信息");
            m13244p();
        }
    }

    /* renamed from: d */
    public void m13270d() {
        this.f7378u = EnumC2198a.Wait;
    }

    /* renamed from: e */
    public void m13267e() {
        this.f7378u = EnumC2198a.Pause;
    }

    /* renamed from: f */
    public void m13264f() {
        this.f7378u = EnumC2198a.Completed;
    }

    /* renamed from: g */
    public EnumC2198a m13262g() {
        return this.f7378u;
    }

    /* renamed from: h */
    public String m13260h() {
        return this.f7371n;
    }

    /* renamed from: i */
    public long m13258i() {
        return this.f7367j;
    }

    /* renamed from: j */
    public Object m13256j() {
        return this.f7379v;
    }

    /* renamed from: k */
    public long m13254k() {
        return this.f7368k;
    }

    /* renamed from: l */
    public long m13252l() {
        return this.f7370m;
    }

    /* renamed from: m */
    public String m13250m() {
        return this.f7372o;
    }

    /* renamed from: n */
    public Bitmap m13248n() {
        return this.f7380w;
    }

    /* renamed from: o */
    public AbstractC2202d m13246o() {
        return this.f7365h;
    }

    public String toString() {
        return "DownloadTaskInfo{fileSize=" + this.f7367j + ", complete=" + this.f7368k + ", urlstring='" + this.f7372o + C0359h.f729z + C0359h.f726w;
    }
}
