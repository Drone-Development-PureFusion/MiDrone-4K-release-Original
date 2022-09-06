package com.tencent.stat.p232a;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.Properties;
/* renamed from: com.tencent.stat.a.c */
/* loaded from: classes2.dex */
public class C4399c {

    /* renamed from: a */
    String f18366a;

    /* renamed from: b */
    String[] f18367b;

    /* renamed from: c */
    Properties f18368c;

    public C4399c() {
        this.f18368c = null;
    }

    public C4399c(String str, String[] strArr, Properties properties) {
        this.f18368c = null;
        this.f18366a = str;
        this.f18367b = strArr;
        this.f18368c = properties;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4399c)) {
            return false;
        }
        C4399c c4399c = (C4399c) obj;
        boolean z = this.f18366a.equals(c4399c.f18366a) && Arrays.equals(this.f18367b, c4399c.f18367b);
        return this.f18368c != null ? z && this.f18368c.equals(c4399c.f18368c) : z && c4399c.f18368c == null;
    }

    public int hashCode() {
        int i = 0;
        if (this.f18366a != null) {
            i = this.f18366a.hashCode();
        }
        if (this.f18367b != null) {
            i ^= Arrays.hashCode(this.f18367b);
        }
        return this.f18368c != null ? i ^ this.f18368c.hashCode() : i;
    }

    public String toString() {
        String str = this.f18366a;
        String str2 = "";
        if (this.f18367b != null) {
            String str3 = this.f18367b[0];
            for (int i = 1; i < this.f18367b.length; i++) {
                str3 = str3 + Constants.ACCEPT_TIME_SEPARATOR_SP + this.f18367b[i];
            }
            str2 = "[" + str3 + "]";
        }
        if (this.f18368c != null) {
            str2 = str2 + this.f18368c.toString();
        }
        return str + str2;
    }
}
