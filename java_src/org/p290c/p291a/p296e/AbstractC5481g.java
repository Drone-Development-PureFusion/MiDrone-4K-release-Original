package org.p290c.p291a.p296e;
/* renamed from: org.c.a.e.g */
/* loaded from: classes.dex */
public abstract class AbstractC5481g {

    /* renamed from: org.c.a.e.g$a */
    /* loaded from: classes2.dex */
    public static class C5483a extends Exception {
        private static final long serialVersionUID = 1;

        public C5483a() {
        }

        public C5483a(Throwable th) {
            super(th);
        }
    }

    /* renamed from: a */
    public static AbstractC5481g m943a(final String str, final Object obj) {
        return new AbstractC5481g() { // from class: org.c.a.e.g.1
            @Override // org.p290c.p291a.p296e.AbstractC5481g
            /* renamed from: a */
            public Object mo942a() {
                return obj;
            }

            @Override // org.p290c.p291a.p296e.AbstractC5481g
            /* renamed from: b */
            public String mo941b() {
                String format;
                if (obj == null) {
                    format = "null";
                } else {
                    try {
                        format = String.format("\"%s\"", obj);
                    } catch (Throwable th) {
                        format = String.format("[toString() threw %s: %s]", th.getClass().getSimpleName(), th.getMessage());
                    }
                }
                return String.format("%s <from %s>", format, str);
            }

            public String toString() {
                return String.format("[%s]", obj);
            }
        };
    }

    /* renamed from: a */
    public abstract Object mo942a();

    /* renamed from: b */
    public abstract String mo941b();
}
