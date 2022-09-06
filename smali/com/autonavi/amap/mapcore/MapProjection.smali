.class public Lcom/autonavi/amap/mapcore/MapProjection;
.super Ljava/lang/Object;


# instance fields
.field private mMapCore:Lcom/autonavi/amap/mapcore/MapCore;

.field private m_bNewInstance:Z

.field native_instance:J


# direct methods
.method public constructor <init>(JLcom/autonavi/amap/mapcore/MapCore;)V
    .locals 3

    const/4 v2, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    iput-boolean v2, p0, Lcom/autonavi/amap/mapcore/MapProjection;->m_bNewInstance:Z

    iput-object p3, p0, Lcom/autonavi/amap/mapcore/MapProjection;->mMapCore:Lcom/autonavi/amap/mapcore/MapCore;

    iput-wide p1, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    iput-boolean v2, p0, Lcom/autonavi/amap/mapcore/MapProjection;->m_bNewInstance:Z

    return-void
.end method

.method public constructor <init>(Lcom/autonavi/amap/mapcore/MapCore;)V
    .locals 4

    const-wide/16 v2, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-wide v2, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->m_bNewInstance:Z

    iput-object p1, p0, Lcom/autonavi/amap/mapcore/MapProjection;->mMapCore:Lcom/autonavi/amap/mapcore/MapCore;

    invoke-virtual {p1}, Lcom/autonavi/amap/mapcore/MapCore;->getInstanceHandle()J

    move-result-wide v0

    cmp-long v2, v0, v2

    if-eqz v2, :cond_0

    invoke-static {v0, v1}, Lcom/autonavi/amap/mapcore/MapProjection;->nativeNewInstance(J)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->m_bNewInstance:Z

    :cond_0
    return-void
.end method

.method public static geo2LonLat(IILcom/autonavi/amap/mapcore/DPoint;)V
    .locals 5

    int-to-long v0, p0

    int-to-long v2, p1

    const/16 v4, 0x14

    invoke-static {v0, v1, v2, v3, v4}, Lcom/autonavi/amap/mapcore/VirtualEarthProjection;->PixelsToLatLong(JJI)Lcom/autonavi/amap/mapcore/DPoint;

    move-result-object v0

    iget-wide v2, v0, Lcom/autonavi/amap/mapcore/DPoint;->x:D

    iput-wide v2, p2, Lcom/autonavi/amap/mapcore/DPoint;->x:D

    iget-wide v0, v0, Lcom/autonavi/amap/mapcore/DPoint;->y:D

    iput-wide v0, p2, Lcom/autonavi/amap/mapcore/DPoint;->y:D

    return-void
.end method

.method public static lonlat2Geo(DDLcom/autonavi/amap/mapcore/IPoint;)V
    .locals 2

    const/16 v0, 0x14

    invoke-static {p2, p3, p0, p1, v0}, Lcom/autonavi/amap/mapcore/VirtualEarthProjection;->LatLongToPixels(DDI)Landroid/graphics/Point;

    move-result-object v0

    iget v1, v0, Landroid/graphics/Point;->x:I

    iput v1, p4, Lcom/autonavi/amap/mapcore/IPoint;->x:I

    iget v0, v0, Landroid/graphics/Point;->y:I

    iput v0, p4, Lcom/autonavi/amap/mapcore/IPoint;->y:I

    return-void
.end method

.method private static native nativeDestroy(J)V
.end method

.method private static native nativeGeo2LonLat(IILcom/autonavi/amap/mapcore/DPoint;)V
.end method

.method private static native nativeGeo2Map(JIILcom/autonavi/amap/mapcore/FPoint;)V
.end method

.method private static native nativeGetBound(JLcom/autonavi/amap/mapcore/IPoint;)V
.end method

.method private static native nativeGetCameraHeaderAngle(J)F
.end method

.method private static native nativeGetCenterMap(JLcom/autonavi/amap/mapcore/FPoint;)V
.end method

.method private static native nativeGetGeoCenter(JLcom/autonavi/amap/mapcore/IPoint;)V
.end method

.method private static native nativeGetMapAngle(J)F
.end method

.method private static native nativeGetMapCenter(JLcom/autonavi/amap/mapcore/FPoint;)V
.end method

.method private static native nativeGetMapLenWithGeo(JI)F
.end method

.method private static native nativeGetMapLenWithWin(JI)F
.end method

.method private static native nativeGetMapLenWithWinbyY(JII)F
.end method

.method private static native nativeGetMapZoomer(J)F
.end method

.method private static native nativeLonLat2Geo(DDLcom/autonavi/amap/mapcore/IPoint;)V
.end method

.method private static native nativeMap2Geo(JFFLcom/autonavi/amap/mapcore/IPoint;)V
.end method

.method private static native nativeMap2Win(JFFLcom/autonavi/amap/mapcore/IPoint;)V
.end method

.method private static native nativeNewInstance(J)J
.end method

.method private static native nativeRecalculate(J)V
.end method

.method private static native nativeSetCameraHeaderAngle(JF)V
.end method

.method private static native nativeSetCenterWithMap(JFF)V
.end method

.method private static native nativeSetGeoCenter(JII)V
.end method

.method private static native nativeSetMapAngle(JF)V
.end method

.method private static native nativeSetMapCenter(JFF)V
.end method

.method private static native nativeSetMapZoomer(JF)V
.end method

.method private static native nativeWin2Map(JIILcom/autonavi/amap/mapcore/FPoint;)V
.end method


# virtual methods
.method public geo2Map(IILcom/autonavi/amap/mapcore/FPoint;)V
    .locals 4

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    invoke-static {v0, v1, p1, p2, p3}, Lcom/autonavi/amap/mapcore/MapProjection;->nativeGeo2Map(JIILcom/autonavi/amap/mapcore/FPoint;)V

    :cond_0
    return-void
.end method

.method public getBound(Lcom/autonavi/amap/mapcore/IPoint;)V
    .locals 4

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    invoke-static {v0, v1, p1}, Lcom/autonavi/amap/mapcore/MapProjection;->nativeGetBound(JLcom/autonavi/amap/mapcore/IPoint;)V

    :cond_0
    return-void
.end method

.method public getCameraHeaderAngle()F
    .locals 4

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    invoke-static {v0, v1}, Lcom/autonavi/amap/mapcore/MapProjection;->nativeGetCameraHeaderAngle(J)F

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCenterMap(Lcom/autonavi/amap/mapcore/FPoint;)V
    .locals 4

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    invoke-static {v0, v1, p1}, Lcom/autonavi/amap/mapcore/MapProjection;->nativeGetCenterMap(JLcom/autonavi/amap/mapcore/FPoint;)V

    :cond_0
    return-void
.end method

.method public getGeoCenter(Lcom/autonavi/amap/mapcore/IPoint;)V
    .locals 4

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    invoke-static {v0, v1, p1}, Lcom/autonavi/amap/mapcore/MapProjection;->nativeGetGeoCenter(JLcom/autonavi/amap/mapcore/IPoint;)V

    :cond_0
    return-void
.end method

.method getInstanceHandle()J
    .locals 2

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    return-wide v0
.end method

.method public getLatLng2Pixel(DDLcom/autonavi/amap/mapcore/IPoint;)V
    .locals 3

    invoke-virtual {p0}, Lcom/autonavi/amap/mapcore/MapProjection;->recalculate()V

    new-instance v0, Lcom/autonavi/amap/mapcore/IPoint;

    invoke-direct {v0}, Lcom/autonavi/amap/mapcore/IPoint;-><init>()V

    new-instance v1, Lcom/autonavi/amap/mapcore/FPoint;

    invoke-direct {v1}, Lcom/autonavi/amap/mapcore/FPoint;-><init>()V

    invoke-static {p3, p4, p1, p2, v0}, Lcom/autonavi/amap/mapcore/MapProjection;->lonlat2Geo(DDLcom/autonavi/amap/mapcore/IPoint;)V

    iget v2, v0, Lcom/autonavi/amap/mapcore/IPoint;->x:I

    iget v0, v0, Lcom/autonavi/amap/mapcore/IPoint;->y:I

    invoke-virtual {p0, v2, v0, v1}, Lcom/autonavi/amap/mapcore/MapProjection;->geo2Map(IILcom/autonavi/amap/mapcore/FPoint;)V

    iget v0, v1, Lcom/autonavi/amap/mapcore/FPoint;->x:F

    iget v1, v1, Lcom/autonavi/amap/mapcore/FPoint;->y:F

    invoke-virtual {p0, v0, v1, p5}, Lcom/autonavi/amap/mapcore/MapProjection;->map2Win(FFLcom/autonavi/amap/mapcore/IPoint;)V

    return-void
.end method

.method public getMapAngle()F
    .locals 4

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    invoke-static {v0, v1}, Lcom/autonavi/amap/mapcore/MapProjection;->nativeGetMapAngle(J)F

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getMapCenter(Lcom/autonavi/amap/mapcore/FPoint;)V
    .locals 4

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    invoke-static {v0, v1, p1}, Lcom/autonavi/amap/mapcore/MapProjection;->nativeGetMapCenter(JLcom/autonavi/amap/mapcore/FPoint;)V

    :cond_0
    return-void
.end method

.method public getMapLenWithGeo(I)F
    .locals 4

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    invoke-static {v0, v1, p1}, Lcom/autonavi/amap/mapcore/MapProjection;->nativeGetMapLenWithGeo(JI)F

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getMapLenWithWin(I)F
    .locals 4

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    invoke-static {v0, v1, p1}, Lcom/autonavi/amap/mapcore/MapProjection;->nativeGetMapLenWithWin(JI)F

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getMapLenWithWinbyY(II)F
    .locals 4

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    invoke-static {v0, v1, p1, p2}, Lcom/autonavi/amap/mapcore/MapProjection;->nativeGetMapLenWithWinbyY(JII)F

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getMapZoomer()F
    .locals 4

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    invoke-static {v0, v1}, Lcom/autonavi/amap/mapcore/MapProjection;->nativeGetMapZoomer(J)F

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public map2Geo(FFLcom/autonavi/amap/mapcore/IPoint;)V
    .locals 4

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    invoke-static {v0, v1, p1, p2, p3}, Lcom/autonavi/amap/mapcore/MapProjection;->nativeMap2Geo(JFFLcom/autonavi/amap/mapcore/IPoint;)V

    :cond_0
    return-void
.end method

.method public map2Win(FFLcom/autonavi/amap/mapcore/IPoint;)V
    .locals 4

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    invoke-static {v0, v1, p1, p2, p3}, Lcom/autonavi/amap/mapcore/MapProjection;->nativeMap2Win(JFFLcom/autonavi/amap/mapcore/IPoint;)V

    :cond_0
    return-void
.end method

.method public recalculate()V
    .locals 4

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    invoke-static {v0, v1}, Lcom/autonavi/amap/mapcore/MapProjection;->nativeRecalculate(J)V

    :cond_0
    return-void
.end method

.method public recycle()V
    .locals 2

    iget-boolean v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->m_bNewInstance:Z

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    invoke-static {v0, v1}, Lcom/autonavi/amap/mapcore/MapProjection;->nativeDestroy(J)V

    :cond_0
    return-void
.end method

.method public setCameraHeaderAngle(F)V
    .locals 4

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    invoke-static {v0, v1, p1}, Lcom/autonavi/amap/mapcore/MapProjection;->nativeSetCameraHeaderAngle(JF)V

    :cond_0
    return-void
.end method

.method public setCenterWithMap(FF)V
    .locals 4

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    invoke-static {v0, v1, p1, p2}, Lcom/autonavi/amap/mapcore/MapProjection;->nativeSetCenterWithMap(JFF)V

    :cond_0
    return-void
.end method

.method public setGeoCenter(II)V
    .locals 4

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    invoke-static {v0, v1, p1, p2}, Lcom/autonavi/amap/mapcore/MapProjection;->nativeSetGeoCenter(JII)V

    :cond_0
    return-void
.end method

.method public setMapAngle(F)V
    .locals 4

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    invoke-static {v0, v1, p1}, Lcom/autonavi/amap/mapcore/MapProjection;->nativeSetMapAngle(JF)V

    :cond_0
    return-void
.end method

.method public setMapCenter(FF)V
    .locals 4

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    invoke-static {v0, v1, p1, p2}, Lcom/autonavi/amap/mapcore/MapProjection;->nativeSetMapCenter(JFF)V

    :cond_0
    return-void
.end method

.method public declared-synchronized setMapZoomer(F)V
    .locals 4

    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->mMapCore:Lcom/autonavi/amap/mapcore/MapCore;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->mMapCore:Lcom/autonavi/amap/mapcore/MapCore;

    iget-object v0, v0, Lcom/autonavi/amap/mapcore/MapCore;->mMap:Lcom/autonavi/amap/mapcore/interfaces/IAMap;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->mMapCore:Lcom/autonavi/amap/mapcore/MapCore;

    iget-object v0, v0, Lcom/autonavi/amap/mapcore/MapCore;->mMap:Lcom/autonavi/amap/mapcore/interfaces/IAMap;

    invoke-interface {v0}, Lcom/autonavi/amap/mapcore/interfaces/IAMap;->getMapConfig()Lcom/autonavi/amap/mapcore/MapConfig;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->mMapCore:Lcom/autonavi/amap/mapcore/MapCore;

    iget-object v0, v0, Lcom/autonavi/amap/mapcore/MapCore;->mMap:Lcom/autonavi/amap/mapcore/interfaces/IAMap;

    invoke-interface {v0}, Lcom/autonavi/amap/mapcore/interfaces/IAMap;->getMapConfig()Lcom/autonavi/amap/mapcore/MapConfig;

    move-result-object v0

    invoke-virtual {v0}, Lcom/autonavi/amap/mapcore/MapConfig;->getLimitZoomLevel()F

    move-result v1

    const/4 v0, 0x0

    cmpl-float v0, v1, v0

    if-lez v0, :cond_4

    cmpg-float v0, p1, v1

    if-gez v0, :cond_4

    :goto_0
    iget-object v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->mMapCore:Lcom/autonavi/amap/mapcore/MapCore;

    iget-object v0, v0, Lcom/autonavi/amap/mapcore/MapCore;->mMap:Lcom/autonavi/amap/mapcore/interfaces/IAMap;

    invoke-interface {v0}, Lcom/autonavi/amap/mapcore/interfaces/IAMap;->getMapConfig()Lcom/autonavi/amap/mapcore/MapConfig;

    move-result-object v0

    invoke-virtual {v0}, Lcom/autonavi/amap/mapcore/MapConfig;->isSetLimitZoomLevel()Z

    move-result v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->mMapCore:Lcom/autonavi/amap/mapcore/MapCore;

    iget-object v0, v0, Lcom/autonavi/amap/mapcore/MapCore;->mMap:Lcom/autonavi/amap/mapcore/interfaces/IAMap;

    invoke-interface {v0}, Lcom/autonavi/amap/mapcore/interfaces/IAMap;->getMapConfig()Lcom/autonavi/amap/mapcore/MapConfig;

    move-result-object v0

    invoke-virtual {v0}, Lcom/autonavi/amap/mapcore/MapConfig;->getMaxZoomLevel()F

    move-result p1

    iget-object v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->mMapCore:Lcom/autonavi/amap/mapcore/MapCore;

    iget-object v0, v0, Lcom/autonavi/amap/mapcore/MapCore;->mMap:Lcom/autonavi/amap/mapcore/interfaces/IAMap;

    invoke-interface {v0}, Lcom/autonavi/amap/mapcore/interfaces/IAMap;->getMapConfig()Lcom/autonavi/amap/mapcore/MapConfig;

    move-result-object v0

    invoke-virtual {v0}, Lcom/autonavi/amap/mapcore/MapConfig;->getMinZoomLevel()F

    move-result v0

    cmpl-float v2, v1, p1

    if-lez v2, :cond_2

    :cond_0
    :goto_1
    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    invoke-static {v0, v1, p1}, Lcom/autonavi/amap/mapcore/MapProjection;->nativeSetMapZoomer(JF)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_1
    monitor-exit p0

    return-void

    :cond_2
    cmpg-float v2, v1, v0

    if-gez v2, :cond_3

    move p1, v0

    goto :goto_1

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    :cond_3
    move p1, v1

    goto :goto_1

    :cond_4
    move v1, p1

    goto :goto_0
.end method

.method public win2Map(IILcom/autonavi/amap/mapcore/FPoint;)V
    .locals 4

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/autonavi/amap/mapcore/MapProjection;->native_instance:J

    invoke-static {v0, v1, p1, p2, p3}, Lcom/autonavi/amap/mapcore/MapProjection;->nativeWin2Map(JIILcom/autonavi/amap/mapcore/FPoint;)V

    :cond_0
    return-void
.end method
