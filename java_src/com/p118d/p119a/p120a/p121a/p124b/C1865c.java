package com.p118d.p119a.p120a.p121a.p124b;

import com.p118d.p119a.p136c.C1949d;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* renamed from: com.d.a.a.a.b.c */
/* loaded from: classes.dex */
public class C1865c implements AbstractC1863a {

    /* renamed from: a */
    private static final String f6609a = "MD5";

    /* renamed from: b */
    private static final int f6610b = 36;

    /* renamed from: a */
    private byte[] m14214a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(f6609a);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            C1949d.m13853a(e);
            return null;
        }
    }

    @Override // com.p118d.p119a.p120a.p121a.p124b.AbstractC1863a
    /* renamed from: a */
    public String mo14215a(String str) {
        return new BigInteger(m14214a(str.getBytes())).abs().toString(36);
    }
}
