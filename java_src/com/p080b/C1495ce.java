package com.p080b;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: com.b.ce */
/* loaded from: classes.dex */
public class C1495ce {

    /* renamed from: a */
    protected File f5315a;

    /* renamed from: b */
    protected int[] f5316b;

    /* renamed from: c */
    private ArrayList f5317c;

    /* renamed from: d */
    private boolean f5318d = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public C1495ce(File file, ArrayList arrayList, int[] iArr) {
        this.f5315a = file;
        this.f5317c = arrayList;
        this.f5316b = iArr;
    }

    /* renamed from: a */
    public void m15866a(boolean z) {
        this.f5318d = z;
    }

    /* renamed from: a */
    public byte[] m15867a() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        Iterator it2 = this.f5317c.iterator();
        while (it2.hasNext()) {
            byte[] bArr = (byte[]) it2.next();
            try {
                dataOutputStream.writeInt(bArr.length);
                dataOutputStream.write(bArr);
            } catch (IOException e) {
            }
        }
        try {
            byteArrayOutputStream.close();
            dataOutputStream.close();
        } catch (IOException e2) {
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final boolean m15865b() {
        return this.f5318d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public final int m15864c() {
        if (this.f5317c == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.f5317c.size(); i2++) {
            i += this.f5317c.get(i2) != null ? ((byte[]) this.f5317c.get(i2)).length : 0;
        }
        return i;
    }
}
