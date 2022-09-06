package com.p080b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* renamed from: com.b.dk */
/* loaded from: classes.dex */
public interface AbstractC1529dk extends IInterface {

    /* renamed from: com.b.dk$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC1530a extends Binder implements AbstractC1529dk {

        /* renamed from: com.b.dk$a$a */
        /* loaded from: classes.dex */
        private static class C1531a implements AbstractC1529dk {

            /* renamed from: a */
            private IBinder f5477a;

            C1531a(IBinder iBinder) {
                this.f5477a = iBinder;
            }

            @Override // com.p080b.AbstractC1529dk
            /* renamed from: a */
            public int mo15673a(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.amap.api.service.locationprovider.ILocationProviderService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f5477a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    if (obtain2.readInt() != 0) {
                        bundle.readFromParcel(obtain2);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5477a;
            }
        }

        public AbstractBinderC1530a() {
            attachInterface(this, "com.amap.api.service.locationprovider.ILocationProviderService");
        }

        /* renamed from: a */
        public static AbstractC1529dk m15674a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.amap.api.service.locationprovider.ILocationProviderService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof AbstractC1529dk)) ? new C1531a(iBinder) : (AbstractC1529dk) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.amap.api.service.locationprovider.ILocationProviderService");
                    Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                    int a = a(bundle);
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    if (bundle != null) {
                        parcel2.writeInt(1);
                        bundle.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    parcel2.writeString("com.amap.api.service.locationprovider.ILocationProviderService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: a */
    int mo15673a(Bundle bundle);
}
