package com.baidu.tts.p108l;

import com.baidu.tts.p085b.p086a.p088b.C1631e;
import com.baidu.tts.p085b.p086a.p088b.C1634f;
import com.baidu.tts.p085b.p089b.p091b.C1653b;
import com.baidu.tts.p096e.EnumC1696b;
import com.baidu.tts.p096e.EnumC1700c;
import com.baidu.tts.p096e.EnumC1701d;
import com.baidu.tts.p096e.EnumC1704g;
import com.baidu.tts.p096e.EnumC1707j;
import com.baidu.tts.p109m.AbstractC1767a;
/* renamed from: com.baidu.tts.l.j */
/* loaded from: classes.dex */
public class C1746j extends AbstractC1767a<C1746j> {

    /* renamed from: a */
    private C1738b f6268a = new C1738b();

    /* renamed from: b */
    private C1737a f6269b = new C1737a();

    /* renamed from: b */
    private int m14727b(EnumC1704g enumC1704g, String str) {
        EnumC1707j enumC1707j;
        C1631e.C1632a m14793b = this.f6268a.m14793b();
        C1634f.C1636b m14796a = this.f6268a.m14796a();
        C1653b.C1654a m14798a = this.f6269b.m14798a();
        switch (enumC1704g) {
            case SPEED:
                this.f6268a.m14794a(str);
                break;
            case VOLUME:
                this.f6268a.m14792b(str);
                break;
            case PITCH:
                this.f6268a.m14790c(str);
                break;
            case TEXT_DAT_PATH:
                m14793b.m15209e(str);
                break;
            case SPEECH_DAT_PATH:
                m14793b.m15207f(str);
                break;
            case TTS_LICENSE_FILE_PATH:
                m14793b.m15205g(str);
                break;
            case APP_CODE:
                m14793b.m15203h(str);
                break;
            case TEXT_ENCODE:
                m14796a.a(EnumC1701d.m14901a(str));
                break;
            case NOTIFICATION_COUNT_PER_SECOND:
                m14798a.a(str);
                break;
            case PRODUCT_ID:
                m14796a.m15179c(str);
                break;
            case AUDIO_ENCODE:
                return m14796a.m15187a(EnumC1696b.m14905a(str));
            case BITRATE:
                m14796a.m15186a(EnumC1700c.m14903a(str));
                break;
            case BACKGROUND:
                m14796a.m15173f(str);
                break;
            case CUSTOM_SYNTH:
                return m14793b.m15213c(str);
            case LANGUAGE:
                m14796a.i(str);
                m14793b.i(str);
                break;
            case OPEN_XML:
                return m14793b.m15211d(str);
            case PUNCTUATION:
                m14796a.m15169h(str);
                break;
            case SPEAKER:
                m14796a.m15177d(str);
                break;
            case STYLE:
                m14796a.m15175e(str);
                break;
            case TERRITORY:
                m14796a.m15171g(str);
                break;
            case TTS_VOCODER_OPTIMIZATION:
                return m14793b.m15217a(str);
            case API_KEY:
                m14796a.m15185a(str);
                break;
            case SECRET_KEY:
                m14796a.m15182b(str);
                break;
            case STREAM_TYPE:
                this.f6269b.m14797a(Integer.parseInt(str));
                break;
            case MIX_MODE:
                try {
                    enumC1707j = EnumC1707j.valueOf(str);
                } catch (Exception e) {
                    enumC1707j = EnumC1707j.DEFAULT;
                }
                this.f6268a.m14795a(enumC1707j);
                break;
            case SAMPLE_RATE:
                m14793b.m15215b(str);
                break;
        }
        return 0;
    }

    /* renamed from: a */
    public int m14729a(EnumC1704g enumC1704g, String str) {
        return m14727b(enumC1704g, str);
    }

    /* renamed from: a */
    public C1738b m14730a() {
        return this.f6268a;
    }

    /* renamed from: b */
    public C1737a m14728b() {
        return this.f6269b;
    }

    /* renamed from: c */
    public C1634f.C1636b m14726c() {
        return this.f6268a.m14796a();
    }

    /* renamed from: d */
    public C1631e.C1632a m14725d() {
        return this.f6268a.m14793b();
    }

    /* renamed from: e */
    public C1653b.C1654a m14724e() {
        return this.f6269b.m14798a();
    }
}
