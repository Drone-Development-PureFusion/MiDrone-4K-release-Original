package com.tencent.p227mm.sdk.contact;

import android.content.Context;
import android.net.Uri;
import com.tencent.p227mm.sdk.storage.ContentProviderDB;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.tencent.mm.sdk.contact.RContactDB */
/* loaded from: classes.dex */
public class RContactDB extends ContentProviderDB<RContactDB> {

    /* renamed from: O */
    private static final Map<String, Uri> f17783O;

    static {
        HashMap hashMap = new HashMap();
        f17783O = hashMap;
        hashMap.put(RContactStorage.TABLE, Uri.parse("content://com.tencent.mm.sdk.contact.provider/rcontact"));
    }

    public RContactDB(Context context) {
        super(context);
    }

    @Override // com.tencent.p227mm.sdk.storage.ContentProviderDB
    public Uri getUriFromTable(String str) {
        return f17783O.get(str);
    }
}
