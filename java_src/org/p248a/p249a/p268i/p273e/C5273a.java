package org.p248a.p249a.p268i.p273e;

import org.apache.http.HttpMessage;
import org.apache.http.ProtocolException;
import org.apache.http.entity.ContentLengthStrategy;
import org.p248a.p249a.p250a.AbstractC5005b;
@AbstractC5005b
/* renamed from: org.a.a.i.e.a */
/* loaded from: classes2.dex */
public class C5273a implements ContentLengthStrategy {

    /* renamed from: a */
    public static final C5273a f22178a = new C5273a(new C5274b(0));

    /* renamed from: b */
    private final ContentLengthStrategy f22179b;

    public C5273a(ContentLengthStrategy contentLengthStrategy) {
        this.f22179b = contentLengthStrategy;
    }

    public long determineLength(HttpMessage httpMessage) {
        long determineLength = this.f22179b.determineLength(httpMessage);
        if (determineLength == -1) {
            throw new ProtocolException("Identity transfer encoding cannot be used");
        }
        return determineLength;
    }
}
