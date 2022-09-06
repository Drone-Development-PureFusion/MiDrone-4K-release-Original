package com.fimi.soul.biz.p182k;

import android.content.Context;
import com.amap.api.services.district.DistrictSearchQuery;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p183l.AbstractC2543p;
import com.fimi.soul.entity.CityInfo;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.entity.WeatherInfo;
import com.fimi.soul.utils.C3638ah;
import com.fimi.soul.utils.NetUtil;
import com.tencent.open.SocialConstants;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.fimi.soul.biz.k.t */
/* loaded from: classes.dex */
public class C2527t implements AbstractC2543p {
    public C2527t(Context context) {
    }

    /* renamed from: a */
    private CityInfo m11799a(Context context) {
        return null;
    }

    /* renamed from: b */
    private PlaneMsg m11798b(CityInfo cityInfo, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "getweatherIDbyCity"));
        arrayList.add(new BasicNameValuePair(DistrictSearchQuery.KEYWORDS_CITY, cityInfo.getCity()));
        arrayList.add(new BasicNameValuePair("town", cityInfo.getTown()));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            if (!jSONObject.isNull("data")) {
                planeMsg.setData((CityInfo) C3638ah.m7703b(CityInfo.class, jSONObject.getJSONObject("data").toString()));
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

    @Override // com.fimi.soul.biz.p183l.AbstractC2543p
    /* renamed from: a */
    public PlaneMsg mo11741a(Context context, CityInfo cityInfo) {
        if (cityInfo != null) {
            return mo11740a(cityInfo, context);
        }
        return null;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2543p
    /* renamed from: a */
    public PlaneMsg mo11740a(CityInfo cityInfo, Context context) {
        PlaneMsg planeMsg = new PlaneMsg();
        PlaneMsg m11798b = m11798b(cityInfo, context);
        if (m11798b.isSuccess()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair(SocialConstants.PARAM_SOURCE, "fimi"));
            arrayList.add(new BasicNameValuePair("cityId", ((CityInfo) m11798b.getData()).getWeatherID()));
            String m7766a = NetUtil.m7766a("http://weatherapi.market.xiaomi.com/wtr-v2/weather", arrayList, context, true);
            if (m7766a != null) {
                try {
                    if (!"".equalsIgnoreCase(m7766a)) {
                        JSONObject jSONObject = new JSONObject(m7766a);
                        WeatherInfo weatherInfo = null;
                        if (!jSONObject.isNull("forecast")) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("forecast");
                            weatherInfo = new WeatherInfo();
                            weatherInfo.setCity(cityInfo.getCity());
                            weatherInfo.setWD(jSONObject2.getString("fx1"));
                            weatherInfo.setWS(jSONObject2.getString("fl1"));
                            weatherInfo.setWeather(jSONObject2.getString("weather1"));
                            weatherInfo.setTemp(jSONObject2.getString("temp1"));
                            weatherInfo.setIndex_tr(jSONObject2.getString("index_ls"));
                        }
                        planeMsg.setData(weatherInfo);
                        planeMsg.setSuccess(true);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            planeMsg.setSuccess(false);
            planeMsg.setErrorMessage("天气无法获取");
        } else {
            planeMsg.setSuccess(false);
        }
        return planeMsg;
    }
}
