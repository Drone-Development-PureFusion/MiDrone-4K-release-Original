package com.fimi.soul.biz.camera.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class X11FileSystem {
    private X11FileInfo curDownloadFile;
    private String curPath;
    private X11FileInfo curUploadFile;
    private long curUploadFileOffset;
    private long curDownloadOffset = 0;
    private List<X11FileInfo> infos = null;
    private Map<String, List<X11FileInfo>> fileList = new HashMap();

    public List<X11FileInfo> getCurDirFileList() {
        List<X11FileInfo> list = null;
        if (this.curPath != null) {
            list = getFileList().get(this.curPath);
        }
        return (this.infos == null || this.infos.size() <= 0) ? list == null ? new ArrayList() : list : this.infos;
    }

    public X11FileInfo getCurDownloadFile() {
        return this.curDownloadFile;
    }

    public long getCurDownloadOffset() {
        return this.curDownloadOffset;
    }

    public String getCurPath() {
        return this.curPath;
    }

    public X11FileInfo getCurUploadFile() {
        return this.curUploadFile;
    }

    public long getCurUploadFileOffset() {
        return this.curUploadFileOffset;
    }

    public Map<String, List<X11FileInfo>> getFileList() {
        return this.fileList;
    }

    public List<X11FileInfo> getInfos() {
        return this.infos;
    }

    public void setCurDownloadFile(X11FileInfo x11FileInfo) {
        this.curDownloadFile = x11FileInfo;
    }

    public void setCurDownloadOffset(long j) {
        this.curDownloadOffset = j;
    }

    public void setCurPath(String str) {
        this.curPath = str;
    }

    public void setCurUploadFile(X11FileInfo x11FileInfo) {
        this.curUploadFile = x11FileInfo;
    }

    public void setCurUploadFileOffset(long j) {
        this.curUploadFileOffset = j;
    }

    public void setInfos(List<X11FileInfo> list) {
        this.infos = list;
    }
}
