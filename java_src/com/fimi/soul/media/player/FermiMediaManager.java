package com.fimi.soul.media.player;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.fimi.soul.C2300R;
import com.fimi.soul.media.player.FermiPlayerViewBuilder;
/* loaded from: classes.dex */
public final class FermiMediaManager {
    public static final String FERMI_PLAYER_TEMP_VARIABLE = "FERMI_PLAYER_TEMP_VARIABLE";
    private static FermiMediaManager fermiMediaManager;
    private Context context;
    private Dialog dialog;
    private DroneVideoDialogFragment droneFragment;
    private VideoDialogFragment fragment;
    private IFermiMediaPlayer player = null;

    private Context getContext() {
        return this.context;
    }

    public static synchronized FermiMediaManager getDefaultManager(Context context) {
        FermiMediaManager fermiMediaManager2;
        synchronized (FermiMediaManager.class) {
            if (fermiMediaManager == null) {
                fermiMediaManager = new FermiMediaManager();
            }
            fermiMediaManager.context = context;
            fermiMediaManager2 = fermiMediaManager;
        }
        return fermiMediaManager2;
    }

    public IFermiMediaPlayer createFermiMediaPlayer(FermiMediaPlayerType fermiMediaPlayerType) {
        switch (fermiMediaPlayerType) {
            case SystemMediaPlayer:
                return new FermiSystemMediaPlayer(getContext());
            default:
                return null;
        }
    }

    public void dismissPopVideoView() {
        if (this.fragment != null) {
            this.fragment.dismissDialog();
            this.fragment = null;
        }
        if (this.dialog != null) {
            this.dialog.dismiss();
            this.dialog = null;
        }
    }

    public void showFullScreenPopVideoView(FragmentManager fragmentManager, String str) {
        this.droneFragment = DroneVideoDialogFragment.newInstance(str);
        this.droneFragment.show(fragmentManager, str);
    }

    public void showPopVideoView(FragmentManager fragmentManager, String str) {
        this.fragment = VideoDialogFragment.newInstance(str);
        this.fragment.show(fragmentManager, "VIDEO_DIALOG_FRAGMENT");
    }

    public void showPopVideoView(String str) {
        final FermiPlayerDialog fermiPlayerDialog = new FermiPlayerDialog(getContext(), C2300R.style.videoDialog);
        final IFermiMediaPlayer createFermiMediaPlayer = createFermiMediaPlayer(FermiMediaPlayerType.SystemMediaPlayer);
        createFermiMediaPlayer.setAutoPlay(true);
        fermiPlayerDialog.setContentView(FermiPlayerViewBuilder.Builder(getContext(), C2300R.layout.layout_videoview_popup).setFermiMediaPlayer(createFermiMediaPlayer).setOnClickCloseListenner(new FermiPlayerViewBuilder.OnClickCloseListener() { // from class: com.fimi.soul.media.player.FermiMediaManager.4
            @Override // com.fimi.soul.media.player.FermiPlayerViewBuilder.OnClickCloseListener
            public void onClose(View view) {
                createFermiMediaPlayer.stop();
                fermiPlayerDialog.dismiss();
            }
        }).setOnDoubleTapListener(new FermiPlayerViewBuilder.OnDoubleTapListener() { // from class: com.fimi.soul.media.player.FermiMediaManager.3
            @Override // com.fimi.soul.media.player.FermiPlayerViewBuilder.OnDoubleTapListener
            public void onDoubleTap(MotionEvent motionEvent) {
            }
        }).create());
        if (str != null) {
            createFermiMediaPlayer.setMediaUri(str);
        }
        fermiPlayerDialog.show();
    }

    public void showPopVideoViewWithNoSeekBar(String str) {
        this.dialog = new FermiPlayerDialog(getContext(), C2300R.style.videoDialog);
        final IFermiMediaPlayer createFermiMediaPlayer = createFermiMediaPlayer(FermiMediaPlayerType.SystemMediaPlayer);
        createFermiMediaPlayer.setAutoPlay(true);
        this.dialog.setContentView(FermiPlayerViewBuilder.Builder(getContext(), C2300R.layout.layout_videoview_popup).setFermiMediaPlayer(createFermiMediaPlayer).setOnClickCloseListenner(new FermiPlayerViewBuilder.OnClickCloseListener() { // from class: com.fimi.soul.media.player.FermiMediaManager.2
            @Override // com.fimi.soul.media.player.FermiPlayerViewBuilder.OnClickCloseListener
            public void onClose(View view) {
                createFermiMediaPlayer.stop();
                FermiMediaManager.this.dialog.dismiss();
            }
        }).setOnDoubleTapListener(new FermiPlayerViewBuilder.OnDoubleTapListener() { // from class: com.fimi.soul.media.player.FermiMediaManager.1
            @Override // com.fimi.soul.media.player.FermiPlayerViewBuilder.OnDoubleTapListener
            public void onDoubleTap(MotionEvent motionEvent) {
            }
        }).create());
        if (str != null) {
            createFermiMediaPlayer.setMediaUri(str);
        }
        this.dialog.show();
        createFermiMediaPlayer.play();
    }
}
