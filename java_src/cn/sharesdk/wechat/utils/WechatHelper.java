package cn.sharesdk.wechat.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.C0683d;
import com.fimi.kernel.C2172a;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.UIHandler;
import com.tencent.open.SocialConstants;
import com.tencent.p227mm.sdk.plugin.MMPluginProviderConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URLConnection;
import java.util.HashMap;
/* loaded from: classes.dex */
public class WechatHelper {

    /* renamed from: a */
    private static WechatHelper f1675a;

    /* renamed from: b */
    private C0714h f1676b = new C0714h();

    /* renamed from: c */
    private C0715i f1677c;

    /* loaded from: classes.dex */
    public static class ShareParams extends Platform.ShareParams {
        @Deprecated
        public String extInfo;
        @Deprecated
        public String filePath;
        @Deprecated
        public Bitmap imageData;
        @Deprecated
        public String imageUrl;
        @Deprecated
        public String musicUrl;
        @Deprecated
        protected int scene;
        @Deprecated
        public int shareType;
        @Deprecated
        public String title;
        @Deprecated
        public String url;
    }

    private WechatHelper() {
    }

    /* renamed from: a */
    private Bitmap m19395a(Bitmap bitmap, double d) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        double sqrt = Math.sqrt(d);
        return Bitmap.createScaledBitmap(bitmap, (int) (width / sqrt), (int) (height / sqrt), true);
    }

    /* renamed from: a */
    public static WechatHelper m19405a() {
        if (f1675a == null) {
            f1675a = new WechatHelper();
        }
        return f1675a;
    }

    /* renamed from: a */
    private void m19401a(Context context, String str, String str2, Bitmap bitmap, int i, C0715i c0715i) {
        WXImageObject wXImageObject = new WXImageObject();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        wXImageObject.imageData = byteArrayOutputStream.toByteArray();
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        if (i != 0) {
            wXMediaMessage.title = str;
            wXMediaMessage.description = str2;
        }
        wXMediaMessage.thumbData = m19404a(context, bitmap);
        m19394a(wXMediaMessage, SocialConstants.PARAM_IMG_URL, i, c0715i);
    }

    /* renamed from: a */
    private void m19400a(Context context, String str, String str2, String str3, int i, C0715i c0715i) {
        WXImageObject wXImageObject = new WXImageObject();
        if (str3.startsWith("/data/")) {
            wXImageObject.imageData = m19390a(str3);
        } else {
            wXImageObject.imagePath = str3;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        if (i != 0) {
            wXMediaMessage.title = str;
            wXMediaMessage.description = str2;
        }
        wXMediaMessage.thumbData = m19387b(context, str3);
        m19394a(wXMediaMessage, SocialConstants.PARAM_IMG_URL, i, c0715i);
    }

    /* renamed from: a */
    private void m19399a(Context context, String str, String str2, String str3, Bitmap bitmap, int i, C0715i c0715i) {
        WXVideoObject wXVideoObject = new WXVideoObject();
        wXVideoObject.videoUrl = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXVideoObject;
        wXMediaMessage.thumbData = m19404a(context, bitmap);
        m19394a(wXMediaMessage, "video", i, c0715i);
    }

    /* renamed from: a */
    private void m19398a(Context context, String str, String str2, String str3, String str4, int i, C0715i c0715i) {
        WXVideoObject wXVideoObject = new WXVideoObject();
        wXVideoObject.videoUrl = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXVideoObject;
        wXMediaMessage.thumbData = m19387b(context, str4);
        m19394a(wXMediaMessage, "video", i, c0715i);
    }

    /* renamed from: a */
    private void m19397a(Context context, String str, String str2, String str3, String str4, Bitmap bitmap, int i, C0715i c0715i) {
        WXMusicObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = str4;
        wXMusicObject.musicDataUrl = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.thumbData = m19404a(context, bitmap);
        m19394a(wXMediaMessage, "music", i, c0715i);
    }

    /* renamed from: a */
    private void m19396a(Context context, String str, String str2, String str3, String str4, String str5, int i, C0715i c0715i) {
        WXMusicObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = str4;
        wXMusicObject.musicDataUrl = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.thumbData = m19387b(context, str5);
        m19394a(wXMediaMessage, "music", i, c0715i);
    }

    /* renamed from: a */
    private void m19394a(WXMediaMessage wXMediaMessage, String str, int i, C0715i c0715i) {
        Class<?> cls;
        String str2 = DeviceHelper.getInstance(c0715i.m19345b().getContext()).getPackageName() + ".wxapi.WXEntryActivity";
        try {
            cls = Class.forName(str2);
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
            cls = null;
        }
        if (cls != null && !WechatHandlerActivity.class.isAssignableFrom(cls)) {
            new Throwable(str2 + " does not extend from " + WechatHandlerActivity.class.getName()).printStackTrace();
        }
        C0708d c0708d = new C0708d();
        c0708d.f1716c = str + System.currentTimeMillis();
        c0708d.f1696a = wXMediaMessage;
        c0708d.f1697b = i;
        this.f1677c = c0715i;
        this.f1676b.m19357a(c0708d);
    }

    /* renamed from: a */
    private void m19389a(String str, String str2, int i, C0715i c0715i) {
        WXTextObject wXTextObject = new WXTextObject();
        wXTextObject.text = str2;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.mediaObject = wXTextObject;
        wXMediaMessage.description = str2;
        m19394a(wXMediaMessage, "text", i, c0715i);
    }

    /* renamed from: a */
    private byte[] m19404a(Context context, Bitmap bitmap) {
        if (bitmap == null) {
            throw new RuntimeException("checkArgs fail, thumbData is null");
        }
        if (!bitmap.isRecycled()) {
            return m19403a(context, bitmap, Bitmap.CompressFormat.PNG);
        }
        throw new RuntimeException("checkArgs fail, thumbData is recycled");
    }

    /* renamed from: a */
    private byte[] m19403a(Context context, Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        if (bitmap == null) {
            throw new RuntimeException("checkArgs fail, thumbData is null");
        }
        if (bitmap.isRecycled()) {
            throw new RuntimeException("checkArgs fail, thumbData is recycled");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, 100, byteArrayOutputStream);
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int length = byteArray.length;
        while (length > 32768) {
            bitmap = m19395a(bitmap, length / 32768.0d);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            bitmap.compress(compressFormat, 100, byteArrayOutputStream2);
            byteArrayOutputStream2.flush();
            byteArrayOutputStream2.close();
            byteArray = byteArrayOutputStream2.toByteArray();
            length = byteArray.length;
        }
        return byteArray;
    }

    /* renamed from: a */
    private byte[] m19390a(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            for (int read = fileInputStream.read(bArr); read > 0; read = fileInputStream.read(bArr)) {
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.flush();
            fileInputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
            return null;
        }
    }

    /* renamed from: b */
    private void m19386b(Context context, String str, String str2, Bitmap bitmap, int i, C0715i c0715i) {
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        byte[] m19404a = m19404a(context, bitmap);
        wXEmojiObject.emojiData = m19404a;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.description = str2;
        wXMediaMessage.thumbData = m19404a;
        m19394a(wXMediaMessage, "emoji", i, c0715i);
    }

    /* renamed from: b */
    private void m19385b(Context context, String str, String str2, String str3, int i, C0715i c0715i) {
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.description = str2;
        wXMediaMessage.thumbData = m19387b(context, str3);
        m19394a(wXMediaMessage, "emoji", i, c0715i);
    }

    /* renamed from: b */
    private void m19384b(Context context, String str, String str2, String str3, Bitmap bitmap, int i, C0715i c0715i) {
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXWebpageObject;
        if (bitmap != null && !bitmap.isRecycled()) {
            wXMediaMessage.thumbData = m19404a(context, bitmap);
            if (wXMediaMessage.thumbData == null) {
                throw new RuntimeException("checkArgs fail, thumbData is null");
            }
            if (wXMediaMessage.thumbData.length > 32768) {
                throw new RuntimeException("checkArgs fail, thumbData is too large: " + wXMediaMessage.thumbData.length + " > 32768");
            }
        }
        m19394a(wXMediaMessage, "webpage", i, c0715i);
    }

    /* renamed from: b */
    private void m19383b(Context context, String str, String str2, String str3, String str4, int i, C0715i c0715i) {
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXWebpageObject;
        if (str4 != null && new File(str4).exists()) {
            wXMediaMessage.thumbData = m19387b(context, str4);
            if (wXMediaMessage.thumbData == null) {
                throw new RuntimeException("checkArgs fail, thumbData is null");
            }
            if (wXMediaMessage.thumbData.length > 32768) {
                throw new RuntimeException("checkArgs fail, thumbData is too large: " + wXMediaMessage.thumbData.length + " > 32768");
            }
        }
        m19394a(wXMediaMessage, "webpage", i, c0715i);
    }

    /* renamed from: b */
    private void m19382b(Context context, String str, String str2, String str3, String str4, Bitmap bitmap, int i, C0715i c0715i) {
        WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
        wXAppExtendObject.filePath = str3;
        wXAppExtendObject.extInfo = str4;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXAppExtendObject;
        wXMediaMessage.thumbData = m19404a(context, bitmap);
        m19394a(wXMediaMessage, "appdata", i, c0715i);
    }

    /* renamed from: b */
    private void m19381b(Context context, String str, String str2, String str3, String str4, String str5, int i, C0715i c0715i) {
        WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
        wXAppExtendObject.filePath = str3;
        wXAppExtendObject.extInfo = str4;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXAppExtendObject;
        wXMediaMessage.thumbData = m19387b(context, str5);
        m19394a(wXMediaMessage, "appdata", i, c0715i);
    }

    /* renamed from: b */
    private byte[] m19387b(Context context, String str) {
        if (!new File(str).exists()) {
            throw new FileNotFoundException();
        }
        return m19403a(context, BitmapHelper.getBitmap(str), BitmapHelper.getBmpFormat(str));
    }

    /* renamed from: c */
    private void m19378c(Context context, String str, String str2, String str3, Bitmap bitmap, int i, C0715i c0715i) {
        WXFileObject wXFileObject = new WXFileObject();
        wXFileObject.filePath = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXFileObject;
        wXMediaMessage.thumbData = m19404a(context, bitmap);
        m19394a(wXMediaMessage, "filedata", i, c0715i);
    }

    /* renamed from: c */
    private void m19377c(Context context, String str, String str2, String str3, String str4, int i, C0715i c0715i) {
        WXFileObject wXFileObject = new WXFileObject();
        wXFileObject.filePath = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXFileObject;
        wXMediaMessage.thumbData = m19387b(context, str4);
        m19394a(wXMediaMessage, "filedata", i, c0715i);
    }

    /* renamed from: a */
    public void m19392a(C0715i c0715i) {
        this.f1677c = c0715i;
        C0705a c0705a = new C0705a();
        c0705a.f1688a = "snsapi_userinfo";
        c0705a.f1689b = "sharesdk_wechat_auth";
        this.f1676b.m19357a(c0705a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x00d4, code lost:
        if (com.mob.tools.utils.ResHelper.copyFile(r0, r4) != false) goto L16;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m19391a(C0715i c0715i, Platform.ShareParams shareParams, final PlatformActionListener platformActionListener) {
        File file;
        final Platform m19345b = c0715i.m19345b();
        String imagePath = shareParams.getImagePath();
        String imageUrl = shareParams.getImageUrl();
        if (TextUtils.isEmpty(imagePath) || !new File(imagePath).exists()) {
            Bitmap imageData = shareParams.getImageData();
            if (imageData != null && !imageData.isRecycled()) {
                File file2 = new File(ResHelper.getCachePath(m19345b.getContext(), C2172a.f7286b), System.currentTimeMillis() + ".png");
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                imageData.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                imagePath = file2.getAbsolutePath();
            } else if (!TextUtils.isEmpty(imageUrl)) {
                imagePath = BitmapHelper.downloadBitmap(m19345b.getContext(), imageUrl);
            }
        }
        Intent intent = new Intent("android.intent.action.SEND");
        String text = shareParams.getText();
        if (!TextUtils.isEmpty(text)) {
            String shortLintk = m19345b.getShortLintk(text, false);
            shareParams.setText(shortLintk);
            intent.putExtra("android.intent.extra.TEXT", shortLintk);
            intent.putExtra("Kdescription", shortLintk);
        }
        if (!TextUtils.isEmpty(imagePath)) {
            File file3 = new File(imagePath);
            if (file3.exists()) {
                if (imagePath.startsWith("/data/")) {
                    file = new File(ResHelper.getCachePath(m19345b.getContext(), C2172a.f7286b), System.currentTimeMillis() + file3.getName());
                    String absolutePath = file.getAbsolutePath();
                    file.createNewFile();
                }
                file = file3;
                if (Build.VERSION.SDK_INT >= 24) {
                    intent.putExtra("android.intent.extra.STREAM", ResHelper.pathToContentUri(m19345b.getContext(), file.getAbsolutePath()));
                } else {
                    intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
                }
                String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(imagePath);
                if (contentTypeFor == null || contentTypeFor.length() <= 0) {
                    contentTypeFor = "image/*";
                }
                intent.setType(contentTypeFor);
            }
        } else {
            intent.setType("text/plain");
        }
        intent.setClassName(MMPluginProviderConstants.PluginIntent.APP_PACKAGE_PATTERN, ((Integer) shareParams.get("scene", Integer.class)).intValue() == 1 ? "com.tencent.mm.ui.tools.ShareToTimeLineUI" : "com.tencent.mm.ui.tools.ShareImgUI");
        intent.addFlags(268435456);
        m19345b.getContext().startActivity(intent);
        final DeviceHelper deviceHelper = DeviceHelper.getInstance(m19345b.getContext());
        final String packageName = m19345b.getContext().getPackageName();
        final HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("ShareParams", shareParams);
        if (!TextUtils.isEmpty(deviceHelper.getTopTaskPackageName())) {
            UIHandler.sendEmptyMessageDelayed(0, 2000L, new Handler.Callback() { // from class: cn.sharesdk.wechat.utils.WechatHelper.1

                /* renamed from: a */
                int f1678a = 0;

                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    if (!packageName.equals(deviceHelper.getTopTaskPackageName())) {
                        if (platformActionListener == null) {
                            return true;
                        }
                        platformActionListener.onComplete(m19345b, 9, hashMap);
                        return true;
                    } else if (this.f1678a >= 5) {
                        return true;
                    } else {
                        this.f1678a++;
                        UIHandler.sendEmptyMessageDelayed(0, 500L, this);
                        return true;
                    }
                }
            });
        } else if (platformActionListener == null || platformActionListener == null) {
        } else {
            platformActionListener.onComplete(m19345b, 9, hashMap);
        }
    }

    /* renamed from: a */
    public boolean m19402a(Context context, String str) {
        return this.f1676b.m19359a(context, str);
    }

    /* renamed from: a */
    public boolean m19393a(WechatHandlerActivity wechatHandlerActivity) {
        return this.f1676b.m19358a(wechatHandlerActivity, this.f1677c);
    }

    /* renamed from: b */
    public void m19380b(C0715i c0715i) {
        Platform m19345b = c0715i.m19345b();
        Platform.ShareParams m19350a = c0715i.m19350a();
        PlatformActionListener m19344c = c0715i.m19344c();
        int shareType = m19350a.getShareType();
        String title = m19350a.getTitle();
        String text = m19350a.getText();
        int scence = m19350a.getScence();
        String imagePath = m19350a.getImagePath();
        String imageUrl = m19350a.getImageUrl();
        Bitmap imageData = m19350a.getImageData();
        String musicUrl = m19350a.getMusicUrl();
        String url = m19350a.getUrl();
        String filePath = m19350a.getFilePath();
        String extInfo = m19350a.getExtInfo();
        Context context = m19345b.getContext();
        switch (shareType) {
            case 1:
                m19389a(title, text, scence, c0715i);
                return;
            case 2:
                if (imagePath != null && imagePath.length() > 0) {
                    m19400a(context, title, text, imagePath, scence, c0715i);
                    return;
                } else if (imageData != null && !imageData.isRecycled()) {
                    m19401a(context, title, text, imageData, scence, c0715i);
                    return;
                } else if (imageUrl == null || imageUrl.length() <= 0) {
                    m19400a(context, title, text, "", scence, c0715i);
                    return;
                } else {
                    m19400a(context, title, text, BitmapHelper.downloadBitmap(m19345b.getContext(), imageUrl), scence, c0715i);
                    return;
                }
            case 3:
            default:
                if (m19344c == null) {
                    return;
                }
                m19344c.onError(m19345b, 9, new IllegalArgumentException("shareType = " + shareType));
                return;
            case 4:
                String shortLintk = m19345b.getShortLintk(url, false);
                c0715i.m19350a().setUrl(shortLintk);
                if (imagePath != null && imagePath.length() > 0) {
                    m19383b(context, title, text, shortLintk, imagePath, scence, c0715i);
                    return;
                } else if (imageData != null && !imageData.isRecycled()) {
                    m19384b(context, title, text, shortLintk, imageData, scence, c0715i);
                    return;
                } else if (imageUrl == null || imageUrl.length() <= 0) {
                    m19383b(context, title, text, shortLintk, "", scence, c0715i);
                    return;
                } else {
                    m19383b(context, title, text, shortLintk, BitmapHelper.downloadBitmap(m19345b.getContext(), imageUrl), scence, c0715i);
                    return;
                }
            case 5:
                String shortLintk2 = m19345b.getShortLintk(musicUrl + " " + url, false);
                String str = shortLintk2.split(" ")[0];
                String str2 = shortLintk2.split(" ")[1];
                if (imagePath != null && imagePath.length() > 0) {
                    m19396a(context, title, text, str, str2, imagePath, scence, c0715i);
                    return;
                } else if (imageData != null && !imageData.isRecycled()) {
                    m19397a(context, title, text, str, str2, imageData, scence, c0715i);
                    return;
                } else if (imageUrl == null || imageUrl.length() <= 0) {
                    m19396a(context, title, text, str, str2, "", scence, c0715i);
                    return;
                } else {
                    m19396a(context, title, text, str, str2, BitmapHelper.downloadBitmap(m19345b.getContext(), imageUrl), scence, c0715i);
                    return;
                }
            case 6:
                String shortLintk3 = m19345b.getShortLintk(url, false);
                c0715i.m19350a().setUrl(shortLintk3);
                if (imagePath != null && imagePath.length() > 0) {
                    m19398a(context, title, text, shortLintk3, imagePath, scence, c0715i);
                    return;
                } else if (imageData != null && !imageData.isRecycled()) {
                    m19399a(context, title, text, shortLintk3, imageData, scence, c0715i);
                    return;
                } else if (imageUrl == null || imageUrl.length() <= 0) {
                    m19398a(context, title, text, shortLintk3, "", scence, c0715i);
                    return;
                } else {
                    m19398a(context, title, text, shortLintk3, BitmapHelper.downloadBitmap(m19345b.getContext(), imageUrl), scence, c0715i);
                    return;
                }
            case 7:
                if (scence == 1) {
                    throw new Throwable("WechatMoments does not support SAHRE_APP");
                }
                if (scence == 2) {
                    throw new Throwable("WechatFavorite does not support SAHRE_APP");
                }
                if (imagePath != null && imagePath.length() > 0) {
                    m19381b(context, title, text, filePath, extInfo, imagePath, scence, c0715i);
                    return;
                } else if (imageData != null && !imageData.isRecycled()) {
                    m19382b(context, title, text, filePath, extInfo, imageData, scence, c0715i);
                    return;
                } else if (imageUrl == null || imageUrl.length() <= 0) {
                    m19381b(context, title, text, filePath, extInfo, "", scence, c0715i);
                    return;
                } else {
                    m19381b(context, title, text, filePath, extInfo, BitmapHelper.downloadBitmap(m19345b.getContext(), imageUrl), scence, c0715i);
                    return;
                }
            case 8:
                if (scence == 1) {
                    throw new Throwable("WechatMoments does not support SHARE_FILE");
                }
                if (imagePath != null && imagePath.length() > 0) {
                    m19377c(context, title, text, filePath, imagePath, scence, c0715i);
                    return;
                } else if (imageData != null && !imageData.isRecycled()) {
                    m19378c(context, title, text, filePath, imageData, scence, c0715i);
                    return;
                } else if (imageUrl == null || imageUrl.length() <= 0) {
                    m19377c(context, title, text, filePath, "", scence, c0715i);
                    return;
                } else {
                    m19377c(context, title, text, filePath, BitmapHelper.downloadBitmap(m19345b.getContext(), imageUrl), scence, c0715i);
                    return;
                }
            case 9:
                if (scence == 1) {
                    throw new Throwable("WechatMoments does not support SHARE_EMOJI");
                }
                if (scence == 2) {
                    throw new Throwable("WechatFavorite does not support SHARE_EMOJI");
                }
                if (imagePath != null && imagePath.length() > 0) {
                    m19385b(context, title, text, imagePath, scence, c0715i);
                    return;
                } else if (imageUrl != null && imageUrl.length() > 0) {
                    m19385b(context, title, text, new NetworkHelper().downloadCache(m19345b.getContext(), imageUrl, C2172a.f7286b, true, null), scence, c0715i);
                    return;
                } else if (imageData == null || imageData.isRecycled()) {
                    m19385b(context, title, text, "", scence, c0715i);
                    return;
                } else {
                    m19386b(context, title, text, imageData, scence, c0715i);
                    return;
                }
        }
    }

    /* renamed from: b */
    public boolean m19388b() {
        return this.f1676b.m19360a();
    }

    /* renamed from: c */
    public boolean m19379c() {
        return this.f1676b.m19353b();
    }

    /* renamed from: d */
    public boolean m19376d() {
        return this.f1676b.m19352c();
    }
}
