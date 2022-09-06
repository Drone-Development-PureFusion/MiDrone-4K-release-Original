package p004b.p005a.p006a.p007a.p025n;
/* renamed from: b.a.a.a.n.c */
/* loaded from: classes.dex */
public class C0230c {
    /* renamed from: a */
    public static final Throwable m21252a(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Object obj = objArr[objArr.length - 1];
        if (!(obj instanceof Throwable)) {
            return null;
        }
        return (Throwable) obj;
    }

    /* renamed from: a */
    public static boolean m21253a(Throwable th) {
        return th != null;
    }

    /* renamed from: b */
    public static Object[] m21251b(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            throw new IllegalStateException("non-sensical empty or null argument array");
        }
        int length = objArr.length - 1;
        Object[] objArr2 = new Object[length];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        return objArr2;
    }

    /* renamed from: c */
    public static Object[] m21250c(Object[] objArr) {
        return objArr;
    }
}
