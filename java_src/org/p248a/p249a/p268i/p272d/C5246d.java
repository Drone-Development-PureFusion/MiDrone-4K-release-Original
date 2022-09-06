package org.p248a.p249a.p268i.p272d;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.SetCookie;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.i.d.d */
/* loaded from: classes2.dex */
public class C5246d implements Serializable, Cloneable, ClientCookie, SetCookie {
    private static final long serialVersionUID = -3869795591041535538L;

    /* renamed from: a */
    private final String f22139a;

    /* renamed from: b */
    private Map<String, String> f22140b = new HashMap();

    /* renamed from: c */
    private String f22141c;

    /* renamed from: d */
    private String f22142d;

    /* renamed from: e */
    private String f22143e;

    /* renamed from: f */
    private Date f22144f;

    /* renamed from: g */
    private String f22145g;

    /* renamed from: h */
    private boolean f22146h;

    /* renamed from: i */
    private int f22147i;

    public C5246d(String str, String str2) {
        C5351a.m1321a(str, "Name");
        this.f22139a = str;
        this.f22141c = str2;
    }

    /* renamed from: a */
    public void m1554a(String str, String str2) {
        this.f22140b.put(str, str2);
    }

    public Object clone() {
        C5246d c5246d = (C5246d) super.clone();
        c5246d.f22140b = new HashMap(this.f22140b);
        return c5246d;
    }

    public boolean containsAttribute(String str) {
        return this.f22140b.get(str) != null;
    }

    public String getAttribute(String str) {
        return this.f22140b.get(str);
    }

    public String getComment() {
        return this.f22142d;
    }

    public String getCommentURL() {
        return null;
    }

    public String getDomain() {
        return this.f22143e;
    }

    public Date getExpiryDate() {
        return this.f22144f;
    }

    public String getName() {
        return this.f22139a;
    }

    public String getPath() {
        return this.f22145g;
    }

    public int[] getPorts() {
        return null;
    }

    public String getValue() {
        return this.f22141c;
    }

    public int getVersion() {
        return this.f22147i;
    }

    public boolean isExpired(Date date) {
        C5351a.m1321a(date, "Date");
        return this.f22144f != null && this.f22144f.getTime() <= date.getTime();
    }

    public boolean isPersistent() {
        return this.f22144f != null;
    }

    public boolean isSecure() {
        return this.f22146h;
    }

    public void setComment(String str) {
        this.f22142d = str;
    }

    public void setDomain(String str) {
        if (str != null) {
            this.f22143e = str.toLowerCase(Locale.ENGLISH);
        } else {
            this.f22143e = null;
        }
    }

    public void setExpiryDate(Date date) {
        this.f22144f = date;
    }

    public void setPath(String str) {
        this.f22145g = str;
    }

    public void setSecure(boolean z) {
        this.f22146h = z;
    }

    public void setValue(String str) {
        this.f22141c = str;
    }

    public void setVersion(int i) {
        this.f22147i = i;
    }

    public String toString() {
        return "[version: " + Integer.toString(this.f22147i) + "][name: " + this.f22139a + "][value: " + this.f22141c + "][domain: " + this.f22143e + "][path: " + this.f22145g + "][expiry: " + this.f22144f + "]";
    }
}
