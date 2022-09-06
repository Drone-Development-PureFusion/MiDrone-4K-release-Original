package com.mob.commons.authorize;

import android.content.Context;
import com.mob.commons.C4125a;
import com.mob.commons.C4146e;
/* loaded from: classes.dex */
public final class DeviceAuthorizer {
    public static synchronized String authorize(Context context, com.mob.commons.MobProduct mobProduct) {
        String m6117a;
        synchronized (DeviceAuthorizer.class) {
            C4146e.m6034a(mobProduct);
            C4128a c4128a = new C4128a();
            m6117a = (mobProduct == null || !C4125a.m6132h(context)) ? c4128a.m6117a(context) : c4128a.m6116a(context, mobProduct);
        }
        return m6117a;
    }

    public static String authorize(Context context, final MobProduct mobProduct) {
        return authorize(context, new com.mob.commons.MobProduct() { // from class: com.mob.commons.authorize.DeviceAuthorizer.1
            @Override // com.mob.commons.MobProduct
            public String getProductAppkey() {
                return MobProduct.this.getProductAppkey();
            }

            @Override // com.mob.commons.MobProduct
            public String getProductTag() {
                return MobProduct.this.getProductTag();
            }

            @Override // com.mob.commons.MobProduct
            public int getSdkver() {
                return MobProduct.this.getSdkver();
            }
        });
    }
}
