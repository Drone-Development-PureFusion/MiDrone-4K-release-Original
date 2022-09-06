package com.tencent.p227mm.sdk.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import com.tencent.p227mm.algorithm.Base64;
import com.tencent.p227mm.sdk.ConstantsUI;
import com.tencent.p227mm.sdk.channel.MMessage;
import com.tencent.p227mm.sdk.platformtools.Log;
import com.tencent.p227mm.sdk.platformtools.Util;
import com.tencent.p227mm.sdk.plugin.MMPluginProviderConstants;
import org.p318d.AbstractC5756f;
/* renamed from: com.tencent.mm.sdk.plugin.MMPluginAPIImpl */
/* loaded from: classes2.dex */
public class MMPluginAPIImpl implements IMMPluginAPI {
    private static final String[] columns = {"key", "type", "value"};

    /* renamed from: R */
    private final Context f17886R;

    /* renamed from: aE */
    private String f17887aE;

    /* renamed from: bz */
    private MMessage.Receiver f17888bz;

    public MMPluginAPIImpl(Context context) {
        this.f17886R = context;
        this.f17887aE = context.getPackageName();
    }

    /* renamed from: a */
    private void m5624a(String str, String str2, Intent intent) {
        Intent intent2 = new Intent(str2);
        intent2.setClassName(MMPluginProviderConstants.PluginIntent.APP_PACKAGE_PATTERN, "com.tencent.mm.plugin.PluginProxyUI");
        if (intent != null) {
            intent2.putExtras(intent);
        }
        intent2.putExtra(MMPluginProviderConstants.PluginIntent.ACCESS_TOKEN, str);
        this.f17886R.startActivity(intent2);
    }

    /* renamed from: c */
    private Object m5623c(String str) {
        Object obj = null;
        Cursor query = this.f17886R.getContentResolver().query(MMPluginProviderConstants.PluginDB.CONTENT_URI, columns, null, new String[]{str}, null);
        if (query != null) {
            int columnIndex = query.getColumnIndex("type");
            int columnIndex2 = query.getColumnIndex("value");
            if (query.moveToFirst()) {
                obj = MMPluginProviderConstants.Resolver.resolveObj(query.getInt(columnIndex), query.getString(columnIndex2));
            }
            query.close();
        }
        return obj;
    }

    @Override // com.tencent.p227mm.sdk.plugin.IMMPluginAPI
    public boolean appendNetStat(int i, int i2, int i3) {
        return Util.nullAsFalse((Boolean) m5623c("plugindb://" + this.f17887aE + "/action.appnetstat?recv=" + i + "&send=" + i2 + "&type=" + i3));
    }

    @Override // com.tencent.p227mm.sdk.plugin.IMMPluginAPI
    public void createMsgController(String str) {
    }

    @Override // com.tencent.p227mm.sdk.plugin.IMMPluginAPI
    public void createQRCodeController(String str) {
        m5624a(str, "qrcode", null);
    }

    @Override // com.tencent.p227mm.sdk.plugin.IMMPluginAPI
    public void createQRCodeController(String str, MMessage.CallBack callBack) {
        createQRCodeController(str, callBack, AbstractC5756f.f23062a);
    }

    @Override // com.tencent.p227mm.sdk.plugin.IMMPluginAPI
    public void createQRCodeController(String str, MMessage.CallBack callBack, String str2) {
        m5624a(str, "qrcode", new Intent().putExtra("qrcode_pattern", str2));
    }

    @Override // com.tencent.p227mm.sdk.plugin.IMMPluginAPI
    public Profile getCurrentProfile(String str) {
        Profile profile = null;
        Cursor query = this.f17886R.getContentResolver().query(Profile.CONTENT_URI, Profile.columns, null, new String[]{str}, null);
        if (query == null) {
            Log.m5647e("MicroMsg.SDK.MMPluginMgrImpl", "get current profile failed");
        } else {
            if (query.moveToFirst()) {
                profile = new Profile();
                profile.convertFrom(query);
            }
            query.close();
        }
        return profile;
    }

    @Override // com.tencent.p227mm.sdk.plugin.IMMPluginAPI
    public String getPluginKey(String str) {
        return (String) m5623c("plugindb://" + str + "/comm.pluginkey");
    }

    @Override // com.tencent.p227mm.sdk.plugin.IMMPluginAPI
    public boolean installPlugin(String str) {
        return Util.nullAsFalse((Boolean) m5623c("plugindb://" + str + "/action.install"));
    }

    @Override // com.tencent.p227mm.sdk.plugin.IMMPluginAPI
    public boolean isPluginInstalled(String str) {
        return Util.nullAsFalse((Boolean) m5623c("plugindb://" + str + "/comm.installed"));
    }

    @Override // com.tencent.p227mm.sdk.plugin.IMMPluginAPI
    public void jumpToBindEmail(String str) {
        m5624a(str, "bindemail", new Intent());
    }

    @Override // com.tencent.p227mm.sdk.plugin.IMMPluginAPI
    public void jumpToBindMobile(String str) {
        m5624a(str, "bindmobile", new Intent());
    }

    @Override // com.tencent.p227mm.sdk.plugin.IMMPluginAPI
    public void jumpToBindQQ(String str) {
        m5624a(str, "bindqq", new Intent());
    }

    @Override // com.tencent.p227mm.sdk.plugin.IMMPluginAPI
    public void jumpToChattingUI(String str, String str2) {
        m5624a(str, "chatting", new Intent().putExtra(ConstantsUI.Contact.KUser, str2).setFlags(67108864));
    }

    @Override // com.tencent.p227mm.sdk.plugin.IMMPluginAPI
    public void jumpToSettingView(String str, String str2) {
        m5624a(str, "profile", new Intent().putExtra(ConstantsUI.Contact.KUser, str2).setFlags(67108864));
    }

    @Override // com.tencent.p227mm.sdk.plugin.IMMPluginAPI
    public boolean registerAutoMsg(String str, String str2) {
        return Util.nullAsFalse((Boolean) m5623c("plugindb://" + this.f17887aE + "/action.automsg?pluginMsgUsername=" + str + "&pluginUsername=" + str2));
    }

    @Override // com.tencent.p227mm.sdk.plugin.IMMPluginAPI
    public boolean registerPattern(String str, MMessage.CallBack callBack, String str2) {
        return false;
    }

    @Override // com.tencent.p227mm.sdk.plugin.IMMPluginAPI
    public boolean registerQRCodePattern(String str, MMessage.CallBack callBack, String str2) {
        if (this.f17888bz != null) {
            this.f17886R.unregisterReceiver(this.f17888bz);
        }
        this.f17888bz = new MMessage.Receiver(callBack);
        this.f17886R.registerReceiver(this.f17888bz, new IntentFilter(MMPluginProviderConstants.PluginIntent.ACTION_QRCODE_SCANNED));
        return Util.nullAsFalse((Boolean) m5623c("plugindb://" + str + "/action.register_qrcode_result?pattern=" + str2));
    }

    @Override // com.tencent.p227mm.sdk.plugin.IMMPluginAPI
    public void release() {
        Log.m5649d("MicroMsg.SDK.MMPluginMgrImpl", "release plugin mgr implemetation");
        if (this.f17888bz != null) {
            this.f17886R.unregisterReceiver(this.f17888bz);
            Log.m5649d("MicroMsg.SDK.MMPluginMgrImpl", "unregister qrcode scan result receiver");
        }
    }

    @Override // com.tencent.p227mm.sdk.plugin.IMMPluginAPI
    public boolean sendMsgNotify(String str, String str2, int i, String str3, Class<?> cls) {
        if (cls == null) {
            return false;
        }
        return Util.nullAsFalse((Boolean) m5623c("plugindb://" + this.f17887aE + "/action.msgnotify?username=" + str + "&msgContent=" + str2 + "&msgType=" + i + "&customNotify=" + str3 + "&intentUri=" + Base64.encodeToString(new Intent(this.f17886R, cls).toUri(0).getBytes(), false)));
    }

    @Override // com.tencent.p227mm.sdk.plugin.IMMPluginAPI
    public boolean unregisterAutoMsg(String str, String str2) {
        return Util.nullAsFalse((Boolean) m5623c("plugindb://" + this.f17887aE + "/action.unautomsg?pluginMsgUsername=" + str + "&pluginUsername=" + str2));
    }
}
