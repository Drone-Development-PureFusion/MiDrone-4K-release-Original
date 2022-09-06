package p004b.p005a.p006a.p028b.p056q;

import java.util.ArrayList;
import java.util.List;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p054o.C0539r;
import p004b.p005a.p006a.p028b.p056q.C0562d;
/* renamed from: b.a.a.b.q.e */
/* loaded from: classes.dex */
public class C0564e {

    /* renamed from: a */
    final String f1253a;

    /* renamed from: b */
    final int f1254b;

    /* renamed from: c */
    EnumC0566a f1255c = EnumC0566a.LITERAL_STATE;

    /* renamed from: d */
    int f1256d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b.a.a.b.q.e$a */
    /* loaded from: classes.dex */
    public enum EnumC0566a {
        LITERAL_STATE,
        START_STATE,
        DEFAULT_VAL_STATE
    }

    public C0564e(String str) {
        this.f1253a = str;
        this.f1254b = str.length();
    }

    /* renamed from: a */
    private void m20126a(char c, List<C0562d> list, StringBuilder sb) {
        switch (c) {
            case '$':
                sb.append(C0359h.f671A);
                m20125a(list, sb);
                sb.setLength(0);
                this.f1255c = EnumC0566a.START_STATE;
                return;
            case '-':
                list.add(C0562d.f1244d);
                this.f1255c = EnumC0566a.LITERAL_STATE;
                return;
            default:
                sb.append(C0359h.f671A).append(c);
                this.f1255c = EnumC0566a.LITERAL_STATE;
                return;
        }
    }

    /* renamed from: a */
    private void m20125a(List<C0562d> list, StringBuilder sb) {
        if (sb.length() == 0) {
            return;
        }
        list.add(new C0562d(C0562d.EnumC0563a.LITERAL, sb.toString()));
    }

    /* renamed from: b */
    private void m20124b(char c, List<C0562d> list, StringBuilder sb) {
        if (c == '{') {
            list.add(C0562d.f1241a);
        } else {
            sb.append(C0359h.f679I).append(c);
        }
        this.f1255c = EnumC0566a.LITERAL_STATE;
    }

    /* renamed from: c */
    private void m20123c(char c, List<C0562d> list, StringBuilder sb) {
        if (c == '$') {
            m20125a(list, sb);
            sb.setLength(0);
            this.f1255c = EnumC0566a.START_STATE;
        } else if (c == ':') {
            m20125a(list, sb);
            sb.setLength(0);
            this.f1255c = EnumC0566a.DEFAULT_VAL_STATE;
        } else if (c == '{') {
            m20125a(list, sb);
            list.add(C0562d.f1242b);
            sb.setLength(0);
        } else if (c != '}') {
            sb.append(c);
        } else {
            m20125a(list, sb);
            list.add(C0562d.f1243c);
            sb.setLength(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public List<C0562d> m20127a() {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        while (this.f1256d < this.f1254b) {
            char charAt = this.f1253a.charAt(this.f1256d);
            this.f1256d++;
            switch (this.f1255c) {
                case LITERAL_STATE:
                    m20123c(charAt, arrayList, sb);
                    break;
                case START_STATE:
                    m20124b(charAt, arrayList, sb);
                    break;
                case DEFAULT_VAL_STATE:
                    m20126a(charAt, arrayList, sb);
                    break;
            }
        }
        switch (this.f1255c) {
            case START_STATE:
                throw new C0539r("Unexpected end of pattern string");
            case LITERAL_STATE:
                m20125a(arrayList, sb);
                break;
        }
        return arrayList;
    }
}
