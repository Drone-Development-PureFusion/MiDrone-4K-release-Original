package com.p080b;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
/* renamed from: com.b.de */
/* loaded from: classes.dex */
final class C1522de implements Serializable {

    /* renamed from: f */
    private byte f5453f = 2;

    /* renamed from: a */
    protected short f5448a = 0;

    /* renamed from: b */
    protected int f5449b = 0;

    /* renamed from: c */
    protected byte f5450c = 0;

    /* renamed from: d */
    protected byte f5451d = 0;

    /* renamed from: e */
    protected ArrayList f5452e = new ArrayList();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final Boolean m15709a(DataOutputStream dataOutputStream) {
        try {
            dataOutputStream.writeByte(this.f5453f);
            dataOutputStream.writeShort(this.f5448a);
            dataOutputStream.writeInt(this.f5449b);
            dataOutputStream.writeByte(this.f5450c);
            dataOutputStream.writeByte(this.f5451d);
            for (byte b = 0; b < this.f5451d; b++) {
                dataOutputStream.writeShort(((C1498ch) this.f5452e.get(b)).f5333a);
                dataOutputStream.writeInt(((C1498ch) this.f5452e.get(b)).f5334b);
                dataOutputStream.writeByte(((C1498ch) this.f5452e.get(b)).f5335c);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
