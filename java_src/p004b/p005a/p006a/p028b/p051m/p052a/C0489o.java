package p004b.p005a.p006a.p028b.p051m.p052a;

import com.tencent.p227mm.sdk.platformtools.Util;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p054o.C0527f;
/* renamed from: b.a.a.b.m.a.o */
/* loaded from: classes.dex */
public class C0489o extends GregorianCalendar {

    /* renamed from: a */
    static final TimeZone f1087a = TimeZone.getTimeZone("GMT");
    private static final long serialVersionUID = -5937537740925066161L;

    /* renamed from: b */
    EnumC0487m f1088b = EnumC0487m.ERRONEOUS;

    public C0489o() {
    }

    public C0489o(TimeZone timeZone, Locale locale) {
        super(timeZone, locale);
    }

    /* renamed from: a */
    private void m20368a(EnumC0487m enumC0487m) {
        this.f1088b = enumC0487m;
    }

    /* renamed from: b */
    public static int m20363b(long j, long j2) {
        if (j > j2) {
            throw new IllegalArgumentException("startTime cannot be larger than endTime");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j2);
        return (calendar2.get(2) - calendar.get(2)) + ((calendar2.get(1) - calendar.get(1)) * 12);
    }

    /* renamed from: a */
    public long m20369a(long j, long j2) {
        if (j > j2) {
            throw new IllegalArgumentException("Start cannot come before end");
        }
        long j3 = j2 - j;
        switch (this.f1088b) {
            case TOP_OF_MILLISECOND:
                return j3;
            case TOP_OF_SECOND:
                return j3 / 1000;
            case TOP_OF_MINUTE:
                return j3 / 60000;
            case TOP_OF_HOUR:
                return ((int) j3) / C0359h.f695Y;
            case HALF_DAY:
            default:
                throw new IllegalStateException("Unknown periodicity type.");
            case TOP_OF_DAY:
                return j3 / Util.MILLSECONDS_OF_DAY;
            case TOP_OF_WEEK:
                return j3 / 604800000;
            case TOP_OF_MONTH:
                return m20363b(j, j2);
        }
    }

    /* renamed from: a */
    public long m20365a(Date date) {
        return m20361b(date).getTime();
    }

    /* renamed from: a */
    public EnumC0487m m20370a() {
        return this.f1088b;
    }

    /* renamed from: a */
    public Date m20364a(Date date, int i) {
        setTime(date);
        switch (this.f1088b) {
            case TOP_OF_MILLISECOND:
                add(14, i);
                break;
            case TOP_OF_SECOND:
                set(14, 0);
                add(13, i);
                break;
            case TOP_OF_MINUTE:
                set(13, 0);
                set(14, 0);
                add(12, i);
                break;
            case TOP_OF_HOUR:
                set(12, 0);
                set(13, 0);
                set(14, 0);
                add(11, i);
                break;
            case HALF_DAY:
            default:
                throw new IllegalStateException("Unknown periodicity type.");
            case TOP_OF_DAY:
                set(11, 0);
                set(12, 0);
                set(13, 0);
                set(14, 0);
                add(5, i);
                break;
            case TOP_OF_WEEK:
                set(7, getFirstDayOfWeek());
                set(11, 0);
                set(12, 0);
                set(13, 0);
                set(14, 0);
                add(3, i);
                break;
            case TOP_OF_MONTH:
                set(5, 1);
                set(11, 0);
                set(12, 0);
                set(13, 0);
                set(14, 0);
                add(2, i);
                break;
        }
        return getTime();
    }

    /* renamed from: a */
    public void m20367a(C0527f c0527f) {
        switch (this.f1088b) {
            case TOP_OF_MILLISECOND:
                c0527f.mo20226d("Roll-over every millisecond.");
                return;
            case TOP_OF_SECOND:
                c0527f.mo20226d("Roll-over every second.");
                return;
            case TOP_OF_MINUTE:
                c0527f.mo20226d("Roll-over every minute.");
                return;
            case TOP_OF_HOUR:
                c0527f.mo20226d("Roll-over at the top of every hour.");
                return;
            case HALF_DAY:
                c0527f.mo20226d("Roll-over at midday and midnight.");
                return;
            case TOP_OF_DAY:
                c0527f.mo20226d("Roll-over at midnight.");
                return;
            case TOP_OF_WEEK:
                c0527f.mo20226d("Rollover at the start of week.");
                return;
            case TOP_OF_MONTH:
                c0527f.mo20226d("Rollover at start of every month.");
                return;
            default:
                c0527f.mo20226d("Unknown periodicity.");
                return;
        }
    }

    /* renamed from: a */
    public void m20366a(String str) {
        this.f1088b = m20362b(str);
    }

    /* renamed from: b */
    public EnumC0487m m20362b(String str) {
        EnumC0487m[] enumC0487mArr;
        C0489o c0489o = new C0489o(f1087a, Locale.getDefault());
        Date date = new Date(0L);
        if (str != null) {
            for (EnumC0487m enumC0487m : EnumC0487m.f1084j) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
                simpleDateFormat.setTimeZone(f1087a);
                String format = simpleDateFormat.format(date);
                c0489o.m20368a(enumC0487m);
                String format2 = simpleDateFormat.format(new Date(c0489o.m20365a(date)));
                if (format != null && format2 != null && !format.equals(format2)) {
                    return enumC0487m;
                }
            }
        }
        return EnumC0487m.ERRONEOUS;
    }

    /* renamed from: b */
    public Date m20361b(Date date) {
        return m20364a(date, 1);
    }
}
