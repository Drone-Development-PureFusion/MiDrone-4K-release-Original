package it.p235a.p236a;

import com.fimi.kernel.utils.C2258f;
import com.xiaomi.mipush.sdk.Constants;
import it.p235a.p236a.p237a.C4847d;
import it.p235a.p236a.p238b.C4854a;
import it.p235a.p236a.p239c.C4857a;
import it.p235a.p236a.p239c.C4858b;
import it.p235a.p236a.p239c.C4859c;
import it.p235a.p236a.p239c.C4860d;
import it.p235a.p236a.p239c.C4861e;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.SSLSocketFactory;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: it.a.a.b */
/* loaded from: classes.dex */
public class C4852b {

    /* renamed from: a */
    public static final int f20716a = 0;

    /* renamed from: b */
    public static final int f20717b = 1;

    /* renamed from: c */
    public static final int f20718c = 2;

    /* renamed from: d */
    public static final int f20719d = 0;

    /* renamed from: e */
    public static final int f20720e = 1;

    /* renamed from: f */
    public static final int f20721f = 2;

    /* renamed from: g */
    public static final int f20722g = 0;

    /* renamed from: h */
    public static final int f20723h = 1;

    /* renamed from: i */
    public static final int f20724i = 2;

    /* renamed from: j */
    private static final int f20725j = 65536;

    /* renamed from: k */
    private static final DateFormat f20726k = new SimpleDateFormat(C2258f.f7530e);

    /* renamed from: l */
    private static final Pattern f20727l = Pattern.compile("\\d{1,3},\\d{1,3},\\d{1,3},\\d{1,3},\\d{1,3},\\d{1,3}");

    /* renamed from: m */
    private static final Pattern f20728m = Pattern.compile("\"/.*\"");

    /* renamed from: E */
    private C4853a f20733E;

    /* renamed from: F */
    private long f20734F;

    /* renamed from: w */
    private String f20760w;

    /* renamed from: x */
    private String f20761x;

    /* renamed from: n */
    private AbstractC4866h f20751n = new C4847d();

    /* renamed from: o */
    private SSLSocketFactory f20752o = (SSLSocketFactory) SSLSocketFactory.getDefault();

    /* renamed from: p */
    private ArrayList f20753p = new ArrayList();

    /* renamed from: q */
    private ArrayList f20754q = new ArrayList();

    /* renamed from: r */
    private AbstractC4878t f20755r = C4854a.m3029a();

    /* renamed from: s */
    private AbstractC4876r f20756s = null;

    /* renamed from: t */
    private String f20757t = null;

    /* renamed from: u */
    private int f20758u = 0;

    /* renamed from: v */
    private int f20759v = 0;

    /* renamed from: y */
    private boolean f20762y = false;

    /* renamed from: z */
    private boolean f20763z = false;

    /* renamed from: A */
    private boolean f20729A = true;

    /* renamed from: B */
    private int f20730B = 0;

    /* renamed from: C */
    private int f20731C = 0;

    /* renamed from: D */
    private long f20732D = 0;

    /* renamed from: G */
    private boolean f20735G = false;

    /* renamed from: H */
    private String f20736H = null;

    /* renamed from: I */
    private boolean f20737I = false;

    /* renamed from: J */
    private boolean f20738J = false;

    /* renamed from: K */
    private boolean f20739K = false;

    /* renamed from: L */
    private boolean f20740L = false;

    /* renamed from: M */
    private boolean f20741M = false;

    /* renamed from: N */
    private boolean f20742N = false;

    /* renamed from: O */
    private boolean f20743O = false;

    /* renamed from: P */
    private InputStream f20744P = null;

    /* renamed from: Q */
    private OutputStream f20745Q = null;

    /* renamed from: R */
    private boolean f20746R = false;

    /* renamed from: S */
    private boolean f20747S = false;

    /* renamed from: T */
    private Object f20748T = new Object();

    /* renamed from: U */
    private Object f20749U = new Object();

    /* renamed from: V */
    private C4864f f20750V = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: it.a.a.b$a */
    /* loaded from: classes.dex */
    public class C4853a extends Thread {

        /* renamed from: a */
        private final C4852b f20764a;

        private C4853a(C4852b c4852b) {
            this.f20764a = c4852b;
        }

        C4853a(C4852b c4852b, C4856c c4856c) {
            this(c4852b);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (C4852b.m3065d(this.f20764a)) {
                if (C4852b.m3061e(this.f20764a) <= 0 && C4852b.m3058f(this.f20764a) > 0) {
                    C4852b.m3105a(this.f20764a, System.currentTimeMillis() + C4852b.m3058f(this.f20764a));
                }
                while (!Thread.interrupted() && C4852b.m3058f(this.f20764a) > 0) {
                    long m3061e = C4852b.m3061e(this.f20764a) - System.currentTimeMillis();
                    if (m3061e > 0) {
                        try {
                            C4852b.m3065d(this.f20764a).wait(m3061e);
                        } catch (InterruptedException e) {
                        }
                    }
                    if (System.currentTimeMillis() >= C4852b.m3061e(this.f20764a)) {
                        try {
                            this.f20764a.m3032x();
                        } catch (Throwable th) {
                        }
                    }
                }
            }
        }
    }

    public C4852b() {
        m3101a(new C4861e());
        m3101a(new C4857a());
        m3101a(new C4858b());
        m3101a(new C4860d());
        m3101a(new C4859c());
    }

    /* renamed from: E */
    private void m3120E() {
        synchronized (this.f20748T) {
            this.f20738J = false;
            this.f20735G = false;
            this.f20739K = false;
            this.f20740L = false;
            this.f20742N = false;
            this.f20750V.m3021a("FEAT");
            C4877s m3016c = this.f20750V.m3016c();
            if (m3016c.m2982a() == 211) {
                String[] m2980c = m3016c.m2980c();
                for (int i = 1; i < m2980c.length - 1; i++) {
                    String upperCase = m2980c[i].trim().toUpperCase();
                    if ("REST STREAM".equalsIgnoreCase(upperCase)) {
                        this.f20735G = true;
                    } else if ("UTF8".equalsIgnoreCase(upperCase)) {
                        this.f20738J = true;
                        this.f20750V.m3017b("UTF-8");
                    } else if ("MLSD".equalsIgnoreCase(upperCase)) {
                        this.f20739K = true;
                    } else if ("MODE Z".equalsIgnoreCase(upperCase) || upperCase.startsWith("MODE Z ")) {
                        this.f20740L = true;
                    }
                }
            }
            if (this.f20738J) {
                this.f20750V.m3021a("OPTS UTF8 ON");
                this.f20750V.m3016c();
            }
            if (this.f20759v == 1 || this.f20759v == 2) {
                this.f20750V.m3021a("PBSZ 0");
                this.f20750V.m3016c();
                this.f20750V.m3021a("PROT P");
                if (this.f20750V.m3016c().m2981b()) {
                    this.f20742N = true;
                }
            }
        }
    }

    /* renamed from: F */
    private AbstractC4867i m3119F() {
        if (!this.f20740L || !this.f20737I) {
            if (this.f20741M) {
                this.f20750V.m3021a("MODE S");
                C4877s m3016c = this.f20750V.m3016c();
                m3110O();
                if (m3016c.m2981b()) {
                    this.f20741M = false;
                }
            }
        } else if (!this.f20741M) {
            this.f20750V.m3021a("MODE Z");
            C4877s m3016c2 = this.f20750V.m3016c();
            m3110O();
            if (m3016c2.m2981b()) {
                this.f20741M = true;
            }
        }
        return this.f20729A ? m3117H() : m3118G();
    }

    /* renamed from: G */
    private AbstractC4867i m3118G() {
        C4856c c4856c = new C4856c(this);
        int m2995c = c4856c.m2995c();
        int[] m3115J = m3115J();
        this.f20750V.m3021a(new StringBuffer().append("PORT ").append(m3115J[0]).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(m3115J[1]).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(m3115J[2]).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(m3115J[3]).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(m2995c >>> 8).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(m2995c & 255).toString());
        C4877s m3016c = this.f20750V.m3016c();
        m3110O();
        if (!m3016c.m2981b()) {
            c4856c.mo2996b();
            try {
                c4856c.mo2997a().close();
            } catch (Throwable th) {
            }
            throw new C4871m(m3016c);
        }
        return c4856c;
    }

    /* renamed from: H */
    private AbstractC4867i m3117H() {
        String str;
        this.f20750V.m3021a("PASV");
        C4877s m3016c = this.f20750V.m3016c();
        m3110O();
        if (!m3016c.m2981b()) {
            throw new C4871m(m3016c);
        }
        String[] m2980c = m3016c.m2980c();
        int i = 0;
        while (true) {
            if (i >= m2980c.length) {
                str = null;
                break;
            }
            Matcher matcher = f20727l.matcher(m2980c[i]);
            if (matcher.find()) {
                str = m2980c[i].substring(matcher.start(), matcher.end());
                break;
            }
            i++;
        }
        if (str == null) {
            throw new C4873o();
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, Constants.ACCEPT_TIME_SEPARATOR_SP);
        int parseInt = Integer.parseInt(stringTokenizer.nextToken());
        int parseInt2 = Integer.parseInt(stringTokenizer.nextToken());
        int parseInt3 = Integer.parseInt(stringTokenizer.nextToken());
        return new C4862d(this, new StringBuffer().append(parseInt).append(".").append(parseInt2).append(".").append(parseInt3).append(".").append(Integer.parseInt(stringTokenizer.nextToken())).toString(), Integer.parseInt(stringTokenizer.nextToken()) | (Integer.parseInt(stringTokenizer.nextToken()) << 8));
    }

    /* renamed from: I */
    private String m3116I() {
        return this.f20736H != null ? this.f20736H : this.f20738J ? "UTF-8" : System.getProperty("file.encoding");
    }

    /* renamed from: J */
    private int[] m3115J() {
        int[] m3114K = m3114K();
        return m3114K == null ? m3113L() : m3114K;
    }

    /* renamed from: K */
    private int[] m3114K() {
        boolean z = false;
        int[] iArr = null;
        String property = System.getProperty(AbstractC4874p.f20843b);
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ".");
            if (stringTokenizer.countTokens() == 4) {
                int[] iArr2 = new int[4];
                int i = 0;
                while (true) {
                    if (i >= 4) {
                        z = true;
                        break;
                    }
                    try {
                        iArr2[i] = Integer.parseInt(stringTokenizer.nextToken());
                    } catch (NumberFormatException e) {
                        iArr2[i] = -1;
                    }
                    if (iArr2[i] < 0 || iArr2[i] > 255) {
                        break;
                    }
                    i++;
                }
                if (z) {
                    iArr = iArr2;
                }
            }
            if (!z) {
                System.err.println(new StringBuffer().append("WARNING: invalid value \"").append(property).append("\" for the ").append(AbstractC4874p.f20843b).append(" system property. The value should ").append("be in the x.x.x.x form.").toString());
            }
        }
        return iArr;
    }

    /* renamed from: L */
    private int[] m3113L() {
        byte[] address = InetAddress.getLocalHost().getAddress();
        return new int[]{address[0] & SmileConstants.BYTE_MARKER_END_OF_CONTENT, address[1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT, address[2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT, address[3] & SmileConstants.BYTE_MARKER_END_OF_CONTENT};
    }

    /* renamed from: M */
    private void m3112M() {
        if (this.f20732D > 0) {
            this.f20733E = new C4853a(this, null);
            this.f20733E.start();
        }
    }

    /* renamed from: N */
    private void m3111N() {
        if (this.f20733E != null) {
            this.f20733E.interrupt();
            this.f20733E = null;
        }
    }

    /* renamed from: O */
    private void m3110O() {
        if (this.f20733E != null) {
            this.f20734F = System.currentTimeMillis() + this.f20732D;
        }
    }

    /* renamed from: a */
    static long m3105a(C4852b c4852b, long j) {
        c4852b.f20734F = j;
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static Socket m3104a(C4852b c4852b, Socket socket, String str, int i) {
        return c4852b.m3084a(socket, str, i);
    }

    /* renamed from: a */
    private Socket m3084a(Socket socket, String str, int i) {
        return this.f20752o.createSocket(socket, str, i, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m3106a(C4852b c4852b) {
        return c4852b.f20742N;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static AbstractC4866h m3079b(C4852b c4852b) {
        return c4852b.f20751n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static String m3069c(C4852b c4852b) {
        return c4852b.f20757t;
    }

    /* renamed from: d */
    static Object m3065d(C4852b c4852b) {
        return c4852b.f20748T;
    }

    /* renamed from: e */
    static long m3061e(C4852b c4852b) {
        return c4852b.f20734F;
    }

    /* renamed from: f */
    static long m3058f(C4852b c4852b) {
        return c4852b.f20732D;
    }

    /* renamed from: m */
    private int m3043m(String str) {
        int lastIndexOf = str.lastIndexOf(46) + 1;
        int length = str.length();
        if (lastIndexOf <= 0 || lastIndexOf >= length - 1) {
            return 2;
        }
        return this.f20755r.mo2979a(str.substring(lastIndexOf, length).toLowerCase()) ? 1 : 2;
    }

    /* renamed from: A */
    public String[] m3124A() {
        String[] m2980c;
        synchronized (this.f20748T) {
            if (!this.f20762y) {
                throw new IllegalStateException("Client not connected");
            }
            if (!this.f20763z) {
                throw new IllegalStateException("Client not authenticated");
            }
            this.f20750V.m3021a("HELP");
            C4877s m3016c = this.f20750V.m3016c();
            m3110O();
            if (!m3016c.m2981b()) {
                throw new C4871m(m3016c);
            }
            m2980c = m3016c.m2980c();
        }
        return m2980c;
    }

    /* renamed from: B */
    public String[] m3123B() {
        String[] m2980c;
        synchronized (this.f20748T) {
            if (!this.f20762y) {
                throw new IllegalStateException("Client not connected");
            }
            if (!this.f20763z) {
                throw new IllegalStateException("Client not authenticated");
            }
            this.f20750V.m3021a("STAT");
            C4877s m3016c = this.f20750V.m3016c();
            m3110O();
            if (!m3016c.m2981b()) {
                throw new C4871m(m3016c);
            }
            m2980c = m3016c.m2980c();
        }
        return m2980c;
    }

    /* renamed from: C */
    public C4872n[] m3122C() {
        return m3045l(null);
    }

    /* renamed from: D */
    public String[] m3121D() {
        String[] strArr;
        C4879u c4879u = null;
        synchronized (this.f20748T) {
            if (!this.f20762y) {
                throw new IllegalStateException("Client not connected");
            }
            if (!this.f20763z) {
                throw new IllegalStateException("Client not authenticated");
            }
            this.f20750V.m3021a("TYPE A");
            C4877s m3016c = this.f20750V.m3016c();
            m3110O();
            if (!m3016c.m2981b()) {
                throw new C4871m(m3016c);
            }
            ArrayList arrayList = new ArrayList();
            AbstractC4867i m3119F = m3119F();
            this.f20750V.m3021a("NLST");
            try {
                Socket mo2997a = m3119F.mo2997a();
                m3119F.mo2996b();
                synchronized (this.f20749U) {
                    this.f20743O = true;
                    this.f20746R = false;
                    this.f20747S = false;
                    try {
                        try {
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        C4877s m3016c2 = this.f20750V.m3016c();
                        if (m3016c2.m2982a() != 150 && m3016c2.m2982a() != 125) {
                            throw new C4871m(m3016c2);
                        }
                        C4877s m3016c3 = this.f20750V.m3016c();
                        if (c4879u == null && m3016c3.m2982a() != 226) {
                            throw new C4871m(m3016c3);
                        }
                        if (this.f20747S) {
                            this.f20750V.m3016c();
                            this.f20747S = false;
                        }
                        throw th;
                    }
                }
                try {
                    this.f20744P = mo2997a.getInputStream();
                    if (this.f20741M) {
                        this.f20744P = new InflaterInputStream(this.f20744P);
                    }
                    C4879u c4879u2 = new C4879u(this.f20744P, m3116I());
                    while (true) {
                        try {
                            String m2978a = c4879u2.m2978a();
                            if (m2978a == null) {
                                break;
                            } else if (m2978a.length() > 0) {
                                arrayList.add(m2978a);
                            }
                        } catch (IOException e) {
                            e = e;
                            synchronized (this.f20749U) {
                                if (!this.f20746R) {
                                    throw new C4868j("I/O error in data transfer", e);
                                }
                                throw new C4843a();
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            c4879u = c4879u2;
                            if (c4879u != null) {
                                try {
                                    c4879u.close();
                                } catch (Throwable th4) {
                                }
                            }
                            try {
                                mo2997a.close();
                            } catch (Throwable th5) {
                            }
                            this.f20744P = null;
                            try {
                                synchronized (this.f20749U) {
                                    try {
                                        boolean z = this.f20746R;
                                        this.f20743O = false;
                                        this.f20746R = false;
                                        throw th;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        throw th;
                                    }
                                }
                            } catch (Throwable th7) {
                                th = th7;
                            }
                        }
                    }
                    if (c4879u2 != null) {
                        try {
                            c4879u2.close();
                        } catch (Throwable th8) {
                        }
                    }
                    try {
                        mo2997a.close();
                    } catch (Throwable th9) {
                    }
                    this.f20744P = null;
                    try {
                        synchronized (this.f20749U) {
                            try {
                                boolean z2 = this.f20746R;
                                this.f20743O = false;
                                this.f20746R = false;
                                C4877s m3016c4 = this.f20750V.m3016c();
                                if (m3016c4.m2982a() != 150 && m3016c4.m2982a() != 125) {
                                    throw new C4871m(m3016c4);
                                }
                                C4877s m3016c5 = this.f20750V.m3016c();
                                if (!z2 && m3016c5.m2982a() != 226) {
                                    throw new C4871m(m3016c5);
                                }
                                if (this.f20747S) {
                                    this.f20750V.m3016c();
                                    this.f20747S = false;
                                }
                                int size = arrayList.size();
                                strArr = new String[size];
                                for (int i = 0; i < size; i++) {
                                    strArr[i] = (String) arrayList.get(i);
                                }
                            } catch (Throwable th10) {
                                th = th10;
                                throw th;
                            }
                        }
                    } catch (Throwable th11) {
                        th = th11;
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th12) {
                th = th12;
                c4879u = null;
            }
        }
        return strArr;
    }

    /* renamed from: a */
    public AbstractC4866h m3109a() {
        AbstractC4866h abstractC4866h;
        synchronized (this.f20748T) {
            abstractC4866h = this.f20751n;
        }
        return abstractC4866h;
    }

    /* renamed from: a */
    public void m3108a(int i) {
        if (i == 0 || i == 1 || i == 2) {
            synchronized (this.f20748T) {
                if (this.f20762y) {
                    throw new IllegalStateException("The security level of the connection can't be changed while the client is connected");
                }
                this.f20759v = i;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid security");
    }

    /* renamed from: a */
    public void m3107a(long j) {
        synchronized (this.f20748T) {
            if (this.f20762y && this.f20763z) {
                m3111N();
            }
            long j2 = this.f20732D;
            this.f20732D = j;
            if (j2 != 0 && j != 0 && this.f20734F > 0) {
                this.f20734F -= j2 - j;
            }
            if (this.f20762y && this.f20763z) {
                m3112M();
            }
        }
    }

    /* renamed from: a */
    public void m3103a(AbstractC4865g abstractC4865g) {
        synchronized (this.f20748T) {
            this.f20753p.add(abstractC4865g);
            if (this.f20750V != null) {
                this.f20750V.m3022a(abstractC4865g);
            }
        }
    }

    /* renamed from: a */
    public void m3102a(AbstractC4866h abstractC4866h) {
        synchronized (this.f20748T) {
            this.f20751n = abstractC4866h;
        }
    }

    /* renamed from: a */
    public void m3101a(AbstractC4876r abstractC4876r) {
        synchronized (this.f20748T) {
            this.f20754q.add(abstractC4876r);
        }
    }

    /* renamed from: a */
    public void m3100a(AbstractC4878t abstractC4878t) {
        synchronized (this.f20748T) {
            this.f20755r = abstractC4878t;
        }
    }

    /* renamed from: a */
    public void m3099a(File file) {
        m3097a(file, 0L, (AbstractC4869k) null);
    }

    /* renamed from: a */
    public void m3098a(File file, long j) {
        m3097a(file, j, (AbstractC4869k) null);
    }

    /* renamed from: a */
    public void m3097a(File file, long j, AbstractC4869k abstractC4869k) {
        FileInputStream fileInputStream;
        if (!file.exists()) {
            throw new FileNotFoundException(file.getAbsolutePath());
        }
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        try {
                            m3089a(file.getName(), fileInputStream, j, j, abstractC4869k);
                            if (fileInputStream == null) {
                                return;
                            }
                            try {
                                fileInputStream.close();
                            } catch (Throwable th) {
                            }
                        } catch (C4868j e) {
                            throw e;
                        } catch (IOException e2) {
                            throw e2;
                        }
                    } catch (C4843a e3) {
                        throw e3;
                    } catch (C4873o e4) {
                        throw e4;
                    }
                } catch (C4871m e5) {
                    throw e5;
                } catch (IllegalStateException e6) {
                    throw e6;
                }
            } catch (IOException e7) {
                throw new C4868j(e7);
            }
        } catch (Throwable th2) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                }
            }
            throw th2;
        }
    }

    /* renamed from: a */
    public void m3096a(File file, AbstractC4869k abstractC4869k) {
        m3097a(file, 0L, abstractC4869k);
    }

    /* renamed from: a */
    public void m3095a(String str) {
        synchronized (this.f20748T) {
            this.f20736H = str;
            if (this.f20762y) {
                try {
                    this.f20750V.m3017b(m3116I());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public void m3093a(String str, File file) {
        m3091a(str, file, 0L, (AbstractC4869k) null);
    }

    /* renamed from: a */
    public void m3092a(String str, File file, long j) {
        m3091a(str, file, j, (AbstractC4869k) null);
    }

    /* renamed from: a */
    public void m3091a(String str, File file, long j, AbstractC4869k abstractC4869k) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, j > 0);
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    m3087a(str, fileOutputStream, j, abstractC4869k);
                                    if (fileOutputStream == null) {
                                        return;
                                    }
                                    try {
                                        fileOutputStream.close();
                                    } catch (Throwable th) {
                                    }
                                } catch (IllegalStateException e) {
                                    throw e;
                                }
                            } catch (C4868j e2) {
                                throw e2;
                            }
                        } catch (C4873o e3) {
                            throw e3;
                        }
                    } catch (C4843a e4) {
                        throw e4;
                    } catch (C4871m e5) {
                        throw e5;
                    }
                } catch (Throwable th2) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th3) {
                        }
                    }
                    throw th2;
                }
            } catch (IOException e6) {
                throw e6;
            }
        } catch (IOException e7) {
            throw new C4868j(e7);
        }
    }

    /* renamed from: a */
    public void m3090a(String str, File file, AbstractC4869k abstractC4869k) {
        m3091a(str, file, 0L, abstractC4869k);
    }

    /* renamed from: a */
    public void m3089a(String str, InputStream inputStream, long j, long j2, AbstractC4869k abstractC4869k) {
        boolean z;
        synchronized (this.f20748T) {
            if (!this.f20762y) {
                throw new IllegalStateException("Client not connected");
            }
            if (!this.f20763z) {
                throw new IllegalStateException("Client not authenticated");
            }
            int i = this.f20730B;
            if (i == 0) {
                i = m3043m(str);
            }
            if (i == 1) {
                this.f20750V.m3021a("TYPE A");
            } else if (i == 2) {
                this.f20750V.m3021a("TYPE I");
            }
            C4877s m3016c = this.f20750V.m3016c();
            m3110O();
            if (!m3016c.m2981b()) {
                throw new C4871m(m3016c);
            }
            AbstractC4867i m3119F = m3119F();
            if (this.f20735G || j > 0) {
                this.f20750V.m3021a(new StringBuffer().append("REST ").append(j).toString());
                C4877s m3016c2 = this.f20750V.m3016c();
                m3110O();
                if (m3016c2.m2982a() != 350 && ((m3016c2.m2982a() != 501 && m3016c2.m2982a() != 502) || j > 0)) {
                    throw new C4871m(m3016c2);
                }
            }
            this.f20750V.m3021a(new StringBuffer().append("STOR ").append(str).toString());
            try {
                Socket mo2997a = m3119F.mo2997a();
                m3119F.mo2996b();
                synchronized (this.f20749U) {
                    this.f20743O = true;
                    this.f20746R = false;
                    this.f20747S = false;
                    try {
                    } catch (Throwable th) {
                        if (this.f20745Q != null) {
                            try {
                                this.f20745Q.close();
                            } catch (Throwable th2) {
                            }
                        }
                        try {
                            mo2997a.close();
                        } catch (Throwable th3) {
                        }
                        this.f20745Q = null;
                        synchronized (this.f20749U) {
                            boolean z2 = this.f20746R;
                            this.f20743O = false;
                            this.f20746R = false;
                            throw th;
                        }
                    }
                }
                try {
                    inputStream.skip(j2);
                    this.f20745Q = mo2997a.getOutputStream();
                    if (this.f20741M) {
                        this.f20745Q = new DeflaterOutputStream(this.f20745Q);
                    }
                    if (abstractC4869k != null) {
                        abstractC4869k.mo2998d();
                    }
                    if (i == 1) {
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.f20745Q, m3116I());
                        char[] cArr = new char[65536];
                        while (true) {
                            int read = inputStreamReader.read(cArr);
                            if (read == -1) {
                                break;
                            }
                            outputStreamWriter.write(cArr, 0, read);
                            outputStreamWriter.flush();
                            if (abstractC4869k != null) {
                                abstractC4869k.mo3001a(read);
                            }
                        }
                    } else if (i == 2) {
                        byte[] bArr = new byte[65536];
                        while (true) {
                            int read2 = inputStream.read(bArr);
                            if (read2 == -1) {
                                break;
                            }
                            this.f20745Q.write(bArr, 0, read2);
                            this.f20745Q.flush();
                            if (abstractC4869k != null) {
                                abstractC4869k.mo3001a(read2);
                            }
                        }
                    }
                    if (this.f20745Q != null) {
                        try {
                            this.f20745Q.close();
                        } catch (Throwable th4) {
                        }
                    }
                    try {
                        mo2997a.close();
                    } catch (Throwable th5) {
                    }
                    this.f20745Q = null;
                    synchronized (this.f20749U) {
                        z = this.f20746R;
                        this.f20743O = false;
                        this.f20746R = false;
                    }
                    C4877s m3016c3 = this.f20750V.m3016c();
                    m3110O();
                    if (m3016c3.m2982a() != 150 && m3016c3.m2982a() != 125) {
                        throw new C4871m(m3016c3);
                    }
                    C4877s m3016c4 = this.f20750V.m3016c();
                    if (!z && m3016c4.m2982a() != 226) {
                        throw new C4871m(m3016c4);
                    }
                    if (this.f20747S) {
                        this.f20750V.m3016c();
                        this.f20747S = false;
                    }
                    if (abstractC4869k != null) {
                        abstractC4869k.mo3000b();
                    }
                } catch (IOException e) {
                    synchronized (this.f20749U) {
                        if (this.f20746R) {
                            if (abstractC4869k != null) {
                                abstractC4869k.mo3002a();
                            }
                            throw new C4843a();
                        }
                        if (abstractC4869k != null) {
                            abstractC4869k.mo2999c();
                        }
                        throw new C4868j("I/O error in data transfer", e);
                    }
                }
            } catch (Throwable th6) {
                m3119F.mo2996b();
                throw th6;
            }
        }
    }

    /* renamed from: a */
    public void m3088a(String str, InputStream inputStream, long j, AbstractC4869k abstractC4869k) {
        boolean z;
        synchronized (this.f20748T) {
            if (!this.f20762y) {
                throw new IllegalStateException("Client not connected");
            }
            if (!this.f20763z) {
                throw new IllegalStateException("Client not authenticated");
            }
            int i = this.f20730B;
            if (i == 0) {
                i = m3043m(str);
            }
            if (i == 1) {
                this.f20750V.m3021a("TYPE A");
            } else if (i == 2) {
                this.f20750V.m3021a("TYPE I");
            }
            C4877s m3016c = this.f20750V.m3016c();
            m3110O();
            if (!m3016c.m2981b()) {
                throw new C4871m(m3016c);
            }
            AbstractC4867i m3119F = m3119F();
            this.f20750V.m3021a(new StringBuffer().append("APPE ").append(str).toString());
            try {
                Socket mo2997a = m3119F.mo2997a();
                m3119F.mo2996b();
                synchronized (this.f20749U) {
                    this.f20743O = true;
                    this.f20746R = false;
                    this.f20747S = false;
                    try {
                    } catch (Throwable th) {
                        if (this.f20745Q != null) {
                            try {
                                this.f20745Q.close();
                            } catch (Throwable th2) {
                            }
                        }
                        try {
                            mo2997a.close();
                        } catch (Throwable th3) {
                        }
                        this.f20745Q = null;
                        synchronized (this.f20749U) {
                            boolean z2 = this.f20746R;
                            this.f20743O = false;
                            this.f20746R = false;
                            throw th;
                        }
                    }
                }
                try {
                    inputStream.skip(j);
                    this.f20745Q = mo2997a.getOutputStream();
                    if (this.f20741M) {
                        this.f20745Q = new DeflaterOutputStream(this.f20745Q);
                    }
                    if (abstractC4869k != null) {
                        abstractC4869k.mo2998d();
                    }
                    if (i == 1) {
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.f20745Q, m3116I());
                        char[] cArr = new char[65536];
                        while (true) {
                            int read = inputStreamReader.read(cArr);
                            if (read == -1) {
                                break;
                            }
                            outputStreamWriter.write(cArr, 0, read);
                            outputStreamWriter.flush();
                            if (abstractC4869k != null) {
                                abstractC4869k.mo3001a(read);
                            }
                        }
                    } else if (i == 2) {
                        byte[] bArr = new byte[65536];
                        while (true) {
                            int read2 = inputStream.read(bArr);
                            if (read2 == -1) {
                                break;
                            }
                            this.f20745Q.write(bArr, 0, read2);
                            this.f20745Q.flush();
                            if (abstractC4869k != null) {
                                abstractC4869k.mo3001a(read2);
                            }
                        }
                    }
                    if (this.f20745Q != null) {
                        try {
                            this.f20745Q.close();
                        } catch (Throwable th4) {
                        }
                    }
                    try {
                        mo2997a.close();
                    } catch (Throwable th5) {
                    }
                    this.f20745Q = null;
                    synchronized (this.f20749U) {
                        z = this.f20746R;
                        this.f20743O = false;
                        this.f20746R = false;
                    }
                    C4877s m3016c2 = this.f20750V.m3016c();
                    m3110O();
                    if (m3016c2.m2982a() != 150 && m3016c2.m2982a() != 125) {
                        throw new C4871m(m3016c2);
                    }
                    C4877s m3016c3 = this.f20750V.m3016c();
                    if (!z && m3016c3.m2982a() != 226) {
                        throw new C4871m(m3016c3);
                    }
                    if (this.f20747S) {
                        this.f20750V.m3016c();
                        this.f20747S = false;
                    }
                    if (abstractC4869k != null) {
                        abstractC4869k.mo3000b();
                    }
                } catch (IOException e) {
                    synchronized (this.f20749U) {
                        if (this.f20746R) {
                            if (abstractC4869k != null) {
                                abstractC4869k.mo3002a();
                            }
                            throw new C4843a();
                        }
                        if (abstractC4869k != null) {
                            abstractC4869k.mo2999c();
                        }
                        throw new C4868j("I/O error in data transfer", e);
                    }
                }
            } catch (Throwable th6) {
                m3119F.mo2996b();
                throw th6;
            }
        }
    }

    /* renamed from: a */
    public void m3087a(String str, OutputStream outputStream, long j, AbstractC4869k abstractC4869k) {
        boolean z;
        synchronized (this.f20748T) {
            if (!this.f20762y) {
                throw new IllegalStateException("Client not connected");
            }
            if (!this.f20763z) {
                throw new IllegalStateException("Client not authenticated");
            }
            int i = this.f20730B;
            if (i == 0) {
                i = m3043m(str);
            }
            if (i == 1) {
                this.f20750V.m3021a("TYPE A");
            } else if (i == 2) {
                this.f20750V.m3021a("TYPE I");
            }
            C4877s m3016c = this.f20750V.m3016c();
            m3110O();
            if (!m3016c.m2981b()) {
                throw new C4871m(m3016c);
            }
            AbstractC4867i m3119F = m3119F();
            if (this.f20735G || j > 0) {
                this.f20750V.m3021a(new StringBuffer().append("REST ").append(j).toString());
                C4877s m3016c2 = this.f20750V.m3016c();
                m3110O();
                if (m3016c2.m2982a() != 350 && ((m3016c2.m2982a() != 501 && m3016c2.m2982a() != 502) || j > 0)) {
                    throw new C4871m(m3016c2);
                }
            }
            this.f20750V.m3021a(new StringBuffer().append("RETR ").append(str).toString());
            Socket mo2997a = m3119F.mo2997a();
            m3119F.mo2996b();
            synchronized (this.f20749U) {
                this.f20743O = true;
                this.f20746R = false;
                this.f20747S = false;
            }
            try {
                this.f20744P = mo2997a.getInputStream();
                if (this.f20741M) {
                    this.f20744P = new InflaterInputStream(this.f20744P);
                }
                if (abstractC4869k != null) {
                    abstractC4869k.mo2998d();
                }
                if (i == 1) {
                    InputStreamReader inputStreamReader = new InputStreamReader(this.f20744P, m3116I());
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                    char[] cArr = new char[65536];
                    while (true) {
                        int read = inputStreamReader.read(cArr, 0, cArr.length);
                        if (read == -1) {
                            break;
                        }
                        outputStreamWriter.write(cArr, 0, read);
                        outputStreamWriter.flush();
                        if (abstractC4869k != null) {
                            abstractC4869k.mo3001a(read);
                        }
                    }
                } else if (i == 2) {
                    byte[] bArr = new byte[65536];
                    while (true) {
                        int read2 = this.f20744P.read(bArr, 0, bArr.length);
                        if (read2 == -1) {
                            break;
                        }
                        outputStream.write(bArr, 0, read2);
                        if (abstractC4869k != null) {
                            abstractC4869k.mo3001a(read2);
                        }
                    }
                }
                if (this.f20744P != null) {
                    try {
                        this.f20744P.close();
                    } catch (Throwable th) {
                    }
                }
                try {
                    mo2997a.close();
                } catch (Throwable th2) {
                }
                this.f20744P = null;
                synchronized (this.f20749U) {
                    z = this.f20746R;
                    this.f20743O = false;
                    this.f20746R = false;
                }
                C4877s m3016c3 = this.f20750V.m3016c();
                m3110O();
                if (m3016c3.m2982a() != 150 && m3016c3.m2982a() != 125) {
                    throw new C4871m(m3016c3);
                }
                C4877s m3016c4 = this.f20750V.m3016c();
                if (!z && m3016c4.m2982a() != 226) {
                    throw new C4871m(m3016c4);
                }
                if (this.f20747S) {
                    this.f20750V.m3016c();
                    this.f20747S = false;
                }
                if (abstractC4869k != null) {
                    abstractC4869k.mo3000b();
                }
            } catch (IOException e) {
                synchronized (this.f20749U) {
                    if (this.f20746R) {
                        if (abstractC4869k != null) {
                            abstractC4869k.mo3002a();
                        }
                        throw new C4843a();
                    }
                    if (abstractC4869k != null) {
                        abstractC4869k.mo2999c();
                    }
                    throw new C4868j("I/O error in data transfer", e);
                }
            }
        }
    }

    /* renamed from: a */
    public void m3086a(String str, String str2) {
        m3085a(str, str2, (String) null);
    }

    /* renamed from: a */
    public void m3085a(String str, String str2, String str3) {
        boolean z;
        boolean z2 = false;
        synchronized (this.f20748T) {
            if (!this.f20762y) {
                throw new IllegalStateException("Client not connected");
            }
            if (this.f20759v == 2) {
                this.f20750V.m3021a("AUTH TLS");
                if (this.f20750V.m3016c().m2981b()) {
                    this.f20750V.m3020a(this.f20752o);
                } else {
                    this.f20750V.m3021a("AUTH SSL");
                    C4877s m3016c = this.f20750V.m3016c();
                    if (!m3016c.m2981b()) {
                        throw new C4871m(m3016c.m2982a(), "SECURITY_FTPES cannot be applied: the server refused both AUTH TLS and AUTH SSL commands");
                    }
                    this.f20750V.m3020a(this.f20752o);
                }
            }
            this.f20763z = false;
            this.f20750V.m3021a(new StringBuffer().append("USER ").append(str).toString());
            C4877s m3016c2 = this.f20750V.m3016c();
            switch (m3016c2.m2982a()) {
                case AbstractC4863e.f20785F /* 230 */:
                    z = false;
                    break;
                case AbstractC4863e.f20808q /* 331 */:
                    z = true;
                    break;
                case AbstractC4863e.f20809r /* 332 */:
                default:
                    throw new C4871m(m3016c2);
            }
            if (z) {
                if (str2 != null) {
                    this.f20750V.m3021a(new StringBuffer().append("PASS ").append(str2).toString());
                    C4877s m3016c3 = this.f20750V.m3016c();
                    switch (m3016c3.m2982a()) {
                        case AbstractC4863e.f20785F /* 230 */:
                            break;
                        default:
                            throw new C4871m(m3016c3);
                        case AbstractC4863e.f20809r /* 332 */:
                            z2 = true;
                            break;
                    }
                } else {
                    throw new C4871m((int) AbstractC4863e.f20808q);
                }
            }
            if (z2) {
                if (str3 == null) {
                    throw new C4871m((int) AbstractC4863e.f20809r);
                }
                this.f20750V.m3021a(new StringBuffer().append("ACCT ").append(str3).toString());
                C4877s m3016c4 = this.f20750V.m3016c();
                switch (m3016c4.m2982a()) {
                    case AbstractC4863e.f20785F /* 230 */:
                        break;
                    default:
                        throw new C4871m(m3016c4);
                }
            }
            this.f20763z = true;
            this.f20760w = str;
            this.f20761x = str2;
        }
        m3120E();
        m3112M();
    }

    /* renamed from: a */
    public void m3083a(SSLSocketFactory sSLSocketFactory) {
        synchronized (this.f20748T) {
            this.f20752o = sSLSocketFactory;
        }
    }

    /* renamed from: a */
    public void m3082a(boolean z) {
        synchronized (this.f20748T) {
            this.f20729A = z;
        }
    }

    /* renamed from: a */
    public String[] m3094a(String str, int i) {
        String[] m2980c;
        synchronized (this.f20748T) {
            if (this.f20762y) {
                throw new IllegalStateException(new StringBuffer().append("Client already connected to ").append(str).append(" on port ").append(i).toString());
            }
            try {
                Socket mo3004c = this.f20751n.mo3004c(str, i);
                if (this.f20759v == 1) {
                    mo3004c = m3084a(mo3004c, str, i);
                }
                this.f20750V = new C4864f(mo3004c, m3116I());
                Iterator it2 = this.f20753p.iterator();
                while (it2.hasNext()) {
                    this.f20750V.m3022a((AbstractC4865g) it2.next());
                }
                C4877s m3016c = this.f20750V.m3016c();
                if (!m3016c.m2981b()) {
                    throw new C4871m(m3016c);
                }
                this.f20762y = true;
                this.f20763z = false;
                this.f20756s = null;
                this.f20757t = str;
                this.f20758u = i;
                this.f20760w = null;
                this.f20761x = null;
                this.f20738J = false;
                this.f20735G = false;
                this.f20739K = false;
                this.f20740L = false;
                this.f20742N = false;
                m2980c = m3016c.m2980c();
                if (!this.f20762y && mo3004c != null) {
                    try {
                        mo3004c.close();
                    } catch (Throwable th) {
                    }
                }
            } catch (IOException e) {
                throw e;
            }
        }
        return m2980c;
    }

    /* renamed from: b */
    public SSLSocketFactory m3081b() {
        SSLSocketFactory sSLSocketFactory;
        synchronized (this.f20748T) {
            sSLSocketFactory = this.f20752o;
        }
        return sSLSocketFactory;
    }

    /* renamed from: b */
    public void m3080b(int i) {
        if (i == 0 || i == 2 || i == 1) {
            synchronized (this.f20748T) {
                this.f20730B = i;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid type");
    }

    /* renamed from: b */
    public void m3078b(AbstractC4865g abstractC4865g) {
        synchronized (this.f20748T) {
            this.f20753p.remove(abstractC4865g);
            if (this.f20750V != null) {
                this.f20750V.m3018b(abstractC4865g);
            }
        }
    }

    /* renamed from: b */
    public void m3077b(AbstractC4876r abstractC4876r) {
        synchronized (this.f20748T) {
            this.f20754q.remove(abstractC4876r);
        }
    }

    /* renamed from: b */
    public void m3076b(File file) {
        m3075b(file, (AbstractC4869k) null);
    }

    /* renamed from: b */
    public void m3075b(File file, AbstractC4869k abstractC4869k) {
        FileInputStream fileInputStream;
        if (!file.exists()) {
            throw new FileNotFoundException(file.getAbsolutePath());
        }
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        try {
                            m3088a(file.getName(), fileInputStream, 0L, abstractC4869k);
                            if (fileInputStream == null) {
                                return;
                            }
                            try {
                                fileInputStream.close();
                            } catch (Throwable th) {
                            }
                        } catch (C4868j e) {
                            throw e;
                        } catch (IOException e2) {
                            throw e2;
                        }
                    } catch (C4843a e3) {
                        throw e3;
                    } catch (C4873o e4) {
                        throw e4;
                    }
                } catch (C4871m e5) {
                    throw e5;
                } catch (IllegalStateException e6) {
                    throw e6;
                }
            } catch (IOException e7) {
                throw new C4868j(e7);
            }
        } catch (Throwable th2) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                }
            }
            throw th2;
        }
    }

    /* renamed from: b */
    public void m3073b(String str, String str2) {
        synchronized (this.f20748T) {
            if (!this.f20762y) {
                throw new IllegalStateException("Client not connected");
            }
            if (!this.f20763z) {
                throw new IllegalStateException("Client not authenticated");
            }
            this.f20750V.m3021a(new StringBuffer().append("RNFR ").append(str).toString());
            C4877s m3016c = this.f20750V.m3016c();
            m3110O();
            if (m3016c.m2982a() != 350) {
                throw new C4871m(m3016c);
            }
            this.f20750V.m3021a(new StringBuffer().append("RNTO ").append(str2).toString());
            C4877s m3016c2 = this.f20750V.m3016c();
            m3110O();
            if (!m3016c2.m2981b()) {
                throw new C4871m(m3016c2);
            }
        }
    }

    /* renamed from: b */
    public void m3072b(boolean z) {
        this.f20737I = z;
    }

    /* renamed from: b */
    public String[] m3074b(String str) {
        return m3094a(str, this.f20759v == 1 ? 990 : 21);
    }

    /* renamed from: c */
    public int m3071c() {
        return this.f20759v;
    }

    /* renamed from: c */
    public C4877s m3068c(String str) {
        C4877s m3016c;
        synchronized (this.f20748T) {
            if (!this.f20762y) {
                throw new IllegalStateException("Client not connected");
            }
            this.f20750V.m3021a(str);
            m3110O();
            m3016c = this.f20750V.m3016c();
        }
        return m3016c;
    }

    /* renamed from: c */
    public void m3070c(int i) {
        if (this.f20730B == 0 || this.f20730B == 1 || this.f20730B == 2) {
            synchronized (this.f20748T) {
                this.f20731C = i;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid MLSD policy");
    }

    /* renamed from: c */
    public void m3067c(boolean z) {
        synchronized (this.f20748T) {
            if (!this.f20762y) {
                throw new IllegalStateException("Client not connected");
            }
            if (this.f20763z) {
                m3111N();
            }
            if (z) {
                this.f20750V.m3021a("QUIT");
                C4877s m3016c = this.f20750V.m3016c();
                if (!m3016c.m2981b()) {
                    throw new C4871m(m3016c);
                }
            }
            this.f20750V.m3023a();
            this.f20750V = null;
            this.f20762y = false;
        }
    }

    /* renamed from: d */
    public int m3066d() {
        int i;
        synchronized (this.f20748T) {
            i = this.f20730B;
        }
        return i;
    }

    /* renamed from: d */
    public C4877s m3064d(String str) {
        C4877s m3016c;
        synchronized (this.f20748T) {
            if (!this.f20762y) {
                throw new IllegalStateException("Client not connected");
            }
            this.f20750V.m3021a(new StringBuffer().append("SITE ").append(str).toString());
            m3110O();
            m3016c = this.f20750V.m3016c();
        }
        return m3016c;
    }

    /* renamed from: d */
    public void m3063d(boolean z) {
        synchronized (this.f20749U) {
            if (this.f20743O && !this.f20746R) {
                if (z) {
                    this.f20750V.m3021a("ABOR");
                    m3110O();
                    this.f20747S = true;
                }
                if (this.f20744P != null) {
                    try {
                        this.f20744P.close();
                    } catch (Throwable th) {
                    }
                }
                if (this.f20745Q != null) {
                    try {
                        this.f20745Q.close();
                    } catch (Throwable th2) {
                    }
                }
                this.f20746R = true;
            }
        }
    }

    /* renamed from: e */
    public int m3062e() {
        int i;
        synchronized (this.f20748T) {
            i = this.f20731C;
        }
        return i;
    }

    /* renamed from: e */
    public void m3060e(String str) {
        synchronized (this.f20748T) {
            if (!this.f20762y) {
                throw new IllegalStateException("Client not connected");
            }
            if (!this.f20763z) {
                throw new IllegalStateException("Client not authenticated");
            }
            this.f20750V.m3021a(new StringBuffer().append("ACCT ").append(str).toString());
            C4877s m3016c = this.f20750V.m3016c();
            m3110O();
            if (!m3016c.m2981b()) {
                throw new C4871m(m3016c);
            }
        }
    }

    /* renamed from: f */
    public String m3059f() {
        String str;
        synchronized (this.f20748T) {
            str = this.f20736H;
        }
        return str;
    }

    /* renamed from: f */
    public void m3057f(String str) {
        synchronized (this.f20748T) {
            if (!this.f20762y) {
                throw new IllegalStateException("Client not connected");
            }
            if (!this.f20763z) {
                throw new IllegalStateException("Client not authenticated");
            }
            this.f20750V.m3021a(new StringBuffer().append("CWD ").append(str).toString());
            C4877s m3016c = this.f20750V.m3016c();
            m3110O();
            if (!m3016c.m2981b()) {
                throw new C4871m(m3016c);
            }
        }
    }

    /* renamed from: g */
    public Date m3055g(String str) {
        Date parse;
        synchronized (this.f20748T) {
            if (!this.f20762y) {
                throw new IllegalStateException("Client not connected");
            }
            if (!this.f20763z) {
                throw new IllegalStateException("Client not authenticated");
            }
            this.f20750V.m3021a(new StringBuffer().append("MDTM ").append(str).toString());
            C4877s m3016c = this.f20750V.m3016c();
            m3110O();
            if (!m3016c.m2981b()) {
                throw new C4871m(m3016c);
            }
            String[] m2980c = m3016c.m2980c();
            if (m2980c.length != 1) {
                throw new C4873o();
            }
            try {
                parse = f20726k.parse(m2980c[0]);
            } catch (ParseException e) {
                throw new C4873o();
            }
        }
        return parse;
    }

    /* renamed from: g */
    public boolean m3056g() {
        boolean z;
        synchronized (this.f20748T) {
            z = this.f20735G;
        }
        return z;
    }

    /* renamed from: h */
    public long m3053h(String str) {
        long parseLong;
        synchronized (this.f20748T) {
            if (!this.f20762y) {
                throw new IllegalStateException("Client not connected");
            }
            if (!this.f20763z) {
                throw new IllegalStateException("Client not authenticated");
            }
            this.f20750V.m3021a("TYPE I");
            C4877s m3016c = this.f20750V.m3016c();
            m3110O();
            if (!m3016c.m2981b()) {
                throw new C4871m(m3016c);
            }
            this.f20750V.m3021a(new StringBuffer().append("SIZE ").append(str).toString());
            C4877s m3016c2 = this.f20750V.m3016c();
            m3110O();
            if (!m3016c2.m2981b()) {
                throw new C4871m(m3016c2);
            }
            String[] m2980c = m3016c2.m2980c();
            if (m2980c.length != 1) {
                throw new C4873o();
            }
            parseLong = Long.parseLong(m2980c[0]);
        }
        return parseLong;
    }

    /* renamed from: h */
    public boolean m3054h() {
        return this.f20740L;
    }

    /* renamed from: i */
    public void m3051i(String str) {
        synchronized (this.f20748T) {
            if (!this.f20762y) {
                throw new IllegalStateException("Client not connected");
            }
            if (!this.f20763z) {
                throw new IllegalStateException("Client not authenticated");
            }
            this.f20750V.m3021a(new StringBuffer().append("DELE ").append(str).toString());
            C4877s m3016c = this.f20750V.m3016c();
            m3110O();
            if (!m3016c.m2981b()) {
                throw new C4871m(m3016c);
            }
        }
    }

    /* renamed from: i */
    public boolean m3052i() {
        return this.f20737I;
    }

    /* renamed from: j */
    public AbstractC4878t m3050j() {
        AbstractC4878t abstractC4878t;
        synchronized (this.f20748T) {
            abstractC4878t = this.f20755r;
        }
        return abstractC4878t;
    }

    /* renamed from: j */
    public void m3049j(String str) {
        synchronized (this.f20748T) {
            if (!this.f20762y) {
                throw new IllegalStateException("Client not connected");
            }
            if (!this.f20763z) {
                throw new IllegalStateException("Client not authenticated");
            }
            this.f20750V.m3021a(new StringBuffer().append("RMD ").append(str).toString());
            C4877s m3016c = this.f20750V.m3016c();
            m3110O();
            if (!m3016c.m2981b()) {
                throw new C4871m(m3016c);
            }
        }
    }

    /* renamed from: k */
    public void m3047k(String str) {
        synchronized (this.f20748T) {
            if (!this.f20762y) {
                throw new IllegalStateException("Client not connected");
            }
            if (!this.f20763z) {
                throw new IllegalStateException("Client not authenticated");
            }
            this.f20750V.m3021a(new StringBuffer().append("MKD ").append(str).toString());
            C4877s m3016c = this.f20750V.m3016c();
            m3110O();
            if (!m3016c.m2981b()) {
                throw new C4871m(m3016c);
            }
        }
    }

    /* renamed from: k */
    public boolean m3048k() {
        boolean z;
        synchronized (this.f20748T) {
            z = this.f20763z;
        }
        return z;
    }

    /* renamed from: l */
    public boolean m3046l() {
        boolean z;
        synchronized (this.f20748T) {
            z = this.f20762y;
        }
        return z;
    }

    /* renamed from: l */
    public C4872n[] m3045l(String str) {
        char c = 0;
        r1 = null;
        C4872n[] mo2983a = null;
        C4879u c4879u = null;
        synchronized (this.f20748T) {
            if (!this.f20762y) {
                throw new IllegalStateException("Client not connected");
            }
            if (!this.f20763z) {
                throw new IllegalStateException("Client not authenticated");
            }
            this.f20750V.m3021a("TYPE A");
            C4877s m3016c = this.f20750V.m3016c();
            m3110O();
            if (!m3016c.m2981b()) {
                throw new C4871m(m3016c);
            }
            AbstractC4867i m3119F = m3119F();
            boolean z = this.f20731C == 0 ? this.f20739K : this.f20731C == 1;
            String str2 = z ? "MLSD" : "LIST";
            if (str != null && str.length() > 0) {
                str2 = new StringBuffer().append(str2).append(" ").append(str).toString();
            }
            ArrayList arrayList = new ArrayList();
            this.f20750V.m3021a(str2);
            try {
                Socket mo2997a = m3119F.mo2997a();
                m3119F.mo2996b();
                synchronized (this.f20749U) {
                    this.f20743O = true;
                    this.f20746R = false;
                    this.f20747S = false;
                    try {
                    } catch (Throwable th) {
                        th = th;
                        C4877s m3016c2 = this.f20750V.m3016c();
                        m3110O();
                        if (m3016c2.m2982a() != 150 && m3016c2.m2982a() != 125) {
                            throw new C4871m(m3016c2);
                        }
                        C4877s m3016c3 = this.f20750V.m3016c();
                        if (c == 0 && m3016c3.m2982a() != 226) {
                            throw new C4871m(m3016c3);
                        }
                        if (this.f20747S) {
                            this.f20750V.m3016c();
                            this.f20747S = false;
                        }
                        throw th;
                    }
                }
                try {
                    try {
                        this.f20744P = mo2997a.getInputStream();
                        if (this.f20741M) {
                            this.f20744P = new InflaterInputStream(this.f20744P);
                        }
                        C4879u c4879u2 = new C4879u(this.f20744P, z ? "UTF-8" : m3116I());
                        while (true) {
                            try {
                                String m2978a = c4879u2.m2978a();
                                if (m2978a == null) {
                                    break;
                                } else if (m2978a.length() > 0) {
                                    arrayList.add(m2978a);
                                }
                            } catch (IOException e) {
                                e = e;
                                synchronized (this.f20749U) {
                                    if (!this.f20746R) {
                                        throw new C4868j("I/O error in data transfer", e);
                                    }
                                    throw new C4843a();
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                c4879u = c4879u2;
                                if (c4879u != null) {
                                    try {
                                        c4879u.close();
                                    } catch (Throwable th3) {
                                    }
                                }
                                try {
                                    mo2997a.close();
                                } catch (Throwable th4) {
                                }
                                this.f20744P = null;
                                try {
                                    synchronized (this.f20749U) {
                                        try {
                                            boolean z2 = this.f20746R;
                                            this.f20743O = false;
                                            this.f20746R = false;
                                            throw th;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                }
                            }
                        }
                        if (c4879u2 != null) {
                            try {
                                c4879u2.close();
                            } catch (Throwable th7) {
                            }
                        }
                        try {
                            mo2997a.close();
                        } catch (Throwable th8) {
                        }
                        this.f20744P = null;
                        synchronized (this.f20749U) {
                            try {
                                boolean z3 = this.f20746R;
                                try {
                                    this.f20743O = false;
                                    this.f20746R = false;
                                    C4877s m3016c4 = this.f20750V.m3016c();
                                    m3110O();
                                    if (m3016c4.m2982a() != 150 && m3016c4.m2982a() != 125) {
                                        throw new C4871m(m3016c4);
                                    }
                                    C4877s m3016c5 = this.f20750V.m3016c();
                                    if (!z3 && m3016c5.m2982a() != 226) {
                                        throw new C4871m(m3016c5);
                                    }
                                    if (this.f20747S) {
                                        this.f20750V.m3016c();
                                        this.f20747S = false;
                                    }
                                    int size = arrayList.size();
                                    String[] strArr = new String[size];
                                    for (int i = 0; i < size; i++) {
                                        strArr[i] = (String) arrayList.get(i);
                                    }
                                    if (z) {
                                        mo2983a = new C4859c().mo2983a(strArr);
                                    } else {
                                        if (this.f20756s != null) {
                                            try {
                                                mo2983a = this.f20756s.mo2983a(strArr);
                                            } catch (C4875q e2) {
                                                this.f20756s = null;
                                            }
                                        }
                                        if (mo2983a == null) {
                                            Iterator it2 = this.f20754q.iterator();
                                            while (it2.hasNext()) {
                                                AbstractC4876r abstractC4876r = (AbstractC4876r) it2.next();
                                                try {
                                                    mo2983a = abstractC4876r.mo2983a(strArr);
                                                    this.f20756s = abstractC4876r;
                                                    break;
                                                } catch (C4875q e3) {
                                                    mo2983a = mo2983a;
                                                }
                                            }
                                        }
                                    }
                                    if (mo2983a == null) {
                                        throw new C4875q();
                                    }
                                } catch (Throwable th9) {
                                    th = th9;
                                    while (true) {
                                        try {
                                            break;
                                        } catch (Throwable th10) {
                                            th = th10;
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th11) {
                                th = th11;
                            }
                        }
                    } catch (IOException e4) {
                        e = e4;
                    }
                } catch (Throwable th12) {
                    th = th12;
                }
            } catch (Throwable th13) {
                th = th13;
                c = 0;
            }
        }
        return mo2983a;
    }

    /* renamed from: m */
    public boolean m3044m() {
        boolean z;
        synchronized (this.f20748T) {
            z = this.f20729A;
        }
        return z;
    }

    /* renamed from: n */
    public String m3042n() {
        String str;
        synchronized (this.f20748T) {
            str = this.f20757t;
        }
        return str;
    }

    /* renamed from: o */
    public int m3041o() {
        int i;
        synchronized (this.f20748T) {
            i = this.f20758u;
        }
        return i;
    }

    /* renamed from: p */
    public String m3040p() {
        String str;
        synchronized (this.f20748T) {
            str = this.f20761x;
        }
        return str;
    }

    /* renamed from: q */
    public String m3039q() {
        String str;
        synchronized (this.f20748T) {
            str = this.f20760w;
        }
        return str;
    }

    /* renamed from: r */
    public long m3038r() {
        long j;
        synchronized (this.f20748T) {
            j = this.f20732D;
        }
        return j;
    }

    /* renamed from: s */
    public AbstractC4865g[] m3037s() {
        AbstractC4865g[] abstractC4865gArr;
        synchronized (this.f20748T) {
            int size = this.f20753p.size();
            abstractC4865gArr = new AbstractC4865g[size];
            for (int i = 0; i < size; i++) {
                abstractC4865gArr[i] = (AbstractC4865g) this.f20753p.get(i);
            }
        }
        return abstractC4865gArr;
    }

    /* renamed from: t */
    public AbstractC4876r[] m3036t() {
        AbstractC4876r[] abstractC4876rArr;
        synchronized (this.f20748T) {
            int size = this.f20754q.size();
            abstractC4876rArr = new AbstractC4876r[size];
            for (int i = 0; i < size; i++) {
                abstractC4876rArr[i] = (AbstractC4876r) this.f20754q.get(i);
            }
        }
        return abstractC4876rArr;
    }

    public String toString() {
        String stringBuffer;
        synchronized (this.f20748T) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(getClass().getName());
            stringBuffer2.append(" [connected=");
            stringBuffer2.append(this.f20762y);
            if (this.f20762y) {
                stringBuffer2.append(", host=");
                stringBuffer2.append(this.f20757t);
                stringBuffer2.append(", port=");
                stringBuffer2.append(this.f20758u);
            }
            stringBuffer2.append(", connector=");
            stringBuffer2.append(this.f20751n);
            stringBuffer2.append(", security=");
            switch (this.f20759v) {
                case 0:
                    stringBuffer2.append("SECURITY_FTP");
                    break;
                case 1:
                    stringBuffer2.append("SECURITY_FTPS");
                    break;
                case 2:
                    stringBuffer2.append("SECURITY_FTPES");
                    break;
            }
            stringBuffer2.append(", authenticated=");
            stringBuffer2.append(this.f20763z);
            if (this.f20763z) {
                stringBuffer2.append(", username=");
                stringBuffer2.append(this.f20760w);
                stringBuffer2.append(", password=");
                StringBuffer stringBuffer3 = new StringBuffer();
                for (int i = 0; i < this.f20761x.length(); i++) {
                    stringBuffer3.append('*');
                }
                stringBuffer2.append(stringBuffer3);
                stringBuffer2.append(", restSupported=");
                stringBuffer2.append(this.f20735G);
                stringBuffer2.append(", utf8supported=");
                stringBuffer2.append(this.f20738J);
                stringBuffer2.append(", mlsdSupported=");
                stringBuffer2.append(this.f20739K);
                stringBuffer2.append(", mode=modezSupported");
                stringBuffer2.append(this.f20740L);
                stringBuffer2.append(", mode=modezEnabled");
                stringBuffer2.append(this.f20741M);
            }
            stringBuffer2.append(", transfer mode=");
            stringBuffer2.append(this.f20729A ? "passive" : "active");
            stringBuffer2.append(", transfer type=");
            switch (this.f20730B) {
                case 0:
                    stringBuffer2.append("TYPE_AUTO");
                    break;
                case 1:
                    stringBuffer2.append("TYPE_TEXTUAL");
                    break;
                case 2:
                    stringBuffer2.append("TYPE_BINARY");
                    break;
            }
            stringBuffer2.append(", textualExtensionRecognizer=");
            stringBuffer2.append(this.f20755r);
            AbstractC4876r[] m3036t = m3036t();
            if (m3036t.length > 0) {
                stringBuffer2.append(", listParsers=");
                for (int i2 = 0; i2 < m3036t.length; i2++) {
                    if (i2 > 0) {
                        stringBuffer2.append(", ");
                    }
                    stringBuffer2.append(m3036t[i2]);
                }
            }
            AbstractC4865g[] m3037s = m3037s();
            if (m3037s.length > 0) {
                stringBuffer2.append(", communicationListeners=");
                for (int i3 = 0; i3 < m3037s.length; i3++) {
                    if (i3 > 0) {
                        stringBuffer2.append(", ");
                    }
                    stringBuffer2.append(m3037s[i3]);
                }
            }
            stringBuffer2.append(", autoNoopTimeout=");
            stringBuffer2.append(this.f20732D);
            stringBuffer2.append("]");
            stringBuffer = stringBuffer2.toString();
        }
        return stringBuffer;
    }

    /* renamed from: u */
    public void m3035u() {
        this.f20751n.m3008b();
    }

    /* renamed from: v */
    public void m3034v() {
        if (this.f20750V != null) {
            this.f20750V.m3023a();
            this.f20750V = null;
        }
        this.f20762y = false;
        m3111N();
    }

    /* renamed from: w */
    public void m3033w() {
        synchronized (this.f20748T) {
            if (!this.f20762y) {
                throw new IllegalStateException("Client not connected");
            }
            if (!this.f20763z) {
                throw new IllegalStateException("Client not authenticated");
            }
            this.f20750V.m3021a("REIN");
            C4877s m3016c = this.f20750V.m3016c();
            if (!m3016c.m2981b()) {
                throw new C4871m(m3016c);
            }
            m3111N();
            this.f20763z = false;
            this.f20760w = null;
            this.f20761x = null;
        }
    }

    /* renamed from: x */
    public void m3032x() {
        synchronized (this.f20748T) {
            if (!this.f20762y) {
                throw new IllegalStateException("Client not connected");
            }
            if (!this.f20763z) {
                throw new IllegalStateException("Client not authenticated");
            }
            this.f20750V.m3021a("NOOP");
            C4877s m3016c = this.f20750V.m3016c();
            if (!m3016c.m2981b()) {
                throw new C4871m(m3016c);
            }
            m3110O();
        }
    }

    /* renamed from: y */
    public String m3031y() {
        String substring;
        synchronized (this.f20748T) {
            if (!this.f20762y) {
                throw new IllegalStateException("Client not connected");
            }
            if (!this.f20763z) {
                throw new IllegalStateException("Client not authenticated");
            }
            this.f20750V.m3021a("PWD");
            C4877s m3016c = this.f20750V.m3016c();
            m3110O();
            if (!m3016c.m2981b()) {
                throw new C4871m(m3016c);
            }
            String[] m2980c = m3016c.m2980c();
            if (m2980c.length != 1) {
                throw new C4873o();
            }
            Matcher matcher = f20728m.matcher(m2980c[0]);
            if (!matcher.find()) {
                throw new C4873o();
            }
            substring = m2980c[0].substring(matcher.start() + 1, matcher.end() - 1);
        }
        return substring;
    }

    /* renamed from: z */
    public void m3030z() {
        synchronized (this.f20748T) {
            if (!this.f20762y) {
                throw new IllegalStateException("Client not connected");
            }
            if (!this.f20763z) {
                throw new IllegalStateException("Client not authenticated");
            }
            this.f20750V.m3021a("CDUP");
            C4877s m3016c = this.f20750V.m3016c();
            m3110O();
            if (!m3016c.m2981b()) {
                throw new C4871m(m3016c);
            }
        }
    }
}
