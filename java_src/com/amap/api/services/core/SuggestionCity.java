package com.amap.api.services.core;
/* loaded from: classes.dex */
public class SuggestionCity {

    /* renamed from: a */
    private String f3974a;

    /* renamed from: b */
    private String f3975b;

    /* renamed from: c */
    private String f3976c;

    /* renamed from: d */
    private int f3977d;

    protected SuggestionCity() {
    }

    public SuggestionCity(String str, String str2, String str3, int i) {
        this.f3974a = str;
        this.f3975b = str2;
        this.f3976c = str3;
        this.f3977d = i;
    }

    public String getAdCode() {
        return this.f3976c;
    }

    public String getCityCode() {
        return this.f3975b;
    }

    public String getCityName() {
        return this.f3974a;
    }

    public int getSuggestionNum() {
        return this.f3977d;
    }

    public void setAdCode(String str) {
        this.f3976c = str;
    }

    public void setCityCode(String str) {
        this.f3975b = str;
    }

    public void setCityName(String str) {
        this.f3974a = str;
    }

    public void setSuggestionNum(int i) {
        this.f3977d = i;
    }
}
