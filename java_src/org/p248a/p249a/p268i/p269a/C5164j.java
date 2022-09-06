package org.p248a.p249a.p268i.p269a;

import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.InvalidCredentialsException;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.auth.NTCredentials;
import org.apache.http.impl.auth.NTLMEngine;
import org.apache.http.message.BufferedHeader;
import org.apache.http.util.CharArrayBuffer;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.i.a.j */
/* loaded from: classes2.dex */
public class C5164j extends AbstractC5147a {

    /* renamed from: a */
    private final NTLMEngine f21907a;

    /* renamed from: b */
    private EnumC5165a f21908b;

    /* renamed from: c */
    private String f21909c;

    /* renamed from: org.a.a.i.a.j$a */
    /* loaded from: classes2.dex */
    enum EnumC5165a {
        UNINITIATED,
        CHALLENGE_RECEIVED,
        MSG_TYPE1_GENERATED,
        MSG_TYPE2_RECEVIED,
        MSG_TYPE3_GENERATED,
        FAILED
    }

    public C5164j() {
        this(new C5155h());
    }

    public C5164j(NTLMEngine nTLMEngine) {
        C5351a.m1321a(nTLMEngine, "NTLM engine");
        this.f21907a = nTLMEngine;
        this.f21908b = EnumC5165a.UNINITIATED;
        this.f21909c = null;
    }

    @Override // org.p248a.p249a.p268i.p269a.AbstractC5147a
    /* renamed from: a */
    protected void mo1809a(CharArrayBuffer charArrayBuffer, int i, int i2) {
        this.f21909c = charArrayBuffer.substringTrimmed(i, i2);
        if (this.f21909c.length() == 0) {
            if (this.f21908b == EnumC5165a.UNINITIATED) {
                this.f21908b = EnumC5165a.CHALLENGE_RECEIVED;
            } else {
                this.f21908b = EnumC5165a.FAILED;
            }
        } else if (this.f21908b.compareTo(EnumC5165a.MSG_TYPE1_GENERATED) < 0) {
            this.f21908b = EnumC5165a.FAILED;
            throw new MalformedChallengeException("Out of sequence NTLM response message");
        } else if (this.f21908b != EnumC5165a.MSG_TYPE1_GENERATED) {
        } else {
            this.f21908b = EnumC5165a.MSG_TYPE2_RECEVIED;
        }
    }

    public Header authenticate(Credentials credentials, HttpRequest httpRequest) {
        String generateType3Msg;
        try {
            NTCredentials nTCredentials = (NTCredentials) credentials;
            if (this.f21908b == EnumC5165a.FAILED) {
                throw new AuthenticationException("NTLM authentication failed");
            }
            if (this.f21908b == EnumC5165a.CHALLENGE_RECEIVED) {
                generateType3Msg = this.f21907a.generateType1Msg(nTCredentials.getDomain(), nTCredentials.getWorkstation());
                this.f21908b = EnumC5165a.MSG_TYPE1_GENERATED;
            } else if (this.f21908b != EnumC5165a.MSG_TYPE2_RECEVIED) {
                throw new AuthenticationException("Unexpected state: " + this.f21908b);
            } else {
                generateType3Msg = this.f21907a.generateType3Msg(nTCredentials.getUserName(), nTCredentials.getPassword(), nTCredentials.getDomain(), nTCredentials.getWorkstation(), this.f21909c);
                this.f21908b = EnumC5165a.MSG_TYPE3_GENERATED;
            }
            CharArrayBuffer charArrayBuffer = new CharArrayBuffer(32);
            if (a()) {
                charArrayBuffer.append(C5083e.f21650N);
            } else {
                charArrayBuffer.append("Authorization");
            }
            charArrayBuffer.append(": NTLM ");
            charArrayBuffer.append(generateType3Msg);
            return new BufferedHeader(charArrayBuffer);
        } catch (ClassCastException e) {
            throw new InvalidCredentialsException("Credentials cannot be used for NTLM authentication: " + credentials.getClass().getName());
        }
    }

    public String getParameter(String str) {
        return null;
    }

    public String getRealm() {
        return null;
    }

    public String getSchemeName() {
        return "ntlm";
    }

    public boolean isComplete() {
        return this.f21908b == EnumC5165a.MSG_TYPE3_GENERATED || this.f21908b == EnumC5165a.FAILED;
    }

    public boolean isConnectionBased() {
        return true;
    }
}
