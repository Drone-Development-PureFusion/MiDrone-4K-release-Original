package com.p118d.p119a.p127b.p132d;

import com.facebook.common.util.UriUtil;
import java.io.InputStream;
import java.util.Locale;
/* renamed from: com.d.a.b.d.b */
/* loaded from: classes.dex */
public interface AbstractC1919b {

    /* renamed from: com.d.a.b.d.b$a */
    /* loaded from: classes.dex */
    public enum EnumC1920a {
        HTTP(UriUtil.HTTP_SCHEME),
        HTTPS(UriUtil.HTTPS_SCHEME),
        FILE("file"),
        CONTENT("content"),
        ASSETS("assets"),
        DRAWABLE("drawable"),
        UNKNOWN("");
        

        /* renamed from: h */
        private String f6798h;

        /* renamed from: i */
        private String f6799i;

        EnumC1920a(String str) {
            this.f6798h = str;
            this.f6799i = str + "://";
        }

        /* renamed from: a */
        public static EnumC1920a m13982a(String str) {
            EnumC1920a[] values;
            if (str != null) {
                for (EnumC1920a enumC1920a : values()) {
                    if (enumC1920a.m13979d(str)) {
                        return enumC1920a;
                    }
                }
            }
            return UNKNOWN;
        }

        /* renamed from: d */
        private boolean m13979d(String str) {
            return str.toLowerCase(Locale.US).startsWith(this.f6799i);
        }

        /* renamed from: b */
        public String m13981b(String str) {
            return this.f6799i + str;
        }

        /* renamed from: c */
        public String m13980c(String str) {
            if (!m13979d(str)) {
                throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", str, this.f6798h));
            }
            return str.substring(this.f6799i.length());
        }
    }

    /* renamed from: a */
    InputStream mo13929a(String str, Object obj);
}
