package com.xiaomi.push.protobuf;

import com.fimi.soul.module.setting.newhand.C3530b;
import com.google.p217a.p218a.AbstractC3995e;
import com.google.p217a.p218a.C3991b;
import com.google.p217a.p218a.C3992c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* renamed from: com.xiaomi.push.protobuf.a */
/* loaded from: classes2.dex */
public final class C4565a {

    /* renamed from: com.xiaomi.push.protobuf.a$a */
    /* loaded from: classes2.dex */
    public static final class C4566a extends AbstractC3995e {

        /* renamed from: a */
        private boolean f18753a;

        /* renamed from: c */
        private boolean f18755c;

        /* renamed from: e */
        private boolean f18757e;

        /* renamed from: g */
        private boolean f18759g;

        /* renamed from: b */
        private int f18754b = 0;

        /* renamed from: d */
        private boolean f18756d = false;

        /* renamed from: f */
        private int f18758f = 0;

        /* renamed from: h */
        private boolean f18760h = false;

        /* renamed from: i */
        private List<String> f18761i = Collections.emptyList();

        /* renamed from: j */
        private int f18762j = -1;

        /* renamed from: b */
        public static C4566a m4701b(byte[] bArr) {
            return (C4566a) new C4566a().a(bArr);
        }

        /* renamed from: c */
        public static C4566a m4700c(C3991b c3991b) {
            return new C4566a().mo4530a(c3991b);
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: a */
        public int mo4533a() {
            if (this.f18762j < 0) {
                mo4526b();
            }
            return this.f18762j;
        }

        /* renamed from: a */
        public C4566a m4707a(int i) {
            this.f18753a = true;
            this.f18754b = i;
            return this;
        }

        /* renamed from: a */
        public C4566a m4706a(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f18761i.isEmpty()) {
                this.f18761i = new ArrayList();
            }
            this.f18761i.add(str);
            return this;
        }

        /* renamed from: a */
        public C4566a m4705a(boolean z) {
            this.f18755c = true;
            this.f18756d = z;
            return this;
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: a */
        public void mo4529a(C3992c c3992c) {
            if (m4698e()) {
                c3992c.m6259b(1, m4699d());
            }
            if (m4696g()) {
                c3992c.m6271a(2, m4697f());
            }
            if (m4694i()) {
                c3992c.m6276a(3, m4695h());
            }
            if (m4692k()) {
                c3992c.m6271a(4, m4693j());
            }
            for (String str : m4691l()) {
                c3992c.m6272a(5, str);
            }
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: b */
        public int mo4526b() {
            int i = 0;
            int m6240d = m4698e() ? C3992c.m6240d(1, m4699d()) + 0 : 0;
            if (m4696g()) {
                m6240d += C3992c.m6254b(2, m4697f());
            }
            if (m4694i()) {
                m6240d += C3992c.m6245c(3, m4695h());
            }
            int m6254b = m4692k() ? m6240d + C3992c.m6254b(4, m4693j()) : m6240d;
            for (String str : m4691l()) {
                i += C3992c.m6250b(str);
            }
            int size = m6254b + i + (m4691l().size() * 1);
            this.f18762j = size;
            return size;
        }

        /* renamed from: b */
        public C4566a m4704b(int i) {
            this.f18757e = true;
            this.f18758f = i;
            return this;
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: b */
        public C4566a mo4530a(C3991b c3991b) {
            while (true) {
                int m6305a = c3991b.m6305a();
                switch (m6305a) {
                    case 0:
                        break;
                    case 8:
                        m4707a(c3991b.m6287i());
                        break;
                    case 16:
                        m4705a(c3991b.m6291f());
                        break;
                    case 24:
                        m4704b(c3991b.m6293e());
                        break;
                    case 32:
                        m4702b(c3991b.m6291f());
                        break;
                    case C3530b.f14177n /* 42 */:
                        m4706a(c3991b.m6289g());
                        break;
                    default:
                        if (a(c3991b, m6305a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        /* renamed from: b */
        public C4566a m4702b(boolean z) {
            this.f18759g = true;
            this.f18760h = z;
            return this;
        }

        /* renamed from: d */
        public int m4699d() {
            return this.f18754b;
        }

        /* renamed from: e */
        public boolean m4698e() {
            return this.f18753a;
        }

        /* renamed from: f */
        public boolean m4697f() {
            return this.f18756d;
        }

        /* renamed from: g */
        public boolean m4696g() {
            return this.f18755c;
        }

        /* renamed from: h */
        public int m4695h() {
            return this.f18758f;
        }

        /* renamed from: i */
        public boolean m4694i() {
            return this.f18757e;
        }

        /* renamed from: j */
        public boolean m4693j() {
            return this.f18760h;
        }

        /* renamed from: k */
        public boolean m4692k() {
            return this.f18759g;
        }

        /* renamed from: l */
        public List<String> m4691l() {
            return this.f18761i;
        }

        /* renamed from: m */
        public int m4690m() {
            return this.f18761i.size();
        }
    }
}
