package com.fimi.soul.utils;

import com.google.gson.Gson;
import java.lang.reflect.Type;
/* renamed from: com.fimi.soul.utils.ag */
/* loaded from: classes.dex */
public class C3637ag {

    /* renamed from: a */
    public static Gson f14794a = new Gson();

    /* renamed from: a */
    public static <T> T m7709a(String str, Class<T> cls) {
        return (T) f14794a.fromJson(str, (Class<Object>) cls);
    }

    /* renamed from: a */
    public static <T> T m7708a(String str, Type type) {
        return (T) f14794a.fromJson(str, type);
    }

    /* renamed from: a */
    public static String m7710a(Object obj) {
        return f14794a.toJson(obj);
    }
}
