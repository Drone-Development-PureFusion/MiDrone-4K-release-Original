package com.fimi.soul.media.player.widget;

import android.view.View;
import com.fimi.soul.media.player.widget.FmMediaController;
/* loaded from: classes.dex */
public interface IMediaController {
    void hide();

    boolean isShowing();

    void setAnchorView(View view);

    void setEnabled(boolean z);

    void setMediaPlayer(FmMediaController.MediaPlayerControl mediaPlayerControl);

    void show();

    void show(int i);

    void showOnce(View view);
}
