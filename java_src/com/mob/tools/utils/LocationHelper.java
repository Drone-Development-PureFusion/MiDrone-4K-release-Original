package com.mob.tools.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.mob.tools.MobHandlerThread;
/* loaded from: classes.dex */
public class LocationHelper implements LocationListener, Handler.Callback {
    private boolean gpsRequesting;
    private int gpsTimeoutSec;
    private Handler handler;

    /* renamed from: lm */
    private LocationManager f17340lm;
    private boolean networkRequesting;
    private int networkTimeoutSec;
    private Location res;

    public LocationHelper() {
        MobHandlerThread mobHandlerThread = new MobHandlerThread();
        mobHandlerThread.start();
        this.handler = new Handler(mobHandlerThread.getLooper(), this);
    }

    private void onGPSTimeout() {
        boolean z = false;
        this.f17340lm.removeUpdates(this);
        this.gpsRequesting = false;
        if (this.networkTimeoutSec != 0) {
            z = true;
        }
        if (!z || !this.f17340lm.isProviderEnabled(C3947a.f16908s)) {
            synchronized (this) {
                notifyAll();
            }
            this.handler.getLooper().quit();
            return;
        }
        this.networkRequesting = true;
        this.f17340lm.requestLocationUpdates(C3947a.f16908s, 1000L, 0.0f, this);
        if (this.networkTimeoutSec <= 0) {
            return;
        }
        this.handler.sendEmptyMessageDelayed(1, this.networkTimeoutSec * 1000);
    }

    private void onRequest() {
        boolean z = false;
        boolean z2 = this.gpsTimeoutSec != 0;
        if (this.networkTimeoutSec != 0) {
            z = true;
        }
        if (z2 && this.f17340lm.isProviderEnabled(GeocodeSearch.GPS)) {
            this.gpsRequesting = true;
            this.f17340lm.requestLocationUpdates(GeocodeSearch.GPS, 1000L, 0.0f, this);
            if (this.gpsTimeoutSec <= 0) {
                return;
            }
            this.handler.sendEmptyMessageDelayed(1, this.gpsTimeoutSec * 1000);
        } else if (!z || !this.f17340lm.isProviderEnabled(C3947a.f16908s)) {
            synchronized (this) {
                notifyAll();
            }
            this.handler.getLooper().quit();
        } else {
            this.networkRequesting = true;
            this.f17340lm.requestLocationUpdates(C3947a.f16908s, 1000L, 0.0f, this);
            if (this.networkTimeoutSec <= 0) {
                return;
            }
            this.handler.sendEmptyMessageDelayed(1, this.networkTimeoutSec * 1000);
        }
    }

    public Location getLocation(Context context) {
        return getLocation(context, 0);
    }

    public Location getLocation(Context context, int i) {
        return getLocation(context, i, 0);
    }

    public Location getLocation(Context context, int i, int i2) {
        return getLocation(context, i, i2, true);
    }

    public Location getLocation(Context context, int i, int i2, boolean z) {
        this.gpsTimeoutSec = i;
        this.networkTimeoutSec = i2;
        this.f17340lm = (LocationManager) context.getSystemService("location");
        if (this.f17340lm == null) {
            return null;
        }
        synchronized (this) {
            this.handler.sendEmptyMessageDelayed(0, 50L);
            wait();
        }
        if (this.res == null && z) {
            boolean z2 = i != 0;
            boolean z3 = i2 != 0;
            if (z2 && this.f17340lm.isProviderEnabled(GeocodeSearch.GPS)) {
                this.res = this.f17340lm.getLastKnownLocation(GeocodeSearch.GPS);
            } else if (z3 && this.f17340lm.isProviderEnabled(C3947a.f16908s)) {
                this.res = this.f17340lm.getLastKnownLocation(C3947a.f16908s);
            }
        }
        return this.res;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            onRequest();
            return false;
        } else if (this.gpsRequesting) {
            onGPSTimeout();
            return false;
        } else if (!this.networkRequesting) {
            return false;
        } else {
            this.f17340lm.removeUpdates(this);
            synchronized (this) {
                notifyAll();
            }
            this.handler.getLooper().quit();
            return false;
        }
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        synchronized (this) {
            this.f17340lm.removeUpdates(this);
            this.res = location;
            notifyAll();
        }
        this.handler.getLooper().quit();
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
