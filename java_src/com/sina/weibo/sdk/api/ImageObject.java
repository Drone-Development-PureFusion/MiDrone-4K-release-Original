package com.sina.weibo.sdk.api;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p001v4.view.accessibility.AccessibilityEventCompat;
import cn.sharesdk.framework.utils.C0683d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import p004b.p005a.p006a.p028b.p051m.C0501h;
/* loaded from: classes.dex */
public class ImageObject implements Parcelable {
    public byte[] imageData;
    public String imagePath;
    private static final int DATA_SIZE = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    public static final Parcelable.Creator<ImageObject> CREATOR = new Parcelable.Creator<ImageObject>() { // from class: com.sina.weibo.sdk.api.ImageObject.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        /* renamed from: createFromParcel */
        public ImageObject mo21850createFromParcel(Parcel parcel) {
            return new ImageObject(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        /* renamed from: newArray */
        public ImageObject[] mo21851newArray(int i) {
            return new ImageObject[i];
        }
    };

    public ImageObject() {
    }

    public ImageObject(Parcel parcel) {
        this.imageData = parcel.createByteArray();
        this.imagePath = parcel.readString();
    }

    public boolean checkArgs() {
        if (this.imageData == null && this.imagePath == null) {
            new Throwable("imageData and imagePath are null").printStackTrace();
            return false;
        } else if (this.imageData != null && this.imageData.length > DATA_SIZE) {
            new Throwable("imageData is too large").printStackTrace();
            return false;
        } else if (this.imagePath != null && this.imagePath.length() > 512) {
            new Throwable("imagePath is too length").printStackTrace();
            return false;
        } else {
            if (this.imagePath != null) {
                try {
                    File file = new File(this.imagePath);
                    if (!file.exists() || file.length() == 0 || file.length() > C0501h.f1123b) {
                        new Throwable("checkArgs fail, image content is too large or not exists").printStackTrace();
                        return false;
                    }
                } catch (Throwable th) {
                    new Throwable("checkArgs fail, image content is too large or not exists").printStackTrace();
                    return false;
                }
            }
            return true;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getObjType() {
        return 2;
    }

    public final void setImageObject(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
                this.imageData = byteArrayOutputStream.toByteArray();
                if (byteArrayOutputStream == null) {
                    return;
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th) {
                    C0683d.m19513a().m5971d(th);
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    C0683d.m19513a().m5971d(th);
                    if (byteArrayOutputStream == null) {
                        return;
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        C0683d.m19513a().m5971d(th3);
                    }
                } catch (Throwable th4) {
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th5) {
                            C0683d.m19513a().m5971d(th5);
                        }
                    }
                    throw th4;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            byteArrayOutputStream = null;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.imageData);
        parcel.writeString(this.imagePath);
    }
}
