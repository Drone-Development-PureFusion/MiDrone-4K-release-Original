package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.fimi.soul.drone.i.ak */
/* loaded from: classes.dex */
public class C2880ak extends C2822e {

    /* renamed from: b */
    public int f10765b;

    /* renamed from: c */
    public byte f10766c = 1;

    public C2880ak(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public int m10585a() {
        return this.f10765b;
    }

    /* renamed from: a */
    public void m10584a(int i, byte b) {
        this.f10765b = i;
        this.f10766c = b;
        if (this.f10431a != null) {
            this.f10431a.mo11220a(C2678d.EnumC2679a.IMU_WORKSTATE);
        }
    }

    /* renamed from: b */
    public byte m10583b() {
        return this.f10766c;
    }

    public String toString() {
        return "IMUWorkStateInfo{imuWorkState=" + (this.f10765b & 255) + "cmdACK=" + (this.f10766c & SmileConstants.BYTE_MARKER_END_OF_CONTENT) + "}";
    }
}
