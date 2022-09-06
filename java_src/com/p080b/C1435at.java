package com.p080b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.model.AmapLoc;
import com.p080b.AbstractC1529dk;
import com.p219mi.live.openlivesdk.C4095b;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import org.json.JSONObject;
/* renamed from: com.b.at */
/* loaded from: classes.dex */
public class C1435at {

    /* renamed from: b */
    private String f4971b;

    /* renamed from: c */
    private Context f4972c;

    /* renamed from: d */
    private boolean f4973d = true;

    /* renamed from: e */
    private AbstractC1529dk f4974e = null;

    /* renamed from: f */
    private ServiceConnection f4975f = null;

    /* renamed from: g */
    private ServiceConnection f4976g = null;

    /* renamed from: h */
    private Intent f4977h = new Intent();

    /* renamed from: i */
    private String f4978i = "com.autonavi.minimap";

    /* renamed from: j */
    private String f4979j = "com.amap.api.service.AMapService";

    /* renamed from: k */
    private String f4980k = "com.autonavi.minimap.LBSConnectionService";

    /* renamed from: l */
    private boolean f4981l = false;

    /* renamed from: m */
    private boolean f4982m = false;

    /* renamed from: a */
    AbstractC1438a f4970a = null;

    /* renamed from: n */
    private String f4983n = "invaid type";

    /* renamed from: o */
    private String f4984o = "empty appkey";

    /* renamed from: p */
    private String f4985p = "refused";

    /* renamed from: q */
    private String f4986q = "failed";

    /* renamed from: com.b.at$a */
    /* loaded from: classes.dex */
    public interface AbstractC1438a {
        /* renamed from: a */
        void mo16236a(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1435at(Context context) {
        this.f4971b = null;
        this.f4972c = null;
        this.f4972c = context;
        try {
            this.f4971b = C1544dr.m15602b(C1456bd.m16132a(C1533dm.m15662f(context).getBytes("UTF-8"), "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDCEYwdO3V2ANrhApjqyk7X8FH5AEaWly58kP9IDAhMqwtIbmcJrUK9oO9Afh3KZnOlDtjiowy733YqpLRO7WBvdbW/c4Dz/d3dy/m+6HMqxaak+GQQRHw/VPdKciaZ3eIZp4MWOyIQwiFSQvPTAo/Na8hV4SgBZHB3lGFw0yu+BmG+h32eIE6p4Y8EDCn+G+yzekX+taMrWTQIysledrygZSGPv1ukbdFDnH/xZEI0dCr9pZT+AZQl3o9a2aMyuRrHM0oupXKKiYl69Y8fKh1Tyd752rF6LrR5uOb9aOfXt18hb+3YL5P9rQ+ZRYbyHYFaxzBPA2jLq0KUQ+Dmg7YhAgMBAAECggEAL9pj0lF3BUHwtssNKdf42QZJMD0BKuDcdZrLV9ifs0f54EJY5enzKw8j76MpdV8N5QVkNX4/BZR0bs9uJogh31oHFs5EXeWbb7V8P7bRrxpNnSAijGBWwscQsyqymf48YlcL28949ujnjoEz3jQjgWOyYnrCgpVhphrQbCGmB5TcZnTFvHfozt/0tzuMj5na5lRnkD0kYXgr0x/SRZcPoCybSpc3t/B/9MAAboGaV/QQkTotr7VOuJfaPRjvg8rzyPzavo3evxsjXj7vDXbN4w0cbk/Uqn2JtvPQ8HoysmF2HdYvILZibvJmWH1hA58b4sn5s6AqFRjMOL7rHdD+gQKBgQD+IzoofmZK5tTxgO9sWsG71IUeshQP9fe159jKCehk1RfuIqqbRP0UcxJiw4eNjHs4zU0HeRL3iF5XfUs0FQanO/pp6YL1xgVdfQlDdTdk6KFHJ0sUJapnJn1S2k7IKfRKE1+rkofSXMYUTsgHF1fDp+gxy4yUMY+h9O+JlKVKOwKBgQDDfaDIblaSm+B0lyG//wFPynAeGd0Q8wcMZbQQ/LWMJZhMZ7fyUZ+A6eL/jB53a2tgnaw2rXBpMe1qu8uSpym2plU0fkgLAnVugS5+KRhOkUHyorcbpVZbs5azf7GlTydR5dI1PHF3Bncemoa6IsEvumHWgQbVyTTz/O9mlFafUwKBgQCvDebms8KUf5JY1F6XfaCLWGVl8nZdVCmQFKbA7Lg2lI5KS3jHQWsupeEZRORffU/3nXsc1apZ9YY+r6CYvI77rRXd1KqPzxos/o7d96TzjkZhc9CEjTlmmh2jb5rqx/Ns/xFcZq/GGH+cx3ODZvHeZQ9NFY+9GLJ+dfB2DX0ZtwKBgQC+9/lZ8telbpqMqpqwqRaJ8LMn5JIdHZu0E6IcuhFLr+ogMW3zTKMpVtGGXEXi2M/TWRPDchiO2tQX4Q5T2/KW19QCbJ5KCwPWiGF3owN4tNOciDGh0xkSidRc0xAh8bnyejSoBry8zlcNUVztdkgMLOGonvCjZWPSOTNQnPYluwKBgCV+WVftpTk3l+OfAJTaXEPNYdh7+WQjzxZKjUaDzx80Ts7hRo2U+EQT7FBjQQNqmmDnWtujo5p1YmJC0FT3n1CVa7g901pb3b0RcOziYWAoJi0/+kLyeo6XBhuLeZ7h90S70GGh1o0V/j/9N1jb5DCL4xKkvdYePPTSTku0BM+n"));
        } catch (Throwable th) {
            C1514cx.m15728a(th, "ConnectionServiceManager", "ConnectionServiceManager");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private AmapLoc m16242a(Bundle bundle) {
        byte[] bArr;
        if (bundle == null) {
            return null;
        }
        if (bundle.containsKey("key")) {
            try {
                bArr = C1456bd.m16128b(C1544dr.m15603b(bundle.getString("key")), "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDCEYwdO3V2ANrhApjqyk7X8FH5AEaWly58kP9IDAhMqwtIbmcJrUK9oO9Afh3KZnOlDtjiowy733YqpLRO7WBvdbW/c4Dz/d3dy/m+6HMqxaak+GQQRHw/VPdKciaZ3eIZp4MWOyIQwiFSQvPTAo/Na8hV4SgBZHB3lGFw0yu+BmG+h32eIE6p4Y8EDCn+G+yzekX+taMrWTQIysledrygZSGPv1ukbdFDnH/xZEI0dCr9pZT+AZQl3o9a2aMyuRrHM0oupXKKiYl69Y8fKh1Tyd752rF6LrR5uOb9aOfXt18hb+3YL5P9rQ+ZRYbyHYFaxzBPA2jLq0KUQ+Dmg7YhAgMBAAECggEAL9pj0lF3BUHwtssNKdf42QZJMD0BKuDcdZrLV9ifs0f54EJY5enzKw8j76MpdV8N5QVkNX4/BZR0bs9uJogh31oHFs5EXeWbb7V8P7bRrxpNnSAijGBWwscQsyqymf48YlcL28949ujnjoEz3jQjgWOyYnrCgpVhphrQbCGmB5TcZnTFvHfozt/0tzuMj5na5lRnkD0kYXgr0x/SRZcPoCybSpc3t/B/9MAAboGaV/QQkTotr7VOuJfaPRjvg8rzyPzavo3evxsjXj7vDXbN4w0cbk/Uqn2JtvPQ8HoysmF2HdYvILZibvJmWH1hA58b4sn5s6AqFRjMOL7rHdD+gQKBgQD+IzoofmZK5tTxgO9sWsG71IUeshQP9fe159jKCehk1RfuIqqbRP0UcxJiw4eNjHs4zU0HeRL3iF5XfUs0FQanO/pp6YL1xgVdfQlDdTdk6KFHJ0sUJapnJn1S2k7IKfRKE1+rkofSXMYUTsgHF1fDp+gxy4yUMY+h9O+JlKVKOwKBgQDDfaDIblaSm+B0lyG//wFPynAeGd0Q8wcMZbQQ/LWMJZhMZ7fyUZ+A6eL/jB53a2tgnaw2rXBpMe1qu8uSpym2plU0fkgLAnVugS5+KRhOkUHyorcbpVZbs5azf7GlTydR5dI1PHF3Bncemoa6IsEvumHWgQbVyTTz/O9mlFafUwKBgQCvDebms8KUf5JY1F6XfaCLWGVl8nZdVCmQFKbA7Lg2lI5KS3jHQWsupeEZRORffU/3nXsc1apZ9YY+r6CYvI77rRXd1KqPzxos/o7d96TzjkZhc9CEjTlmmh2jb5rqx/Ns/xFcZq/GGH+cx3ODZvHeZQ9NFY+9GLJ+dfB2DX0ZtwKBgQC+9/lZ8telbpqMqpqwqRaJ8LMn5JIdHZu0E6IcuhFLr+ogMW3zTKMpVtGGXEXi2M/TWRPDchiO2tQX4Q5T2/KW19QCbJ5KCwPWiGF3owN4tNOciDGh0xkSidRc0xAh8bnyejSoBry8zlcNUVztdkgMLOGonvCjZWPSOTNQnPYluwKBgCV+WVftpTk3l+OfAJTaXEPNYdh7+WQjzxZKjUaDzx80Ts7hRo2U+EQT7FBjQQNqmmDnWtujo5p1YmJC0FT3n1CVa7g901pb3b0RcOziYWAoJi0/+kLyeo6XBhuLeZ7h90S70GGh1o0V/j/9N1jb5DCL4xKkvdYePPTSTku0BM+n");
            } catch (Throwable th) {
                C1514cx.m15728a(th, "ConnectionServiceManager", "parseData part");
            }
            if (bundle.containsKey("result")) {
                return null;
            }
            try {
                String str = new String(C1456bd.m16131a(bArr, C1544dr.m15603b(bundle.getString("result"))), "utf-8");
                if (str == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2)) {
                    String string = jSONObject.getString(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2);
                    if (this.f4983n.equals(string)) {
                        this.f4973d = false;
                    }
                    if (this.f4984o.equals(string)) {
                        this.f4973d = false;
                    }
                    if (this.f4985p.equals(string)) {
                        this.f4973d = false;
                    }
                    if (this.f4986q.equals(string)) {
                    }
                    return null;
                }
                AmapLoc amapLoc = new AmapLoc(jSONObject);
                amapLoc.m16531c("lbs");
                amapLoc.m16546a(7);
                if ("WGS84".equals(amapLoc.m16514l()) && C1514cx.m15732a(amapLoc.m16520i(), amapLoc.m16522h())) {
                    DPoint m15684a = C1528dj.m15684a(this.f4972c, amapLoc.m16522h(), amapLoc.m16520i());
                    amapLoc.m16540b(m15684a.getLatitude());
                    amapLoc.m16548a(m15684a.getLongitude());
                }
                return amapLoc;
            } catch (Throwable th2) {
                C1514cx.m15728a(th2, C1435at.class.getName(), "parseData");
                return null;
            }
        }
        bArr = null;
        if (bundle.containsKey("result")) {
        }
    }

    /* renamed from: a */
    public void m16243a() {
        m16238c();
        this.f4972c = null;
        this.f4974e = null;
        this.f4975f = null;
        this.f4976g = null;
        if (this.f4970a != null) {
            this.f4970a.mo16236a(-1);
        }
        this.f4973d = true;
        this.f4981l = false;
        this.f4982m = false;
    }

    /* renamed from: a */
    public void m16241a(final AbstractC1438a abstractC1438a) {
        try {
            this.f4970a = abstractC1438a;
            if (this.f4975f == null) {
                this.f4975f = new ServiceConnection() { // from class: com.b.at.1
                    @Override // android.content.ServiceConnection
                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        C1435at.this.f4974e = AbstractC1529dk.AbstractBinderC1530a.m15674a(iBinder);
                        abstractC1438a.mo16236a(0);
                    }

                    @Override // android.content.ServiceConnection
                    public void onServiceDisconnected(ComponentName componentName) {
                        C1435at.this.f4974e = null;
                    }
                };
            }
            if (this.f4976g != null) {
                return;
            }
            this.f4976g = new ServiceConnection() { // from class: com.b.at.2
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }
            };
        } catch (Throwable th) {
            C1514cx.m15728a(th, "ConnectionServiceManager", "init");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean m16239b() {
        try {
            if (C1473bp.m16033p()) {
                this.f4977h.putExtra(C4095b.f17105f, this.f4971b);
                this.f4977h.setComponent(new ComponentName(this.f4978i, this.f4979j));
                this.f4981l = this.f4972c.bindService(this.f4977h, this.f4975f, 1);
            }
            if (C1473bp.m16032q()) {
                Intent intent = new Intent();
                intent.putExtra(C4095b.f17105f, this.f4971b);
                intent.setComponent(new ComponentName(this.f4978i, this.f4980k));
                this.f4982m = this.f4972c.bindService(intent, this.f4976g, 1);
            }
            if (this.f4981l) {
                if (this.f4982m) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            C1514cx.m15728a(th, "ConnectionServiceManager", "bindService");
            return false;
        }
    }

    /* renamed from: c */
    void m16238c() {
        try {
            if (this.f4981l) {
                this.f4972c.unbindService(this.f4975f);
            }
            if (this.f4982m) {
                this.f4972c.unbindService(this.f4976g);
            }
        } catch (IllegalArgumentException e) {
            C1514cx.m15728a(e, "ConnectionServiceManager", "unbindService");
        } catch (Throwable th) {
            C1514cx.m15728a(th, "ConnectionServiceManager", "unbindService");
        }
        this.f4974e = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public AmapLoc m16237d() {
        try {
            if (!this.f4973d || !this.f4981l) {
                return null;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", "corse");
            bundle.putString(C4095b.f17105f, this.f4971b);
            this.f4974e.mo15673a(bundle);
            if (bundle.size() < 1) {
                return null;
            }
            return m16242a(bundle);
        } catch (RemoteException e) {
            C1514cx.m15728a(e, "ConnectionServiceManager", "sendCommand");
            return null;
        } catch (Throwable th) {
            C1514cx.m15728a(th, "ConnectionServiceManager", "sendCommand");
            return null;
        }
    }
}
