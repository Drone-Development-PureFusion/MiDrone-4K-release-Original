package com.baidu.tts.p108l;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.p096e.EnumC1695a;
import com.baidu.tts.p096e.EnumC1702e;
import com.baidu.tts.p109m.AbstractC1767a;
/* renamed from: com.baidu.tts.l.h */
/* loaded from: classes.dex */
public class C1744h extends AbstractC1767a<C1744h> {

    /* renamed from: a */
    private EnumC1702e f6253a;

    /* renamed from: b */
    private int f6254b;

    /* renamed from: c */
    private int f6255c;

    /* renamed from: d */
    private String f6256d;

    /* renamed from: e */
    private int f6257e;

    /* renamed from: f */
    private int f6258f;

    /* renamed from: g */
    private byte[] f6259g;

    /* renamed from: h */
    private EnumC1695a f6260h;

    /* renamed from: i */
    private C1745i f6261i;

    /* renamed from: j */
    private TtsError f6262j;

    /* renamed from: a */
    public static C1744h m14755a(C1745i c1745i, TtsError ttsError) {
        C1744h m14749b = m14749b(c1745i);
        m14749b.m14759a(ttsError);
        return m14749b;
    }

    /* renamed from: b */
    public static C1744h m14750b(TtsError ttsError) {
        C1744h c1744h = new C1744h();
        c1744h.m14759a(ttsError);
        return c1744h;
    }

    /* renamed from: b */
    public static C1744h m14749b(C1745i c1745i) {
        C1744h c1744h = new C1744h();
        c1744h.m14756a(c1745i);
        return c1744h;
    }

    /* renamed from: a */
    public int m14761a() {
        return this.f6255c;
    }

    /* renamed from: a */
    public void m14760a(int i) {
        this.f6255c = i;
    }

    /* renamed from: a */
    public void m14759a(TtsError ttsError) {
        this.f6262j = ttsError;
    }

    /* renamed from: a */
    public void m14758a(EnumC1695a enumC1695a) {
        this.f6260h = enumC1695a;
    }

    /* renamed from: a */
    public void m14757a(EnumC1702e enumC1702e) {
        this.f6253a = enumC1702e;
    }

    /* renamed from: a */
    public void m14756a(C1745i c1745i) {
        this.f6261i = c1745i;
    }

    /* renamed from: a */
    public void m14754a(String str) {
        this.f6256d = str;
    }

    /* renamed from: a */
    public void m14753a(byte[] bArr) {
        this.f6259g = bArr;
    }

    /* renamed from: b */
    public int m14752b() {
        return this.f6257e;
    }

    /* renamed from: b */
    public void m14751b(int i) {
        this.f6257e = i;
    }

    /* renamed from: c */
    public int m14748c() {
        return this.f6258f;
    }

    /* renamed from: c */
    public void m14747c(int i) {
        this.f6258f = i;
    }

    /* renamed from: d */
    public void m14745d(int i) {
        this.f6254b = i;
    }

    /* renamed from: d */
    public byte[] m14746d() {
        return this.f6259g;
    }

    /* renamed from: e */
    public C1745i m14744e() {
        return this.f6261i;
    }

    /* renamed from: f */
    public TtsError m14743f() {
        return this.f6262j;
    }
}
