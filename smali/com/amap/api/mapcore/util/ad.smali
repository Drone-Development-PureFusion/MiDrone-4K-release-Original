.class public Lcom/amap/api/mapcore/util/ad;
.super Lcom/amap/api/mapcore/util/af;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/amap/api/mapcore/util/af;-><init>()V

    return-void
.end method


# virtual methods
.method public mergeCameraUpdateDelegate(Lcom/autonavi/amap/mapcore/MapMessage;)V
    .locals 1

    iget-object v0, p0, Lcom/amap/api/mapcore/util/ad;->geoPoint:Lcom/autonavi/amap/mapcore/IPoint;

    if-nez v0, :cond_0

    iget-object v0, p1, Lcom/autonavi/amap/mapcore/MapMessage;->geoPoint:Lcom/autonavi/amap/mapcore/IPoint;

    :goto_0
    iput-object v0, p1, Lcom/autonavi/amap/mapcore/MapMessage;->geoPoint:Lcom/autonavi/amap/mapcore/IPoint;

    iget v0, p0, Lcom/amap/api/mapcore/util/ad;->zoom:F

    invoke-static {v0}, Ljava/lang/Float;->isNaN(F)Z

    move-result v0

    if-eqz v0, :cond_1

    iget v0, p1, Lcom/autonavi/amap/mapcore/MapMessage;->zoom:F

    :goto_1
    iput v0, p1, Lcom/autonavi/amap/mapcore/MapMessage;->zoom:F

    iget v0, p0, Lcom/amap/api/mapcore/util/ad;->bearing:F

    invoke-static {v0}, Ljava/lang/Float;->isNaN(F)Z

    move-result v0

    if-eqz v0, :cond_2

    iget v0, p1, Lcom/autonavi/amap/mapcore/MapMessage;->bearing:F

    :goto_2
    iput v0, p1, Lcom/autonavi/amap/mapcore/MapMessage;->bearing:F

    iget v0, p0, Lcom/amap/api/mapcore/util/ad;->tilt:F

    invoke-static {v0}, Ljava/lang/Float;->isNaN(F)Z

    move-result v0

    if-eqz v0, :cond_3

    iget v0, p1, Lcom/autonavi/amap/mapcore/MapMessage;->tilt:F

    :goto_3
    iput v0, p1, Lcom/autonavi/amap/mapcore/MapMessage;->tilt:F

    return-void

    :cond_0
    iget-object v0, p0, Lcom/amap/api/mapcore/util/ad;->geoPoint:Lcom/autonavi/amap/mapcore/IPoint;

    goto :goto_0

    :cond_1
    iget v0, p0, Lcom/amap/api/mapcore/util/ad;->zoom:F

    goto :goto_1

    :cond_2
    iget v0, p0, Lcom/amap/api/mapcore/util/ad;->bearing:F

    goto :goto_2

    :cond_3
    iget v0, p0, Lcom/amap/api/mapcore/util/ad;->tilt:F

    goto :goto_3
.end method

.method public runCameraUpdate(Lcom/autonavi/amap/mapcore/MapProjection;)V
    .locals 0

    invoke-virtual {p0, p1}, Lcom/amap/api/mapcore/util/ad;->a(Lcom/autonavi/amap/mapcore/MapProjection;)V

    return-void
.end method
