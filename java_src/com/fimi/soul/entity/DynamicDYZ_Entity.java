package com.fimi.soul.entity;

import java.io.Serializable;
import p004b.p005a.p006a.p028b.C0359h;
/* loaded from: classes.dex */
public class DynamicDYZ_Entity implements Serializable {
    private double currentVersion;
    private int deviceType = 0;
    private double distance;
    private String encryptKey;
    private String encryptValue;
    private long endDate;
    private String fcIds;

    /* renamed from: id */
    private int f11127id;
    private long insertDate;
    private double latitude;
    private double limitHeight;
    private double limitRadius;
    private double logitude;
    private double noFlyType;
    private double pushType;
    private int radius;
    private String remarks;
    private long startDate;
    private int status;
    private int type;
    private double warinRadius;
    private String whileRange;

    public double getCurrentVersion() {
        return this.currentVersion;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public double getDistance() {
        return this.distance;
    }

    public String getEncryptKey() {
        return this.encryptKey;
    }

    public String getEncryptValue() {
        return this.encryptValue;
    }

    public long getEndDate() {
        return this.endDate;
    }

    public String getFcIds() {
        return this.fcIds;
    }

    public int getId() {
        return this.f11127id;
    }

    public long getInsertDate() {
        return this.insertDate;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLimitHeight() {
        return this.limitHeight;
    }

    public double getLimitRadius() {
        return this.limitRadius;
    }

    public double getLogitude() {
        return this.logitude;
    }

    public double getNoFlyType() {
        return this.noFlyType;
    }

    public double getPushType() {
        return this.pushType;
    }

    public int getRadius() {
        return this.radius;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public long getStartDate() {
        return this.startDate;
    }

    public int getStatus() {
        return this.status;
    }

    public int getType() {
        return this.type;
    }

    public double getWarinRadius() {
        return this.warinRadius;
    }

    public String getWhileRange() {
        return this.whileRange;
    }

    public void setCurrentVersion(double d) {
        this.currentVersion = d;
    }

    public void setDeviceType(int i) {
        this.deviceType = i;
    }

    public void setDistance(double d) {
        this.distance = d;
    }

    public void setEncryptKey(String str) {
        this.encryptKey = str;
    }

    public void setEncryptValue(String str) {
        this.encryptValue = str;
    }

    public void setEndDate(long j) {
        this.endDate = j;
    }

    public void setFcIds(String str) {
        this.fcIds = str;
    }

    public void setId(int i) {
        this.f11127id = i;
    }

    public void setInsertDate(long j) {
        this.insertDate = j;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLimitHeight(double d) {
        this.limitHeight = d;
    }

    public void setLimitRadius(double d) {
        this.limitRadius = d;
    }

    public void setLogitude(double d) {
        this.logitude = d;
    }

    public void setNoFlyType(double d) {
        this.noFlyType = d;
    }

    public void setPushType(double d) {
        this.pushType = d;
    }

    public void setRadius(int i) {
        this.radius = i;
    }

    public void setRemarks(String str) {
        this.remarks = str;
    }

    public void setStartDate(long j) {
        this.startDate = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setWarinRadius(double d) {
        this.warinRadius = d;
    }

    public void setWhileRange(String str) {
        this.whileRange = str;
    }

    public String toString() {
        return "DynamicDYZ_Entity{warinRadius=" + this.warinRadius + ", limitRadius=" + this.limitRadius + ", limitHeight=" + this.limitHeight + ", encryptValue='" + this.encryptValue + C0359h.f729z + ", logitude=" + this.logitude + ", endDate=" + this.endDate + ", latitude=" + this.latitude + ", insertDate=" + this.insertDate + ", id=" + this.f11127id + ", radius=" + this.radius + ", encryptKey='" + this.encryptKey + C0359h.f729z + ", type=" + this.type + ", startDate=" + this.startDate + ", status=" + this.status + ", remarks='" + this.remarks + C0359h.f729z + ", deviceType=" + this.deviceType + ", distance=" + this.distance + ", noFlyType=" + this.noFlyType + ", currentVersion=" + this.currentVersion + ", pushType=" + this.pushType + ", fcIds='" + this.fcIds + C0359h.f729z + ", whileRange='" + this.whileRange + C0359h.f729z + C0359h.f726w;
    }
}
