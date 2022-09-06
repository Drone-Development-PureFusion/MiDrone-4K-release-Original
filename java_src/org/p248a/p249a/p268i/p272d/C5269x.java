package org.p248a.p249a.p268i.p272d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import org.p248a.p249a.p250a.AbstractC5005b;
@AbstractC5005b
/* renamed from: org.a.a.i.d.x */
/* loaded from: classes2.dex */
public class C5269x {

    /* renamed from: a */
    private static final int f22172a = 256;

    /* renamed from: b */
    private final C5268w f22173b;

    C5269x(C5268w c5268w) {
        this.f22173b = c5268w;
    }

    /* renamed from: a */
    private boolean m1539a(Reader reader, StringBuilder sb) {
        char c;
        sb.setLength(0);
        boolean z = false;
        do {
            int read = reader.read();
            if (read == -1 || (c = (char) read) == '\n') {
                return read != -1;
            }
            if (Character.isWhitespace(c)) {
                z = true;
            }
            if (!z) {
                sb.append(c);
            }
        } while (sb.length() <= 256);
        throw new IOException("Line too long");
    }

    /* renamed from: a */
    public void m1540a(Reader reader) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder(256);
        boolean z = true;
        while (z) {
            boolean m1539a = m1539a(bufferedReader, sb);
            String sb2 = sb.toString();
            if (sb2.length() == 0) {
                z = m1539a;
            } else if (sb2.startsWith("//")) {
                z = m1539a;
            } else {
                if (sb2.startsWith(".")) {
                    sb2 = sb2.substring(1);
                }
                boolean startsWith = sb2.startsWith("!");
                if (startsWith) {
                    sb2 = sb2.substring(1);
                }
                if (startsWith) {
                    arrayList2.add(sb2);
                } else {
                    arrayList.add(sb2);
                }
                z = m1539a;
            }
        }
        this.f22173b.m1543a(arrayList);
        this.f22173b.m1541b(arrayList2);
    }
}
