package com.p078a.p079a;

import com.fimi.soul.media.player.FimiMediaMeta;
import com.p078a.p079a.C0738o;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.CRC32;
/* renamed from: com.a.a.ac */
/* loaded from: classes.dex */
public abstract class AbstractC0722ac {

    /* renamed from: a */
    private static final byte[] f1772a = C0756z.m19129a(8448);

    /* renamed from: a */
    public static long m19276a(int i) {
        return i < 0 ? FimiMediaMeta.AV_CH_WIDE_RIGHT + i : i;
    }

    /* renamed from: a */
    public static C0756z m19270a(Date date) {
        return new C0756z(m19275a(date.getTime()));
    }

    /* renamed from: a */
    private static String m19274a(AbstractC0717a abstractC0717a, byte[] bArr) {
        if (abstractC0717a != null) {
            CRC32 crc32 = new CRC32();
            crc32.update(bArr);
            if (crc32.getValue() != abstractC0717a.m19336i_()) {
                return null;
            }
            try {
                return AbstractC0746v.f1878b.mo19201a(abstractC0717a.m19338b());
            } catch (IOException e) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static Date m19271a(C0756z c0756z) {
        return new Date(m19268b(c0756z.m19126b()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m19272a(C0748w c0748w, byte[] bArr, byte[] bArr2) {
        String m19274a;
        String name = c0748w.getName();
        String m19274a2 = m19274a((C0734k) c0748w.m19179b(C0734k.f1809a), bArr);
        if (m19274a2 != null && !name.equals(m19274a2)) {
            c0748w.m19188a(m19274a2);
        }
        if (bArr2 == null || bArr2.length <= 0 || (m19274a = m19274a((C0733j) c0748w.m19179b(C0733j.f1808a), bArr2)) == null) {
            return;
        }
        c0748w.setComment(m19274a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m19273a(C0748w c0748w) {
        return m19266c(c0748w) && m19265d(c0748w);
    }

    /* renamed from: a */
    public static byte[] m19275a(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        int i = calendar.get(1);
        if (i < 1980) {
            return m19269a(f1772a);
        }
        return C0756z.m19129a((calendar.get(13) >> 1) | ((i - 1980) << 25) | ((calendar.get(2) + 1) << 21) | (calendar.get(5) << 16) | (calendar.get(11) << 11) | (calendar.get(12) << 5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static byte[] m19269a(byte[] bArr) {
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
            return bArr2;
        }
        return null;
    }

    /* renamed from: b */
    public static long m19268b(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, ((int) ((j >> 25) & 127)) + 1980);
        calendar.set(2, ((int) ((j >> 21) & 15)) - 1);
        calendar.set(5, ((int) (j >> 16)) & 31);
        calendar.set(11, ((int) (j >> 11)) & 31);
        calendar.set(12, ((int) (j >> 5)) & 63);
        calendar.set(13, ((int) (j << 1)) & 62);
        return calendar.getTime().getTime();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static void m19267b(C0748w c0748w) {
        if (!m19266c(c0748w)) {
            throw new C0738o(C0738o.C0739a.f1825a, c0748w);
        }
        if (m19265d(c0748w)) {
            return;
        }
        throw new C0738o(C0738o.C0739a.f1826b, c0748w);
    }

    /* renamed from: c */
    private static boolean m19266c(C0748w c0748w) {
        return !c0748w.m19167l().m19239c();
    }

    /* renamed from: d */
    private static boolean m19265d(C0748w c0748w) {
        return c0748w.getMethod() == 0 || c0748w.getMethod() == 8;
    }
}
