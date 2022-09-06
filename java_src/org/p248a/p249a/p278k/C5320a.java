package org.p248a.p249a.p278k;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.message.HeaderValueFormatter;
import org.apache.http.util.CharArrayBuffer;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.k.a */
/* loaded from: classes.dex */
public class C5320a implements HeaderValueFormatter {
    @Deprecated

    /* renamed from: a */
    public static final C5320a f22324a = new C5320a();

    /* renamed from: b */
    public static final C5320a f22325b = new C5320a();

    /* renamed from: c */
    public static final String f22326c = " ;,:@()<>\\\"/[]?={}\t";

    /* renamed from: d */
    public static final String f22327d = "\"\\";

    /* renamed from: a */
    public static String m1462a(HeaderElement headerElement, boolean z, HeaderValueFormatter headerValueFormatter) {
        if (headerValueFormatter == null) {
            headerValueFormatter = f22325b;
        }
        return headerValueFormatter.formatHeaderElement((CharArrayBuffer) null, headerElement, z).toString();
    }

    /* renamed from: a */
    public static String m1460a(NameValuePair nameValuePair, boolean z, HeaderValueFormatter headerValueFormatter) {
        if (headerValueFormatter == null) {
            headerValueFormatter = f22325b;
        }
        return headerValueFormatter.formatNameValuePair((CharArrayBuffer) null, nameValuePair, z).toString();
    }

    /* renamed from: a */
    public static String m1457a(HeaderElement[] headerElementArr, boolean z, HeaderValueFormatter headerValueFormatter) {
        if (headerValueFormatter == null) {
            headerValueFormatter = f22325b;
        }
        return headerValueFormatter.formatElements((CharArrayBuffer) null, headerElementArr, z).toString();
    }

    /* renamed from: a */
    public static String m1455a(NameValuePair[] nameValuePairArr, boolean z, HeaderValueFormatter headerValueFormatter) {
        if (headerValueFormatter == null) {
            headerValueFormatter = f22325b;
        }
        return headerValueFormatter.formatParameters((CharArrayBuffer) null, nameValuePairArr, z).toString();
    }

    /* renamed from: a */
    protected int m1463a(HeaderElement headerElement) {
        if (headerElement == null) {
            return 0;
        }
        int length = headerElement.getName().length();
        String value = headerElement.getValue();
        if (value != null) {
            length += value.length() + 3;
        }
        int parameterCount = headerElement.getParameterCount();
        if (parameterCount <= 0) {
            return length;
        }
        for (int i = 0; i < parameterCount; i++) {
            length += m1461a(headerElement.getParameter(i)) + 2;
        }
        return length;
    }

    /* renamed from: a */
    protected int m1461a(NameValuePair nameValuePair) {
        if (nameValuePair == null) {
            return 0;
        }
        int length = nameValuePair.getName().length();
        String value = nameValuePair.getValue();
        return value != null ? length + value.length() + 3 : length;
    }

    /* renamed from: a */
    protected int m1458a(HeaderElement[] headerElementArr) {
        int i = 0;
        if (headerElementArr != null && headerElementArr.length >= 1) {
            int length = headerElementArr.length;
            i = (headerElementArr.length - 1) * 2;
            int i2 = 0;
            while (i2 < length) {
                int m1463a = m1463a(headerElementArr[i2]) + i;
                i2++;
                i = m1463a;
            }
        }
        return i;
    }

    /* renamed from: a */
    protected int m1456a(NameValuePair[] nameValuePairArr) {
        int i = 0;
        if (nameValuePairArr != null && nameValuePairArr.length >= 1) {
            int length = nameValuePairArr.length;
            i = (nameValuePairArr.length - 1) * 2;
            int i2 = 0;
            while (i2 < length) {
                int m1461a = m1461a(nameValuePairArr[i2]) + i;
                i2++;
                i = m1461a;
            }
        }
        return i;
    }

    /* renamed from: a */
    protected void m1459a(CharArrayBuffer charArrayBuffer, String str, boolean z) {
        if (!z) {
            for (int i = 0; i < str.length() && !z; i++) {
                z = m1464a(str.charAt(i));
            }
        }
        if (z) {
            charArrayBuffer.append('\"');
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (m1454b(charAt)) {
                charArrayBuffer.append('\\');
            }
            charArrayBuffer.append(charAt);
        }
        if (z) {
            charArrayBuffer.append('\"');
        }
    }

    /* renamed from: a */
    protected boolean m1464a(char c) {
        return f22326c.indexOf(c) >= 0;
    }

    /* renamed from: b */
    protected boolean m1454b(char c) {
        return f22327d.indexOf(c) >= 0;
    }

    public CharArrayBuffer formatElements(CharArrayBuffer charArrayBuffer, HeaderElement[] headerElementArr, boolean z) {
        C5351a.m1321a(headerElementArr, "Header element array");
        int m1458a = m1458a(headerElementArr);
        if (charArrayBuffer == null) {
            charArrayBuffer = new CharArrayBuffer(m1458a);
        } else {
            charArrayBuffer.ensureCapacity(m1458a);
        }
        for (int i = 0; i < headerElementArr.length; i++) {
            if (i > 0) {
                charArrayBuffer.append(", ");
            }
            formatHeaderElement(charArrayBuffer, headerElementArr[i], z);
        }
        return charArrayBuffer;
    }

    public CharArrayBuffer formatHeaderElement(CharArrayBuffer charArrayBuffer, HeaderElement headerElement, boolean z) {
        C5351a.m1321a(headerElement, "Header element");
        int m1463a = m1463a(headerElement);
        if (charArrayBuffer == null) {
            charArrayBuffer = new CharArrayBuffer(m1463a);
        } else {
            charArrayBuffer.ensureCapacity(m1463a);
        }
        charArrayBuffer.append(headerElement.getName());
        String value = headerElement.getValue();
        if (value != null) {
            charArrayBuffer.append((char) SignatureVisitor.INSTANCEOF);
            m1459a(charArrayBuffer, value, z);
        }
        int parameterCount = headerElement.getParameterCount();
        if (parameterCount > 0) {
            for (int i = 0; i < parameterCount; i++) {
                charArrayBuffer.append("; ");
                formatNameValuePair(charArrayBuffer, headerElement.getParameter(i), z);
            }
        }
        return charArrayBuffer;
    }

    public CharArrayBuffer formatNameValuePair(CharArrayBuffer charArrayBuffer, NameValuePair nameValuePair, boolean z) {
        C5351a.m1321a(nameValuePair, "Name / value pair");
        int m1461a = m1461a(nameValuePair);
        if (charArrayBuffer == null) {
            charArrayBuffer = new CharArrayBuffer(m1461a);
        } else {
            charArrayBuffer.ensureCapacity(m1461a);
        }
        charArrayBuffer.append(nameValuePair.getName());
        String value = nameValuePair.getValue();
        if (value != null) {
            charArrayBuffer.append((char) SignatureVisitor.INSTANCEOF);
            m1459a(charArrayBuffer, value, z);
        }
        return charArrayBuffer;
    }

    public CharArrayBuffer formatParameters(CharArrayBuffer charArrayBuffer, NameValuePair[] nameValuePairArr, boolean z) {
        C5351a.m1321a(nameValuePairArr, "Header parameter array");
        int m1456a = m1456a(nameValuePairArr);
        if (charArrayBuffer == null) {
            charArrayBuffer = new CharArrayBuffer(m1456a);
        } else {
            charArrayBuffer.ensureCapacity(m1456a);
        }
        for (int i = 0; i < nameValuePairArr.length; i++) {
            if (i > 0) {
                charArrayBuffer.append("; ");
            }
            formatNameValuePair(charArrayBuffer, nameValuePairArr[i], z);
        }
        return charArrayBuffer;
    }
}
