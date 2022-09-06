package com.fimi.soul.module.update.p210a;

import android.text.TextUtils;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.utils.C2277v;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.drone.p193d.p194a.p195a.C2737bz;
import com.fimi.soul.drone.p201g.C2849a;
import com.fimi.soul.drone.p201g.C2850b;
import com.fimi.soul.drone.p201g.C2851c;
import com.fimi.soul.drone.p202h.C2853b;
import com.fimi.soul.module.update.C3587b;
import com.fimi.soul.utils.C3681j;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.Queue;
/* renamed from: com.fimi.soul.module.update.a.f */
/* loaded from: classes.dex */
public class C3584f implements AbstractC3581c {

    /* renamed from: a */
    private int f14525a;

    /* renamed from: b */
    private Queue<C2737bz> f14526b;

    @Override // com.fimi.soul.module.update.p210a.AbstractC3581c
    /* renamed from: a */
    public int mo7900a() {
        return this.f14525a;
    }

    @Override // com.fimi.soul.module.update.p210a.AbstractC3581c
    /* renamed from: a */
    public long mo7899a(int i) {
        return new File(mo7894b(i)).length();
    }

    @Override // com.fimi.soul.module.update.p210a.AbstractC3581c
    /* renamed from: a */
    public void mo7898a(int i, int i2) {
        C3580b c3580b = (C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class);
        if (c3580b == null) {
            c3580b = new C3580b();
        }
        c3580b.m7943i().put(Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 0:
                c3580b.m7958a(i2);
                break;
            case 1:
                c3580b.m7956b(i2);
                break;
            case 3:
                c3580b.m7954c(i2);
                break;
            case 4:
                c3580b.m7952d(i2);
                c3580b.m7936l(i2);
                break;
            case 5:
                c3580b.m7940j(i2);
                break;
            case 6:
                c3580b.m7944h(i2);
                break;
            case 8:
                c3580b.m7932n(i2);
                break;
            case 9:
                c3580b.m7948f(i2);
                break;
            case 10:
                c3580b.m7946g(i2);
                break;
            case 11:
                c3580b.m7950e(i2);
                break;
            case 13:
                c3580b.m7938k(i2);
                c3580b.m7936l(i2);
                break;
            case 14:
                c3580b.m7942i(i2);
                break;
            case 15:
                c3580b.m7950e(i2);
                break;
            case 25:
                c3580b.m7942i(i2);
                break;
            case 26:
                c3580b.m7950e(i2);
                break;
            case 253:
                c3580b.m7934m(i2);
                break;
        }
        C2238c.m13125c().mo13117a(C3587b.f14534C, c3580b);
    }

    /* renamed from: a */
    public void m7897a(int i, byte[] bArr, byte[] bArr2) {
        for (int i2 = 0; i2 < 4; i2++) {
            bArr2[i + i2] = bArr[i2];
        }
    }

    @Override // com.fimi.soul.module.update.p210a.AbstractC3581c
    /* renamed from: a */
    public void mo7896a(C3583e c3583e) {
        if (c3583e == null) {
            return;
        }
        File file = new File(mo7893c(c3583e.m7912d()));
        if (!file.exists()) {
            file.mkdir();
        }
        int m7912d = c3583e.m7912d();
        c3583e.m7926a();
        long m7909e = c3583e.m7909e();
        long m7908f = c3583e.m7908f();
        long m7907g = c3583e.m7907g();
        long m7906h = c3583e.m7906h();
        FileInputStream fileInputStream = null;
        try {
            File file2 = new File(mo7893c(c3583e.m7912d()));
            if (file2.exists()) {
                fileInputStream = new FileInputStream(file2);
            }
            File file3 = new File(mo7894b(m7912d));
            if (!file3.exists()) {
                file3.createNewFile();
            }
            byte[] m10768a = C2853b.m10768a(m7909e);
            byte[] m10768a2 = C2853b.m10768a(m7908f);
            byte[] m10768a3 = C2853b.m10768a(m7907g);
            byte[] m10768a4 = C2853b.m10768a(m7906h);
            byte[] m10773a = C2851c.m10773a(fileInputStream);
            FileOutputStream fileOutputStream = new FileOutputStream(file3);
            m7897a(16, m10768a, m10773a);
            m7897a(20, m10768a2, m10773a);
            m7897a(24, m10768a3, m10773a);
            m7897a(28, m10768a4, m10773a);
            m7897a(48, C2853b.m10769a((int) C2853b.m10766a(C2849a.m10779a(m10773a), 12)), m10773a);
            int[] m10779a = C2849a.m10779a(m10773a);
            m7897a(m10773a.length - 4, C2853b.m10769a((int) C2853b.m10766a(m10779a, m10779a.length - 1)), m10773a);
            fileOutputStream.write(m10773a);
            fileOutputStream.flush();
            fileInputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.fimi.soul.module.update.p210a.AbstractC3581c
    /* renamed from: b */
    public String mo7894b(int i) {
        return String.format("%s", mo7893c(i) + ".crc");
    }

    @Override // com.fimi.soul.module.update.p210a.AbstractC3581c
    /* renamed from: b */
    public Queue<C2737bz> mo7895b() {
        return this.f14526b;
    }

    @Override // com.fimi.soul.module.update.p210a.AbstractC3581c
    /* renamed from: c */
    public String mo7893c(int i) {
        boolean z = false;
        boolean z2 = C2277v.m12784a(DroidPlannerApp.m12520g()).m12746o() == 1;
        if (C2367d.m12459a().m12440i() || z2) {
            z = true;
        }
        boolean m12439j = C2367d.m12459a().m12439j();
        String str = null;
        if (i == 0 && m12439j) {
            str = C3587b.f14535D;
        } else if (i == 3 && m12439j) {
            str = C3587b.f14538G;
        } else if (i == 1 && m12439j) {
            str = C3587b.f14536E;
        } else if (i == 2 && m12439j) {
            str = C3587b.f14537F;
        } else if (i == 10 && m12439j) {
            str = C3587b.f14539H;
        } else if (i == 9 && m12439j) {
            str = C3587b.f14541J;
        } else if (i == 6 && m12439j) {
            str = C3587b.f14540I;
        } else if (i == 11 && m12439j) {
            str = C3587b.f14543L;
        } else if (i == 4 && m12439j) {
            str = "firmware.zip";
        } else if (i == 0 && z) {
            str = C3587b.f14554W;
        } else if (i == 1 && z) {
            str = C3587b.f14555X;
        } else if (i == 3 && z) {
            str = C3587b.f14556Y;
        } else if (i == 13 && z) {
            str = C3587b.f14557Z;
        } else if (i == 10 && z) {
            str = C3587b.f14548Q;
        } else if (i == 9 && z) {
            str = C3587b.f14549R;
        } else if (i == 6 && z) {
            str = C3587b.f14550S;
        } else if (i == 253 && m12439j) {
            str = C3587b.f14552U;
        } else if (i == 5 && m12439j) {
            str = C3587b.f14551T;
        } else if (i == 5 && z) {
            str = C3587b.f14559aa;
        } else if (i == 8) {
            str = C3587b.f14533B;
        }
        return TextUtils.isEmpty(str) ? "" : C3681j.m7457v() + str;
    }

    @Override // com.fimi.soul.module.update.p210a.AbstractC3581c
    /* renamed from: d */
    public Queue<C2737bz> mo7892d(int i) {
        File file = new File(mo7894b(i));
        this.f14526b = new LinkedList();
        if (file.exists()) {
            try {
                C2850b.m10775a(i, new FileInputStream(file), file.length());
                this.f14526b = C2850b.m10776a();
                this.f14525a = this.f14526b.size();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.f14526b;
    }

    @Override // com.fimi.soul.module.update.p210a.AbstractC3581c
    /* renamed from: e */
    public void mo7891e(int i) {
    }
}
