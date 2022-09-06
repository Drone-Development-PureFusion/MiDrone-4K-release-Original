package p004b.p005a.p006a.p028b.p029a;

import android.os.Environment;
import p004b.p005a.p006a.p028b.p057r.C0578l;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.b.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC0267a {

    /* renamed from: a */
    private static final String f465a = "assets";

    /* renamed from: a */
    public static String m21099a() {
        if (C0578l.m20100a()) {
            String externalStorageState = Environment.getExternalStorageState();
            if (!externalStorageState.equals("mounted") && !externalStorageState.equals("mounted_ro")) {
                return null;
            }
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        return "/mnt/sdcard";
    }

    /* renamed from: a */
    public static String m21098a(String str) {
        return (C0578l.m20100a() ? Environment.getDataDirectory().getAbsolutePath() : "/data") + "/data/" + str + "/files";
    }

    /* renamed from: b */
    public static String m21097b() {
        if (C0578l.m20100a()) {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        String m20067a = C0589u.m20067a("EXTERNAL_STORAGE");
        return m20067a == null ? "/sdcard" : m20067a;
    }

    /* renamed from: b */
    public static String m21096b(String str) {
        return (C0578l.m20100a() ? Environment.getDataDirectory().getAbsolutePath() : "/data") + "/data/" + str + "/databases";
    }

    /* renamed from: c */
    public static String m21095c() {
        return f465a;
    }
}
