package com.p080b;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.b.cc */
/* loaded from: classes.dex */
public final class C1493cc implements Serializable {

    /* renamed from: c */
    private byte f5311c = 8;

    /* renamed from: a */
    protected byte f5309a = 0;

    /* renamed from: b */
    protected ArrayList f5310b = new ArrayList();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final Boolean m15868a(DataOutputStream dataOutputStream) {
        try {
            dataOutputStream.writeByte(this.f5311c);
            dataOutputStream.writeByte(this.f5309a);
            for (byte b = 0; b < this.f5309a; b++) {
                C1494cd c1494cd = (C1494cd) this.f5310b.get(b);
                dataOutputStream.write(c1494cd.f5312a);
                dataOutputStream.writeShort(c1494cd.f5313b);
                dataOutputStream.write(C1496cf.m15854a(c1494cd.f5314c, c1494cd.f5314c.length));
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
