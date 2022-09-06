package p004b.p005a.p006a.p028b.p035g.p037b;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.sax2.Driver;
import p004b.p005a.p006a.p028b.AbstractC0292f;
import p004b.p005a.p006a.p028b.p035g.p039d.C0340g;
import p004b.p005a.p006a.p028b.p035g.p039d.C0346m;
import p004b.p005a.p006a.p028b.p054o.AbstractC0526e;
import p004b.p005a.p006a.p028b.p054o.C0528g;
import p004b.p005a.p006a.p028b.p055p.AbstractC0547g;
/* renamed from: b.a.a.b.g.b.e */
/* loaded from: classes.dex */
public class C0329e extends DefaultHandler implements AbstractC0526e {

    /* renamed from: a */
    C0340g f618a;

    /* renamed from: b */
    private final C0528g f619b;

    /* renamed from: c */
    private List<C0328d> f620c;

    /* renamed from: d */
    private Locator f621d;

    public C0329e() {
        this.f620c = new ArrayList();
        this.f618a = new C0340g();
        this.f619b = new C0528g(null, this);
    }

    public C0329e(AbstractC0292f abstractC0292f) {
        this.f620c = new ArrayList();
        this.f618a = new C0340g();
        this.f619b = new C0528g(abstractC0292f, this);
    }

    /* renamed from: a */
    private Driver m20929a() {
        try {
            Driver driver = new Driver();
            try {
                driver.setFeature("http://xml.org/sax/features/validation", false);
            } catch (SAXNotSupportedException e) {
            }
            driver.setFeature("http://xml.org/sax/features/namespaces", true);
            return driver;
        } catch (Exception e2) {
            mo20231a("Parser configuration error occurred", e2);
            throw new C0346m("Parser configuration error occurred", e2);
        }
    }

    /* renamed from: d */
    private void m20921d(String str, Throwable th) {
        mo20231a(str, th);
        throw new C0346m(str, th);
    }

    /* renamed from: a */
    String m20927a(String str, String str2) {
        return (str == null || str.length() < 1) ? str2 : str;
    }

    /* renamed from: a */
    public List<C0328d> mo20926a(InputSource inputSource) {
        Driver m20929a = m20929a();
        try {
            m20929a.setContentHandler(this);
            m20929a.setErrorHandler(this);
            m20929a.parse(inputSource);
            return this.f620c;
        } catch (EOFException e) {
            m20921d(e.getLocalizedMessage(), new SAXParseException(e.getLocalizedMessage(), this.f621d, e));
            throw new IllegalStateException("This point can never be reached");
        } catch (IOException e2) {
            m20921d("I/O error occurred while parsing xml file", e2);
            throw new IllegalStateException("This point can never be reached");
        } catch (SAXException e3) {
            throw new C0346m("Problem parsing XML document. See previously reported errors.", e3);
        } catch (Exception e4) {
            m20921d("Unexpected exception while parsing XML document.", e4);
            throw new IllegalStateException("This point can never be reached");
        }
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: a */
    public void mo20233a(AbstractC0292f abstractC0292f) {
        this.f619b.mo20233a(abstractC0292f);
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: a */
    public void mo20232a(AbstractC0547g abstractC0547g) {
        this.f619b.mo20232a(abstractC0547g);
    }

    /* renamed from: a */
    public final void m20928a(InputStream inputStream) {
        mo20926a(new InputSource(inputStream));
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: a */
    public void mo20231a(String str, Throwable th) {
        this.f619b.mo20231a(str, th);
    }

    /* renamed from: b */
    public Locator m20925b() {
        return this.f621d;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: b */
    public void mo20229b(String str, Throwable th) {
        this.f619b.mo20229b(str, th);
    }

    /* renamed from: b */
    boolean m20924b(String str) {
        return str.trim().length() == 0;
    }

    /* renamed from: c */
    C0328d m20923c() {
        if (this.f620c.isEmpty()) {
            return null;
        }
        return this.f620c.get(this.f620c.size() - 1);
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: c */
    public void mo20228c(String str) {
        this.f619b.mo20228c(str);
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: c */
    public void mo20227c(String str, Throwable th) {
        this.f619b.mo20227c(str, th);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) {
        String str = new String(cArr, i, i2);
        C0328d m20923c = m20923c();
        if (m20923c instanceof C0325a) {
            ((C0325a) m20923c).m20935a(str);
        } else if (m20924b(str)) {
        } else {
            this.f620c.add(new C0325a(str, m20925b()));
        }
    }

    /* renamed from: d */
    public List<C0328d> m20922d() {
        return this.f620c;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: d */
    public void mo20226d(String str) {
        this.f619b.mo20226d(str);
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: e */
    public void mo20225e(String str) {
        this.f619b.mo20225e(str);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        if (str3 == null || str3.length() == 0) {
        }
        this.f620c.add(new C0326b(str, str2, str3, m20925b()));
        this.f618a.m20899c();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ErrorHandler
    public void error(SAXParseException sAXParseException) {
        mo20231a("XML_PARSING - Parsing error on line " + sAXParseException.getLineNumber() + " and column " + sAXParseException.getColumnNumber(), sAXParseException);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ErrorHandler
    public void fatalError(SAXParseException sAXParseException) {
        mo20231a("XML_PARSING - Parsing fatal error on line " + sAXParseException.getLineNumber() + " and column " + sAXParseException.getColumnNumber(), sAXParseException);
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0526e
    /* renamed from: h_ */
    public AbstractC0292f mo20224h_() {
        return this.f619b.mo20224h_();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator locator) {
        this.f621d = locator;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() {
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        if (str3 == null || str3.length() == 0) {
        }
        this.f618a.m20902a(m20927a(str2, str3));
        this.f620c.add(new C0330f(this.f618a.m20904a(), str, str2, str3, attributes, m20925b()));
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ErrorHandler
    public void warning(SAXParseException sAXParseException) {
        mo20227c("XML_PARSING - Parsing warning on line " + sAXParseException.getLineNumber() + " and column " + sAXParseException.getColumnNumber(), sAXParseException);
    }
}
