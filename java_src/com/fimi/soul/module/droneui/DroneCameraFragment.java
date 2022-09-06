package com.fimi.soul.module.droneui;

import android.os.Bundle;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseDroneFragment;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.media.player.FermiMediaManager;
import com.fimi.soul.media.player.FermiMediaPlayerType;
import com.fimi.soul.media.player.IFermiMediaPlayer;
import com.fimi.soul.media.player.IMediaPlayer;
import com.fimi.soul.media.player.OnPlayerStateChangedListener;
import com.fimi.soul.module.droneui.FlightActivity;
/* loaded from: classes.dex */
public class DroneCameraFragment extends BaseDroneFragment {

    /* renamed from: a */
    private static final String f12599a = DroneCameraFragment.class.getSimpleName();

    /* renamed from: b */
    private static final int f12600b = 2;

    /* renamed from: e */
    private static View f12601e;

    /* renamed from: c */
    private SurfaceView f12602c;

    /* renamed from: f */
    private IFermiMediaPlayer f12604f;

    /* renamed from: d */
    private String f12603d = C2427e.m12218d();

    /* renamed from: g */
    private boolean f12605g = false;

    /* renamed from: a */
    private void m8908a(View view) {
        this.f12602c = (SurfaceView) view.findViewById(C2300R.C2302id.ids_video_view);
        f12601e = view.findViewById(C2300R.C2302id.control_cantairn);
        f12601e.setVisibility(0);
    }

    /* renamed from: i */
    private void m8901i() {
        this.f12602c.setKeepScreenOn(true);
        PreferenceManager.getDefaultSharedPreferences(getActivity());
        this.f12602c.setZOrderMediaOverlay(true);
        this.f12604f = FermiMediaManager.getDefaultManager(getActivity()).createFermiMediaPlayer(FermiMediaPlayerType.FimiMediaPlayer);
        this.f12604f.setSurfaceView(this.f12602c);
        this.f12604f.setAutoPlay(false);
        this.f12604f.setMediaUri(this.f12603d);
        this.f12604f.addOnPlayerStateChangedListener(new OnPlayerStateChangedListener() { // from class: com.fimi.soul.module.droneui.DroneCameraFragment.1
            @Override // com.fimi.soul.media.player.OnPlayerStateChangedListener
            public void OnPlayerStateChanged(IFermiMediaPlayer.FermiPlyaerState fermiPlyaerState, IFermiMediaPlayer iFermiMediaPlayer) {
                Log.d("Good", "播放器状态-->" + fermiPlyaerState.toString());
                if (fermiPlyaerState == IFermiMediaPlayer.FermiPlyaerState.Inited) {
                    DroneCameraFragment.this.f12605g = true;
                    DroneCameraFragment.this.m8904f();
                }
                if (DroneCameraFragment.this.f12605g) {
                    if (fermiPlyaerState == IFermiMediaPlayer.FermiPlyaerState.Playing) {
                        DroneCameraFragment.this.getActivity().runOnUiThread(new Runnable() { // from class: com.fimi.soul.module.droneui.DroneCameraFragment.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                DroneCameraFragment.this.c().sendEmptyMessageDelayed(2, 500L);
                            }
                        });
                    } else {
                        DroneCameraFragment.this.getActivity().runOnUiThread(new Runnable() { // from class: com.fimi.soul.module.droneui.DroneCameraFragment.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                DroneCameraFragment.f12601e.setVisibility(0);
                            }
                        });
                    }
                }
            }
        });
    }

    @Override // com.fimi.kernel.BaseFragment
    /* renamed from: a */
    public void mo8909a(Message message) {
        a().mo12676c();
        if (message.what == 2) {
            f12601e.setVisibility(8);
        }
    }

    /* renamed from: f */
    public void m8904f() {
        if (((FlightActivity) getActivity()).m8887b() == FlightActivity.EnumC3284c.Camera && this.f12604f != null && this.f12603d != null && this.f12605g) {
            try {
                this.f12602c.setVisibility(0);
                this.f12604f.prepare();
                this.f12604f.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: g */
    public void m8903g() {
        f12601e.setVisibility(0);
        this.f12602c.setZOrderMediaOverlay(false);
        this.f12602c.setVisibility(8);
        if (this.f12604f.isPlaying()) {
            this.f12604f.stop();
        }
    }

    @Override // com.fimi.kernel.BaseFragment, android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(C2300R.layout.fragment_camera_preview, (ViewGroup) null);
        getActivity().setVolumeControlStream(3);
        m8908a(inflate);
        m8901i();
        return inflate;
    }

    @Override // android.support.p001v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f12604f.isPlaying()) {
            this.f12604f.stop();
        }
        if (this.f12604f instanceof IMediaPlayer) {
            ((IMediaPlayer) this.f12604f).release();
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onStart() {
        Log.d("Good", "onStart");
        m8904f();
        super.onStart();
    }

    @Override // android.support.p001v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.f12604f.isPlaying()) {
            this.f12604f.stop();
        }
    }
}
