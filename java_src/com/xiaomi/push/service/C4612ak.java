package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* renamed from: com.xiaomi.push.service.ak */
/* loaded from: classes.dex */
public class C4612ak {

    /* renamed from: a */
    private static C4612ak f18951a;

    /* renamed from: b */
    private ConcurrentHashMap<String, HashMap<String, C4614b>> f18952b = new ConcurrentHashMap<>();

    /* renamed from: c */
    private List<AbstractC4613a> f18953c = new ArrayList();

    /* renamed from: com.xiaomi.push.service.ak$a */
    /* loaded from: classes.dex */
    public interface AbstractC4613a {
        /* renamed from: a */
        void mo4284a();
    }

    /* renamed from: com.xiaomi.push.service.ak$b */
    /* loaded from: classes.dex */
    public static class C4614b {

        /* renamed from: a */
        public String f18954a;

        /* renamed from: b */
        public String f18955b;

        /* renamed from: c */
        public String f18956c;

        /* renamed from: d */
        public String f18957d;

        /* renamed from: e */
        public boolean f18958e;

        /* renamed from: f */
        public String f18959f;

        /* renamed from: g */
        public String f18960g;

        /* renamed from: h */
        public String f18961h;

        /* renamed from: i */
        public String f18962i;

        /* renamed from: j */
        public String f18963j;

        /* renamed from: k */
        public C4643b f18964k;

        /* renamed from: l */
        public Context f18965l;

        /* renamed from: p */
        private XMPushService f18969p;

        /* renamed from: m */
        EnumC4616c f18966m = EnumC4616c.unbind;

        /* renamed from: n */
        private int f18967n = 0;

        /* renamed from: o */
        private List<AbstractC4615a> f18968o = new ArrayList();

        /* renamed from: q */
        private XMPushService.C4583b f18970q = new XMPushService.C4583b(this);

        /* renamed from: com.xiaomi.push.service.ak$b$a */
        /* loaded from: classes2.dex */
        public interface AbstractC4615a {
            /* renamed from: a */
            void mo3815a(EnumC4616c enumC4616c, EnumC4616c enumC4616c2, int i);
        }

        public C4614b() {
        }

        public C4614b(XMPushService xMPushService) {
            this.f18969p = xMPushService;
            m4366a(new C4617al(this));
        }

        /* renamed from: a */
        public long m4368a() {
            return 1000 * (((long) ((Math.random() * 20.0d) - 10.0d)) + ((this.f18967n + 1) * 15));
        }

        /* renamed from: a */
        public String m4367a(int i) {
            switch (i) {
                case 1:
                    return "OPEN";
                case 2:
                    return "CLOSE";
                case 3:
                    return "KICK";
                default:
                    return "unknown";
            }
        }

        /* renamed from: a */
        public void m4366a(AbstractC4615a abstractC4615a) {
            synchronized (this.f18968o) {
                this.f18968o.add(abstractC4615a);
            }
        }

        /* renamed from: a */
        public void m4364a(EnumC4616c enumC4616c, int i, int i2, String str, String str2) {
            boolean z = true;
            synchronized (this.f18968o) {
                for (AbstractC4615a abstractC4615a : this.f18968o) {
                    abstractC4615a.mo3815a(this.f18966m, enumC4616c, i2);
                }
            }
            if (this.f18966m != enumC4616c) {
                AbstractC4478b.m5041a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", this.f18966m, enumC4616c, m4367a(i), AbstractC4618am.m4361a(i2), str, str2, this.f18961h));
                this.f18966m = enumC4616c;
            }
            if (this.f18964k == null) {
                AbstractC4478b.m5036d("status changed while the client dispatcher is missing");
            } else if (i == 2) {
                this.f18964k.m4292a(this.f18965l, this, i2);
            } else if (i == 3) {
                this.f18964k.m4291a(this.f18965l, this, str2, str);
            } else if (i == 1) {
                if (enumC4616c != EnumC4616c.binded) {
                    z = false;
                }
                if (!z && "wait".equals(str2)) {
                    this.f18967n++;
                } else if (z) {
                    this.f18967n = 0;
                }
                this.f18964k.m4290a(this.f18965l, this, z, i2, str);
            }
        }

        /* renamed from: b */
        public void m4363b(AbstractC4615a abstractC4615a) {
            synchronized (this.f18968o) {
                this.f18968o.remove(abstractC4615a);
            }
        }
    }

    /* renamed from: com.xiaomi.push.service.ak$c */
    /* loaded from: classes.dex */
    public enum EnumC4616c {
        unbind,
        binding,
        binded
    }

    private C4612ak() {
    }

    /* renamed from: a */
    public static synchronized C4612ak m4383a() {
        C4612ak c4612ak;
        synchronized (C4612ak.class) {
            if (f18951a == null) {
                f18951a = new C4612ak();
            }
            c4612ak = f18951a;
        }
        return c4612ak;
    }

    /* renamed from: d */
    private String m4370d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("@");
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    /* renamed from: a */
    public synchronized void m4382a(Context context) {
        for (HashMap<String, C4614b> hashMap : this.f18952b.values()) {
            for (C4614b c4614b : hashMap.values()) {
                c4614b.m4364a(EnumC4616c.unbind, 1, 3, null, null);
            }
        }
    }

    /* renamed from: a */
    public synchronized void m4381a(Context context, int i) {
        for (HashMap<String, C4614b> hashMap : this.f18952b.values()) {
            for (C4614b c4614b : hashMap.values()) {
                c4614b.m4364a(EnumC4616c.unbind, 2, i, null, null);
            }
        }
    }

    /* renamed from: a */
    public synchronized void m4380a(AbstractC4613a abstractC4613a) {
        this.f18953c.add(abstractC4613a);
    }

    /* renamed from: a */
    public synchronized void m4379a(C4614b c4614b) {
        HashMap<String, C4614b> hashMap = this.f18952b.get(c4614b.f18961h);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.f18952b.put(c4614b.f18961h, hashMap);
        }
        hashMap.put(m4370d(c4614b.f18955b), c4614b);
        for (AbstractC4613a abstractC4613a : this.f18953c) {
            abstractC4613a.mo4284a();
        }
    }

    /* renamed from: a */
    public synchronized void m4378a(String str) {
        HashMap<String, C4614b> hashMap = this.f18952b.get(str);
        if (hashMap != null) {
            hashMap.clear();
            this.f18952b.remove(str);
        }
        for (AbstractC4613a abstractC4613a : this.f18953c) {
            abstractC4613a.mo4284a();
        }
    }

    /* renamed from: a */
    public synchronized void m4377a(String str, String str2) {
        HashMap<String, C4614b> hashMap = this.f18952b.get(str);
        if (hashMap != null) {
            hashMap.remove(m4370d(str2));
            if (hashMap.isEmpty()) {
                this.f18952b.remove(str);
            }
        }
        for (AbstractC4613a abstractC4613a : this.f18953c) {
            abstractC4613a.mo4284a();
        }
    }

    /* renamed from: b */
    public synchronized C4614b m4374b(String str, String str2) {
        HashMap<String, C4614b> hashMap;
        hashMap = this.f18952b.get(str);
        return hashMap == null ? null : hashMap.get(m4370d(str2));
    }

    /* renamed from: b */
    public synchronized ArrayList<C4614b> m4376b() {
        ArrayList<C4614b> arrayList;
        arrayList = new ArrayList<>();
        for (HashMap<String, C4614b> hashMap : this.f18952b.values()) {
            arrayList.addAll(hashMap.values());
        }
        return arrayList;
    }

    /* renamed from: b */
    public synchronized List<String> m4375b(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (HashMap<String, C4614b> hashMap : this.f18952b.values()) {
            for (C4614b c4614b : hashMap.values()) {
                if (str.equals(c4614b.f18954a)) {
                    arrayList.add(c4614b.f18961h);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public synchronized int m4373c() {
        return this.f18952b.size();
    }

    /* renamed from: c */
    public synchronized Collection<C4614b> m4372c(String str) {
        return !this.f18952b.containsKey(str) ? new ArrayList<>() : ((HashMap) this.f18952b.get(str).clone()).values();
    }

    /* renamed from: d */
    public synchronized void m4371d() {
        this.f18952b.clear();
    }

    /* renamed from: e */
    public synchronized void m4369e() {
        this.f18953c.clear();
    }
}
