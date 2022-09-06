package com.p080b;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
/* renamed from: com.b.ca */
/* loaded from: classes.dex */
final class C1491ca implements Serializable {

    /* renamed from: c */
    private byte f5298c = 3;

    /* renamed from: a */
    protected byte f5296a = 0;

    /* renamed from: b */
    protected ArrayList f5297b = new ArrayList();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final Boolean m15869a(DataOutputStream dataOutputStream) {
        try {
            dataOutputStream.writeByte(this.f5298c);
            dataOutputStream.writeByte(this.f5296a);
            for (int i = 0; i < this.f5297b.size(); i++) {
                C1492cb c1492cb = (C1492cb) this.f5297b.get(i);
                dataOutputStream.writeByte(c1492cb.f5299a);
                byte[] bArr = new byte[c1492cb.f5299a];
                System.arraycopy(c1492cb.f5300b, 0, bArr, 0, c1492cb.f5299a < c1492cb.f5300b.length ? c1492cb.f5299a : c1492cb.f5300b.length);
                dataOutputStream.write(bArr);
                dataOutputStream.writeDouble(c1492cb.f5301c);
                dataOutputStream.writeInt(c1492cb.f5302d);
                dataOutputStream.writeInt(c1492cb.f5303e);
                dataOutputStream.writeDouble(c1492cb.f5304f);
                dataOutputStream.writeByte(c1492cb.f5305g);
                dataOutputStream.writeByte(c1492cb.f5306h);
                byte[] bArr2 = new byte[c1492cb.f5306h];
                System.arraycopy(c1492cb.f5307i, 0, bArr2, 0, c1492cb.f5306h < c1492cb.f5307i.length ? c1492cb.f5306h : c1492cb.f5307i.length);
                dataOutputStream.write(bArr2);
                dataOutputStream.writeByte(c1492cb.f5308j);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
