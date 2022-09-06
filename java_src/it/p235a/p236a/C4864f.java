package it.p235a.p236a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import javax.net.ssl.SSLSocketFactory;
/* renamed from: it.a.a.f */
/* loaded from: classes.dex */
public class C4864f {

    /* renamed from: a */
    private ArrayList f20818a = new ArrayList();

    /* renamed from: b */
    private Socket f20819b;

    /* renamed from: c */
    private String f20820c;

    /* renamed from: d */
    private C4879u f20821d;

    /* renamed from: e */
    private C4880v f20822e;

    public C4864f(Socket socket, String str) {
        this.f20819b = null;
        this.f20820c = null;
        this.f20821d = null;
        this.f20822e = null;
        this.f20819b = socket;
        this.f20820c = str;
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        this.f20821d = new C4879u(inputStream, str);
        this.f20822e = new C4880v(outputStream, str);
    }

    /* renamed from: d */
    private String m3015d() {
        String m2978a = this.f20821d.m2978a();
        if (m2978a == null) {
            throw new IOException("FTPConnection closed");
        }
        Iterator it2 = this.f20818a.iterator();
        while (it2.hasNext()) {
            ((AbstractC4865g) it2.next()).m3013b(m2978a);
        }
        return m2978a;
    }

    /* renamed from: a */
    public void m3023a() {
        try {
            this.f20819b.close();
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public void m3022a(AbstractC4865g abstractC4865g) {
        this.f20818a.add(abstractC4865g);
    }

    /* renamed from: a */
    public void m3021a(String str) {
        this.f20822e.m2975b(str);
        Iterator it2 = this.f20818a.iterator();
        while (it2.hasNext()) {
            ((AbstractC4865g) it2.next()).m3014a(str);
        }
    }

    /* renamed from: a */
    public void m3020a(SSLSocketFactory sSLSocketFactory) {
        this.f20819b = sSLSocketFactory.createSocket(this.f20819b, this.f20819b.getInetAddress().getHostName(), this.f20819b.getPort(), true);
        InputStream inputStream = this.f20819b.getInputStream();
        OutputStream outputStream = this.f20819b.getOutputStream();
        this.f20821d = new C4879u(inputStream, this.f20820c);
        this.f20822e = new C4880v(outputStream, this.f20820c);
    }

    /* renamed from: b */
    public void m3018b(AbstractC4865g abstractC4865g) {
        this.f20818a.remove(abstractC4865g);
    }

    /* renamed from: b */
    public void m3017b(String str) {
        this.f20820c = str;
        this.f20821d.m2977a(str);
        this.f20822e.m2976a(str);
    }

    /* renamed from: b */
    public AbstractC4865g[] m3019b() {
        int size = this.f20818a.size();
        AbstractC4865g[] abstractC4865gArr = new AbstractC4865g[size];
        for (int i = 0; i < size; i++) {
            abstractC4865gArr[i] = (AbstractC4865g) this.f20818a.get(i);
        }
        return abstractC4865gArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x006a, code lost:
        r3 = r5.size();
        r4 = new java.lang.String[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0070, code lost:
        if (r1 >= r3) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0072, code lost:
        r4[r1] = (java.lang.String) r5.get(r1);
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009a, code lost:
        return new it.p235a.p236a.C4877s(r2, r4);
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C4877s m3016c() {
        int i;
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            String m3015d = m3015d();
            if (m3015d.trim().length() != 0) {
                String substring = m3015d.startsWith("\n") ? m3015d.substring(1) : m3015d;
                int length = substring.length();
                if (i3 == 0 && length < 3) {
                    throw new C4873o();
                }
                try {
                    i = Integer.parseInt(substring.substring(0, 3));
                } catch (Exception e) {
                    if (i3 == 0) {
                        throw new C4873o();
                    }
                    i = 0;
                }
                if (i3 != 0 && i != 0 && i != i3) {
                    throw new C4873o();
                }
                int i4 = i3 == 0 ? i : i3;
                if (i <= 0) {
                    arrayList.add(substring);
                } else if (length <= 3) {
                    if (length == 3) {
                        break;
                    }
                    arrayList.add(substring);
                } else {
                    char charAt = substring.charAt(3);
                    arrayList.add(substring.substring(4, length));
                    if (charAt == ' ') {
                        break;
                    } else if (charAt != '-') {
                        throw new C4873o();
                    } else {
                        i3 = i4;
                    }
                }
                i3 = i4;
            }
        }
    }
}
