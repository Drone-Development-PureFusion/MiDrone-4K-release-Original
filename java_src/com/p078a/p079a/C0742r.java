package com.p078a.p079a;

import java.util.zip.ZipException;
/* renamed from: com.a.a.r */
/* loaded from: classes.dex */
public class C0742r extends ZipException {

    /* renamed from: a */
    static final String f1841a = "archive's size exceeds the limit of 4GByte.";

    /* renamed from: b */
    static final String f1842b = "archive contains more than 65535 entries.";
    private static final long serialVersionUID = 20110809;

    public C0742r(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m19212a(C0748w c0748w) {
        return String.valueOf(c0748w.getName()) + "'s size exceeds the limit of 4GByte.";
    }
}
