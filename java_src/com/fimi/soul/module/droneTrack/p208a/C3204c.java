package com.fimi.soul.module.droneTrack.p208a;

import com.fimi.soul.biz.p175d.C2434c;
import com.fimi.soul.module.droneTrack.AbstractC3217f;
import com.fimi.soul.module.droneTrack.C3214c;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.fimi.soul.module.droneTrack.a.c */
/* loaded from: classes.dex */
public class C3204c {

    /* renamed from: b */
    private static final String f12317b = C2434c.m12195a().m12194b();

    /* renamed from: a */
    List<List<String>> f12318a;

    /* renamed from: c */
    private C3207d f12319c;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.fimi.soul.module.droneTrack.a.c$a */
    /* loaded from: classes.dex */
    public static class C3206a {

        /* renamed from: a */
        private static C3204c f12323a = new C3204c();

        private C3206a() {
        }
    }

    /* renamed from: a */
    public static C3204c m9133a() {
        return C3206a.f12323a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9128a(String[] strArr, int i) {
        if (this.f12318a == null) {
            this.f12318a = new ArrayList();
        } else {
            this.f12318a.clear();
        }
        int length = strArr.length % i == 0 ? strArr.length / i : strArr.length / i;
        for (int i2 = 0; i2 < length; i2++) {
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            for (int i4 = i2 * i; i3 < i && i4 < strArr.length; i4++) {
                arrayList.add(strArr[i4]);
                i3++;
            }
            this.f12318a.add(arrayList);
        }
    }

    /* renamed from: a */
    public void m9129a(final String str, final AbstractC3217f abstractC3217f) {
        C3214c.m9086b(new Runnable() { // from class: com.fimi.soul.module.droneTrack.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (str != null) {
                    File file = new File(str);
                    if (!file.exists()) {
                        return;
                    }
                    try {
                        byte[] bArr = new byte[(int) file.length()];
                        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                        randomAccessFile.read(bArr);
                        String[] split = new String(bArr).split("\n");
                        randomAccessFile.close();
                        C3204c.this.m9127b();
                        int length = split.length;
                        C3204c.this.m9128a(split, split.length / 4);
                        if (C3204c.this.f12318a == null || C3204c.this.f12318a.size() < 4) {
                            return;
                        }
                        C3204c.this.f12319c = new C3207d();
                        C3204c.this.f12319c.m9121a(abstractC3217f);
                        C3204c.this.f12319c.m9115d().m9106a(C3204c.this.f12318a.get(0));
                        C3204c.this.f12319c.m9117c().m9106a(C3204c.this.f12318a.get(1));
                        C3204c.this.f12319c.m9119b().m9106a(C3204c.this.f12318a.get(2));
                        C3204c.this.f12319c.m9124a().m9106a(C3204c.this.f12318a.get(3));
                        C3204c.this.f12319c.m9113e();
                    } catch (Exception e) {
                        if (abstractC3217f == null) {
                            return;
                        }
                        abstractC3217f.mo9082a(e.toString());
                    }
                }
            }
        });
    }

    /* renamed from: b */
    public void m9127b() {
        C3203b.m9155a().m9143d();
        m9126c();
        if (this.f12319c != null) {
            this.f12319c.m9121a((AbstractC3217f) null);
            this.f12319c = null;
        }
        if (this.f12318a != null) {
            this.f12318a = null;
        }
    }

    /* renamed from: c */
    public void m9126c() {
        if (this.f12319c != null) {
            this.f12319c.m9111f();
        }
    }
}
