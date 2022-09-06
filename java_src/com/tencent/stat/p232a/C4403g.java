package com.tencent.stat.p232a;

import android.content.Context;
import com.tencent.stat.StatGameUser;
import com.tencent.stat.common.C4420k;
import org.json.JSONObject;
/* renamed from: com.tencent.stat.a.g */
/* loaded from: classes2.dex */
public class C4403g extends AbstractC4401e {

    /* renamed from: a */
    private StatGameUser f18393a;

    public C4403g(Context context, int i, StatGameUser statGameUser) {
        super(context, i);
        this.f18393a = null;
        this.f18393a = statGameUser.m21865clone();
    }

    @Override // com.tencent.stat.p232a.AbstractC4401e
    /* renamed from: a */
    public EnumC4402f mo5242a() {
        return EnumC4402f.MTA_GAME_USER;
    }

    @Override // com.tencent.stat.p232a.AbstractC4401e
    /* renamed from: a */
    public boolean mo5241a(JSONObject jSONObject) {
        if (this.f18393a == null) {
            return false;
        }
        C4420k.m5199a(jSONObject, "wod", this.f18393a.getWorldName());
        C4420k.m5199a(jSONObject, "gid", this.f18393a.getAccount());
        C4420k.m5199a(jSONObject, "lev", this.f18393a.getLevel());
        return true;
    }
}
