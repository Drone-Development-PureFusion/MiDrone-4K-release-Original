package com.fimi.soul.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/* renamed from: com.fimi.soul.utils.ap */
/* loaded from: classes.dex */
public class C3654ap {
    /* renamed from: a */
    public static Map<String, String> m7658a(String str) {
        Scanner scanner = new Scanner(str);
        HashMap hashMap = new HashMap();
        while (scanner.hasNextLine()) {
            String[] split = scanner.nextLine().split("=");
            if (split != null && split.length == 2) {
                hashMap.put(split[0], split[1]);
            }
        }
        return hashMap;
    }
}
