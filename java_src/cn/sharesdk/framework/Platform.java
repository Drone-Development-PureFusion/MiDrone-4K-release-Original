package cn.sharesdk.framework;

import android.content.Context;
import android.graphics.Bitmap;
import cn.sharesdk.framework.p075b.p077b.C0660f;
import java.util.HashMap;
/* loaded from: classes.dex */
public abstract class Platform {
    public static final int ACTION_AUTHORIZING = 1;
    protected static final int ACTION_CUSTOMER = 655360;
    public static final int ACTION_FOLLOWING_USER = 6;
    protected static final int ACTION_GETTING_BILATERAL_LIST = 10;
    protected static final int ACTION_GETTING_FOLLOWER_LIST = 11;
    public static final int ACTION_GETTING_FRIEND_LIST = 2;
    public static final int ACTION_SENDING_DIRECT_MESSAGE = 5;
    public static final int ACTION_SHARE = 9;
    public static final int ACTION_TIMELINE = 7;
    public static final int ACTION_USER_INFOR = 8;
    public static final int CUSTOMER_ACTION_MASK = 65535;
    public static final int SHARE_APPS = 7;
    public static final int SHARE_EMOJI = 9;
    public static final int SHARE_FILE = 8;
    public static final int SHARE_IMAGE = 2;
    public static final int SHARE_MUSIC = 5;
    public static final int SHARE_TEXT = 1;
    public static final int SHARE_VIDEO = 6;
    public static final int SHARE_WEBPAGE = 4;
    public static final int SHARE_ZHIFUBAO = 10;

    /* renamed from: a */
    private C0665c f1426a;
    protected final Context context;

    /* renamed from: db */
    protected final PlatformDb f1427db;
    protected PlatformActionListener listener;

    /* loaded from: classes.dex */
    public static class ShareParams extends InnerShareParams {
        @Deprecated
        public String imagePath;
        @Deprecated
        public String text;

        public ShareParams() {
        }

        public ShareParams(String str) {
            super(str);
        }

        public ShareParams(HashMap<String, Object> hashMap) {
            super(hashMap);
        }
    }

    public Platform(Context context) {
        this.context = context;
        this.f1426a = new C0665c(this, context);
        this.f1427db = this.f1426a.m19586g();
        this.listener = this.f1426a.m19584i();
    }

    public void SSOSetting(boolean z) {
        this.f1426a.m19599a(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m19772a() {
        this.f1426a.m19599a(false);
        this.f1426a.m19603a(getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afterRegister(int i, Object obj) {
        this.f1426a.m19596b(i, obj);
    }

    public void authorize() {
        authorize(null);
    }

    public void authorize(String[] strArr) {
        this.f1426a.m19598a(strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean m19771b() {
        return this.f1426a.m19587f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean checkAuthorize(int i, Object obj);

    /* JADX INFO: Access modifiers changed from: protected */
    public void copyDevinfo(String str, String str2) {
        ShareSDK.m19762a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void copyNetworkDevinfo(int i, int i2) {
        ShareSDK.m19766a(i, i2);
    }

    public void customerProtocol(String str, String str2, short s, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
        this.f1426a.m19601a(str, str2, s, hashMap, hashMap2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void doAuthorize(String[] strArr);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void doCustomerProtocol(String str, String str2, int i, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void doShare(ShareParams shareParams);

    protected abstract HashMap<String, Object> filterFriendshipInfo(int i, HashMap<String, Object> hashMap);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract C0660f.C0661a filterShareContent(ShareParams shareParams, HashMap<String, Object> hashMap);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void follow(String str);

    public void followFriend(String str) {
        this.f1426a.m19594b(str);
    }

    protected abstract HashMap<String, Object> getBilaterals(int i, int i2, String str);

    public Context getContext() {
        return this.context;
    }

    public PlatformDb getDb() {
        return this.f1427db;
    }

    public String getDevinfo(String str) {
        return getDevinfo(getName(), str);
    }

    public String getDevinfo(String str, String str2) {
        return ShareSDK.m19758b(str, str2);
    }

    protected abstract HashMap<String, Object> getFollowers(int i, int i2, String str);

    protected abstract HashMap<String, Object> getFollowings(int i, int i2, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void getFriendList(int i, int i2, String str);

    public int getId() {
        return this.f1426a.m19611a();
    }

    public abstract String getName();

    /* JADX INFO: Access modifiers changed from: protected */
    public String getNetworkDevinfo(int i, String str, String str2) {
        return this.f1426a.m19608a(i, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getNetworkDevinfo(String str, String str2) {
        return getNetworkDevinfo(getPlatformId(), str, str2);
    }

    public PlatformActionListener getPlatformActionListener() {
        return this.f1426a.m19593c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int getPlatformId();

    public String getShortLintk(String str, boolean z) {
        return this.f1426a.m19600a(str, z);
    }

    public int getSortId() {
        return this.f1426a.m19597b();
    }

    public void getTimeLine(String str, int i, int i2) {
        this.f1426a.m19602a(str, i, i2);
    }

    public abstract int getVersion();

    public abstract boolean hasShareCallback();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void initDevInfo(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public void innerAuthorize(int i, Object obj) {
        this.f1426a.m19609a(i, obj);
    }

    public boolean isAuthValid() {
        return this.f1426a.m19590d();
    }

    public boolean isClientValid() {
        return false;
    }

    public boolean isSSODisable() {
        return this.f1426a.m19588e();
    }

    @Deprecated
    public boolean isValid() {
        return this.f1426a.m19590d();
    }

    public void listFriend(int i, int i2, String str) {
        this.f1426a.m19610a(i, i2, str);
    }

    @Deprecated
    public void removeAccount() {
        this.f1426a.m19585h();
    }

    public void removeAccount(boolean z) {
        this.f1426a.m19585h();
        ShareSDK.removeCookieOnAuthorize(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setNetworkDevinfo();

    public void setPlatformActionListener(PlatformActionListener platformActionListener) {
        this.f1426a.m19605a(platformActionListener);
    }

    public void share(ShareParams shareParams) {
        this.f1426a.m19606a(shareParams);
    }

    public void showUser(String str) {
        this.f1426a.m19591c(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void timeline(int i, int i2, String str);

    protected String uploadImageToFileServer(Bitmap bitmap) {
        return this.f1426a.m19607a(bitmap);
    }

    protected String uploadImageToFileServer(String str) {
        return this.f1426a.m19589d(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void userInfor(String str);
}
