package com.fimi.soul.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SuggestBean implements Serializable {
    private String contact;
    private String content;
    private String email;
    private String model;
    private String userID;
    private String commandCode = "addSuggestion";
    private List<String> list = new ArrayList();

    public String getCommandCode() {
        return this.commandCode;
    }

    public String getContact() {
        return this.contact;
    }

    public String getContent() {
        return this.content;
    }

    public String getEmail() {
        return this.email;
    }

    public List<String> getList() {
        return this.list;
    }

    public String getModel() {
        return this.model;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setCommandCode(String str) {
        this.commandCode = str;
    }

    public void setContact(String str) {
        this.contact = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setUserID(String str) {
        if (str == null || "".equals(str)) {
            this.userID = "0";
        } else {
            this.userID = str;
        }
    }
}
