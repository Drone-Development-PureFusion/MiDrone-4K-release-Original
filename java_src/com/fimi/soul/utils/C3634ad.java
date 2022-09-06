package com.fimi.soul.utils;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
/* renamed from: com.fimi.soul.utils.ad */
/* loaded from: classes.dex */
public class C3634ad {

    /* renamed from: a */
    private String f14789a;

    /* renamed from: b */
    private HttpPost f14790b;

    /* renamed from: c */
    private HttpResponse f14791c;

    /* renamed from: d */
    private HttpParams f14792d = new BasicHttpParams();

    /* renamed from: e */
    private HttpClient f14793e = new DefaultHttpClient(this.f14792d);

    public C3634ad(String str, Context context) {
        this.f14789a = str;
        HttpConnectionParams.setConnectionTimeout(this.f14792d, 15000);
        HttpConnectionParams.setSoTimeout(this.f14792d, 15000);
    }

    /* renamed from: a */
    public InputStream m7718a(List<NameValuePair> list) {
        try {
            this.f14790b = new HttpPost(this.f14789a);
            if (list != null) {
                this.f14790b.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
            }
            this.f14791c = this.f14793e.execute(this.f14790b);
            if (200 != this.f14791c.getStatusLine().getStatusCode()) {
                return null;
            }
            return this.f14791c.getEntity().getContent();
        } catch (IOException e) {
            return null;
        }
    }

    /* renamed from: b */
    public String m7717b(List<NameValuePair> list) {
        try {
            this.f14790b = new HttpPost(this.f14789a);
            if (list != null) {
                this.f14790b.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
            }
            this.f14791c = this.f14793e.execute(this.f14790b);
            if (200 != this.f14791c.getStatusLine().getStatusCode()) {
                return null;
            }
            String entityUtils = EntityUtils.toString(this.f14791c.getEntity());
            System.out.println("ȡ�÷���ֵ" + entityUtils);
            return entityUtils;
        } catch (IOException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    /* renamed from: c */
    public int m7716c(List<NameValuePair> list) {
        try {
            this.f14790b = new HttpPost(this.f14789a);
            if (list != null) {
                this.f14790b.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
            }
            this.f14791c = this.f14793e.execute(this.f14790b);
            if (200 != this.f14791c.getStatusLine().getStatusCode()) {
                return -1;
            }
            return Integer.parseInt(EntityUtils.toString(this.f14791c.getEntity()));
        } catch (IOException e) {
            return -1;
        }
    }

    /* renamed from: d */
    public int m7715d(List<NameValuePair> list) {
        try {
            this.f14790b = new HttpPost(this.f14789a);
            if (list != null) {
                this.f14790b.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
            }
            this.f14791c = this.f14793e.execute(this.f14790b);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
