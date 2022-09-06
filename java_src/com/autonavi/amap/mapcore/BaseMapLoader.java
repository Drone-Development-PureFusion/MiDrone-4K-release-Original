package com.autonavi.amap.mapcore;

import android.text.TextUtils;
import com.amap.api.mapcore.util.C0993ff;
import com.fimi.kernel.p157b.p161d.C2227d;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;
/* loaded from: classes.dex */
public abstract class BaseMapLoader {
    long createtime;
    MapCore mGLMapEngine;
    BaseMapCallImplement mMapCallback;
    long m_reqestStartLen;
    int mapLevel;
    byte[] recievedDataBuffer;
    public ArrayList<MapSourceGridData> mapTiles = new ArrayList<>();
    int recievedDataSize = 0;
    int nextImgDataLength = 0;
    boolean recievedHeader = false;
    int mCapaticy = 30720;
    int mCapaticyExt = C2227d.f7442b;
    volatile boolean inRequest = false;
    volatile boolean isFinished = false;
    volatile boolean mCanceled = false;
    int datasource = 0;
    public HttpURLConnection httpURLConnection = null;

    private synchronized void onConnectionOver() {
        int i = 0;
        synchronized (this) {
            processRecivedVersionOrScenicWidgetData();
            this.recievedDataBuffer = null;
            this.nextImgDataLength = 0;
            this.recievedDataSize = 0;
            while (true) {
                try {
                    int i2 = i;
                    if (i2 >= this.mapTiles.size()) {
                        break;
                    }
                    this.mMapCallback.tileProcessCtrl.removeTile(this.mapTiles.get(i2).keyGridName);
                    i = i2 + 1;
                } catch (Throwable th) {
                }
            }
            this.isFinished = true;
        }
    }

    private void onConnectionRecieveData(byte[] bArr, int i) {
        if (this.mCapaticy < this.recievedDataSize + i) {
            try {
                this.mCapaticy += this.mCapaticyExt;
                byte[] bArr2 = new byte[this.mCapaticy];
                System.arraycopy(this.recievedDataBuffer, 0, bArr2, 0, this.recievedDataSize);
                this.recievedDataBuffer = bArr2;
            } catch (OutOfMemoryError e) {
                doCancel();
                return;
            }
        }
        try {
            System.arraycopy(bArr, 0, this.recievedDataBuffer, this.recievedDataSize, i);
            this.recievedDataSize += i;
            if (isNeedProcessReturn()) {
                return;
            }
            if (!this.recievedHeader && !processReceivedDataHeader(i)) {
                return;
            }
            processRecivedDataByType();
        } catch (ArrayIndexOutOfBoundsException e2) {
            doCancel();
        } catch (Exception e3) {
            doCancel();
        }
    }

    public void OnException(int i) {
        privteTestTime("", " network error:" + i);
        this.isFinished = true;
        if (this.datasource == 6 || this.datasource == 4 || this.datasource == 1 || this.mCanceled) {
        }
        this.isFinished = true;
    }

    public void addReuqestTiles(MapSourceGridData mapSourceGridData) {
        this.mapTiles.add(mapSourceGridData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean containllegal(String str) {
        return str.contains("<") || str.contains("[");
    }

    public synchronized void doCancel() {
        if (!this.mCanceled && !this.isFinished) {
            this.mCanceled = true;
            if (this.httpURLConnection != null && this.inRequest) {
                this.httpURLConnection.disconnect();
            }
            onConnectionOver();
            this.mMapCallback = null;
            this.mGLMapEngine = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00a0, code lost:
        throw new java.lang.InterruptedException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doRequest() {
        InputStream inputStream;
        if (this.mCanceled || this.isFinished) {
            return;
        }
        if (!isRequestValid()) {
            doCancel();
            return;
        }
        String mapAddress = getMapAddress();
        String mapSvrPath = getMapSvrPath();
        if (mapSvrPath == null || mapSvrPath.length() == 0 || mapAddress == null) {
            return;
        }
        InputStream inputStream2 = null;
        String gridParma = getGridParma();
        if (TextUtils.isEmpty(gridParma)) {
            return;
        }
        this.inRequest = true;
        try {
            try {
                Proxy m18085a = C0993ff.m18085a(this.mMapCallback.getContext());
                String url = getURL(mapAddress, mapSvrPath, gridParma);
                if (m18085a != null) {
                    this.httpURLConnection = (HttpURLConnection) new URL(url).openConnection(m18085a);
                } else {
                    this.httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
                }
                if (this.httpURLConnection != null) {
                    this.httpURLConnection.setConnectTimeout(20000);
                    this.httpURLConnection.setRequestMethod("GET");
                    this.httpURLConnection.connect();
                    if (this.httpURLConnection.getResponseCode() == 200) {
                        inputStream = this.httpURLConnection.getInputStream();
                        try {
                            onConnectionOpened();
                            byte[] bArr = new byte[512];
                            boolean z = true;
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read <= -1) {
                                    break;
                                }
                                if (z) {
                                    privteTestTime("recievedFirstByte:", "");
                                    z = false;
                                }
                                Thread.currentThread();
                                if (Thread.interrupted()) {
                                    break;
                                } else if (this.mCanceled) {
                                    break;
                                } else {
                                    onConnectionRecieveData(bArr, read);
                                }
                            }
                            onConnectionOver();
                            if (inputStream == null || this.mCanceled) {
                            }
                            try {
                                inputStream.close();
                                return;
                            } catch (IOException e) {
                                OnException(1002);
                                return;
                            }
                        } catch (IOException e2) {
                            inputStream2 = inputStream;
                            OnException(1002);
                            onConnectionOver();
                            if (inputStream2 == null || this.mCanceled) {
                                return;
                            }
                            try {
                                inputStream2.close();
                                return;
                            } catch (IOException e3) {
                                OnException(1002);
                                return;
                            }
                        } catch (IllegalArgumentException e4) {
                            inputStream2 = inputStream;
                            onConnectionOver();
                            if (inputStream2 == null || this.mCanceled) {
                                return;
                            }
                            try {
                                inputStream2.close();
                                return;
                            } catch (IOException e5) {
                                OnException(1002);
                                return;
                            }
                        } catch (IllegalStateException e6) {
                            inputStream2 = inputStream;
                            onConnectionOver();
                            if (inputStream2 == null || this.mCanceled) {
                                return;
                            }
                            try {
                                inputStream2.close();
                                return;
                            } catch (IOException e7) {
                                OnException(1002);
                                return;
                            }
                        } catch (NullPointerException e8) {
                            inputStream2 = inputStream;
                            onConnectionOver();
                            if (inputStream2 == null || this.mCanceled) {
                                return;
                            }
                            try {
                                inputStream2.close();
                                return;
                            } catch (IOException e9) {
                                OnException(1002);
                                return;
                            }
                        } catch (OutOfMemoryError e10) {
                            inputStream2 = inputStream;
                            onConnectionOver();
                            if (inputStream2 == null || this.mCanceled) {
                                return;
                            }
                            try {
                                inputStream2.close();
                                return;
                            } catch (IOException e11) {
                                OnException(1002);
                                return;
                            }
                        } catch (SecurityException e12) {
                            inputStream2 = inputStream;
                            onConnectionOver();
                            if (inputStream2 == null || this.mCanceled) {
                                return;
                            }
                            try {
                                inputStream2.close();
                                return;
                            } catch (IOException e13) {
                                OnException(1002);
                                return;
                            }
                        } catch (Throwable th) {
                            inputStream2 = inputStream;
                            th = th;
                            onConnectionOver();
                            if (inputStream2 != null && !this.mCanceled) {
                                try {
                                    inputStream2.close();
                                } catch (IOException e14) {
                                    OnException(1002);
                                }
                            }
                            throw th;
                        }
                    }
                    OnException(1002);
                } else {
                    OnException(1002);
                }
                inputStream = null;
                onConnectionOver();
                if (inputStream == null) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e15) {
        } catch (IllegalArgumentException e16) {
        } catch (IllegalStateException e17) {
        } catch (NullPointerException e18) {
        } catch (OutOfMemoryError e19) {
        } catch (SecurityException e20) {
        }
    }

    protected abstract String getGridParma();

    protected abstract String getMapAddress();

    protected abstract String getMapSvrPath();

    protected String getURL(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public synchronized boolean hasFinished() {
        boolean z;
        if (!this.mCanceled) {
            if (!this.isFinished) {
                z = false;
            }
        }
        z = true;
        return z;
    }

    protected void initTestTime() {
        this.m_reqestStartLen = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isAssic(String str) {
        if (str == null) {
            return false;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] >= 256 || charArray[i] <= 0) {
                return false;
            }
        }
        return true;
    }

    protected abstract boolean isNeedProcessReturn();

    public abstract boolean isRequestValid();

    public void onConnectionError(BaseMapLoader baseMapLoader, int i, String str) {
    }

    protected void onConnectionOpened() {
        this.recievedDataBuffer = new byte[this.mCapaticy];
        this.nextImgDataLength = 0;
        this.recievedDataSize = 0;
        this.recievedHeader = false;
    }

    protected void privteTestTime(String str, String str2) {
    }

    protected abstract boolean processReceivedDataHeader(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public void processReceivedDataV4() {
        if (this.nextImgDataLength == 0) {
            if (this.recievedDataSize < 8) {
                return;
            }
            this.nextImgDataLength = Convert.getInt(this.recievedDataBuffer, 0) + 8;
            processReceivedDataV4();
        } else if (this.recievedDataSize < this.nextImgDataLength) {
        } else {
            processReceivedTileDataV4(this.recievedDataBuffer, 8, this.nextImgDataLength);
            Convert.moveArray(this.recievedDataBuffer, this.nextImgDataLength, this.recievedDataBuffer, 0, this.recievedDataSize - this.nextImgDataLength);
            this.recievedDataSize -= this.nextImgDataLength;
            this.nextImgDataLength = 0;
            processReceivedDataV4();
        }
    }

    protected void processReceivedTileDataV4(byte[] bArr, int i, int i2) {
        int i3 = i + 4;
        int i4 = i3 + 1;
        int i5 = bArr[i3];
        String str = (i5 <= 0 || (i4 + i5) + (-1) >= i2) ? "" : new String(bArr, i4, i5, "utf-8");
        int i6 = i4 + i5;
        if (this.mGLMapEngine.isMapEngineValid() && i2 > i) {
            boolean z = !this.mMapCallback.isGridInScreen(this.datasource, str);
            if (this.mGLMapEngine.putMapData(bArr, i, i2 - i, this.datasource, 0)) {
                VMapDataCache.getInstance().putRecoder(null, str, this.datasource);
            }
            if (!z) {
                return;
            }
            doCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void processRecivedData() {
        if (this.nextImgDataLength == 0) {
            if (this.recievedDataSize < 8) {
                return;
            }
            this.nextImgDataLength = Convert.getInt(this.recievedDataBuffer, 0) + 8;
            processRecivedData();
        } else if (this.recievedDataSize < this.nextImgDataLength) {
        } else {
            int i = Convert.getInt(this.recievedDataBuffer, 0);
            int i2 = Convert.getInt(this.recievedDataBuffer, 4);
            if (i2 == 0) {
                processRecivedTileData(this.recievedDataBuffer, 8, i + 8);
            } else {
                try {
                    GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(this.recievedDataBuffer, 8, i));
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[128];
                    while (true) {
                        int read = gZIPInputStream.read(bArr);
                        if (read <= -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    processRecivedTileData(byteArrayOutputStream.toByteArray(), 0, i2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.nextImgDataLength > 0) {
                Convert.moveArray(this.recievedDataBuffer, this.nextImgDataLength, this.recievedDataBuffer, 0, this.recievedDataSize - this.nextImgDataLength);
            }
            this.recievedDataSize -= this.nextImgDataLength;
            this.nextImgDataLength = 0;
            processRecivedData();
        }
    }

    protected abstract void processRecivedDataByType();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void processRecivedTileData(byte[] bArr, int i, int i2) {
        int i3 = i + 2 + 2 + 4;
        int i4 = i3 + 1;
        int i5 = bArr[i3];
        String str = "";
        if (i5 > 0 && (i4 + i5) - 1 < i2) {
            str = new String(bArr, i4, i5, "utf-8");
        }
        int i6 = i4 + i5;
        if (this.mGLMapEngine.isMapEngineValid() && i2 > i) {
            boolean z = !this.mMapCallback.isGridInScreen(this.datasource, str);
            VMapDataCache.getInstance().putRecoder(null, str, this.datasource);
            this.mGLMapEngine.putMapData(bArr, i, i2 - i, this.datasource, 0);
            if (!z) {
                return;
            }
            doCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void processRecivedVersionData(byte[] bArr, int i, int i2) {
        if (i2 <= 0 || i2 > bArr.length || Convert.getInt(bArr, 0) != 0 || Convert.getInt(bArr, 4) != 0) {
            return;
        }
        int i3 = Convert.getInt(bArr, 8);
        boolean z = true;
        ArrayList arrayList = new ArrayList();
        int i4 = 12;
        int i5 = 0;
        while (true) {
            if (i5 >= i3) {
                break;
            }
            if (i4 >= i2) {
                z = false;
                break;
            }
            int i6 = i4 + 1;
            int i7 = bArr[i4];
            if (i7 <= 0 || i6 + i7 >= i2) {
                break;
            }
            arrayList.add(new String(bArr, i6, i7, "utf-8"));
            i4 = i7 + i6 + 4;
            i5++;
        }
        z = false;
        if (!z) {
            return;
        }
        for (int i8 = 0; i8 < arrayList.size(); i8++) {
            VMapDataCache.getInstance().putRecoder(null, (String) arrayList.get(i8), this.datasource);
        }
        this.mGLMapEngine.putMapData(bArr, 0, i2, this.datasource, 0);
    }

    protected abstract void processRecivedVersionOrScenicWidgetData();
}
