package com.p118d.p119a.p136c;

import android.graphics.Bitmap;
import com.p118d.p119a.p120a.p125b.AbstractC1876c;
import com.p118d.p119a.p127b.p128a.C1893e;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/* renamed from: com.d.a.c.e */
/* loaded from: classes.dex */
public final class C1950e {

    /* renamed from: a */
    private static final String f6945a = "_";

    /* renamed from: b */
    private static final String f6946b = "x";

    private C1950e() {
    }

    /* renamed from: a */
    public static String m13843a(String str, C1893e c1893e) {
        return str + f6945a + c1893e.m14153a() + f6946b + c1893e.m14150b();
    }

    /* renamed from: a */
    public static Comparator<String> m13845a() {
        return new Comparator<String>() { // from class: com.d.a.c.e.1
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(String str, String str2) {
                return str.substring(0, str.lastIndexOf(C1950e.f6945a)).compareTo(str2.substring(0, str2.lastIndexOf(C1950e.f6945a)));
            }
        };
    }

    /* renamed from: a */
    public static List<Bitmap> m13844a(String str, AbstractC1876c abstractC1876c) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : abstractC1876c.mo14207a()) {
            if (str2.startsWith(str)) {
                arrayList.add(abstractC1876c.mo14206a(str2));
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static List<String> m13842b(String str, AbstractC1876c abstractC1876c) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : abstractC1876c.mo14207a()) {
            if (str2.startsWith(str)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public static void m13841c(String str, AbstractC1876c abstractC1876c) {
        ArrayList<String> arrayList = new ArrayList();
        for (String str2 : abstractC1876c.mo14207a()) {
            if (str2.startsWith(str)) {
                arrayList.add(str2);
            }
        }
        for (String str3 : arrayList) {
            abstractC1876c.mo14203b(str3);
        }
    }
}
