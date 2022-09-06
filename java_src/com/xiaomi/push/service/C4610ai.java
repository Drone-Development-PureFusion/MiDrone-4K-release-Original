package com.xiaomi.push.service;

import android.util.Pair;
import com.xiaomi.channel.commonutils.misc.C4480b;
import com.xiaomi.xmpush.thrift.C4768ac;
import com.xiaomi.xmpush.thrift.C4770ad;
import com.xiaomi.xmpush.thrift.C4816n;
import com.xiaomi.xmpush.thrift.C4819p;
import com.xiaomi.xmpush.thrift.EnumC4804f;
import com.xiaomi.xmpush.thrift.EnumC4805g;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.xiaomi.push.service.ai */
/* loaded from: classes2.dex */
public class C4610ai {
    /* renamed from: a */
    public static int m4387a(C4609ah c4609ah, EnumC4804f enumC4804f) {
        int i = 0;
        String m4385a = m4385a(enumC4804f);
        switch (enumC4804f) {
            case MISC_CONFIG:
                i = 1;
                break;
        }
        return c4609ah.f18948a.getInt(m4385a, i);
    }

    /* renamed from: a */
    private static String m4385a(EnumC4804f enumC4804f) {
        return "oc_version_" + enumC4804f.m3436a();
    }

    /* renamed from: a */
    private static List<Pair<Integer, Object>> m4384a(List<C4819p> list, boolean z) {
        Pair pair;
        if (C4480b.m5030a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (C4819p c4819p : list) {
            int m3346a = c4819p.m3346a();
            EnumC4805g m3434a = EnumC4805g.m3434a(c4819p.m3340c());
            if (m3434a != null) {
                if (!z || !c4819p.f20388c) {
                    switch (m3434a) {
                        case INT:
                            pair = new Pair(Integer.valueOf(m3346a), Integer.valueOf(c4819p.m3334f()));
                            break;
                        case LONG:
                            pair = new Pair(Integer.valueOf(m3346a), Long.valueOf(c4819p.m3331h()));
                            break;
                        case STRING:
                            pair = new Pair(Integer.valueOf(m3346a), c4819p.m3329j());
                            break;
                        case BOOLEAN:
                            pair = new Pair(Integer.valueOf(m3346a), Boolean.valueOf(c4819p.m3327l()));
                            break;
                        default:
                            pair = null;
                            break;
                    }
                    arrayList.add(pair);
                } else {
                    arrayList.add(new Pair(Integer.valueOf(m3346a), null));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m4389a(C4609ah c4609ah, C4768ac c4768ac) {
        c4609ah.m4390b(m4384a(c4768ac.m3723a(), true));
    }

    /* renamed from: a */
    public static void m4388a(C4609ah c4609ah, C4770ad c4770ad) {
        for (C4816n c4816n : c4770ad.m3717a()) {
            if (c4816n.m3356a() > m4387a(c4609ah, c4816n.m3350d())) {
                m4386a(c4609ah, c4816n.m3350d(), c4816n.m3356a());
                c4609ah.m4392a(m4384a(c4816n.f20325b, false));
            }
        }
    }

    /* renamed from: a */
    public static void m4386a(C4609ah c4609ah, EnumC4804f enumC4804f, int i) {
        c4609ah.f18948a.edit().putInt(m4385a(enumC4804f), i).commit();
    }
}
