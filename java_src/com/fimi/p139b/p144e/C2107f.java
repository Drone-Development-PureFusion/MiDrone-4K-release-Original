package com.fimi.p139b.p144e;
/* renamed from: com.fimi.b.e.f */
/* loaded from: classes.dex */
public class C2107f {

    /* renamed from: b */
    static boolean f7043b;

    /* renamed from: a */
    EnumC2109a f7044a = EnumC2109a.UNINIT;

    /* renamed from: c */
    public C2106e f7045c = new C2106e();

    /* renamed from: d */
    private C2104c f7046d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fimi.b.e.f$a */
    /* loaded from: classes.dex */
    public enum EnumC2109a {
        UNINIT,
        IDLE,
        STX,
        LENGHT,
        TARGETID,
        SOURCEID,
        SEQ,
        MSGID,
        PAYLOAD,
        CRC1
    }

    /* renamed from: a */
    public C2104c m13671a(int i) {
        f7043b = false;
        switch (this.f7044a) {
            case UNINIT:
            case IDLE:
                if (i == 254) {
                    this.f7044a = EnumC2109a.STX;
                    this.f7046d = new C2104c();
                    break;
                }
                break;
            case STX:
                if (!f7043b) {
                    this.f7046d.m13712a(1, i);
                    this.f7044a = EnumC2109a.LENGHT;
                    break;
                } else {
                    f7043b = false;
                    this.f7044a = EnumC2109a.IDLE;
                    break;
                }
            case LENGHT:
                this.f7046d.m13712a(2, i);
                this.f7044a = EnumC2109a.TARGETID;
                break;
            case TARGETID:
                this.f7046d.m13712a(3, i);
                this.f7044a = EnumC2109a.SOURCEID;
                break;
            case SOURCEID:
                this.f7046d.m13712a(4, i);
                this.f7044a = EnumC2109a.SEQ;
                break;
            case SEQ:
                this.f7046d.m13712a(5, i);
                this.f7044a = EnumC2109a.MSGID;
                if (this.f7046d.m13709b() == 4) {
                    this.f7044a = EnumC2109a.PAYLOAD;
                    break;
                }
                break;
            case MSGID:
                this.f7046d.f7028b.m13700a((byte) i);
                if (this.f7046d.m13705d()) {
                    this.f7044a = EnumC2109a.PAYLOAD;
                    break;
                }
                break;
            case PAYLOAD:
                this.f7046d.m13704e();
                if (i == this.f7046d.f7029c.m13725c()) {
                    this.f7044a = EnumC2109a.CRC1;
                    break;
                } else {
                    f7043b = false;
                    this.f7044a = EnumC2109a.IDLE;
                    if (i == 254) {
                        this.f7044a = EnumC2109a.STX;
                        this.f7046d.f7029c.m13729a();
                    }
                    this.f7045c.m13676a();
                    break;
                }
            case CRC1:
                if (i == this.f7046d.f7029c.m13727b()) {
                    this.f7045c.m13674a(this.f7046d);
                    f7043b = true;
                    this.f7044a = EnumC2109a.IDLE;
                    break;
                } else {
                    f7043b = false;
                    this.f7044a = EnumC2109a.IDLE;
                    if (i == 254) {
                        this.f7044a = EnumC2109a.STX;
                        this.f7046d.f7029c.m13729a();
                    }
                    this.f7045c.m13676a();
                    break;
                }
        }
        if (f7043b) {
            return this.f7046d;
        }
        return null;
    }
}
