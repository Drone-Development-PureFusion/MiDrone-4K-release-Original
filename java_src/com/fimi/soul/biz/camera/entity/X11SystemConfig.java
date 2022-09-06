package com.fimi.soul.biz.camera.entity;

import com.fimi.soul.biz.camera.C2427e;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class X11SystemConfig {
    private String SDState;
    public String ae_bias;
    private String appStatus;
    public String awb;
    private int batteryLevel;
    private String cameraTimeLock;
    private int cameraType;
    private String captureMode;
    public String contrast;
    private long cur_time;
    private String image_format;
    private boolean isSaveLowResolution;
    private boolean isTimelapsePhoto;
    private boolean isTimelapseVideo;
    private int maxZoomInfo;
    private int photoFileNumbers;
    private String photoQuality;
    private String photoSize;
    private String photoStamp;
    private String powerSourceType;
    private int ravl;
    private int remainPhotoTakeNumbers;
    private int remainVideoRecordMinutes;
    public String saturation;
    public String sharpness;
    private String streamOutType;
    private String systemType;
    private int totalFileNumbers;
    private int videoFileNumbers;
    private String videoLoopBack;
    private String videoMode;
    private String videoQuality;
    private String videoResolution;
    private String videoSrt;
    private String videoStamp;
    private String videoStandard;
    private long freeKBSpace = 0;
    private long totalKBSpace = 0;
    private int currentZoomInfo = 0;
    private boolean isVideoStamp = false;
    private String dvVersion = null;
    private Map<String, X11SystemConfigOption> systemConfigOptions = new HashMap();
    private X11DeviceInfo x11DeviceInfo = new X11DeviceInfo();

    public String getAe_bias() {
        return this.ae_bias;
    }

    public String getAppStatus() {
        return this.appStatus;
    }

    public String getAwb() {
        return this.awb;
    }

    public int getBatteryLevel() {
        return this.batteryLevel;
    }

    public String getCameraTimeLock() {
        return this.cameraTimeLock;
    }

    public String getCaptureMode() {
        return this.captureMode;
    }

    public String getContrast() {
        return this.contrast;
    }

    public long getCur_time() {
        return this.cur_time;
    }

    public int getCurrentZoomInfo() {
        return this.currentZoomInfo;
    }

    public String getDvVersion() {
        return this.dvVersion;
    }

    public long getFreeKBSpace() {
        return this.freeKBSpace;
    }

    public String getImage_format() {
        return this.image_format;
    }

    public int getMaxZoomInfo() {
        return this.maxZoomInfo;
    }

    public int getPhotoFileNumbers() {
        return this.photoFileNumbers;
    }

    public String getPhotoQuality() {
        return this.photoQuality;
    }

    public String getPhotoSize() {
        return this.photoSize;
    }

    public String getPhotoStamp() {
        return this.photoStamp;
    }

    public String getPowerSourceType() {
        return this.powerSourceType;
    }

    public int getRavl() {
        return this.ravl;
    }

    public int getRemainPhotoTakeNumbers() {
        return this.remainPhotoTakeNumbers;
    }

    public int getRemainVideoRecordMinutes() {
        return this.remainVideoRecordMinutes;
    }

    public String getSDState() {
        return this.SDState;
    }

    public String getSaturation() {
        return this.saturation;
    }

    public String getSharpness() {
        return this.sharpness;
    }

    public String getStreamOutType() {
        return this.streamOutType;
    }

    public Map<String, X11SystemConfigOption> getSystemConfigOptions() {
        return this.systemConfigOptions;
    }

    public String getSystemType() {
        return this.systemType;
    }

    public int getTotalFileNumbers() {
        return this.totalFileNumbers;
    }

    public long getTotalKBSpace() {
        return this.totalKBSpace;
    }

    public int getVideoFileNumbers() {
        return this.videoFileNumbers;
    }

    public String getVideoLoopBack() {
        return this.videoLoopBack;
    }

    public String getVideoMode() {
        return this.videoMode;
    }

    public String getVideoQuality() {
        return this.videoQuality;
    }

    public String getVideoResolution() {
        return this.videoResolution;
    }

    public String getVideoSrt() {
        return this.videoSrt;
    }

    public String getVideoStamp() {
        return this.videoStamp;
    }

    public String getVideoStandard() {
        return this.videoStandard;
    }

    public X11DeviceInfo getX11DeviceInfo() {
        return this.x11DeviceInfo;
    }

    public String getX11DeviceName() {
        return this.x11DeviceInfo != null ? this.x11DeviceInfo.getChip() : C2427e.f8361j;
    }

    public boolean isCamara1080() {
        return this.cameraType != 66;
    }

    public boolean isContinueCaptureMode() {
        return this.captureMode != null && this.captureMode.contains(C2427e.f8313cJ);
    }

    public boolean isPrecisePhotoMode() {
        return this.captureMode != null && this.captureMode.contains(C2427e.f8314cK);
    }

    public boolean isSaveLowResolution() {
        return this.isSaveLowResolution;
    }

    public boolean isTimelapsePhoto() {
        return this.isTimelapsePhoto;
    }

    public boolean isTimelapseVideo() {
        return this.isTimelapseVideo;
    }

    public boolean isVideoStamp() {
        return this.isVideoStamp;
    }

    public void setAe_bias(String str) {
        this.ae_bias = str;
    }

    public void setAppStatus(String str) {
        this.appStatus = str;
    }

    public void setAwb(String str) {
        this.awb = str;
    }

    public void setBatteryLevel(int i) {
        this.batteryLevel = i;
    }

    public void setCameraTimeLock(String str) {
        this.cameraTimeLock = str;
    }

    public void setCameraType(int i) {
        this.cameraType = i;
    }

    public void setCaptureMode(String str) {
        this.captureMode = str;
    }

    public void setContrast(String str) {
        this.contrast = str;
    }

    public void setCur_time(long j) {
        this.cur_time = j;
    }

    public void setCurrentZoomInfo(int i) {
        this.currentZoomInfo = i;
    }

    public void setDvVersion(String str) {
        this.dvVersion = str;
    }

    public void setFreeKBSpace(long j) {
        this.freeKBSpace = j;
    }

    public void setImage_format(String str) {
        this.image_format = str;
    }

    public void setMaxZoomInfo(int i) {
        this.maxZoomInfo = i;
    }

    public void setPhotoFileNumbers(int i) {
        this.photoFileNumbers = i;
    }

    public void setPhotoQuality(String str) {
        this.photoQuality = str;
    }

    public void setPhotoSize(String str) {
        this.photoSize = str;
    }

    public void setPhotoStamp(String str) {
        this.photoStamp = str;
    }

    public void setPowerSourceType(String str) {
        this.powerSourceType = str;
    }

    public void setRavl(int i) {
        this.ravl = i;
    }

    public void setRemainPhotoTakeNumbers(int i) {
        this.remainPhotoTakeNumbers = i;
    }

    public void setRemainVideoRecordMinutes(int i) {
        this.remainVideoRecordMinutes = i;
    }

    public void setSDState(String str) {
        this.SDState = str;
    }

    public void setSaturation(String str) {
        this.saturation = str;
    }

    public void setSaveLowResolution(boolean z) {
        this.isSaveLowResolution = z;
    }

    public void setSharpness(String str) {
        this.sharpness = str;
    }

    public void setStreamOutType(String str) {
        this.streamOutType = str;
    }

    public void setSystemConfigOptions(Map<String, X11SystemConfigOption> map) {
        this.systemConfigOptions = map;
    }

    public void setSystemType(String str) {
        this.systemType = str;
    }

    public void setTimelapsePhoto(boolean z) {
        this.isTimelapsePhoto = z;
    }

    public void setTimelapseVideo(boolean z) {
        this.isTimelapseVideo = z;
    }

    public void setTotalFileNumbers(int i) {
        this.totalFileNumbers = i;
    }

    public void setTotalKBSpace(long j) {
        this.totalKBSpace = j;
    }

    public void setVideoFileNumbers(int i) {
        this.videoFileNumbers = i;
    }

    public void setVideoLoopBack(String str) {
        this.videoLoopBack = str;
    }

    public void setVideoMode(String str) {
        this.videoMode = str;
    }

    public void setVideoQuality(String str) {
        this.videoQuality = str;
    }

    public void setVideoResolution(String str) {
        this.videoResolution = str;
    }

    public void setVideoSrt(String str) {
        this.videoSrt = str;
    }

    public void setVideoStamp(String str) {
        this.videoStamp = str;
    }

    public void setVideoStamp(boolean z) {
        this.isVideoStamp = z;
    }

    public void setVideoStandard(String str) {
        this.videoStandard = str;
    }

    public void setX11DeviceInfo(X11DeviceInfo x11DeviceInfo) {
        this.x11DeviceInfo = x11DeviceInfo;
    }
}
