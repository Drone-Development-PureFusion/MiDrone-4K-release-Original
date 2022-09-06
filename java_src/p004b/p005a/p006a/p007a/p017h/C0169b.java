package p004b.p005a.p006a.p007a.p017h;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import p004b.p005a.p006a.p007a.C0146d;
import p004b.p005a.p006a.p007a.C0148e;
import p004b.p005a.p006a.p007a.C0151f;
import p004b.p005a.p006a.p007a.p025n.AbstractC0236i;
import p004b.p005a.p006a.p028b.p054o.AbstractC0534m;
import p004b.p005a.p006a.p028b.p054o.C0527f;
@Deprecated
/* renamed from: b.a.a.a.h.b */
/* loaded from: classes.dex */
public class C0169b extends C0527f implements AbstractC0236i, AbstractC0534m {

    /* renamed from: c */
    private Set f258c = new HashSet();

    /* renamed from: a */
    boolean f256a = false;

    /* renamed from: b */
    boolean f257b = false;

    /* renamed from: b */
    private void m21390b(C0148e c0148e, C0146d c0146d) {
        d("Propagating " + c0146d + " level on " + c0148e + " onto the JUL framework");
        Logger m21397a = C0168a.m21397a(c0148e);
        this.f258c.add(m21397a);
        m21397a.setLevel(C0168a.m21398a(c0146d));
    }

    /* renamed from: d */
    private void m21389d() {
        for (C0148e c0148e : ((C0151f) this.f1190s).m21434c()) {
            if (c0148e.m21461c() != null) {
                m21390b(c0148e, c0148e.m21461c());
            }
        }
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0236i
    /* renamed from: a */
    public void mo21245a(C0148e c0148e, C0146d c0146d) {
        m21390b(c0148e, c0146d);
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0236i
    /* renamed from: a */
    public void mo21244a(C0151f c0151f) {
    }

    /* renamed from: a */
    public void m21392a(boolean z) {
        this.f257b = z;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0236i
    /* renamed from: a */
    public boolean mo21246a() {
        return false;
    }

    /* renamed from: b */
    public void m21391b() {
        LogManager logManager = LogManager.getLogManager();
        Enumeration<String> loggerNames = logManager.getLoggerNames();
        while (loggerNames.hasMoreElements()) {
            String nextElement = loggerNames.nextElement();
            Logger logger = logManager.getLogger(nextElement);
            if (C0168a.m21395a(logger) && logger.getLevel() != null) {
                d("Setting level of jul logger [" + nextElement + "] to null");
                logger.setLevel(null);
            }
        }
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0236i
    /* renamed from: b */
    public void mo21243b(C0151f c0151f) {
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0236i
    /* renamed from: c */
    public void mo21242c(C0151f c0151f) {
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: g_ */
    public boolean mo20158g_() {
        return this.f256a;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        if (this.f257b) {
            m21391b();
        }
        m21389d();
        this.f256a = true;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: k */
    public void mo20155k() {
        this.f256a = false;
    }
}
