package android.support.p001v4.p003os;

import android.os.Parcelable;
/* renamed from: android.support.v4.os.ParcelableCompatCreatorHoneycombMR2Stub */
/* loaded from: classes.dex */
class ParcelableCompatCreatorHoneycombMR2Stub {
    ParcelableCompatCreatorHoneycombMR2Stub() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Parcelable.Creator<T> instantiate(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
        return new ParcelableCompatCreatorHoneycombMR2(parcelableCompatCreatorCallbacks);
    }
}
