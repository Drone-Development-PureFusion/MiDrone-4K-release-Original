package com.baidu.tts.database;

import com.baidu.tts.tools.SqlTool;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
/* loaded from: classes.dex */
public class FsFileInfoTable {

    /* loaded from: classes.dex */
    public enum Field {
        ABS_PATH("absPath", "varchar primary key"),
        STATE(XiaomiOAuthConstants.EXTRA_STATE_2, "integer");
        

        /* renamed from: c */
        private final String f5931c;

        /* renamed from: d */
        private final String f5932d;

        Field(String str, String str2) {
            this.f5931c = str;
            this.f5932d = str2;
        }

        public String getColumnName() {
            return this.f5931c;
        }

        public String getDataType() {
            return this.f5932d;
        }
    }

    /* renamed from: a */
    public static String m14933a() {
        return SqlTool.sqlCreateTable("fsFileInfo", Field.values());
    }

    /* renamed from: b */
    public static String m14932b() {
        return SqlTool.sqlDropTable("fsFileInfo");
    }
}
