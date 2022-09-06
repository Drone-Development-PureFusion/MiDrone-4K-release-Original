package p004b.p005a.p006a.p028b.p035g.p040e;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
/* renamed from: b.a.a.b.g.e.c */
/* loaded from: classes.dex */
public class C0353c {
    /* renamed from: a */
    public static String m20825a(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        String lowerCase = str.substring(0, 1).toLowerCase();
        return str.length() > 1 ? lowerCase + str.substring(1) : lowerCase;
    }

    /* renamed from: a */
    public static C0354d[] m20826a(Class<?> cls) {
        Method[] methods;
        ArrayList arrayList = new ArrayList();
        for (Method method : cls.getMethods()) {
            arrayList.add(new C0354d(method.getName(), method));
        }
        return (C0354d[]) arrayList.toArray(new C0354d[0]);
    }

    /* renamed from: b */
    public static C0355e[] m20824b(Class<?> cls) {
        Method[] methods;
        int length = "set".length();
        HashMap hashMap = new HashMap();
        for (Method method : cls.getMethods()) {
            String name = method.getName();
            boolean z = name.startsWith("get") && name.length() > length;
            boolean z2 = name.startsWith("set") && name.length() > length;
            if (z || z2) {
                String m20825a = m20825a(name.substring(length));
                C0355e c0355e = (C0355e) hashMap.get(m20825a);
                if (c0355e == null) {
                    c0355e = new C0355e(m20825a);
                    hashMap.put(m20825a, c0355e);
                }
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (z2) {
                    if (parameterTypes.length == 1) {
                        c0355e.m20819a(method);
                        c0355e.m20820a(parameterTypes[0]);
                    }
                } else if (z && parameterTypes.length == 0) {
                    c0355e.m20817b(method);
                    if (c0355e.m20815d() == null) {
                        c0355e.m20820a(method.getReturnType());
                    }
                }
            }
        }
        return (C0355e[]) hashMap.values().toArray(new C0355e[0]);
    }
}
