package org.p248a.p249a.p268i.p275g;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpMessage;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.LineParser;
import org.apache.http.params.HttpParams;
import org.apache.http.util.CharArrayBuffer;
import org.p248a.p249a.C5093f;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p260e.C5087c;
import org.p248a.p249a.p261f.p264c.C5122l;
import org.p248a.p249a.p278k.C5323d;
import org.p248a.p249a.p279l.C5324a;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.i.g.a */
/* loaded from: classes.dex */
public abstract class AbstractC5292a<T extends HttpMessage> implements HttpMessageParser {

    /* renamed from: b */
    private static final int f22237b = 0;

    /* renamed from: c */
    private static final int f22238c = 1;

    /* renamed from: a */
    protected final LineParser f22239a;

    /* renamed from: d */
    private final SessionInputBuffer f22240d;

    /* renamed from: e */
    private final C5087c f22241e;

    /* renamed from: f */
    private final List<CharArrayBuffer> f22242f;

    /* renamed from: g */
    private int f22243g;

    /* renamed from: h */
    private T f22244h;

    public AbstractC5292a(SessionInputBuffer sessionInputBuffer, LineParser lineParser, C5087c c5087c) {
        this.f22240d = (SessionInputBuffer) C5351a.m1321a(sessionInputBuffer, "Session input buffer");
        this.f22239a = lineParser == null ? C5323d.f22336b : lineParser;
        this.f22241e = c5087c == null ? C5087c.f21705a : c5087c;
        this.f22242f = new ArrayList();
        this.f22243g = 0;
    }

    @Deprecated
    public AbstractC5292a(SessionInputBuffer sessionInputBuffer, LineParser lineParser, HttpParams httpParams) {
        C5351a.m1321a(sessionInputBuffer, "Session input buffer");
        C5351a.m1321a(httpParams, "HTTP parameters");
        this.f22240d = sessionInputBuffer;
        this.f22241e = C5324a.m1427b(httpParams);
        this.f22239a = lineParser == null ? C5323d.f22336b : lineParser;
        this.f22242f = new ArrayList();
        this.f22243g = 0;
    }

    /* renamed from: a */
    public static Header[] m1507a(SessionInputBuffer sessionInputBuffer, int i, int i2, LineParser lineParser) {
        ArrayList arrayList = new ArrayList();
        if (lineParser == null) {
            lineParser = C5323d.f22336b;
        }
        return m1506a(sessionInputBuffer, i, i2, lineParser, arrayList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x002e, code lost:
        r1 = new org.apache.http.Header[r13.size()];
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0038, code lost:
        if (r2 >= r13.size()) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0040, code lost:
        r1[r2] = r12.parseHeader(r13.get(r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0046, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ab, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b5, code lost:
        throw new org.apache.http.ProtocolException(r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b6, code lost:
        return r1;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Header[] m1506a(SessionInputBuffer sessionInputBuffer, int i, int i2, LineParser lineParser, List<CharArrayBuffer> list) {
        CharArrayBuffer charArrayBuffer;
        char charAt;
        int i3 = 0;
        C5351a.m1321a(sessionInputBuffer, "Session input buffer");
        C5351a.m1321a(lineParser, "Line parser");
        C5351a.m1321a(list, "Header line list");
        CharArrayBuffer charArrayBuffer2 = null;
        CharArrayBuffer charArrayBuffer3 = null;
        while (true) {
            if (charArrayBuffer3 == null) {
                charArrayBuffer3 = new CharArrayBuffer(64);
            } else {
                charArrayBuffer3.clear();
            }
            if (sessionInputBuffer.readLine(charArrayBuffer3) == -1 || charArrayBuffer3.length() < 1) {
                break;
            }
            if ((charArrayBuffer3.charAt(0) == ' ' || charArrayBuffer3.charAt(0) == '\t') && charArrayBuffer2 != null) {
                int i4 = 0;
                while (i4 < charArrayBuffer3.length() && ((charAt = charArrayBuffer3.charAt(i4)) == ' ' || charAt == '\t')) {
                    i4++;
                }
                if (i2 > 0 && ((charArrayBuffer2.length() + 1) + charArrayBuffer3.length()) - i4 > i2) {
                    throw new C5093f("Maximum line length limit exceeded");
                }
                charArrayBuffer2.append((char) C5122l.f21763c);
                charArrayBuffer2.append(charArrayBuffer3, i4, charArrayBuffer3.length() - i4);
                charArrayBuffer = charArrayBuffer3;
                charArrayBuffer3 = charArrayBuffer2;
            } else {
                list.add(charArrayBuffer3);
                charArrayBuffer = null;
            }
            if (i > 0 && list.size() >= i) {
                throw new C5093f("Maximum header count exceeded");
            }
            charArrayBuffer2 = charArrayBuffer3;
            charArrayBuffer3 = charArrayBuffer;
        }
    }

    /* renamed from: b */
    protected abstract T mo1495b(SessionInputBuffer sessionInputBuffer);

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public T parse() {
        switch (this.f22243g) {
            case 0:
                try {
                    this.f22244h = mo1495b(this.f22240d);
                    this.f22243g = 1;
                    break;
                } catch (ParseException e) {
                    throw new ProtocolException(e.getMessage(), e);
                }
            case 1:
                break;
            default:
                throw new IllegalStateException("Inconsistent parser state");
        }
        this.f22244h.setHeaders(m1506a(this.f22240d, this.f22241e.m2049b(), this.f22241e.m2052a(), this.f22239a, this.f22242f));
        T t = this.f22244h;
        this.f22244h = null;
        this.f22242f.clear();
        this.f22243g = 0;
        return t;
    }
}
