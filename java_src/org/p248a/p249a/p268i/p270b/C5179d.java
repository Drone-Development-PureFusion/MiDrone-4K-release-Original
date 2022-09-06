package org.p248a.p249a.p268i.p270b;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieIdentityComparator;
import org.p248a.p249a.p250a.AbstractC5004a;
import org.p248a.p249a.p250a.AbstractC5007d;
@AbstractC5007d
/* renamed from: org.a.a.i.b.d */
/* loaded from: classes2.dex */
public class C5179d implements Serializable, CookieStore {
    private static final long serialVersionUID = -7581093305228232025L;
    @AbstractC5004a(m2313a = "this")

    /* renamed from: a */
    private final TreeSet<Cookie> f21949a = new TreeSet<>((Comparator<? super Cookie>) new CookieIdentityComparator());

    /* renamed from: a */
    public synchronized void m1774a(Cookie[] cookieArr) {
        if (cookieArr != null) {
            for (Cookie cookie : cookieArr) {
                addCookie(cookie);
            }
        }
    }

    public synchronized void addCookie(Cookie cookie) {
        if (cookie != null) {
            this.f21949a.remove(cookie);
            if (!cookie.isExpired(new Date())) {
                this.f21949a.add(cookie);
            }
        }
    }

    public synchronized void clear() {
        this.f21949a.clear();
    }

    public synchronized boolean clearExpired(Date date) {
        boolean z = false;
        synchronized (this) {
            if (date != null) {
                Iterator<Cookie> it2 = this.f21949a.iterator();
                boolean z2 = false;
                while (it2.hasNext()) {
                    if (it2.next().isExpired(date)) {
                        it2.remove();
                        z2 = true;
                    }
                }
                z = z2;
            }
        }
        return z;
    }

    public synchronized List<Cookie> getCookies() {
        return new ArrayList(this.f21949a);
    }

    public synchronized String toString() {
        return this.f21949a.toString();
    }
}
