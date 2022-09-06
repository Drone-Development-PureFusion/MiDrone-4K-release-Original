package com.tencent.p227mm.sdk.storage;

import android.content.ContentValues;
import android.database.Cursor;
/* renamed from: com.tencent.mm.sdk.storage.MDBItem */
/* loaded from: classes2.dex */
public interface MDBItem {
    void convertFrom(Cursor cursor);

    ContentValues convertTo();
}
