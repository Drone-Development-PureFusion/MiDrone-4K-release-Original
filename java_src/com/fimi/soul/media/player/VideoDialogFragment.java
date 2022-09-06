package com.fimi.soul.media.player;

import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.p163c.AbstractC2239a;
import com.fimi.soul.C2300R;
import com.fimi.soul.media.player.FermiPlayerViewBuilder;
@SuppressLint({"ValidFragment"})
/* loaded from: classes.dex */
public class VideoDialogFragment extends DialogFragment {
    private static final String SP_KEY_FRAGMENT_LOADING_AGAIN = "SP_KEY_FRAGMENT_LOADING_AGAIN_VideoDialogFragment";
    private static final String SP_KEY_FRAGMENT_ORIGIN_ORIENTATION = "SP_KEY_FRAGMENT_ORIGIN_ORIENTATION_VideoDialogFragment";
    private static final String SP_KEY_FRAGMENT_POSITION = "SP_KEY_FRAGMENT_POSITION_VideoDialogFragment";
    private static final String SP_KEY_PLAYER_ADDR = "SP_KEY_PLAYER_ADDR_VideoDialogFragment";
    private IFermiMediaPlayer player;
    private boolean isPortait = false;
    AbstractC2239a manager = null;
    private int currentPosition = 0;
    private boolean loadingAgain = false;
    private String url = "";

    /* JADX INFO: Access modifiers changed from: private */
    public void changeScreenOrientation() {
        this.player.pause();
        this.currentPosition = this.player.getPosition();
        Log.d("Good", this.currentPosition + "");
        if (this.currentPosition < 2000) {
            this.currentPosition = 0;
        } else {
            this.currentPosition -= 2000;
        }
        this.manager.mo13120a(SP_KEY_FRAGMENT_POSITION, this.currentPosition);
        if (this.isPortait) {
            getActivity().setRequestedOrientation(0);
        }
    }

    public static VideoDialogFragment newInstance(String str) {
        VideoDialogFragment videoDialogFragment = new VideoDialogFragment();
        videoDialogFragment.url = str;
        C2238c.m13125c().mo13116a("SP_KEY_PLAYER_ADDR_VideoDialogFragment", str);
        return videoDialogFragment;
    }

    public void dismissDialog() {
        this.player.stop();
        if (this.manager.mo13108d(SP_KEY_FRAGMENT_ORIGIN_ORIENTATION) != this.isPortait) {
            if (this.manager.mo13108d(SP_KEY_FRAGMENT_ORIGIN_ORIENTATION)) {
                getActivity().setRequestedOrientation(1);
            } else {
                getActivity().setRequestedOrientation(0);
            }
        }
        this.currentPosition = 0;
        this.manager.mo13120a(SP_KEY_FRAGMENT_POSITION, this.currentPosition);
        this.manager.mo13114a(SP_KEY_FRAGMENT_LOADING_AGAIN, false);
        dismiss();
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        dismissDialog();
        super.onCancel(dialogInterface);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.manager = C2238c.m13125c();
        setStyle(C2300R.style.videoDialog, 16973831);
        this.isPortait = getResources().getConfiguration().orientation == 1;
        this.currentPosition = this.manager.mo13112b(SP_KEY_FRAGMENT_POSITION);
        this.loadingAgain = this.manager.mo13108d(SP_KEY_FRAGMENT_LOADING_AGAIN);
        if (!this.loadingAgain) {
            this.manager.mo13114a(SP_KEY_FRAGMENT_ORIGIN_ORIENTATION, this.isPortait);
            this.manager.mo13114a(SP_KEY_FRAGMENT_LOADING_AGAIN, true);
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = this.isPortait ? C2300R.layout.layout_videoview_popup : C2300R.layout.layout_videoview_popup_fullscreen;
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.player.setAutoPlay(true);
        this.player.setPlayPosition(this.currentPosition);
        this.url = this.manager.mo13121a("SP_KEY_PLAYER_ADDR_VideoDialogFragment");
        View create = FermiPlayerViewBuilder.Builder(getActivity(), i).setFermiMediaPlayer(this.player).setOnClickFullscreenListener(new View.OnClickListener() { // from class: com.fimi.soul.media.player.VideoDialogFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoDialogFragment.this.changeScreenOrientation();
            }
        }).setOnClickCloseListenner(new FermiPlayerViewBuilder.OnClickCloseListener() { // from class: com.fimi.soul.media.player.VideoDialogFragment.2
            @Override // com.fimi.soul.media.player.FermiPlayerViewBuilder.OnClickCloseListener
            public void onClose(View view) {
                VideoDialogFragment.this.player.stop();
                VideoDialogFragment.this.dismissDialog();
            }
        }).setOnDoubleTapListener(new FermiPlayerViewBuilder.OnDoubleTapListener() { // from class: com.fimi.soul.media.player.VideoDialogFragment.1
            @Override // com.fimi.soul.media.player.FermiPlayerViewBuilder.OnDoubleTapListener
            public void onDoubleTap(MotionEvent motionEvent) {
                VideoDialogFragment.this.changeScreenOrientation();
            }
        }).create();
        this.player.setMediaUri(this.url);
        this.player.prepare();
        return create;
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.player.play();
    }
}
