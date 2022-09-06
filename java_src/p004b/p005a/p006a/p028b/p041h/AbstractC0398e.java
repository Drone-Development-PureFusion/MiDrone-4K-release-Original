package p004b.p005a.p006a.p028b.p041h;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import p004b.p005a.p006a.p028b.AbstractC0269b;
import p004b.p005a.p006a.p028b.AbstractC0459j;
import p004b.p005a.p006a.p028b.p030b.AbstractC0271b;
import p004b.p005a.p006a.p028b.p030b.C0270a;
import p004b.p005a.p006a.p028b.p033e.C0288a;
import p004b.p005a.p006a.p028b.p044i.AbstractC0454i;
import p004b.p005a.p006a.p028b.p053n.AbstractC0513f;
import p004b.p005a.p006a.p028b.p053n.C0512e;
import p004b.p005a.p006a.p028b.p054o.C0529h;
import p004b.p005a.p006a.p028b.p057r.C0572f;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.b.h.e */
/* loaded from: classes.dex */
public abstract class AbstractC0398e<E> extends AbstractC0269b<E> {

    /* renamed from: b */
    static InternetAddress[] f828b = new InternetAddress[0];

    /* renamed from: c */
    static final int f829c = 1228800000;

    /* renamed from: i */
    protected AbstractC0459j<E> f835i;

    /* renamed from: j */
    protected AbstractC0459j<E> f836j;

    /* renamed from: k */
    String f837k;

    /* renamed from: l */
    String f838l;

    /* renamed from: m */
    String f839m;

    /* renamed from: o */
    protected MimeMessage f841o;

    /* renamed from: p */
    protected AbstractC0271b<E> f842p;

    /* renamed from: r */
    protected C0529h<E> f844r;

    /* renamed from: u */
    private String f845u;

    /* renamed from: w */
    private String f847w;

    /* renamed from: d */
    long f833d = 0;

    /* renamed from: e */
    int f834e = 300000;

    /* renamed from: a */
    private List<AbstractC0454i<E>> f832a = new ArrayList();

    /* renamed from: v */
    private String f846v = null;

    /* renamed from: x */
    private int f848x = 25;

    /* renamed from: y */
    private boolean f849y = false;

    /* renamed from: z */
    private boolean f850z = false;

    /* renamed from: n */
    boolean f840n = true;

    /* renamed from: A */
    private String f830A = "UTF-8";

    /* renamed from: q */
    protected AbstractC0513f<E> f843q = new C0512e();

    /* renamed from: B */
    private int f831B = 0;

    /* renamed from: b.a.a.b.h.e$a */
    /* loaded from: classes.dex */
    class RunnableC0399a implements Runnable {

        /* renamed from: a */
        final C0288a<E> f851a;

        /* renamed from: b */
        final E f852b;

        RunnableC0399a(C0288a<E> c0288a, E e) {
            this.f851a = c0288a;
            this.f852b = e;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC0398e.this.m20623b((C0288a<C0288a<E>>) this.f851a, (C0288a<E>) this.f852b);
        }
    }

    /* renamed from: a */
    private Session m20635a() {
        Properties properties = new Properties(C0589u.m20070a());
        if (this.f847w != null) {
            properties.put("mail.smtp.host", this.f847w);
        }
        properties.put("mail.smtp.port", Integer.toString(this.f848x));
        if (this.f839m != null) {
            properties.put("mail.smtp.localhost", this.f839m);
        }
        C0397d c0397d = null;
        if (this.f837k != null) {
            c0397d = new C0397d(this.f837k, this.f838l);
            properties.put("mail.smtp.auth", "true");
        }
        if (!m20593v() || !m20592w()) {
            if (m20593v()) {
                properties.put("mail.smtp.starttls.enable", "true");
            }
            if (m20592w()) {
                properties.put("mail.smtp.socketFactory.port", Integer.toString(this.f848x));
                properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.socketFactory.fallback", "true");
            }
        } else {
            c("Both SSL and StartTLS cannot be enabled simultaneously");
        }
        return Session.getInstance(properties, c0397d);
    }

    /* renamed from: c */
    private List<InternetAddress> m20620c(E e) {
        int size = this.f832a.size();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            try {
                String a = this.f832a.get(i).a((AbstractC0454i<E>) e);
                if (a != null && a.length() != 0) {
                    arrayList.addAll(Arrays.asList(InternetAddress.parse(a, true)));
                }
            } catch (AddressException e2) {
                a("Could not parse email address for [" + this.f832a.get(i) + "] for event [" + e + "]", (Throwable) e2);
                return arrayList;
            }
        }
        return arrayList;
    }

    /* renamed from: A */
    public AbstractC0459j<E> m20636A() {
        return this.f836j;
    }

    /* renamed from: a */
    protected abstract AbstractC0459j<E> mo20627a(String str);

    /* renamed from: a */
    public void m20634a(int i) {
        m20624b(i);
    }

    /* renamed from: a */
    public void m20633a(AbstractC0271b<E> abstractC0271b) {
        this.f842p = abstractC0271b;
    }

    /* renamed from: a */
    protected abstract void mo20632a(C0288a<E> c0288a, E e);

    /* renamed from: a */
    protected abstract void mo20631a(C0288a<E> c0288a, StringBuffer stringBuffer);

    /* renamed from: a */
    public void m20630a(AbstractC0459j<E> abstractC0459j) {
        this.f836j = abstractC0459j;
    }

    /* renamed from: a */
    public void m20629a(AbstractC0513f<E> abstractC0513f) {
        this.f843q = abstractC0513f;
    }

    /* renamed from: a */
    public void m20628a(C0529h<E> c0529h) {
        this.f844r = c0529h;
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0269b
    /* renamed from: a */
    protected void mo20289a(E e) {
        if (!m20625b()) {
            return;
        }
        String mo20295a = this.f843q.mo20295a(e);
        long currentTimeMillis = System.currentTimeMillis();
        C0288a<E> a = this.f844r.a(mo20295a, currentTimeMillis);
        mo20632a((C0288a<C0288a<E>>) a, (C0288a<E>) e);
        try {
            if (this.f842p.mo21090a((AbstractC0271b<E>) e)) {
                C0288a<E> c0288a = new C0288a<>(a);
                a.m21034a();
                if (this.f840n) {
                    this.f1190s.mo20993s().execute(new RunnableC0399a(c0288a, e));
                } else {
                    m20623b((C0288a<C0288a<E>>) c0288a, (C0288a<E>) e);
                }
            }
        } catch (C0270a e2) {
            this.f831B++;
            if (this.f831B < 4) {
                a("SMTPAppender's EventEvaluator threw an Exception-", e2);
            }
        }
        if (mo20622b((AbstractC0398e<E>) e)) {
            this.f844r.d(mo20295a);
        }
        this.f844r.a(currentTimeMillis);
        if (this.f833d + this.f834e >= currentTimeMillis) {
            return;
        }
        d("SMTPAppender [" + this.f476g + "] is tracking [" + this.f844r.a() + "] buffers");
        this.f833d = currentTimeMillis;
        if (this.f834e >= f829c) {
            return;
        }
        this.f834e *= 4;
    }

    /* renamed from: a */
    public void m20626a(MimeMessage mimeMessage) {
        this.f841o = mimeMessage;
    }

    /* renamed from: b */
    public void m20624b(int i) {
        this.f848x = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0067 A[Catch: Exception -> 0x00d8, TryCatch #0 {Exception -> 0x00d8, blocks: (B:3:0x0001, B:5:0x0013, B:6:0x0016, B:8:0x001e, B:9:0x0021, B:11:0x002c, B:12:0x002f, B:14:0x0037, B:15:0x003a, B:17:0x0040, B:19:0x0048, B:21:0x0050, B:22:0x0056, B:24:0x0067, B:27:0x006f, B:29:0x008a, B:30:0x0097, B:32:0x00df), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006f A[Catch: Exception -> 0x00d8, TryCatch #0 {Exception -> 0x00d8, blocks: (B:3:0x0001, B:5:0x0013, B:6:0x0016, B:8:0x001e, B:9:0x0021, B:11:0x002c, B:12:0x002f, B:14:0x0037, B:15:0x003a, B:17:0x0040, B:19:0x0048, B:21:0x0050, B:22:0x0056, B:24:0x0067, B:27:0x006f, B:29:0x008a, B:30:0x0097, B:32:0x00df), top: B:2:0x0001 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void m20623b(C0288a<E> c0288a, E e) {
        String str;
        List<InternetAddress> m20620c;
        try {
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            StringBuffer stringBuffer = new StringBuffer();
            String mo20445e = this.f836j.mo20445e();
            if (mo20445e != null) {
                stringBuffer.append(mo20445e);
            }
            String mo20444f = this.f836j.mo20444f();
            if (mo20444f != null) {
                stringBuffer.append(mo20444f);
            }
            mo20631a((C0288a) c0288a, stringBuffer);
            String mo20443g = this.f836j.mo20443g();
            if (mo20443g != null) {
                stringBuffer.append(mo20443g);
            }
            String mo20442h = this.f836j.mo20442h();
            if (mo20442h != null) {
                stringBuffer.append(mo20442h);
            }
            String str2 = "Undefined subject";
            if (this.f835i != null) {
                str2 = this.f835i.mo20455a((AbstractC0459j<E>) e);
                int indexOf = str2 != null ? str2.indexOf(10) : -1;
                if (indexOf > -1) {
                    str = str2.substring(0, indexOf);
                    this.f841o.setSubject(str, this.f830A);
                    m20620c = m20620c((AbstractC0398e<E>) e);
                    if (!m20620c.isEmpty()) {
                        d("Empty destination address. Aborting email transmission");
                        return;
                    }
                    InternetAddress[] internetAddressArr = (InternetAddress[]) m20620c.toArray(f828b);
                    this.f841o.setRecipients(Message.RecipientType.TO, internetAddressArr);
                    String mo20447d = this.f836j.mo20447d();
                    if (C0572f.m20114a(mo20447d)) {
                        mimeBodyPart.setText(stringBuffer.toString(), this.f830A, C0572f.m20113b(mo20447d));
                    } else {
                        mimeBodyPart.setContent(stringBuffer.toString(), this.f836j.mo20447d());
                    }
                    MimeMultipart mimeMultipart = new MimeMultipart();
                    mimeMultipart.addBodyPart(mimeBodyPart);
                    this.f841o.setContent(mimeMultipart);
                    this.f841o.setSentDate(new Date());
                    d("About to send out SMTP message \"" + str + "\" to " + Arrays.toString(internetAddressArr));
                    Transport.send(this.f841o);
                    return;
                }
            }
            str = str2;
            this.f841o.setSubject(str, this.f830A);
            m20620c = m20620c((AbstractC0398e<E>) e);
            if (!m20620c.isEmpty()) {
            }
        } catch (Exception e2) {
            a("Error occurred while sending e-mail notification.", e2);
        }
    }

    /* renamed from: b */
    public void m20621b(boolean z) {
        this.f840n = z;
    }

    /* renamed from: b */
    public boolean m20625b() {
        if (!this.f475f) {
            c("Attempting to append to a non-started appender: " + g());
            return false;
        } else if (this.f841o == null) {
            c("Message object not configured.");
            return false;
        } else if (this.f842p == null) {
            c("No EventEvaluator is set for appender [" + this.f476g + "].");
            return false;
        } else if (this.f836j != null) {
            return true;
        } else {
            c("No layout set for appender named [" + this.f476g + "]. For more information, please visit http://logback.qos.ch/codes.html#smtp_no_layout");
            return false;
        }
    }

    /* renamed from: b */
    protected abstract boolean mo20622b(E e);

    /* renamed from: c */
    public void m20619c(boolean z) {
        this.f849y = z;
    }

    /* renamed from: d */
    public List<AbstractC0454i<E>> m20618d() {
        return this.f832a;
    }

    /* renamed from: d */
    public void m20617d(boolean z) {
        this.f850z = z;
    }

    /* renamed from: e */
    public String m20616e() {
        return this.f845u;
    }

    /* renamed from: f */
    public String m20615f() {
        return this.f846v;
    }

    /* renamed from: f */
    InternetAddress m20614f(String str) {
        try {
            return new InternetAddress(str);
        } catch (AddressException e) {
            a("Could not parse address [" + str + "].", (Throwable) e);
            return null;
        }
    }

    /* renamed from: f_ */
    protected abstract AbstractC0454i<E> mo20613f_(String str);

    /* renamed from: g */
    public void m20612g(String str) {
        this.f845u = str;
    }

    /* renamed from: h */
    public void m20611h(String str) {
        this.f846v = str;
    }

    /* renamed from: i */
    public void m20610i(String str) {
        m20609j(str);
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0269b, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        if (this.f844r == null) {
            this.f844r = new C0529h<>();
        }
        Session m20635a = m20635a();
        if (m20635a == null) {
            c("Failed to obtain javax.mail.Session. Cannot start.");
            return;
        }
        this.f841o = new MimeMessage(m20635a);
        try {
            if (this.f845u != null) {
                this.f841o.setFrom(m20614f(this.f845u));
            } else {
                this.f841o.setFrom();
            }
            this.f835i = mo20627a(this.f846v);
            this.f475f = true;
        } catch (MessagingException e) {
            a("Could not activate SMTPAppender options.", (Throwable) e);
        }
    }

    /* renamed from: j */
    public void m20609j(String str) {
        this.f847w = str;
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0269b, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: k */
    public synchronized void mo20155k() {
        this.f475f = false;
    }

    /* renamed from: k */
    public void m20608k(String str) {
        this.f839m = str;
    }

    /* renamed from: l */
    public String m20607l() {
        return m20605m();
    }

    /* renamed from: l */
    public void m20606l(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Null or empty <to> property");
        }
        AbstractC0454i<E> mo20613f_ = mo20613f_(str.trim());
        mo20613f_.a(this.f1190s);
        mo20613f_.mo20156j();
        this.f832a.add(mo20613f_);
    }

    /* renamed from: m */
    public String m20605m() {
        return this.f847w;
    }

    /* renamed from: m */
    public void m20604m(String str) {
        this.f837k = str;
    }

    /* renamed from: n */
    public int m20603n() {
        return m20601o();
    }

    /* renamed from: n */
    public void m20602n(String str) {
        this.f838l = str;
    }

    /* renamed from: o */
    public int m20601o() {
        return this.f848x;
    }

    /* renamed from: o */
    public void m20600o(String str) {
        this.f830A = str;
    }

    /* renamed from: p */
    public String m20599p() {
        return this.f839m;
    }

    /* renamed from: q */
    public C0529h<E> m20598q() {
        return this.f844r;
    }

    /* renamed from: r */
    public AbstractC0513f<E> m20597r() {
        return this.f843q;
    }

    /* renamed from: s */
    public boolean m20596s() {
        return this.f840n;
    }

    /* renamed from: t */
    public List<String> m20595t() {
        ArrayList arrayList = new ArrayList();
        for (AbstractC0454i<E> abstractC0454i : this.f832a) {
            arrayList.add(abstractC0454i.m20471l());
        }
        return arrayList;
    }

    /* renamed from: u */
    public Message m20594u() {
        return this.f841o;
    }

    /* renamed from: v */
    public boolean m20593v() {
        return this.f849y;
    }

    /* renamed from: w */
    public boolean m20592w() {
        return this.f850z;
    }

    /* renamed from: x */
    public String m20591x() {
        return this.f837k;
    }

    /* renamed from: y */
    public String m20590y() {
        return this.f838l;
    }

    /* renamed from: z */
    public String m20589z() {
        return this.f830A;
    }
}
