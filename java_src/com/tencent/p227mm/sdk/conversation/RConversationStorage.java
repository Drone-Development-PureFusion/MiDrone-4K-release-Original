package com.tencent.p227mm.sdk.conversation;

import android.content.Context;
import com.tencent.p227mm.sdk.storage.ISQLiteDatabase;
import com.tencent.p227mm.sdk.storage.MAutoStorage;
/* renamed from: com.tencent.mm.sdk.conversation.RConversationStorage */
/* loaded from: classes.dex */
public class RConversationStorage extends MAutoStorage<RConversation> {
    public static final String AUTHORITY = "com.tencent.mm.sdk.conversation.provider";
    public static final String PRIMARY_KEY = "username";
    public static final String TABLE = "rconversation";

    private RConversationStorage(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase);
    }

    public static RConversationStorage create(Context context) {
        return new RConversationStorage(new RConversationDB(context));
    }

    public RConversation get(String str) {
        RConversation rConversation = new RConversation();
        rConversation.field_username = str;
        if (!super.get((RConversationStorage) rConversation, "username")) {
            return null;
        }
        return rConversation;
    }

    @Override // com.tencent.p227mm.sdk.storage.MAutoStorage
    public String[] getColumns() {
        return RConversation.COLUMNS;
    }

    @Override // com.tencent.p227mm.sdk.storage.MAutoStorage
    public String getPrimaryKey() {
        return "username";
    }

    @Override // com.tencent.p227mm.sdk.storage.MAutoStorage
    public String getTableName() {
        return TABLE;
    }
}
