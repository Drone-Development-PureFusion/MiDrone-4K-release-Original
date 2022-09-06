package com.tencent.p227mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.p227mm.sdk.openapi.WXMediaMessage;
import com.tencent.p227mm.sdk.platformtools.Log;
/* renamed from: com.tencent.mm.sdk.openapi.GetMessageFromWX */
/* loaded from: classes.dex */
public final class GetMessageFromWX {

    /* renamed from: com.tencent.mm.sdk.openapi.GetMessageFromWX$Req */
    /* loaded from: classes.dex */
    public static class Req extends BaseReq {
        public String username;

        public Req() {
        }

        public Req(Bundle bundle) {
            fromBundle(bundle);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.p227mm.sdk.openapi.BaseReq
        public final boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.p227mm.sdk.openapi.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
        }

        @Override // com.tencent.p227mm.sdk.openapi.BaseReq
        public int getType() {
            return 3;
        }

        @Override // com.tencent.p227mm.sdk.openapi.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
        }
    }

    /* renamed from: com.tencent.mm.sdk.openapi.GetMessageFromWX$Resp */
    /* loaded from: classes.dex */
    public static class Resp extends BaseResp {
        public WXMediaMessage message;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.p227mm.sdk.openapi.BaseResp
        public final boolean checkArgs() {
            if (this.message == null) {
                Log.m5647e("MicroMsg.SDK.GetMessageFromWX.Resp", "checkArgs fail, message is null");
                return false;
            }
            return this.message.checkArgs();
        }

        @Override // com.tencent.p227mm.sdk.openapi.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.message = WXMediaMessage.Builder.fromBundle(bundle);
        }

        @Override // com.tencent.p227mm.sdk.openapi.BaseResp
        public int getType() {
            return 3;
        }

        @Override // com.tencent.p227mm.sdk.openapi.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putAll(WXMediaMessage.Builder.toBundle(this.message));
        }
    }

    private GetMessageFromWX() {
    }
}
