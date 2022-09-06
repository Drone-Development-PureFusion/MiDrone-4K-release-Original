package com.fimi.soul.utils;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Sets;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.listener.RequestLoggingListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.fimi.kernel.C2238c;
import com.fimi.soul.biz.camera.entity.X11FileInfo;
/* renamed from: com.fimi.soul.utils.aa */
/* loaded from: classes.dex */
public class C3630aa {

    /* renamed from: a */
    private static final String f14778a = "imagepipeline_cache";

    /* renamed from: c */
    private static final int f14780c = 41943040;

    /* renamed from: e */
    private static ImagePipelineConfig f14782e;

    /* renamed from: b */
    private static final int f14779b = (int) Runtime.getRuntime().maxMemory();

    /* renamed from: d */
    private static final int f14781d = f14779b / 4;

    /* renamed from: a */
    public static void m7745a() {
        Fresco.initialize(C2238c.m13131a(), m7738c());
    }

    /* renamed from: a */
    public static void m7744a(SimpleDraweeView simpleDraweeView, String str) {
        m7743a(simpleDraweeView, str, null);
    }

    /* renamed from: a */
    public static void m7743a(SimpleDraweeView simpleDraweeView, String str, ControllerListener controllerListener) {
        if (str == null) {
            return;
        }
        int i = simpleDraweeView.getLayoutParams().width;
        int i2 = simpleDraweeView.getLayoutParams().height;
        PipelineDraweeControllerBuilder newDraweeControllerBuilder = Fresco.newDraweeControllerBuilder();
        newDraweeControllerBuilder.setOldController(simpleDraweeView.getController());
        newDraweeControllerBuilder.setAutoPlayAnimations(true);
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.parse(str));
        newBuilderWithSource.setProgressiveRenderingEnabled(true);
        Log.d("Good", str);
        if (i > 0 && i2 > 0) {
            newBuilderWithSource.setResizeOptions(new ResizeOptions(i, i2));
        }
        newDraweeControllerBuilder.setImageRequest(newBuilderWithSource.build());
        newDraweeControllerBuilder.setControllerListener(controllerListener);
        simpleDraweeView.setController(newDraweeControllerBuilder.build());
    }

    /* renamed from: a */
    public static void m7742a(SimpleDraweeView simpleDraweeView, String str, String str2, ControllerListener controllerListener) {
        if (str2 == null) {
            return;
        }
        int i = simpleDraweeView.getLayoutParams().width;
        int i2 = simpleDraweeView.getLayoutParams().height;
        PipelineDraweeControllerBuilder newDraweeControllerBuilder = Fresco.newDraweeControllerBuilder();
        if (!str.startsWith("file:///")) {
            str = "file://" + str;
        }
        if (str != null && str.length() > 0) {
            newDraweeControllerBuilder.setLowResImageRequest(ImageRequest.fromUri(str));
        }
        newDraweeControllerBuilder.setOldController(simpleDraweeView.getController());
        newDraweeControllerBuilder.setAutoPlayAnimations(true);
        ImageRequestBuilder newBuilderWithSource = str2.endsWith(X11FileInfo.FILE_TYPE_MP4) ? ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)) : ImageRequestBuilder.newBuilderWithSource(Uri.parse(str2));
        if (i > 0 && i2 > 0) {
            newBuilderWithSource.setResizeOptions(new ResizeOptions(i, i2));
        }
        newDraweeControllerBuilder.setImageRequest(newBuilderWithSource.build());
        newDraweeControllerBuilder.setControllerListener(controllerListener);
        simpleDraweeView.setController(newDraweeControllerBuilder.build());
    }

    /* renamed from: a */
    private static void m7741a(ImagePipelineConfig.Builder builder) {
        builder.setRequestListeners(Sets.newHashSet(new RequestLoggingListener()));
    }

    /* renamed from: a */
    private static void m7740a(ImagePipelineConfig.Builder builder, Context context) {
        final MemoryCacheParams memoryCacheParams = new MemoryCacheParams(f14781d, Integer.MAX_VALUE, f14781d, Integer.MAX_VALUE, Integer.MAX_VALUE);
        builder.setBitmapMemoryCacheParamsSupplier(new Supplier<MemoryCacheParams>() { // from class: com.fimi.soul.utils.aa.1
            @Override // com.facebook.common.internal.Supplier
            /* renamed from: a */
            public MemoryCacheParams mo21803get() {
                return MemoryCacheParams.this;
            }
        }).setMainDiskCacheConfig(DiskCacheConfig.newBuilder().setBaseDirectoryPath(context.getApplicationContext().getCacheDir()).setBaseDirectoryName(f14778a).setMaxCacheSize(41943040L).build());
    }

    /* renamed from: b */
    public static void m7739b() {
        Fresco.shutDown();
    }

    /* renamed from: c */
    public static ImagePipelineConfig m7738c() {
        if (f14782e == null) {
            ImagePipelineConfig.Builder newBuilder = ImagePipelineConfig.newBuilder(C2238c.m13131a());
            m7740a(newBuilder, C2238c.m13131a());
            m7741a(newBuilder);
            f14782e = newBuilder.build();
        }
        return f14782e;
    }

    /* renamed from: d */
    public static void m7737d() {
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        imagePipeline.clearMemoryCaches();
        imagePipeline.clearDiskCaches();
    }
}
