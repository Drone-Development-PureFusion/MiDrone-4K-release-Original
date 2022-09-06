package com.xiaomi.push.protobuf;

import com.fimi.soul.module.setting.newhand.C3530b;
import com.google.p217a.p218a.AbstractC3995e;
import com.google.p217a.p218a.C3990a;
import com.google.p217a.p218a.C3991b;
import com.google.p217a.p218a.C3992c;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import p004b.p005a.p006a.p028b.p041h.C0409j;
/* renamed from: com.xiaomi.push.protobuf.b */
/* loaded from: classes.dex */
public final class C4567b {

    /* renamed from: com.xiaomi.push.protobuf.b$a */
    /* loaded from: classes2.dex */
    public static final class C4568a extends AbstractC3995e {

        /* renamed from: a */
        private boolean f18763a;

        /* renamed from: c */
        private boolean f18765c;

        /* renamed from: e */
        private boolean f18767e;

        /* renamed from: g */
        private boolean f18769g;

        /* renamed from: i */
        private boolean f18771i;

        /* renamed from: k */
        private boolean f18773k;

        /* renamed from: m */
        private boolean f18775m;

        /* renamed from: o */
        private boolean f18777o;

        /* renamed from: q */
        private boolean f18779q;

        /* renamed from: s */
        private boolean f18781s;

        /* renamed from: u */
        private boolean f18783u;

        /* renamed from: b */
        private int f18764b = 0;

        /* renamed from: d */
        private long f18766d = 0;

        /* renamed from: f */
        private String f18768f = "";

        /* renamed from: h */
        private String f18770h = "";

        /* renamed from: j */
        private String f18772j = "";

        /* renamed from: l */
        private String f18774l = "";

        /* renamed from: n */
        private String f18776n = "";

        /* renamed from: p */
        private int f18778p = 1;

        /* renamed from: r */
        private int f18780r = 0;

        /* renamed from: t */
        private int f18782t = 0;

        /* renamed from: v */
        private String f18784v = "";

        /* renamed from: w */
        private int f18785w = -1;

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: a */
        public int mo4533a() {
            if (this.f18785w < 0) {
                mo4526b();
            }
            return this.f18785w;
        }

        /* renamed from: a */
        public C4568a m4689a(int i) {
            this.f18763a = true;
            this.f18764b = i;
            return this;
        }

        /* renamed from: a */
        public C4568a m4688a(long j) {
            this.f18765c = true;
            this.f18766d = j;
            return this;
        }

        /* renamed from: a */
        public C4568a m4687a(String str) {
            this.f18767e = true;
            this.f18768f = str;
            return this;
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: a */
        public void mo4529a(C3992c c3992c) {
            if (m4678e()) {
                c3992c.m6276a(1, m4681d());
            }
            if (m4674g()) {
                c3992c.m6258b(2, m4676f());
            }
            if (m4672i()) {
                c3992c.m6272a(3, m4673h());
            }
            if (m4670k()) {
                c3992c.m6272a(4, m4671j());
            }
            if (m4668m()) {
                c3992c.m6272a(5, m4669l());
            }
            if (m4666o()) {
                c3992c.m6272a(6, m4667n());
            }
            if (m4663r()) {
                c3992c.m6272a(7, m4664q());
            }
            if (m4662s()) {
                c3992c.m6276a(8, m4661t());
            }
            if (m4659v()) {
                c3992c.m6276a(9, m4660u());
            }
            if (m4657x()) {
                c3992c.m6276a(10, m4658w());
            }
            if (m4655z()) {
                c3992c.m6272a(11, m4656y());
            }
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: b */
        public int mo4526b() {
            int i = 0;
            if (m4678e()) {
                i = 0 + C3992c.m6245c(1, m4681d());
            }
            if (m4674g()) {
                i += C3992c.m6239d(2, m4676f());
            }
            if (m4672i()) {
                i += C3992c.m6255b(3, m4673h());
            }
            if (m4670k()) {
                i += C3992c.m6255b(4, m4671j());
            }
            if (m4668m()) {
                i += C3992c.m6255b(5, m4669l());
            }
            if (m4666o()) {
                i += C3992c.m6255b(6, m4667n());
            }
            if (m4663r()) {
                i += C3992c.m6255b(7, m4664q());
            }
            if (m4662s()) {
                i += C3992c.m6245c(8, m4661t());
            }
            if (m4659v()) {
                i += C3992c.m6245c(9, m4660u());
            }
            if (m4657x()) {
                i += C3992c.m6245c(10, m4658w());
            }
            if (m4655z()) {
                i += C3992c.m6255b(11, m4656y());
            }
            this.f18785w = i;
            return i;
        }

        /* renamed from: b */
        public C4568a m4686b(int i) {
            this.f18777o = true;
            this.f18778p = i;
            return this;
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: b */
        public C4568a mo4530a(C3991b c3991b) {
            while (true) {
                int m6305a = c3991b.m6305a();
                switch (m6305a) {
                    case 0:
                        break;
                    case 8:
                        m4689a(c3991b.m6293e());
                        break;
                    case 16:
                        m4688a(c3991b.m6295d());
                        break;
                    case 26:
                        m4687a(c3991b.m6289g());
                        break;
                    case 34:
                        m4684b(c3991b.m6289g());
                        break;
                    case C3530b.f14177n /* 42 */:
                        m4682c(c3991b.m6289g());
                        break;
                    case 50:
                        m4679d(c3991b.m6289g());
                        break;
                    case Opcodes.ASTORE /* 58 */:
                        m4677e(c3991b.m6289g());
                        break;
                    case 64:
                        m4686b(c3991b.m6293e());
                        break;
                    case C0409j.f902s /* 72 */:
                        m4683c(c3991b.m6293e());
                        break;
                    case 80:
                        m4680d(c3991b.m6293e());
                        break;
                    case 90:
                        m4675f(c3991b.m6289g());
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
        public C4568a m4684b(String str) {
            this.f18769g = true;
            this.f18770h = str;
            return this;
        }

        /* renamed from: c */
        public C4568a m4683c(int i) {
            this.f18779q = true;
            this.f18780r = i;
            return this;
        }

        /* renamed from: c */
        public C4568a m4682c(String str) {
            this.f18771i = true;
            this.f18772j = str;
            return this;
        }

        /* renamed from: d */
        public int m4681d() {
            return this.f18764b;
        }

        /* renamed from: d */
        public C4568a m4680d(int i) {
            this.f18781s = true;
            this.f18782t = i;
            return this;
        }

        /* renamed from: d */
        public C4568a m4679d(String str) {
            this.f18773k = true;
            this.f18774l = str;
            return this;
        }

        /* renamed from: e */
        public C4568a m4677e(String str) {
            this.f18775m = true;
            this.f18776n = str;
            return this;
        }

        /* renamed from: e */
        public boolean m4678e() {
            return this.f18763a;
        }

        /* renamed from: f */
        public long m4676f() {
            return this.f18766d;
        }

        /* renamed from: f */
        public C4568a m4675f(String str) {
            this.f18783u = true;
            this.f18784v = str;
            return this;
        }

        /* renamed from: g */
        public boolean m4674g() {
            return this.f18765c;
        }

        /* renamed from: h */
        public String m4673h() {
            return this.f18768f;
        }

        /* renamed from: i */
        public boolean m4672i() {
            return this.f18767e;
        }

        /* renamed from: j */
        public String m4671j() {
            return this.f18770h;
        }

        /* renamed from: k */
        public boolean m4670k() {
            return this.f18769g;
        }

        /* renamed from: l */
        public String m4669l() {
            return this.f18772j;
        }

        /* renamed from: m */
        public boolean m4668m() {
            return this.f18771i;
        }

        /* renamed from: n */
        public String m4667n() {
            return this.f18774l;
        }

        /* renamed from: o */
        public boolean m4666o() {
            return this.f18773k;
        }

        /* renamed from: p */
        public C4568a m4665p() {
            this.f18773k = false;
            this.f18774l = "";
            return this;
        }

        /* renamed from: q */
        public String m4664q() {
            return this.f18776n;
        }

        /* renamed from: r */
        public boolean m4663r() {
            return this.f18775m;
        }

        /* renamed from: s */
        public boolean m4662s() {
            return this.f18777o;
        }

        /* renamed from: t */
        public int m4661t() {
            return this.f18778p;
        }

        /* renamed from: u */
        public int m4660u() {
            return this.f18780r;
        }

        /* renamed from: v */
        public boolean m4659v() {
            return this.f18779q;
        }

        /* renamed from: w */
        public int m4658w() {
            return this.f18782t;
        }

        /* renamed from: x */
        public boolean m4657x() {
            return this.f18781s;
        }

        /* renamed from: y */
        public String m4656y() {
            return this.f18784v;
        }

        /* renamed from: z */
        public boolean m4655z() {
            return this.f18783u;
        }
    }

    /* renamed from: com.xiaomi.push.protobuf.b$b */
    /* loaded from: classes.dex */
    public static final class C4569b extends AbstractC3995e {

        /* renamed from: a */
        private boolean f18786a;

        /* renamed from: c */
        private boolean f18788c;

        /* renamed from: e */
        private boolean f18790e;

        /* renamed from: g */
        private boolean f18792g;

        /* renamed from: b */
        private boolean f18787b = false;

        /* renamed from: d */
        private int f18789d = 0;

        /* renamed from: f */
        private int f18791f = 0;

        /* renamed from: h */
        private int f18793h = 0;

        /* renamed from: i */
        private int f18794i = -1;

        /* renamed from: b */
        public static C4569b m4650b(byte[] bArr) {
            return (C4569b) new C4569b().a(bArr);
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: a */
        public int mo4533a() {
            if (this.f18794i < 0) {
                mo4526b();
            }
            return this.f18794i;
        }

        /* renamed from: a */
        public C4569b m4654a(int i) {
            this.f18788c = true;
            this.f18789d = i;
            return this;
        }

        /* renamed from: a */
        public C4569b m4653a(boolean z) {
            this.f18786a = true;
            this.f18787b = z;
            return this;
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: a */
        public void mo4529a(C3992c c3992c) {
            if (m4647e()) {
                c3992c.m6271a(1, m4648d());
            }
            if (m4645g()) {
                c3992c.m6276a(3, m4646f());
            }
            if (m4643i()) {
                c3992c.m6276a(4, m4644h());
            }
            if (m4641k()) {
                c3992c.m6276a(5, m4642j());
            }
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: b */
        public int mo4526b() {
            int i = 0;
            if (m4647e()) {
                i = 0 + C3992c.m6254b(1, m4648d());
            }
            if (m4645g()) {
                i += C3992c.m6245c(3, m4646f());
            }
            if (m4643i()) {
                i += C3992c.m6245c(4, m4644h());
            }
            if (m4641k()) {
                i += C3992c.m6245c(5, m4642j());
            }
            this.f18794i = i;
            return i;
        }

        /* renamed from: b */
        public C4569b m4652b(int i) {
            this.f18790e = true;
            this.f18791f = i;
            return this;
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: b */
        public C4569b mo4530a(C3991b c3991b) {
            while (true) {
                int m6305a = c3991b.m6305a();
                switch (m6305a) {
                    case 0:
                        break;
                    case 8:
                        m4653a(c3991b.m6291f());
                        break;
                    case 24:
                        m4654a(c3991b.m6293e());
                        break;
                    case 32:
                        m4652b(c3991b.m6293e());
                        break;
                    case 40:
                        m4649c(c3991b.m6293e());
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

        /* renamed from: c */
        public C4569b m4649c(int i) {
            this.f18792g = true;
            this.f18793h = i;
            return this;
        }

        /* renamed from: d */
        public boolean m4648d() {
            return this.f18787b;
        }

        /* renamed from: e */
        public boolean m4647e() {
            return this.f18786a;
        }

        /* renamed from: f */
        public int m4646f() {
            return this.f18789d;
        }

        /* renamed from: g */
        public boolean m4645g() {
            return this.f18788c;
        }

        /* renamed from: h */
        public int m4644h() {
            return this.f18791f;
        }

        /* renamed from: i */
        public boolean m4643i() {
            return this.f18790e;
        }

        /* renamed from: j */
        public int m4642j() {
            return this.f18793h;
        }

        /* renamed from: k */
        public boolean m4641k() {
            return this.f18792g;
        }
    }

    /* renamed from: com.xiaomi.push.protobuf.b$c */
    /* loaded from: classes2.dex */
    public static final class C4570c extends AbstractC3995e {

        /* renamed from: a */
        private boolean f18795a;

        /* renamed from: c */
        private boolean f18797c;

        /* renamed from: e */
        private boolean f18799e;

        /* renamed from: g */
        private boolean f18801g;

        /* renamed from: i */
        private boolean f18803i;

        /* renamed from: k */
        private boolean f18805k;

        /* renamed from: b */
        private String f18796b = "";

        /* renamed from: d */
        private String f18798d = "";

        /* renamed from: f */
        private String f18800f = "";

        /* renamed from: h */
        private String f18802h = "";

        /* renamed from: j */
        private String f18804j = "";

        /* renamed from: l */
        private String f18806l = "";

        /* renamed from: m */
        private int f18807m = -1;

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: a */
        public int mo4533a() {
            if (this.f18807m < 0) {
                mo4526b();
            }
            return this.f18807m;
        }

        /* renamed from: a */
        public C4570c m4640a(String str) {
            this.f18795a = true;
            this.f18796b = str;
            return this;
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: a */
        public void mo4529a(C3992c c3992c) {
            if (m4634e()) {
                c3992c.m6272a(1, m4636d());
            }
            if (m4630g()) {
                c3992c.m6272a(2, m4632f());
            }
            if (m4628i()) {
                c3992c.m6272a(3, m4629h());
            }
            if (m4626k()) {
                c3992c.m6272a(4, m4627j());
            }
            if (m4624m()) {
                c3992c.m6272a(5, m4625l());
            }
            if (m4622o()) {
                c3992c.m6272a(6, m4623n());
            }
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: b */
        public int mo4526b() {
            int i = 0;
            if (m4634e()) {
                i = 0 + C3992c.m6255b(1, m4636d());
            }
            if (m4630g()) {
                i += C3992c.m6255b(2, m4632f());
            }
            if (m4628i()) {
                i += C3992c.m6255b(3, m4629h());
            }
            if (m4626k()) {
                i += C3992c.m6255b(4, m4627j());
            }
            if (m4624m()) {
                i += C3992c.m6255b(5, m4625l());
            }
            if (m4622o()) {
                i += C3992c.m6255b(6, m4623n());
            }
            this.f18807m = i;
            return i;
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: b */
        public C4570c mo4530a(C3991b c3991b) {
            while (true) {
                int m6305a = c3991b.m6305a();
                switch (m6305a) {
                    case 0:
                        break;
                    case 10:
                        m4640a(c3991b.m6289g());
                        break;
                    case 18:
                        m4638b(c3991b.m6289g());
                        break;
                    case 26:
                        m4637c(c3991b.m6289g());
                        break;
                    case 34:
                        m4635d(c3991b.m6289g());
                        break;
                    case C3530b.f14177n /* 42 */:
                        m4633e(c3991b.m6289g());
                        break;
                    case 50:
                        m4631f(c3991b.m6289g());
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
        public C4570c m4638b(String str) {
            this.f18797c = true;
            this.f18798d = str;
            return this;
        }

        /* renamed from: c */
        public C4570c m4637c(String str) {
            this.f18799e = true;
            this.f18800f = str;
            return this;
        }

        /* renamed from: d */
        public C4570c m4635d(String str) {
            this.f18801g = true;
            this.f18802h = str;
            return this;
        }

        /* renamed from: d */
        public String m4636d() {
            return this.f18796b;
        }

        /* renamed from: e */
        public C4570c m4633e(String str) {
            this.f18803i = true;
            this.f18804j = str;
            return this;
        }

        /* renamed from: e */
        public boolean m4634e() {
            return this.f18795a;
        }

        /* renamed from: f */
        public C4570c m4631f(String str) {
            this.f18805k = true;
            this.f18806l = str;
            return this;
        }

        /* renamed from: f */
        public String m4632f() {
            return this.f18798d;
        }

        /* renamed from: g */
        public boolean m4630g() {
            return this.f18797c;
        }

        /* renamed from: h */
        public String m4629h() {
            return this.f18800f;
        }

        /* renamed from: i */
        public boolean m4628i() {
            return this.f18799e;
        }

        /* renamed from: j */
        public String m4627j() {
            return this.f18802h;
        }

        /* renamed from: k */
        public boolean m4626k() {
            return this.f18801g;
        }

        /* renamed from: l */
        public String m4625l() {
            return this.f18804j;
        }

        /* renamed from: m */
        public boolean m4624m() {
            return this.f18803i;
        }

        /* renamed from: n */
        public String m4623n() {
            return this.f18806l;
        }

        /* renamed from: o */
        public boolean m4622o() {
            return this.f18805k;
        }
    }

    /* renamed from: com.xiaomi.push.protobuf.b$d */
    /* loaded from: classes.dex */
    public static final class C4571d extends AbstractC3995e {

        /* renamed from: a */
        private boolean f18808a;

        /* renamed from: c */
        private boolean f18810c;

        /* renamed from: e */
        private boolean f18812e;

        /* renamed from: g */
        private boolean f18814g;

        /* renamed from: b */
        private boolean f18809b = false;

        /* renamed from: d */
        private String f18811d = "";

        /* renamed from: f */
        private String f18813f = "";

        /* renamed from: h */
        private String f18815h = "";

        /* renamed from: i */
        private int f18816i = -1;

        /* renamed from: b */
        public static C4571d m4617b(byte[] bArr) {
            return (C4571d) new C4571d().a(bArr);
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: a */
        public int mo4533a() {
            if (this.f18816i < 0) {
                mo4526b();
            }
            return this.f18816i;
        }

        /* renamed from: a */
        public C4571d m4621a(String str) {
            this.f18810c = true;
            this.f18811d = str;
            return this;
        }

        /* renamed from: a */
        public C4571d m4620a(boolean z) {
            this.f18808a = true;
            this.f18809b = z;
            return this;
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: a */
        public void mo4529a(C3992c c3992c) {
            if (m4614e()) {
                c3992c.m6271a(1, m4615d());
            }
            if (m4612g()) {
                c3992c.m6272a(2, m4613f());
            }
            if (m4610i()) {
                c3992c.m6272a(3, m4611h());
            }
            if (m4608k()) {
                c3992c.m6272a(4, m4609j());
            }
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: b */
        public int mo4526b() {
            int i = 0;
            if (m4614e()) {
                i = 0 + C3992c.m6254b(1, m4615d());
            }
            if (m4612g()) {
                i += C3992c.m6255b(2, m4613f());
            }
            if (m4610i()) {
                i += C3992c.m6255b(3, m4611h());
            }
            if (m4608k()) {
                i += C3992c.m6255b(4, m4609j());
            }
            this.f18816i = i;
            return i;
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: b */
        public C4571d mo4530a(C3991b c3991b) {
            while (true) {
                int m6305a = c3991b.m6305a();
                switch (m6305a) {
                    case 0:
                        break;
                    case 8:
                        m4620a(c3991b.m6291f());
                        break;
                    case 18:
                        m4621a(c3991b.m6289g());
                        break;
                    case 26:
                        m4618b(c3991b.m6289g());
                        break;
                    case 34:
                        m4616c(c3991b.m6289g());
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
        public C4571d m4618b(String str) {
            this.f18812e = true;
            this.f18813f = str;
            return this;
        }

        /* renamed from: c */
        public C4571d m4616c(String str) {
            this.f18814g = true;
            this.f18815h = str;
            return this;
        }

        /* renamed from: d */
        public boolean m4615d() {
            return this.f18809b;
        }

        /* renamed from: e */
        public boolean m4614e() {
            return this.f18808a;
        }

        /* renamed from: f */
        public String m4613f() {
            return this.f18811d;
        }

        /* renamed from: g */
        public boolean m4612g() {
            return this.f18810c;
        }

        /* renamed from: h */
        public String m4611h() {
            return this.f18813f;
        }

        /* renamed from: i */
        public boolean m4610i() {
            return this.f18812e;
        }

        /* renamed from: j */
        public String m4609j() {
            return this.f18815h;
        }

        /* renamed from: k */
        public boolean m4608k() {
            return this.f18814g;
        }
    }

    /* renamed from: com.xiaomi.push.protobuf.b$e */
    /* loaded from: classes2.dex */
    public static final class C4572e extends AbstractC3995e {

        /* renamed from: a */
        private boolean f18817a;

        /* renamed from: c */
        private boolean f18819c;

        /* renamed from: e */
        private boolean f18821e;

        /* renamed from: g */
        private boolean f18823g;

        /* renamed from: i */
        private boolean f18825i;

        /* renamed from: k */
        private boolean f18827k;

        /* renamed from: m */
        private boolean f18829m;

        /* renamed from: o */
        private boolean f18831o;

        /* renamed from: q */
        private boolean f18833q;

        /* renamed from: s */
        private boolean f18835s;

        /* renamed from: b */
        private int f18818b = 0;

        /* renamed from: d */
        private String f18820d = "";

        /* renamed from: f */
        private String f18822f = "";

        /* renamed from: h */
        private String f18824h = "";

        /* renamed from: j */
        private int f18826j = 0;

        /* renamed from: l */
        private String f18828l = "";

        /* renamed from: n */
        private String f18830n = "";

        /* renamed from: p */
        private String f18832p = "";

        /* renamed from: r */
        private C4569b f18834r = null;

        /* renamed from: t */
        private int f18836t = 0;

        /* renamed from: u */
        private int f18837u = -1;

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: a */
        public int mo4533a() {
            if (this.f18837u < 0) {
                mo4526b();
            }
            return this.f18837u;
        }

        /* renamed from: a */
        public C4572e m4607a(int i) {
            this.f18817a = true;
            this.f18818b = i;
            return this;
        }

        /* renamed from: a */
        public C4572e m4606a(C4569b c4569b) {
            if (c4569b == null) {
                throw new NullPointerException();
            }
            this.f18833q = true;
            this.f18834r = c4569b;
            return this;
        }

        /* renamed from: a */
        public C4572e m4605a(String str) {
            this.f18819c = true;
            this.f18820d = str;
            return this;
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: a */
        public void mo4529a(C3992c c3992c) {
            if (m4597e()) {
                c3992c.m6259b(1, m4599d());
            }
            if (m4593g()) {
                c3992c.m6272a(2, m4595f());
            }
            if (m4591i()) {
                c3992c.m6272a(3, m4592h());
            }
            if (m4589k()) {
                c3992c.m6272a(4, m4590j());
            }
            if (m4587m()) {
                c3992c.m6276a(5, m4588l());
            }
            if (m4585o()) {
                c3992c.m6272a(6, m4586n());
            }
            if (m4583q()) {
                c3992c.m6272a(7, m4584p());
            }
            if (m4581s()) {
                c3992c.m6272a(8, m4582r());
            }
            if (m4580t()) {
                c3992c.m6273a(9, m4579u());
            }
            if (m4577w()) {
                c3992c.m6276a(10, m4578v());
            }
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: b */
        public int mo4526b() {
            int i = 0;
            if (m4597e()) {
                i = 0 + C3992c.m6240d(1, m4599d());
            }
            if (m4593g()) {
                i += C3992c.m6255b(2, m4595f());
            }
            if (m4591i()) {
                i += C3992c.m6255b(3, m4592h());
            }
            if (m4589k()) {
                i += C3992c.m6255b(4, m4590j());
            }
            if (m4587m()) {
                i += C3992c.m6245c(5, m4588l());
            }
            if (m4585o()) {
                i += C3992c.m6255b(6, m4586n());
            }
            if (m4583q()) {
                i += C3992c.m6255b(7, m4584p());
            }
            if (m4581s()) {
                i += C3992c.m6255b(8, m4582r());
            }
            if (m4580t()) {
                i += C3992c.m6256b(9, m4579u());
            }
            if (m4577w()) {
                i += C3992c.m6245c(10, m4578v());
            }
            this.f18837u = i;
            return i;
        }

        /* renamed from: b */
        public C4572e m4604b(int i) {
            this.f18825i = true;
            this.f18826j = i;
            return this;
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: b */
        public C4572e mo4530a(C3991b c3991b) {
            while (true) {
                int m6305a = c3991b.m6305a();
                switch (m6305a) {
                    case 0:
                        break;
                    case 8:
                        m4607a(c3991b.m6287i());
                        break;
                    case 18:
                        m4605a(c3991b.m6289g());
                        break;
                    case 26:
                        m4602b(c3991b.m6289g());
                        break;
                    case 34:
                        m4600c(c3991b.m6289g());
                        break;
                    case 40:
                        m4604b(c3991b.m6293e());
                        break;
                    case 50:
                        m4598d(c3991b.m6289g());
                        break;
                    case Opcodes.ASTORE /* 58 */:
                        m4596e(c3991b.m6289g());
                        break;
                    case 66:
                        m4594f(c3991b.m6289g());
                        break;
                    case 74:
                        C4569b c4569b = new C4569b();
                        c3991b.m6303a(c4569b);
                        m4606a(c4569b);
                        break;
                    case 80:
                        m4601c(c3991b.m6293e());
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
        public C4572e m4602b(String str) {
            this.f18821e = true;
            this.f18822f = str;
            return this;
        }

        /* renamed from: c */
        public C4572e m4601c(int i) {
            this.f18835s = true;
            this.f18836t = i;
            return this;
        }

        /* renamed from: c */
        public C4572e m4600c(String str) {
            this.f18823g = true;
            this.f18824h = str;
            return this;
        }

        /* renamed from: d */
        public int m4599d() {
            return this.f18818b;
        }

        /* renamed from: d */
        public C4572e m4598d(String str) {
            this.f18827k = true;
            this.f18828l = str;
            return this;
        }

        /* renamed from: e */
        public C4572e m4596e(String str) {
            this.f18829m = true;
            this.f18830n = str;
            return this;
        }

        /* renamed from: e */
        public boolean m4597e() {
            return this.f18817a;
        }

        /* renamed from: f */
        public C4572e m4594f(String str) {
            this.f18831o = true;
            this.f18832p = str;
            return this;
        }

        /* renamed from: f */
        public String m4595f() {
            return this.f18820d;
        }

        /* renamed from: g */
        public boolean m4593g() {
            return this.f18819c;
        }

        /* renamed from: h */
        public String m4592h() {
            return this.f18822f;
        }

        /* renamed from: i */
        public boolean m4591i() {
            return this.f18821e;
        }

        /* renamed from: j */
        public String m4590j() {
            return this.f18824h;
        }

        /* renamed from: k */
        public boolean m4589k() {
            return this.f18823g;
        }

        /* renamed from: l */
        public int m4588l() {
            return this.f18826j;
        }

        /* renamed from: m */
        public boolean m4587m() {
            return this.f18825i;
        }

        /* renamed from: n */
        public String m4586n() {
            return this.f18828l;
        }

        /* renamed from: o */
        public boolean m4585o() {
            return this.f18827k;
        }

        /* renamed from: p */
        public String m4584p() {
            return this.f18830n;
        }

        /* renamed from: q */
        public boolean m4583q() {
            return this.f18829m;
        }

        /* renamed from: r */
        public String m4582r() {
            return this.f18832p;
        }

        /* renamed from: s */
        public boolean m4581s() {
            return this.f18831o;
        }

        /* renamed from: t */
        public boolean m4580t() {
            return this.f18833q;
        }

        /* renamed from: u */
        public C4569b m4579u() {
            return this.f18834r;
        }

        /* renamed from: v */
        public int m4578v() {
            return this.f18836t;
        }

        /* renamed from: w */
        public boolean m4577w() {
            return this.f18835s;
        }
    }

    /* renamed from: com.xiaomi.push.protobuf.b$f */
    /* loaded from: classes2.dex */
    public static final class C4573f extends AbstractC3995e {

        /* renamed from: a */
        private boolean f18838a;

        /* renamed from: c */
        private boolean f18840c;

        /* renamed from: e */
        private boolean f18842e;

        /* renamed from: b */
        private String f18839b = "";

        /* renamed from: d */
        private String f18841d = "";

        /* renamed from: f */
        private C4569b f18843f = null;

        /* renamed from: g */
        private int f18844g = -1;

        /* renamed from: b */
        public static C4573f m4572b(byte[] bArr) {
            return (C4573f) new C4573f().a(bArr);
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: a */
        public int mo4533a() {
            if (this.f18844g < 0) {
                mo4526b();
            }
            return this.f18844g;
        }

        /* renamed from: a */
        public C4573f m4576a(C4569b c4569b) {
            if (c4569b == null) {
                throw new NullPointerException();
            }
            this.f18842e = true;
            this.f18843f = c4569b;
            return this;
        }

        /* renamed from: a */
        public C4573f m4575a(String str) {
            this.f18838a = true;
            this.f18839b = str;
            return this;
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: a */
        public void mo4529a(C3992c c3992c) {
            if (m4570e()) {
                c3992c.m6272a(1, m4571d());
            }
            if (m4568g()) {
                c3992c.m6272a(2, m4569f());
            }
            if (m4567h()) {
                c3992c.m6273a(3, m4566i());
            }
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: b */
        public int mo4526b() {
            int i = 0;
            if (m4570e()) {
                i = 0 + C3992c.m6255b(1, m4571d());
            }
            if (m4568g()) {
                i += C3992c.m6255b(2, m4569f());
            }
            if (m4567h()) {
                i += C3992c.m6256b(3, m4566i());
            }
            this.f18844g = i;
            return i;
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: b */
        public C4573f mo4530a(C3991b c3991b) {
            while (true) {
                int m6305a = c3991b.m6305a();
                switch (m6305a) {
                    case 0:
                        break;
                    case 10:
                        m4575a(c3991b.m6289g());
                        break;
                    case 18:
                        m4573b(c3991b.m6289g());
                        break;
                    case 26:
                        C4569b c4569b = new C4569b();
                        c3991b.m6303a(c4569b);
                        m4576a(c4569b);
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
        public C4573f m4573b(String str) {
            this.f18840c = true;
            this.f18841d = str;
            return this;
        }

        /* renamed from: d */
        public String m4571d() {
            return this.f18839b;
        }

        /* renamed from: e */
        public boolean m4570e() {
            return this.f18838a;
        }

        /* renamed from: f */
        public String m4569f() {
            return this.f18841d;
        }

        /* renamed from: g */
        public boolean m4568g() {
            return this.f18840c;
        }

        /* renamed from: h */
        public boolean m4567h() {
            return this.f18842e;
        }

        /* renamed from: i */
        public C4569b m4566i() {
            return this.f18843f;
        }
    }

    /* renamed from: com.xiaomi.push.protobuf.b$g */
    /* loaded from: classes.dex */
    public static final class C4574g extends AbstractC3995e {

        /* renamed from: a */
        private boolean f18845a;

        /* renamed from: c */
        private boolean f18847c;

        /* renamed from: e */
        private boolean f18849e;

        /* renamed from: b */
        private String f18846b = "";

        /* renamed from: d */
        private String f18848d = "";

        /* renamed from: f */
        private String f18850f = "";

        /* renamed from: g */
        private int f18851g = -1;

        /* renamed from: b */
        public static C4574g m4562b(byte[] bArr) {
            return (C4574g) new C4574g().a(bArr);
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: a */
        public int mo4533a() {
            if (this.f18851g < 0) {
                mo4526b();
            }
            return this.f18851g;
        }

        /* renamed from: a */
        public C4574g m4565a(String str) {
            this.f18845a = true;
            this.f18846b = str;
            return this;
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: a */
        public void mo4529a(C3992c c3992c) {
            if (m4559e()) {
                c3992c.m6272a(1, m4560d());
            }
            if (m4557g()) {
                c3992c.m6272a(2, m4558f());
            }
            if (m4555i()) {
                c3992c.m6272a(3, m4556h());
            }
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: b */
        public int mo4526b() {
            int i = 0;
            if (m4559e()) {
                i = 0 + C3992c.m6255b(1, m4560d());
            }
            if (m4557g()) {
                i += C3992c.m6255b(2, m4558f());
            }
            if (m4555i()) {
                i += C3992c.m6255b(3, m4556h());
            }
            this.f18851g = i;
            return i;
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: b */
        public C4574g mo4530a(C3991b c3991b) {
            while (true) {
                int m6305a = c3991b.m6305a();
                switch (m6305a) {
                    case 0:
                        break;
                    case 10:
                        m4565a(c3991b.m6289g());
                        break;
                    case 18:
                        m4563b(c3991b.m6289g());
                        break;
                    case 26:
                        m4561c(c3991b.m6289g());
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
        public C4574g m4563b(String str) {
            this.f18847c = true;
            this.f18848d = str;
            return this;
        }

        /* renamed from: c */
        public C4574g m4561c(String str) {
            this.f18849e = true;
            this.f18850f = str;
            return this;
        }

        /* renamed from: d */
        public String m4560d() {
            return this.f18846b;
        }

        /* renamed from: e */
        public boolean m4559e() {
            return this.f18845a;
        }

        /* renamed from: f */
        public String m4558f() {
            return this.f18848d;
        }

        /* renamed from: g */
        public boolean m4557g() {
            return this.f18847c;
        }

        /* renamed from: h */
        public String m4556h() {
            return this.f18850f;
        }

        /* renamed from: i */
        public boolean m4555i() {
            return this.f18849e;
        }
    }

    /* renamed from: com.xiaomi.push.protobuf.b$h */
    /* loaded from: classes.dex */
    public static final class C4575h extends AbstractC3995e {

        /* renamed from: a */
        private boolean f18852a;

        /* renamed from: c */
        private boolean f18854c;

        /* renamed from: b */
        private int f18853b = 0;

        /* renamed from: d */
        private String f18855d = "";

        /* renamed from: e */
        private int f18856e = -1;

        /* renamed from: b */
        public static C4575h m4551b(byte[] bArr) {
            return (C4575h) new C4575h().a(bArr);
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: a */
        public int mo4533a() {
            if (this.f18856e < 0) {
                mo4526b();
            }
            return this.f18856e;
        }

        /* renamed from: a */
        public C4575h m4554a(int i) {
            this.f18852a = true;
            this.f18853b = i;
            return this;
        }

        /* renamed from: a */
        public C4575h m4553a(String str) {
            this.f18854c = true;
            this.f18855d = str;
            return this;
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: a */
        public void mo4529a(C3992c c3992c) {
            if (m4549e()) {
                c3992c.m6276a(1, m4550d());
            }
            if (m4547g()) {
                c3992c.m6272a(2, m4548f());
            }
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: b */
        public int mo4526b() {
            int i = 0;
            if (m4549e()) {
                i = 0 + C3992c.m6245c(1, m4550d());
            }
            if (m4547g()) {
                i += C3992c.m6255b(2, m4548f());
            }
            this.f18856e = i;
            return i;
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: b */
        public C4575h mo4530a(C3991b c3991b) {
            while (true) {
                int m6305a = c3991b.m6305a();
                switch (m6305a) {
                    case 0:
                        break;
                    case 8:
                        m4554a(c3991b.m6293e());
                        break;
                    case 18:
                        m4553a(c3991b.m6289g());
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

        /* renamed from: d */
        public int m4550d() {
            return this.f18853b;
        }

        /* renamed from: e */
        public boolean m4549e() {
            return this.f18852a;
        }

        /* renamed from: f */
        public String m4548f() {
            return this.f18855d;
        }

        /* renamed from: g */
        public boolean m4547g() {
            return this.f18854c;
        }
    }

    /* renamed from: com.xiaomi.push.protobuf.b$i */
    /* loaded from: classes.dex */
    public static final class C4576i extends AbstractC3995e {

        /* renamed from: a */
        private boolean f18857a;

        /* renamed from: b */
        private C3990a f18858b = C3990a.f17056a;

        /* renamed from: c */
        private int f18859c = -1;

        /* renamed from: b */
        public static C4576i m4544b(byte[] bArr) {
            return (C4576i) new C4576i().a(bArr);
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: a */
        public int mo4533a() {
            if (this.f18859c < 0) {
                mo4526b();
            }
            return this.f18859c;
        }

        /* renamed from: a */
        public C4576i m4546a(C3990a c3990a) {
            this.f18857a = true;
            this.f18858b = c3990a;
            return this;
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: a */
        public void mo4529a(C3992c c3992c) {
            if (m4542e()) {
                c3992c.m6274a(1, m4543d());
            }
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: b */
        public int mo4526b() {
            int i = 0;
            if (m4542e()) {
                i = 0 + C3992c.m6257b(1, m4543d());
            }
            this.f18859c = i;
            return i;
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: b */
        public C4576i mo4530a(C3991b c3991b) {
            while (true) {
                int m6305a = c3991b.m6305a();
                switch (m6305a) {
                    case 0:
                        break;
                    case 10:
                        m4546a(c3991b.m6288h());
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

        /* renamed from: d */
        public C3990a m4543d() {
            return this.f18858b;
        }

        /* renamed from: e */
        public boolean m4542e() {
            return this.f18857a;
        }
    }

    /* renamed from: com.xiaomi.push.protobuf.b$j */
    /* loaded from: classes.dex */
    public static final class C4577j extends AbstractC3995e {

        /* renamed from: a */
        private boolean f18860a;

        /* renamed from: c */
        private boolean f18862c;

        /* renamed from: b */
        private C3990a f18861b = C3990a.f17056a;

        /* renamed from: d */
        private C4569b f18863d = null;

        /* renamed from: e */
        private int f18864e = -1;

        /* renamed from: b */
        public static C4577j m4538b(byte[] bArr) {
            return (C4577j) new C4577j().a(bArr);
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: a */
        public int mo4533a() {
            if (this.f18864e < 0) {
                mo4526b();
            }
            return this.f18864e;
        }

        /* renamed from: a */
        public C4577j m4541a(C3990a c3990a) {
            this.f18860a = true;
            this.f18861b = c3990a;
            return this;
        }

        /* renamed from: a */
        public C4577j m4540a(C4569b c4569b) {
            if (c4569b == null) {
                throw new NullPointerException();
            }
            this.f18862c = true;
            this.f18863d = c4569b;
            return this;
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: a */
        public void mo4529a(C3992c c3992c) {
            if (m4536e()) {
                c3992c.m6274a(1, m4537d());
            }
            if (m4535f()) {
                c3992c.m6273a(2, m4534g());
            }
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: b */
        public int mo4526b() {
            int i = 0;
            if (m4536e()) {
                i = 0 + C3992c.m6257b(1, m4537d());
            }
            if (m4535f()) {
                i += C3992c.m6256b(2, m4534g());
            }
            this.f18864e = i;
            return i;
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: b */
        public C4577j mo4530a(C3991b c3991b) {
            while (true) {
                int m6305a = c3991b.m6305a();
                switch (m6305a) {
                    case 0:
                        break;
                    case 10:
                        m4541a(c3991b.m6288h());
                        break;
                    case 18:
                        C4569b c4569b = new C4569b();
                        c3991b.m6303a(c4569b);
                        m4540a(c4569b);
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

        /* renamed from: d */
        public C3990a m4537d() {
            return this.f18861b;
        }

        /* renamed from: e */
        public boolean m4536e() {
            return this.f18860a;
        }

        /* renamed from: f */
        public boolean m4535f() {
            return this.f18862c;
        }

        /* renamed from: g */
        public C4569b m4534g() {
            return this.f18863d;
        }
    }

    /* renamed from: com.xiaomi.push.protobuf.b$k */
    /* loaded from: classes.dex */
    public static final class C4578k extends AbstractC3995e {

        /* renamed from: a */
        private boolean f18865a;

        /* renamed from: c */
        private boolean f18867c;

        /* renamed from: e */
        private boolean f18869e;

        /* renamed from: g */
        private boolean f18871g;

        /* renamed from: i */
        private boolean f18873i;

        /* renamed from: k */
        private boolean f18875k;

        /* renamed from: b */
        private String f18866b = "";

        /* renamed from: d */
        private String f18868d = "";

        /* renamed from: f */
        private long f18870f = 0;

        /* renamed from: h */
        private long f18872h = 0;

        /* renamed from: j */
        private boolean f18874j = false;

        /* renamed from: l */
        private int f18876l = 0;

        /* renamed from: m */
        private int f18877m = -1;

        /* renamed from: b */
        public static C4578k m4522b(byte[] bArr) {
            return (C4578k) new C4578k().a(bArr);
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: a */
        public int mo4533a() {
            if (this.f18877m < 0) {
                mo4526b();
            }
            return this.f18877m;
        }

        /* renamed from: a */
        public C4578k m4532a(int i) {
            this.f18875k = true;
            this.f18876l = i;
            return this;
        }

        /* renamed from: a */
        public C4578k m4531a(long j) {
            this.f18869e = true;
            this.f18870f = j;
            return this;
        }

        /* renamed from: a */
        public C4578k m4528a(String str) {
            this.f18865a = true;
            this.f18866b = str;
            return this;
        }

        /* renamed from: a */
        public C4578k m4527a(boolean z) {
            this.f18873i = true;
            this.f18874j = z;
            return this;
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: a */
        public void mo4529a(C3992c c3992c) {
            if (m4520e()) {
                c3992c.m6272a(1, m4521d());
            }
            if (m4518g()) {
                c3992c.m6272a(2, m4519f());
            }
            if (m4516i()) {
                c3992c.m6275a(3, m4517h());
            }
            if (m4514k()) {
                c3992c.m6275a(4, m4515j());
            }
            if (m4512m()) {
                c3992c.m6271a(5, m4513l());
            }
            if (m4510o()) {
                c3992c.m6276a(6, m4511n());
            }
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: b */
        public int mo4526b() {
            int i = 0;
            if (m4520e()) {
                i = 0 + C3992c.m6255b(1, m4521d());
            }
            if (m4518g()) {
                i += C3992c.m6255b(2, m4519f());
            }
            if (m4516i()) {
                i += C3992c.m6244c(3, m4517h());
            }
            if (m4514k()) {
                i += C3992c.m6244c(4, m4515j());
            }
            if (m4512m()) {
                i += C3992c.m6254b(5, m4513l());
            }
            if (m4510o()) {
                i += C3992c.m6245c(6, m4511n());
            }
            this.f18877m = i;
            return i;
        }

        /* renamed from: b */
        public C4578k m4525b(long j) {
            this.f18871g = true;
            this.f18872h = j;
            return this;
        }

        @Override // com.google.p217a.p218a.AbstractC3995e
        /* renamed from: b */
        public C4578k mo4530a(C3991b c3991b) {
            while (true) {
                int m6305a = c3991b.m6305a();
                switch (m6305a) {
                    case 0:
                        break;
                    case 10:
                        m4528a(c3991b.m6289g());
                        break;
                    case 18:
                        m4523b(c3991b.m6289g());
                        break;
                    case 24:
                        m4531a(c3991b.m6297c());
                        break;
                    case 32:
                        m4525b(c3991b.m6297c());
                        break;
                    case 40:
                        m4527a(c3991b.m6291f());
                        break;
                    case 48:
                        m4532a(c3991b.m6293e());
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
        public C4578k m4523b(String str) {
            this.f18867c = true;
            this.f18868d = str;
            return this;
        }

        /* renamed from: d */
        public String m4521d() {
            return this.f18866b;
        }

        /* renamed from: e */
        public boolean m4520e() {
            return this.f18865a;
        }

        /* renamed from: f */
        public String m4519f() {
            return this.f18868d;
        }

        /* renamed from: g */
        public boolean m4518g() {
            return this.f18867c;
        }

        /* renamed from: h */
        public long m4517h() {
            return this.f18870f;
        }

        /* renamed from: i */
        public boolean m4516i() {
            return this.f18869e;
        }

        /* renamed from: j */
        public long m4515j() {
            return this.f18872h;
        }

        /* renamed from: k */
        public boolean m4514k() {
            return this.f18871g;
        }

        /* renamed from: l */
        public boolean m4513l() {
            return this.f18874j;
        }

        /* renamed from: m */
        public boolean m4512m() {
            return this.f18873i;
        }

        /* renamed from: n */
        public int m4511n() {
            return this.f18876l;
        }

        /* renamed from: o */
        public boolean m4510o() {
            return this.f18875k;
        }
    }
}
