package com.fimi.soul.drone.p200f;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* renamed from: com.fimi.soul.drone.f.c */
/* loaded from: classes.dex */
public class C2846c {
    /* renamed from: a */
    public static String m10795a() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    /* renamed from: a */
    public static Date m10794a(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
