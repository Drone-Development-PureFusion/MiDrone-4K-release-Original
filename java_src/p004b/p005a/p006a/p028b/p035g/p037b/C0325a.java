package p004b.p005a.p006a.p028b.p035g.p037b;

import com.xiaomi.mipush.sdk.Constants;
import org.xml.sax.Locator;
/* renamed from: b.a.a.b.g.b.a */
/* loaded from: classes.dex */
public class C0325a extends C0328d {

    /* renamed from: e */
    private String f613e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0325a(String str, Locator locator) {
        super(null, null, null, locator);
        this.f613e = str;
    }

    /* renamed from: a */
    public String m20936a() {
        return this.f613e != null ? this.f613e.trim() : this.f613e;
    }

    /* renamed from: a */
    public void m20935a(String str) {
        this.f613e += str;
    }

    public String toString() {
        return "BodyEvent(" + m20936a() + ")" + this.f617d.getLineNumber() + Constants.ACCEPT_TIME_SEPARATOR_SP + this.f617d.getColumnNumber();
    }
}
