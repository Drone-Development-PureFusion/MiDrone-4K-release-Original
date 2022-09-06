package com.p080b;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import org.codehaus.jackson.smile.SmileConstants;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.b.bx */
/* loaded from: classes.dex */
public final class C1485bx implements Serializable {

    /* renamed from: k */
    private byte f5238k = SmileConstants.HEADER_BYTE_2;

    /* renamed from: l */
    private short f5239l = 0;

    /* renamed from: a */
    protected byte[] f5228a = new byte[16];

    /* renamed from: b */
    protected byte[] f5229b = new byte[16];

    /* renamed from: c */
    protected byte[] f5230c = new byte[16];

    /* renamed from: d */
    protected short f5231d = 0;

    /* renamed from: e */
    protected short f5232e = 0;

    /* renamed from: f */
    protected byte f5233f = 0;

    /* renamed from: g */
    protected byte[] f5234g = new byte[16];

    /* renamed from: h */
    protected byte[] f5235h = new byte[32];

    /* renamed from: i */
    protected short f5236i = 0;

    /* renamed from: j */
    protected ArrayList f5237j = new ArrayList();

    /* renamed from: a */
    private Boolean m15932a(DataOutputStream dataOutputStream) {
        Boolean.valueOf(true);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream2.flush();
            dataOutputStream2.write(this.f5228a);
            dataOutputStream2.write(this.f5229b);
            dataOutputStream2.write(this.f5230c);
            dataOutputStream2.writeShort(this.f5231d);
            dataOutputStream2.writeShort(this.f5232e);
            dataOutputStream2.writeByte(this.f5233f);
            this.f5234g[15] = 0;
            dataOutputStream2.write(C1496cf.m15854a(this.f5234g, this.f5234g.length));
            this.f5235h[31] = 0;
            dataOutputStream2.write(C1496cf.m15854a(this.f5235h, this.f5235h.length));
            dataOutputStream2.writeShort(this.f5236i);
            for (short s = 0; s < this.f5236i; s = (short) (s + 1)) {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream3 = new DataOutputStream(byteArrayOutputStream2);
                dataOutputStream3.flush();
                C1479bu c1479bu = (C1479bu) this.f5237j.get(s);
                if (c1479bu.f5176c != null && !c1479bu.f5176c.m15970a(dataOutputStream3).booleanValue()) {
                    Boolean.valueOf(false);
                }
                if (c1479bu.f5177d != null && !c1479bu.f5177d.m15709a(dataOutputStream3).booleanValue()) {
                    Boolean.valueOf(false);
                }
                if (c1479bu.f5178e != null && !c1479bu.f5178e.m15841a(dataOutputStream3).booleanValue()) {
                    Boolean.valueOf(false);
                }
                if (c1479bu.f5179f != null && !c1479bu.f5179f.m15868a(dataOutputStream3).booleanValue()) {
                    Boolean.valueOf(false);
                }
                if (c1479bu.f5180g != null && !c1479bu.f5180g.m15869a(dataOutputStream3).booleanValue()) {
                    Boolean.valueOf(false);
                }
                c1479bu.f5174a = Integer.valueOf(byteArrayOutputStream2.size() + 4).shortValue();
                dataOutputStream2.writeShort(c1479bu.f5174a);
                dataOutputStream2.writeInt(c1479bu.f5175b);
                dataOutputStream2.write(byteArrayOutputStream2.toByteArray());
            }
            this.f5239l = Integer.valueOf(byteArrayOutputStream.size()).shortValue();
            dataOutputStream.writeByte(this.f5238k);
            dataOutputStream.writeShort(this.f5239l);
            dataOutputStream.write(byteArrayOutputStream.toByteArray());
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final byte[] m15933a() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m15932a(new DataOutputStream(byteArrayOutputStream));
        return byteArrayOutputStream.toByteArray();
    }
}
