package com.tencent.open;

import android.app.Activity;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.p223a.C4188a;
import com.tencent.open.C4350c;
import com.tencent.open.p228a.C4331f;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.Util;
import com.tencent.tauth.IRequestListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;
import p004b.p005a.p006a.p028b.p054o.AbstractC0517a;
/* loaded from: classes2.dex */
public class LocationApi extends BaseApi implements C4350c.AbstractC4351a {

    /* renamed from: a */
    private HandlerThread f17934a;

    /* renamed from: b */
    private Handler f17935b;

    /* renamed from: c */
    private Handler f17936c;

    /* renamed from: d */
    private C4350c f17937d;

    /* renamed from: e */
    private Bundle f17938e;

    /* renamed from: f */
    private IUiListener f17939f;

    /* renamed from: com.tencent.open.LocationApi$a */
    /* loaded from: classes2.dex */
    private abstract class AbstractC4290a implements IRequestListener {
        private AbstractC4290a() {
        }

        /* renamed from: a */
        protected abstract void mo5588a(Exception exc);

        @Override // com.tencent.tauth.IRequestListener
        public void onConnectTimeoutException(ConnectTimeoutException connectTimeoutException) {
            mo5588a(connectTimeoutException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onHttpStatusException(HttpUtils.HttpStatusException httpStatusException) {
            mo5588a(httpStatusException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onIOException(IOException iOException) {
            mo5588a(iOException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onJSONException(JSONException jSONException) {
            mo5588a(jSONException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onMalformedURLException(MalformedURLException malformedURLException) {
            mo5588a(malformedURLException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onNetworkUnavailableException(HttpUtils.NetworkUnavailableException networkUnavailableException) {
            mo5588a(networkUnavailableException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onSocketTimeoutException(SocketTimeoutException socketTimeoutException) {
            mo5588a(socketTimeoutException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onUnknowException(Exception exc) {
            mo5588a(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tencent.open.LocationApi$b */
    /* loaded from: classes2.dex */
    public class C4291b extends AbstractC4290a {

        /* renamed from: c */
        private IUiListener f17947c;

        public C4291b(IUiListener iUiListener) {
            super();
            this.f17947c = iUiListener;
        }

        @Override // com.tencent.open.LocationApi.AbstractC4290a
        /* renamed from: a */
        protected void mo5588a(Exception exc) {
            if (this.f17947c != null) {
                this.f17947c.onError(new UiError(100, exc.getMessage(), null));
            }
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onComplete(JSONObject jSONObject) {
            if (this.f17947c != null) {
                this.f17947c.onComplete(jSONObject);
            }
            C4331f.m5445b("SDKQQAgentPref", "GetNearbySwitchEnd:" + SystemClock.elapsedRealtime());
        }
    }

    public LocationApi(QQAuth qQAuth, QQToken qQToken) {
        super(qQAuth, qQToken);
        m5599a();
    }

    public LocationApi(QQToken qQToken) {
        super(qQToken);
        m5599a();
    }

    /* renamed from: a */
    private void m5599a() {
        this.f17937d = new C4350c();
        this.f17934a = new HandlerThread("get_location");
        this.f17934a.start();
        this.f17935b = new Handler(this.f17934a.getLooper());
        this.f17936c = new Handler(Global.getContext().getMainLooper()) { // from class: com.tencent.open.LocationApi.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 101:
                        C4331f.m5445b(C4331f.f18119d, "location: get location timeout.");
                        LocationApi.this.m5598a(-13, Constants.MSG_LOCATION_TIMEOUT_ERROR);
                        break;
                    case 103:
                        C4331f.m5445b(C4331f.f18119d, "location: verify sosocode success.");
                        LocationApi.this.f17937d.m5389a(Global.getContext(), LocationApi.this);
                        LocationApi.this.f17936c.sendEmptyMessageDelayed(101, AbstractC0517a.f1169e);
                        break;
                    case 104:
                        C4331f.m5445b(C4331f.f18119d, "location: verify sosocode failed.");
                        LocationApi.this.m5598a(-14, Constants.MSG_LOCATION_VERIFY_ERROR);
                        break;
                }
                super.handleMessage(message);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5598a(int i, String str) {
        this.f17937d.m5388b();
        if (this.f17939f == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", i);
            jSONObject.put("errMsg", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.f17939f.onComplete(jSONObject);
    }

    /* renamed from: a */
    private void m5597a(Location location) {
        Bundle composeCGIParams;
        C4331f.m5445b(C4331f.f18119d, "location: search mParams: " + this.f17938e);
        if (this.f17938e != null) {
            composeCGIParams = new Bundle(this.f17938e);
            composeCGIParams.putAll(composeCGIParams());
        } else {
            composeCGIParams = composeCGIParams();
        }
        String valueOf = String.valueOf(location.getLatitude());
        String valueOf2 = String.valueOf(location.getLongitude());
        composeCGIParams.putString("appid", this.mToken.getAppId());
        if (!composeCGIParams.containsKey("latitude")) {
            composeCGIParams.putString("latitude", valueOf);
        }
        if (!composeCGIParams.containsKey("longitude")) {
            composeCGIParams.putString("longitude", valueOf2);
        }
        if (!composeCGIParams.containsKey("page")) {
            composeCGIParams.putString("page", String.valueOf(1));
        }
        composeCGIParams.putString("encrytoken", Util.encrypt("tencent&sdk&qazxc***14969%%" + this.mToken.getAccessToken() + this.mToken.getAppId() + this.mToken.getOpenId() + "qzone3.4"));
        C4331f.m5445b(C4331f.f18119d, "location: search params: " + composeCGIParams);
        C4331f.m5445b("SDKQQAgentPref", "GetNearbySwitchStart:" + SystemClock.elapsedRealtime());
        HttpUtils.requestAsync(this.mToken, Global.getContext(), "http://fusion.qq.com/cgi-bin/qzapps/mapp_lbs_getnear.cgi", composeCGIParams, "GET", new C4291b(this.f17939f));
    }

    /* renamed from: a */
    private void m5594a(final String str, final String... strArr) {
        this.f17935b.post(new Runnable() { // from class: com.tencent.open.LocationApi.3
            @Override // java.lang.Runnable
            public void run() {
                if (strArr == null || strArr.length == 0) {
                    return;
                }
                C4188a.m5956a(Global.getContext(), LocationApi.this.mToken, "search_nearby".equals(str) ? "id_search_nearby" : "id_delete_location", strArr);
            }
        });
    }

    /* renamed from: b */
    private void m5593b() {
        this.f17937d.m5388b();
    }

    /* renamed from: c */
    private boolean m5591c() {
        ConnectivityManager connectivityManager = (ConnectivityManager) Global.getContext().getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
        }
        return false;
    }

    /* renamed from: d */
    private JSONObject m5589d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", -9);
            jSONObject.put("errMsg", Constants.MSG_IO_ERROR);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void deleteLocation(Activity activity, Bundle bundle, IUiListener iUiListener) {
        Bundle composeCGIParams;
        if (!m5591c()) {
            if (iUiListener == null) {
                return;
            }
            iUiListener.onComplete(m5589d());
            return;
        }
        if (bundle != null) {
            composeCGIParams = new Bundle(bundle);
            composeCGIParams.putAll(composeCGIParams());
        } else {
            composeCGIParams = composeCGIParams();
        }
        composeCGIParams.putString("appid", this.mToken.getAppId());
        composeCGIParams.putString("timestamp", String.valueOf(System.currentTimeMillis()));
        composeCGIParams.putString("encrytoken", Util.encrypt("tencent&sdk&qazxc***14969%%" + this.mToken.getAccessToken() + this.mToken.getAppId() + this.mToken.getOpenId() + "qzone3.4"));
        C4331f.m5445b(C4331f.f18119d, "location: delete params: " + composeCGIParams);
        HttpUtils.requestAsync(this.mToken, Global.getContext(), "http://fusion.qq.com/cgi-bin/qzapps/mapp_lbs_delete.cgi", composeCGIParams, "GET", new C4291b(iUiListener));
        m5594a("delete_location", "success");
    }

    @Override // com.tencent.open.C4350c.AbstractC4351a
    public void onLocationUpdate(Location location) {
        m5597a(location);
        m5593b();
        this.f17936c.removeMessages(101);
    }

    public void searchNearby(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (!m5591c()) {
            if (iUiListener == null) {
                return;
            }
            iUiListener.onComplete(m5589d());
            return;
        }
        this.f17938e = bundle;
        this.f17939f = iUiListener;
        this.f17935b.post(new Runnable() { // from class: com.tencent.open.LocationApi.2
            @Override // java.lang.Runnable
            public void run() {
                if (LocationApi.this.f17937d.m5390a()) {
                    Message.obtain(LocationApi.this.f17936c, 103).sendToTarget();
                } else {
                    Message.obtain(LocationApi.this.f17936c, 104).sendToTarget();
                }
            }
        });
    }
}
