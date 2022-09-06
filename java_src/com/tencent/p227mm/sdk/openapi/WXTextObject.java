package com.tencent.p227mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.p227mm.sdk.openapi.WXMediaMessage;
import com.tencent.p227mm.sdk.platformtools.Log;
/* renamed from: com.tencent.mm.sdk.openapi.WXTextObject */
/* loaded from: classes.dex */
public class WXTextObject implements WXMediaMessage.IMediaObject {
    public String text;

    public WXTextObject() {
        this(null);
    }

    public WXTextObject(String str) {
        this.text = str;
    }

    @Override // com.tencent.p227mm.sdk.openapi.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        if (this.text == null || this.text.length() == 0 || this.text.length() > 10240) {
            Log.m5647e("MicroMsg.SDK.WXTextObject", "checkArgs fail, text is invalid");
            return false;
        }
        return true;
    }

    @Override // com.tencent.p227mm.sdk.openapi.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString("_wxtextobject_text", this.text);
    }

    @Override // com.tencent.p227mm.sdk.openapi.WXMediaMessage.IMediaObject
    public int type() {
        return 1;
    }

    @Override // com.tencent.p227mm.sdk.openapi.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.text = bundle.getString("_wxtextobject_text");
    }
}
