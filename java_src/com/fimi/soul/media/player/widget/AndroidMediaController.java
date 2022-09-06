package com.fimi.soul.media.player.widget;

import android.app.ActionBar;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class AndroidMediaController extends FmMediaController implements IMediaController {
    private ActionBar mActionBar;
    private ArrayList<View> mShowOnceArray = new ArrayList<>();

    public AndroidMediaController(Context context) {
        super(context);
        initView(context);
    }

    public AndroidMediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public AndroidMediaController(Context context, boolean z) {
        super(context, z);
        initView(context);
    }

    private void initView(Context context) {
    }

    @Override // com.fimi.soul.media.player.widget.FmMediaController, com.fimi.soul.media.player.widget.IMediaController
    public void hide() {
        super.hide();
        if (this.mActionBar != null) {
            this.mActionBar.hide();
        }
        Iterator<View> it2 = this.mShowOnceArray.iterator();
        while (it2.hasNext()) {
            it2.next().setVisibility(8);
        }
    }

    public void setSupportActionBar(@Nullable ActionBar actionBar) {
        this.mActionBar = actionBar;
        if (isShowing()) {
            actionBar.show();
        } else {
            actionBar.hide();
        }
    }

    @Override // com.fimi.soul.media.player.widget.FmMediaController, com.fimi.soul.media.player.widget.IMediaController
    public void show() {
        super.show();
        if (this.mActionBar != null) {
            this.mActionBar.show();
        }
        Iterator<View> it2 = this.mShowOnceArray.iterator();
        while (it2.hasNext()) {
            it2.next().setVisibility(0);
        }
    }

    @Override // com.fimi.soul.media.player.widget.IMediaController
    public void showOnce(@NonNull View view) {
        this.mShowOnceArray.add(view);
        view.setVisibility(0);
        show();
    }
}
