package com.xiaomi.push.log;

import android.content.Context;
import android.content.SharedPreferences;
import com.fimi.soul.utils.p211a.C3628c;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.tencent.p227mm.sdk.platformtools.Util;
import com.xiaomi.channel.commonutils.file.C4476c;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.misc.C4488h;
import com.xiaomi.channel.commonutils.network.C4497d;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.C4627at;
import com.xiaomi.smack.util.C4747e;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.xiaomi.push.log.b */
/* loaded from: classes.dex */
public class C4556b {

    /* renamed from: c */
    private static volatile C4556b f18721c = null;

    /* renamed from: a */
    private final ConcurrentLinkedQueue<C4558b> f18722a = new ConcurrentLinkedQueue<>();

    /* renamed from: b */
    private Context f18723b;

    /* renamed from: com.xiaomi.push.log.b$a */
    /* loaded from: classes2.dex */
    class C4557a extends C4558b {
        C4557a() {
            super();
        }

        @Override // com.xiaomi.push.log.C4556b.C4558b, com.xiaomi.channel.commonutils.misc.C4488h.AbstractC4490b
        /* renamed from: b */
        public void mo3817b() {
            C4556b.this.m4719b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.log.b$b */
    /* loaded from: classes2.dex */
    public class C4558b extends C4488h.AbstractC4490b {

        /* renamed from: i */
        long f18725i = System.currentTimeMillis();

        /* JADX INFO: Access modifiers changed from: package-private */
        public C4558b() {
        }

        @Override // com.xiaomi.channel.commonutils.misc.C4488h.AbstractC4490b
        /* renamed from: b */
        public void mo3817b() {
        }

        /* renamed from: d */
        public boolean mo4713d() {
            return true;
        }

        /* renamed from: e */
        final boolean m4714e() {
            return System.currentTimeMillis() - this.f18725i > 172800000;
        }
    }

    /* renamed from: com.xiaomi.push.log.b$c */
    /* loaded from: classes2.dex */
    class C4559c extends C4558b {

        /* renamed from: a */
        String f18727a;

        /* renamed from: b */
        String f18728b;

        /* renamed from: c */
        File f18729c;

        /* renamed from: d */
        int f18730d;

        /* renamed from: e */
        boolean f18731e;

        /* renamed from: f */
        boolean f18732f;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C4559c(String str, String str2, File file, boolean z) {
            super();
            this.f18727a = str;
            this.f18728b = str2;
            this.f18729c = file;
            this.f18732f = z;
        }

        /* renamed from: f */
        private boolean m4712f() {
            int i;
            SharedPreferences sharedPreferences = C4556b.this.f18723b.getSharedPreferences("log.timestamp", 0);
            String string = sharedPreferences.getString("log.requst", "");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(string);
                currentTimeMillis = jSONObject.getLong(C3628c.C3629a.f14776i);
                i = jSONObject.getInt("times");
            } catch (JSONException e) {
                i = 0;
            }
            if (System.currentTimeMillis() - currentTimeMillis >= Util.MILLSECONDS_OF_DAY) {
                currentTimeMillis = System.currentTimeMillis();
                i = 0;
            } else if (i > 10) {
                return false;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(C3628c.C3629a.f14776i, currentTimeMillis);
                jSONObject2.put("times", i + 1);
                sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
            } catch (JSONException e2) {
                AbstractC4478b.m5037c("JSONException on put " + e2.getMessage());
            }
            return true;
        }

        @Override // com.xiaomi.push.log.C4556b.C4558b, com.xiaomi.channel.commonutils.misc.C4488h.AbstractC4490b
        /* renamed from: b */
        public void mo3817b() {
            try {
                if (m4712f()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(C3947a.f16896g, C4627at.m4329e());
                    hashMap.put(Constants.EXTRA_KEY_TOKEN, this.f18728b);
                    hashMap.put("net", C4497d.m4978k(C4556b.this.f18723b));
                    C4497d.m4992a(this.f18727a, hashMap, this.f18729c, "file");
                }
                this.f18731e = true;
            } catch (IOException e) {
            }
        }

        @Override // com.xiaomi.channel.commonutils.misc.C4488h.AbstractC4490b
        /* renamed from: c */
        public void mo4323c() {
            if (!this.f18731e) {
                this.f18730d++;
                if (this.f18730d < 3) {
                    C4556b.this.f18722a.add(this);
                }
            }
            if (this.f18731e || this.f18730d >= 3) {
                this.f18729c.delete();
            }
            C4556b.this.m4724a((1 << this.f18730d) * 1000);
        }

        @Override // com.xiaomi.push.log.C4556b.C4558b
        /* renamed from: d */
        public boolean mo4713d() {
            return C4497d.m4983f(C4556b.this.f18723b) || (this.f18732f && C4497d.m4985d(C4556b.this.f18723b));
        }
    }

    private C4556b(Context context) {
        this.f18723b = context;
        this.f18722a.add(new C4557a());
        m4718b(0L);
    }

    /* renamed from: a */
    public static C4556b m4723a(Context context) {
        if (f18721c == null) {
            synchronized (C4556b.class) {
                if (f18721c == null) {
                    f18721c = new C4556b(context);
                }
            }
        }
        f18721c.f18723b = context;
        return f18721c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4724a(long j) {
        C4558b peek = this.f18722a.peek();
        if (peek == null || !peek.mo4713d()) {
            return;
        }
        m4718b(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m4719b() {
        if (C4476c.m5051b() || C4476c.m5052a()) {
            return;
        }
        try {
            File file = new File(this.f18723b.getExternalFilesDir(null) + "/.logcache");
            if (!file.exists() || !file.isDirectory()) {
                return;
            }
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                file2.delete();
            }
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: b */
    private void m4718b(long j) {
        if (!this.f18722a.isEmpty()) {
            C4747e.m3832a(new C4561d(this), j);
        }
    }

    /* renamed from: c */
    private void m4716c() {
        while (!this.f18722a.isEmpty()) {
            if (!this.f18722a.peek().m4714e() && this.f18722a.size() <= 6) {
                return;
            }
            AbstractC4478b.m5037c("remove Expired task");
            this.f18722a.remove();
        }
    }

    /* renamed from: a */
    public void m4725a() {
        m4716c();
        m4724a(0L);
    }

    /* renamed from: a */
    public void m4720a(String str, String str2, Date date, Date date2, int i, boolean z) {
        this.f18722a.add(new C4560c(this, i, date, date2, str, str2, z));
        m4718b(0L);
    }
}
