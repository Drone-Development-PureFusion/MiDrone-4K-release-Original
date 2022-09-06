package p004b.p005a.p006a.p028b.p057r;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;
/* renamed from: b.a.a.b.r.x */
/* loaded from: classes.dex */
public class C0592x {
    /* renamed from: a */
    public static void m20041a(Collection<String> collection, Collection<String> collection2) {
        if (collection2.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (String str : collection2) {
            Pattern compile = Pattern.compile(str);
            for (String str2 : collection) {
                if (compile.matcher(str2).matches()) {
                    arrayList.add(str2);
                }
            }
        }
        collection.retainAll(arrayList);
    }

    /* renamed from: a */
    public static void m20040a(Collection<String> collection, String... strArr) {
        m20041a(collection, Arrays.asList(strArr));
    }

    /* renamed from: b */
    public static void m20039b(Collection<String> collection, Collection<String> collection2) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (String str : collection2) {
            Pattern compile = Pattern.compile(str);
            for (String str2 : collection) {
                if (compile.matcher(str2).matches()) {
                    arrayList.add(str2);
                }
            }
        }
        collection.removeAll(arrayList);
    }

    /* renamed from: b */
    public static void m20038b(Collection<String> collection, String... strArr) {
        m20039b(collection, Arrays.asList(strArr));
    }
}
