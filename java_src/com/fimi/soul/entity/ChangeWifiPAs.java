package com.fimi.soul.entity;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ChangeWifiPAs implements Serializable {
    private CommadBean command;
    private Fwap fwdap;

    public CommadBean getmCommadBean() {
        return this.command;
    }

    public Fwap getmFwap() {
        return this.fwdap;
    }

    public void setmCommadBean(CommadBean commadBean) {
        this.command = commadBean;
    }

    public void setmFwap(Fwap fwap) {
        this.fwdap = fwap;
    }
}
