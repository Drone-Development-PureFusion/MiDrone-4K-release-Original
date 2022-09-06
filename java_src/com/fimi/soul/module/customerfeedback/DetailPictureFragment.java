package com.fimi.soul.module.customerfeedback;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p001v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.fimi.kernel.utils.C2252c;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3630aa;
import com.fimi.soul.view.photodraweeview.AbstractC3867d;
import com.fimi.soul.view.photodraweeview.PhotoDraweeView;
/* loaded from: classes.dex */
public class DetailPictureFragment extends Fragment {

    /* renamed from: a */
    public static final String f11506a = "UriKey";

    /* renamed from: b */
    private int f11507b;

    /* renamed from: c */
    private Uri f11508c;

    /* renamed from: d */
    private PhotoDraweeView f11509d;

    /* renamed from: e */
    private ProgressBar f11510e;

    /* renamed from: f */
    private AbstractC3867d f11511f;

    /* renamed from: g */
    private boolean f11512g;

    /* renamed from: h */
    private boolean f11513h;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.fimi.soul.module.customerfeedback.DetailPictureFragment$a */
    /* loaded from: classes.dex */
    public class C3080a extends BaseControllerListener<ImageInfo> {
        private C3080a() {
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        /* renamed from: a */
        public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
            super.onFinalImageSet(str, imageInfo, animatable);
            DetailPictureFragment.this.f11510e.setVisibility(8);
            if (imageInfo == null || DetailPictureFragment.this.f11509d == null) {
                return;
            }
            DetailPictureFragment.this.f11509d.mo6742a(imageInfo.getWidth(), imageInfo.getHeight());
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFailure(String str, Throwable th) {
            super.onFailure(str, th);
            DetailPictureFragment.this.f11510e.setVisibility(8);
        }
    }

    /* renamed from: a */
    public static DetailPictureFragment m9722a(Uri uri) {
        DetailPictureFragment detailPictureFragment = new DetailPictureFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(f11506a, uri);
        detailPictureFragment.setArguments(bundle);
        return detailPictureFragment;
    }

    /* renamed from: a */
    public int m9724a() {
        return this.f11507b;
    }

    /* renamed from: a */
    public void m9723a(int i) {
        this.f11507b = i;
    }

    /* renamed from: a */
    public void m9720a(AbstractC3867d abstractC3867d) {
        if (abstractC3867d != null) {
            this.f11509d.setOnPhotoTapListener(abstractC3867d);
            this.f11511f = abstractC3867d;
        }
    }

    /* renamed from: b */
    public void m9719b() {
        if (this.f11508c == null || this.f11510e == null || this.f11509d == null || !this.f11513h) {
            return;
        }
        this.f11510e.setVisibility(0);
        C3630aa.m7743a(this.f11509d, this.f11508c.toString(), new C3080a());
        C3083a.m9700a().m9699a(this.f11508c);
        this.f11512g = true;
    }

    /* renamed from: b */
    public void m9718b(Uri uri) {
        this.f11508c = uri;
    }

    /* renamed from: c */
    public Uri m9716c() {
        return this.f11508c;
    }

    /* renamed from: d */
    public boolean m9715d() {
        return this.f11512g;
    }

    @Override // android.support.p001v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f11509d.getLayoutParams().height = C2252c.m13053d(getActivity()).heightPixels;
        this.f11509d.getLayoutParams().width = C2252c.m13053d(getActivity()).widthPixels;
    }

    @Override // android.support.p001v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // android.support.p001v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f11508c = (Uri) arguments.getParcelable(f11506a);
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.feedback_image_detail_fragment, (ViewGroup) null);
        this.f11509d = (PhotoDraweeView) inflate.findViewById(C2300R.C2302id.image);
        this.f11510e = (ProgressBar) inflate.findViewById(C2300R.C2302id.loading);
        return inflate;
    }

    @Override // android.support.p001v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (!getUserVisibleHint()) {
            this.f11513h = false;
            return;
        }
        this.f11513h = true;
        m9719b();
    }
}
