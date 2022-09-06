package cn.sharesdk.framework;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.utils.C0683d;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.lang.reflect.Field;
import java.util.HashMap;
/* renamed from: cn.sharesdk.framework.c */
/* loaded from: classes.dex */
public class C0665c {

    /* renamed from: a */
    private Platform f1563a;

    /* renamed from: b */
    private Context f1564b;

    /* renamed from: c */
    private PlatformDb f1565c;

    /* renamed from: e */
    private int f1567e;

    /* renamed from: f */
    private int f1568f;

    /* renamed from: g */
    private boolean f1569g;

    /* renamed from: i */
    private boolean f1571i;

    /* renamed from: h */
    private boolean f1570h = true;

    /* renamed from: d */
    private C0632a f1566d = new C0632a();

    public C0665c(Platform platform, Context context) {
        this.f1563a = platform;
        this.f1564b = context;
        String name = platform.getName();
        this.f1565c = new PlatformDb(context, name, platform.getVersion());
        m19603a(name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public boolean m19583j() {
        boolean z = false;
        if (ShareSDK.m19767a()) {
            String m19608a = m19608a(this.f1563a.getPlatformId(), "covert_url", (String) null);
            if (m19608a != null) {
                m19608a.trim();
            }
            if (!"false".equals(m19608a)) {
                z = true;
            }
            this.f1570h = z;
            this.f1563a.setNetworkDevinfo();
            return true;
        }
        try {
            HashMap hashMap = new HashMap();
            if (!ShareSDK.m19760a(hashMap)) {
                return false;
            }
            if (!ShareSDK.m19757b(hashMap)) {
                C0683d.m19513a().m5966i("Failed to parse network dev-info: " + new Hashon().fromHashMap(hashMap), new Object[0]);
                return false;
            }
            String m19608a2 = m19608a(this.f1563a.getPlatformId(), "covert_url", (String) null);
            if (m19608a2 != null) {
                m19608a2.trim();
            }
            this.f1570h = !"false".equals(m19608a2);
            this.f1563a.setNetworkDevinfo();
            return true;
        } catch (Throwable th) {
            C0683d.m19513a().m5959w(th);
            return false;
        }
    }

    /* renamed from: k */
    private String m19582k() {
        StringBuilder sb = new StringBuilder();
        try {
            if ("TencentWeibo".equals(this.f1563a.getName())) {
                C0683d.m19513a().m5966i("user id %s ==>>", m19586g().getUserName());
                sb.append(Data.urlEncode(m19586g().getUserName(), "utf-8"));
            } else {
                sb.append(Data.urlEncode(m19586g().getUserId(), "utf-8"));
            }
            sb.append("|").append(Data.urlEncode(m19586g().get("secretType"), "utf-8"));
            sb.append("|").append(Data.urlEncode(m19586g().get("gender"), "utf-8"));
            sb.append("|").append(Data.urlEncode(m19586g().get("birthday"), "utf-8"));
            sb.append("|").append(Data.urlEncode(m19586g().get("educationJSONArrayStr"), "utf-8"));
            sb.append("|").append(Data.urlEncode(m19586g().get("workJSONArrayStr"), "utf-8"));
        } catch (Throwable th) {
            C0683d.m19513a().m5959w(th);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public int m19611a() {
        return this.f1567e;
    }

    /* renamed from: a */
    public String m19608a(int i, String str, String str2) {
        String m19765a = ShareSDK.m19765a(i, str);
        return (TextUtils.isEmpty(m19765a) || "null".equals(m19765a)) ? this.f1563a.getDevinfo(this.f1563a.getName(), str2) : m19765a;
    }

    /* renamed from: a */
    public String m19607a(Bitmap bitmap) {
        return ShareSDK.m19764a(bitmap);
    }

    /* renamed from: a */
    public String m19600a(String str, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f1570h) {
            C0683d.m19513a().m5966i("getShortLintk use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            return str;
        } else if (TextUtils.isEmpty(str)) {
            C0683d.m19513a().m5966i("getShortLintk use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            return str;
        } else {
            String m19761a = ShareSDK.m19761a(str, z, this.f1563a.getPlatformId(), m19582k());
            C0683d.m19513a().m5966i("getShortLintk use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            return m19761a;
        }
    }

    /* renamed from: a */
    public void m19610a(int i, int i2, String str) {
        m19592c(2, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
    }

    /* renamed from: a */
    public void m19609a(int i, Object obj) {
        this.f1566d.m19753a(this.f1563a, i, obj);
    }

    /* renamed from: a */
    public void m19606a(Platform.ShareParams shareParams) {
        if (shareParams != null) {
            m19592c(9, shareParams);
        } else if (this.f1566d == null) {
        } else {
            this.f1566d.onError(this.f1563a, 9, new NullPointerException());
        }
    }

    /* renamed from: a */
    public void m19605a(PlatformActionListener platformActionListener) {
        this.f1566d.m19750a(platformActionListener);
    }

    /* renamed from: a */
    public void m19603a(String str) {
        try {
            this.f1567e = ResHelper.parseInt(String.valueOf(ShareSDK.m19758b(str, "Id")).trim());
        } catch (Throwable th) {
            if (!(this.f1563a instanceof CustomPlatform)) {
                C0683d.m19513a().m5972d(this.f1563a.getName() + " failed to parse Id, this will cause method getId() always returens 0", new Object[0]);
            }
        }
        try {
            this.f1568f = ResHelper.parseInt(String.valueOf(ShareSDK.m19758b(str, "SortId")).trim());
        } catch (Throwable th2) {
            if (!(this.f1563a instanceof CustomPlatform)) {
                C0683d.m19513a().m5972d(this.f1563a.getName() + " failed to parse SortId, this won't cause any problem, don't worry", new Object[0]);
            }
        }
        String m19758b = ShareSDK.m19758b(str, "Enable");
        if (m19758b == null) {
            this.f1571i = true;
            if (!(this.f1563a instanceof CustomPlatform)) {
                C0683d.m19513a().m5972d(this.f1563a.getName() + " failed to parse Enable, this will cause platform always be enable", new Object[0]);
            }
        } else {
            this.f1571i = "true".equals(m19758b.trim());
        }
        this.f1563a.initDevInfo(str);
    }

    /* renamed from: a */
    public void m19602a(String str, int i, int i2) {
        m19592c(7, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
    }

    /* renamed from: a */
    public void m19601a(String str, String str2, short s, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
        m19592c(655360 | s, new Object[]{str, str2, hashMap, hashMap2});
    }

    /* renamed from: a */
    public void m19599a(boolean z) {
        this.f1569g = z;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [cn.sharesdk.framework.c$2] */
    /* renamed from: a */
    public void m19598a(final String[] strArr) {
        new Thread() { // from class: cn.sharesdk.framework.c.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    C0665c.this.m19583j();
                    C0665c.this.f1563a.doAuthorize(strArr);
                } catch (Throwable th) {
                    C0683d.m19513a().m5959w(th);
                }
            }
        }.start();
    }

    /* renamed from: b */
    public int m19597b() {
        return this.f1568f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void m19596b(int i, Object obj) {
        Field[] fields;
        Object obj2;
        switch (i) {
            case 1:
                if (this.f1566d == null) {
                    return;
                }
                this.f1566d.onComplete(this.f1563a, 1, null);
                return;
            case 2:
                Object[] objArr = (Object[]) obj;
                this.f1563a.getFriendList(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), (String) objArr[2]);
                return;
            case 3:
            case 4:
            case 5:
            default:
                Object[] objArr2 = (Object[]) obj;
                this.f1563a.doCustomerProtocol(String.valueOf(objArr2[0]), String.valueOf(objArr2[1]), i, (HashMap) objArr2[2], (HashMap) objArr2[3]);
                return;
            case 6:
                this.f1563a.follow((String) obj);
                return;
            case 7:
                Object[] objArr3 = (Object[]) obj;
                this.f1563a.timeline(((Integer) objArr3[0]).intValue(), ((Integer) objArr3[1]).intValue(), (String) objArr3[2]);
                return;
            case 8:
                this.f1563a.userInfor(obj == null ? null : (String) obj);
                return;
            case 9:
                Platform.ShareParams shareParams = (Platform.ShareParams) obj;
                HashMap<String, Object> map = shareParams.toMap();
                for (Field field : shareParams.getClass().getFields()) {
                    if (map.get(field.getName()) == null) {
                        field.setAccessible(true);
                        try {
                            obj2 = field.get(shareParams);
                        } catch (Throwable th) {
                            C0683d.m19513a().m5959w(th);
                            obj2 = null;
                        }
                        if (obj2 != null) {
                            map.put(field.getName(), obj2);
                        }
                    }
                }
                if (this.f1566d instanceof C0632a) {
                    this.f1566d.m19751a(this.f1563a, shareParams);
                }
                this.f1563a.doShare(shareParams);
                return;
        }
    }

    /* renamed from: b */
    public void m19594b(String str) {
        m19592c(6, str);
    }

    /* renamed from: c */
    public PlatformActionListener m19593c() {
        return this.f1566d.m19756a();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [cn.sharesdk.framework.c$1] */
    /* renamed from: c */
    protected void m19592c(final int i, final Object obj) {
        new Thread() { // from class: cn.sharesdk.framework.c.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    C0665c.this.m19583j();
                    if (!C0665c.this.f1563a.checkAuthorize(i, obj)) {
                        return;
                    }
                    C0665c.this.m19596b(i, obj);
                } catch (Throwable th) {
                    C0683d.m19513a().m5959w(th);
                }
            }
        }.start();
    }

    /* renamed from: c */
    public void m19591c(String str) {
        m19592c(8, str);
    }

    /* renamed from: d */
    public String m19589d(String str) {
        return ShareSDK.m19763a(str);
    }

    /* renamed from: d */
    public boolean m19590d() {
        return this.f1565c.isValid();
    }

    /* renamed from: e */
    public boolean m19588e() {
        return this.f1569g;
    }

    /* renamed from: f */
    public boolean m19587f() {
        return this.f1571i;
    }

    /* renamed from: g */
    public PlatformDb m19586g() {
        return this.f1565c;
    }

    /* renamed from: h */
    public void m19585h() {
        this.f1565c.removeAccount();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public PlatformActionListener m19584i() {
        return this.f1566d;
    }
}
