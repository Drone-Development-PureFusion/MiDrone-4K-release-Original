.class public Lcom/amap/api/mapcore/util/ac;
.super Lcom/amap/api/mapcore/util/af;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/amap/api/mapcore/util/af;-><init>()V

    return-void
.end method


# virtual methods
.method public mergeCameraUpdateDelegate(Lcom/autonavi/amap/mapcore/MapMessage;)V
    .locals 0

    return-void
.end method

.method public runCameraUpdate(Lcom/autonavi/amap/mapcore/MapProjection;)V
    .locals 4

    const/4 v3, 0x0

    iget-object v0, p0, Lcom/amap/api/mapcore/util/ac;->mapConfig:Lcom/autonavi/amap/mapcore/MapConfig;

    invoke-static {p0, p1, v0}, Lcom/amap/api/mapcore/util/eh;->a(Lcom/amap/api/mapcore/util/af;Lcom/autonavi/amap/mapcore/MapProjection;Lcom/autonavi/amap/mapcore/MapConfig;)Landroid/util/Pair;

    move-result-object v1

    iget-object v0, v1, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v0, Ljava/lang/Float;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v0

    invoke-virtual {p1, v0}, Lcom/autonavi/amap/mapcore/MapProjection;->setMapZoomer(F)V

    iget-object v0, v1, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v0, Lcom/autonavi/amap/mapcore/IPoint;

    iget v2, v0, Lcom/autonavi/amap/mapcore/IPoint;->x:I

    iget-object v0, v1, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v0, Lcom/autonavi/amap/mapcore/IPoint;

    iget v0, v0, Lcom/autonavi/amap/mapcore/IPoint;->y:I

    invoke-virtual {p1, v2, v0}, Lcom/autonavi/amap/mapcore/MapProjection;->setGeoCenter(II)V

    invoke-virtual {p1, v3}, Lcom/autonavi/amap/mapcore/MapProjection;->setCameraHeaderAngle(F)V

    invoke-virtual {p1, v3}, Lcom/autonavi/amap/mapcore/MapProjection;->setMapAngle(F)V

    return-void
.end method
