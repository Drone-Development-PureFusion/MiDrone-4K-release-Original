package com.tencent.p227mm.sdk.platformtools;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.p227mm.sdk.platformtools.BackwardSupportUtil;
/* renamed from: com.tencent.mm.sdk.platformtools.AnimationHelperImpl22 */
/* loaded from: classes.dex */
class AnimationHelperImpl22 implements BackwardSupportUtil.AnimationHelper.IHelper {
    @Override // com.tencent.p227mm.sdk.platformtools.BackwardSupportUtil.AnimationHelper.IHelper
    public void cancelAnimation(View view, Animation animation) {
        animation.cancel();
    }
}
