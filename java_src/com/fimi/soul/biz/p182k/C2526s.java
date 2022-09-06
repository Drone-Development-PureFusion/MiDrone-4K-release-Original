package com.fimi.soul.biz.p182k;

import android.content.Context;
import android.location.Location;
import android.util.Log;
import com.amap.api.services.district.DistrictSearchQuery;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p170c.C2374a;
import com.fimi.soul.biz.p183l.AbstractC2542o;
import com.fimi.soul.biz.p185n.C2571k;
import com.fimi.soul.biz.p185n.C2582p;
import com.fimi.soul.entity.FlightTimeInfo;
import com.fimi.soul.entity.NearPerson;
import com.fimi.soul.entity.Page;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.entity.Relation;
import com.fimi.soul.entity.User;
import com.fimi.soul.utils.C3638ah;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.NetUtil;
import com.tencent.open.GameAppOperation;
import com.xiaomi.account.openauth.AuthorizeApi;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.fimi.soul.biz.k.s */
/* loaded from: classes.dex */
public class C2526s implements AbstractC2542o {

    /* renamed from: a */
    private static String f8723a = XiaomiOAuthConstants.OPEN_API_PATH_PROFILE;

    /* renamed from: b */
    private C2571k f8724b;

    public C2526s(Context context) {
        this.f8724b = C2571k.m11651a(context);
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2529b
    /* renamed from: a */
    public PlaneMsg mo11739a(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "getAllUsers"));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            ArrayList m7706a = C3638ah.m7706a(User[].class, jSONObject.getJSONArray("data").toString());
            planeMsg.setCommandCode(string2);
            planeMsg.setData(m7706a);
            planeMsg.setErrorCode(string3);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2542o
    /* renamed from: a */
    public PlaneMsg mo11759a(Relation relation, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "addUserRelation"));
        arrayList.add(new BasicNameValuePair("userID", relation.getUserID()));
        arrayList.add(new BasicNameValuePair("relationID", relation.getRelationID()));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            if (!jSONObject.isNull("data")) {
                planeMsg.setData((Relation) C3638ah.m7703b(Relation.class, jSONObject.getJSONObject("data").toString()));
            }
            planeMsg.setCommandCode(string2);
            planeMsg.setErrorCode(string3);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2542o
    /* renamed from: a */
    public PlaneMsg mo11758a(User user, int i, String str, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "selectNearbyPerson"));
        arrayList.add(new BasicNameValuePair("userID", user.getUserID()));
        arrayList.add(new BasicNameValuePair("sex", user.getSex()));
        arrayList.add(new BasicNameValuePair("curLongitude", user.getCurLongitude()));
        arrayList.add(new BasicNameValuePair("curLatitude", user.getCurLatitude()));
        arrayList.add(new BasicNameValuePair("curPage", i + ""));
        arrayList.add(new BasicNameValuePair("pageSize", "20"));
        arrayList.add(new BasicNameValuePair("distance", str));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            if (!jSONObject.isNull("data")) {
                planeMsg.setData(C3638ah.m7706a(NearPerson[].class, jSONObject.getJSONArray("data").toString()));
            }
            if (!jSONObject.isNull("page")) {
                planeMsg.setPage((Page) C3638ah.m7703b(Page.class, jSONObject.getJSONObject("page").toString()));
            }
            planeMsg.setCommandCode(string2);
            planeMsg.setErrorCode(string3);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2542o
    /* renamed from: a */
    public PlaneMsg mo11757a(User user, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", MiPushClient.COMMAND_REGISTER));
        arrayList.add(new BasicNameValuePair("name", user.getName()));
        arrayList.add(new BasicNameValuePair(GameAppOperation.GAME_SIGNATURE, user.getSignature()));
        arrayList.add(new BasicNameValuePair(DistrictSearchQuery.KEYWORDS_COUNTRY, user.getCountry()));
        arrayList.add(new BasicNameValuePair("nickName", user.getNickName()));
        arrayList.add(new BasicNameValuePair("userIDs", user.getUserIDs()));
        arrayList.add(new BasicNameValuePair("xiaomiID", user.getXiaomiID()));
        arrayList.add(new BasicNameValuePair("device", user.getDevice()));
        arrayList.add(new BasicNameValuePair("sex", user.getSex()));
        arrayList.add(new BasicNameValuePair("phone", user.getPhone()));
        arrayList.add(new BasicNameValuePair("userImgUrl", user.getUserImgUrl()));
        Location m11639d = this.f8724b.m11639d();
        if (m11639d != null && C2582p.m11612a(context).m11606d()) {
            arrayList.add(new BasicNameValuePair("curLongitude", this.f8724b.m11644b() + ""));
            arrayList.add(new BasicNameValuePair("curLatitude", this.f8724b.m11652a() + ""));
        }
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            if (!jSONObject.isNull("data")) {
                User user2 = (User) C3638ah.m7703b(User.class, jSONObject.getJSONObject("data").toString());
                if (m11639d != null && 0.0d != m11639d.getLatitude() && 0.0d != m11639d.getLongitude()) {
                    user2.setCurLongitude(this.f8724b.m11644b() + "");
                    user2.setCurLatitude(this.f8724b.m11652a() + "");
                }
                if (z) {
                    C2353b.m12512a(context, user2);
                }
                planeMsg.setData(user2);
            }
            planeMsg.setCommandCode(string2);
            planeMsg.setErrorCode(string3);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2542o
    /* renamed from: a */
    public PlaneMsg mo11756a(String str, int i, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "selectNickName"));
        arrayList.add(new BasicNameValuePair("nickName", str));
        arrayList.add(new BasicNameValuePair("curPage", i + ""));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            if (!jSONObject.isNull("data")) {
                planeMsg.setData(C3638ah.m7706a(User[].class, jSONObject.getJSONArray("data").toString()));
            }
            if (!jSONObject.isNull("page")) {
                planeMsg.setPage((Page) C3638ah.m7703b(Page.class, jSONObject.getJSONObject("page").toString()));
            }
            planeMsg.setCommandCode(string2);
            planeMsg.setErrorCode(string3);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2529b
    /* renamed from: a */
    public PlaneMsg mo11796a(String str, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "getUserById"));
        arrayList.add(new BasicNameValuePair("userid", str));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            if (!jSONObject.isNull("data")) {
                String jSONObject2 = jSONObject.getJSONObject("data").toString();
                planeMsg.setData((User) C3638ah.m7703b(User.class, jSONObject2));
                m7762b = jSONObject2;
            }
            planeMsg.setCommandCode(string2);
            planeMsg.setData((User) C3638ah.m7703b(User.class, m7762b));
            planeMsg.setErrorCode(string3);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2542o
    /* renamed from: a */
    public PlaneMsg mo11755a(String str, String str2, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "login"));
        arrayList.add(new BasicNameValuePair("name", str));
        arrayList.add(new BasicNameValuePair("pwd", str2));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            if (!jSONObject.isNull("data")) {
                planeMsg.setData((User) C3638ah.m7703b(User.class, jSONObject.getJSONObject("data").toString()));
            }
            planeMsg.setCommandCode(string2);
            planeMsg.setErrorCode(string3);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2542o
    /* renamed from: b */
    public PlaneMsg mo11754b(Context context) {
        JSONObject jSONObject;
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            try {
                jSONObject = new JSONObject(AuthorizeApi.doHttpGet(context, f8723a, Long.parseLong("2882303761517328945"), C2374a.m12422c(context, 0), C2374a.m12424b(context, 0), C2374a.m12426a(context, 0)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (!jSONObject.getString("result").equals("ok")) {
                if (jSONObject.getString("result").equals(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2)) {
                    String string = jSONObject.getString("description");
                    planeMsg.setErrorCode(jSONObject.getString(XiaomiOAuthConstants.EXTRA_CODE_2));
                    planeMsg.setErrorMessage(string);
                    planeMsg.setSuccess(false);
                }
                return planeMsg;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            User user = new User();
            user.setXiaomiID(jSONObject2.getString("userId"));
            user.setName(jSONObject2.getString("miliaoNick"));
            user.setNickName(jSONObject2.getString("miliaoNick"));
            user.setDevice(C3658ar.m7619a(context));
            if (!jSONObject2.isNull("sex") && jSONObject2.getString("sex").equals(context.getResources().getString(C2300R.C2303string.man))) {
                user.setSex("1");
            } else if (!jSONObject2.isNull("sex") && jSONObject2.getString("sex").equals(context.getResources().getString(C2300R.C2303string.woman))) {
                user.setSex("0");
            }
            return mo11757a(user, context);
        } catch (Exception e2) {
            String string2 = context.getString(C2300R.C2303string.login_xiaomi_account_sync_fail);
            planeMsg.setErrorCode("110");
            planeMsg.setErrorMessage(string2);
            planeMsg.setSuccess(false);
            C2353b.m12509a(string2, C2526s.class);
            return planeMsg;
        }
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2542o
    /* renamed from: b */
    public PlaneMsg mo11753b(User user, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "editUserImage"));
        arrayList.add(new BasicNameValuePair("userID", user.getUserID()));
        arrayList.add(new BasicNameValuePair("userImgUrl", user.getUserImgUrl()));
        arrayList.add(new BasicNameValuePair("objectName", user.getObjectName()));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            if (!jSONObject.isNull("data")) {
                User user2 = (User) C3638ah.m7703b(User.class, jSONObject.getJSONObject("data").toString());
                if (z) {
                    C2353b.m12512a(context, user2);
                }
                planeMsg.setData(user2);
            }
            planeMsg.setCommandCode(string2);
            planeMsg.setErrorCode(string3);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2542o
    /* renamed from: b */
    public PlaneMsg mo11752b(String str, int i, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "getUserRelations"));
        arrayList.add(new BasicNameValuePair("userID", str));
        arrayList.add(new BasicNameValuePair("curPage", i + ""));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            if (!jSONObject.isNull("data")) {
                planeMsg.setData(C3638ah.m7706a(Relation[].class, jSONObject.getJSONArray("data").toString()));
            }
            if (!jSONObject.isNull("page")) {
                planeMsg.setPage((Page) C3638ah.m7703b(Page.class, jSONObject.getJSONObject("page").toString()));
            }
            planeMsg.setCommandCode(string2);
            planeMsg.setErrorCode(string3);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2542o
    /* renamed from: b */
    public PlaneMsg mo11751b(String str, String str2, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "editPushRegID"));
        arrayList.add(new BasicNameValuePair("userID", str));
        arrayList.add(new BasicNameValuePair("regID", str2));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        C2353b.m12509a(m7762b, C2526s.class);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            planeMsg.setCommandCode(string2);
            planeMsg.setErrorCode(string3);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2529b
    /* renamed from: b */
    public boolean mo11795b(String str, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "delUserById"));
        arrayList.add(new BasicNameValuePair("userid", str));
        try {
            return new JSONObject(NetUtil.m7762b(C2353b.f7951i, arrayList, context)).getBoolean("success");
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2542o
    /* renamed from: c */
    public PlaneMsg mo11750c(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "getDynamicDNZ"));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            planeMsg.setCommandCode(string2);
            planeMsg.setErrorCode(string3);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
            planeMsg.setData(jSONObject.getJSONArray("data").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2542o
    /* renamed from: c */
    public PlaneMsg mo11749c(User user, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "editUser"));
        arrayList.add(new BasicNameValuePair("userID", user.getUserID()));
        arrayList.add(new BasicNameValuePair("sex", user.getSex()));
        arrayList.add(new BasicNameValuePair(GameAppOperation.GAME_SIGNATURE, user.getSignature()));
        arrayList.add(new BasicNameValuePair("nickName", user.getNickName()));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            if (!jSONObject.isNull("data")) {
                User user2 = (User) C3638ah.m7703b(User.class, jSONObject.getJSONObject("data").toString());
                if (z) {
                    C2353b.m12512a(context, user2);
                }
                planeMsg.setData(user2);
            }
            planeMsg.setCommandCode(string2);
            planeMsg.setErrorCode(string3);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2542o
    /* renamed from: c */
    public PlaneMsg mo11748c(String str, int i, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "getRelationUserList"));
        arrayList.add(new BasicNameValuePair("relationID", str));
        arrayList.add(new BasicNameValuePair("curPage", i + ""));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            if (!jSONObject.isNull("data")) {
                planeMsg.setData(C3638ah.m7706a(Relation[].class, jSONObject.getJSONArray("data").toString()));
            }
            if (!jSONObject.isNull("page")) {
                planeMsg.setPage((Page) C3638ah.m7703b(Page.class, jSONObject.getJSONObject("page").toString()));
            }
            planeMsg.setCommandCode(string2);
            planeMsg.setErrorCode(string3);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2542o
    /* renamed from: c */
    public PlaneMsg mo11747c(String str, Context context) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        ArrayList arrayList = new ArrayList();
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            arrayList.add(new BasicNameValuePair("commandCode", "addPlaneActionList"));
            arrayList.add(new BasicNameValuePair("jsonContent", str));
            if (str != null && (jSONArray = new JSONArray(str)) != null && (jSONObject = jSONArray.getJSONObject(0)) != null && jSONObject.has("userID")) {
                arrayList.add(new BasicNameValuePair("userID", jSONObject.getString("userID")));
            }
            JSONObject jSONObject2 = new JSONObject(NetUtil.m7762b(C2353b.f7951i, arrayList, context));
            String string = jSONObject2.getString("errorMessage");
            String string2 = jSONObject2.getString("commandCode");
            String string3 = jSONObject2.getString("errorCode");
            boolean z = jSONObject2.getBoolean("success");
            Log.i("ljh", "rt : " + jSONObject2.toString());
            planeMsg.setCommandCode(string2);
            planeMsg.setErrorCode(string3);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
            planeMsg.setData(C3638ah.m7703b(FlightTimeInfo.class, jSONObject2.getJSONObject("data").toString()));
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2542o
    /* renamed from: c */
    public PlaneMsg mo11746c(String str, String str2, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "addPlaneAction"));
        arrayList.add(new BasicNameValuePair("planeID", str));
        arrayList.add(new BasicNameValuePair("userID", str2));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            planeMsg.setCommandCode(string2);
            planeMsg.setErrorCode(string3);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
            String jSONObject2 = jSONObject.getJSONObject("data").toString();
            if (jSONObject2 != null) {
                planeMsg.setData(C3638ah.m7703b(FlightTimeInfo.class, jSONObject2));
            } else {
                planeMsg.setSuccess(false);
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2542o
    /* renamed from: d */
    public PlaneMsg mo11745d(User user, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "getIsAttention"));
        arrayList.add(new BasicNameValuePair("userID", user.getUserID()));
        arrayList.add(new BasicNameValuePair("relationID", user.getCountry()));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            planeMsg.setData(jSONObject.getString("data"));
            planeMsg.setCommandCode(string2);
            planeMsg.setErrorCode(string3);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2542o
    /* renamed from: e */
    public PlaneMsg mo11744e(User user, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "clearLocation"));
        arrayList.add(new BasicNameValuePair("userID", user.getUserID()));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        C2353b.m12509a(m7762b, C2526s.class);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            planeMsg.setCommandCode(string2);
            planeMsg.setErrorCode(string3);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2542o
    /* renamed from: f */
    public PlaneMsg mo11743f(User user, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "exitAircraft"));
        arrayList.add(new BasicNameValuePair("userID", user.getUserID()));
        C2353b.m12506d(context);
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        C2353b.m12509a(m7762b, C2526s.class);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            if (!jSONObject.isNull("data")) {
                String jSONObject2 = jSONObject.getJSONObject("data").toString();
                User user2 = (User) C3638ah.m7703b(User.class, jSONObject2);
                planeMsg.setData(user);
                m7762b = jSONObject2;
            }
            User user3 = (User) C3638ah.m7703b(User.class, m7762b);
            planeMsg.setCommandCode(string2);
            planeMsg.setData(user);
            planeMsg.setErrorCode(string3);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2542o
    /* renamed from: g */
    public PlaneMsg mo11742g(User user, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "editPhone"));
        arrayList.add(new BasicNameValuePair("userID", user.getUserID()));
        arrayList.add(new BasicNameValuePair("phone", user.getPhone()));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            planeMsg.setCommandCode(string2);
            planeMsg.setErrorCode(string3);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return planeMsg;
    }
}
