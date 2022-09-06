package com.android.volley.toolbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/* renamed from: com.android.volley.toolbox.d */
/* loaded from: classes.dex */
public class C1353d {

    /* renamed from: a */
    protected static final Comparator<byte[]> f4640a = new Comparator<byte[]>() { // from class: com.android.volley.toolbox.d.1
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };

    /* renamed from: b */
    private List<byte[]> f4641b = new LinkedList();

    /* renamed from: c */
    private List<byte[]> f4642c = new ArrayList(64);

    /* renamed from: d */
    private int f4643d = 0;

    /* renamed from: e */
    private final int f4644e;

    public C1353d(int i) {
        this.f4644e = i;
    }

    /* renamed from: a */
    private synchronized void m16665a() {
        while (this.f4643d > this.f4644e) {
            byte[] remove = this.f4641b.remove(0);
            this.f4642c.remove(remove);
            this.f4643d -= remove.length;
        }
    }

    /* renamed from: a */
    public synchronized void m16663a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f4644e) {
                this.f4641b.add(bArr);
                int binarySearch = Collections.binarySearch(this.f4642c, bArr, f4640a);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f4642c.add(binarySearch, bArr);
                this.f4643d += bArr.length;
                m16665a();
            }
        }
    }

    /* renamed from: a */
    public synchronized byte[] m16664a(int i) {
        byte[] bArr;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f4642c.size()) {
                bArr = new byte[i];
                break;
            }
            bArr = this.f4642c.get(i3);
            if (bArr.length >= i) {
                this.f4643d -= bArr.length;
                this.f4642c.remove(i3);
                this.f4641b.remove(bArr);
                break;
            }
            i2 = i3 + 1;
        }
        return bArr;
    }
}
