package com.amap.api.mapcore.util;

import com.autonavi.amap.mapcore.ERROR_CODE;
import com.fimi.soul.service.CameraSocketService;
import com.hoho.android.usbserial.driver.UsbId;
/* renamed from: com.amap.api.mapcore.util.eq */
/* loaded from: classes.dex */
public class C0966eq extends Exception {

    /* renamed from: a */
    private String f3021a;

    /* renamed from: b */
    private int f3022b;

    public C0966eq() {
        this.f3021a = "";
        this.f3022b = 1000;
    }

    public C0966eq(String str) {
        super(str);
        this.f3021a = "";
        this.f3022b = 1000;
        this.f3021a = str;
        m18198a(str);
    }

    /* renamed from: a */
    private void m18198a(String str) {
        if ("用户签名未通过".equals(str)) {
            this.f3022b = 1001;
        } else if ("用户key不正确或过期".equals(str)) {
            this.f3022b = 1002;
        } else if ("请求服务不存在".equals(str)) {
            this.f3022b = UsbId.VENDOR_ATMEL;
        } else if ("访问已超出日访问量".equals(str)) {
            this.f3022b = ERROR_CODE.CANCEL_ERROR;
        } else if ("用户访问过于频繁".equals(str)) {
            this.f3022b = 1005;
        } else if ("用户IP无效".equals(str)) {
            this.f3022b = 1006;
        } else if ("用户域名无效".equals(str)) {
            this.f3022b = 1007;
        } else if ("用户MD5安全码未通过".equals(str)) {
            this.f3022b = 1008;
        } else if ("请求key与绑定平台不符".equals(str)) {
            this.f3022b = 1009;
        } else if ("IP访问超限".equals(str)) {
            this.f3022b = 1010;
        } else if ("服务不支持https请求".equals(str)) {
            this.f3022b = 1011;
        } else if ("权限不足，服务请求被拒绝".equals(str)) {
            this.f3022b = 1012;
        } else if ("开发者删除了key，key被删除后无法正常使用".equals(str)) {
            this.f3022b = 1013;
        } else if ("请求服务响应错误".equals(str)) {
            this.f3022b = 1100;
        } else if ("引擎返回数据异常".equals(str)) {
            this.f3022b = 1101;
        } else if ("服务端请求链接超时".equals(str)) {
            this.f3022b = 1102;
        } else if ("读取服务结果超时".equals(str)) {
            this.f3022b = 1103;
        } else if ("请求参数非法".equals(str)) {
            this.f3022b = CameraSocketService.f14616b;
        } else if ("缺少必填参数".equals(str)) {
            this.f3022b = 1201;
        } else if ("请求协议非法".equals(str)) {
            this.f3022b = 1202;
        } else if ("其他未知错误".equals(str)) {
            this.f3022b = 1203;
        } else if ("协议解析错误 - ProtocolException".equals(str)) {
            this.f3022b = 1801;
        } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f3022b = 1802;
        } else if ("url异常 - MalformedURLException".equals(str)) {
            this.f3022b = 1803;
        } else if ("未知主机 - UnKnowHostException".equals(str)) {
            this.f3022b = 1804;
        } else if ("未知错误".equals(str)) {
            this.f3022b = 1900;
        } else if ("无效的参数 - IllegalArgumentException".equals(str)) {
            this.f3022b = 1901;
        } else if ("http或socket连接失败 - ConnectionException".equals(str)) {
            this.f3022b = 1806;
        } else if ("IO 操作异常 - IOException".equals(str)) {
            this.f3022b = 1902;
        } else if ("空指针异常 - NullPointException".equals(str)) {
            this.f3022b = 1903;
        } else {
            this.f3022b = 1800;
        }
    }

    /* renamed from: a */
    public String m18199a() {
        return this.f3021a;
    }
}
