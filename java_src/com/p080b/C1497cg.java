package com.p080b;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
/* renamed from: com.b.cg */
/* loaded from: classes.dex */
final class C1497cg implements Serializable {

    /* renamed from: g */
    private byte f5332g = 4;

    /* renamed from: a */
    protected int f5326a = 0;

    /* renamed from: b */
    protected int f5327b = 0;

    /* renamed from: c */
    protected short f5328c = 0;

    /* renamed from: d */
    protected short f5329d = 0;

    /* renamed from: e */
    protected int f5330e = 0;

    /* renamed from: f */
    protected byte f5331f = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final Boolean m15841a(DataOutputStream dataOutputStream) {
        boolean z = false;
        try {
            dataOutputStream.writeByte(this.f5332g);
            dataOutputStream.writeInt(this.f5326a);
            dataOutputStream.writeInt(this.f5327b);
            dataOutputStream.writeShort(this.f5328c);
            dataOutputStream.writeShort(this.f5329d);
            dataOutputStream.writeInt(this.f5330e);
            dataOutputStream.writeByte(this.f5331f);
            return true;
        } catch (IOException e) {
            return z;
        }
    }
}
