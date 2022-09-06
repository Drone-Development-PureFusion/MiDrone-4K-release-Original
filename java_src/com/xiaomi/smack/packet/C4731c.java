package com.xiaomi.smack.packet;

import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import com.xiaomi.smack.util.C4746d;
/* renamed from: com.xiaomi.smack.packet.c */
/* loaded from: classes.dex */
public class C4731c extends AbstractC4732d {

    /* renamed from: c */
    private String f19425c;

    /* renamed from: d */
    private String f19426d;

    /* renamed from: e */
    private String f19427e;

    /* renamed from: f */
    private String f19428f;

    /* renamed from: g */
    private String f19429g;

    /* renamed from: h */
    private String f19430h;

    /* renamed from: i */
    private boolean f19431i;

    /* renamed from: j */
    private String f19432j;

    /* renamed from: k */
    private String f19433k;

    /* renamed from: l */
    private String f19434l;

    /* renamed from: m */
    private String f19435m;

    /* renamed from: n */
    private String f19436n;

    /* renamed from: o */
    private boolean f19437o;

    public C4731c() {
        this.f19425c = null;
        this.f19426d = null;
        this.f19431i = false;
        this.f19433k = "";
        this.f19434l = "";
        this.f19435m = "";
        this.f19436n = "";
        this.f19437o = false;
    }

    public C4731c(Bundle bundle) {
        super(bundle);
        this.f19425c = null;
        this.f19426d = null;
        this.f19431i = false;
        this.f19433k = "";
        this.f19434l = "";
        this.f19435m = "";
        this.f19436n = "";
        this.f19437o = false;
        this.f19425c = bundle.getString("ext_msg_type");
        this.f19427e = bundle.getString("ext_msg_lang");
        this.f19426d = bundle.getString("ext_msg_thread");
        this.f19428f = bundle.getString("ext_msg_sub");
        this.f19429g = bundle.getString("ext_msg_body");
        this.f19430h = bundle.getString("ext_body_encode");
        this.f19432j = bundle.getString("ext_msg_appid");
        this.f19431i = bundle.getBoolean("ext_msg_trans", false);
        this.f19437o = bundle.getBoolean("ext_msg_encrypt", false);
        this.f19433k = bundle.getString("ext_msg_seq");
        this.f19434l = bundle.getString("ext_msg_mseq");
        this.f19435m = bundle.getString("ext_msg_fseq");
        this.f19436n = bundle.getString("ext_msg_status");
    }

    /* renamed from: a */
    public String m3910a() {
        return this.f19425c;
    }

    /* renamed from: a */
    public void m3909a(String str) {
        this.f19432j = str;
    }

    /* renamed from: a */
    public void m3908a(String str, String str2) {
        this.f19429g = str;
        this.f19430h = str2;
    }

    /* renamed from: a */
    public void m3907a(boolean z) {
        this.f19431i = z;
    }

    @Override // com.xiaomi.smack.packet.AbstractC4732d
    /* renamed from: b */
    public Bundle mo3863b() {
        Bundle mo3863b = super.mo3863b();
        if (!TextUtils.isEmpty(this.f19425c)) {
            mo3863b.putString("ext_msg_type", this.f19425c);
        }
        if (this.f19427e != null) {
            mo3863b.putString("ext_msg_lang", this.f19427e);
        }
        if (this.f19428f != null) {
            mo3863b.putString("ext_msg_sub", this.f19428f);
        }
        if (this.f19429g != null) {
            mo3863b.putString("ext_msg_body", this.f19429g);
        }
        if (!TextUtils.isEmpty(this.f19430h)) {
            mo3863b.putString("ext_body_encode", this.f19430h);
        }
        if (this.f19426d != null) {
            mo3863b.putString("ext_msg_thread", this.f19426d);
        }
        if (this.f19432j != null) {
            mo3863b.putString("ext_msg_appid", this.f19432j);
        }
        if (this.f19431i) {
            mo3863b.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.f19433k)) {
            mo3863b.putString("ext_msg_seq", this.f19433k);
        }
        if (!TextUtils.isEmpty(this.f19434l)) {
            mo3863b.putString("ext_msg_mseq", this.f19434l);
        }
        if (!TextUtils.isEmpty(this.f19435m)) {
            mo3863b.putString("ext_msg_fseq", this.f19435m);
        }
        if (this.f19437o) {
            mo3863b.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.f19436n)) {
            mo3863b.putString("ext_msg_status", this.f19436n);
        }
        return mo3863b;
    }

    /* renamed from: b */
    public void m3906b(String str) {
        this.f19433k = str;
    }

    /* renamed from: b */
    public void m3905b(boolean z) {
        this.f19437o = z;
    }

    @Override // com.xiaomi.smack.packet.AbstractC4732d
    /* renamed from: c */
    public String mo3862c() {
        C4738h p;
        StringBuilder sb = new StringBuilder();
        sb.append("<message");
        if (t() != null) {
            sb.append(" xmlns=\"").append(t()).append("\"");
        }
        if (this.f19427e != null) {
            sb.append(" xml:lang=\"").append(m3893i()).append("\"");
        }
        if (k() != null) {
            sb.append(" id=\"").append(k()).append("\"");
        }
        if (m() != null) {
            sb.append(" to=\"").append(C4746d.m3838a(m())).append("\"");
        }
        if (!TextUtils.isEmpty(m3901e())) {
            sb.append(" seq=\"").append(m3901e()).append("\"");
        }
        if (!TextUtils.isEmpty(m3899f())) {
            sb.append(" mseq=\"").append(m3899f()).append("\"");
        }
        if (!TextUtils.isEmpty(m3897g())) {
            sb.append(" fseq=\"").append(m3897g()).append("\"");
        }
        if (!TextUtils.isEmpty(m3895h())) {
            sb.append(" status=\"").append(m3895h()).append("\"");
        }
        if (n() != null) {
            sb.append(" from=\"").append(C4746d.m3838a(n())).append("\"");
        }
        if (l() != null) {
            sb.append(" chid=\"").append(C4746d.m3838a(l())).append("\"");
        }
        if (this.f19431i) {
            sb.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.f19432j)) {
            sb.append(" appid=\"").append(m3903d()).append("\"");
        }
        if (!TextUtils.isEmpty(this.f19425c)) {
            sb.append(" type=\"").append(this.f19425c).append("\"");
        }
        if (this.f19437o) {
            sb.append(" s=\"1\"");
        }
        sb.append(">");
        if (this.f19428f != null) {
            sb.append("<subject>").append(C4746d.m3838a(this.f19428f));
            sb.append("</subject>");
        }
        if (this.f19429g != null) {
            sb.append("<body");
            if (!TextUtils.isEmpty(this.f19430h)) {
                sb.append(" encode=\"").append(this.f19430h).append("\"");
            }
            sb.append(">").append(C4746d.m3838a(this.f19429g)).append("</body>");
        }
        if (this.f19426d != null) {
            sb.append("<thread>").append(this.f19426d).append("</thread>");
        }
        if (XiaomiOAuthConstants.EXTRA_ERROR_CODE_2.equalsIgnoreCase(this.f19425c) && (p = p()) != null) {
            sb.append(p.m3859b());
        }
        sb.append(s());
        sb.append("</message>");
        return sb.toString();
    }

    /* renamed from: c */
    public void m3904c(String str) {
        this.f19434l = str;
    }

    /* renamed from: d */
    public String m3903d() {
        return this.f19432j;
    }

    /* renamed from: d */
    public void m3902d(String str) {
        this.f19435m = str;
    }

    /* renamed from: e */
    public String m3901e() {
        return this.f19433k;
    }

    /* renamed from: e */
    public void m3900e(String str) {
        this.f19436n = str;
    }

    @Override // com.xiaomi.smack.packet.AbstractC4732d
    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C4731c c4731c = (C4731c) obj;
        if (!super.equals(c4731c)) {
            return false;
        }
        if (this.f19429g != null) {
            if (!this.f19429g.equals(c4731c.f19429g)) {
                return false;
            }
        } else if (c4731c.f19429g != null) {
            return false;
        }
        if (this.f19427e != null) {
            if (!this.f19427e.equals(c4731c.f19427e)) {
                return false;
            }
        } else if (c4731c.f19427e != null) {
            return false;
        }
        if (this.f19428f != null) {
            if (!this.f19428f.equals(c4731c.f19428f)) {
                return false;
            }
        } else if (c4731c.f19428f != null) {
            return false;
        }
        if (this.f19426d != null) {
            if (!this.f19426d.equals(c4731c.f19426d)) {
                return false;
            }
        } else if (c4731c.f19426d != null) {
            return false;
        }
        if (this.f19425c != c4731c.f19425c) {
            z = false;
        }
        return z;
    }

    /* renamed from: f */
    public String m3899f() {
        return this.f19434l;
    }

    /* renamed from: f */
    public void m3898f(String str) {
        this.f19425c = str;
    }

    /* renamed from: g */
    public String m3897g() {
        return this.f19435m;
    }

    /* renamed from: g */
    public void m3896g(String str) {
        this.f19428f = str;
    }

    /* renamed from: h */
    public String m3895h() {
        return this.f19436n;
    }

    /* renamed from: h */
    public void m3894h(String str) {
        this.f19429g = str;
    }

    @Override // com.xiaomi.smack.packet.AbstractC4732d
    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f19427e != null ? this.f19427e.hashCode() : 0) + (((this.f19426d != null ? this.f19426d.hashCode() : 0) + (((this.f19429g != null ? this.f19429g.hashCode() : 0) + ((this.f19425c != null ? this.f19425c.hashCode() : 0) * 31)) * 31)) * 31)) * 31;
        if (this.f19428f != null) {
            i = this.f19428f.hashCode();
        }
        return hashCode + i;
    }

    /* renamed from: i */
    public String m3893i() {
        return this.f19427e;
    }

    /* renamed from: i */
    public void m3892i(String str) {
        this.f19426d = str;
    }

    /* renamed from: j */
    public void m3891j(String str) {
        this.f19427e = str;
    }
}
