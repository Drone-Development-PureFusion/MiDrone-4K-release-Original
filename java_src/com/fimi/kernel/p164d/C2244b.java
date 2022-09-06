package com.fimi.kernel.p164d;

import android.content.Context;
import android.media.AudioManager;
import android.os.Environment;
import com.baidu.tts.auth.AuthInfo;
import com.baidu.tts.client.SpeechError;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.SpeechSynthesizerListener;
import com.baidu.tts.client.TtsMode;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* renamed from: com.fimi.kernel.d.b */
/* loaded from: classes.dex */
public class C2244b implements SpeechSynthesizerListener {

    /* renamed from: d */
    private static final String f7481d = "baiduTTS";

    /* renamed from: e */
    private static final String f7482e = "bd_etts_ch_speech_female.dat";

    /* renamed from: f */
    private static final String f7483f = "bd_etts_ch_text.dat";

    /* renamed from: g */
    private static final String f7484g = "temp_license";

    /* renamed from: h */
    private static final String f7485h = "bd_etts_speech_female_en.dat";

    /* renamed from: i */
    private static final String f7486i = "bd_etts_text_en.dat";

    /* renamed from: k */
    private static C2244b f7488k;

    /* renamed from: l */
    private static Context f7489l;

    /* renamed from: b */
    private SpeechSynthesizer f7490b;

    /* renamed from: c */
    private String f7491c;

    /* renamed from: m */
    private boolean f7492m;

    /* renamed from: n */
    private AudioManager f7493n;

    /* renamed from: o */
    private int f7494o;

    /* renamed from: p */
    private int f7495p;

    /* renamed from: q */
    private boolean f7496q;

    /* renamed from: r */
    private AbstractC2245a f7497r;

    /* renamed from: a */
    private static boolean f7480a = false;

    /* renamed from: j */
    private static boolean f7487j = false;

    /* renamed from: com.fimi.kernel.d.b$a */
    /* loaded from: classes.dex */
    public interface AbstractC2245a {
        /* renamed from: a */
        void m13087a(boolean z);
    }

    private C2244b() {
        if (f7489l != null) {
            this.f7493n = (AudioManager) f7489l.getSystemService("audio");
            this.f7494o = this.f7493n.getStreamVolume(3);
            this.f7495p = this.f7493n.getStreamMaxVolume(3);
        }
    }

    /* renamed from: a */
    public static C2244b m13105a(Context context) {
        f7489l = context;
        if (f7488k == null) {
            synchronized (C2244b.class) {
                f7488k = new C2244b();
            }
        }
        return f7488k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m13101a(boolean z, String str, String str2) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        FileOutputStream fileOutputStream3 = null;
        fileOutputStream3 = 0;
        InputStream inputStream2 = null;
        fileOutputStream3 = 0;
        fileOutputStream3 = null;
        File file = new File(str2);
        if (z || (!z && !file.exists())) {
            try {
                try {
                    inputStream = f7489l.getResources().getAssets().open(str);
                    try {
                        fileOutputStream2 = new FileOutputStream(str2);
                    } catch (FileNotFoundException e) {
                        e = e;
                        fileOutputStream = null;
                        inputStream2 = inputStream;
                    } catch (IOException e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        fileOutputStream3 = inputStream.read(bArr, 0, 1024);
                        if (fileOutputStream3 < 0) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, fileOutputStream3);
                    }
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                } catch (FileNotFoundException e5) {
                    e = e5;
                    inputStream2 = inputStream;
                    fileOutputStream = fileOutputStream2;
                    try {
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (inputStream2 == null) {
                            return;
                        }
                        try {
                            inputStream2.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStream2;
                        fileOutputStream3 = fileOutputStream;
                        if (fileOutputStream3 != null) {
                            try {
                                fileOutputStream3.close();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e9) {
                                e9.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e10) {
                    e = e10;
                    fileOutputStream3 = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream3 != 0) {
                        try {
                            fileOutputStream3.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream3 = fileOutputStream2;
                    if (fileOutputStream3 != null) {
                    }
                    if (inputStream != null) {
                    }
                    throw th;
                }
            } catch (FileNotFoundException e13) {
                e = e13;
                fileOutputStream = null;
            } catch (IOException e14) {
                e = e14;
                inputStream = null;
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
            }
        }
    }

    /* renamed from: b */
    public static C2244b m13099b(Context context) {
        f7489l = context;
        return f7488k;
    }

    /* renamed from: e */
    private void m13091e(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /* renamed from: g */
    private void m13089g() {
        if (this.f7491c == null) {
            this.f7491c = Environment.getExternalStorageDirectory().toString() + "/" + f7481d;
        }
        m13091e(this.f7491c);
        m13101a(false, f7482e, this.f7491c + "/" + f7482e);
        m13101a(false, f7483f, this.f7491c + "/" + f7483f);
        m13101a(false, f7484g, this.f7491c + "/" + f7484g);
        m13101a(false, "english/bd_etts_speech_female_en.dat", this.f7491c + "/" + f7485h);
        m13101a(false, "english/bd_etts_text_en.dat", this.f7491c + "/" + f7486i);
    }

    /* renamed from: h */
    private void m13088h() {
        this.f7490b = SpeechSynthesizer.getInstance();
        this.f7490b.setContext(f7489l);
        this.f7490b.setSpeechSynthesizerListener(this);
        this.f7490b.setParam(SpeechSynthesizer.PARAM_TTS_TEXT_MODEL_FILE, this.f7491c + "/" + f7483f);
        this.f7490b.setParam(SpeechSynthesizer.PARAM_TTS_SPEECH_MODEL_FILE, this.f7491c + "/" + f7482e);
        this.f7490b.setAppId(C2243a.f7477a);
        this.f7490b.setApiKey(C2243a.f7478b, C2243a.f7479c);
        AuthInfo auth = this.f7490b.auth(TtsMode.MIX);
        if (!auth.isSuccess()) {
            this.f7492m = false;
            auth.getTtsError().getDetailMessage();
            return;
        }
        this.f7492m = true;
        this.f7490b.setParam(SpeechSynthesizer.PARAM_SPEAKER, "0");
        this.f7490b.setParam(SpeechSynthesizer.PARAM_MIX_MODE, SpeechSynthesizer.MIX_MODE_HIGH_SPEED_SYNTHESIZE_WIFI);
        this.f7490b.initTts(TtsMode.MIX);
        this.f7490b.loadEnglishModel(this.f7491c + "/" + f7486i, this.f7491c + "/" + f7485h);
    }

    /* renamed from: a */
    public void m13106a() {
        if (!this.f7492m) {
            m13089g();
            m13088h();
        }
    }

    /* renamed from: a */
    public void m13104a(AbstractC2245a abstractC2245a) {
        this.f7497r = abstractC2245a;
    }

    /* renamed from: a */
    public void m13103a(String str) {
        if (str == null || this.f7490b == null) {
            return;
        }
        if (this.f7493n != null && this.f7494o <= this.f7495p && !this.f7496q) {
            this.f7496q = true;
            this.f7493n.setStreamVolume(3, this.f7493n.getStreamMaxVolume(3), 4);
        }
        try {
            if (f7480a) {
                this.f7490b.stop();
            }
            this.f7490b.speak(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m13102a(boolean z) {
        this.f7492m = z;
    }

    /* renamed from: b */
    public void m13100b() {
        if (this.f7490b != null) {
            this.f7490b.stop();
        }
    }

    /* renamed from: b */
    public void m13098b(String str) {
        this.f7490b.setParam(SpeechSynthesizer.PARAM_SPEAKER, str);
    }

    /* renamed from: b */
    public void m13097b(boolean z) {
        this.f7496q = z;
    }

    /* renamed from: c */
    public void m13096c() {
        this.f7490b.release();
    }

    /* renamed from: c */
    public void m13095c(String str) {
        this.f7490b.setParam(SpeechSynthesizer.PARAM_VOLUME, str);
    }

    /* renamed from: d */
    public void m13093d(String str) {
        this.f7490b.setParam(SpeechSynthesizer.PARAM_PITCH, str);
    }

    /* renamed from: d */
    public boolean m13094d() {
        return this.f7492m;
    }

    /* renamed from: e */
    public void m13092e() {
        if (f7480a) {
            this.f7490b.stop();
        }
    }

    /* renamed from: f */
    public boolean m13090f() {
        return this.f7496q;
    }

    @Override // com.baidu.tts.client.SpeechSynthesizerListener
    public void onError(String str, SpeechError speechError) {
    }

    @Override // com.baidu.tts.client.SpeechSynthesizerListener
    public void onSpeechFinish(String str) {
        f7480a = false;
        if (this.f7497r != null) {
            this.f7497r.m13087a(true);
        }
    }

    @Override // com.baidu.tts.client.SpeechSynthesizerListener
    public void onSpeechProgressChanged(String str, int i) {
    }

    @Override // com.baidu.tts.client.SpeechSynthesizerListener
    public void onSpeechStart(String str) {
        f7480a = true;
        if (this.f7497r != null) {
            this.f7497r.m13087a(false);
        }
    }

    @Override // com.baidu.tts.client.SpeechSynthesizerListener
    public void onSynthesizeDataArrived(String str, byte[] bArr, int i) {
    }

    @Override // com.baidu.tts.client.SpeechSynthesizerListener
    public void onSynthesizeFinish(String str) {
    }

    @Override // com.baidu.tts.client.SpeechSynthesizerListener
    public void onSynthesizeStart(String str) {
    }
}
