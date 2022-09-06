package p004b.p005a.p006a.p028b.p035g.p037b;

import com.xiaomi.mipush.sdk.Constants;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.helpers.AttributesImpl;
import p004b.p005a.p006a.p028b.p035g.p039d.C0340g;
/* renamed from: b.a.a.b.g.b.f */
/* loaded from: classes.dex */
public class C0330f extends C0328d {

    /* renamed from: e */
    public final Attributes f622e;

    /* renamed from: f */
    public final C0340g f623f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0330f(C0340g c0340g, String str, String str2, String str3, Attributes attributes, Locator locator) {
        super(str, str2, str3, locator);
        this.f622e = new AttributesImpl(attributes);
        this.f623f = c0340g;
    }

    /* renamed from: a */
    public Attributes m20920a() {
        return this.f622e;
    }

    public String toString() {
        return "StartEvent(" + e() + ")  [" + this.f617d.getLineNumber() + Constants.ACCEPT_TIME_SEPARATOR_SP + this.f617d.getColumnNumber() + "]";
    }
}
