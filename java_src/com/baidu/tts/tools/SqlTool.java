package com.baidu.tts.tools;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import p004b.p005a.p006a.p007a.p025n.C0228a;
/* loaded from: classes.dex */
public class SqlTool {
    /* renamed from: a */
    private static String m14674a(Method method, Object obj) {
        try {
            return (String) method.invoke(obj, null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static String m14673a(Method method, Method method2, Object obj) {
        String m14674a;
        String m14674a2 = m14674a(method, obj);
        if (m14674a2 == null || (m14674a = m14674a(method2, obj)) == null) {
            return null;
        }
        return m14674a2 + " " + m14674a;
    }

    public static String addPlaceholders(int i) {
        if (i < 1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(C0228a.f351a);
        for (int i2 = 1; i2 < i; i2++) {
            sb.append(",?");
        }
        return sb.toString();
    }

    public static String buildConditions(String str, String... strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArr) {
            if (!StringTool.isEmpty(str2)) {
                arrayList.add(str2);
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            sb.append((String) it2.next());
        }
        while (it2.hasNext()) {
            sb.append(" " + str + " ");
            sb.append((String) it2.next());
        }
        return sb.toString();
    }

    public static String buildInCondition(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        return str + " in (" + addPlaceholders(strArr.length) + ")";
    }

    public static String[] getSQLformat(String str, String[] strArr, String[] strArr2, String[] strArr3) {
        String[] strArr4 = new String[strArr.length + 1 + strArr2.length + strArr3.length];
        strArr4[0] = str;
        System.arraycopy(strArr, 0, strArr4, 1, strArr.length);
        System.arraycopy(strArr2, 0, strArr4, strArr.length + 1, strArr2.length);
        System.arraycopy(strArr3, 0, strArr4, strArr.length + 1 + strArr2.length, strArr3.length);
        return strArr4;
    }

    public static String sqlCreateTable(String str, Object[] objArr) {
        if (str == null || objArr == null) {
            return null;
        }
        Object obj = objArr[0];
        Class<?> cls = obj.getClass();
        try {
            Method supportedMethod = ReflectTool.getSupportedMethod(cls, "getColumnName", null);
            Method supportedMethod2 = ReflectTool.getSupportedMethod(cls, "getDataType", null);
            StringBuilder sb = new StringBuilder("create Table " + str);
            String m14673a = m14673a(supportedMethod, supportedMethod2, obj);
            if (m14673a == null) {
                return null;
            }
            sb.append(" (" + m14673a);
            int length = objArr.length;
            for (int i = 1; i < length; i++) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(m14673a(supportedMethod, supportedMethod2, objArr[i]));
            }
            sb.append(")");
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String sqlDropTable(String str) {
        return "drop table if exists " + str;
    }
}
