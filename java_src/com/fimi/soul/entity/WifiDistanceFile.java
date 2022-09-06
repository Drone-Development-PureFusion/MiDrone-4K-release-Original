package com.fimi.soul.entity;

import com.fimi.kernel.p157b.p159b.C2196b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class WifiDistanceFile implements Serializable {
    public static final int FILE_TYPE_DIR = 0;
    public static final int FILE_TYPE_IMAGE = 1;
    public static final int FILE_TYPE_UNKNOW_FILE = -1;
    public static final int FILE_TYPE_VIDEO = 2;
    public static final int FILE_TYPE_VOICE = 3;
    private static final long serialVersionUID = 1;
    private String absolutePath;
    private String dateString;
    C2196b downloadTaskInfo;
    private String durationString;
    private boolean isDir;
    private String localDownloadCachePath;
    private String localThumbnailPath;
    private String name;
    private WifiDistanceFile parentDir;
    private String parentStrDir;
    private String realPath;
    private String remoteThmUrl;
    private String remoteUrl;
    private long size;
    private Object tag;
    private int type;
    private String path = "/";
    private List<WifiDistanceFile> mFiles = new ArrayList();

    public WifiDistanceFile(String str) {
        this.name = str;
        this.type = getFileType(str);
    }

    public static int getFileType(String str) {
        if (str != null) {
            int lastIndexOf = str.lastIndexOf(".");
            if (lastIndexOf < 0) {
                return 0;
            }
            String substring = str.substring(lastIndexOf + 1);
            if ("jpg".equals(substring.toLowerCase())) {
                return 1;
            }
            if ("mp4".equals(substring.toLowerCase())) {
                return 2;
            }
            if ("mp3".equals(substring.toLowerCase())) {
                return 3;
            }
        }
        return -1;
    }

    public void addFile(WifiDistanceFile wifiDistanceFile) {
        wifiDistanceFile.setParentStrDir(getPath());
        this.mFiles.add(wifiDistanceFile);
    }

    public String getAbsolutePath() {
        return this.absolutePath;
    }

    public String getDateString() {
        return this.dateString;
    }

    public C2196b getDownloadTaskInfo() {
        return this.downloadTaskInfo;
    }

    public String getDurationString() {
        return this.durationString;
    }

    public String getLocalDownloadCachePath() {
        return this.localDownloadCachePath;
    }

    public String getLocalThumbnailPath() {
        return this.localThumbnailPath;
    }

    public String getName() {
        return this.name;
    }

    public WifiDistanceFile getParentDir() {
        return this.parentDir;
    }

    public String getParentStrDir() {
        return this.parentStrDir;
    }

    public String getPath() {
        return this.path;
    }

    public String getRealPath() {
        return this.realPath;
    }

    public String getRemoteThmUrl() {
        return this.remoteThmUrl;
    }

    public String getRemoteUrl() {
        return this.remoteUrl;
    }

    public long getSize() {
        return this.size;
    }

    public Object getTag() {
        return this.tag;
    }

    public int getType() {
        return this.type;
    }

    public List<WifiDistanceFile> getWifDistanceDir() {
        return this.mFiles;
    }

    public boolean isDir() {
        return this.type == 0;
    }

    public void setAbsolutePath(String str) {
        this.absolutePath = str;
    }

    public void setDateString(String str) {
        this.dateString = str;
    }

    public void setDownloadTaskInfo(C2196b c2196b) {
        this.downloadTaskInfo = c2196b;
    }

    public void setDurationString(String str) {
        this.durationString = str;
    }

    public void setLocalDownloadCachePath(String str) {
        this.localDownloadCachePath = str;
    }

    public void setLocalThumbnailPath(String str) {
        this.localThumbnailPath = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setParentDir(WifiDistanceFile wifiDistanceFile) {
        this.parentDir = wifiDistanceFile;
    }

    public void setParentStrDir(String str) {
        this.parentStrDir = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setRealPath(String str) {
        this.realPath = str;
    }

    public void setRemoteThmUrl(String str) {
        this.remoteThmUrl = str;
    }

    public void setRemoteUrl(String str) {
        this.remoteUrl = str;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setWifDistanceDir(List<WifiDistanceFile> list) {
        this.mFiles = list;
    }
}
