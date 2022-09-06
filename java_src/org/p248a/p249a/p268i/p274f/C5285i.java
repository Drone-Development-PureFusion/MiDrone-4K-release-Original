package org.p248a.p249a.p268i.p274f;

import java.io.InterruptedIOException;
import org.p248a.p249a.p250a.AbstractC5005b;
@AbstractC5005b
/* renamed from: org.a.a.i.f.i */
/* loaded from: classes2.dex */
public class C5285i extends InterruptedIOException {
    private static final long serialVersionUID = 4973849966012490112L;

    public C5285i(String str) {
        super(str);
    }

    public C5285i(String str, Throwable th) {
        super(str);
        if (th != null) {
            initCause(th);
        }
    }
}
