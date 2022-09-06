package com.amap.api.maps.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.FrameLayout;
import com.amap.api.mapcore.util.AbstractC0927dv;
import com.amap.api.mapcore.util.C0945eh;
import com.amap.api.mapcore.util.C1119p;
import java.io.FileInputStream;
import java.io.InputStream;
/* loaded from: classes.dex */
public final class BitmapDescriptorFactory {
    public static final float HUE_AZURE = 210.0f;
    public static final float HUE_BLUE = 240.0f;
    public static final float HUE_CYAN = 180.0f;
    public static final float HUE_GREEN = 120.0f;
    public static final float HUE_MAGENTA = 300.0f;
    public static final float HUE_ORANGE = 30.0f;
    public static final float HUE_RED = 0.0f;
    public static final float HUE_ROSE = 330.0f;
    public static final float HUE_VIOLET = 270.0f;
    public static final float HUE_YELLOW = 60.0f;

    public static BitmapDescriptor defaultMarker() {
        try {
            return fromAsset(AbstractC0927dv.EnumC0928a.marker_default.name() + ".png");
        } catch (Throwable th) {
            return null;
        }
    }

    public static BitmapDescriptor defaultMarker(float f) {
        try {
            float f2 = (((int) (15.0f + f)) / 30) * 30;
            float f3 = f2 > 330.0f ? 330.0f : f2 < 0.0f ? 0.0f : f2;
            String str = "";
            if (f3 == 0.0f) {
                str = "RED";
            } else if (f3 == 30.0f) {
                str = "ORANGE";
            } else if (f3 == 60.0f) {
                str = "YELLOW";
            } else if (f3 == 120.0f) {
                str = "GREEN";
            } else if (f3 == 180.0f) {
                str = "CYAN";
            } else if (f3 == 210.0f) {
                str = "AZURE";
            } else if (f3 == 240.0f) {
                str = "BLUE";
            } else if (f3 == 270.0f) {
                str = "VIOLET";
            } else if (f3 == 300.0f) {
                str = "MAGENTA";
            } else if (f3 == 330.0f) {
                str = "ROSE";
            }
            return fromAsset(str + ".png");
        } catch (Throwable th) {
            return null;
        }
    }

    public static BitmapDescriptor fromAsset(String str) {
        try {
            InputStream resourceAsStream = BitmapDescriptorFactory.class.getResourceAsStream("/assets/" + str);
            Bitmap decodeStream = BitmapFactory.decodeStream(resourceAsStream);
            resourceAsStream.close();
            BitmapDescriptor fromBitmap = fromBitmap(decodeStream);
            decodeStream.recycle();
            return fromBitmap;
        } catch (Throwable th) {
            return null;
        }
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            return new BitmapDescriptor(bitmap);
        } catch (Throwable th) {
            return null;
        }
    }

    public static BitmapDescriptor fromFile(String str) {
        try {
            Context context = C1119p.f3495a;
            if (context == null) {
                return null;
            }
            FileInputStream openFileInput = context.openFileInput(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(openFileInput);
            openFileInput.close();
            BitmapDescriptor fromBitmap = fromBitmap(decodeStream);
            decodeStream.recycle();
            return fromBitmap;
        } catch (Throwable th) {
            return null;
        }
    }

    public static BitmapDescriptor fromPath(String str) {
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            BitmapDescriptor fromBitmap = fromBitmap(decodeFile);
            decodeFile.recycle();
            return fromBitmap;
        } catch (Throwable th) {
            return null;
        }
    }

    public static BitmapDescriptor fromResource(int i) {
        try {
            Context context = C1119p.f3495a;
            if (context == null) {
                return null;
            }
            Bitmap decodeStream = BitmapFactory.decodeStream(context.getResources().openRawResource(i));
            BitmapDescriptor fromBitmap = fromBitmap(decodeStream);
            decodeStream.recycle();
            return fromBitmap;
        } catch (Throwable th) {
            return null;
        }
    }

    public static BitmapDescriptor fromView(View view) {
        try {
            Context context = C1119p.f3495a;
            if (context == null) {
                return null;
            }
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.addView(view);
            frameLayout.setDrawingCacheEnabled(true);
            Bitmap m18351a = C0945eh.m18351a(frameLayout);
            BitmapDescriptor fromBitmap = fromBitmap(m18351a);
            m18351a.recycle();
            return fromBitmap;
        } catch (Throwable th) {
            return null;
        }
    }
}
