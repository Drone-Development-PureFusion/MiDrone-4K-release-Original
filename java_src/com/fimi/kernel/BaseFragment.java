package com.fimi.kernel;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.p001v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fimi.kernel.p163c.AbstractC2239a;
import com.fimi.kernel.utils.C2281x;
import com.fimi.kernel.view.AbstractC2288b;
/* loaded from: classes.dex */
public abstract class BaseFragment extends Fragment {

    /* renamed from: a */
    private Handler f7283a;

    /* renamed from: com.fimi.kernel.BaseFragment$a */
    /* loaded from: classes.dex */
    class HandlerC2167a extends Handler {
        HandlerC2167a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BaseFragment.this.mo8909a(message);
            super.handleMessage(message);
        }
    }

    /* renamed from: a */
    public AbstractC2288b m13344a() {
        return C2238c.m13127b();
    }

    /* renamed from: a */
    public void mo8909a(Message message) {
    }

    /* renamed from: a */
    public void m13343a(Runnable runnable) {
        C2281x.m12704a(runnable);
    }

    /* renamed from: b */
    public AbstractC2239a m13342b() {
        return C2238c.m13125c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public Handler m13341c() {
        return this.f7283a;
    }

    @Override // android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f7283a = new HandlerC2167a();
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }
}
