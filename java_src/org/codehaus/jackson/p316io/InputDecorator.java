package org.codehaus.jackson.p316io;

import java.io.InputStream;
import java.io.Reader;
/* renamed from: org.codehaus.jackson.io.InputDecorator */
/* loaded from: classes2.dex */
public abstract class InputDecorator {
    public abstract InputStream decorate(IOContext iOContext, InputStream inputStream);

    public abstract InputStream decorate(IOContext iOContext, byte[] bArr, int i, int i2);

    public abstract Reader decorate(IOContext iOContext, Reader reader);
}
