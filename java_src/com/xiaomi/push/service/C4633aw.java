package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.push.service.C4630av;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* renamed from: com.xiaomi.push.service.aw */
/* loaded from: classes.dex */
public class C4633aw {

    /* renamed from: a */
    private static C4633aw f19042a = new C4633aw();

    /* renamed from: b */
    private static ExecutorService f19043b = Executors.newSingleThreadExecutor();

    /* renamed from: c */
    private Context f19044c;

    /* renamed from: e */
    private String f19046e;

    /* renamed from: d */
    private Map<String, AbstractC4635b> f19045d = new HashMap();

    /* renamed from: f */
    private final ArrayList<C4630av.C4632b> f19047f = new ArrayList<>();

    /* renamed from: com.xiaomi.push.service.aw$a */
    /* loaded from: classes2.dex */
    public class RunnableC4634a implements Runnable {

        /* renamed from: a */
        AbstractC4635b f19048a;

        /* renamed from: b */
        String f19049b;

        public RunnableC4634a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C4633aw.this.f19045d.put(this.f19049b, this.f19048a);
            C4633aw.this.m4302c("Add uploader, provider is " + this.f19049b);
        }
    }

    /* renamed from: com.xiaomi.push.service.aw$b */
    /* loaded from: classes.dex */
    public interface AbstractC4635b {
        /* renamed from: a */
        void mo4280a(ArrayList<C4630av.C4632b> arrayList);

        /* renamed from: a */
        boolean mo4283a(C4630av.C4632b c4632b);
    }

    /* renamed from: com.xiaomi.push.service.aw$c */
    /* loaded from: classes2.dex */
    public class RunnableC4636c implements Runnable {

        /* renamed from: b */
        private Context f19052b;

        public RunnableC4636c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C4633aw.this.f19044c != null) {
                AbstractC4478b.m5036d("[TinyDataManager]: please do not init TinyDataManager repeatly.");
                return;
            }
            C4633aw.this.f19044c = this.f19052b;
            C4633aw.this.m4314a(new C4630av.C4631a(this.f19052b), "SHORT_UPLOADER_FROM_SELF");
            C4633aw.this.m4302c("Init");
        }
    }

    /* renamed from: com.xiaomi.push.service.aw$d */
    /* loaded from: classes2.dex */
    private class RunnableC4637d implements Runnable {

        /* renamed from: a */
        String f19053a;

        public RunnableC4637d(String str) {
            this.f19053a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            C4633aw.this.m4302c(this.f19053a);
        }
    }

    /* renamed from: com.xiaomi.push.service.aw$e */
    /* loaded from: classes2.dex */
    private class RunnableC4638e implements Runnable {

        /* renamed from: a */
        String f19055a;

        private RunnableC4638e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(C4633aw.this.f19046e)) {
                AbstractC4478b.m5036d("[TinyDataManager]:channel is not null, please do not set repeatly.");
                return;
            }
            C4633aw.this.f19046e = this.f19055a;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= C4633aw.this.f19047f.size()) {
                    C4633aw.this.m4302c("Set channel to " + this.f19055a);
                    return;
                }
                C4630av.C4632b c4632b = (C4630av.C4632b) C4633aw.this.f19047f.get(i2);
                if (!c4632b.f19041c.f20152f && c4632b.f19041c.f20147a == null) {
                    c4632b.f19041c.f20147a = this.f19055a;
                }
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.xiaomi.push.service.aw$f */
    /* loaded from: classes2.dex */
    public class RunnableC4639f implements Runnable {

        /* renamed from: a */
        C4630av.C4632b f19057a;

        private RunnableC4639f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            boolean z = true;
            if (this.f19057a.f19041c.f20152f) {
                this.f19057a.f19041c.f20147a = "push_sdk_channel";
            } else {
                this.f19057a.f19041c.f20147a = C4633aw.this.f19046e;
            }
            this.f19057a.f19039a = C4630av.m4322a();
            AbstractC4635b m4304c = C4633aw.this.m4304c();
            String str2 = null;
            boolean z2 = false;
            if (m4304c == null) {
                str2 = "uploader is null";
                z2 = true;
            }
            if (!z2 && C4633aw.this.m4308b()) {
                str2 = "TinyDataManager need init";
                z2 = true;
            }
            if (!z2 && this.f19057a.f19041c.f20147a == null) {
                str2 = "request channel is null";
                z2 = true;
            }
            if (z2 || m4304c.mo4283a(this.f19057a)) {
                z = z2;
                str = str2;
            } else {
                str = "uploader refuse upload";
            }
            if (z) {
                AbstractC4478b.m5037c(this.f19057a.toString() + " is added to pending list. Pending Reason is " + str);
                C4633aw.this.f19047f.add(this.f19057a);
                return;
            }
            AbstractC4478b.m5037c(this.f19057a.toString() + " is uploaded immediately.");
            ArrayList<C4630av.C4632b> arrayList = new ArrayList<>();
            arrayList.add(this.f19057a);
            m4304c.mo4280a(arrayList);
        }
    }

    private C4633aw() {
    }

    /* renamed from: a */
    public static C4633aw m4319a() {
        return f19042a;
    }

    /* renamed from: a */
    private void m4315a(C4630av.C4632b c4632b) {
        RunnableC4639f runnableC4639f = new RunnableC4639f();
        runnableC4639f.f19057a = c4632b;
        f19043b.execute(runnableC4639f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public AbstractC4635b m4304c() {
        AbstractC4635b abstractC4635b = this.f19045d.get("UPLOADER_FROM_MIPUSHCLIENT");
        if (abstractC4635b != null) {
            return abstractC4635b;
        }
        AbstractC4635b abstractC4635b2 = this.f19045d.get("UPLOADER_FROM_XMPUSHSERVICE");
        if (abstractC4635b2 != null) {
            return abstractC4635b2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public boolean m4302c(String str) {
        AbstractC4635b m4304c;
        AbstractC4478b.m5037c("TinyDataManager is checking and uploading tiny data, reason is " + str + ", the size of pending list is " + this.f19047f.size());
        if (!m4308b() && (m4304c = m4304c()) != null) {
            ArrayList<C4630av.C4632b> arrayList = new ArrayList<>();
            Iterator<C4630av.C4632b> it2 = this.f19047f.iterator();
            while (it2.hasNext()) {
                C4630av.C4632b next = it2.next();
                if (next.f19041c.f20147a != null && m4304c.mo4283a(next)) {
                    arrayList.add(next);
                }
            }
            if (arrayList.size() != 0) {
                m4304c.mo4280a(arrayList);
                Iterator<C4630av.C4632b> it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    C4630av.C4632b next2 = it3.next();
                    AbstractC4478b.m5037c("Pending Data " + next2.toString() + " uploaded by TinyDataManager, reason is " + str);
                    this.f19047f.remove(next2);
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void m4316a(Context context) {
        if (context == null) {
            AbstractC4478b.m5036d("[TinyDataManager]:context is null, TinyDataManager.init(Context, TinyDataUploader) failed.");
            return;
        }
        RunnableC4636c runnableC4636c = new RunnableC4636c();
        runnableC4636c.f19052b = context;
        f19043b.execute(runnableC4636c);
    }

    /* renamed from: a */
    public void m4314a(AbstractC4635b abstractC4635b, String str) {
        if (abstractC4635b == null) {
            AbstractC4478b.m5036d("[TinyDataManager]: please do not add null uploader to TinyDataManager.");
        } else if (TextUtils.isEmpty(str)) {
            AbstractC4478b.m5036d("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            RunnableC4634a runnableC4634a = new RunnableC4634a();
            runnableC4634a.f19049b = str;
            runnableC4634a.f19048a = abstractC4635b;
            f19043b.execute(runnableC4634a);
        }
    }

    /* renamed from: a */
    public void m4310a(String str) {
        if (!TextUtils.isEmpty(this.f19046e)) {
            AbstractC4478b.m5036d("[TinyDataManager]:channel is not null, please do not set repeatly.");
            return;
        }
        RunnableC4638e runnableC4638e = new RunnableC4638e();
        runnableC4638e.f19055a = str;
        f19043b.execute(runnableC4638e);
    }

    /* renamed from: a */
    public boolean m4318a(int i, String str, String str2, long j, String str3) {
        return m4317a(i, str, str2, j, str3, true);
    }

    /* renamed from: a */
    public boolean m4317a(int i, String str, String str2, long j, String str3, boolean z) {
        if (C4630av.m4321a(str, str2, j, str3)) {
            return false;
        }
        C4630av.C4632b c4632b = new C4630av.C4632b();
        c4632b.f19040b = i;
        c4632b.f19041c.f20153g = str;
        c4632b.f19041c.f20149c = str2;
        c4632b.f19041c.f20150d = j;
        c4632b.f19041c.f20148b = str3;
        c4632b.f19041c.f20152f = z;
        c4632b.f19041c.f20151e = System.currentTimeMillis();
        m4315a(c4632b);
        return true;
    }

    /* renamed from: a */
    public boolean m4309a(String str, String str2, long j, String str3) {
        return m4318a(0, str, str2, j, str3);
    }

    /* renamed from: b */
    public void m4305b(String str) {
        f19043b.execute(new RunnableC4637d(str));
    }

    /* renamed from: b */
    public boolean m4308b() {
        return this.f19044c == null;
    }
}
