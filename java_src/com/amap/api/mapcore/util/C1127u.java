package com.amap.api.mapcore.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.WindowManager;
import com.amap.api.maps.model.Marker;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
/* renamed from: com.amap.api.mapcore.util.u */
/* loaded from: classes.dex */
public class C1127u implements SensorEventListener {

    /* renamed from: a */
    private SensorManager f3525a;

    /* renamed from: b */
    private Sensor f3526b;

    /* renamed from: c */
    private long f3527c = 0;

    /* renamed from: d */
    private final int f3528d = 100;

    /* renamed from: e */
    private float f3529e;

    /* renamed from: f */
    private Context f3530f;

    /* renamed from: g */
    private AbstractC1115l f3531g;

    /* renamed from: h */
    private Marker f3532h;

    public C1127u(Context context, AbstractC1115l abstractC1115l) {
        this.f3530f = context.getApplicationContext();
        this.f3531g = abstractC1115l;
        this.f3525a = (SensorManager) context.getSystemService("sensor");
        this.f3526b = this.f3525a.getDefaultSensor(3);
    }

    /* renamed from: a */
    public static int m17471a(Context context) {
        switch (((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation()) {
            case 0:
                return 0;
            case 1:
                return 90;
            case 2:
                return Opcodes.GETFIELD;
            case 3:
                return -90;
            default:
                return 0;
        }
    }

    /* renamed from: a */
    public void m17472a() {
        this.f3525a.registerListener(this, this.f3526b, 3);
    }

    /* renamed from: a */
    public void m17470a(Marker marker) {
        this.f3532h = marker;
    }

    /* renamed from: b */
    public void m17469b() {
        this.f3525a.unregisterListener(this, this.f3526b);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (System.currentTimeMillis() - this.f3527c < 100) {
            return;
        }
        if (this.f3531g.mo17557a() != null && this.f3531g.mo17557a().getAnimateionsCount() > 0) {
            return;
        }
        switch (sensorEvent.sensor.getType()) {
            case 3:
                float m17471a = (sensorEvent.values[0] + m17471a(this.f3530f)) % 360.0f;
                if (m17471a > 180.0f) {
                    m17471a -= 360.0f;
                } else if (m17471a < -180.0f) {
                    m17471a += 360.0f;
                }
                if (Math.abs(this.f3529e - m17471a) < 3.0f) {
                    return;
                }
                if (Float.isNaN(m17471a)) {
                    m17471a = 0.0f;
                }
                this.f3529e = m17471a;
                if (this.f3532h != null) {
                    try {
                        this.f3531g.mo17542a(C0768ag.m19090d(this.f3529e));
                        this.f3532h.setRotateAngle(-this.f3529e);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                this.f3527c = System.currentTimeMillis();
                return;
            default:
                return;
        }
    }
}
