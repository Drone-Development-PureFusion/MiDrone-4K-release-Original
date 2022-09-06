package com.fimi.soul.media.gallery;

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
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.camera.entity.X11FileInfo;
import com.fimi.soul.utils.C3630aa;
import com.fimi.soul.view.photodraweeview.AbstractC3867d;
import com.fimi.soul.view.photodraweeview.PhotoDraweeView;
/* loaded from: classes.dex */
public class DroneImageDetailFragment extends Fragment {

    /* renamed from: b */
    private String f11138b;

    /* renamed from: d */
    private String f11140d;

    /* renamed from: e */
    private PhotoDraweeView f11141e;

    /* renamed from: f */
    private ProgressBar f11142f;

    /* renamed from: h */
    private AbstractC3867d f11144h;

    /* renamed from: a */
    private int f11137a = 0;

    /* renamed from: c */
    private boolean f11139c = false;

    /* renamed from: g */
    private Bitmap f11143g = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.fimi.soul.media.gallery.DroneImageDetailFragment$a */
    /* loaded from: classes.dex */
    public class C2944a extends BaseControllerListener<ImageInfo> {
        private C2944a() {
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        /* renamed from: a */
        public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
            super.onFinalImageSet(str, imageInfo, animatable);
            DroneImageDetailFragment.this.f11142f.setVisibility(8);
            if (imageInfo == null || DroneImageDetailFragment.this.f11141e == null) {
                return;
            }
            DroneImageDetailFragment.this.f11141e.mo6742a(imageInfo.getWidth(), imageInfo.getHeight());
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFailure(String str, Throwable th) {
            super.onFailure(str, th);
            DroneImageDetailFragment.this.f11142f.setVisibility(8);
        }
    }

    /* renamed from: a */
    public static DroneImageDetailFragment m10049a(String str) {
        return new DroneImageDetailFragment();
    }

    /* renamed from: a */
    public int m10053a() {
        return this.f11137a;
    }

    /* renamed from: a */
    public void m10052a(int i) {
        this.f11137a = i;
    }

    /* renamed from: a */
    public void m10050a(AbstractC3867d abstractC3867d) {
        this.f11144h = abstractC3867d;
    }

    /* renamed from: b */
    public void m10048b() {
        if (this.f11138b.contains("&&")) {
            this.f11138b = this.f11138b.split("&&")[0];
        }
        if (this.f11140d != null) {
            C3630aa.m7742a(this.f11141e, this.f11140d, this.f11138b, new C2944a());
        } else {
            C3630aa.m7743a(this.f11141e, this.f11138b, new C2944a());
        }
        this.f11139c = true;
    }

    /* renamed from: b */
    public void m10046b(String str) {
        this.f11138b = str;
    }

    /* renamed from: c */
    public PhotoDraweeView m10045c() {
        return this.f11141e;
    }

    /* renamed from: c */
    public void m10044c(String str) {
        this.f11140d = str;
    }

    /* renamed from: d */
    public String m10043d() {
        return this.f11138b;
    }

    /* renamed from: e */
    public String m10042e() {
        return this.f11140d;
    }

    @Override // android.support.p001v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f11141e.getLayoutParams().height = C2252c.m13053d(getActivity()).heightPixels;
        this.f11141e.getLayoutParams().width = C2252c.m13053d(getActivity()).widthPixels;
        if (this.f11144h != null) {
            this.f11141e.setOnPhotoTapListener(this.f11144h);
        }
        if (this.f11139c) {
            m10048b();
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.image_detail_fragment, viewGroup, false);
        this.f11142f = (ProgressBar) inflate.findViewById(C2300R.C2302id.loading);
        if (this.f11138b == null || this.f11138b.endsWith(X11FileInfo.FILE_TYPE_MP4)) {
            this.f11142f.setVisibility(8);
        } else {
            this.f11142f.setVisibility(0);
        }
        this.f11141e = (PhotoDraweeView) inflate.findViewById(C2300R.C2302id.image);
        return inflate;
    }

    @Override // android.support.p001v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f11143g = null;
        System.gc();
    }

    @Override // android.support.p001v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.f11143g != null && !this.f11143g.isRecycled()) {
            this.f11143g.recycle();
        }
        System.gc();
    }
}
