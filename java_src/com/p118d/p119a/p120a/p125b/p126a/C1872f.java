package com.p118d.p119a.p120a.p125b.p126a;

import android.graphics.Bitmap;
import com.p118d.p119a.p120a.p125b.AbstractC1876c;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
/* renamed from: com.d.a.a.b.a.f */
/* loaded from: classes.dex */
public class C1872f implements AbstractC1876c {

    /* renamed from: a */
    private final LinkedHashMap<String, Bitmap> f6622a;

    /* renamed from: b */
    private final int f6623b;

    /* renamed from: c */
    private int f6624c;

    public C1872f(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f6623b = i;
        this.f6622a = new LinkedHashMap<>(0, 0.75f, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0031, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m14213a(int i) {
        while (true) {
            synchronized (this) {
                if (this.f6624c < 0 || (this.f6622a.isEmpty() && this.f6624c != 0)) {
                    break;
                } else if (this.f6624c <= i || this.f6622a.isEmpty()) {
                    break;
                } else {
                    Map.Entry<String, Bitmap> next = this.f6622a.entrySet().iterator().next();
                    if (next == null) {
                        return;
                    }
                    String key = next.getKey();
                    this.f6622a.remove(key);
                    this.f6624c -= m14212b(key, next.getValue());
                }
            }
        }
    }

    /* renamed from: b */
    private int m14212b(String str, Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: a */
    public final Bitmap mo14206a(String str) {
        Bitmap bitmap;
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            bitmap = this.f6622a.get(str);
        }
        return bitmap;
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: a */
    public Collection<String> mo14207a() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f6622a.keySet());
        }
        return hashSet;
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: a */
    public final boolean mo14205a(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f6624c += m14212b(str, bitmap);
            Bitmap put = this.f6622a.put(str, bitmap);
            if (put != null) {
                this.f6624c -= m14212b(str, put);
            }
        }
        m14213a(this.f6623b);
        return true;
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: b */
    public final Bitmap mo14203b(String str) {
        Bitmap remove;
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            remove = this.f6622a.remove(str);
            if (remove != null) {
                this.f6624c -= m14212b(str, remove);
            }
        }
        return remove;
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: b */
    public void mo14204b() {
        m14213a(-1);
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.f6623b));
    }
}
