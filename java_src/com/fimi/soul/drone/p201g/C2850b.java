package com.fimi.soul.drone.p201g;

import com.fimi.soul.drone.p193d.p194a.p195a.C2737bz;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Queue;
/* renamed from: com.fimi.soul.drone.g.b */
/* loaded from: classes.dex */
public class C2850b {

    /* renamed from: a */
    public static final int f10493a = 176;

    /* renamed from: b */
    public static Queue<C2737bz> f10494b = new LinkedList();

    /* renamed from: a */
    public static Queue<C2737bz> m10776a() {
        return f10494b;
    }

    /* renamed from: a */
    public static void m10774a(Queue<C2737bz> queue) {
        queue.removeAll(queue);
    }

    /* renamed from: a */
    public static byte[] m10775a(int i, InputStream inputStream, long j) {
        int i2 = 1;
        if (f10494b.size() > 1) {
            m10774a(f10494b);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[176];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                inputStream.close();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
            C2737bz c2737bz = new C2737bz();
            c2737bz.f10026e = (byte) i;
            c2737bz.f10025d = (short) i2;
            if (bArr.length == 176) {
                c2737bz.m11177a(bArr.length);
                c2737bz.m11176b(bArr.length + 3);
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    c2737bz.f10027f[i3] = bArr[i3];
                }
                f10494b.offer(c2737bz);
            } else {
                c2737bz.m11177a(bArr.length);
                c2737bz.m11176b(bArr.length + 3);
                for (int i4 = 0; i4 < bArr.length; i4++) {
                    c2737bz.f10027f[i4] = bArr[i4];
                }
                f10494b.offer(c2737bz);
            }
            bArr = new byte[176];
            i2++;
        }
    }
}
