package com.fimi.soul.p165a.p166a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
/* renamed from: com.fimi.soul.a.a.a */
/* loaded from: classes.dex */
public class C2305a implements SensorEventListener {

    /* renamed from: a */
    boolean f7696a = true;

    /* renamed from: b */
    private Context f7697b;

    /* renamed from: c */
    private SensorManager f7698c;

    /* renamed from: d */
    private Sensor f7699d;

    /* renamed from: e */
    private Sensor f7700e;

    /* renamed from: f */
    private float f7701f;

    /* renamed from: g */
    private AbstractC2306a f7702g;

    /* renamed from: com.fimi.soul.a.a.a$a */
    /* loaded from: classes.dex */
    public interface AbstractC2306a {
        /* renamed from: a */
        void m12620a(float f);
    }

    public C2305a(Context context) {
        this.f7697b = context;
    }

    /* renamed from: a */
    public void m12623a() {
        this.f7698c = (SensorManager) this.f7697b.getSystemService("sensor");
        if (this.f7698c != null) {
            this.f7700e = this.f7698c.getDefaultSensor(3);
            this.f7699d = this.f7698c.getDefaultSensor(4);
        }
        if (this.f7700e == null && this.f7699d == null) {
            return;
        }
        this.f7698c.registerListener(this, this.f7700e, 2);
        SensorManager sensorManager = this.f7698c;
        Sensor sensor = this.f7699d;
        SensorManager sensorManager2 = this.f7698c;
        sensorManager.registerListener(this, sensor, 2);
    }

    /* renamed from: a */
    public void m12622a(AbstractC2306a abstractC2306a) {
        this.f7702g = abstractC2306a;
    }

    /* renamed from: b */
    public void m12621b() {
        if (this.f7698c != null) {
            this.f7698c.unregisterListener(this);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 4 && Math.abs(sensorEvent.values[2]) > 0.1d) {
            this.f7696a = true;
        }
        if (sensorEvent.sensor.getType() != 3 || !this.f7696a) {
            return;
        }
        this.f7696a = false;
        float f = sensorEvent.values[0];
        if (Math.abs(f - this.f7701f) <= 1.5d) {
            return;
        }
        this.f7702g.m12620a(f);
        this.f7701f = f;
    }
}
