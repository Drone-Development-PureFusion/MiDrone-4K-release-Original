.class public Lcom/autonavi/amap/mapcore/AMapNativeRenderer;
.super Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    :try_start_0
    const-string v0, "gdinamapv4sdk752ex"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    goto :goto_0
.end method

.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static native nativeDrawGradientColorLine([FIF[II[III)V
.end method

.method public static native nativeDrawLineByMultiColor([FIFI[II[II)V
.end method

.method public static native nativeDrawLineByMultiTextureID([FIF[II[IIF)V
.end method

.method public static native nativeDrawLineByTextureID([FIFIFFFFFZZZ)V
.end method
