package com.amap.api.mapcore.util;
/* renamed from: com.amap.api.mapcore.util.ex */
/* loaded from: classes.dex */
public class C0975ex extends Exception {

    /* renamed from: a */
    private String f3043a;

    /* renamed from: b */
    private int f3044b = -1;

    public C0975ex(String str) {
        super(str);
        this.f3043a = "未知的错误";
        this.f3043a = str;
        m18174a(str);
    }

    /* renamed from: a */
    private void m18174a(String str) {
        if ("IO 操作异常 - IOException".equals(str)) {
            this.f3044b = 21;
        } else if ("socket 连接异常 - SocketException".equals(str)) {
            this.f3044b = 22;
        } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f3044b = 23;
        } else if ("无效的参数 - IllegalArgumentException".equals(str)) {
            this.f3044b = 24;
        } else if ("空指针异常 - NullPointException".equals(str)) {
            this.f3044b = 25;
        } else if ("url异常 - MalformedURLException".equals(str)) {
            this.f3044b = 26;
        } else if ("未知主机 - UnKnowHostException".equals(str)) {
            this.f3044b = 27;
        } else if ("服务器连接失败 - UnknownServiceException".equals(str)) {
            this.f3044b = 28;
        } else if ("协议解析错误 - ProtocolException".equals(str)) {
            this.f3044b = 29;
        } else if ("http连接失败 - ConnectionException".equals(str)) {
            this.f3044b = 30;
        } else if ("未知的错误".equals(str)) {
            this.f3044b = 31;
        } else if ("key鉴权失败".equals(str)) {
            this.f3044b = 32;
        } else if ("requeust is null".equals(str)) {
            this.f3044b = 1;
        } else if ("request url is empty".equals(str)) {
            this.f3044b = 2;
        } else if ("response is null".equals(str)) {
            this.f3044b = 3;
        } else if ("thread pool has exception".equals(str)) {
            this.f3044b = 4;
        } else if ("sdk name is invalid".equals(str)) {
            this.f3044b = 5;
        } else if ("sdk info is null".equals(str)) {
            this.f3044b = 6;
        } else if ("sdk packages is null".equals(str)) {
            this.f3044b = 7;
        } else if ("线程池为空".equals(str)) {
            this.f3044b = 8;
        } else if ("获取对象错误".equals(str)) {
            this.f3044b = 101;
        } else {
            this.f3044b = -1;
        }
    }

    /* renamed from: a */
    public String m18175a() {
        return this.f3043a;
    }

    /* renamed from: b */
    public int m18173b() {
        return this.f3044b;
    }
}
