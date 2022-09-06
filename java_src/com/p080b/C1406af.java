package com.p080b;

import android.content.ContentValues;
import android.database.Cursor;
import com.p080b.C1407ag;
import com.tencent.open.GameAppOperation;
import java.util.HashMap;
/* renamed from: com.b.af */
/* loaded from: classes.dex */
public class C1406af implements AbstractC1566l<C1407ag> {

    /* renamed from: a */
    private C1407ag f4833a;

    /* renamed from: a */
    public static String m16423a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("sdkname", str);
        return C1565k.m15494a(hashMap);
    }

    /* renamed from: a */
    public static String m16422a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("sdkname", str);
        hashMap.put("dynamicversion", str2);
        return C1565k.m15494a(hashMap);
    }

    /* renamed from: a */
    public static String m16421a(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("filename", str);
        hashMap.put("sdkname", str2);
        hashMap.put("dynamicversion", str4);
        hashMap.put(GameAppOperation.QQFAV_DATALINE_VERSION, str3);
        return C1565k.m15494a(hashMap);
    }

    /* renamed from: b */
    public static String m16419b(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("filename", str);
        return C1565k.m15494a(hashMap);
    }

    /* renamed from: b */
    public static String m16418b(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("sdkname", str);
        hashMap.put("status", str2);
        return C1565k.m15494a(hashMap);
    }

    @Override // com.p080b.AbstractC1566l
    /* renamed from: a */
    public ContentValues mo15451a() {
        if (this.f4833a == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("filename", this.f4833a.m16417a());
        contentValues.put("md5", this.f4833a.m16415b());
        contentValues.put("sdkname", this.f4833a.m16414c());
        contentValues.put(GameAppOperation.QQFAV_DATALINE_VERSION, this.f4833a.m16413d());
        contentValues.put("dynamicversion", this.f4833a.m16412e());
        contentValues.put("status", this.f4833a.m16411f());
        return contentValues;
    }

    @Override // com.p080b.AbstractC1566l
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo15448a(C1407ag c1407ag) {
        this.f4833a = c1407ag;
    }

    @Override // com.p080b.AbstractC1566l
    /* renamed from: b */
    public C1407ag mo15450a(Cursor cursor) {
        String string = cursor.getString(1);
        String string2 = cursor.getString(2);
        String string3 = cursor.getString(3);
        String string4 = cursor.getString(4);
        String string5 = cursor.getString(5);
        return new C1407ag.C1408a(string2, string3, string, string4, string5).m16408a(cursor.getString(6)).m16410a();
    }

    @Override // com.p080b.AbstractC1566l
    /* renamed from: b */
    public String mo15447b() {
        return "file";
    }
}
