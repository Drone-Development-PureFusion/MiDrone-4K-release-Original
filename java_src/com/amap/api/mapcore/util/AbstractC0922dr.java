package com.amap.api.mapcore.util;

import android.text.TextUtils;
import android.util.Log;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;
import com.baidu.tts.loopj.AsyncHttpClient;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.p248a.p249a.C5083e;
/* renamed from: com.amap.api.mapcore.util.dr */
/* loaded from: classes.dex */
public abstract class AbstractC0922dr implements TileProvider {

    /* renamed from: a */
    private final int f2830a;

    /* renamed from: b */
    C1072hc f2831b;

    /* renamed from: c */
    private final int f2832c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.mapcore.util.dr$a */
    /* loaded from: classes.dex */
    public class C0923a extends AbstractC1075hd {

        /* renamed from: b */
        private String f2834b;

        public C0923a(String str) {
            this.f2834b = "";
            this.f2834b = str;
            a(C0993ff.m18085a(C1119p.f3495a));
            a(5000);
            b(50000);
        }

        @Override // com.amap.api.mapcore.util.AbstractC1075hd
        /* renamed from: a */
        public Map<String, String> mo17702a() {
            HashMap hashMap = new HashMap();
            hashMap.put(C5083e.f21661Y, C1022g.f3202d);
            hashMap.put("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
            hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "4.1.2", "3dmap"));
            hashMap.put("X-INFO", C0986fb.m18150a(C1119p.f3495a));
            hashMap.put("key", C0976ey.m18166f(C1119p.f3495a));
            hashMap.put("logversion", "2.1");
            return hashMap;
        }

        @Override // com.amap.api.mapcore.util.AbstractC1075hd
        /* renamed from: b */
        public Map<String, String> mo17699b() {
            return null;
        }

        @Override // com.amap.api.mapcore.util.AbstractC1075hd
        /* renamed from: c */
        public String mo17697c() {
            return this.f2834b;
        }
    }

    public AbstractC0922dr(int i, int i2) {
        this.f2830a = i;
        this.f2832c = i2;
    }

    /* renamed from: a */
    private byte[] m18478a(String str) {
        try {
            C0923a c0923a = new C0923a(str);
            this.f2831b = C1072hc.m17707a(false);
            return this.f2831b.m17703d(c0923a);
        } catch (Throwable th) {
            Log.e("BaseTileProvider", str);
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public abstract String mo17454a(int i, int i2, int i3);

    @Override // com.amap.api.maps.model.TileProvider
    public final Tile getTile(int i, int i2, int i3) {
        String mo17454a = mo17454a(i, i2, i3);
        if (TextUtils.isEmpty(mo17454a)) {
            return NO_TILE;
        }
        try {
            return new Tile(this.f2830a, this.f2832c, m18478a(mo17454a));
        } catch (IOException e) {
            return NO_TILE;
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileHeight() {
        return this.f2832c;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileWidth() {
        return this.f2830a;
    }
}
