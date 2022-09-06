package com.amap.api.mapcore.util;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.fimi.soul.media.player.IMediaPlayer;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.amap.api.mapcore.util.et */
/* loaded from: classes.dex */
public class C0969et {

    /* renamed from: a */
    private static String[] f3029a = {"com.amap.api.trace", "com.amap.api.trace.core"};

    /* renamed from: a */
    public static int m18189a(List<LatLng> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        int i = 0;
        int i2 = 0;
        while (i < list.size() - 1) {
            LatLng latLng = list.get(i);
            LatLng latLng2 = list.get(i + 1);
            if (latLng == null || latLng2 == null) {
                return i2;
            }
            i++;
            i2 = (int) (AMapUtils.calculateLineDistance(latLng, latLng2) + i2);
        }
        return i2;
    }

    /* renamed from: a */
    public static void m18190a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status") || !jSONObject.has("infocode")) {
                return;
            }
            String string = jSONObject.getString("status");
            int i = jSONObject.getInt("infocode");
            if (string.equals("1") || !string.equals("0")) {
                return;
            }
            switch (i) {
                case IMediaPlayer.MEDIA_INFO_VIDEO_ROTATION_CHANGED /* 10001 */:
                    throw new C0966eq("用户key不正确或过期");
                case 10002:
                    throw new C0966eq("请求服务不存在");
                case 10003:
                    throw new C0966eq("访问已超出日访问量");
                case 10004:
                    throw new C0966eq("用户访问过于频繁");
                case 10005:
                    throw new C0966eq("用户IP无效");
                case 10006:
                    throw new C0966eq("用户域名无效");
                case 10007:
                    throw new C0966eq("用户签名未通过");
                case 10008:
                    throw new C0966eq("用户MD5安全码未通过");
                case 10009:
                    throw new C0966eq("请求key与绑定平台不符");
                case 10010:
                    throw new C0966eq("IP访问超限");
                case 10011:
                    throw new C0966eq("服务不支持https请求");
                case 10012:
                    throw new C0966eq("权限不足，服务请求被拒绝");
                case 10013:
                    throw new C0966eq("开发者删除了key，key被删除后无法正常使用");
                case 20000:
                    throw new C0966eq("请求参数非法");
                case 20001:
                    throw new C0966eq("缺少必填参数");
                case 20002:
                    throw new C0966eq("请求协议非法");
                case 20003:
                    throw new C0966eq("其他未知错误");
                case 30000:
                    throw new C0966eq("请求服务响应错误");
                case 30001:
                    throw new C0966eq("引擎返回数据异常");
                case 30002:
                    throw new C0966eq("服务端请求链接超时");
                case 30003:
                    throw new C0966eq("读取服务结果超时");
                default:
                    throw new C0966eq(jSONObject.getString("info"));
            }
        } catch (JSONException e) {
            throw new C0966eq("协议解析错误 - ProtocolException");
        }
    }
}
