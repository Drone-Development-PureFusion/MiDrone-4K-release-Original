package it.p235a.p236a.p239c;

import com.tencent.p227mm.sdk.platformtools.Util;
import com.xiaomi.mipush.sdk.Constants;
import it.p235a.p236a.AbstractC4876r;
import it.p235a.p236a.C4872n;
import it.p235a.p236a.C4875q;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.p248a.p249a.p261f.p264c.C5122l;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p051m.p052a.C0477f;
/* renamed from: it.a.a.c.d */
/* loaded from: classes.dex */
public class C4860d implements AbstractC4876r {

    /* renamed from: a */
    private static final Pattern f20773a = Pattern.compile("^(d|-)\\s+\\[.{8}\\]\\s+\\S+\\s+(\\d+)\\s+(?:(\\w{3})\\s+(\\d{1,2}))\\s+(?:(\\d{4})|(?:(\\d{1,2}):(\\d{1,2})))\\s+([^\\\\/*?\"<>|]+)$");

    /* renamed from: b */
    private static final DateFormat f20774b = new SimpleDateFormat("MMM dd yyyy HH:mm", Locale.US);

    @Override // it.p235a.p236a.AbstractC4876r
    /* renamed from: a */
    public C4872n[] mo2983a(String[] strArr) {
        boolean z;
        Date parse;
        Date date;
        int length = strArr.length;
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(1);
        C4872n[] c4872nArr = new C4872n[length];
        for (int i2 = 0; i2 < length; i2++) {
            Matcher matcher = f20773a.matcher(strArr[i2]);
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
            c4872nArr[i2] = new C4872n();
            if (group.equals(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                c4872nArr[i2].m2992a(0);
            } else if (!group.equals(C0477f.f1054a)) {
                throw new C4875q();
            } else {
                c4872nArr[i2].m2992a(1);
            }
            try {
                c4872nArr[i2].m2991a(Long.parseLong(group2));
                if (group4.length() == 1) {
                    group4 = new StringBuffer().append("0").append(group4).toString();
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(group3);
                stringBuffer.append(C5122l.f21763c);
                stringBuffer.append(group4);
                stringBuffer.append(C5122l.f21763c);
                if (group5 == null) {
                    stringBuffer.append(i);
                    z = true;
                } else {
                    stringBuffer.append(group5);
                    z = false;
                }
                stringBuffer.append(C5122l.f21763c);
                if (group6 == null || group7 == null) {
                    stringBuffer.append("00:00");
                } else {
                    if (group6.length() == 1) {
                        group6 = new StringBuffer().append("0").append(group6).toString();
                    }
                    if (group7.length() == 1) {
                        group7 = new StringBuffer().append("0").append(group7).toString();
                    }
                    stringBuffer.append(group6);
                    stringBuffer.append(C0359h.f671A);
                    stringBuffer.append(group7);
                }
                try {
                    synchronized (f20774b) {
                        parse = f20774b.parse(stringBuffer.toString());
                    }
                    if (z) {
                        Calendar calendar2 = Calendar.getInstance();
                        calendar2.setTime(parse);
                        if (calendar2.after(calendar) && calendar2.getTimeInMillis() - calendar.getTimeInMillis() > Util.MILLSECONDS_OF_DAY) {
                            calendar2.set(1, i - 1);
                            date = calendar2.getTime();
                            c4872nArr[i2].m2989a(date);
                            c4872nArr[i2].m2990a(group8);
                        }
                    }
                    date = parse;
                    c4872nArr[i2].m2989a(date);
                    c4872nArr[i2].m2990a(group8);
                } catch (ParseException e) {
                    throw new C4875q();
                }
            } finally {
                C4875q c4875q = new C4875q();
            }
        }
        return c4872nArr;
    }
}
