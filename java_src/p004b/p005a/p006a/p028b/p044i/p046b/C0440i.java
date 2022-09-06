package p004b.p005a.p006a.p028b.p044i.p046b;

import com.autonavi.amap.mapcore.ERROR_CODE;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import p004b.p005a.p006a.p028b.p044i.p047c.AbstractC0446c;
import p004b.p005a.p006a.p028b.p044i.p047c.C0447d;
import p004b.p005a.p006a.p028b.p044i.p047c.C0448e;
import p004b.p005a.p006a.p028b.p054o.C0539r;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: b.a.a.b.i.b.i */
/* loaded from: classes.dex */
public class C0440i {

    /* renamed from: a */
    final String f980a;

    /* renamed from: b */
    final int f981b;

    /* renamed from: c */
    final AbstractC0446c f982c;

    /* renamed from: d */
    final AbstractC0446c f983d;

    /* renamed from: e */
    EnumC0442a f984e;

    /* renamed from: f */
    int f985f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b.a.a.b.i.b.i$a */
    /* loaded from: classes.dex */
    public enum EnumC0442a {
        LITERAL_STATE,
        FORMAT_MODIFIER_STATE,
        KEYWORD_STATE,
        OPTION_STATE,
        RIGHT_PARENTHESIS_STATE
    }

    C0440i(String str) {
        this(str, new C0447d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0440i(String str, AbstractC0446c abstractC0446c) {
        this.f983d = new C0448e();
        this.f984e = EnumC0442a.LITERAL_STATE;
        this.f985f = 0;
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("null or empty pattern string not allowed");
        }
        this.f980a = str;
        this.f981b = str.length();
        this.f982c = abstractC0446c;
    }

    /* renamed from: a */
    private void m20507a(char c, List<C0439h> list, StringBuffer stringBuffer) {
        list.add(C0439h.f975n);
        switch (c) {
            case ')':
                return;
            case Opcodes.DUP2 /* 92 */:
                m20505a("%{}", stringBuffer);
                this.f984e = EnumC0442a.LITERAL_STATE;
                return;
            case Opcodes.LSHR /* 123 */:
                this.f984e = EnumC0442a.OPTION_STATE;
                return;
            default:
                stringBuffer.append(c);
                this.f984e = EnumC0442a.LITERAL_STATE;
                return;
        }
    }

    /* renamed from: a */
    private void m20506a(int i, StringBuffer stringBuffer, List<C0439h> list) {
        if (stringBuffer.length() > 0) {
            list.add(new C0439h(i, stringBuffer.toString()));
            stringBuffer.setLength(0);
        }
    }

    /* renamed from: b */
    private void m20504b(char c, List<C0439h> list, StringBuffer stringBuffer) {
        new C0436e(this).m20527a(c, list);
    }

    /* renamed from: c */
    private void m20502c(char c, List<C0439h> list, StringBuffer stringBuffer) {
        if (c == '(') {
            m20506a(1002, stringBuffer, list);
            list.add(C0439h.f976o);
            this.f984e = EnumC0442a.LITERAL_STATE;
        } else if (!Character.isJavaIdentifierStart(c)) {
            stringBuffer.append(c);
        } else {
            m20506a(1002, stringBuffer, list);
            this.f984e = EnumC0442a.KEYWORD_STATE;
            stringBuffer.append(c);
        }
    }

    /* renamed from: d */
    private void m20501d(char c, List<C0439h> list, StringBuffer stringBuffer) {
        switch (c) {
            case '%':
                m20506a(1000, stringBuffer, list);
                list.add(C0439h.f977p);
                this.f984e = EnumC0442a.FORMAT_MODIFIER_STATE;
                return;
            case ')':
                m20506a(1000, stringBuffer, list);
                this.f984e = EnumC0442a.RIGHT_PARENTHESIS_STATE;
                return;
            case Opcodes.DUP2 /* 92 */:
                m20505a("%()", stringBuffer);
                return;
            default:
                stringBuffer.append(c);
                return;
        }
    }

    /* renamed from: e */
    private void m20500e(char c, List<C0439h> list, StringBuffer stringBuffer) {
        if (Character.isJavaIdentifierPart(c)) {
            stringBuffer.append(c);
        } else if (c == '{') {
            m20506a(ERROR_CODE.CANCEL_ERROR, stringBuffer, list);
            this.f984e = EnumC0442a.OPTION_STATE;
        } else if (c == '(') {
            m20506a(1005, stringBuffer, list);
            this.f984e = EnumC0442a.LITERAL_STATE;
        } else if (c == '%') {
            m20506a(ERROR_CODE.CANCEL_ERROR, stringBuffer, list);
            list.add(C0439h.f977p);
            this.f984e = EnumC0442a.FORMAT_MODIFIER_STATE;
        } else if (c == ')') {
            m20506a(ERROR_CODE.CANCEL_ERROR, stringBuffer, list);
            this.f984e = EnumC0442a.RIGHT_PARENTHESIS_STATE;
        } else {
            m20506a(ERROR_CODE.CANCEL_ERROR, stringBuffer, list);
            if (c != '\\') {
                stringBuffer.append(c);
            } else if (this.f985f < this.f981b) {
                String str = this.f980a;
                int i = this.f985f;
                this.f985f = i + 1;
                this.f982c.mo20494a("%()", stringBuffer, str.charAt(i), this.f985f);
            }
            this.f984e = EnumC0442a.LITERAL_STATE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public List m20508a() {
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        while (this.f985f < this.f981b) {
            char charAt = this.f980a.charAt(this.f985f);
            this.f985f++;
            switch (this.f984e) {
                case LITERAL_STATE:
                    m20501d(charAt, arrayList, stringBuffer);
                    break;
                case FORMAT_MODIFIER_STATE:
                    m20502c(charAt, arrayList, stringBuffer);
                    break;
                case OPTION_STATE:
                    m20504b(charAt, arrayList, stringBuffer);
                    break;
                case KEYWORD_STATE:
                    m20500e(charAt, arrayList, stringBuffer);
                    break;
                case RIGHT_PARENTHESIS_STATE:
                    m20507a(charAt, arrayList, stringBuffer);
                    break;
            }
        }
        switch (this.f984e) {
            case LITERAL_STATE:
                m20506a(1000, stringBuffer, arrayList);
                break;
            case FORMAT_MODIFIER_STATE:
            case OPTION_STATE:
                throw new C0539r("Unexpected end of pattern string");
            case KEYWORD_STATE:
                arrayList.add(new C0439h(ERROR_CODE.CANCEL_ERROR, stringBuffer.toString()));
                break;
            case RIGHT_PARENTHESIS_STATE:
                arrayList.add(C0439h.f975n);
                break;
        }
        return arrayList;
    }

    /* renamed from: a */
    void m20505a(String str, StringBuffer stringBuffer) {
        if (this.f985f < this.f981b) {
            String str2 = this.f980a;
            int i = this.f985f;
            this.f985f = i + 1;
            this.f982c.mo20494a(str, stringBuffer, str2.charAt(i), this.f985f);
        }
    }

    /* renamed from: b */
    void m20503b(String str, StringBuffer stringBuffer) {
        if (this.f985f < this.f981b) {
            String str2 = this.f980a;
            int i = this.f985f;
            this.f985f = i + 1;
            this.f983d.mo20494a(str, stringBuffer, str2.charAt(i), this.f985f);
        }
    }
}
