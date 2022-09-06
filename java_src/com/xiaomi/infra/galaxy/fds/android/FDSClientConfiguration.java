package com.xiaomi.infra.galaxy.fds.android;

import com.xiaomi.infra.galaxy.fds.android.auth.GalaxyFDSCredential;
import com.xiaomi.infra.galaxy.fds.android.util.Args;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class FDSClientConfiguration {
    public static final int DEFAULT_CONNECTION_TIMEOUT_MS = 50000;
    public static final int DEFAULT_MAX_RETRY_TIMES = 3;
    public static final int DEFAULT_SOCKET_TIMEOUT_MS = 50000;
    public static final int DEFAULT_UPLOAD_PART_SIZE = 4096;
    private static final String URI_CDN = "cdn";
    private static final String URI_FDS_SSL_SUFFIX = ".fds-ssl.api.xiaomi.com";
    private static final String URI_FDS_SUFFIX = ".fds.api.xiaomi.com";
    private static final String URI_FILES = "files";
    private static final String URI_HTTPS_PREFIX = "https://";
    private static final String URI_HTTP_PREFIX = "http://";
    private GalaxyFDSCredential credential;
    private int socketTimeoutMs = 50000;
    private int connectionTimeoutMs = 50000;
    private int socketSendBufferSizeHint = 0;
    private int socketReceiveBufferSizeHint = 0;
    private int maxRetryTimes = 3;
    private int uploadPartSize = 4096;
    private String regionName = "";
    private boolean enableHttps = true;
    private boolean enableCdnForUpload = false;
    private boolean enableCdnForDownload = true;
    private boolean enableUnitTestMode = false;
    private String baseUriForUnitTest = "";

    private String getBaseUriPrefix(boolean z, String str) {
        return str.isEmpty() ? z ? URI_CDN : "files" : z ? str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + URI_CDN : str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + "files";
    }

    private String getBaseUriSuffix(boolean z, boolean z2) {
        return (!z || !z2) ? URI_FDS_SUFFIX : URI_FDS_SSL_SUFFIX;
    }

    String buildBaseUri(boolean z) {
        if (this.enableUnitTestMode) {
            return this.baseUriForUnitTest;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.enableHttps ? URI_HTTPS_PREFIX : URI_HTTP_PREFIX);
        sb.append(getBaseUriPrefix(z, this.regionName));
        sb.append(getBaseUriSuffix(z, this.enableHttps));
        return sb.toString();
    }

    public void enableCdnForDownload(boolean z) {
        this.enableCdnForDownload = z;
    }

    public void enableCdnForUpload(boolean z) {
        this.enableCdnForUpload = z;
    }

    public void enableHttps(boolean z) {
        this.enableHttps = z;
    }

    void enableUnitTestMode(boolean z) {
        this.enableUnitTestMode = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getBaseUri() {
        return buildBaseUri(false);
    }

    String getBaseUriForUnitTest() {
        return this.baseUriForUnitTest;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getCdnBaseUri() {
        return buildBaseUri(true);
    }

    @Deprecated
    public String getCdnServiceBaseUri() {
        return getCdnBaseUri();
    }

    public int getConnectionTimeoutMs() {
        return this.connectionTimeoutMs;
    }

    public GalaxyFDSCredential getCredential() {
        return this.credential;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getDownloadBaseUri() {
        return buildBaseUri(this.enableCdnForDownload);
    }

    @Deprecated
    public String getFdsServiceBaseUri() {
        return getBaseUri();
    }

    public int getMaxRetryTimes() {
        return this.maxRetryTimes;
    }

    public String getRegionName() {
        return this.regionName;
    }

    public int[] getSocketBufferSizeHints() {
        return new int[]{this.socketSendBufferSizeHint, this.socketReceiveBufferSizeHint};
    }

    public int getSocketTimeoutMs() {
        return this.socketTimeoutMs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUploadBaseUri() {
        return buildBaseUri(this.enableCdnForUpload);
    }

    public int getUploadPartSize() {
        return this.uploadPartSize;
    }

    public boolean isCdnEnabledForDownload() {
        return this.enableCdnForDownload;
    }

    public boolean isCdnEnabledForUpload() {
        return this.enableCdnForUpload;
    }

    boolean isEnabledUnitTestMode() {
        return this.enableUnitTestMode;
    }

    public boolean isHttpsEnabled() {
        return this.enableHttps;
    }

    void setBaseUriForUnitTest(String str) {
        this.baseUriForUnitTest = str;
    }

    @Deprecated
    public void setCdnServiceBaseUri(String str) {
    }

    public void setConnectionTimeoutMs(int i) {
        this.connectionTimeoutMs = i;
    }

    public void setCredential(GalaxyFDSCredential galaxyFDSCredential) {
        Args.notNull(galaxyFDSCredential, "credential");
        this.credential = galaxyFDSCredential;
    }

    @Deprecated
    public void setFdsServiceBaseUri(String str) {
    }

    public void setMaxRetryTimes(int i) {
        Args.notNegative(i, "max retry times");
        this.maxRetryTimes = i;
    }

    public void setRegionName(String str) {
        this.regionName = str;
    }

    public void setSocketBufferSizeHints(int i, int i2) {
        this.socketSendBufferSizeHint = i;
        this.socketReceiveBufferSizeHint = i2;
    }

    public void setSocketTimeoutMs(int i) {
        this.socketTimeoutMs = i;
    }

    public void setUploadPartSize(int i) {
        Args.positive(i, "upload part size");
        this.uploadPartSize = i;
    }

    FDSClientConfiguration withBaseUriForUnitTest(String str) {
        setBaseUriForUnitTest(str);
        return this;
    }

    public FDSClientConfiguration withCdnForDownload(boolean z) {
        enableCdnForDownload(z);
        return this;
    }

    public FDSClientConfiguration withCdnForUpload(boolean z) {
        enableCdnForUpload(z);
        return this;
    }

    @Deprecated
    public FDSClientConfiguration withCdnServiceBaseUri(String str) {
        return this;
    }

    public FDSClientConfiguration withConnectionTimeoutMs(int i) {
        setConnectionTimeoutMs(i);
        return this;
    }

    public FDSClientConfiguration withCredential(GalaxyFDSCredential galaxyFDSCredential) {
        setCredential(galaxyFDSCredential);
        return this;
    }

    @Deprecated
    public FDSClientConfiguration withFdsServiceBaseUri(String str) {
        return this;
    }

    public FDSClientConfiguration withHttps(boolean z) {
        enableHttps(z);
        return this;
    }

    public FDSClientConfiguration withMaxRetryTimes(int i) {
        setMaxRetryTimes(i);
        return this;
    }

    public FDSClientConfiguration withRegionName(String str) {
        setRegionName(str);
        return this;
    }

    public FDSClientConfiguration withSocketBufferSizeHints(int i, int i2) {
        setSocketBufferSizeHints(i, i2);
        return this;
    }

    public FDSClientConfiguration withSocketTimeoutMs(int i) {
        setSocketTimeoutMs(i);
        return this;
    }

    FDSClientConfiguration withUnitTestMode(boolean z) {
        enableUnitTestMode(z);
        return this;
    }

    public FDSClientConfiguration withUploadPartSize(int i) {
        setUploadPartSize(i);
        return this;
    }
}
