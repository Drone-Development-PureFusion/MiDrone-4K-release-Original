package cn.sharesdk.sina.weibo;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.p075b.p077b.C0660f;
import cn.sharesdk.framework.utils.C0683d;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.tencent.p227mm.sdk.contact.RContact;
import com.tencent.p227mm.sdk.plugin.MMPluginProviderConstants;
import com.xiaomi.account.openauth.AuthorizeActivityBase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import p004b.p005a.p006a.p028b.p044i.p045a.C0413a;
/* loaded from: classes.dex */
public class SinaWeibo extends Platform {
    public static final String NAME = SinaWeibo.class.getSimpleName();

    /* renamed from: a */
    private String f1629a;

    /* renamed from: b */
    private String f1630b;

    /* renamed from: c */
    private String f1631c;

    /* renamed from: d */
    private boolean f1632d;

    /* loaded from: classes.dex */
    public static class ShareParams extends Platform.ShareParams {
        @Deprecated
        public String imageUrl;
        @Deprecated
        public float latitude;
        @Deprecated
        public float longitude;
    }

    public SinaWeibo(Context context) {
        super(context);
    }

    /* renamed from: c */
    private boolean m19499c() {
        if (!TextUtils.isEmpty(getDb().get("refresh_token"))) {
            C0696d m19455a = C0696d.m19455a(this);
            m19455a.m19449a(this.f1629a, this.f1630b);
            m19455a.m19451a(this.f1631c);
            return m19455a.m19459a();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public boolean checkAuthorize(int i, Object obj) {
        C0696d m19455a = C0696d.m19455a(this);
        if (i != 9 || !this.f1632d || !m19455a.m19444b()) {
            if (!isAuthValid() && !m19499c()) {
                innerAuthorize(i, obj);
                return false;
            }
            m19455a.m19449a(this.f1629a, this.f1630b);
            m19455a.m19441b(this.f1427db.getToken());
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doAuthorize(String[] strArr) {
        final C0696d m19455a = C0696d.m19455a(this);
        m19455a.m19449a(this.f1629a, this.f1630b);
        m19455a.m19451a(this.f1631c);
        m19455a.m19445a(strArr);
        m19455a.m19454a(new AuthorizeListener() { // from class: cn.sharesdk.sina.weibo.SinaWeibo.1
            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onCancel() {
                if (SinaWeibo.this.listener != null) {
                    SinaWeibo.this.listener.onCancel(SinaWeibo.this, 1);
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onComplete(Bundle bundle) {
                long j;
                String string = bundle.getString(C3947a.f16896g);
                String string2 = bundle.getString("access_token");
                String string3 = bundle.getString("expires_in");
                String string4 = bundle.getString("refresh_token");
                SinaWeibo.this.f1427db.put(RContact.COL_NICKNAME, bundle.getString("userName"));
                SinaWeibo.this.f1427db.put("remind_in", bundle.getString("remind_in"));
                SinaWeibo.this.f1427db.putToken(string2);
                try {
                    j = ResHelper.parseLong(string3);
                } catch (Throwable th) {
                    j = 0;
                }
                SinaWeibo.this.f1427db.putExpiresIn(j);
                SinaWeibo.this.f1427db.put("refresh_token", string4);
                SinaWeibo.this.f1427db.putUserId(string);
                m19455a.m19441b(string2);
                SinaWeibo.this.afterRegister(1, null);
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onError(Throwable th) {
                if (SinaWeibo.this.listener != null) {
                    SinaWeibo.this.listener.onError(SinaWeibo.this, 1, th);
                }
            }
        }, isSSODisable());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doCustomerProtocol(String str, String str2, int i, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
        try {
            HashMap<String, Object> m19446a = C0696d.m19455a(this).m19446a(str, str2, hashMap, hashMap2);
            if (m19446a == null || m19446a.size() <= 0) {
                if (this.listener != null) {
                    this.listener.onError(this, i, new Throwable());
                }
            } else if (!m19446a.containsKey("error_code") || ((Integer) m19446a.get("error_code")).intValue() == 0) {
                if (this.listener != null) {
                    this.listener.onComplete(this, i, m19446a);
                }
            } else if (this.listener != null) {
                this.listener.onError(this, i, new Throwable(new Hashon().fromHashMap(m19446a)));
            }
        } catch (Throwable th) {
            this.listener.onError(this, i, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0070 -> B:23:0x0043). Please submit an issue!!! */
    @Override // cn.sharesdk.framework.Platform
    public void doShare(Platform.ShareParams shareParams) {
        int stringRes;
        String text = shareParams.getText();
        String string = (!TextUtils.isEmpty(text) || (stringRes = ResHelper.getStringRes(getContext(), "ssdk_weibo_upload_content")) <= 0) ? text : getContext().getString(stringRes);
        C0696d m19455a = C0696d.m19455a(this);
        m19455a.m19449a(this.f1629a, this.f1630b);
        String imagePath = shareParams.getImagePath();
        String imageUrl = shareParams.getImageUrl();
        if (this.f1632d && m19455a.m19444b()) {
            try {
                m19455a.m19456a(shareParams, this.listener);
                return;
            } catch (Throwable th) {
                this.listener.onError(this, 9, th);
                return;
            }
        }
        try {
            HashMap<String, Object> m19447a = m19455a.m19447a(getShortLintk(string, false), imageUrl, imagePath, shareParams.getLongitude(), shareParams.getLatitude());
            if (m19447a == null) {
                if (this.listener != null) {
                    this.listener.onError(this, 9, new Throwable());
                }
            } else if (!m19447a.containsKey("error_code") || ((Integer) m19447a.get("error_code")).intValue() == 0) {
                m19447a.put("ShareParams", shareParams);
                if (this.listener != null) {
                    this.listener.onComplete(this, 9, m19447a);
                }
            } else if (this.listener != null) {
                this.listener.onError(this, 9, new Throwable(new Hashon().fromHashMap(m19447a)));
            }
        } catch (Throwable th2) {
            this.listener.onError(this, 9, th2);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    protected HashMap<String, Object> filterFriendshipInfo(int i, HashMap<String, Object> hashMap) {
        Object obj;
        HashMap<String, Object> hashMap2 = new HashMap<>();
        switch (i) {
            case 2:
                hashMap2.put("type", "FOLLOWING");
                break;
            case 10:
                hashMap2.put("type", "FRIENDS");
                break;
            case 11:
                hashMap2.put("type", "FOLLOWERS");
                break;
            default:
                return null;
        }
        hashMap2.put("snsplat", Integer.valueOf(getPlatformId()));
        hashMap2.put("snsuid", this.f1427db.getUserId());
        int parseInt = Integer.parseInt(String.valueOf(hashMap.get("current_cursor")));
        int parseInt2 = Integer.parseInt(String.valueOf(hashMap.get("total_number")));
        if (parseInt2 != 0 && (obj = hashMap.get("users")) != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            if (arrayList2.size() <= 0) {
                return null;
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                HashMap hashMap3 = (HashMap) it2.next();
                if (hashMap3 != null) {
                    HashMap hashMap4 = new HashMap();
                    hashMap4.put("snsuid", String.valueOf(hashMap3.get("id")));
                    hashMap4.put(RContact.COL_NICKNAME, String.valueOf(hashMap3.get("screen_name")));
                    hashMap4.put("icon", String.valueOf(hashMap3.get("avatar_hd")));
                    if (String.valueOf(hashMap3.get("verified")).equals("true")) {
                        hashMap4.put("secretType", "1");
                    } else {
                        hashMap4.put("secretType", "0");
                    }
                    hashMap4.put(MMPluginProviderConstants.OAuth.SECRET, String.valueOf(hashMap3.get("verified_reason")));
                    String valueOf = String.valueOf(hashMap3.get("gender"));
                    if (valueOf.equals(C0413a.f922b)) {
                        hashMap4.put("gender", "0");
                    } else if (valueOf.equals("f")) {
                        hashMap4.put("gender", "1");
                    } else {
                        hashMap4.put("gender", "2");
                    }
                    hashMap4.put("snsUserUrl", "http://weibo.com/" + String.valueOf(hashMap3.get("profile_url")));
                    hashMap4.put("resume", String.valueOf(hashMap3.get("description")));
                    hashMap4.put("followerCount", String.valueOf(hashMap3.get("followers_count")));
                    hashMap4.put("favouriteCount", String.valueOf(hashMap3.get("friends_count")));
                    hashMap4.put("shareCount", String.valueOf(hashMap3.get("statuses_count")));
                    hashMap4.put("snsregat", String.valueOf(ResHelper.dateToLong(String.valueOf(hashMap3.get("created_at")))));
                    arrayList.add(hashMap4);
                }
            }
            if (arrayList == null || arrayList.size() <= 0) {
                return null;
            }
            if (10 == i) {
                hashMap2.put("nextCursor", ((Integer) hashMap.get("page_count")).intValue() * (parseInt + 1) >= parseInt2 ? parseInt + "_true" : (parseInt + 1) + "_false");
            } else {
                int size = arrayList.size() + parseInt;
                hashMap2.put("nextCursor", size >= parseInt2 ? parseInt2 + "_true" : size + "_false");
            }
            hashMap2.put("list", arrayList);
            return hashMap2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public C0660f.C0661a filterShareContent(Platform.ShareParams shareParams, HashMap<String, Object> hashMap) {
        C0660f.C0661a c0661a = new C0660f.C0661a();
        c0661a.f1532b = shareParams.getText();
        if (hashMap != null) {
            c0661a.f1531a = String.valueOf(hashMap.get("id"));
            c0661a.f1534d.add(String.valueOf(hashMap.get("original_pic")));
            c0661a.f1537g = hashMap;
        }
        return c0661a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void follow(String str) {
        try {
            HashMap<String, Object> m19435d = C0696d.m19455a(this).m19435d(str);
            if (m19435d == null) {
                if (this.listener != null) {
                    this.listener.onError(this, 6, new Throwable());
                }
            } else if (!m19435d.containsKey("error_code") || ((Integer) m19435d.get("error_code")).intValue() == 0) {
                if (this.listener != null) {
                    this.listener.onComplete(this, 6, m19435d);
                }
            } else if (this.listener != null) {
                this.listener.onError(this, 6, new Throwable(new Hashon().fromHashMap(m19435d)));
            }
        } catch (Throwable th) {
            this.listener.onError(this, 6, th);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    protected HashMap<String, Object> getBilaterals(int i, int i2, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.f1427db.getUserId();
        }
        if (TextUtils.isEmpty(str)) {
            str = this.f1427db.get(RContact.COL_NICKNAME);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HashMap<String, Object> m19439c = C0696d.m19455a(this).m19439c(i, i2, str);
            if (m19439c == null || m19439c.containsKey("error_code")) {
                return null;
            }
            m19439c.put("page_count", Integer.valueOf(i));
            m19439c.put("current_cursor", Integer.valueOf(i2));
            return filterFriendshipInfo(10, m19439c);
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
            return null;
        }
    }

    @Override // cn.sharesdk.framework.Platform
    protected HashMap<String, Object> getFollowers(int i, int i2, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.f1427db.getUserId();
        }
        if (TextUtils.isEmpty(str)) {
            str = this.f1427db.get(RContact.COL_NICKNAME);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HashMap<String, Object> m19436d = C0696d.m19455a(this).m19436d(i, i2, str);
            if (m19436d == null || m19436d.containsKey("error_code")) {
                return null;
            }
            m19436d.put("current_cursor", Integer.valueOf(i2));
            return filterFriendshipInfo(11, m19436d);
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
            return null;
        }
    }

    @Override // cn.sharesdk.framework.Platform
    protected HashMap<String, Object> getFollowings(int i, int i2, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.f1427db.getUserId();
        }
        if (TextUtils.isEmpty(str)) {
            str = this.f1427db.get(RContact.COL_NICKNAME);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HashMap<String, Object> m19443b = C0696d.m19455a(this).m19443b(i, i2, str);
            if (m19443b == null || m19443b.containsKey("error_code")) {
                return null;
            }
            m19443b.put("current_cursor", Integer.valueOf(i2));
            return filterFriendshipInfo(2, m19443b);
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void getFriendList(int i, int i2, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.f1427db.getUserId();
        }
        if (TextUtils.isEmpty(str)) {
            str = this.f1427db.get(RContact.COL_NICKNAME);
        }
        if (TextUtils.isEmpty(str)) {
            if (this.listener == null) {
                return;
            }
            this.listener.onError(this, 2, new RuntimeException("Both weibo id and screen_name are null"));
            return;
        }
        try {
            HashMap<String, Object> m19443b = C0696d.m19455a(this).m19443b(i, i2, str);
            if (m19443b == null) {
                if (this.listener != null) {
                    this.listener.onError(this, 2, new Throwable());
                }
            } else if (!m19443b.containsKey("error_code") || ((Integer) m19443b.get("error_code")).intValue() == 0) {
                if (this.listener != null) {
                    this.listener.onComplete(this, 2, m19443b);
                }
            } else if (this.listener != null) {
                this.listener.onError(this, 2, new Throwable(new Hashon().fromHashMap(m19443b)));
            }
        } catch (Throwable th) {
            this.listener.onError(this, 2, th);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public String getName() {
        return NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public int getPlatformId() {
        return 1;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getVersion() {
        return 1;
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean hasShareCallback() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void initDevInfo(String str) {
        this.f1629a = getDevinfo("AppKey");
        this.f1630b = getDevinfo("AppSecret");
        this.f1631c = getDevinfo("RedirectUrl");
        this.f1632d = "true".equals(getDevinfo("ShareByAppClient"));
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean isClientValid() {
        return C0696d.m19455a(this).m19444b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void setNetworkDevinfo() {
        this.f1629a = getNetworkDevinfo("app_key", "AppKey");
        this.f1630b = getNetworkDevinfo("app_secret", "AppSecret");
        this.f1631c = getNetworkDevinfo(AuthorizeActivityBase.KEY_REDIRECT_URI, "RedirectUrl");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void timeline(int i, int i2, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.f1427db.getUserId();
        }
        if (TextUtils.isEmpty(str)) {
            str = this.f1427db.get(RContact.COL_NICKNAME);
        }
        if (TextUtils.isEmpty(str)) {
            if (this.listener == null) {
                return;
            }
            this.listener.onError(this, 7, new RuntimeException("Both weibo id and screen_name are null"));
            return;
        }
        try {
            HashMap<String, Object> m19458a = C0696d.m19455a(this).m19458a(i, i2, str);
            if (m19458a == null) {
                if (this.listener != null) {
                    this.listener.onError(this, 7, new Throwable());
                }
            } else if (!m19458a.containsKey("error_code") || ((Integer) m19458a.get("error_code")).intValue() == 0) {
                if (this.listener != null) {
                    this.listener.onComplete(this, 7, m19458a);
                }
            } else if (this.listener != null) {
                this.listener.onError(this, 7, new Throwable(new Hashon().fromHashMap(m19458a)));
            }
        } catch (Throwable th) {
            this.listener.onError(this, 7, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void userInfor(String str) {
        boolean z = true;
        boolean z2 = false;
        if (TextUtils.isEmpty(str)) {
            str = this.f1427db.getUserId();
            z2 = true;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.f1427db.get(RContact.COL_NICKNAME);
        } else {
            z = z2;
        }
        if (TextUtils.isEmpty(str)) {
            if (this.listener == null) {
                return;
            }
            this.listener.onError(this, 8, new RuntimeException("Both weibo id and screen_name are null"));
            return;
        }
        try {
            HashMap<String, Object> m19437c = C0696d.m19455a(this).m19437c(str);
            if (m19437c == null) {
                if (this.listener == null) {
                    return;
                }
                this.listener.onError(this, 8, new Throwable());
            } else if (m19437c.containsKey("error_code") && ((Integer) m19437c.get("error_code")).intValue() != 0) {
                if (this.listener == null) {
                    return;
                }
                this.listener.onError(this, 8, new Throwable(new Hashon().fromHashMap(m19437c)));
            } else {
                if (z) {
                    this.f1427db.putUserId(String.valueOf(m19437c.get("id")));
                    this.f1427db.put(RContact.COL_NICKNAME, String.valueOf(m19437c.get("screen_name")));
                    this.f1427db.put("icon", String.valueOf(m19437c.get("avatar_hd")));
                    if (String.valueOf(m19437c.get("verified")).equals("true")) {
                        this.f1427db.put("secretType", "1");
                    } else {
                        this.f1427db.put("secretType", "0");
                    }
                    this.f1427db.put(MMPluginProviderConstants.OAuth.SECRET, String.valueOf(m19437c.get("verified_reason")));
                    String valueOf = String.valueOf(m19437c.get("gender"));
                    if (valueOf.equals(C0413a.f922b)) {
                        this.f1427db.put("gender", "0");
                    } else if (valueOf.equals("f")) {
                        this.f1427db.put("gender", "1");
                    } else {
                        this.f1427db.put("gender", "2");
                    }
                    this.f1427db.put("snsUserUrl", "http://weibo.com/" + String.valueOf(m19437c.get("profile_url")));
                    this.f1427db.put("resume", String.valueOf(m19437c.get("description")));
                    this.f1427db.put("followerCount", String.valueOf(m19437c.get("followers_count")));
                    this.f1427db.put("favouriteCount", String.valueOf(m19437c.get("friends_count")));
                    this.f1427db.put("shareCount", String.valueOf(m19437c.get("statuses_count")));
                    this.f1427db.put("snsregat", String.valueOf(ResHelper.dateToLong(String.valueOf(m19437c.get("created_at")))));
                }
                if (this.listener == null) {
                    return;
                }
                this.listener.onComplete(this, 8, m19437c);
            }
        } catch (Throwable th) {
            this.listener.onError(this, 8, th);
        }
    }
}
