package org.p248a.p249a.p267h;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
import org.p248a.p249a.p250a.AbstractC5006c;
@AbstractC5006c
/* renamed from: org.a.a.h.a */
/* loaded from: classes.dex */
public abstract class AbstractC5136a implements HttpEntity {

    /* renamed from: a */
    protected static final int f21776a = 4096;

    /* renamed from: b */
    protected Header f21777b;

    /* renamed from: c */
    protected Header f21778c;

    /* renamed from: d */
    protected boolean f21779d;

    /* renamed from: a */
    public void m1954a(String str) {
        BasicHeader basicHeader = null;
        if (str != null) {
            basicHeader = new BasicHeader("Content-Type", str);
        }
        m1953a((Header) basicHeader);
    }

    /* renamed from: a */
    public void m1953a(Header header) {
        this.f21777b = header;
    }

    /* renamed from: a */
    public void m1952a(boolean z) {
        this.f21779d = z;
    }

    /* renamed from: b */
    public void m1951b(String str) {
        BasicHeader basicHeader = null;
        if (str != null) {
            basicHeader = new BasicHeader("Content-Encoding", str);
        }
        m1950b((Header) basicHeader);
    }

    /* renamed from: b */
    public void m1950b(Header header) {
        this.f21778c = header;
    }

    @Deprecated
    public void consumeContent() {
    }

    public Header getContentEncoding() {
        return this.f21778c;
    }

    public Header getContentType() {
        return this.f21777b;
    }

    public boolean isChunked() {
        return this.f21779d;
    }
}
