package it.p235a.p236a.p239c;

import it.p235a.p236a.AbstractC4876r;
import it.p235a.p236a.C4872n;
import it.p235a.p236a.C4875q;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* renamed from: it.a.a.c.a */
/* loaded from: classes.dex */
public class C4857a implements AbstractC4876r {

    /* renamed from: a */
    private static final Pattern f20769a = Pattern.compile("^(\\d{2})-(\\d{2})-(\\d{2})\\s+(\\d{2}):(\\d{2})(AM|PM)\\s+(<DIR>|\\d+)\\s+([^\\\\/*?\"<>|]+)$");

    /* renamed from: b */
    private static final DateFormat f20770b = new SimpleDateFormat("MM/dd/yy hh:mm a");

    @Override // it.p235a.p236a.AbstractC4876r
    /* renamed from: a */
    public C4872n[] mo2983a(String[] strArr) {
        Date parse;
        int length = strArr.length;
        C4872n[] c4872nArr = new C4872n[length];
        for (int i = 0; i < length; i++) {
            Matcher matcher = f20769a.matcher(strArr[i]);
            if (!matcher.matches()) {
                throw new C4875q();
            }
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            String group3 = matcher.group(3);
            String group4 = matcher.group(4);
            String group5 = matcher.group(5);
            String group6 = matcher.group(6);
            String group7 = matcher.group(7);
            String group8 = matcher.group(8);
            c4872nArr[i] = new C4872n();
            c4872nArr[i].m2990a(group8);
            if (group7.equalsIgnoreCase("<DIR>")) {
                c4872nArr[i].m2992a(1);
                c4872nArr[i].m2991a(0L);
            } else {
                try {
                    long parseLong = Long.parseLong(group7);
                    c4872nArr[i].m2992a(0);
                    c4872nArr[i].m2991a(parseLong);
                } finally {
                    C4875q c4875q = new C4875q();
                }
            }
            String stringBuffer = new StringBuffer().append(group).append("/").append(group2).append("/").append(group3).append(" ").append(group4).append(":").append(group5).append(" ").append(group6).toString();
            try {
                synchronized (f20770b) {
                    parse = f20770b.parse(stringBuffer);
                }
                c4872nArr[i].m2989a(parse);
            } catch (ParseException e) {
                throw new C4875q();
            }
        }
        return c4872nArr;
    }
}
