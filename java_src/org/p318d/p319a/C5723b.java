package org.p318d.p319a;

import java.util.Queue;
import org.p318d.AbstractC5744c;
import org.p318d.AbstractC5756f;
import org.p318d.p320b.C5739k;
/* renamed from: org.d.a.b */
/* loaded from: classes2.dex */
public class C5723b implements AbstractC5744c {

    /* renamed from: a */
    String f22969a;

    /* renamed from: b */
    C5739k f22970b;

    /* renamed from: d */
    Queue<C5726e> f22971d;

    public C5723b(C5739k c5739k, Queue<C5726e> queue) {
        this.f22970b = c5739k;
        this.f22969a = c5739k.mo88d();
        this.f22971d = queue;
    }

    /* renamed from: a */
    private void m187a(EnumC5724c enumC5724c, String str, Object[] objArr, Throwable th) {
        m186a(enumC5724c, null, str, objArr, th);
    }

    /* renamed from: a */
    private void m186a(EnumC5724c enumC5724c, AbstractC5756f abstractC5756f, String str, Object[] objArr, Throwable th) {
        C5726e c5726e = new C5726e();
        c5726e.m183a(System.currentTimeMillis());
        c5726e.m180a(enumC5724c);
        c5726e.m179a(this.f22970b);
        c5726e.m182a(this.f22969a);
        c5726e.m175b(str);
        c5726e.m177a(objArr);
        c5726e.m181a(th);
        c5726e.m173c(Thread.currentThread().getName());
        this.f22971d.add(c5726e);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public void mo118a(String str, Object obj) {
        m187a(EnumC5724c.TRACE, str, new Object[]{obj}, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public void mo117a(String str, Object obj, Object obj2) {
        m187a(EnumC5724c.TRACE, str, new Object[]{obj, obj2}, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public void mo116a(String str, Throwable th) {
        m187a(EnumC5724c.TRACE, str, (Object[]) null, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public void mo115a(String str, Object... objArr) {
        m187a(EnumC5724c.TRACE, str, objArr, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public void mo113a(AbstractC5756f abstractC5756f, String str) {
        m186a(EnumC5724c.TRACE, abstractC5756f, str, null, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public void mo112a(AbstractC5756f abstractC5756f, String str, Object obj) {
        m186a(EnumC5724c.TRACE, abstractC5756f, str, new Object[]{obj}, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public void mo111a(AbstractC5756f abstractC5756f, String str, Object obj, Object obj2) {
        m186a(EnumC5724c.TRACE, abstractC5756f, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public void mo110a(AbstractC5756f abstractC5756f, String str, Throwable th) {
        m186a(EnumC5724c.TRACE, abstractC5756f, str, null, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public void mo109a(AbstractC5756f abstractC5756f, String str, Object... objArr) {
        m186a(EnumC5724c.TRACE, abstractC5756f, str, objArr, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: a */
    public boolean mo114a(AbstractC5756f abstractC5756f) {
        return true;
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public void mo108b(String str, Object obj) {
        m187a(EnumC5724c.DEBUG, str, new Object[]{obj}, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public void mo107b(String str, Object obj, Object obj2) {
        m187a(EnumC5724c.DEBUG, str, new Object[]{obj, obj2}, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public void mo106b(String str, Throwable th) {
        m187a(EnumC5724c.DEBUG, str, (Object[]) null, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public void mo105b(String str, Object... objArr) {
        m187a(EnumC5724c.DEBUG, str, objArr, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public void mo103b(AbstractC5756f abstractC5756f, String str) {
        m186a(EnumC5724c.DEBUG, abstractC5756f, str, null, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public void mo102b(AbstractC5756f abstractC5756f, String str, Object obj) {
        m186a(EnumC5724c.DEBUG, abstractC5756f, str, new Object[]{obj}, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public void mo101b(AbstractC5756f abstractC5756f, String str, Object obj, Object obj2) {
        m186a(EnumC5724c.DEBUG, abstractC5756f, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public void mo100b(AbstractC5756f abstractC5756f, String str, Throwable th) {
        m186a(EnumC5724c.DEBUG, abstractC5756f, str, null, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public void mo99b(AbstractC5756f abstractC5756f, String str, Object... objArr) {
        m186a(EnumC5724c.DEBUG, abstractC5756f, str, objArr, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: b */
    public boolean mo104b(AbstractC5756f abstractC5756f) {
        return true;
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public void mo98c(String str, Object obj) {
        m187a(EnumC5724c.ERROR, str, new Object[]{obj}, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public void mo97c(String str, Object obj, Object obj2) {
        m187a(EnumC5724c.ERROR, str, new Object[]{obj, obj2}, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public void mo96c(String str, Throwable th) {
        m187a(EnumC5724c.ERROR, str, (Object[]) null, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public void mo95c(String str, Object... objArr) {
        m187a(EnumC5724c.ERROR, str, objArr, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public void mo93c(AbstractC5756f abstractC5756f, String str) {
        m186a(EnumC5724c.ERROR, abstractC5756f, str, null, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public void mo92c(AbstractC5756f abstractC5756f, String str, Object obj) {
        m186a(EnumC5724c.ERROR, abstractC5756f, str, new Object[]{obj}, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public void mo91c(AbstractC5756f abstractC5756f, String str, Object obj, Object obj2) {
        m186a(EnumC5724c.ERROR, abstractC5756f, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public void mo90c(AbstractC5756f abstractC5756f, String str, Throwable th) {
        m186a(EnumC5724c.ERROR, abstractC5756f, str, null, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public void mo89c(AbstractC5756f abstractC5756f, String str, Object... objArr) {
        m186a(EnumC5724c.ERROR, abstractC5756f, str, objArr, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: c */
    public boolean mo94c(AbstractC5756f abstractC5756f) {
        return true;
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public String mo88d() {
        return this.f22969a;
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public void mo87d(String str, Object obj) {
        m187a(EnumC5724c.INFO, str, new Object[]{obj}, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public void mo86d(String str, Object obj, Object obj2) {
        m187a(EnumC5724c.INFO, str, new Object[]{obj, obj2}, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public void mo85d(String str, Throwable th) {
        m187a(EnumC5724c.INFO, str, (Object[]) null, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public void mo84d(String str, Object... objArr) {
        m187a(EnumC5724c.INFO, str, objArr, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public void mo82d(AbstractC5756f abstractC5756f, String str) {
        m186a(EnumC5724c.INFO, abstractC5756f, str, null, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public void mo81d(AbstractC5756f abstractC5756f, String str, Object obj) {
        m186a(EnumC5724c.INFO, abstractC5756f, str, new Object[]{obj}, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public void mo80d(AbstractC5756f abstractC5756f, String str, Object obj, Object obj2) {
        m186a(EnumC5724c.INFO, abstractC5756f, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public void mo79d(AbstractC5756f abstractC5756f, String str, Throwable th) {
        m186a(EnumC5724c.INFO, abstractC5756f, str, null, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public void mo78d(AbstractC5756f abstractC5756f, String str, Object... objArr) {
        m186a(EnumC5724c.INFO, abstractC5756f, str, objArr, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: d */
    public boolean mo83d(AbstractC5756f abstractC5756f) {
        return true;
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public void mo77e(String str, Object obj) {
        m187a(EnumC5724c.WARN, str, new Object[]{obj}, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public void mo76e(String str, Object obj, Object obj2) {
        m187a(EnumC5724c.WARN, str, new Object[]{obj, obj2}, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public void mo75e(String str, Throwable th) {
        m187a(EnumC5724c.WARN, str, (Object[]) null, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public void mo74e(String str, Object... objArr) {
        m187a(EnumC5724c.WARN, str, objArr, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public void mo72e(AbstractC5756f abstractC5756f, String str) {
        m187a(EnumC5724c.WARN, str, (Object[]) null, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public void mo71e(AbstractC5756f abstractC5756f, String str, Object obj) {
        m187a(EnumC5724c.WARN, str, new Object[]{obj}, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public void mo70e(AbstractC5756f abstractC5756f, String str, Object obj, Object obj2) {
        m186a(EnumC5724c.WARN, abstractC5756f, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public void mo69e(AbstractC5756f abstractC5756f, String str, Throwable th) {
        m186a(EnumC5724c.WARN, abstractC5756f, str, null, th);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public void mo68e(AbstractC5756f abstractC5756f, String str, Object... objArr) {
        m186a(EnumC5724c.WARN, abstractC5756f, str, objArr, null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: e */
    public boolean mo73e(AbstractC5756f abstractC5756f) {
        return true;
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: f */
    public void mo67f(String str) {
        m187a(EnumC5724c.TRACE, str, (Object[]) null, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: g */
    public void mo66g(String str) {
        m187a(EnumC5724c.TRACE, str, (Object[]) null, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: h */
    public void mo64h(String str) {
        m187a(EnumC5724c.ERROR, str, (Object[]) null, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: h */
    public boolean mo65h() {
        return true;
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: i */
    public void mo62i(String str) {
        m187a(EnumC5724c.INFO, str, (Object[]) null, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: i */
    public boolean mo63i() {
        return true;
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: j */
    public void mo60j(String str) {
        m187a(EnumC5724c.WARN, str, (Object[]) null, (Throwable) null);
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: j */
    public boolean mo61j() {
        return true;
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: k */
    public boolean mo59k() {
        return true;
    }

    @Override // org.p318d.AbstractC5744c
    /* renamed from: l */
    public boolean mo58l() {
        return true;
    }
}
