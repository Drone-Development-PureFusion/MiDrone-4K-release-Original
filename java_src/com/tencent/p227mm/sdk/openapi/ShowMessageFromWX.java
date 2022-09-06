package com.tencent.p227mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.p227mm.sdk.openapi.WXMediaMessage;
/* renamed from: com.tencent.mm.sdk.openapi.ShowMessageFromWX */
/* loaded from: classes.dex */
public class ShowMessageFromWX {

    /* renamed from: com.tencent.mm.sdk.openapi.ShowMessageFromWX$Req */
    /* loaded from: classes.dex */
    public static class Req extends BaseReq {
        public WXMediaMessage message;

        public Req() {
        }

        public Req(Bundle bundle) {
            fromBundle(bundle);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.p227mm.sdk.openapi.BaseReq
        public final boolean checkArgs() {
            if (this.message == null) {
                return false;
            }
            return this.message.checkArgs();
        }

        @Override // com.tencent.p227mm.sdk.openapi.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.message = WXMediaMessage.Builder.fromBundle(bundle);
        }

        @Override // com.tencent.p227mm.sdk.openapi.BaseReq
        public int getType() {
            return 4;
        }

        @Override // com.tencent.p227mm.sdk.openapi.BaseReq
        public void toBundle(Bundle bundle) {
            Bundle bundle2 = WXMediaMessage.Builder.toBundle(this.message);
            super.toBundle(bundle2);
            bundle.putAll(bundle2);
        }
    }

    /* renamed from: com.tencent.mm.sdk.openapi.ShowMessageFromWX$Resp */
    /* loaded from: classes.dex */
    public static class Resp extends BaseResp {
        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.p227mm.sdk.openapi.BaseResp
        public final boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.p227mm.sdk.openapi.BaseResp
        public int getType() {
            return 4;
        }
    }

    private ShowMessageFromWX() {
    }
}
