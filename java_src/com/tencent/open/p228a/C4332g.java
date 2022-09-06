package com.tencent.open.p228a;

import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
/* renamed from: com.tencent.open.a.g */
/* loaded from: classes2.dex */
public class C4332g implements Iterable<String> {

    /* renamed from: a */
    private ConcurrentLinkedQueue<String> f18121a;

    /* renamed from: b */
    private AtomicInteger f18122b;

    public C4332g() {
        this.f18121a = null;
        this.f18122b = null;
        this.f18121a = new ConcurrentLinkedQueue<>();
        this.f18122b = new AtomicInteger(0);
    }

    /* renamed from: a */
    public int m5438a() {
        return this.f18122b.get();
    }

    /* renamed from: a */
    public int m5436a(String str) {
        int length = str.length();
        this.f18121a.add(str);
        return this.f18122b.addAndGet(length);
    }

    /* renamed from: a */
    public void m5437a(Writer writer, char[] cArr) {
        if (writer == null || cArr == null || cArr.length == 0) {
            return;
        }
        int length = cArr.length;
        Iterator<String> it2 = iterator();
        int i = 0;
        int i2 = length;
        while (it2.hasNext()) {
            String next = it2.next();
            int length2 = next.length();
            int i3 = 0;
            while (length2 > 0) {
                int i4 = i2 > length2 ? length2 : i2;
                next.getChars(i3, i3 + i4, cArr, i);
                i2 -= i4;
                i += i4;
                length2 -= i4;
                int i5 = i4 + i3;
                if (i2 == 0) {
                    writer.write(cArr, 0, length);
                    i = 0;
                    i2 = length;
                    i3 = i5;
                } else {
                    i3 = i5;
                }
            }
        }
        if (i > 0) {
            writer.write(cArr, 0, i);
        }
        writer.flush();
    }

    /* renamed from: b */
    public void m5435b() {
        this.f18121a.clear();
        this.f18122b.set(0);
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this.f18121a.iterator();
    }
}
