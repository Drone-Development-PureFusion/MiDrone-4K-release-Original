package android.support.p001v4.app;

import android.app.PendingIntent;
import android.os.Bundle;
import android.support.p001v4.app.RemoteInputCompatBase;
/* renamed from: android.support.v4.app.NotificationCompatBase */
/* loaded from: classes.dex */
class NotificationCompatBase {

    /* renamed from: android.support.v4.app.NotificationCompatBase$Action */
    /* loaded from: classes.dex */
    public static abstract class Action {

        /* renamed from: android.support.v4.app.NotificationCompatBase$Action$Factory */
        /* loaded from: classes.dex */
        public interface Factory {
            /* renamed from: build */
            Action mo21684build(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInputCompatBase.RemoteInput[] remoteInputArr);

            /* renamed from: newArray */
            Action[] mo21685newArray(int i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract PendingIntent getActionIntent();

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract Bundle getExtras();

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract int getIcon();

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: getRemoteInputs */
        public abstract RemoteInputCompatBase.RemoteInput[] mo21683getRemoteInputs();

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract CharSequence getTitle();
    }

    NotificationCompatBase() {
    }
}
