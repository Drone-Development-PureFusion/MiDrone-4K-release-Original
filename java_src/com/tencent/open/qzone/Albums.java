package com.tencent.open.qzone;

import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.SocialConstants;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.HttpUtils;
import com.tencent.tauth.IUiListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes2.dex */
public class Albums extends BaseApi {

    /* loaded from: classes2.dex */
    public enum AlbumSecurity {
        publicToAll("1"),
        privateOnly("2"),
        friendsOnly("4"),
        needQuestion("5");
        

        /* renamed from: a */
        private final String f18178a;

        AlbumSecurity(String str) {
            this.f18178a = str;
        }

        public String getSecurity() {
            return this.f18178a;
        }
    }

    public Albums(Context context, QQAuth qQAuth, QQToken qQToken) {
        super(qQAuth, qQToken);
    }

    public Albums(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public void addAlbum(String str, String str2, AlbumSecurity albumSecurity, String str3, String str4, IUiListener iUiListener) {
        Bundle composeCGIParams = composeCGIParams();
        if (str == null) {
            str = "";
        }
        composeCGIParams.putString("albumname", str);
        if (str2 == null) {
            str2 = "";
        }
        composeCGIParams.putString("albumdesc", str2);
        composeCGIParams.putString("priv", albumSecurity == null ? AlbumSecurity.publicToAll.getSecurity() : albumSecurity.getSecurity());
        if (str3 == null) {
            str3 = "";
        }
        composeCGIParams.putString("question", str3);
        if (str4 == null) {
            str4 = "";
        }
        composeCGIParams.putString("answer", str4);
        HttpUtils.requestAsync(this.mToken, Global.getContext(), "photo/add_album", composeCGIParams, "POST", new BaseApi.TempRequestListener(iUiListener));
    }

    public void listAlbum(IUiListener iUiListener) {
        HttpUtils.requestAsync(this.mToken, Global.getContext(), "photo/list_album", composeCGIParams(), "GET", new BaseApi.TempRequestListener(iUiListener));
    }

    public void listPhotos(String str, IUiListener iUiListener) {
        Bundle composeCGIParams = composeCGIParams();
        if (str == null) {
            str = "";
        }
        composeCGIParams.putString("albumid", str);
        HttpUtils.requestAsync(this.mToken, Global.getContext(), "photo/list_photo", composeCGIParams, "GET", new BaseApi.TempRequestListener(iUiListener));
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void uploadPicture(String str, String str2, String str3, String str4, String str5, IUiListener iUiListener) {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(iUiListener);
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (IOException e) {
                e = e;
                byteArrayOutputStream = null;
                fileInputStream2 = fileInputStream;
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                Bundle composeCGIParams = composeCGIParams();
                File file = new File(str);
                composeCGIParams.putByteArray(SocialConstants.PARAM_AVATAR_URI, byteArray);
                if (str2 == null) {
                    str2 = "";
                }
                composeCGIParams.putString("photodesc", str2);
                composeCGIParams.putString("title", file.getName());
                if (str3 != null) {
                    if (str3 == null) {
                        str3 = "";
                    }
                    composeCGIParams.putString("albumid", str3);
                }
                if (str4 == null) {
                    str4 = "";
                }
                composeCGIParams.putString("x", str4);
                if (str5 == null) {
                    str5 = "";
                }
                composeCGIParams.putString("y", str5);
                HttpUtils.requestAsync(this.mToken, Global.getContext(), "photo/upload_pic", composeCGIParams, "POST", tempRequestListener);
            } catch (IOException e4) {
                e = e4;
                fileInputStream2 = fileInputStream;
                try {
                    tempRequestListener.onIOException(e);
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    if (fileInputStream2 == null) {
                        return;
                    }
                    try {
                        fileInputStream2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (byteArrayOutputStream != null) {
                }
                if (fileInputStream != null) {
                }
                throw th;
            }
        } catch (IOException e9) {
            e = e9;
            byteArrayOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            fileInputStream = null;
        }
    }
}
