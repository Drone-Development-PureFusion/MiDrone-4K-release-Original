package com.tencent.p227mm.sdk.platformtools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
/* renamed from: com.tencent.mm.sdk.platformtools.SensorController */
/* loaded from: classes.dex */
public class SensorController extends BroadcastReceiver implements SensorEventListener {

    /* renamed from: aR */
    private static float f17852aR = 4.2949673E9f;

    /* renamed from: aU */
    private static float f17853aU = 0.5f;

    /* renamed from: aS */
    private SensorManager f17854aS;

    /* renamed from: aT */
    private float f17855aT;

    /* renamed from: aV */
    private SensorEventCallBack f17856aV;

    /* renamed from: aW */
    private Sensor f17857aW;

    /* renamed from: aX */
    private final boolean f17858aX;

    /* renamed from: aY */
    private boolean f17859aY = false;

    /* renamed from: aZ */
    private boolean f17860aZ = false;

    /* renamed from: com.tencent.mm.sdk.platformtools.SensorController$SensorEventCallBack */
    /* loaded from: classes.dex */
    public interface SensorEventCallBack {
        void onSensorEvent(boolean z);
    }

    public SensorController(Context context) {
        this.f17854aS = (SensorManager) context.getSystemService("sensor");
        this.f17857aW = this.f17854aS.getDefaultSensor(8);
        this.f17858aX = this.f17857aW != null;
        this.f17855aT = f17853aU + 1.0f;
    }

    public boolean isSensorEnable() {
        return this.f17858aX;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
            int intExtra = intent.getIntExtra(XiaomiOAuthConstants.EXTRA_STATE_2, 0);
            if (intExtra == 1) {
                this.f17859aY = true;
            }
            if (intExtra != 0) {
                return;
            }
            this.f17859aY = false;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.f17859aY) {
            return;
        }
        float f = sensorEvent.values[0];
        switch (sensorEvent.sensor.getType()) {
            case 8:
                if (f < f17852aR) {
                    f17852aR = f;
                    f17853aU = 0.5f + f;
                }
                if (this.f17855aT < f17853aU || f >= f17853aU) {
                    if (this.f17855aT <= f17853aU && f > f17853aU && this.f17856aV != null) {
                        Log.m5641v("MicroMsg.SensorController", "sensor event true");
                        this.f17856aV.onSensorEvent(true);
                    }
                } else if (this.f17856aV != null) {
                    Log.m5641v("MicroMsg.SensorController", "sensor event false");
                    this.f17856aV.onSensorEvent(false);
                }
                this.f17855aT = f;
                return;
            default:
                return;
        }
    }

    public void removeSensorCallBack() {
        Log.m5641v("MicroMsg.SensorController", "sensor callback removed");
        this.f17854aS.unregisterListener(this, this.f17857aW);
        this.f17854aS.unregisterListener(this);
        this.f17860aZ = false;
        this.f17856aV = null;
    }

    public void setSensorCallBack(SensorEventCallBack sensorEventCallBack) {
        Log.m5641v("MicroMsg.SensorController", "sensor callback set");
        if (!this.f17860aZ) {
            this.f17854aS.registerListener(this, this.f17857aW, 2);
            this.f17860aZ = true;
        }
        this.f17856aV = sensorEventCallBack;
    }
}
