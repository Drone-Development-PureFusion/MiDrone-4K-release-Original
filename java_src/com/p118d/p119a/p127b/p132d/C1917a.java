package com.p118d.p119a.p127b.p132d;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import com.p118d.p119a.p127b.p128a.C1879a;
import com.p118d.p119a.p127b.p132d.AbstractC1919b;
import com.p118d.p119a.p136c.C1947c;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.p248a.p249a.C5083e;
/* renamed from: com.d.a.b.d.a */
/* loaded from: classes.dex */
public class C1917a implements AbstractC1919b {

    /* renamed from: a */
    public static final int f6779a = 5000;

    /* renamed from: b */
    public static final int f6780b = 20000;

    /* renamed from: c */
    protected static final int f6781c = 32768;

    /* renamed from: d */
    protected static final String f6782d = "@#&=*+-_.,:!?()/~'%";

    /* renamed from: e */
    protected static final int f6783e = 5;

    /* renamed from: f */
    protected static final String f6784f = "content://com.android.contacts/";

    /* renamed from: j */
    private static final String f6785j = "UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))";

    /* renamed from: g */
    protected final Context f6786g;

    /* renamed from: h */
    protected final int f6787h;

    /* renamed from: i */
    protected final int f6788i;

    public C1917a(Context context) {
        this(context, 5000, 20000);
    }

    public C1917a(Context context, int i, int i2) {
        this.f6786g = context.getApplicationContext();
        this.f6787h = i;
        this.f6788i = i2;
    }

    @TargetApi(8)
    /* renamed from: a */
    private InputStream m13993a(String str) {
        Bitmap createVideoThumbnail;
        if (Build.VERSION.SDK_INT < 8 || (createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 2)) == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createVideoThumbnail.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    /* renamed from: b */
    private boolean m13991b(Uri uri) {
        String type = this.f6786g.getContentResolver().getType(uri);
        return type != null && type.startsWith("video/");
    }

    /* renamed from: b */
    private boolean m13990b(String str) {
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str));
        return mimeTypeFromExtension != null && mimeTypeFromExtension.startsWith("video/");
    }

    @TargetApi(14)
    /* renamed from: a */
    protected InputStream m13994a(Uri uri) {
        ContentResolver contentResolver = this.f6786g.getContentResolver();
        return Build.VERSION.SDK_INT >= 14 ? ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true) : ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri);
    }

    @Override // com.p118d.p119a.p127b.p132d.AbstractC1919b
    /* renamed from: a */
    public InputStream mo13929a(String str, Object obj) {
        switch (AbstractC1919b.EnumC1920a.m13982a(str)) {
            case HTTP:
            case HTTPS:
                return m13989b(str, obj);
            case FILE:
                return m13987d(str, obj);
            case CONTENT:
                return m13986e(str, obj);
            case ASSETS:
                return m13985f(str, obj);
            case DRAWABLE:
                return m13984g(str, obj);
            default:
                return m13983h(str, obj);
        }
    }

    /* renamed from: a */
    protected boolean m13992a(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getResponseCode() == 200;
    }

    /* renamed from: b */
    protected InputStream m13989b(String str, Object obj) {
        HttpURLConnection m13988c = m13988c(str, obj);
        for (int i = 0; m13988c.getResponseCode() / 100 == 3 && i < 5; i++) {
            m13988c = m13988c(m13988c.getHeaderField(C5083e.f21644H), obj);
        }
        try {
            InputStream inputStream = m13988c.getInputStream();
            if (m13992a(m13988c)) {
                return new C1879a(new BufferedInputStream(inputStream, 32768), m13988c.getContentLength());
            }
            C1947c.m13861a((Closeable) inputStream);
            throw new IOException("Image request failed with response code " + m13988c.getResponseCode());
        } catch (IOException e) {
            C1947c.m13860a(m13988c.getErrorStream());
            throw e;
        }
    }

    /* renamed from: c */
    protected HttpURLConnection m13988c(String str, Object obj) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Uri.encode(str, f6782d)).openConnection();
        httpURLConnection.setConnectTimeout(this.f6787h);
        httpURLConnection.setReadTimeout(this.f6788i);
        return httpURLConnection;
    }

    /* renamed from: d */
    protected InputStream m13987d(String str, Object obj) {
        String m13980c = AbstractC1919b.EnumC1920a.FILE.m13980c(str);
        return m13990b(str) ? m13993a(m13980c) : new C1879a(new BufferedInputStream(new FileInputStream(m13980c), 32768), (int) new File(m13980c).length());
    }

    /* renamed from: e */
    protected InputStream m13986e(String str, Object obj) {
        ContentResolver contentResolver = this.f6786g.getContentResolver();
        Uri parse = Uri.parse(str);
        if (m13991b(parse)) {
            Bitmap thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, Long.valueOf(parse.getLastPathSegment()).longValue(), 1, null);
            if (thumbnail != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                thumbnail.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            }
        } else if (str.startsWith(f6784f)) {
            return m13994a(parse);
        }
        return contentResolver.openInputStream(parse);
    }

    /* renamed from: f */
    protected InputStream m13985f(String str, Object obj) {
        return this.f6786g.getAssets().open(AbstractC1919b.EnumC1920a.ASSETS.m13980c(str));
    }

    /* renamed from: g */
    protected InputStream m13984g(String str, Object obj) {
        return this.f6786g.getResources().openRawResource(Integer.parseInt(AbstractC1919b.EnumC1920a.DRAWABLE.m13980c(str)));
    }

    /* renamed from: h */
    protected InputStream m13983h(String str, Object obj) {
        throw new UnsupportedOperationException(String.format(f6785j, str));
    }
}
