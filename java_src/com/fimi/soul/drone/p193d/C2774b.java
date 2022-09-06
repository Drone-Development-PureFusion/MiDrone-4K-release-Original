package com.fimi.soul.drone.p193d;

import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2772e;
/* renamed from: com.fimi.soul.drone.d.b */
/* loaded from: classes.dex */
public class C2774b {

    /* renamed from: b */
    static boolean f10275b;

    /* renamed from: a */
    EnumC2776a f10276a = EnumC2776a.MILINK_PARSE_STATE_UNINIT;

    /* renamed from: c */
    public C2772e f10277c = new C2772e();

    /* renamed from: d */
    private C2770c f10278d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fimi.soul.drone.d.b$a */
    /* loaded from: classes.dex */
    public enum EnumC2776a {
        MILINK_PARSE_STATE_GOT_COMPID,
        MILINK_PARSE_STATE_UNINIT,
        MILINK_PARSE_STATE_IDLE,
        MILINK_PARSE_STATE_GOT_STX,
        MILINK_PARSE_STATE_GOT_LENGTH,
        MILINK_PARSE_STATE_GOT_MSGID,
        MILINK_PARSE_STATE_GOT_CRC1,
        MILINK_PARSE_STATE_GOT_PAYLOAD
    }

    /* renamed from: a */
    public C2770c m11034a(int i) {
        f10275b = false;
        switch (this.f10276a) {
            case MILINK_PARSE_STATE_UNINIT:
            case MILINK_PARSE_STATE_IDLE:
                if (i == 254) {
                    this.f10276a = EnumC2776a.MILINK_PARSE_STATE_GOT_STX;
                    this.f10278d = new C2770c();
                    break;
                }
                break;
            case MILINK_PARSE_STATE_GOT_STX:
                if (!f10275b) {
                    this.f10278d.f10262b = i;
                    this.f10276a = EnumC2776a.MILINK_PARSE_STATE_GOT_LENGTH;
                    break;
                } else {
                    f10275b = false;
                    this.f10276a = EnumC2776a.MILINK_PARSE_STATE_IDLE;
                    break;
                }
            case MILINK_PARSE_STATE_GOT_LENGTH:
                this.f10278d.f10263c = i;
                this.f10276a = EnumC2776a.MILINK_PARSE_STATE_GOT_MSGID;
                break;
            case MILINK_PARSE_STATE_GOT_MSGID:
                this.f10278d.f10264d.m11063a((byte) i);
                if (this.f10278d.m11072a()) {
                    this.f10276a = EnumC2776a.MILINK_PARSE_STATE_GOT_PAYLOAD;
                    break;
                }
                break;
            case MILINK_PARSE_STATE_GOT_PAYLOAD:
                this.f10278d.m11070b();
                if (i == this.f10278d.f10265e.m11187c()) {
                    this.f10276a = EnumC2776a.MILINK_PARSE_STATE_GOT_CRC1;
                    break;
                } else {
                    f10275b = false;
                    this.f10276a = EnumC2776a.MILINK_PARSE_STATE_IDLE;
                    if (i == 254) {
                        this.f10276a = EnumC2776a.MILINK_PARSE_STATE_GOT_STX;
                        this.f10278d.f10265e.m11191a();
                    }
                    this.f10277c.m11040a();
                    break;
                }
            case MILINK_PARSE_STATE_GOT_CRC1:
                if (i == this.f10278d.f10265e.m11189b()) {
                    this.f10277c.m11038a(this.f10278d);
                    f10275b = true;
                    this.f10276a = EnumC2776a.MILINK_PARSE_STATE_IDLE;
                    break;
                } else {
                    f10275b = false;
                    this.f10276a = EnumC2776a.MILINK_PARSE_STATE_IDLE;
                    if (i == 254) {
                        this.f10276a = EnumC2776a.MILINK_PARSE_STATE_GOT_STX;
                        this.f10278d.f10265e.m11191a();
                    }
                    this.f10277c.m11040a();
                    break;
                }
        }
        if (f10275b) {
            return this.f10278d;
        }
        return null;
    }
}
