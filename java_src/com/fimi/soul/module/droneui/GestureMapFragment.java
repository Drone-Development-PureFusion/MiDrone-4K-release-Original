package com.fimi.soul.module.droneui;

import android.gesture.GestureOverlayView;
import android.graphics.Point;
import android.os.Bundle;
import android.support.p001v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3653ao;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class GestureMapFragment extends Fragment implements GestureOverlayView.OnGestureListener {

    /* renamed from: a */
    private static final int f12686a = 15;

    /* renamed from: b */
    private static final int f12687b = 2;

    /* renamed from: c */
    private double f12688c;

    /* renamed from: d */
    private GestureOverlayView f12689d;

    /* renamed from: e */
    private AbstractC3285a f12690e;

    /* renamed from: com.fimi.soul.module.droneui.GestureMapFragment$a */
    /* loaded from: classes.dex */
    public interface AbstractC3285a {
        /* renamed from: a */
        void m8838a(List<Point> list);
    }

    /* renamed from: a */
    private int m8845a(double d) {
        return (int) Math.round(getResources().getDisplayMetrics().density * d);
    }

    /* renamed from: a */
    private void m8842a(List<Point> list) {
        float[] fArr = this.f12689d.getGesture().getStrokes().get(0).points;
        for (int i = 0; i < fArr.length; i += 2) {
            list.add(new Point((int) fArr[i], (int) fArr[i + 1]));
        }
    }

    /* renamed from: d */
    private List<Point> m8839d() {
        ArrayList arrayList = new ArrayList();
        m8842a(arrayList);
        return arrayList;
    }

    /* renamed from: a */
    public void m8846a() {
        this.f12689d.setEnabled(true);
    }

    /* renamed from: a */
    public void m8844a(GestureOverlayView gestureOverlayView) {
        this.f12689d = gestureOverlayView;
    }

    /* renamed from: a */
    public void m8843a(AbstractC3285a abstractC3285a) {
        this.f12690e = abstractC3285a;
    }

    /* renamed from: b */
    public void m8841b() {
        this.f12689d.setEnabled(false);
    }

    /* renamed from: c */
    public GestureOverlayView m8840c() {
        return this.f12689d;
    }

    @Override // android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.fragment_gesture_map, viewGroup, false);
        this.f12689d = (GestureOverlayView) inflate.findViewById(C2300R.C2302id.overlay1);
        this.f12689d.addOnGestureListener(this);
        this.f12689d.setEnabled(false);
        this.f12689d.setGestureStrokeWidth(m8845a(2.0d));
        this.f12688c = m8845a(15.0d);
        return inflate;
    }

    @Override // android.gesture.GestureOverlayView.OnGestureListener
    public void onGesture(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
    }

    @Override // android.gesture.GestureOverlayView.OnGestureListener
    public void onGestureCancelled(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
    }

    @Override // android.gesture.GestureOverlayView.OnGestureListener
    public void onGestureEnded(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
        this.f12689d.setEnabled(false);
        List<Point> m8839d = m8839d();
        if (m8839d.size() > 1) {
            m8839d = C3653ao.m7659a(m8839d, this.f12688c);
        }
        this.f12690e.m8838a(m8839d);
    }

    @Override // android.gesture.GestureOverlayView.OnGestureListener
    public void onGestureStarted(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
    }
}
