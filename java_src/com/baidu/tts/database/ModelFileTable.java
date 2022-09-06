package com.baidu.tts.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.client.model.ModelFileInfo;
import com.baidu.tts.database.C1693c;
import com.baidu.tts.tools.SqlTool;
/* loaded from: classes.dex */
public class ModelFileTable {

    /* loaded from: classes.dex */
    public enum Field {
        ID("id", "integer primary key"),
        LENGTH("length", "bigint"),
        MD5("md5", "varchar(32)"),
        NAME("name", "varchar(256) not null default unnamed"),
        ABS_PATH("absPath", "varchar");
        

        /* renamed from: f */
        private final String f5940f;

        /* renamed from: g */
        private final String f5941g;

        Field(String str, String str2) {
            this.f5940f = str;
            this.f5941g = str2;
        }

        public String getColumnName() {
            return this.f5940f;
        }

        public String getDataType() {
            return this.f5941g;
        }
    }

    /* renamed from: a */
    public static int m14929a(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.delete("modelFile", "id=?", new String[]{str});
    }

    /* renamed from: a */
    public static String m14931a() {
        return SqlTool.sqlCreateTable("modelFile", Field.values());
    }

    /* renamed from: a */
    public static void m14930a(SQLiteDatabase sQLiteDatabase, final ModelFileBags modelFileBags) {
        new C1693c(sQLiteDatabase, new C1693c.AbstractC1694a() { // from class: com.baidu.tts.database.ModelFileTable.1
            @Override // com.baidu.tts.database.C1693c.AbstractC1694a
            /* renamed from: a */
            public boolean mo14907a(SQLiteDatabase sQLiteDatabase2) {
                try {
                    SQLiteStatement compileStatement = sQLiteDatabase2.compileStatement("insert into modelFile (id, length, md5, name, absPath) values (?, ?, ?, ?, ?)");
                    for (ModelFileInfo modelFileInfo : ModelFileBags.this.getModelFileInfos()) {
                        String serverid = modelFileInfo.getServerid();
                        String length = modelFileInfo.getLength();
                        String md5 = modelFileInfo.getMd5();
                        String name = modelFileInfo.getName();
                        String absPath = modelFileInfo.getAbsPath();
                        compileStatement.bindString(1, serverid);
                        compileStatement.bindString(2, length);
                        compileStatement.bindString(3, md5);
                        compileStatement.bindString(4, name);
                        compileStatement.bindString(5, absPath);
                        compileStatement.executeInsert();
                    }
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        }).m14908a();
    }

    /* renamed from: b */
    public static String m14928b() {
        return SqlTool.sqlDropTable("modelFile");
    }
}
