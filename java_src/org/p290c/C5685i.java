package org.p290c;
/* renamed from: org.c.i */
/* loaded from: classes2.dex */
public class C5685i extends AssertionError {

    /* renamed from: a */
    private static final int f22792a = 20;
    private static final long serialVersionUID = 1;

    /* renamed from: b */
    private String f22793b;

    /* renamed from: c */
    private String f22794c;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: org.c.i$a */
    /* loaded from: classes2.dex */
    public static class C5687a {

        /* renamed from: a */
        private static final String f22795a = "...";

        /* renamed from: b */
        private static final String f22796b = "]";

        /* renamed from: c */
        private static final String f22797c = "[";

        /* renamed from: d */
        private final int f22798d;

        /* renamed from: e */
        private final String f22799e;

        /* renamed from: f */
        private final String f22800f;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: org.c.i$a$a */
        /* loaded from: classes2.dex */
        public class C5688a {

            /* renamed from: b */
            private final String f22802b;

            /* renamed from: c */
            private final String f22803c;

            private C5688a() {
                this.f22802b = C5687a.this.m294a();
                this.f22803c = C5687a.this.m290b(this.f22802b);
            }

            /* renamed from: a */
            private String m285a(String str) {
                return C5687a.f22797c + str.substring(this.f22802b.length(), str.length() - this.f22803c.length()) + C5687a.f22796b;
            }

            /* renamed from: a */
            public String m286a() {
                return m285a(C5687a.this.f22799e);
            }

            /* renamed from: b */
            public String m284b() {
                return m285a(C5687a.this.f22800f);
            }

            /* renamed from: c */
            public String m283c() {
                return this.f22802b.length() <= C5687a.this.f22798d ? this.f22802b : C5687a.f22795a + this.f22802b.substring(this.f22802b.length() - C5687a.this.f22798d);
            }

            /* renamed from: d */
            public String m282d() {
                return this.f22803c.length() <= C5687a.this.f22798d ? this.f22803c : this.f22803c.substring(0, C5687a.this.f22798d) + C5687a.f22795a;
            }
        }

        public C5687a(int i, String str, String str2) {
            this.f22798d = i;
            this.f22799e = str;
            this.f22800f = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public String m294a() {
            int min = Math.min(this.f22799e.length(), this.f22800f.length());
            for (int i = 0; i < min; i++) {
                if (this.f22799e.charAt(i) != this.f22800f.charAt(i)) {
                    return this.f22799e.substring(0, i);
                }
            }
            return this.f22799e.substring(0, min);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public String m290b(String str) {
            int i = 0;
            int min = Math.min(this.f22799e.length() - str.length(), this.f22800f.length() - str.length()) - 1;
            while (i <= min && this.f22799e.charAt((this.f22799e.length() - 1) - i) == this.f22800f.charAt((this.f22800f.length() - 1) - i)) {
                i++;
            }
            return this.f22799e.substring(this.f22799e.length() - i);
        }

        /* renamed from: a */
        public String m293a(String str) {
            if (this.f22799e == null || this.f22800f == null || this.f22799e.equals(this.f22800f)) {
                return C5562c.m705e(str, this.f22799e, this.f22800f);
            }
            C5688a c5688a = new C5688a();
            String m283c = c5688a.m283c();
            String m282d = c5688a.m282d();
            return C5562c.m705e(str, m283c + c5688a.m286a() + m282d, m283c + c5688a.m284b() + m282d);
        }
    }

    public C5685i(String str, String str2, String str3) {
        super(str);
        this.f22793b = str2;
        this.f22794c = str3;
    }

    /* renamed from: a */
    public String m296a() {
        return this.f22794c;
    }

    /* renamed from: b */
    public String m295b() {
        return this.f22793b;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return new C5687a(20, this.f22793b, this.f22794c).m293a(super.getMessage());
    }
}
