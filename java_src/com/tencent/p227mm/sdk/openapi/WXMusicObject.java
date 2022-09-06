package com.tencent.p227mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.p227mm.sdk.openapi.WXMediaMessage;
import com.tencent.p227mm.sdk.platformtools.Log;
/* renamed from: com.tencent.mm.sdk.openapi.WXMusicObject */
/* loaded from: classes.dex */
public class WXMusicObject implements WXMediaMessage.IMediaObject {
    public String musicLowBandUrl;
    public String musicUrl;

    @Override // com.tencent.p227mm.sdk.openapi.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        if ((this.musicUrl == null || this.musicUrl.length() == 0) && (this.musicLowBandUrl == null || this.musicLowBandUrl.length() == 0)) {
            Log.m5647e("MicroMsg.SDK.WXMusicObject", "both arguments are null");
            return false;
        } else if (this.musicUrl != null && this.musicUrl.length() > 10240) {
            Log.m5647e("MicroMsg.SDK.WXMusicObject", "checkArgs fail, musicUrl is too long");
            return false;
        } else if (this.musicLowBandUrl == null || this.musicLowBandUrl.length() <= 10240) {
            return true;
        } else {
            Log.m5647e("MicroMsg.SDK.WXMusicObject", "checkArgs fail, musicLowBandUrl is too long");
            return false;
        }
    }

    @Override // com.tencent.p227mm.sdk.openapi.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString("_wxmusicobject_musicUrl", this.musicUrl);
        bundle.putString("_wxmusicobject_musicLowBandUrl", this.musicLowBandUrl);
    }

    @Override // com.tencent.p227mm.sdk.openapi.WXMediaMessage.IMediaObject
    public int type() {
        return 3;
    }

    @Override // com.tencent.p227mm.sdk.openapi.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.musicUrl = bundle.getString("_wxmusicobject_musicUrl");
        this.musicLowBandUrl = bundle.getString("_wxmusicobject_musicLowBandUrl");
    }
}
