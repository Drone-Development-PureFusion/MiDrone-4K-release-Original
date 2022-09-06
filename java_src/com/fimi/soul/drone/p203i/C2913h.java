package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.p193d.p194a.C2771d;
import com.fimi.soul.drone.p203i.C2924j;
import org.codehaus.jackson.smile.SmileConstants;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.i.h */
/* loaded from: classes.dex */
public class C2913h extends AbstractC2860a {

    /* renamed from: a */
    private C2924j.EnumC2926b f10954a = C2924j.EnumC2926b.Set;

    /* renamed from: b */
    private EnumC2914a f10955b = EnumC2914a.NormalReady;

    /* renamed from: c */
    private EnumC2915b f10956c = EnumC2915b.NormalReady;

    /* renamed from: d */
    private EnumC2916c f10957d = EnumC2916c.NoWarining;

    /* renamed from: e */
    private byte f10958e;

    /* renamed from: f */
    private byte f10959f;

    /* renamed from: g */
    private byte f10960g;

    /* renamed from: h */
    private byte f10961h;

    /* renamed from: com.fimi.soul.drone.i.h$a */
    /* loaded from: classes.dex */
    public enum EnumC2914a {
        NormalReady,
        PhotoShoting,
        VideoRecording,
        Error,
        Formating,
        NoSDCard,
        FullSDCard,
        OUTSDCard,
        WIFIINIT,
        CAMERASTART,
        SAVEPHOTO,
        LOW_SPEED_CARD,
        UPDATEPRO,
        UPDATEFAILE,
        CardNoPropose,
        CardNoProposeAndParamerr,
        CardWriteLow,
        CardWriteLowAndParamerr,
        CardSetroot,
        CardFileSysError,
        CardParametersError,
        MachineException
    }

    /* renamed from: com.fimi.soul.drone.i.h$b */
    /* loaded from: classes.dex */
    public enum EnumC2915b {
        NormalReady,
        Formating,
        NoSDCard,
        Error
    }

    /* renamed from: com.fimi.soul.drone.i.h$c */
    /* loaded from: classes.dex */
    public enum EnumC2916c {
        NoWarining,
        FullSDCard
    }

    /* renamed from: a */
    private C2924j.EnumC2926b m10297a(byte b) {
        return b == 1 ? C2924j.EnumC2926b.Set : b == 2 ? C2924j.EnumC2926b.Get : this.f10954a;
    }

    /* renamed from: b */
    private EnumC2915b m10291b(byte b) {
        return b == 1 ? EnumC2915b.NormalReady : b == 2 ? EnumC2915b.Formating : b == 3 ? EnumC2915b.NoSDCard : EnumC2915b.Error;
    }

    /* renamed from: c */
    private EnumC2916c m10289c(byte b) {
        return b == 1 ? EnumC2916c.FullSDCard : EnumC2916c.NoWarining;
    }

    @Override // com.fimi.soul.drone.p193d.AbstractC2682a
    /* renamed from: a */
    public void mo10248a(C2771d c2771d) {
        c2771d.m11052c();
        byte m11050d = c2771d.m11050d();
        this.f10958e = m11050d;
        this.f10959f = c2771d.m11050d();
        this.f10960g = c2771d.m11050d();
        this.f10961h = c2771d.m11050d();
        byte b = (byte) (m11050d & 3);
        byte b2 = (byte) ((m11050d >>> 2) & 3);
        m10297a(b2);
        byte b3 = (byte) ((b2 >>> 2) & 3);
        m10291b(b3);
        m10289c((byte) ((b3 >>> 2) & 3));
    }

    /* renamed from: a */
    public void m10296a(EnumC2914a enumC2914a) {
        this.f10955b = enumC2914a;
    }

    /* renamed from: a */
    public void m10295a(EnumC2915b enumC2915b) {
        this.f10956c = enumC2915b;
    }

    /* renamed from: a */
    public void m10294a(EnumC2916c enumC2916c) {
        this.f10957d = enumC2916c;
    }

    /* renamed from: a */
    public void m10293a(C2924j.EnumC2926b enumC2926b) {
        this.f10954a = enumC2926b;
    }

    /* renamed from: b */
    public int m10292b() {
        return this.f10958e & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
    }

    /* renamed from: c */
    public C2924j.EnumC2926b m10290c() {
        return this.f10954a;
    }

    /* renamed from: d */
    public long m10288d() {
        long j = 0;
        if (this.f10958e == 1) {
            j = this.f10959f & ((this.f10960g * 16) + 255);
        }
        return this.f10958e == 2 ? (this.f10959f * 60 * 60 * 1000) + (this.f10960g * 60 * 1000) + (this.f10961h * 1000) : j;
    }

    /* renamed from: e */
    public int m10287e() {
        return this.f10959f;
    }

    /* renamed from: f */
    public EnumC2914a m10286f() {
        return this.f10958e == 0 ? EnumC2914a.NormalReady : this.f10958e == 1 ? EnumC2914a.PhotoShoting : this.f10958e == 2 ? EnumC2914a.VideoRecording : this.f10958e == 3 ? EnumC2914a.MachineException : this.f10958e == 16 ? EnumC2914a.Formating : this.f10958e == 17 ? EnumC2914a.CardNoPropose : this.f10958e == 18 ? EnumC2914a.CardNoProposeAndParamerr : this.f10958e == 19 ? EnumC2914a.CardWriteLow : this.f10958e == 20 ? EnumC2914a.CardWriteLowAndParamerr : this.f10958e == 21 ? EnumC2914a.CardSetroot : this.f10958e == 32 ? EnumC2914a.NoSDCard : this.f10958e == 48 ? EnumC2914a.CardParametersError : this.f10958e == 64 ? EnumC2914a.FullSDCard : this.f10958e == 80 ? EnumC2914a.OUTSDCard : this.f10958e == 81 ? EnumC2914a.CAMERASTART : this.f10958e == 82 ? EnumC2914a.WIFIINIT : this.f10958e == 83 ? EnumC2914a.SAVEPHOTO : this.f10958e == 84 ? EnumC2914a.LOW_SPEED_CARD : this.f10958e == 85 ? EnumC2914a.CardFileSysError : (this.f10958e & SmileConstants.BYTE_MARKER_END_OF_CONTENT) == 255 ? EnumC2914a.UPDATEPRO : (this.f10958e & SmileConstants.BYTE_MARKER_END_OF_CONTENT) == 254 ? EnumC2914a.UPDATEFAILE : EnumC2914a.Error;
    }

    /* renamed from: g */
    public EnumC2915b m10285g() {
        return this.f10956c;
    }

    /* renamed from: h */
    public EnumC2916c m10284h() {
        return this.f10957d;
    }

    public String toString() {
        return "CloudCameraStatusVariable{cameraMode=" + this.f10954a + ", cameraStatus=" + this.f10955b + ", sdCardStatus=" + this.f10956c + ", waringStatus=" + this.f10957d + ", status = " + ((int) this.f10958e) + ", time = " + m10288d() + C0359h.f726w;
    }
}
