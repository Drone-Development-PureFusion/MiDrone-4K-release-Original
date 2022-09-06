package com.fimi.soul.module.droneFragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p001v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.utils.C2277v;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.p180i.C2477h;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p202h.C2854c;
import com.fimi.soul.drone.p203i.p204a.C2861a;
import com.fimi.soul.entity.DeviceType;
import com.fimi.soul.module.droneui.FlightActivity;
import com.fimi.soul.module.update.C3587b;
import com.fimi.soul.module.update.p210a.C3580b;
import com.fimi.soul.view.DialogC3796e;
/* loaded from: classes.dex */
public class DroneTakePhotoFragment extends Fragment implements C2678d.AbstractC2680b {

    /* renamed from: a */
    C2277v f11579a;

    /* renamed from: b */
    private View$OnClickListenerC3187i f11580b;

    /* renamed from: c */
    private C3186h f11581c;

    /* renamed from: d */
    private C2657a f11582d;

    /* renamed from: e */
    private View f11583e;

    /* renamed from: f */
    private Dialog f11584f;

    /* renamed from: g */
    private int f11585g;

    /* renamed from: h */
    private double f11586h;

    /* renamed from: i */
    private FlightActivity.AbstractC3281a f11587i;

    /* renamed from: a */
    private void m9674a(String str) {
        if (this.f11584f != null && this.f11584f.isShowing()) {
            this.f11584f.dismiss();
            this.f11584f = null;
        }
        DialogC3796e.C3797a c3797a = new DialogC3796e.C3797a(getActivity());
        c3797a.m7045a(str);
        c3797a.m7043a(true);
        c3797a.m7044a(getString(C2300R.C2303string.finish), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.droneFragment.DroneTakePhotoFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        this.f11584f = c3797a.m7049a();
        this.f11584f.setCanceledOnTouchOutside(false);
        this.f11584f.show();
    }

    /* renamed from: a */
    private boolean m9676a(View view) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        return ((float) (view.getBottom() - rect.bottom)) > view.getResources().getDisplayMetrics().density * 100.0f;
    }

    /* renamed from: c */
    private void m9672c() {
        boolean z = false;
        if (C2277v.m12784a(getActivity()).m12742s() == DeviceType.DEVICE_4K) {
            z = true;
        }
        if (!z || m9671d() < 2016) {
            short m10533c = this.f11582d.mo11221Z().m10533c();
            if (this.f11585g - m10533c < 0) {
                this.f11586h = ((m10533c - 255) * 90) / 255;
            } else {
                this.f11586h = ((m10533c * 90) / 255) - 90;
            }
            this.f11585g = m10533c;
        } else {
            this.f11586h = this.f11582d.mo11221Z().m10520j();
        }
        this.f11580b.m9298a((int) this.f11586h);
    }

    /* renamed from: d */
    private int m9671d() {
        C3580b c3580b = (C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class);
        if (c3580b == null) {
            c3580b = new C3580b();
        }
        if (c3580b == null || c3580b.m7955c() <= 0) {
            return 0;
        }
        return c3580b.m7955c();
    }

    /* renamed from: a */
    public void m9675a(FlightActivity.AbstractC3281a abstractC3281a) {
        this.f11587i = abstractC3281a;
    }

    /* renamed from: a */
    public boolean m9677a() {
        if (this.f11584f == null || !this.f11584f.isShowing()) {
            return m9676a(this.f11583e);
        }
        return false;
    }

    /* renamed from: b */
    public void m9673b() {
        this.f11580b.m9265j();
    }

    @Override // android.support.p001v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f11582d = ((DroidPlannerApp) activity.getApplication()).f7895a;
        this.f11579a = C2277v.m12784a(getActivity());
    }

    @Override // android.support.p001v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.drone_takephone, (ViewGroup) null);
        this.f11583e = inflate;
        this.f11580b = new View$OnClickListenerC3187i(inflate, this.f11582d);
        this.f11581c = new C3186h(inflate);
        this.f11580b.m9287a(this.f11587i);
        return inflate;
    }

    @Override // android.support.p001v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f11582d.mo11214b(this);
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        switch (enumC2679a) {
            case CAMERARECORD:
                if (C2477h.m12020a(getActivity().getApplicationContext()).m12022a().get() != 4) {
                    return;
                }
                this.f11580b.m9284b();
                return;
            case PTZ_GAIN:
                c2657a.mo11221Z().m10533c();
                if (!c2657a.mo11215ae()) {
                    return;
                }
                m9672c();
                return;
            case WXCETAKEPHOTOAGAIN:
                this.f11580b.m9300a();
                return;
            case TAKEPHOTOBACKDATA:
                C2861a m11306az = c2657a.m11306az();
                if (m11306az.m10733j() != 19) {
                    return;
                }
                this.f11580b.m9292a(m11306az);
                return;
            case HEARDATA:
                if (!c2657a.m11318an().m10066u()) {
                    return;
                }
                this.f11580b.m9271g();
                return;
            default:
                return;
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (isAdded()) {
            if (z) {
                if (this.f11584f != null) {
                    this.f11584f.dismiss();
                }
                if (this.f11581c != null) {
                    this.f11581c.m9302a();
                }
                if (this.f11580b == null) {
                    return;
                }
                this.f11580b.m9273f();
                return;
            }
            if (!this.f11579a.m12787a().getBoolean(C2854c.f10580bF, false)) {
                m9674a(getString(C2300R.C2303string.fly_take_photo_tip));
            }
            this.f11580b.m9277d();
            this.f11580b.m9275e();
            this.f11580b.m9267i();
            this.f11581c.m9301b();
            this.f11582d.mo11220a(C2678d.EnumC2679a.CLEARMARKERTAKEPHOTO);
            this.f11582d.mo11220a(C2678d.EnumC2679a.CLEARDATA);
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.f11582d.mo11219a(this);
    }
}
