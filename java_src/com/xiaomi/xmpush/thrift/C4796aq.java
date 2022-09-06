package com.xiaomi.xmpush.thrift;

import android.content.Context;
import com.xiaomi.channel.commonutils.android.C4464b;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.misc.C4483e;
import com.xiaomi.push.service.C4641ay;
import org.p248a.p283b.AbstractC5358a;
import org.p248a.p283b.C5388e;
import org.p248a.p283b.C5389f;
import org.p248a.p283b.C5390g;
import org.p248a.p283b.p285b.C5368a;
import org.p248a.p283b.p285b.C5379k;
/* renamed from: com.xiaomi.xmpush.thrift.aq */
/* loaded from: classes.dex */
public class C4796aq {
    /* renamed from: a */
    public static short m3472a(Context context, C4766ab c4766ab) {
        int i = 0;
        int m5090a = (C4483e.m5028a(context) ? 8 : 0) + 0 + C4464b.m5093d(context, c4766ab.f19629f).m5090a() + (C4483e.m5027b(context) ? 4 : 0);
        if (C4641ay.m4298a(context, c4766ab)) {
            i = 16;
        }
        return (short) (m5090a + i);
    }

    /* renamed from: a */
    public static short m3469a(boolean z, boolean z2, boolean z3) {
        int i = 0;
        int i2 = (z2 ? 2 : 0) + 0 + (z ? 4 : 0);
        if (z3) {
            i = 1;
        }
        return (short) (i + i2);
    }

    /* renamed from: a */
    public static <T extends AbstractC5358a<T, ?>> void m3470a(T t, byte[] bArr) {
        if (bArr == null) {
            throw new C5389f("the message byte is empty.");
        }
        new C5388e(new C5379k.C5380a(true, true, bArr.length)).m1208a(t, bArr);
    }

    /* renamed from: a */
    public static <T extends AbstractC5358a<T, ?>> byte[] m3471a(T t) {
        if (t == null) {
            return null;
        }
        try {
            return new C5390g(new C5368a.C5369a()).m1207a(t);
        } catch (C5389f e) {
            AbstractC4478b.m5040a("convertThriftObjectToBytes catch TException.", e);
            return null;
        }
    }
}
