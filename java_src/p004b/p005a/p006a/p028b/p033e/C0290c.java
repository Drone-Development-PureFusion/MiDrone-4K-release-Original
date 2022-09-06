package p004b.p005a.p006a.p028b.p033e;

import java.util.LinkedList;
import java.util.List;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: b.a.a.b.e.c */
/* loaded from: classes.dex */
public class C0290c {
    /* renamed from: a */
    private static int m21022a(StackTraceElement[] stackTraceElementArr, StackTraceElement[] stackTraceElementArr2) {
        int i = 0;
        if (stackTraceElementArr2 != null) {
            int length = stackTraceElementArr.length - 1;
            for (int length2 = stackTraceElementArr2.length - 1; length >= 0 && length2 >= 0 && stackTraceElementArr[length].equals(stackTraceElementArr2[length2]); length2--) {
                i++;
                length--;
            }
        }
        return i;
    }

    /* renamed from: a */
    private static String m21024a(Throwable th, StackTraceElement[] stackTraceElementArr) {
        String str = "";
        if (stackTraceElementArr != null) {
            str = C0359h.f718o;
        }
        String str2 = str + th.getClass().getName();
        return th.getMessage() != null ? str2 + ": " + th.getMessage() : str2;
    }

    /* renamed from: a */
    private static void m21023a(List<String> list, Throwable th, StackTraceElement[] stackTraceElementArr) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int m21022a = m21022a(stackTrace, stackTraceElementArr);
        list.add(m21024a(th, stackTraceElementArr));
        for (int i = 0; i < stackTrace.length - m21022a; i++) {
            list.add("\tat " + stackTrace[i].toString());
        }
        if (m21022a != 0) {
            list.add("\t... " + m21022a + " common frames omitted");
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            m21023a(list, cause, stackTrace);
        }
    }

    /* renamed from: a */
    public static String[] m21025a(Throwable th) {
        LinkedList linkedList = new LinkedList();
        m21023a(linkedList, th, null);
        return (String[]) linkedList.toArray(new String[0]);
    }
}
