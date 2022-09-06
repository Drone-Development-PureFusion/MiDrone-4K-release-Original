package p004b.p005a.p006a.p028b.p054o;

import java.util.ArrayList;
import java.util.List;
import p004b.p005a.p006a.p028b.p033e.C0288a;
/* renamed from: b.a.a.b.o.h */
/* loaded from: classes.dex */
public class C0529h<E> extends AbstractC0517a<C0288a<E>> {

    /* renamed from: a */
    static final int f1195a = 64;

    /* renamed from: b */
    static final int f1196b = 256;

    /* renamed from: c */
    int f1197c = 256;

    public C0529h() {
        a(64);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0517a
    /* renamed from: a */
    public C0288a<E> mo20217b(String str) {
        return new C0288a<>(this.f1197c);
    }

    /* renamed from: a */
    protected void m20223a(C0288a<E> c0288a) {
        c0288a.m21034a();
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0517a
    /* renamed from: a */
    protected /* synthetic */ boolean mo20222a(Object obj) {
        return m20219b((C0288a) ((C0288a) obj));
    }

    /* renamed from: b */
    public void m20220b(int i) {
        this.f1197c = i;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0517a
    /* renamed from: b */
    protected /* synthetic */ void mo20218b(Object obj) {
        m20223a((C0288a) ((C0288a) obj));
    }

    /* renamed from: b */
    protected boolean m20219b(C0288a<E> c0288a) {
        return false;
    }

    /* renamed from: f */
    public int m20216f() {
        return this.f1197c;
    }

    /* renamed from: g */
    List<String> m20215g() {
        return new ArrayList(this.f1176i.keySet());
    }

    /* renamed from: h */
    List<String> m20214h() {
        return new ArrayList(this.f1177j.keySet());
    }
}
