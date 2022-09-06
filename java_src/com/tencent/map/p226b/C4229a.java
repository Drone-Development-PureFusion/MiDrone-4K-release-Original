package com.tencent.map.p226b;
/* renamed from: com.tencent.map.b.a */
/* loaded from: classes.dex */
public final class C4229a {

    /* renamed from: a */
    private static C4229a f17557a = null;

    /* renamed from: com.tencent.map.b.a$1 */
    /* loaded from: classes.dex */
    static /* synthetic */ class C42301 {
        private C42301() {
        }

        /* synthetic */ C42301(C4229a c4229a, byte b) {
            this();
        }

        /* renamed from: a */
        public boolean m5812a(String str, String str2) {
            int m5814a = C4229a.m5814a(C4229a.this, str);
            if (str2.charAt(4) != C4258i.f17701a.charAt(((((m5814a * 9) + 10) / 3) + 36) & 31)) {
                return false;
            }
            if (str2.charAt(7) != C4258i.f17701a.charAt((((m5814a * 5) + 11) / 5) & 31)) {
                return false;
            }
            if (str2.charAt(12) != C4258i.f17701a.charAt((((m5814a + 10) / 3) << 3) & 31)) {
                return false;
            }
            if (str2.charAt(14) != C4258i.f17701a.charAt((((m5814a * 3) + 19) / 9) & 31)) {
                return false;
            }
            if (str2.charAt(19) != C4258i.f17701a.charAt((((m5814a * 3) + 39) / 8) & 31)) {
                return false;
            }
            if (str2.charAt(21) != C4258i.f17701a.charAt((((m5814a / 23) + 67) / 7) & 31)) {
                return false;
            }
            if (str2.charAt(26) != C4258i.f17701a.charAt(((((m5814a + 23) / 6) + 3) * 7) & 31)) {
                return false;
            }
            int i = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                i = C4258i.f17702b[(i ^ C4258i.m5699a(str.charAt(i2))) & 255] ^ ((i >> 8) & 255);
            }
            if (str2.charAt(0) != C4258i.f17701a.charAt(i & 31)) {
                return false;
            }
            return str2.charAt(1) == C4258i.f17701a.charAt((i >> 5) & 31);
        }
    }

    private C4229a() {
    }

    /* renamed from: a */
    static /* synthetic */ int m5814a(C4229a c4229a, String str) {
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i += C4258i.m5699a(str.charAt(i2));
        }
        return ((length << 7) + length) ^ i;
    }

    /* renamed from: a */
    public static synchronized C4229a m5815a() {
        C4229a c4229a;
        synchronized (C4229a.class) {
            if (f17557a == null) {
                f17557a = new C4229a();
            }
            c4229a = f17557a;
        }
        return c4229a;
    }

    /* renamed from: a */
    public final boolean m5813a(String str, String str2) {
        if (C4258i.m5692a(str) && C4258i.m5690b(str2) && new C42301(this, (byte) 0).m5812a(str, str2)) {
            int i = 0;
            for (int i2 = 0; i2 < 27; i2++) {
                i = C4258i.f17702b[(i ^ C4258i.m5699a(str2.charAt(i2))) & 255] ^ ((i >> 8) & 255);
            }
            return str2.charAt(27) != C4258i.f17701a.charAt(i & 31) ? false : str2.charAt(28) == C4258i.f17701a.charAt((i >> 5) & 31);
        }
        return false;
    }
}
