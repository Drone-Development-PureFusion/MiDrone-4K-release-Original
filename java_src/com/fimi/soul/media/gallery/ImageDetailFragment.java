package com.fimi.soul.media.gallery;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.p001v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.fimi.kernel.utils.C2252c;
import com.fimi.kernel.utils.C2274s;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3630aa;
import com.fimi.soul.utils.C3710y;
import com.fimi.soul.view.photodraweeview.AbstractC3867d;
import com.fimi.soul.view.photodraweeview.PhotoDraweeView;
/* loaded from: classes.dex */
public class ImageDetailFragment extends Fragment {

    /* renamed from: e */
    private static boolean f11257e;

    /* renamed from: a */
    Bitmap f11258a = null;

    /* renamed from: b */
    private String f11259b;

    /* renamed from: c */
    private PhotoDraweeView f11260c;

    /* renamed from: d */
    private ProgressBar f11261d;

    /* renamed from: a */
    public static ImageDetailFragment m9941a(String str, boolean z) {
        ImageDetailFragment imageDetailFragment = new ImageDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        imageDetailFragment.setArguments(bundle);
        f11257e = z;
        return imageDetailFragment;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private void m9942a(PhotoDraweeView photoDraweeView, String str, Bitmap bitmap) {
        if (bitmap == null) {
            photoDraweeView.setImageResource(C2300R.C2301drawable.friends_sends_pictures_no);
        } else if (!C3710y.m7386c(str, getActivity())) {
            photoDraweeView.setImageBitmap(bitmap);
        } else {
            photoDraweeView.setBackground(C2274s.m12826a(bitmap));
            photoDraweeView.setImageResource(C2300R.C2301drawable.video_ic);
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (f11257e) {
            this.f11259b = "file://" + this.f11259b;
        }
        this.f11260c.getLayoutParams().height = C2252c.m13053d(getActivity()).heightPixels;
        this.f11260c.getLayoutParams().width = C2252c.m13053d(getActivity()).widthPixels;
        C3630aa.m7743a(this.f11260c, this.f11259b, new BaseControllerListener<ImageInfo>() { // from class: com.fimi.soul.media.gallery.ImageDetailFragment.2
            @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
            /* renamed from: a */
            public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
                super.onFinalImageSet(str, imageInfo, animatable);
                if (imageInfo == null || ImageDetailFragment.this.f11260c == null) {
                    return;
                }
                ImageDetailFragment.this.f11260c.mo6742a(imageInfo.getWidth(), imageInfo.getHeight());
            }
        });
    }

    @Override // android.support.p001v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11259b = getArguments() != null ? getArguments().getString("url") : null;
    }

    @Override // android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.image_detail_fragment, viewGroup, false);
        this.f11260c = (PhotoDraweeView) inflate.findViewById(C2300R.C2302id.image);
        this.f11260c.setOnPhotoTapListener(new AbstractC3867d() { // from class: com.fimi.soul.media.gallery.ImageDetailFragment.1
            @Override // com.fimi.soul.view.photodraweeview.AbstractC3867d
            /* renamed from: a */
            public void mo6741a(View view, float f, float f2) {
                ImageDetailFragment.this.getActivity().finish();
                ImageDetailFragment.this.getActivity().overridePendingTransition(17432576, 17432577);
            }
        });
        this.f11261d = (ProgressBar) inflate.findViewById(C2300R.C2302id.loading);
        return inflate;
    }

    @Override // android.support.p001v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f11258a = null;
        System.gc();
    }

    @Override // android.support.p001v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.f11258a != null && !this.f11258a.isRecycled()) {
            this.f11258a.recycle();
        }
        System.gc();
    }
}
