package p004b.p005a.p006a.p007a.p023l;

import java.util.Arrays;
import java.util.List;
import p004b.p005a.p006a.p007a.C0151f;
/* renamed from: b.a.a.a.l.b */
/* loaded from: classes.dex */
public class C0221b implements AbstractC0220a {

    /* renamed from: a */
    private C0151f f345a;

    public C0221b(C0151f c0151f) {
        this.f345a = c0151f;
    }

    @Override // p004b.p005a.p006a.p007a.p023l.AbstractC0220a
    /* renamed from: a */
    public C0151f mo21276a() {
        return mo21274b();
    }

    @Override // p004b.p005a.p006a.p007a.p023l.AbstractC0220a
    /* renamed from: a */
    public C0151f mo21275a(String str) {
        if (this.f345a.p().equals(str)) {
            return this.f345a;
        }
        return null;
    }

    @Override // p004b.p005a.p006a.p007a.p023l.AbstractC0220a
    /* renamed from: b */
    public C0151f mo21274b() {
        return this.f345a;
    }

    @Override // p004b.p005a.p006a.p007a.p023l.AbstractC0220a
    /* renamed from: b */
    public C0151f mo21273b(String str) {
        return this.f345a;
    }

    @Override // p004b.p005a.p006a.p007a.p023l.AbstractC0220a
    /* renamed from: c */
    public List<String> mo21272c() {
        return Arrays.asList(this.f345a.p());
    }
}
