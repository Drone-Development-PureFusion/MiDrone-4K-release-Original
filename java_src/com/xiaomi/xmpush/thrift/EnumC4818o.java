package com.xiaomi.xmpush.thrift;

import java.util.Map;
/* renamed from: com.xiaomi.xmpush.thrift.o */
/* loaded from: classes2.dex */
public enum EnumC4818o {
    Invalid("INVALID"),
    BarClick("bar:click"),
    BarCancel("bar:cancel"),
    AppOpen("app:open"),
    PackageUninstall("package uninstalled"),
    AppUninstall("app_uninstalled"),
    ClientInfoUpdate("client_info_update"),
    ClientInfoUpdateOk("client_info_update_ok"),
    ClientMIIDUpdate("client_miid_update"),
    PullOfflineMessage("pull"),
    IosSleep("ios_sleep"),
    IosWakeUp("ios_wakeup"),
    AwakeApp("awake_app"),
    NormalClientConfigUpdate("normal_client_config_update"),
    CustomClientConfigUpdate("custom_client_config_update"),
    DailyCheckClientConfig("daily_check_client_config"),
    DataCollection("data_collection"),
    RegIdExpired("registration id expired"),
    ConnectionDisabled("!!!MILINK CONNECTION DISABLED!!!"),
    PackageUnregistered("package_unregistered"),
    DecryptMessageFail("decrypt_msg_fail"),
    SyncInfo("sync_info"),
    SyncInfoResult("sync_info_result"),
    ForceSync("force_sync"),
    UploadClientLog("upload_client_log"),
    NotificationBarInfo("notification_bar_info"),
    SyncMIID("sync_miid"),
    UploadTinyData("upload"),
    GeoUpdateLoc("geo_update_loc"),
    GeoRegsiter("geo_reg"),
    GeoRegsiterResult("geo_reg_result"),
    GeoUnregsiter("geo_unreg"),
    GeoUnregsiterResult("geo_unreg_result"),
    GeoSync("geo_sync"),
    GeoUpload("geo_upload"),
    GeoPackageUninstalled("geo_package_uninstalled"),
    CancelPushMessage("clear_push_message"),
    DisablePushMessage("disable_push"),
    EnablePushMessage("enable_push");
    

    /* renamed from: O */
    public static Map<String, EnumC4818o> f20348O = null;

    /* renamed from: N */
    public final String f20376N;

    EnumC4818o(String str) {
        this.f20376N = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f20376N;
    }
}
