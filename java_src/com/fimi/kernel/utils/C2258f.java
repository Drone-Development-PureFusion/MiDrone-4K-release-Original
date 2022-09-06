package com.fimi.kernel.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/* renamed from: com.fimi.kernel.utils.f */
/* loaded from: classes.dex */
public class C2258f {

    /* renamed from: a */
    public static final String f7526a = "yyyy-MM-dd HH:mm:ss";

    /* renamed from: b */
    public static final String f7527b = "yyyy-MM-dd";

    /* renamed from: c */
    public static final String f7528c = "yyyy-MM";

    /* renamed from: d */
    public static final String f7529d = "yyyy-MM-dd HH:mm";

    /* renamed from: e */
    public static final String f7530e = "yyyyMMddHHmmss";

    /* renamed from: f */
    public static final String f7531f = "MM/dd";

    /* renamed from: g */
    public static final String f7532g = "HH:mm:ss";

    /* renamed from: h */
    public static final String f7533h = "HH:mm";

    /* renamed from: i */
    public static final String f7534i = "AM";

    /* renamed from: j */
    public static final String f7535j = "PM";

    /* renamed from: a */
    public static int m13028a(long j, long j2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j2);
        int i = calendar.get(1);
        int i2 = calendar2.get(1);
        int i3 = calendar.get(6);
        int i4 = calendar2.get(6);
        if (i - i2 > 0) {
            return calendar2.getActualMaximum(6) + (i3 - i4);
        }
        if (i - i2 >= 0) {
            return i3 - i4;
        }
        return (i3 - i4) - calendar.getActualMaximum(6);
    }

    /* renamed from: a */
    public static long m13031a() {
        try {
            return m13023a(m13026a("yyyy-MM-dd") + " 00:00:00", "yyyy-MM-dd HH:mm:ss").getTime();
        } catch (Exception e) {
            return -1L;
        }
    }

    /* renamed from: a */
    public static String m13029a(long j) {
        if (j > 1000) {
            if ((j / 1000) / 60 <= 1) {
                return (j / 1000) + "秒";
            }
            return ((j / 1000) / 60) + "分" + ((j / 1000) % 60) + "秒";
        }
        return j + "毫秒";
    }

    /* renamed from: a */
    public static String m13027a(long j, String str) {
        try {
            return new SimpleDateFormat(str).format(Long.valueOf(j));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m13026a(String str) {
        C2266k.m12947a(C2258f.class, "getCurrentDate:" + str);
        try {
            return new SimpleDateFormat(str).format(new GregorianCalendar().getTime());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static String m13025a(String str, int i) {
        try {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
            int i2 = gregorianCalendar.get(7);
            if (i2 == i) {
                return simpleDateFormat.format(gregorianCalendar.getTime());
            }
            int i3 = i - i2;
            if (i == 1) {
                i3 = 7 - Math.abs(i3);
            }
            gregorianCalendar.add(5, i3);
            return simpleDateFormat.format(gregorianCalendar.getTime());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m13024a(String str, int i, int i2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.add(i, i2);
            return simpleDateFormat.format(gregorianCalendar.getTime());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m13022a(String str, String str2, int i, int i2) {
        try {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
            gregorianCalendar.setTime(simpleDateFormat.parse(str));
            gregorianCalendar.add(i, i2);
            return simpleDateFormat.format(gregorianCalendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m13020a(Date date, String str) {
        try {
            return new SimpleDateFormat(str).format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m13019a(Date date, String str, int i, int i2) {
        try {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
            gregorianCalendar.setTime(date);
            gregorianCalendar.add(i, i2);
            return simpleDateFormat.format(gregorianCalendar.getTime());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static Date m13023a(String str, String str2) {
        try {
            return new SimpleDateFormat(str2).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static void m13018a(String[] strArr) {
        System.out.println(m13011c("2012-3-2 12:2:20", "MM月dd日  HH:mm"));
    }

    /* renamed from: a */
    public static boolean m13030a(int i) {
        return (i % 4 == 0 && i % 400 != 0) || i % 400 == 0;
    }

    /* renamed from: b */
    public static int m13016b(long j, long j2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j2);
        return (calendar.get(11) - calendar2.get(11)) + (m13028a(j, j2) * 24);
    }

    /* renamed from: b */
    public static long m13017b() {
        try {
            return m13023a(m13026a("yyyy-MM-dd") + " 24:00:00", "yyyy-MM-dd HH:mm:ss").getTime();
        } catch (Exception e) {
            return -1L;
        }
    }

    /* renamed from: b */
    public static String m13015b(String str) {
        return m13025a(str, 2);
    }

    /* renamed from: b */
    public static String m13014b(String str, String str2) {
        try {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str));
            return new SimpleDateFormat(str2).format(gregorianCalendar.getTime());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public static int m13013c(long j, long j2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j2);
        return (calendar.get(12) - calendar2.get(12)) + (m13016b(j, j2) * 60);
    }

    /* renamed from: c */
    public static String m13012c(String str) {
        return m13025a(str, 1);
    }

    /* renamed from: c */
    public static String m13011c(String str, String str2) {
        int m13028a;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        try {
            calendar2.setTime(simpleDateFormat.parse(str));
            calendar.setTime(new Date());
            m13028a = m13028a(calendar.getTimeInMillis(), calendar2.getTimeInMillis());
        } catch (Exception e) {
        }
        if (m13028a == 0) {
            int m13016b = m13016b(calendar.getTimeInMillis(), calendar2.getTimeInMillis());
            if (m13016b > 0) {
                str = "今天" + m13014b(str, f7533h);
            } else if (m13016b >= 0 && m13016b == 0) {
                int m13013c = m13013c(calendar.getTimeInMillis(), calendar2.getTimeInMillis());
                if (m13013c > 0) {
                    str = m13013c + "分钟前";
                } else if (m13013c >= 0) {
                    str = "刚刚";
                }
            }
            return str;
        } else if (m13028a <= 0 ? m13028a >= 0 || m13028a == -1 || m13028a == -2 : m13028a == 1 || m13028a == 2) {
        }
        String m13014b = m13014b(str, str2);
        if (!C2269n.m12889b(m13014b)) {
            str = m13014b;
        }
        return str;
    }

    /* renamed from: d */
    public static String m13010d(String str) {
        try {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
            gregorianCalendar.set(5, 1);
            return simpleDateFormat.format(gregorianCalendar.getTime());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: d */
    public static String m13009d(String str, String str2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        try {
            gregorianCalendar.setTime(new SimpleDateFormat(str2).parse(str));
            switch (gregorianCalendar.get(7) - 1) {
                case 0:
                    return "星期日";
                case 1:
                    return "星期一";
                case 2:
                    return "星期二";
                case 3:
                    return "星期三";
                case 4:
                    return "星期四";
                case 5:
                    return "星期五";
                case 6:
                    return "星期六";
                default:
                    return "星期日";
            }
        } catch (Exception e) {
            return "错误";
        }
    }

    /* renamed from: e */
    public static String m13008e(String str) {
        try {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
            gregorianCalendar.set(5, 1);
            gregorianCalendar.roll(5, -1);
            return simpleDateFormat.format(gregorianCalendar.getTime());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: e */
    public static String m13007e(String str, String str2) {
        return m13023a(str, str2).getHours() >= 12 ? f7535j : f7534i;
    }

    /* renamed from: a */
    public Date m13021a(Date date, int i, int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        try {
            gregorianCalendar.setTime(date);
            gregorianCalendar.add(i, i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gregorianCalendar.getTime();
    }
}
