package com.fimi.soul.media.player;

import android.app.Dialog;
import android.content.Context;
/* loaded from: classes.dex */
class FermiPlayerDialog extends Dialog {
    public FermiPlayerDialog(Context context) {
        super(context);
    }

    public FermiPlayerDialog(Context context, int i) {
        super(context, i);
        setCancelable(false);
    }
}
