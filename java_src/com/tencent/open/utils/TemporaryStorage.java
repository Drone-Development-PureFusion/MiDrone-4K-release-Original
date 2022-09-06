package com.tencent.open.utils;

import java.util.HashMap;
/* loaded from: classes.dex */
public class TemporaryStorage {

    /* renamed from: a */
    private static HashMap<String, Object> f18215a = new HashMap<>();

    public static Object get(String str) {
        return f18215a.remove(str);
    }

    public static void remove(String str) {
        f18215a.remove(str);
    }

    public static Object set(String str, Object obj) {
        return f18215a.put(str, obj);
    }
}
