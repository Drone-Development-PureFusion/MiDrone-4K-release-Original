package p004b.p005a.p006a.p028b.p044i.p046b;

import com.fimi.soul.module.setting.newhand.C3530b;
import java.util.ArrayList;
import java.util.List;
import p004b.p005a.p006a.p028b.p044i.p046b.C0440i;
import p004b.p005a.p006a.p028b.p044i.p047c.AbstractC0446c;
import p004b.p005a.p006a.p028b.p044i.p047c.C0445b;
import p004b.p005a.p006a.p028b.p054o.C0539r;
/* renamed from: b.a.a.b.i.b.e */
/* loaded from: classes.dex */
public class C0436e {

    /* renamed from: g */
    private static final int f947g = 0;

    /* renamed from: h */
    private static final int f948h = 1;

    /* renamed from: i */
    private static final int f949i = 2;

    /* renamed from: a */
    final AbstractC0446c f950a;

    /* renamed from: b */
    final C0440i f951b;

    /* renamed from: c */
    final String f952c;

    /* renamed from: d */
    final int f953d;

    /* renamed from: e */
    char f954e;

    /* renamed from: f */
    int f955f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0436e(C0440i c0440i) {
        this(c0440i, new C0445b());
    }

    C0436e(C0440i c0440i, AbstractC0446c abstractC0446c) {
        this.f955f = 0;
        this.f951b = c0440i;
        this.f952c = c0440i.f980a;
        this.f953d = c0440i.f981b;
        this.f950a = abstractC0446c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m20527a(char c, List<C0439h> list) {
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList = new ArrayList();
        while (this.f951b.f985f < this.f953d) {
            switch (this.f955f) {
                case 0:
                    switch (c) {
                        case '\t':
                        case '\n':
                        case '\r':
                        case ' ':
                        case C3530b.f14179p /* 44 */:
                            break;
                        case '\"':
                        case '\'':
                            this.f955f = 2;
                            this.f954e = c;
                            continue;
                        case '}':
                            m20525a(list, arrayList);
                            return;
                        default:
                            stringBuffer.append(c);
                            this.f955f = 1;
                            continue;
                    }
                case 1:
                    switch (c) {
                        case C3530b.f14179p /* 44 */:
                            arrayList.add(stringBuffer.toString().trim());
                            stringBuffer.setLength(0);
                            this.f955f = 0;
                            continue;
                        case '}':
                            arrayList.add(stringBuffer.toString().trim());
                            m20525a(list, arrayList);
                            return;
                        default:
                            stringBuffer.append(c);
                            continue;
                    }
                case 2:
                    if (c != this.f954e) {
                        if (c != '\\') {
                            stringBuffer.append(c);
                            break;
                        } else {
                            m20526a(String.valueOf(this.f954e), stringBuffer);
                            break;
                        }
                    } else {
                        arrayList.add(stringBuffer.toString());
                        stringBuffer.setLength(0);
                        this.f955f = 0;
                        break;
                    }
            }
            c = this.f952c.charAt(this.f951b.f985f);
            this.f951b.f985f++;
        }
        if (c == '}') {
            if (this.f955f == 0) {
                m20525a(list, arrayList);
                return;
            } else if (this.f955f != 1) {
                throw new C0539r("Unexpected end of pattern string in OptionTokenizer");
            } else {
                arrayList.add(stringBuffer.toString().trim());
                m20525a(list, arrayList);
                return;
            }
        }
        throw new C0539r("Unexpected end of pattern string in OptionTokenizer");
    }

    /* renamed from: a */
    void m20526a(String str, StringBuffer stringBuffer) {
        if (this.f951b.f985f < this.f953d) {
            String str2 = this.f952c;
            C0440i c0440i = this.f951b;
            int i = c0440i.f985f;
            c0440i.f985f = i + 1;
            this.f950a.mo20494a(str, stringBuffer, str2.charAt(i), this.f951b.f985f);
        }
    }

    /* renamed from: a */
    void m20525a(List<C0439h> list, List<String> list2) {
        list.add(new C0439h(1006, list2));
        this.f951b.f984e = C0440i.EnumC0442a.LITERAL_STATE;
    }
}
