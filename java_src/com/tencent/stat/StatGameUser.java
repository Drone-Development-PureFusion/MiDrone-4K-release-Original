package com.tencent.stat;
/* loaded from: classes2.dex */
public class StatGameUser implements Cloneable {

    /* renamed from: a */
    private String f18333a = "";

    /* renamed from: b */
    private String f18334b = "";

    /* renamed from: c */
    private String f18335c = "";

    /* renamed from: clone */
    public StatGameUser m21865clone() {
        try {
            return (StatGameUser) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public String getAccount() {
        return this.f18334b;
    }

    public String getLevel() {
        return this.f18335c;
    }

    public String getWorldName() {
        return this.f18333a;
    }

    public void setAccount(String str) {
        this.f18334b = str;
    }

    public void setLevel(String str) {
        this.f18335c = str;
    }

    public void setWorldName(String str) {
        this.f18333a = str;
    }
}
