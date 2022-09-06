package org.p248a.p249a.p252c.p255c;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.AbortableHttpRequest;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionReleaseTrigger;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.HeaderGroup;
import org.apache.http.params.HttpParams;
import org.p248a.p249a.p252c.p258f.C5067a;
import org.p248a.p249a.p259d.AbstractC5081b;
/* renamed from: org.a.a.c.c.a */
/* loaded from: classes.dex */
public abstract class AbstractC5032a extends AbstractHttpMessage implements Cloneable, AbstractC5039f, HttpRequest, AbortableHttpRequest {

    /* renamed from: a */
    private final AtomicBoolean f21534a = new AtomicBoolean(false);

    /* renamed from: b */
    private final AtomicReference<AbstractC5081b> f21535b = new AtomicReference<>(null);

    /* renamed from: a */
    public void m2233a() {
        this.f21535b.set(null);
    }

    @Override // org.p248a.p249a.p252c.p255c.AbstractC5039f
    /* renamed from: a */
    public void mo2231a(AbstractC5081b abstractC5081b) {
        if (!this.f21534a.get()) {
            this.f21535b.set(abstractC5081b);
        }
    }

    public void abort() {
        AbstractC5081b andSet;
        if (!this.f21534a.compareAndSet(false, true) || (andSet = this.f21535b.getAndSet(null)) == null) {
            return;
        }
        andSet.mo1532a();
    }

    /* renamed from: b */
    public void m2232b() {
        AbstractC5081b andSet = this.f21535b.getAndSet(null);
        if (andSet != null) {
            andSet.mo1532a();
        }
        this.f21534a.set(false);
    }

    public Object clone() {
        AbstractC5032a abstractC5032a = (AbstractC5032a) super.clone();
        abstractC5032a.headergroup = (HeaderGroup) C5067a.m2157a(this.headergroup);
        abstractC5032a.params = (HttpParams) C5067a.m2157a(this.params);
        return abstractC5032a;
    }

    @Override // org.p248a.p249a.p252c.p255c.AbstractC5039f
    public boolean isAborted() {
        return this.f21534a.get();
    }

    @Deprecated
    public void setConnectionRequest(final ClientConnectionRequest clientConnectionRequest) {
        mo2231a(new AbstractC5081b() { // from class: org.a.a.c.c.a.1
            @Override // org.p248a.p249a.p259d.AbstractC5081b
            /* renamed from: a */
            public boolean mo1532a() {
                clientConnectionRequest.abortRequest();
                return true;
            }
        });
    }

    @Deprecated
    public void setReleaseTrigger(final ConnectionReleaseTrigger connectionReleaseTrigger) {
        mo2231a(new AbstractC5081b() { // from class: org.a.a.c.c.a.2
            @Override // org.p248a.p249a.p259d.AbstractC5081b
            /* renamed from: a */
            public boolean mo1532a() {
                try {
                    connectionReleaseTrigger.abortConnection();
                    return true;
                } catch (IOException e) {
                    return false;
                }
            }
        });
    }
}
