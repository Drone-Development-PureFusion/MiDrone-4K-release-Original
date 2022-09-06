package com.github.moduth.blockcanary;

import com.github.moduth.blockcanary.p215b.C3947a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.github.moduth.blockcanary.n */
/* loaded from: classes.dex */
public class C3972n extends AbstractC3970m {

    /* renamed from: d */
    private static final LinkedHashMap<Long, String> f16997d = new LinkedHashMap<>();

    /* renamed from: e */
    private static final int f16998e = 10;

    /* renamed from: f */
    private int f16999f;

    /* renamed from: g */
    private Thread f17000g;

    public C3972n(Thread thread, int i, long j) {
        super(j);
        this.f16999f = 10;
        this.f17000g = thread;
        this.f16999f = i;
    }

    public C3972n(Thread thread, long j) {
        this(thread, 10, j);
    }

    /* renamed from: a */
    public ArrayList<String> m6345a(long j, long j2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (f16997d) {
            for (Long l : f16997d.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(simpleDateFormat.format(l) + C3947a.f16890a + C3947a.f16890a + f16997d.get(l));
                }
            }
        }
        return arrayList;
    }

    @Override // com.github.moduth.blockcanary.AbstractC3970m
    /* renamed from: c */
    protected void mo6344c() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.f17000g.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append(C3947a.f16890a);
        }
        synchronized (f16997d) {
            if (f16997d.size() == this.f16999f && this.f16999f > 0) {
                f16997d.remove(f16997d.keySet().iterator().next());
            }
            f16997d.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
