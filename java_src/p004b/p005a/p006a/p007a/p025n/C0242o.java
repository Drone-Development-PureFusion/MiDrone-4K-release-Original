package p004b.p005a.p006a.p007a.p025n;
/* renamed from: b.a.a.a.n.o */
/* loaded from: classes.dex */
public class C0242o {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static int m21195a(StackTraceElement[] stackTraceElementArr, C0243p[] c0243pArr) {
        int i = 0;
        if (c0243pArr != null) {
            int length = stackTraceElementArr.length - 1;
            for (int length2 = c0243pArr.length - 1; length >= 0 && length2 >= 0 && stackTraceElementArr[length].equals(c0243pArr[length2].f397a); length2--) {
                i++;
                length--;
            }
        }
        return i;
    }
}
