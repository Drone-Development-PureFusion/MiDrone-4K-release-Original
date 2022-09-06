package android.support.p001v4.media;

import android.view.KeyEvent;
/* renamed from: android.support.v4.media.TransportMediatorCallback */
/* loaded from: classes.dex */
interface TransportMediatorCallback {
    long getPlaybackPosition();

    void handleAudioFocusChange(int i);

    void handleKey(KeyEvent keyEvent);

    void playbackPositionUpdate(long j);
}
