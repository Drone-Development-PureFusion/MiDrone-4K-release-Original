package com.p078a.p079a;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.codehaus.jackson.smile.SmileConstants;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.a.a.i */
/* loaded from: classes.dex */
public class C0731i implements AbstractC0745u {

    /* renamed from: a */
    private final char[] f1804a;

    /* renamed from: b */
    private final List<C0732a> f1805b;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.a.a.i$a */
    /* loaded from: classes.dex */
    public static final class C0732a implements Comparable<C0732a> {

        /* renamed from: a */
        public final char f1806a;

        /* renamed from: b */
        public final byte f1807b;

        C0732a(byte b, char c) {
            this.f1807b = b;
            this.f1806a = c;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(C0732a c0732a) {
            return this.f1806a - c0732a.f1806a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0732a) {
                C0732a c0732a = (C0732a) obj;
                return this.f1806a == c0732a.f1806a && this.f1807b == c0732a.f1807b;
            }
            return false;
        }

        public int hashCode() {
            return this.f1806a;
        }

        public String toString() {
            return "0x" + Integer.toHexString(65535 & this.f1806a) + "->0x" + Integer.toHexString(this.f1807b & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
        }
    }

    public C0731i(char[] cArr) {
        this.f1804a = (char[]) cArr.clone();
        ArrayList arrayList = new ArrayList(this.f1804a.length);
        byte b = Byte.MAX_VALUE;
        for (int i = 0; i < this.f1804a.length; i++) {
            b = (byte) (b + 1);
            arrayList.add(new C0732a(b, this.f1804a[i]));
        }
        Collections.sort(arrayList);
        this.f1805b = Collections.unmodifiableList(arrayList);
    }

    /* renamed from: b */
    private C0732a m19230b(char c) {
        int i = 0;
        int size = this.f1805b.size();
        while (size > i) {
            int i2 = i + ((size - i) / 2);
            C0732a c0732a = this.f1805b.get(i2);
            if (c0732a.f1806a == c) {
                return c0732a;
            }
            if (c0732a.f1806a < c) {
                i = i2 + 1;
            } else {
                size = i2;
            }
        }
        if (i >= this.f1805b.size()) {
            return null;
        }
        C0732a c0732a2 = this.f1805b.get(i);
        if (c0732a2.f1806a == c) {
            return c0732a2;
        }
        return null;
    }

    /* renamed from: a */
    public char m19233a(byte b) {
        return b >= 0 ? (char) b : this.f1804a[b + 128];
    }

    @Override // com.p078a.p079a.AbstractC0745u
    /* renamed from: a */
    public String mo19201a(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            cArr[i] = m19233a(bArr[i]);
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public boolean m19232a(char c) {
        return (c >= 0 && c < 128) || m19230b(c) != null;
    }

    @Override // com.p078a.p079a.AbstractC0745u
    /* renamed from: a */
    public boolean mo19202a(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!m19232a(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public boolean m19231a(ByteBuffer byteBuffer, char c) {
        if (c >= 0 && c < 128) {
            byteBuffer.put((byte) c);
            return true;
        }
        C0732a m19230b = m19230b(c);
        if (m19230b == null) {
            return false;
        }
        byteBuffer.put(m19230b.f1807b);
        return true;
    }

    @Override // com.p078a.p079a.AbstractC0745u
    /* renamed from: b */
    public ByteBuffer mo19200b(String str) {
        ByteBuffer allocate = ByteBuffer.allocate(str.length() + 6 + ((str.length() + 1) / 2));
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (allocate.remaining() < 6) {
                allocate = AbstractC0746v.m19197a(allocate, allocate.position() + 6);
            }
            if (!m19231a(allocate, charAt)) {
                AbstractC0746v.m19198a(allocate, charAt);
            }
        }
        allocate.limit(allocate.position());
        allocate.rewind();
        return allocate;
    }
}
