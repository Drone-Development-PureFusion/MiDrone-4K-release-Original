package com.tencent.p227mm.sdk.conversation;

import android.content.Context;
import android.net.Uri;
import com.tencent.p227mm.sdk.storage.ContentProviderDB;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.tencent.mm.sdk.conversation.RConversationDB */
/* loaded from: classes.dex */
public class RConversationDB extends ContentProviderDB<RConversationDB> {

    /* renamed from: O */
    private static final Map<String, Uri> f17785O;

    static {
        HashMap hashMap = new HashMap();
        f17785O = hashMap;
        hashMap.put(RConversationStorage.TABLE, Uri.parse("content://com.tencent.mm.sdk.conversation.provider/rconversation"));
    }

    public RConversationDB(Context context) {
        super(context);
    }

    @Override // com.tencent.p227mm.sdk.storage.ContentProviderDB
    public Uri getUriFromTable(String str) {
        return f17785O.get(str);
    }
}
