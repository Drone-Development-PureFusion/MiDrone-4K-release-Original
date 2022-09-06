package com.tencent.open.weiyun;

import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.p228a.C4331f;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.Util;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class RecordManager extends BaseApi {
    public RecordManager(Context context, QQAuth qQAuth, QQToken qQToken) {
        super(qQAuth, qQToken);
    }

    public RecordManager(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public void checkRecord(String str, final IUiListener iUiListener) {
        Bundle composeCGIParams = composeCGIParams();
        BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(new IUiListener() { // from class: com.tencent.open.weiyun.RecordManager.6
            @Override // com.tencent.tauth.IUiListener
            public void onCancel() {
                iUiListener.onCancel();
            }

            @Override // com.tencent.tauth.IUiListener
            public void onComplete(Object obj) {
                try {
                    if (((JSONObject) obj).getInt("ret") == 0) {
                        iUiListener.onComplete(Boolean.TRUE);
                    } else {
                        iUiListener.onComplete(Boolean.FALSE);
                    }
                } catch (JSONException e) {
                    iUiListener.onError(new UiError(-4, e.getMessage(), null));
                }
            }

            @Override // com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                iUiListener.onError(uiError);
            }
        });
        composeCGIParams.putString("key", Util.toHexString(str));
        HttpUtils.requestAsync(this.mToken, Global.getContext(), "https://graph.qq.com/weiyun/check_record", composeCGIParams, "GET", tempRequestListener);
    }

    public void createRecord(String str, String str2, final IUiListener iUiListener) {
        Bundle composeCGIParams = composeCGIParams();
        BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(new IUiListener() { // from class: com.tencent.open.weiyun.RecordManager.1
            @Override // com.tencent.tauth.IUiListener
            public void onCancel() {
                iUiListener.onCancel();
            }

            @Override // com.tencent.tauth.IUiListener
            public void onComplete(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                try {
                    if (jSONObject.getInt("ret") == 0) {
                        iUiListener.onComplete("");
                    } else {
                        iUiListener.onError(new UiError(-4, jSONObject.toString(), null));
                    }
                } catch (JSONException e) {
                    iUiListener.onError(new UiError(-4, e.getMessage(), null));
                }
            }

            @Override // com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                iUiListener.onError(uiError);
            }
        });
        composeCGIParams.putString("key", Util.toHexString(str));
        try {
            composeCGIParams.putByteArray("value", Util.toHexString(str2).getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            C4331f.m5445b("RecordManager", "-->cr, get value of utf-8 exception.");
        }
        HttpUtils.requestAsync(this.mToken, Global.getContext(), "https://graph.qq.com/weiyun/create_record", composeCGIParams, "POST", tempRequestListener);
    }

    public void deleteRecord(String str, final IUiListener iUiListener) {
        Bundle composeCGIParams = composeCGIParams();
        BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(new IUiListener() { // from class: com.tencent.open.weiyun.RecordManager.2
            @Override // com.tencent.tauth.IUiListener
            public void onCancel() {
                iUiListener.onCancel();
            }

            @Override // com.tencent.tauth.IUiListener
            public void onComplete(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                try {
                    if (jSONObject.getInt("ret") == 0) {
                        iUiListener.onComplete("");
                    } else {
                        iUiListener.onError(new UiError(-4, jSONObject.toString(), null));
                    }
                } catch (JSONException e) {
                    iUiListener.onError(new UiError(-4, e.getMessage(), null));
                }
            }

            @Override // com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                iUiListener.onError(uiError);
            }
        });
        composeCGIParams.putString("key", Util.toHexString(str));
        HttpUtils.requestAsync(this.mToken, Global.getContext(), "https://graph.qq.com/weiyun/delete_record", composeCGIParams, "GET", tempRequestListener);
    }

    public void getRecord(String str, final IUiListener iUiListener) {
        Bundle composeCGIParams = composeCGIParams();
        BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(new IUiListener() { // from class: com.tencent.open.weiyun.RecordManager.3
            @Override // com.tencent.tauth.IUiListener
            public void onCancel() {
                iUiListener.onCancel();
            }

            @Override // com.tencent.tauth.IUiListener
            public void onComplete(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                try {
                    if (jSONObject.getInt("ret") == 0) {
                        iUiListener.onComplete(Util.hexToString(jSONObject.getJSONObject("data").getString("value")));
                    } else {
                        iUiListener.onError(new UiError(-4, jSONObject.toString(), null));
                    }
                } catch (JSONException e) {
                    iUiListener.onError(new UiError(-4, e.getMessage(), null));
                }
            }

            @Override // com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                iUiListener.onError(uiError);
            }
        });
        composeCGIParams.putString("key", Util.toHexString(str));
        HttpUtils.requestAsync(this.mToken, Global.getContext(), "https://graph.qq.com/weiyun/get_record", composeCGIParams, "GET", tempRequestListener);
    }

    public void modifyRecord(String str, String str2, final IUiListener iUiListener) {
        Bundle composeCGIParams = composeCGIParams();
        BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(new IUiListener() { // from class: com.tencent.open.weiyun.RecordManager.4
            @Override // com.tencent.tauth.IUiListener
            public void onCancel() {
                iUiListener.onCancel();
            }

            @Override // com.tencent.tauth.IUiListener
            public void onComplete(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                try {
                    if (jSONObject.getInt("ret") == 0) {
                        iUiListener.onComplete("");
                    } else {
                        iUiListener.onError(new UiError(-4, jSONObject.toString(), null));
                    }
                } catch (JSONException e) {
                    iUiListener.onError(new UiError(-4, e.getMessage(), null));
                }
            }

            @Override // com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                iUiListener.onError(uiError);
            }
        });
        composeCGIParams.putString("key", Util.toHexString(str));
        try {
            composeCGIParams.putByteArray("value", Util.toHexString(str2).getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            C4331f.m5445b("RecordManager", "-->mr, get value of utf-8 exception.");
        }
        HttpUtils.requestAsync(this.mToken, Global.getContext(), "https://graph.qq.com/weiyun/modify_record", composeCGIParams, "POST", tempRequestListener);
    }

    public void queryAllRecord(final IUiListener iUiListener) {
        HttpUtils.requestAsync(this.mToken, Global.getContext(), "https://graph.qq.com/weiyun/query_all_record", composeCGIParams(), "GET", new BaseApi.TempRequestListener(new IUiListener() { // from class: com.tencent.open.weiyun.RecordManager.5
            @Override // com.tencent.tauth.IUiListener
            public void onCancel() {
                iUiListener.onCancel();
            }

            @Override // com.tencent.tauth.IUiListener
            public void onComplete(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                try {
                    if (jSONObject.getInt("ret") != 0) {
                        iUiListener.onError(new UiError(-4, jSONObject.toString(), null));
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    if (!jSONObject2.isNull("keys")) {
                        JSONArray jSONArray = jSONObject2.getJSONArray("keys");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add(Util.hexToString(jSONArray.getJSONObject(i).getString("key")));
                        }
                    }
                    iUiListener.onComplete(arrayList);
                } catch (JSONException e) {
                    iUiListener.onError(new UiError(-4, e.getMessage(), null));
                }
            }

            @Override // com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                iUiListener.onError(uiError);
            }
        }));
    }
}
