package p004b.p005a.p006a.p028b.p035g.p039d;

import org.xml.sax.Locator;
import p004b.p005a.p006a.p028b.AbstractC0292f;
import p004b.p005a.p006a.p028b.p054o.C0528g;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: b.a.a.b.g.d.b */
/* loaded from: classes.dex */
public class C0333b extends C0528g {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C0333b(AbstractC0292f abstractC0292f, C0345l c0345l) {
        super(abstractC0292f, c0345l);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p004b.p005a.p006a.p028b.p054o.C0528g
    /* renamed from: a */
    public Object mo20234a() {
        Locator locator = ((C0345l) super.mo20234a()).f647a;
        return locator != null ? C0345l.class.getName() + "@" + locator.getLineNumber() + ":" + locator.getColumnNumber() : C0345l.class.getName() + "@NA:NA";
    }
}
