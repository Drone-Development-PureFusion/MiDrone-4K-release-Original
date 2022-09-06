package org.p248a.p249a.p268i.p272d;

import java.util.Date;
import org.apache.http.cookie.SetCookie2;
import org.p248a.p249a.p250a.AbstractC5006c;
@AbstractC5006c
/* renamed from: org.a.a.i.d.c */
/* loaded from: classes2.dex */
public class C5245c extends C5246d implements SetCookie2 {
    private static final long serialVersionUID = -7744598295706617057L;

    /* renamed from: a */
    private String f22136a;

    /* renamed from: b */
    private int[] f22137b;

    /* renamed from: c */
    private boolean f22138c;

    public C5245c(String str, String str2) {
        super(str, str2);
    }

    @Override // org.p248a.p249a.p268i.p272d.C5246d
    public Object clone() {
        C5245c c5245c = (C5245c) super.clone();
        if (this.f22137b != null) {
            c5245c.f22137b = (int[]) this.f22137b.clone();
        }
        return c5245c;
    }

    @Override // org.p248a.p249a.p268i.p272d.C5246d
    public String getCommentURL() {
        return this.f22136a;
    }

    @Override // org.p248a.p249a.p268i.p272d.C5246d
    public int[] getPorts() {
        return this.f22137b;
    }

    @Override // org.p248a.p249a.p268i.p272d.C5246d
    public boolean isExpired(Date date) {
        return this.f22138c || super.isExpired(date);
    }

    @Override // org.p248a.p249a.p268i.p272d.C5246d
    public boolean isPersistent() {
        return !this.f22138c && super.isPersistent();
    }

    public void setCommentURL(String str) {
        this.f22136a = str;
    }

    public void setDiscard(boolean z) {
        this.f22138c = z;
    }

    public void setPorts(int[] iArr) {
        this.f22137b = iArr;
    }
}
