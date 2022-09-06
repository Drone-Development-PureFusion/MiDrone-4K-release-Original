package org.p248a.p249a.p252c.p258f;

import java.io.Closeable;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.p248a.p249a.p252c.p255c.AbstractC5035b;
import org.p248a.p249a.p282o.C5354d;
/* renamed from: org.a.a.c.f.c */
/* loaded from: classes2.dex */
public class C5071c {
    private C5071c() {
    }

    /* renamed from: a */
    public static void m2146a(AbstractC5035b abstractC5035b) {
        if (abstractC5035b != null) {
            try {
                C5354d.m1303b(abstractC5035b.getEntity());
                abstractC5035b.close();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: a */
    public static void m2145a(HttpResponse httpResponse) {
        HttpEntity entity;
        if (httpResponse == null || (entity = httpResponse.getEntity()) == null) {
            return;
        }
        try {
            C5354d.m1303b(entity);
        } catch (IOException e) {
        }
    }

    /* renamed from: a */
    public static void m2144a(HttpClient httpClient) {
        if (httpClient == null || !(httpClient instanceof Closeable)) {
            return;
        }
        try {
            ((Closeable) httpClient).close();
        } catch (IOException e) {
        }
    }
}
