package com.baidu.tts.tools;

import com.fimi.kernel.utils.C2258f;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes.dex */
public class DateTool {
    public static String format(long j, String str) {
        return format(new Date(j), str);
    }

    public static String format(String str, String str2, String str3) {
        try {
            return format(new SimpleDateFormat(str2, Locale.CHINA).parse(str), str3);
        } catch (Exception e) {
            return null;
        }
    }

    public static String format(Calendar calendar, String str) {
        try {
            return format(calendar.getTime(), str);
        } catch (Exception e) {
            return null;
        }
    }

    public static String format(Date date, String str) {
        return new SimpleDateFormat(str, Locale.CHINA).format(date);
    }

    public static String formatCurrentDate(String str) {
        return format(new Date(), str);
    }

    public static String formatInChinaDate(long j) {
        return format(j, "yyyy年M月d日");
    }

    public static String formatInHHmm(long j) {
        return format(j, C2258f.f7533h);
    }

    public static String formatInyyyyMMdd(long j) {
        return format(j, "yyyy.MM.dd");
    }

    public static Calendar getCalendar(String str, String str2) {
        try {
            Date parse = new SimpleDateFormat(str2, Locale.CHINA).parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            return calendar;
        } catch (Exception e) {
            return null;
        }
    }

    public static Date getDate(String str, String str2) {
        try {
            return new SimpleDateFormat(str2, Locale.CHINA).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String[] getDateRange(String str, String str2, int i) {
        Calendar calendar = getCalendar(str, str2);
        Date time = calendar.getTime();
        String[] strArr = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            calendar.add(5, -((i - i2) - 1));
            calendar.getTime();
            strArr[i2] = String.valueOf(calendar.get(5));
            calendar.setTime(time);
        }
        return strArr;
    }

    public static String simpleFormatCurrentDate() {
        return formatCurrentDate("yyyy年M月d日 HH:mm:ss:SSS");
    }
}
