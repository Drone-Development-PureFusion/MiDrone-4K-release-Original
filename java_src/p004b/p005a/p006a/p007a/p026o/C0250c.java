package p004b.p005a.p006a.p007a.p026o;

import java.util.LinkedHashMap;
import java.util.Map;
/* renamed from: b.a.a.a.o.c */
/* loaded from: classes.dex */
class C0250c extends LinkedHashMap<String, Integer> {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    final int f430a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0250c(int i) {
        super((int) (i * 1.3333334f), 0.75f, true);
        if (i < 1) {
            throw new IllegalArgumentException("Cache size cannot be smaller than 1");
        }
        this.f430a = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m21151a(String str) {
        Integer valueOf;
        if (str == null) {
            return 0;
        }
        synchronized (this) {
            Integer num = (Integer) super.get(str);
            valueOf = num == null ? 0 : Integer.valueOf(num.intValue() + 1);
            super.put(str, valueOf);
        }
        return valueOf.intValue();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public synchronized void clear() {
        super.clear();
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<String, Integer> entry) {
        return size() > this.f430a;
    }
}
