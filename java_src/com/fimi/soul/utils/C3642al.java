package com.fimi.soul.utils;

import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.fimi.kernel.C2238c;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p170c.C2374a;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.biz.p185n.C2562f;
import com.fimi.soul.biz.p185n.C2613z;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.entity.User;
import com.fimi.soul.module.login.LoginActivity;
import com.fimi.soul.utils.AbstractC3648am;
import com.xiaomi.account.openauth.XMAuthericationException;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import com.xiaomi.account.openauth.XiaomiOAuthFuture;
import com.xiaomi.account.openauth.XiaomiOAuthResults;
import com.xiaomi.account.openauth.XiaomiOAuthorize;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.fimi.soul.utils.al */
/* loaded from: classes.dex */
public class C3642al implements AbstractC3648am {

    /* renamed from: a */
    private static final String f14801a = "http://dev.xiaomi.com";

    /* renamed from: b */
    private XiaomiOAuthResults f14802b;

    /* renamed from: c */
    private User f14803c = new User();

    /* renamed from: d */
    private C2613z f14804d;

    /* renamed from: e */
    private Context f14805e;

    /* renamed from: f */
    private AbstractC3648am.AbstractC3649a f14806f;

    /* renamed from: g */
    private String f14807g;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.fimi.soul.utils.al$3] */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.fimi.soul.utils.al$4] */
    /* renamed from: a */
    public void m7688a() {
        C2562f.m11683a(this.f14805e).m11679a(new AbstractC2538k() { // from class: com.fimi.soul.utils.al.2
            @Override // com.fimi.soul.biz.p183l.AbstractC2538k
            /* renamed from: a */
            public void mo6501a(PlaneMsg planeMsg, File file) {
            }
        });
        final XiaomiOAuthFuture<String> callOpenApi = new XiaomiOAuthorize().callOpenApi(this.f14805e, Long.parseLong("2882303761517328945"), XiaomiOAuthConstants.OPEN_API_PATH_PHONE, this.f14802b.getAccessToken(), this.f14802b.getMacKey(), this.f14802b.getMacAlgorithm());
        new AsyncTask<Void, Void, String>() { // from class: com.fimi.soul.utils.al.3

            /* renamed from: a */
            Exception f14812a;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public String doInBackground(Void... voidArr) {
                try {
                    return (String) callOpenApi.getResult();
                } catch (OperationCanceledException e) {
                    this.f14812a = e;
                    return null;
                } catch (XMAuthericationException e2) {
                    this.f14812a = e2;
                    return null;
                } catch (IOException e3) {
                    this.f14812a = e3;
                    return null;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public void onPostExecute(String str) {
                if (str == null) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
                    if (jSONObject.getString("phone") == null || jSONObject.getString("phone").length() <= 0) {
                        return;
                    }
                    C3642al.this.f14803c.setPhone(jSONObject.getString("phone"));
                } catch (NullPointerException e) {
                    e.printStackTrace();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // android.os.AsyncTask
            protected void onPreExecute() {
                C2353b.m12509a("waiting for Future result...", LoginActivity.class);
            }
        }.execute(new Void[0]);
        final XiaomiOAuthFuture<String> callOpenApi2 = new XiaomiOAuthorize().callOpenApi(this.f14805e, Long.parseLong("2882303761517328945"), XiaomiOAuthConstants.OPEN_API_PATH_PROFILE, this.f14802b.getAccessToken(), this.f14802b.getMacKey(), this.f14802b.getMacAlgorithm());
        new AsyncTask<Void, Void, String>() { // from class: com.fimi.soul.utils.al.4

            /* renamed from: a */
            Exception f14815a;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public String doInBackground(Void... voidArr) {
                try {
                    return (String) callOpenApi2.getResult();
                } catch (OperationCanceledException e) {
                    this.f14815a = e;
                    return null;
                } catch (XMAuthericationException e2) {
                    this.f14815a = e2;
                    return null;
                } catch (IOException e3) {
                    this.f14815a = e3;
                    return null;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public void onPostExecute(String str) {
                if (TextUtils.isEmpty(str)) {
                    if (C3642al.this.f14806f == null) {
                        return;
                    }
                    C3642al.this.f14806f.mo7670a(C3642al.this.f14805e.getResources().getString(C2300R.C2303string.login_result));
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
                    C3642al.this.f14803c.setXiaomiID(jSONObject.getString("userId"));
                    C3642al.this.f14803c.setName(jSONObject.getString("miliaoNick"));
                    C3642al.this.f14803c.setNickName(jSONObject.getString("miliaoNick"));
                    C3642al.this.f14803c.setDevice(C3658ar.m7619a(C2238c.m13131a()));
                    if (jSONObject.has("sex")) {
                        if (jSONObject.getString("sex").equals(C3642al.this.f14805e.getResources().getString(C2300R.C2303string.man))) {
                            C3642al.this.f14803c.setSex("1");
                        } else if (jSONObject.getString("sex").equals(C3642al.this.f14805e.getResources().getString(C2300R.C2303string.woman))) {
                            C3642al.this.f14803c.setSex("0");
                        }
                    }
                    if (jSONObject.has("miliaoIcon_orig")) {
                        C3642al.this.f14803c.setUserImgUrl(jSONObject.getString("miliaoIcon_orig"));
                    }
                    C3642al.this.f14804d.m11505d(C3642al.this.f14803c, new AbstractC2538k() { // from class: com.fimi.soul.utils.al.4.1
                        @Override // com.fimi.soul.biz.p183l.AbstractC2538k
                        /* renamed from: a */
                        public void mo6501a(PlaneMsg planeMsg, File file) {
                            C3642al.this.f14807g = planeMsg.getErrorMessage();
                            if (planeMsg.isSuccess()) {
                                MiPushClient.registerPush(C3642al.this.f14805e, "2882303761517328945", C2353b.f7959q);
                                if (C3642al.this.f14806f == null) {
                                    return;
                                }
                                C3642al.this.f14806f.mo7671a();
                            } else if (C3642al.this.f14807g != null) {
                                if (C3642al.this.f14806f == null) {
                                    return;
                                }
                                C3642al.this.f14806f.mo7670a(C3642al.this.f14807g);
                            } else if (C3642al.this.f14806f == null) {
                            } else {
                                C3642al.this.f14806f.mo7670a(C3642al.this.f14805e.getResources().getString(C2300R.C2303string.login_result_net));
                            }
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override // android.os.AsyncTask
            protected void onPreExecute() {
                C2353b.m12509a("waiting for Future result...", LoginActivity.class);
            }
        }.execute(new Void[0]);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.fimi.soul.utils.al$1] */
    /* renamed from: a */
    private <V> void m7684a(final XiaomiOAuthFuture<V> xiaomiOAuthFuture) {
        new AsyncTask<Void, Void, V>() { // from class: com.fimi.soul.utils.al.1

            /* renamed from: a */
            Exception f14808a;

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r0v4, types: [V, java.lang.Object] */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public V doInBackground(Void... voidArr) {
                try {
                    return xiaomiOAuthFuture.getResult();
                } catch (OperationCanceledException e) {
                    this.f14808a = e;
                    return null;
                } catch (XMAuthericationException e2) {
                    this.f14808a = e2;
                    return null;
                } catch (IOException e3) {
                    this.f14808a = e3;
                    return null;
                }
            }

            @Override // android.os.AsyncTask
            protected void onPostExecute(V v) {
                if (v == 0) {
                    if (this.f14808a != null) {
                        if (C3642al.this.f14806f == null) {
                            return;
                        }
                        C3642al.this.f14806f.mo7669b();
                    } else if (C3642al.this.f14806f == null) {
                    } else {
                        C3642al.this.f14806f.mo7670a(C3642al.this.f14805e.getResources().getString(C2300R.C2303string.login_result));
                    }
                } else if (!(v instanceof XiaomiOAuthResults)) {
                } else {
                    C3642al.this.f14802b = (XiaomiOAuthResults) v;
                    if (C3642al.this.f14802b.getAccessToken() == null) {
                        if (C3642al.this.f14806f == null) {
                            return;
                        }
                        C3642al.this.f14806f.mo7670a(C3642al.this.f14805e.getResources().getString(C2300R.C2303string.login_result));
                        return;
                    }
                    C2374a.m12421c(C2238c.m13131a(), 0, C3642al.this.f14802b.getAccessToken());
                    C2374a.m12423b(C2238c.m13131a(), 0, C3642al.this.f14802b.getMacKey());
                    C2374a.m12425a(C2238c.m13131a(), 0, C3642al.this.f14802b.getMacAlgorithm());
                    C3642al.this.m7688a();
                }
            }

            @Override // android.os.AsyncTask
            protected void onPreExecute() {
                C2353b.m12509a("waiting for Future result...", LoginActivity.class);
            }
        }.execute(new Void[0]);
    }

    @Override // com.fimi.soul.utils.AbstractC3648am
    /* renamed from: a */
    public void mo7672a(Context context, AbstractC3648am.AbstractC3649a abstractC3649a) {
        this.f14805e = context;
        this.f14806f = abstractC3649a;
        this.f14804d = C2613z.m11525a(context);
        m7684a(new XiaomiOAuthorize().setAppId(Long.parseLong("2882303761517328945")).setRedirectUrl(f14801a).setScope(Arrays.copyOf(new int[4], 0)).setKeepCookies(true).setNoMiui(false).setSkipConfirm(false).startGetAccessToken((Activity) context));
    }
}
