package com.mining.app.zxing.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.fimi.soul.C2300R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.mining.app.zxing.p221a.C4103c;
import com.mining.app.zxing.p222b.C4115f;
import com.mining.app.zxing.p222b.HandlerC4109a;
import com.mining.app.zxing.view.ViewfinderView;
import java.io.IOException;
import java.util.Vector;
/* loaded from: classes.dex */
public class MipcaActivityCapture extends Activity implements SurfaceHolder.Callback {

    /* renamed from: h */
    private static final long f17173h = 200;

    /* renamed from: a */
    private HandlerC4109a f17174a;

    /* renamed from: b */
    private ViewfinderView f17175b;

    /* renamed from: c */
    private boolean f17176c;

    /* renamed from: d */
    private Vector<BarcodeFormat> f17177d;

    /* renamed from: e */
    private String f17178e;

    /* renamed from: f */
    private C4115f f17179f;

    /* renamed from: g */
    private Button f17180g;

    /* renamed from: i */
    private final MediaPlayer.OnCompletionListener f17181i = new MediaPlayer.OnCompletionListener() { // from class: com.mining.app.zxing.activity.MipcaActivityCapture.2
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.seekTo(0);
        }
    };

    /* renamed from: a */
    private void m6161a(SurfaceHolder surfaceHolder) {
        try {
            C4103c.m6188a().m6184a(surfaceHolder);
            if (this.f17174a != null) {
                return;
            }
            this.f17174a = new HandlerC4109a(this, this.f17177d, this.f17178e);
        } catch (IOException e) {
        } catch (RuntimeException e2) {
        }
    }

    /* renamed from: a */
    public ViewfinderView m6162a() {
        return this.f17175b;
    }

    /* renamed from: a */
    public void m6160a(Result result, Bitmap bitmap) {
        this.f17179f.m6150a();
        String text = result.getText();
        if (text.equals("")) {
            Toast.makeText(this, "Scan failed!", 0).show();
        } else {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("result", text);
            intent.putExtras(bundle);
            setResult(-1, intent);
        }
        finish();
    }

    /* renamed from: b */
    public Handler m6159b() {
        return this.f17174a;
    }

    /* renamed from: c */
    public void m6158c() {
        this.f17175b.m6147a();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.activity_insurance_capture);
        C4103c.m6186a(getApplication());
        this.f17175b = (ViewfinderView) findViewById(C2300R.C2302id.viewfinder_view);
        this.f17180g = (Button) findViewById(C2300R.C2302id.return_insurance);
        this.f17176c = false;
        this.f17179f = new C4115f(this);
        this.f17180g.setOnClickListener(new View.OnClickListener() { // from class: com.mining.app.zxing.activity.MipcaActivityCapture.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MipcaActivityCapture.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.f17179f.m6149b();
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.f17174a != null) {
            this.f17174a.m6157a();
            this.f17174a = null;
        }
        C4103c.m6188a().m6182b();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        SurfaceHolder holder = ((SurfaceView) findViewById(C2300R.C2302id.preview_view)).getHolder();
        if (this.f17176c) {
            m6161a(holder);
        } else {
            holder.addCallback(this);
            holder.setType(3);
        }
        this.f17177d = null;
        this.f17178e = null;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (!this.f17176c) {
            this.f17176c = true;
            m6161a(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f17176c = false;
    }
}
