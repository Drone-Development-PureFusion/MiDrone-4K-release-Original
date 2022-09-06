package com.tencent.open.weiyun;
/* loaded from: classes2.dex */
public class WeiyunFile {

    /* renamed from: a */
    private String f18256a;

    /* renamed from: b */
    private String f18257b;

    /* renamed from: c */
    private String f18258c;

    /* renamed from: d */
    private long f18259d;

    public WeiyunFile(String str, String str2, String str3, long j) {
        this.f18256a = str;
        this.f18257b = str2;
        this.f18258c = str3;
        this.f18259d = j;
    }

    public String getCreateTime() {
        return this.f18258c;
    }

    public String getFileId() {
        return this.f18256a;
    }

    public String getFileName() {
        return this.f18257b;
    }

    public long getFileSize() {
        return this.f18259d;
    }

    public void setCreateTime(String str) {
        this.f18258c = str;
    }

    public void setFileId(String str) {
        this.f18256a = str;
    }

    public void setFileName(String str) {
        this.f18257b = str;
    }

    public void setFileSize(long j) {
        this.f18259d = j;
    }
}
