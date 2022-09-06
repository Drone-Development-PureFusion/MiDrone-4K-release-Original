package com.p078a.p079a;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.a.a.h */
/* loaded from: classes.dex */
public class C0730h implements AbstractC0745u {

    /* renamed from: a */
    private final Charset f1803a;

    public C0730h(Charset charset) {
        this.f1803a = charset;
    }

    @Override // com.p078a.p079a.AbstractC0745u
    /* renamed from: a */
    public String mo19201a(byte[] bArr) {
        return this.f1803a.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(bArr)).toString();
    }

    @Override // com.p078a.p079a.AbstractC0745u
    /* renamed from: a */
    public boolean mo19202a(String str) {
        CharsetEncoder newEncoder = this.f1803a.newEncoder();
        newEncoder.onMalformedInput(CodingErrorAction.REPORT);
        newEncoder.onUnmappableCharacter(CodingErrorAction.REPORT);
        return newEncoder.canEncode(str);
    }

    @Override // com.p078a.p079a.AbstractC0745u
    /* renamed from: b */
    public ByteBuffer mo19200b(String str) {
        CharsetEncoder newEncoder = this.f1803a.newEncoder();
        newEncoder.onMalformedInput(CodingErrorAction.REPORT);
        newEncoder.onUnmappableCharacter(CodingErrorAction.REPORT);
        CharBuffer wrap = CharBuffer.wrap(str);
        ByteBuffer allocate = ByteBuffer.allocate(str.length() + ((str.length() + 1) / 2));
        while (true) {
            if (wrap.remaining() <= 0) {
                break;
            }
            CoderResult encode = newEncoder.encode(wrap, allocate, true);
            if (encode.isUnmappable() || encode.isMalformed()) {
                if (encode.length() * 6 > allocate.remaining()) {
                    allocate = AbstractC0746v.m19197a(allocate, allocate.position() + (encode.length() * 6));
                }
                for (int i = 0; i < encode.length(); i++) {
                    AbstractC0746v.m19198a(allocate, wrap.get());
                }
            } else if (encode.isOverflow()) {
                allocate = AbstractC0746v.m19197a(allocate, 0);
            } else if (encode.isUnderflow()) {
                newEncoder.flush(allocate);
                break;
            }
        }
        allocate.limit(allocate.position());
        allocate.rewind();
        return allocate;
    }
}
