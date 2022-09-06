package com.fimi.soul.biz.p185n;

import android.content.Context;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.entity.UserDeviceFirmwareVersion;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.NetUtil;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
/* renamed from: com.fimi.soul.biz.n.y */
/* loaded from: classes.dex */
public class C2611y {

    /* renamed from: a */
    private Gson f9036a = new Gson();

    /* renamed from: b */
    private Context f9037b;

    /* renamed from: com.fimi.soul.biz.n.y$a */
    /* loaded from: classes.dex */
    public class RunnableC2612a implements Runnable {

        /* renamed from: a */
        List<NameValuePair> f9038a;

        public RunnableC2612a(List<NameValuePair> list) {
            this.f9038a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            NetUtil.m7767a(C2353b.f7951i, this.f9038a, C2611y.this.f9037b);
        }
    }

    public C2611y(Context context) {
        this.f9037b = context;
    }

    /* renamed from: a */
    public void m11529a() {
        m11527a(m11526b());
    }

    /* renamed from: a */
    public void m11527a(UserDeviceFirmwareVersion userDeviceFirmwareVersion) {
        if (userDeviceFirmwareVersion != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("commandCode", "getUserVersion"));
            arrayList.add(new BasicNameValuePair("jsonStr", this.f9036a.toJson(userDeviceFirmwareVersion)));
            C2281x.m12702b(new RunnableC2612a(arrayList));
        }
    }

    /* renamed from: b */
    public UserDeviceFirmwareVersion m11526b() {
        String userID = C2353b.m12507c(this.f9037b).getUserID();
        UserDeviceFirmwareVersion userDeviceFirmwareVersion = new UserDeviceFirmwareVersion();
        if (userID != null && !userID.equals("")) {
            userDeviceFirmwareVersion.setUserID(Integer.parseInt(userID));
        }
        userDeviceFirmwareVersion.setFcID(C3579a.m7971a().m7970a(0).m7905i());
        userDeviceFirmwareVersion.setAndroidVer(C3658ar.m7589d(this.f9037b));
        if (C2367d.m12459a().m12438k()) {
            userDeviceFirmwareVersion.setDeviceType("1");
            int m7921b = C3579a.m7971a().m7970a(14).m7921b();
            if (m7921b != 0) {
                userDeviceFirmwareVersion.setX6D4kVer("" + m7921b);
            } else {
                int m7921b2 = C3579a.m7971a().m7970a(25).m7921b();
                if (m7921b2 != 0) {
                    userDeviceFirmwareVersion.setX6D4kVer("" + m7921b2);
                }
            }
            int m7921b3 = C3579a.m7971a().m7970a(13).m7921b();
            if (m7921b3 != 0) {
                userDeviceFirmwareVersion.setCamVer("" + m7921b3);
            }
            int m7921b4 = C3579a.m7971a().m7970a(15).m7921b();
            if (m7921b4 != 0) {
                userDeviceFirmwareVersion.setX6RVer("" + m7921b4);
            } else {
                int m7921b5 = C3579a.m7971a().m7970a(26).m7921b();
                if (m7921b5 != 0) {
                    userDeviceFirmwareVersion.setX6RVer("" + m7921b5);
                }
            }
        } else {
            userDeviceFirmwareVersion.setDeviceType("0");
            int m7921b6 = C3579a.m7971a().m7970a(4).m7921b();
            if (m7921b6 != 0) {
                userDeviceFirmwareVersion.setCamVer("" + m7921b6);
            }
            int m7921b7 = C3579a.m7971a().m7970a(11).m7921b();
            if (m7921b7 != 0) {
                userDeviceFirmwareVersion.setX6RVer("" + m7921b7);
            }
        }
        int m7921b8 = C3579a.m7971a().m7970a(0).m7921b();
        if (m7921b8 != 0) {
            userDeviceFirmwareVersion.setFcVer("" + m7921b8);
        }
        int m7921b9 = C3579a.m7971a().m7970a(1).m7921b();
        if (m7921b9 != 0) {
            userDeviceFirmwareVersion.setRcVer("" + m7921b9);
        }
        int m7921b10 = C3579a.m7971a().m7970a(10).m7921b();
        if (m7921b10 != 0) {
            userDeviceFirmwareVersion.setNoflyVer("" + m7921b10);
        }
        int m7921b11 = C3579a.m7971a().m7970a(3).m7921b();
        if (m7921b11 != 0) {
            userDeviceFirmwareVersion.setGcVer("" + m7921b11);
        }
        int m7921b12 = C3579a.m7971a().m7970a(6).m7921b();
        if (m7921b12 != 0) {
            userDeviceFirmwareVersion.setServVer("" + m7921b12);
        }
        int m7921b13 = C3579a.m7971a().m7970a(9).m7921b();
        if (m7921b13 != 0) {
            userDeviceFirmwareVersion.setX2Ver("" + m7921b13);
        }
        int m7921b14 = C3579a.m7971a().m7970a(5).m7921b();
        if (m7921b14 != 0) {
            userDeviceFirmwareVersion.setBatteryVer("" + m7921b14);
        }
        return userDeviceFirmwareVersion;
    }
}
