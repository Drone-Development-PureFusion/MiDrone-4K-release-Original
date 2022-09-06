package org.p248a.p249a.p282o;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
/* renamed from: org.a.a.o.c */
/* loaded from: classes2.dex */
public class C5353c {
    /* renamed from: a */
    public static Charset m1309a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Charset.forName(str);
        } catch (UnsupportedCharsetException e) {
            return null;
        }
    }

    /* renamed from: b */
    public static Charset m1308b(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Charset.forName(str);
        } catch (UnsupportedCharsetException e) {
            throw new UnsupportedEncodingException(str);
        }
    }
}
