package com.tencent.open.web.security;

import com.tencent.open.C4315a;
import com.tencent.open.p228a.C4331f;
/* loaded from: classes2.dex */
public class SecureJsInterface extends C4315a.C4317b {

    /* renamed from: a */
    private static final String f18234a = C4331f.f18119d + ".SI";
    public static boolean isPWDEdit = false;

    /* renamed from: b */
    private String f18235b;

    public void clearAllEdit() {
        C4331f.m5442c(f18234a, "-->clear all edit.");
        try {
            JniInterface.clearAllPWD();
        } catch (Exception e) {
            C4331f.m5439e(f18234a, "-->clear all edit exception: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void curPosFromJS(String str) {
        C4331f.m5442c(f18234a, "-->curPosFromJS: " + str);
        int i = -1;
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            C4331f.m5439e(f18234a, "-->curPosFromJS number format exception.");
        }
        if (i < 0) {
            throw new RuntimeException("position is illegal.");
        }
        if (!C4365a.f18238c) {
        }
        if (C4365a.f18237b) {
            if (!Boolean.valueOf(JniInterface.BackSpaceChar(C4365a.f18237b, i)).booleanValue()) {
                return;
            }
            C4365a.f18237b = false;
            return;
        }
        this.f18235b = C4365a.f18236a;
        JniInterface.insetTextToArray(i, this.f18235b, this.f18235b.length());
        C4331f.m5445b(f18234a, "mKey: " + this.f18235b);
    }

    @Override // com.tencent.open.C4315a.C4317b
    public boolean customCallback() {
        return true;
    }

    public String getMD5FromNative() {
        C4331f.m5442c(f18234a, "-->get md5 form native");
        try {
            String pWDKeyToMD5 = JniInterface.getPWDKeyToMD5(null);
            C4331f.m5445b(f18234a, "-->getMD5FromNative, MD5= " + pWDKeyToMD5);
            return pWDKeyToMD5;
        } catch (Exception e) {
            C4331f.m5439e(f18234a, "-->get md5 form native exception: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void isPasswordEdit(String str) {
        C4331f.m5442c(f18234a, "-->is pswd edit, flag: " + str);
        int i = -1;
        try {
            i = Integer.parseInt(str);
        } catch (Exception e) {
            C4331f.m5439e(f18234a, "-->is pswd edit exception: " + e.getMessage());
        }
        if (i == 0 || i == 1) {
            if (i == 0) {
                isPWDEdit = false;
                return;
            } else if (i != 1) {
                return;
            } else {
                isPWDEdit = true;
                return;
            }
        }
        throw new RuntimeException("is pswd edit flag is illegal.");
    }
}
