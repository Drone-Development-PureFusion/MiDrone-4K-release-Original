package com.fimi.soul.drone.p202h;

import android.content.Context;
import com.fimi.soul.drone.p193d.p194a.p195a.C2737bz;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Queue;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
/* renamed from: com.fimi.soul.drone.h.d */
/* loaded from: classes.dex */
public class C2856d {

    /* renamed from: a */
    public static Queue<C2737bz> f10642a = new LinkedList();

    /* renamed from: a */
    public static Queue<C2737bz> m10762a() {
        return f10642a;
    }

    /* renamed from: a */
    public static void m10760a(Queue<C2737bz> queue) {
        queue.removeAll(queue);
    }

    /* renamed from: a */
    public static byte[] m10761a(InputStream inputStream, long j, Context context) {
        if (f10642a.size() > 1) {
            m10760a(f10642a);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[Opcodes.GETFIELD];
        int i = 1;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                inputStream.close();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
            C2737bz c2737bz = new C2737bz();
            c2737bz.f10025d = (short) i;
            if (bArr.length == 180) {
                c2737bz.m11177a(bArr.length);
                c2737bz.m11176b(bArr.length + 2);
                for (int i2 = 0; i2 < bArr.length; i2++) {
                    c2737bz.f10027f[i2] = bArr[i2];
                }
                f10642a.offer(c2737bz);
            } else {
                c2737bz.m11177a(bArr.length);
                c2737bz.m11176b(bArr.length + 2);
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    c2737bz.f10027f[i3] = bArr[i3];
                }
                f10642a.offer(c2737bz);
            }
            bArr = ((long) i) == j / 180 ? new byte[(int) (j % 180)] : new byte[Opcodes.GETFIELD];
            i++;
        }
    }
}
