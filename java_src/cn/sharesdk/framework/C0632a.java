package cn.sharesdk.framework;

import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.p075b.C0664d;
import cn.sharesdk.framework.p075b.p077b.C0656b;
import cn.sharesdk.framework.p075b.p077b.C0660f;
import cn.sharesdk.framework.utils.C0683d;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.tencent.p227mm.sdk.contact.RContact;
import com.tencent.p227mm.sdk.plugin.MMPluginProviderConstants;
import java.util.HashMap;
/* renamed from: cn.sharesdk.framework.a */
/* loaded from: classes.dex */
public class C0632a implements PlatformActionListener {

    /* renamed from: a */
    private PlatformActionListener f1441a;

    /* renamed from: b */
    private HashMap<Platform, Platform.ShareParams> f1442b = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m19754a(Platform platform) {
        try {
            return m19749a(platform.getDb(), new String[]{RContact.COL_NICKNAME, "icon", "gender", "snsUserUrl", "resume", "secretType", MMPluginProviderConstants.OAuth.SECRET, "birthday", "followerCount", "favouriteCount", "shareCount", "snsregat", "snsUserLevel", "educationJSONArrayStr", "workJSONArrayStr"});
        } catch (Throwable th) {
            C0683d.m19513a().m5959w(th);
            return null;
        }
    }

    /* renamed from: a */
    private String m19749a(PlatformDb platformDb, String[] strArr) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i = 0;
        for (String str : strArr) {
            if (i > 0) {
                sb2.append('|');
                sb.append('|');
            }
            i++;
            String str2 = platformDb.get(str);
            if (!TextUtils.isEmpty(str2)) {
                sb.append(str2);
                sb2.append(Data.urlEncode(str2, "utf-8"));
            }
        }
        C0683d.m19513a().m5966i("======UserData: " + sb.toString(), new Object[0]);
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m19755a(int i, Platform platform) {
    }

    /* renamed from: a */
    private void m19752a(Platform platform, final int i, final HashMap<String, Object> hashMap) {
        final PlatformActionListener platformActionListener = this.f1441a;
        this.f1441a = new PlatformActionListener() { // from class: cn.sharesdk.framework.a.1
            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onCancel(Platform platform2, int i2) {
                C0632a.this.f1441a = platformActionListener;
                if (C0632a.this.f1441a != null) {
                    C0632a.this.f1441a.onComplete(platform2, i, hashMap);
                    C0632a.this.f1441a = null;
                }
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onComplete(Platform platform2, int i2, HashMap<String, Object> hashMap2) {
                C0632a.this.f1441a = platformActionListener;
                if (C0632a.this.f1441a != null) {
                    C0632a.this.f1441a.onComplete(platform2, i, hashMap);
                    if (!"Wechat".equals(platform2.getName())) {
                        C0632a.this.f1441a = null;
                    }
                }
                C0656b c0656b = new C0656b();
                c0656b.f1502a = platform2.getPlatformId();
                c0656b.f1503b = "TencentWeibo".equals(platform2.getName()) ? platform2.getDb().get("name") : platform2.getDb().getUserId();
                c0656b.f1504c = new Hashon().fromHashMap(hashMap2);
                c0656b.f1505d = C0632a.this.m19754a(platform2);
                C0664d m19618a = C0664d.m19618a(platform2.getContext(), c0656b.f1508g);
                if (m19618a != null) {
                    m19618a.m19616a(c0656b);
                }
                C0632a.this.m19755a(1, platform2);
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onError(Platform platform2, int i2, Throwable th) {
                C0683d.m19513a().m5959w(th);
                C0632a.this.f1441a = platformActionListener;
                if (C0632a.this.f1441a != null) {
                    C0632a.this.f1441a.onComplete(platform2, i, hashMap);
                    C0632a.this.f1441a = null;
                }
            }
        };
        platform.showUser(null);
    }

    /* renamed from: b */
    private String m19744b(Platform platform) {
        Platform platform2;
        PlatformDb db = platform.getDb();
        if (("WechatMoments".equals(platform.getName()) || "WechatFavorite".equals(platform.getName())) && TextUtils.isEmpty(db.getUserGender()) && (platform2 = ShareSDK.getPlatform("Wechat")) != null) {
            db = platform2.getDb();
        }
        try {
            return m19749a(db, new String[]{"gender", "birthday", "secretType", "educationJSONArrayStr", "workJSONArrayStr"});
        } catch (Throwable th) {
            C0683d.m19513a().m5959w(th);
            return null;
        }
    }

    /* renamed from: b */
    private void m19743b(Platform platform, int i, HashMap<String, Object> hashMap) {
        HashMap<String, Object> hashMap2;
        Platform.ShareParams remove = hashMap != null ? (Platform.ShareParams) hashMap.remove("ShareParams") : this.f1442b.remove(platform);
        try {
            hashMap2 = (HashMap) hashMap.clone();
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
            hashMap2 = hashMap;
        }
        if (remove != null) {
            C0660f c0660f = new C0660f();
            c0660f.f1530o = remove.getCustomFlag();
            String userId = platform.getDb().getUserId();
            if (("WechatMoments".equals(platform.getName()) || "WechatFavorite".equals(platform.getName())) && TextUtils.isEmpty(userId)) {
                Platform platform2 = ShareSDK.getPlatform("Wechat");
                if (platform2 != null) {
                    userId = platform2.getDb().getUserId();
                }
            } else if ("TencentWeibo".equals(platform.getName())) {
                userId = platform.getDb().get("name");
            }
            c0660f.f1526b = userId;
            c0660f.f1525a = platform.getPlatformId();
            C0660f.C0661a filterShareContent = platform.filterShareContent(remove, hashMap2);
            if (filterShareContent != null) {
                c0660f.f1527c = filterShareContent.f1531a;
                c0660f.f1528d = filterShareContent;
            }
            c0660f.f1529n = m19744b(platform);
            C0664d m19618a = C0664d.m19618a(platform.getContext(), c0660f.f1508g);
            if (m19618a != null) {
                m19618a.m19616a(c0660f);
            }
        }
        if (this.f1441a != null) {
            try {
                this.f1441a.onComplete(platform, i, hashMap);
                this.f1441a = null;
            } catch (Throwable th2) {
                C0683d.m19513a().m5971d(th2);
            }
        }
        m19755a(9, platform);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public PlatformActionListener m19756a() {
        return this.f1441a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m19753a(Platform platform, final int i, final Object obj) {
        final PlatformActionListener platformActionListener = this.f1441a;
        this.f1441a = new PlatformActionListener() { // from class: cn.sharesdk.framework.a.2
            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onCancel(Platform platform2, int i2) {
                C0632a.this.f1441a = platformActionListener;
                if (C0632a.this.f1441a != null) {
                    C0632a.this.f1441a.onCancel(platform2, i);
                    C0632a.this.f1441a = null;
                }
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onComplete(Platform platform2, int i2, HashMap<String, Object> hashMap) {
                C0632a.this.f1441a = platformActionListener;
                platform2.afterRegister(i, obj);
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onError(Platform platform2, int i2, Throwable th) {
                C0632a.this.f1441a = platformActionListener;
                if (C0632a.this.f1441a != null) {
                    C0632a.this.f1441a.onError(platform2, i2, th);
                    C0632a.this.f1441a = null;
                }
            }
        };
        platform.doAuthorize(null);
    }

    /* renamed from: a */
    public void m19751a(Platform platform, Platform.ShareParams shareParams) {
        this.f1442b.put(platform, shareParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m19750a(PlatformActionListener platformActionListener) {
        this.f1441a = platformActionListener;
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onCancel(Platform platform, int i) {
        if (this.f1441a != null) {
            this.f1441a.onCancel(platform, i);
            this.f1441a = null;
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        if (platform instanceof CustomPlatform) {
            if (this.f1441a == null) {
                return;
            }
            this.f1441a.onComplete(platform, i, hashMap);
            this.f1441a = null;
            return;
        }
        switch (i) {
            case 1:
                m19752a(platform, i, hashMap);
                return;
            case 9:
                m19743b(platform, i, hashMap);
                return;
            default:
                if (this.f1441a == null) {
                    return;
                }
                this.f1441a.onComplete(platform, i, hashMap);
                if ("Wechat".equals(platform.getName())) {
                    return;
                }
                this.f1441a = null;
                return;
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onError(Platform platform, int i, Throwable th) {
        if (this.f1441a != null) {
            this.f1441a.onError(platform, i, th);
            this.f1441a = null;
        }
    }
}
