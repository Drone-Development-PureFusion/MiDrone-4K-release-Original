package com.baidu.tts.tools;

import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class StringTool {
    public static String addDivider(List<String> list, String str) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it2 = list.iterator();
        if (it2.hasNext()) {
            sb.append(it2.next());
        }
        while (it2.hasNext()) {
            sb.append(str);
            sb.append(it2.next());
        }
        return sb.toString();
    }

    public static String addDivider(int[] iArr, String str) {
        if (iArr != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(iArr[0]);
            for (int i = 1; i < iArr.length; i++) {
                sb.append(str);
                sb.append(iArr[i]);
            }
            return sb.toString();
        }
        return null;
    }

    public static boolean isAllNumber(String str) {
        if (str != null) {
            return str.matches("^[0-9]{1,20}$");
        }
        return false;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() <= 0;
    }

    public static boolean isEqual(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }
}
