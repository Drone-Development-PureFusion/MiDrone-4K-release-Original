package com.facebook.imagepipeline.nativecode;

import com.facebook.common.soloader.SoLoaderShim;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class ImagePipelineNativeLoader {
    public static final List<String> DEPENDENCIES;
    public static final String DSO_NAME = "imagepipeline";

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add("webp");
        DEPENDENCIES = Collections.unmodifiableList(arrayList);
    }

    public static void load() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= DEPENDENCIES.size()) {
                SoLoaderShim.loadLibrary(DSO_NAME);
                return;
            } else {
                SoLoaderShim.loadLibrary(DEPENDENCIES.get(i2));
                i = i2 + 1;
            }
        }
    }
}
