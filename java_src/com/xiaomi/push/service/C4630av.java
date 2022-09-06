package com.xiaomi.push.service;

import android.content.Context;
import com.fimi.kernel.p157b.p161d.C2227d;
import com.xiaomi.channel.commonutils.file.C4474a;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.network.C4497d;
import com.xiaomi.channel.commonutils.string.C4507d;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.C4633aw;
import com.xiaomi.xmpush.thrift.C4772ae;
import com.xiaomi.xmpush.thrift.C4796aq;
import com.xiaomi.xmpush.thrift.C4799c;
import com.xiaomi.xmpush.thrift.C4801d;
import com.xiaomi.xmpush.thrift.EnumC4818o;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
/* renamed from: com.xiaomi.push.service.av */
/* loaded from: classes2.dex */
public class C4630av {

    /* renamed from: a */
    private static String f19036a = C4507d.m4949a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;

    /* renamed from: b */
    private static AtomicLong f19037b = new AtomicLong(0);

    /* renamed from: com.xiaomi.push.service.av$a */
    /* loaded from: classes2.dex */
    public static class C4631a implements C4633aw.AbstractC4635b {

        /* renamed from: a */
        private final Context f19038a;

        public C4631a(Context context) {
            this.f19038a = context;
        }

        @Override // com.xiaomi.push.service.C4633aw.AbstractC4635b
        /* renamed from: a */
        public void mo4280a(ArrayList<C4632b> arrayList) {
        }

        @Override // com.xiaomi.push.service.C4633aw.AbstractC4635b
        /* renamed from: a */
        public boolean mo4283a(C4632b c4632b) {
            return C4497d.m4985d(this.f19038a);
        }
    }

    /* renamed from: com.xiaomi.push.service.av$b */
    /* loaded from: classes2.dex */
    public static class C4632b {

        /* renamed from: a */
        public String f19039a;

        /* renamed from: b */
        public int f19040b;

        /* renamed from: c */
        public C4801d f19041c = new C4801d();

        public String toString() {
            return "TinyDataRequest:{id:" + this.f19039a + ", uploadHint:" + this.f19040b + ", channel:" + this.f19041c.f20147a + ", category:" + this.f19041c.f20153g + ", name:" + this.f19041c.f20149c + ", counter: " + this.f19041c.f20150d + ", data: " + this.f19041c.f20148b + ", fromSDK:" + this.f19041c.f20152f + ",  }";
        }
    }

    /* renamed from: a */
    public static String m4322a() {
        return f19036a + f19037b.incrementAndGet();
    }

    /* renamed from: a */
    public static ArrayList<C4772ae> m4320a(ArrayList<C4632b> arrayList, String str, String str2) {
        if (arrayList == null) {
            AbstractC4478b.m5036d("requests can not be null in TinyDataHelper.transToThriftObj().");
            return null;
        } else if (arrayList.size() == 0) {
            AbstractC4478b.m5036d("requests.length is 0 in TinyDataHelper.transToThriftObj().");
            return null;
        } else {
            ArrayList<C4772ae> arrayList2 = new ArrayList<>();
            int i = 0;
            C4799c c4799c = new C4799c();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                C4632b c4632b = arrayList.get(i2);
                if (c4632b != null && c4632b.f19041c != null) {
                    int length = C4796aq.m3471a(c4632b.f19041c).length;
                    if (length > 30720) {
                        AbstractC4478b.m5036d("TinyData is too big, ignore upload request." + c4632b.toString());
                    } else {
                        if (i + length > 30720) {
                            C4772ae c4772ae = new C4772ae(m4322a(), false);
                            c4772ae.m3693d(str);
                            c4772ae.m3698b(str2);
                            c4772ae.m3695c(EnumC4818o.UploadTinyData.f20376N);
                            c4772ae.m3701a(C4474a.m5054a(C4796aq.m3471a(c4799c)));
                            arrayList2.add(c4772ae);
                            c4799c = new C4799c();
                            i = 0;
                        }
                        c4799c.m3456a(c4632b.f19041c);
                        i += length;
                    }
                }
            }
            if (c4799c.m3458a() != 0) {
                C4772ae c4772ae2 = new C4772ae(m4322a(), false);
                c4772ae2.m3693d(str);
                c4772ae2.m3698b(str2);
                c4772ae2.m3695c(EnumC4818o.UploadTinyData.f20376N);
                c4772ae2.m3701a(C4474a.m5054a(C4796aq.m3471a(c4799c)));
                arrayList2.add(c4772ae2);
            }
            return arrayList2;
        }
    }

    /* renamed from: a */
    public static boolean m4321a(String str, String str2, long j, String str3) {
        if (str == null) {
            AbstractC4478b.m5041a("Value of parameter category can not be null.");
            return true;
        } else if (str2 == null) {
            AbstractC4478b.m5041a("Value of parameter Name can not be null");
            return true;
        } else if (!C4507d.m4942d(str)) {
            AbstractC4478b.m5041a("Value of parameter catetory invalid, can only contain ascii char.");
            return true;
        } else if (!C4507d.m4942d(str2)) {
            AbstractC4478b.m5041a("Value of parameter name invalid, can only contain ascii char.");
            return true;
        } else if (str3 == null || str3.length() <= 10240) {
            return false;
        } else {
            AbstractC4478b.m5041a("Parameter data is too large(" + str3.length() + "), max size for data is " + C2227d.f7442b);
            return true;
        }
    }
}
