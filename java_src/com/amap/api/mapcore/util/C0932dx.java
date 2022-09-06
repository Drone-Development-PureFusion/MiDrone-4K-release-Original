package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amap.api.mapcore.util.C0898dg;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;
/* renamed from: com.amap.api.mapcore.util.dx */
/* loaded from: classes.dex */
public class C0932dx extends C0933dy {

    /* renamed from: e */
    private TileProvider f2867e = null;

    public C0932dx(Context context, int i, int i2) {
        super(context, i, i2);
        m18431a(context);
    }

    /* renamed from: a */
    private void m18431a(Context context) {
        m18429b(context);
    }

    /* renamed from: b */
    private void m18429b(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
        }
    }

    /* renamed from: c */
    private Bitmap m18428c(C0898dg.C0899a c0899a) {
        try {
            Tile tile = this.f2867e.getTile(c0899a.f2713a, c0899a.f2714b, c0899a.f2715c);
            if (tile != null && tile != TileProvider.NO_TILE) {
                return BitmapFactory.decodeByteArray(tile.data, 0, tile.data.length);
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // com.amap.api.mapcore.util.C0933dy, com.amap.api.mapcore.util.AbstractC0934dz
    /* renamed from: a */
    protected Bitmap mo18418a(Object obj) {
        return m18428c((C0898dg.C0899a) obj);
    }

    /* renamed from: a */
    public void m18430a(TileProvider tileProvider) {
        this.f2867e = tileProvider;
    }
}
