package com.fimi.soul.entity;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CommadBean implements Serializable {
    private String data;
    private String name;
    private String type;

    public String getData() {
        return this.data;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
