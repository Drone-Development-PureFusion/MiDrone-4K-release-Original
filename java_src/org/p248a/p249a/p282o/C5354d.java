package org.p248a.p249a.p282o;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;
import org.p248a.p249a.p267h.C5140e;
/* renamed from: org.a.a.o.d */
/* loaded from: classes.dex */
public final class C5354d {
    private C5354d() {
    }

    /* renamed from: a */
    public static String m1306a(HttpEntity httpEntity, String str) {
        return m1305a(httpEntity, str != null ? Charset.forName(str) : null);
    }

    /* renamed from: a */
    public static String m1305a(HttpEntity httpEntity, Charset charset) {
        String str = null;
        Charset charset2 = null;
        boolean z = false;
        C5351a.m1321a(httpEntity, "Entity");
        InputStream content = httpEntity.getContent();
        if (content != null) {
            try {
                if (httpEntity.getContentLength() <= 2147483647L) {
                    z = true;
                }
                C5351a.m1319a(z, "HTTP entity too large to be buffered in memory");
                int contentLength = (int) httpEntity.getContentLength();
                if (contentLength < 0) {
                    contentLength = 4096;
                }
                try {
                    C5140e m1941a = C5140e.m1941a(httpEntity);
                    if (m1941a != null) {
                        charset2 = m1941a.m1940b();
                    }
                    if (charset2 == null) {
                        charset2 = charset;
                    }
                    if (charset2 == null) {
                        charset2 = Charset.forName("ISO-8859-1");
                    }
                    InputStreamReader inputStreamReader = new InputStreamReader(content, charset2);
                    CharArrayBuffer charArrayBuffer = new CharArrayBuffer(contentLength);
                    char[] cArr = new char[1024];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read == -1) {
                            break;
                        }
                        charArrayBuffer.append(cArr, 0, read);
                    }
                    str = charArrayBuffer.toString();
                } catch (UnsupportedCharsetException e) {
                    throw new UnsupportedEncodingException(e.getMessage());
                }
            } finally {
                content.close();
            }
        }
        return str;
    }

    /* renamed from: a */
    public static void m1307a(HttpEntity httpEntity) {
        try {
            m1303b(httpEntity);
        } catch (IOException e) {
        }
    }

    /* renamed from: a */
    public static void m1304a(HttpResponse httpResponse, HttpEntity httpEntity) {
        C5351a.m1321a(httpResponse, "Response");
        m1303b(httpResponse.getEntity());
        httpResponse.setEntity(httpEntity);
    }

    /* renamed from: b */
    public static void m1303b(HttpEntity httpEntity) {
        InputStream content;
        if (httpEntity == null || !httpEntity.isStreaming() || (content = httpEntity.getContent()) == null) {
            return;
        }
        content.close();
    }

    /* renamed from: c */
    public static byte[] m1302c(HttpEntity httpEntity) {
        int i = 4096;
        boolean z = false;
        C5351a.m1321a(httpEntity, "Entity");
        InputStream content = httpEntity.getContent();
        if (content == null) {
            return null;
        }
        try {
            if (httpEntity.getContentLength() <= 2147483647L) {
                z = true;
            }
            C5351a.m1319a(z, "HTTP entity too large to be buffered in memory");
            int contentLength = (int) httpEntity.getContentLength();
            if (contentLength >= 0) {
                i = contentLength;
            }
            ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(i);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = content.read(bArr);
                if (read == -1) {
                    return byteArrayBuffer.toByteArray();
                }
                byteArrayBuffer.append(bArr, 0, read);
            }
        } finally {
            content.close();
        }
    }

    @Deprecated
    /* renamed from: d */
    public static String m1301d(HttpEntity httpEntity) {
        NameValuePair parameterByName;
        C5351a.m1321a(httpEntity, "Entity");
        if (httpEntity.getContentType() != null) {
            HeaderElement[] elements = httpEntity.getContentType().getElements();
            if (elements.length > 0 && (parameterByName = elements[0].getParameterByName("charset")) != null) {
                return parameterByName.getValue();
            }
            return null;
        }
        return null;
    }

    @Deprecated
    /* renamed from: e */
    public static String m1300e(HttpEntity httpEntity) {
        C5351a.m1321a(httpEntity, "Entity");
        if (httpEntity.getContentType() != null) {
            HeaderElement[] elements = httpEntity.getContentType().getElements();
            if (elements.length <= 0) {
                return null;
            }
            return elements[0].getName();
        }
        return null;
    }

    /* renamed from: f */
    public static String m1299f(HttpEntity httpEntity) {
        return m1305a(httpEntity, (Charset) null);
    }
}
