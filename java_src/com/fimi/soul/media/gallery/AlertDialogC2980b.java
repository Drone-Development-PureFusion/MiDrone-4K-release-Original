package com.fimi.soul.media.gallery;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import com.fimi.soul.C2300R;
import com.fimi.soul.view.photodraweeview.AbstractC3867d;
import com.fimi.soul.view.photodraweeview.PhotoDraweeView;
/* renamed from: com.fimi.soul.media.gallery.b */
/* loaded from: classes.dex */
public class AlertDialogC2980b extends AlertDialog implements View.OnClickListener {

    /* renamed from: a */
    private Bitmap f11281a;

    /* renamed from: b */
    private ProgressBar f11282b;

    public AlertDialogC2980b(Context context, Bitmap bitmap, int i) {
        super(context, i);
        this.f11281a = bitmap;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.gallery /* 2131493603 */:
                dismiss();
                return;
            default:
                return;
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.gallery_dialog);
        PhotoDraweeView photoDraweeView = (PhotoDraweeView) findViewById(C2300R.C2302id.gallery);
        photoDraweeView.setOnPhotoTapListener(new AbstractC3867d() { // from class: com.fimi.soul.media.gallery.b.1
            @Override // com.fimi.soul.view.photodraweeview.AbstractC3867d
            /* renamed from: a */
            public void mo6741a(View view, float f, float f2) {
                AlertDialogC2980b.this.dismiss();
            }
        });
        this.f11282b = (ProgressBar) findViewById(C2300R.C2302id.progress);
        photoDraweeView.setOnClickListener(this);
        if (this.f11281a != null) {
            photoDraweeView.setImageBitmap(this.f11281a);
            this.f11282b.setVisibility(4);
            photoDraweeView.setVisibility(0);
        }
    }
}
