package com.xiaomi.smack.packet;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.smack.util.C4746d;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* renamed from: com.xiaomi.smack.packet.a */
/* loaded from: classes.dex */
public class C4728a implements AbstractC4733e {

    /* renamed from: a */
    private String f19411a;

    /* renamed from: b */
    private String f19412b;

    /* renamed from: c */
    private String[] f19413c;

    /* renamed from: d */
    private String[] f19414d;

    /* renamed from: e */
    private String f19415e;

    /* renamed from: f */
    private List<C4728a> f19416f;

    public C4728a(String str, String str2, String[] strArr, String[] strArr2) {
        this.f19413c = null;
        this.f19414d = null;
        this.f19416f = null;
        this.f19411a = str;
        this.f19412b = str2;
        this.f19413c = strArr;
        this.f19414d = strArr2;
    }

    public C4728a(String str, String str2, String[] strArr, String[] strArr2, String str3, List<C4728a> list) {
        this.f19413c = null;
        this.f19414d = null;
        this.f19416f = null;
        this.f19411a = str;
        this.f19412b = str2;
        this.f19413c = strArr;
        this.f19414d = strArr2;
        this.f19415e = str3;
        this.f19416f = list;
    }

    /* renamed from: a */
    public static C4728a m3923a(Bundle bundle) {
        ArrayList arrayList;
        String string = bundle.getString("ext_ele_name");
        String string2 = bundle.getString("ext_ns");
        String string3 = bundle.getString("ext_text");
        Bundle bundle2 = bundle.getBundle("attributes");
        Set<String> keySet = bundle2.keySet();
        String[] strArr = new String[keySet.size()];
        String[] strArr2 = new String[keySet.size()];
        int i = 0;
        for (String str : keySet) {
            strArr[i] = str;
            strArr2[i] = bundle2.getString(str);
            i++;
        }
        if (bundle.containsKey("children")) {
            Parcelable[] parcelableArray = bundle.getParcelableArray("children");
            arrayList = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList.add(m3923a((Bundle) parcelable));
            }
        } else {
            arrayList = null;
        }
        return new C4728a(string, string2, strArr, strArr2, string3, arrayList);
    }

    /* renamed from: a */
    public static Parcelable[] m3921a(List<C4728a> list) {
        return m3920a((C4728a[]) list.toArray(new C4728a[list.size()]));
    }

    /* renamed from: a */
    public static Parcelable[] m3920a(C4728a[] c4728aArr) {
        if (c4728aArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[c4728aArr.length];
        for (int i = 0; i < c4728aArr.length; i++) {
            parcelableArr[i] = c4728aArr[i].m3915f();
        }
        return parcelableArr;
    }

    /* renamed from: a */
    public String m3924a() {
        return this.f19411a;
    }

    /* renamed from: a */
    public String m3922a(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (this.f19413c != null) {
            for (int i = 0; i < this.f19413c.length; i++) {
                if (str.equals(this.f19413c[i])) {
                    return this.f19414d[i];
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public String m3919b() {
        return this.f19412b;
    }

    /* renamed from: b */
    public void m3918b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f19415e = C4746d.m3838a(str);
        } else {
            this.f19415e = str;
        }
    }

    /* renamed from: c */
    public String m3917c() {
        return !TextUtils.isEmpty(this.f19415e) ? C4746d.m3835b(this.f19415e) : this.f19415e;
    }

    @Override // com.xiaomi.smack.packet.AbstractC4733e
    /* renamed from: d */
    public String mo3868d() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(this.f19411a);
        if (!TextUtils.isEmpty(this.f19412b)) {
            sb.append(" ").append("xmlns=").append("\"").append(this.f19412b).append("\"");
        }
        if (this.f19413c != null && this.f19413c.length > 0) {
            for (int i = 0; i < this.f19413c.length; i++) {
                if (!TextUtils.isEmpty(this.f19414d[i])) {
                    sb.append(" ").append(this.f19413c[i]).append("=\"").append(C4746d.m3838a(this.f19414d[i])).append("\"");
                }
            }
        }
        if (!TextUtils.isEmpty(this.f19415e)) {
            sb.append(">").append(this.f19415e).append("</").append(this.f19411a).append(">");
        } else if (this.f19416f == null || this.f19416f.size() <= 0) {
            sb.append("/>");
        } else {
            sb.append(">");
            for (C4728a c4728a : this.f19416f) {
                sb.append(c4728a.mo3868d());
            }
            sb.append("</").append(this.f19411a).append(">");
        }
        return sb.toString();
    }

    /* renamed from: e */
    public Bundle m3916e() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.f19411a);
        bundle.putString("ext_ns", this.f19412b);
        bundle.putString("ext_text", this.f19415e);
        Bundle bundle2 = new Bundle();
        if (this.f19413c != null && this.f19413c.length > 0) {
            for (int i = 0; i < this.f19413c.length; i++) {
                bundle2.putString(this.f19413c[i], this.f19414d[i]);
            }
        }
        bundle.putBundle("attributes", bundle2);
        if (this.f19416f != null && this.f19416f.size() > 0) {
            bundle.putParcelableArray("children", m3921a(this.f19416f));
        }
        return bundle;
    }

    /* renamed from: f */
    public Parcelable m3915f() {
        return m3916e();
    }

    public String toString() {
        return mo3868d();
    }
}
