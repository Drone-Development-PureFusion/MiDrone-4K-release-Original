package cn.sharesdk.framework;

import android.content.Context;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.p075b.p077b.C0660f;
import cn.sharesdk.framework.utils.C0683d;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.p219mi.live.openlivesdk.C4095b;
import java.util.HashMap;
/* loaded from: classes.dex */
public abstract class Service {

    /* renamed from: a */
    private Context f1435a;

    /* renamed from: b */
    private String f1436b;

    /* loaded from: classes.dex */
    public static abstract class ServiceEvent {
        private static final int PLATFORM = 1;
        protected Service service;

        public ServiceEvent(Service service) {
            this.service = service;
        }

        protected HashMap<String, Object> filterShareContent(int i, Platform.ShareParams shareParams, HashMap<String, Object> hashMap) {
            C0660f.C0661a filterShareContent = ShareSDK.getPlatform(ShareSDK.platformIdToName(i)).filterShareContent(shareParams, hashMap);
            HashMap<String, Object> hashMap2 = new HashMap<>();
            hashMap2.put("shareID", filterShareContent.f1531a);
            hashMap2.put("shareContent", new Hashon().fromJson(filterShareContent.toString()));
            C0683d.m19513a().m5966i("filterShareContent ==>>%s", hashMap2);
            return hashMap2;
        }

        protected HashMap<String, Object> toMap() {
            HashMap<String, Object> hashMap = new HashMap<>();
            DeviceHelper deviceHelper = DeviceHelper.getInstance(this.service.f1435a);
            hashMap.put("deviceid", deviceHelper.getDeviceKey());
            hashMap.put(C4095b.f17105f, this.service.getAppKey());
            hashMap.put("apppkg", deviceHelper.getPackageName());
            hashMap.put("appver", Integer.valueOf(deviceHelper.getAppVersion()));
            hashMap.put("sdkver", Integer.valueOf(this.service.getServiceVersionInt()));
            hashMap.put("plat", 1);
            hashMap.put("networktype", deviceHelper.getDetailNetworkTypeForStatic());
            hashMap.put("deviceData", deviceHelper.getDeviceDataNotAES());
            return hashMap;
        }

        public final String toString() {
            return new Hashon().fromHashMap(toMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m19770a(Context context) {
        this.f1435a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m19768a(String str) {
        this.f1436b = str;
    }

    public String getAppKey() {
        return this.f1436b;
    }

    public Context getContext() {
        return this.f1435a;
    }

    public String getDeviceKey() {
        return DeviceHelper.getInstance(this.f1435a).getDeviceKey();
    }

    protected abstract int getServiceVersionInt();

    public abstract String getServiceVersionName();

    public void onBind() {
    }

    public void onUnbind() {
    }
}
