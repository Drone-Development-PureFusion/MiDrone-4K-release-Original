package com.p080b;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
/* renamed from: com.b.bv */
/* loaded from: classes.dex */
final class C1480bv implements Serializable {

    /* renamed from: k */
    private byte f5191k = 1;

    /* renamed from: a */
    protected int f5181a = 0;

    /* renamed from: b */
    protected int f5182b = 0;

    /* renamed from: c */
    protected int f5183c = 0;

    /* renamed from: d */
    protected int f5184d = 0;

    /* renamed from: e */
    protected int f5185e = 0;

    /* renamed from: f */
    protected short f5186f = 0;

    /* renamed from: g */
    protected byte f5187g = 0;

    /* renamed from: h */
    protected byte f5188h = 0;

    /* renamed from: i */
    protected long f5189i = 0;

    /* renamed from: j */
    protected long f5190j = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final Boolean m15970a(DataOutputStream dataOutputStream) {
        boolean z = false;
        if (dataOutputStream == null) {
            return z;
        }
        try {
            dataOutputStream.writeByte(this.f5191k);
            dataOutputStream.writeInt(this.f5181a);
            dataOutputStream.writeInt(this.f5182b);
            dataOutputStream.writeInt(this.f5183c);
            dataOutputStream.writeInt(this.f5184d);
            dataOutputStream.writeInt(this.f5185e);
            dataOutputStream.writeShort(this.f5186f);
            dataOutputStream.writeByte(this.f5187g);
            dataOutputStream.writeByte(this.f5188h);
            dataOutputStream.writeLong(this.f5189i);
            dataOutputStream.writeLong(this.f5190j);
            return true;
        } catch (IOException e) {
            return z;
        }
    }
}
