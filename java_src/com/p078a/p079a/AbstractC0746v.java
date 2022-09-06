package com.p078a.p079a;

import com.fimi.soul.module.droneui.DroneMap;
import com.fimi.soul.module.setting.newhand.C3531c;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.a.a.v */
/* loaded from: classes.dex */
public abstract class AbstractC0746v {

    /* renamed from: c */
    private static final Map<String, C0747a> f1879c;

    /* renamed from: e */
    private static final String f1881e = "utf-8";

    /* renamed from: d */
    private static final byte[] f1880d = {48, 49, 50, 51, SmileConstants.TOKEN_KEY_LONG_STRING, 53, 54, 55, 56, 57, 65, 66, DroneMap.f12612o, 68, 69, 70};

    /* renamed from: a */
    static final String f1877a = "UTF8";

    /* renamed from: b */
    static final AbstractC0745u f1878b = new C0727e(f1877a);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.a.a.v$a */
    /* loaded from: classes.dex */
    public static class C0747a {

        /* renamed from: a */
        private final char[] f1882a;

        /* renamed from: b */
        private C0731i f1883b;

        C0747a(char[] cArr) {
            this.f1882a = cArr;
        }

        /* renamed from: a */
        public synchronized C0731i m19195a() {
            if (this.f1883b == null) {
                this.f1883b = new C0731i(this.f1882a);
            }
            return this.f1883b;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        C0747a c0747a = new C0747a(new char[]{199, 252, 233, 226, 228, 224, 229, 231, 234, 235, 232, 239, 238, 236, 196, 197, 201, 230, 198, 244, 246, 242, 251, 249, 255, 214, 220, 162, 163, 165, 8359, 402, 225, 237, 243, 250, 241, 209, 170, 186, 191, 8976, 172, 189, 188, 161, 171, 187, 9617, 9618, 9619, 9474, 9508, 9569, 9570, 9558, 9557, 9571, 9553, 9559, 9565, 9564, 9563, 9488, 9492, 9524, 9516, 9500, 9472, 9532, 9566, 9567, 9562, 9556, 9577, 9574, 9568, 9552, 9580, 9575, 9576, 9572, 9573, 9561, 9560, 9554, 9555, 9579, 9578, 9496, 9484, 9608, 9604, 9612, 9616, 9600, 945, 223, 915, 960, 931, 963, 181, 964, 934, 920, 937, 948, 8734, 966, 949, 8745, 8801, 177, 8805, 8804, 8992, 8993, 247, 8776, 176, 8729, 183, 8730, 8319, 178, 9632, 160});
        hashMap.put("CP437", c0747a);
        hashMap.put("Cp437", c0747a);
        hashMap.put("cp437", c0747a);
        hashMap.put("IBM437", c0747a);
        hashMap.put("ibm437", c0747a);
        C0747a c0747a2 = new C0747a(new char[]{199, 252, 233, 226, 228, 224, 229, 231, 234, 235, 232, 239, 238, 236, 196, 197, 201, 230, 198, 244, 246, 242, 251, 249, 255, 214, 220, 248, 163, 216, 215, 402, 225, 237, 243, 250, 241, 209, 170, 186, 191, 174, 172, 189, 188, 161, 171, 187, 9617, 9618, 9619, 9474, 9508, 193, 194, 192, 169, 9571, 9553, 9559, 9565, 162, 165, 9488, 9492, 9524, 9516, 9500, 9472, 9532, 227, 195, 9562, 9556, 9577, 9574, 9568, 9552, 9580, 164, 240, 208, 202, 203, 200, 305, 205, 206, 207, 9496, 9484, 9608, 9604, 166, 204, 9600, 211, 223, 212, 210, 245, 213, 181, 254, 222, 218, 219, 217, 253, 221, 175, 180, 173, 177, 8215, 190, 182, 167, 247, 184, 176, 168, 183, 185, 179, 178, 9632, 160});
        hashMap.put("CP850", c0747a2);
        hashMap.put("Cp850", c0747a2);
        hashMap.put("cp850", c0747a2);
        hashMap.put("IBM850", c0747a2);
        hashMap.put("ibm850", c0747a2);
        f1879c = Collections.unmodifiableMap(hashMap);
    }

    /* renamed from: a */
    public static AbstractC0745u m19199a(String str) {
        if (m19196b(str)) {
            return f1878b;
        }
        if (str == null) {
            return new C0727e();
        }
        C0747a c0747a = f1879c.get(str);
        if (c0747a != null) {
            return c0747a.m19195a();
        }
        try {
            return new C0730h(Charset.forName(str));
        } catch (UnsupportedCharsetException e) {
            return new C0727e(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static ByteBuffer m19197a(ByteBuffer byteBuffer, int i) {
        byteBuffer.limit(byteBuffer.position());
        byteBuffer.rewind();
        int capacity = byteBuffer.capacity() * 2;
        if (capacity >= i) {
            i = capacity;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        allocate.put(byteBuffer);
        return allocate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m19198a(ByteBuffer byteBuffer, char c) {
        byteBuffer.put((byte) 37);
        byteBuffer.put(C3531c.f14197f);
        byteBuffer.put(f1880d[(c >> '\f') & 15]);
        byteBuffer.put(f1880d[(c >> '\b') & 15]);
        byteBuffer.put(f1880d[(c >> 4) & 15]);
        byteBuffer.put(f1880d[c & 15]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static boolean m19196b(String str) {
        if (str == null) {
            str = System.getProperty("file.encoding");
        }
        return f1877a.equalsIgnoreCase(str) || f1881e.equalsIgnoreCase(str);
    }
}
