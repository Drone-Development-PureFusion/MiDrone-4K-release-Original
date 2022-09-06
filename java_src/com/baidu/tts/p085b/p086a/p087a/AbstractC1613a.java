package com.baidu.tts.p085b.p086a.p087a;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.p085b.p086a.AbstractC1623b;
import com.baidu.tts.p085b.p086a.p088b.AbstractC1625b;
import com.baidu.tts.p096e.EnumC1702e;
import com.baidu.tts.p104i.AbstractC1722a;
import com.baidu.tts.p108l.C1741e;
import com.baidu.tts.p108l.C1742f;
import com.baidu.tts.p108l.C1743g;
import com.baidu.tts.p108l.C1744h;
import com.baidu.tts.p108l.C1745i;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.baidu.tts.b.a.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC1613a extends AbstractC1722a implements AbstractC1618d {

    /* renamed from: a */
    protected AbstractC1625b f5713a;

    /* renamed from: b */
    protected List<AbstractC1623b> f5714b = new ArrayList();

    /* renamed from: c */
    protected volatile AbstractC1614b f5715c;

    @Override // com.baidu.tts.p085b.p086a.p087a.AbstractC1618d
    /* renamed from: a */
    public int mo15245a(C1741e c1741e) {
        return this.f5715c.mo15245a(c1741e);
    }

    @Override // com.baidu.tts.p085b.p086a.p087a.AbstractC1618d
    /* renamed from: a */
    public int mo15244a(C1742f c1742f) {
        return this.f5715c.mo15244a(c1742f);
    }

    @Override // com.baidu.tts.p085b.p086a.p087a.AbstractC1618d
    /* renamed from: a */
    public int mo15243a(C1743g c1743g) {
        return this.f5715c.mo15243a(c1743g);
    }

    /* renamed from: a */
    public AbstractC1614b m15277a() {
        return this.f5715c;
    }

    /* renamed from: a */
    public void m15276a(AbstractC1614b abstractC1614b) {
        this.f5715c = abstractC1614b;
    }

    @Override // com.baidu.tts.p085b.p086a.p087a.AbstractC1618d
    /* renamed from: a */
    public void mo15249a(AbstractC1625b abstractC1625b) {
        this.f5715c.mo15249a(abstractC1625b);
    }

    @Override // com.baidu.tts.p085b.p086a.p087a.AbstractC1618d
    /* renamed from: a */
    public void mo15248a(AbstractC1623b abstractC1623b) {
        this.f5715c.mo15248a(abstractC1623b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m15275a(C1744h c1744h) {
        if (A()) {
            if (c1744h == null) {
                c1744h = new C1744h();
            }
            c1744h.m14757a(EnumC1702e.SYN_START);
            if (this.f5714b == null) {
                return;
            }
            for (AbstractC1623b abstractC1623b : this.f5714b) {
                if (abstractC1623b != null) {
                    abstractC1623b.mo15227a(c1744h);
                }
            }
        }
    }

    @Override // com.baidu.tts.p085b.p086a.p087a.AbstractC1618d
    /* renamed from: a */
    public void mo15241a(C1745i c1745i) {
        this.f5715c.mo15241a(c1745i);
    }

    @Override // com.baidu.tts.p085b.p086a.p087a.AbstractC1618d
    /* renamed from: a */
    public void mo15247a(Object obj) {
        this.f5715c.mo15247a((AbstractC1614b) obj);
    }

    @Override // com.baidu.tts.p085b.p086a.p087a.AbstractC1618d
    /* renamed from: b */
    public int mo15240b(C1741e c1741e) {
        return this.f5715c.mo15240b(c1741e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m15274b(C1744h c1744h) {
        if (A()) {
            if (c1744h == null) {
                c1744h = new C1744h();
            }
            c1744h.m14757a(EnumC1702e.SYN_DATA);
            if (this.f5714b == null) {
                return;
            }
            for (AbstractC1623b abstractC1623b : this.f5714b) {
                if (abstractC1623b != null) {
                    abstractC1623b.mo15225c(c1744h);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m15273c(C1744h c1744h) {
        if (A()) {
            if (c1744h == null) {
                c1744h = new C1744h();
            }
            c1744h.m14757a(EnumC1702e.SYN_FINISH);
            if (this.f5714b == null) {
                return;
            }
            for (AbstractC1623b abstractC1623b : this.f5714b) {
                if (abstractC1623b != null) {
                    abstractC1623b.mo15226b(c1744h);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public void m15272d(C1744h c1744h) {
        if (c1744h == null) {
            c1744h = new C1744h();
        }
        c1744h.m14757a(EnumC1702e.SYN_STOP);
        if (this.f5714b != null) {
            for (AbstractC1623b abstractC1623b : this.f5714b) {
                if (abstractC1623b != null) {
                    abstractC1623b.mo15223e(c1744h);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public void m15271e(C1744h c1744h) {
        if (c1744h == null) {
            c1744h = new C1744h();
        }
        c1744h.m14757a(EnumC1702e.SYN_ERROR);
        if (this.f5714b != null) {
            for (AbstractC1623b abstractC1623b : this.f5714b) {
                if (abstractC1623b != null) {
                    abstractC1623b.mo15224d(c1744h);
                }
            }
        }
    }

    @Override // com.baidu.tts.p104i.AbstractC1722a
    /* renamed from: g */
    protected TtsError mo14843g() {
        return this.f5715c.mo14683b();
    }

    @Override // com.baidu.tts.p104i.AbstractC1722a
    /* renamed from: h */
    protected void mo14842h() {
        this.f5715c.mo15246a();
    }

    @Override // com.baidu.tts.p104i.AbstractC1722a
    /* renamed from: i */
    protected void mo14841i() {
        this.f5715c.mo14682c();
    }

    @Override // com.baidu.tts.p104i.AbstractC1722a
    /* renamed from: j */
    protected void mo14840j() {
        this.f5715c.mo14681d();
    }

    @Override // com.baidu.tts.p104i.AbstractC1722a
    /* renamed from: k */
    protected void mo14839k() {
        this.f5715c.mo14680e();
    }

    @Override // com.baidu.tts.p104i.AbstractC1722a
    /* renamed from: l */
    protected void mo14838l() {
        this.f5715c.mo14679f();
    }
}
