package com.fimi.kernel.utils;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* renamed from: com.fimi.kernel.utils.j */
/* loaded from: classes.dex */
public class C2263j<T> {

    /* renamed from: com.fimi.kernel.utils.j$a */
    /* loaded from: classes.dex */
    static class C2265a {

        /* renamed from: a */
        String f7542a;

        /* renamed from: b */
        String f7543b;

        C2265a() {
        }

        /* renamed from: a */
        public String m12956a() {
            return this.f7542a;
        }

        /* renamed from: a */
        public void m12955a(String str) {
            this.f7542a = str;
        }

        /* renamed from: b */
        public String m12954b() {
            return this.f7543b;
        }

        /* renamed from: b */
        public void m12953b(String str) {
            this.f7543b = str;
        }
    }

    /* renamed from: a */
    public static Object m12959a(String str, Class cls) {
        try {
            return new GsonBuilder().create().fromJson(str, (Class<Object>) cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m12961a(Object obj) {
        try {
            return new GsonBuilder().create().toJson(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m12958a(List<?> list) {
        try {
            return new GsonBuilder().create().toJson(list);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static List<?> m12960a(String str, TypeToken typeToken) {
        try {
            return (List) new GsonBuilder().create().fromJson(str, typeToken.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static void m12957a(String[] strArr) {
        List<?> m12960a = m12960a("[{id:1,name:22},{id:2,name:33}]", new TypeToken<ArrayList<C2265a>>() { // from class: com.fimi.kernel.utils.j.1
        });
        System.out.println(m12960a.size());
        Iterator<?> it2 = m12960a.iterator();
        while (it2.hasNext()) {
            System.out.println(((C2265a) it2.next()).m12954b());
        }
        System.out.println(((C2265a) m12959a("{id:1,name:22}", C2265a.class)).m12954b());
    }
}
