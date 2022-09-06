package com.tencent.connect.dataprovider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import com.fimi.soul.media.player.FimiMediaMeta;
import com.tencent.connect.dataprovider.DataType;
import java.io.File;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class CallbackManager {

    /* renamed from: a */
    private WeakReference<Context> f17480a;

    /* renamed from: b */
    private Uri f17481b;

    /* renamed from: c */
    private String f17482c;

    /* renamed from: d */
    private String f17483d;

    /* renamed from: e */
    private String f17484e;

    /* renamed from: f */
    private String f17485f;

    /* renamed from: g */
    private boolean f17486g;

    /* renamed from: h */
    private int f17487h;

    public CallbackManager(Activity activity) {
        this.f17486g = false;
        this.f17480a = new WeakReference<>(activity.getApplicationContext());
        Intent intent = activity.getIntent();
        if (intent != null) {
            this.f17481b = intent.getData();
            this.f17482c = intent.getStringExtra(Constants.SRC_PACKAGE_NAME);
            this.f17483d = intent.getStringExtra(Constants.SRC_ACTIVITY_CLASS_NAME);
            this.f17484e = intent.getStringExtra(Constants.SRC_ACTIVITY_ACTION);
            this.f17487h = intent.getIntExtra(Constants.REQUEST_TYPE, 0);
            this.f17485f = intent.getStringExtra(Constants.APPID);
            if (this.f17481b == null || this.f17483d == null) {
                return;
            }
            this.f17486g = true;
        }
    }

    /* renamed from: a */
    private int m5847a(Bundle bundle) {
        if (!this.f17486g) {
            return -2;
        }
        Intent intent = new Intent();
        intent.setClassName(this.f17482c, this.f17483d);
        intent.setAction(this.f17484e);
        bundle.putString(Constants.APPID, this.f17485f);
        intent.putExtras(bundle);
        intent.setFlags(268435456);
        this.f17480a.get().startActivity(intent);
        return 0;
    }

    /* renamed from: a */
    private int m5846a(String str) {
        if (str == null) {
            return -7;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("http://")) {
            return 0;
        }
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return -10;
        }
        if (!lowerCase.startsWith(Environment.getExternalStorageDirectory().toString().toLowerCase())) {
            return -5;
        }
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            return -8;
        }
        long length = file.length();
        if (length == 0) {
            return -9;
        }
        return length > FimiMediaMeta.AV_CH_STEREO_RIGHT ? -6 : 0;
    }

    public int getRequestDateTypeFlag() {
        return this.f17487h;
    }

    public boolean isCallFromTencentApp() {
        return this.f17486g;
    }

    public boolean isSupportType(int i) {
        return (getRequestDateTypeFlag() & i) != 0;
    }

    public int sendTextAndImagePath(String str, String str2) {
        if (!isSupportType(1)) {
            return -1;
        }
        int m5846a = m5846a(str2);
        if (m5846a != 0) {
            return m5846a;
        }
        DataType.TextAndMediaPath textAndMediaPath = new DataType.TextAndMediaPath(str, str2);
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.DATA_TYPE, 1);
        bundle.putParcelable(Constants.CONTENT_DATA, textAndMediaPath);
        return m5847a(bundle);
    }

    public int sendTextAndVideoPath(String str, String str2) {
        if (!isSupportType(2)) {
            return -1;
        }
        int m5846a = m5846a(str2);
        if (m5846a != 0) {
            return m5846a;
        }
        DataType.TextAndMediaPath textAndMediaPath = new DataType.TextAndMediaPath(str, str2);
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.DATA_TYPE, 2);
        bundle.putParcelable(Constants.CONTENT_DATA, textAndMediaPath);
        return m5847a(bundle);
    }

    public int sendTextOnly(String str) {
        if (!isSupportType(4)) {
            return -1;
        }
        DataType.TextOnly textOnly = new DataType.TextOnly(str);
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.DATA_TYPE, 4);
        bundle.putParcelable(Constants.CONTENT_DATA, textOnly);
        return m5847a(bundle);
    }
}
