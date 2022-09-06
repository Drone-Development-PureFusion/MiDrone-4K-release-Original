package android.support.p001v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.p001v4.app.BackStackRecord;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: android.support.v4.app.BackStackState */
/* loaded from: classes.dex */
public final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() { // from class: android.support.v4.app.BackStackState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        /* renamed from: createFromParcel */
        public BackStackState mo21673createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        /* renamed from: newArray */
        public BackStackState[] mo21674newArray(int i) {
            return new BackStackState[i];
        }
    };
    final int mBreadCrumbShortTitleRes;
    final CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final CharSequence mBreadCrumbTitleText;
    final int mIndex;
    final String mName;
    final int[] mOps;
    final int mTransition;
    final int mTransitionStyle;

    public BackStackState(Parcel parcel) {
        this.mOps = parcel.createIntArray();
        this.mTransition = parcel.readInt();
        this.mTransitionStyle = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mBreadCrumbTitleRes = parcel.readInt();
        this.mBreadCrumbTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mBreadCrumbShortTitleRes = parcel.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }

    public BackStackState(FragmentManagerImpl fragmentManagerImpl, BackStackRecord backStackRecord) {
        int i = 0;
        for (BackStackRecord.C0042Op c0042Op = backStackRecord.mHead; c0042Op != null; c0042Op = c0042Op.next) {
            if (c0042Op.removed != null) {
                i += c0042Op.removed.size();
            }
        }
        this.mOps = new int[i + (backStackRecord.mNumOp * 7)];
        if (!backStackRecord.mAddToBackStack) {
            throw new IllegalStateException("Not on back stack");
        }
        int i2 = 0;
        for (BackStackRecord.C0042Op c0042Op2 = backStackRecord.mHead; c0042Op2 != null; c0042Op2 = c0042Op2.next) {
            int i3 = i2 + 1;
            this.mOps[i2] = c0042Op2.cmd;
            int i4 = i3 + 1;
            this.mOps[i3] = c0042Op2.fragment != null ? c0042Op2.fragment.mIndex : -1;
            int i5 = i4 + 1;
            this.mOps[i4] = c0042Op2.enterAnim;
            int i6 = i5 + 1;
            this.mOps[i5] = c0042Op2.exitAnim;
            int i7 = i6 + 1;
            this.mOps[i6] = c0042Op2.popEnterAnim;
            int i8 = i7 + 1;
            this.mOps[i7] = c0042Op2.popExitAnim;
            if (c0042Op2.removed != null) {
                int size = c0042Op2.removed.size();
                int i9 = i8 + 1;
                this.mOps[i8] = size;
                int i10 = 0;
                while (i10 < size) {
                    this.mOps[i9] = c0042Op2.removed.get(i10).mIndex;
                    i10++;
                    i9++;
                }
                i2 = i9;
            } else {
                i2 = i8 + 1;
                this.mOps[i8] = 0;
            }
        }
        this.mTransition = backStackRecord.mTransition;
        this.mTransitionStyle = backStackRecord.mTransitionStyle;
        this.mName = backStackRecord.mName;
        this.mIndex = backStackRecord.mIndex;
        this.mBreadCrumbTitleRes = backStackRecord.mBreadCrumbTitleRes;
        this.mBreadCrumbTitleText = backStackRecord.mBreadCrumbTitleText;
        this.mBreadCrumbShortTitleRes = backStackRecord.mBreadCrumbShortTitleRes;
        this.mBreadCrumbShortTitleText = backStackRecord.mBreadCrumbShortTitleText;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BackStackRecord instantiate(FragmentManagerImpl fragmentManagerImpl) {
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManagerImpl);
        int i = 0;
        int i2 = 0;
        while (i2 < this.mOps.length) {
            BackStackRecord.C0042Op c0042Op = new BackStackRecord.C0042Op();
            int i3 = i2 + 1;
            c0042Op.cmd = this.mOps[i2];
            if (FragmentManagerImpl.DEBUG) {
                Log.v("FragmentManager", "Instantiate " + backStackRecord + " op #" + i + " base fragment #" + this.mOps[i3]);
            }
            int i4 = i3 + 1;
            int i5 = this.mOps[i3];
            if (i5 >= 0) {
                c0042Op.fragment = fragmentManagerImpl.mActive.get(i5);
            } else {
                c0042Op.fragment = null;
            }
            int i6 = i4 + 1;
            c0042Op.enterAnim = this.mOps[i4];
            int i7 = i6 + 1;
            c0042Op.exitAnim = this.mOps[i6];
            int i8 = i7 + 1;
            c0042Op.popEnterAnim = this.mOps[i7];
            int i9 = i8 + 1;
            c0042Op.popExitAnim = this.mOps[i8];
            int i10 = i9 + 1;
            int i11 = this.mOps[i9];
            if (i11 > 0) {
                c0042Op.removed = new ArrayList<>(i11);
                int i12 = 0;
                while (i12 < i11) {
                    if (FragmentManagerImpl.DEBUG) {
                        Log.v("FragmentManager", "Instantiate " + backStackRecord + " set remove fragment #" + this.mOps[i10]);
                    }
                    c0042Op.removed.add(fragmentManagerImpl.mActive.get(this.mOps[i10]));
                    i12++;
                    i10++;
                }
            }
            backStackRecord.addOp(c0042Op);
            i++;
            i2 = i10;
        }
        backStackRecord.mTransition = this.mTransition;
        backStackRecord.mTransitionStyle = this.mTransitionStyle;
        backStackRecord.mName = this.mName;
        backStackRecord.mIndex = this.mIndex;
        backStackRecord.mAddToBackStack = true;
        backStackRecord.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
        backStackRecord.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
        backStackRecord.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
        backStackRecord.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
        backStackRecord.bumpBackStackNesting(1);
        return backStackRecord;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.mOps);
        parcel.writeInt(this.mTransition);
        parcel.writeInt(this.mTransitionStyle);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbTitleText, parcel, 0);
        parcel.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, parcel, 0);
    }
}
