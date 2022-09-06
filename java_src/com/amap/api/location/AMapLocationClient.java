package com.amap.api.location;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.fence.Fence;
import com.p080b.C1390a;
import com.p080b.C1514cx;
import com.p080b.C1580z;
/* loaded from: classes.dex */
public class AMapLocationClient implements LocationManagerBase {

    /* renamed from: a */
    HandlerC0758a f1983a;

    /* renamed from: b */
    Context f1984b;

    /* renamed from: c */
    LocationManagerBase f1985c;

    /* renamed from: d */
    AMapLocationClientOption f1986d;

    /* renamed from: e */
    AMapLocationListener f1987e;

    /* renamed from: f */
    AMapLocationClient f1988f;

    /* renamed from: com.amap.api.location.AMapLocationClient$a */
    /* loaded from: classes.dex */
    static class HandlerC0758a extends Handler {

        /* renamed from: a */
        AMapLocationClient f1989a;

        public HandlerC0758a(AMapLocationClient aMapLocationClient) {
            this.f1989a = null;
            this.f1989a = aMapLocationClient;
        }

        public HandlerC0758a(AMapLocationClient aMapLocationClient, Looper looper) {
            super(looper);
            this.f1989a = null;
            this.f1989a = aMapLocationClient;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                super.handleMessage(message);
                switch (message.arg1) {
                    case 1:
                        this.f1989a.f1986d = (AMapLocationClientOption) message.obj;
                        this.f1989a.f1985c.setLocationOption(this.f1989a.f1986d);
                        break;
                    case 2:
                        this.f1989a.f1987e = (AMapLocationListener) message.obj;
                        this.f1989a.f1985c.setLocationListener(this.f1989a.f1987e);
                        break;
                    case 3:
                        this.f1989a.f1985c.startLocation();
                        break;
                    case 4:
                        this.f1989a.f1985c.stopLocation();
                        break;
                    case 5:
                        this.f1989a.f1987e = (AMapLocationListener) message.obj;
                        this.f1989a.f1985c.unRegisterLocationListener(this.f1989a.f1987e);
                        break;
                    case 6:
                        Fence fence = (Fence) message.obj;
                        this.f1989a.f1985c.addGeoFenceAlert(fence.f1954b, fence.f1956d, fence.f1955c, fence.f1957e, fence.f1958f, fence.f1953a);
                        break;
                    case 7:
                        this.f1989a.f1985c.removeGeoFenceAlert((PendingIntent) message.obj);
                        break;
                    case 8:
                        this.f1989a.f1985c.startAssistantLocation();
                        break;
                    case 9:
                        this.f1989a.f1985c.stopAssistantLocation();
                        break;
                    case 10:
                        Fence fence2 = (Fence) message.obj;
                        this.f1989a.f1985c.removeGeoFenceAlert(fence2.f1953a, fence2.f1954b);
                        break;
                    case 11:
                        this.f1989a.f1985c.onDestroy();
                        this.f1989a.f1985c = null;
                        this.f1989a = null;
                        break;
                }
            } catch (Throwable th) {
                C1514cx.m15728a(th, "AMapLocationClient", "handleMessage end");
            }
        }
    }

    public AMapLocationClient(Context context) {
        try {
            if (context == null) {
                throw new IllegalArgumentException("Context参数不能为null");
            }
            this.f1984b = context.getApplicationContext();
            this.f1988f = new AMapLocationClient(this.f1984b, null, true);
            if (Looper.myLooper() == null) {
                this.f1983a = new HandlerC0758a(this.f1988f, this.f1984b.getMainLooper());
            } else {
                this.f1983a = new HandlerC0758a(this.f1988f);
            }
        } catch (Throwable th) {
            C1514cx.m15728a(th, "AMapLocationClient", "AMapLocationClient 1");
        }
    }

    public AMapLocationClient(Context context, Intent intent) {
        try {
            if (context == null) {
                throw new IllegalArgumentException("Context参数不能为null");
            }
            this.f1984b = context.getApplicationContext();
            this.f1988f = new AMapLocationClient(this.f1984b, intent, true);
            if (Looper.myLooper() == null) {
                this.f1983a = new HandlerC0758a(this.f1988f, this.f1984b.getMainLooper());
            } else {
                this.f1983a = new HandlerC0758a(this.f1988f);
            }
        } catch (Throwable th) {
            C1514cx.m15728a(th, "AMapLocationClient", "AMapLocationClient 2");
        }
    }

    private AMapLocationClient(Context context, Intent intent, boolean z) {
        try {
            this.f1984b = context;
            this.f1985c = (LocationManagerBase) C1580z.m15422a(context, C1514cx.m15729a("2.4.1"), "com.amap.api.location.LocationManagerWrapper", C1390a.class, new Class[]{Context.class, Intent.class}, new Object[]{context, intent});
        } catch (Throwable th) {
            this.f1985c = new C1390a(context, intent);
            C1514cx.m15728a(th, "AMapLocationClient", "AMapLocationClient 3");
        }
    }

    public static void setApiKey(String str) {
        try {
            C1514cx.f5406a = str;
        } catch (Throwable th) {
            C1514cx.m15728a(th, "AMapLocationClient", "setApiKey");
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void addGeoFenceAlert(String str, double d, double d2, float f, long j, PendingIntent pendingIntent) {
        try {
            Message obtain = Message.obtain();
            Fence fence = new Fence();
            fence.f1954b = str;
            fence.f1956d = d;
            fence.f1955c = d2;
            fence.f1957e = f;
            fence.f1953a = pendingIntent;
            fence.f1958f = j;
            obtain.obj = fence;
            obtain.arg1 = 6;
            this.f1983a.sendMessage(obtain);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "AMapLocationClient", "addGeoFenceAlert");
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public AMapLocation getLastKnownLocation() {
        try {
            if (this.f1988f != null && this.f1988f.f1985c != null) {
                return this.f1988f.f1985c.getLastKnownLocation();
            }
        } catch (Throwable th) {
            C1514cx.m15728a(th, "AMapLocationClient", "getLastKnownLocation");
        }
        return null;
    }

    @Override // com.amap.api.location.LocationManagerBase
    public String getVersion() {
        try {
            if (this.f1988f != null) {
                return this.f1988f.f1985c.getVersion();
            }
        } catch (Throwable th) {
            C1514cx.m15728a(th, "AMapLocationClient", "getVersion");
        }
        return null;
    }

    @Override // com.amap.api.location.LocationManagerBase
    public boolean isStarted() {
        try {
            if (this.f1988f != null) {
                return this.f1988f.f1985c.isStarted();
            }
        } catch (Throwable th) {
            C1514cx.m15728a(th, "AMapLocationClient", "isStarted");
        }
        return false;
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void onDestroy() {
        try {
            Message obtain = Message.obtain();
            obtain.arg1 = 11;
            this.f1983a.sendMessage(obtain);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "AMapLocationClient", "onDestroy");
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void removeGeoFenceAlert(PendingIntent pendingIntent) {
        try {
            Message obtain = Message.obtain();
            obtain.obj = pendingIntent;
            obtain.arg1 = 7;
            this.f1983a.sendMessage(obtain);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "AMapLocationClient", "removeGeoFenceAlert 2");
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void removeGeoFenceAlert(PendingIntent pendingIntent, String str) {
        try {
            Message obtain = Message.obtain();
            Fence fence = new Fence();
            fence.f1954b = str;
            fence.f1953a = pendingIntent;
            obtain.obj = fence;
            obtain.arg1 = 10;
            this.f1983a.sendMessage(obtain);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "AMapLocationClient", "removeGeoFenceAlert 1");
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void setLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            if (aMapLocationListener == null) {
                throw new IllegalArgumentException("listener参数不能为null");
            }
            Message obtain = Message.obtain();
            obtain.arg1 = 2;
            obtain.obj = aMapLocationListener;
            this.f1983a.sendMessage(obtain);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "AMapLocationClient", "setLocationListener");
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void setLocationOption(AMapLocationClientOption aMapLocationClientOption) {
        try {
            if (aMapLocationClientOption == null) {
                throw new IllegalArgumentException("LocationManagerOption参数不能为null");
            }
            Message obtain = Message.obtain();
            obtain.arg1 = 1;
            obtain.obj = aMapLocationClientOption;
            this.f1983a.sendMessage(obtain);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "AMapLocationClient", "setLocationOption");
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void startAssistantLocation() {
        try {
            Message obtain = Message.obtain();
            obtain.arg1 = 8;
            this.f1983a.sendMessage(obtain);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "AMapLocationClient", "startAssistantLocation");
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void startLocation() {
        try {
            Message obtain = Message.obtain();
            obtain.arg1 = 3;
            this.f1983a.sendMessage(obtain);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "AMapLocationClient", "startLocation");
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void stopAssistantLocation() {
        try {
            Message obtain = Message.obtain();
            obtain.arg1 = 9;
            this.f1983a.sendMessage(obtain);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "AMapLocationClient", "stopAssistantLocation");
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void stopLocation() {
        try {
            Message obtain = Message.obtain();
            obtain.arg1 = 4;
            this.f1983a.sendMessage(obtain);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "AMapLocationClient", "stopLocation");
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void unRegisterLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            Message obtain = Message.obtain();
            obtain.arg1 = 5;
            obtain.obj = aMapLocationListener;
            this.f1983a.sendMessage(obtain);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "AMapLocationClient", "unRegisterLocationListener");
        }
    }
}
