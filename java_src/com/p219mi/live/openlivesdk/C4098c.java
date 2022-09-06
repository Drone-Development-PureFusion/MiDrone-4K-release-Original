package com.p219mi.live.openlivesdk;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import com.p219mi.live.openlivesdk.p220a.AbstractC4094a;
/* renamed from: com.mi.live.openlivesdk.c */
/* loaded from: classes.dex */
public class C4098c {

    /* renamed from: a */
    static final String f17114a = "liveopen://startstream?appid=%s&appkey=%s&packagename=%s&playui=%s";

    /* renamed from: b */
    static final String f17115b = "liveopen://endstream?appid=%s&appkey=%s&packagename=%s";

    /* renamed from: c */
    private String f17116c;

    /* renamed from: d */
    private String f17117d;

    /* renamed from: e */
    private int f17118e;

    /* renamed from: f */
    private AbstractC4094a f17119f;

    /* renamed from: g */
    private Application f17120g;

    /* renamed from: h */
    private BroadcastReceiver f17121h = new BroadcastReceiver() { // from class: com.mi.live.openlivesdk.c.1
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z;
            if (intent != null) {
                String action = intent.getAction();
                switch (action.hashCode()) {
                    case -2077898362:
                        if (action.equals(C4095b.f17101b)) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 1390740215:
                        if (action.equals(C4095b.f17102c)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    default:
                        z = true;
                        break;
                }
                switch (z) {
                    case false:
                        String stringExtra = intent.getStringExtra(C4095b.f17103d);
                        if (C4098c.this.f17119f == null) {
                            return;
                        }
                        if (TextUtils.isEmpty(stringExtra)) {
                            C4098c.this.f17119f.mo6212a(-1, "");
                            return;
                        } else {
                            C4098c.this.f17119f.mo6211a(stringExtra);
                            return;
                        }
                    case true:
                        if (C4098c.this.f17119f == null) {
                            return;
                        }
                        C4098c.this.f17119f.mo6213a();
                        return;
                    default:
                        return;
                }
            }
        }
    };

    public C4098c(String str, String str2, int i, AbstractC4094a abstractC4094a, Application application) {
        this.f17118e = 0;
        this.f17116c = str;
        this.f17117d = str2;
        this.f17119f = abstractC4094a;
        this.f17120g = application;
        this.f17118e = i;
        m6206b();
    }

    /* renamed from: b */
    private void m6206b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(C4095b.f17101b);
        intentFilter.addAction(C4095b.f17102c);
        if (this.f17120g != null) {
            this.f17120g.registerReceiver(this.f17121h, intentFilter);
        }
    }

    /* renamed from: c */
    private void m6204c() {
        if (this.f17120g != null) {
            this.f17120g.unregisterReceiver(this.f17121h);
        }
    }

    /* renamed from: a */
    public void m6209a() {
        this.f17119f = null;
        m6204c();
        this.f17120g = null;
    }

    /* renamed from: a */
    public void m6208a(Context context) {
        if (context != null) {
            int m6203a = C4100d.m6203a(context);
            if (m6203a == 1) {
                Intent intent = new Intent();
                intent.setAction(C4095b.f17100a);
                intent.setData(Uri.parse(String.format(f17114a, this.f17116c, this.f17117d, context.getPackageName(), Integer.valueOf(this.f17118e))));
                context.startActivity(intent);
            } else if (m6203a == -2) {
                this.f17119f.mo6212a(-2, "MiLive App not install");
            } else if (m6203a != -3) {
            } else {
                this.f17119f.mo6212a(-3, "MiLive App version is too low");
            }
        }
    }

    /* renamed from: b */
    public void m6205b(Context context) {
        if (context != null) {
            int m6203a = C4100d.m6203a(context);
            if (m6203a == 1) {
                Intent intent = new Intent();
                intent.setAction(C4095b.f17100a);
                intent.setData(Uri.parse(String.format(f17115b, this.f17116c, this.f17117d, context.getPackageName())));
                context.startActivity(intent);
            } else if (m6203a == -2) {
                this.f17119f.mo6210b(-2, "MiLive App not install");
            } else if (m6203a != -3) {
            } else {
                this.f17119f.mo6210b(-3, "MiLive App version is too low");
            }
        }
    }
}
