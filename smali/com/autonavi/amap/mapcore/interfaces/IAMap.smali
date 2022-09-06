.class public interface abstract Lcom/autonavi/amap/mapcore/interfaces/IAMap;
.super Ljava/lang/Object;


# virtual methods
.method public abstract addArc(Lcom/amap/api/maps/model/ArcOptions;)Lcom/amap/api/maps/model/Arc;
.end method

.method public abstract addCircle(Lcom/amap/api/maps/model/CircleOptions;)Lcom/amap/api/maps/model/Circle;
.end method

.method public abstract addGroundOverlay(Lcom/amap/api/maps/model/GroundOverlayOptions;)Lcom/amap/api/maps/model/GroundOverlay;
.end method

.method public abstract addMarker(Lcom/amap/api/maps/model/MarkerOptions;)Lcom/amap/api/maps/model/Marker;
.end method

.method public abstract addMarkers(Ljava/util/ArrayList;Z)Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/amap/api/maps/model/MarkerOptions;",
            ">;Z)",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/amap/api/maps/model/Marker;",
            ">;"
        }
    .end annotation
.end method

.method public abstract addNavigateArrow(Lcom/amap/api/maps/model/NavigateArrowOptions;)Lcom/amap/api/maps/model/NavigateArrow;
.end method

.method public abstract addPolygon(Lcom/amap/api/maps/model/PolygonOptions;)Lcom/amap/api/maps/model/Polygon;
.end method

.method public abstract addPolyline(Lcom/amap/api/maps/model/PolylineOptions;)Lcom/amap/api/maps/model/Polyline;
.end method

.method public abstract addText(Lcom/amap/api/maps/model/TextOptions;)Lcom/amap/api/maps/model/Text;
.end method

.method public abstract addTileOverlay(Lcom/amap/api/maps/model/TileOverlayOptions;)Lcom/amap/api/maps/model/TileOverlay;
.end method

.method public abstract animateCamera(Lcom/amap/api/maps/CameraUpdate;)V
.end method

.method public abstract animateCameraWithCallback(Lcom/amap/api/maps/CameraUpdate;Lcom/amap/api/maps/AMap$CancelableCallback;)V
.end method

.method public abstract animateCameraWithDurationAndCallback(Lcom/amap/api/maps/CameraUpdate;JLcom/amap/api/maps/AMap$CancelableCallback;)V
.end method

.method public abstract calculateZoomToSpanLevel(IIIILcom/amap/api/maps/model/LatLng;Lcom/amap/api/maps/model/LatLng;)Landroid/util/Pair;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(IIII",
            "Lcom/amap/api/maps/model/LatLng;",
            "Lcom/amap/api/maps/model/LatLng;",
            ")",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/Float;",
            "Lcom/amap/api/maps/model/LatLng;",
            ">;"
        }
    .end annotation
.end method

.method public abstract clear()V
.end method

.method public abstract clear(Z)V
.end method

.method public abstract destroy()V
.end method

.method public abstract getAMapProjection()Lcom/amap/api/maps/Projection;
.end method

.method public abstract getAMapUiSettings()Lcom/amap/api/maps/UiSettings;
.end method

.method public abstract getCameraAngle()F
.end method

.method public abstract getCameraPosition()Lcom/amap/api/maps/model/CameraPosition;
.end method

.method public abstract getInfoWindowAnimationManager()Lcom/amap/api/maps/InfoWindowAnimationManager;
.end method

.method public abstract getMainHandler()Landroid/os/Handler;
.end method

.method public abstract getMapConfig()Lcom/autonavi/amap/mapcore/MapConfig;
.end method

.method public abstract getMapHeight()I
.end method

.method public abstract getMapPrintScreen(Lcom/amap/api/maps/AMap$onMapPrintScreenListener;)V
.end method

.method public abstract getMapScreenMarkers()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amap/api/maps/model/Marker;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getMapScreenShot(Lcom/amap/api/maps/AMap$OnMapScreenShotListener;)V
.end method

.method public abstract getMapTextZIndex()I
.end method

.method public abstract getMapType()I
.end method

.method public abstract getMapWidth()I
.end method

.method public abstract getMaxZoomLevel()F
.end method

.method public abstract getMinZoomLevel()F
.end method

.method public abstract getMyLocation()Landroid/location/Location;
.end method

.method public abstract getScalePerPixel()F
.end method

.method public abstract getView()Landroid/view/View;
.end method

.method public abstract getZoomToSpanLevel(Lcom/amap/api/maps/model/LatLng;Lcom/amap/api/maps/model/LatLng;)F
.end method

.method public abstract isIndoorEnabled()Z
.end method

.method public abstract isMaploaded()Z
.end method

.method public abstract isMyLocationEnabled()Z
.end method

.method public abstract isTrafficEnabled()Z
.end method

.method public abstract moveCamera(Lcom/amap/api/maps/CameraUpdate;)V
.end method

.method public abstract onActivityPause()V
.end method

.method public abstract onActivityResume()V
.end method

.method public abstract onChangeFinish()V
.end method

.method public abstract onFling()V
.end method

.method public abstract reloadMap()V
.end method

.method public abstract removecache()V
.end method

.method public abstract removecache(Lcom/amap/api/maps/AMap$OnCacheRemoveListener;)V
.end method

.method public abstract resetMinMaxZoomPreference()V
.end method

.method public abstract set3DBuildingEnabled(Z)V
.end method

.method public abstract setAMapGestureListener(Lcom/amap/api/maps/model/AMapGestureListener;)V
.end method

.method public abstract setCenterToPixel(II)V
.end method

.method public abstract setCustomRenderer(Lcom/amap/api/maps/CustomRenderer;)V
.end method

.method public abstract setIndoorBuildingInfo(Lcom/amap/api/maps/model/IndoorBuildingInfo;)V
.end method

.method public abstract setIndoorEnabled(Z)V
.end method

.method public abstract setInfoWindowAdapter(Lcom/amap/api/maps/AMap$InfoWindowAdapter;)V
.end method

.method public abstract setLoadOfflineData(Z)V
.end method

.method public abstract setLocationSource(Lcom/amap/api/maps/LocationSource;)V
.end method

.method public abstract setMapStatusLimits(Lcom/amap/api/maps/model/LatLngBounds;)V
.end method

.method public abstract setMapTextEnable(Z)V
.end method

.method public abstract setMapTextZIndex(I)V
.end method

.method public abstract setMapType(I)V
.end method

.method public abstract setMaskLayerParams(IIIIIJ)V
.end method

.method public abstract setMaxZoomLevel(F)V
.end method

.method public abstract setMinZoomLevel(F)V
.end method

.method public abstract setMyLocationEnabled(Z)V
.end method

.method public abstract setMyLocationRotateAngle(F)V
.end method

.method public abstract setMyLocationStyle(Lcom/amap/api/maps/model/MyLocationStyle;)V
.end method

.method public abstract setMyLocationType(I)V
.end method

.method public abstract setMyTrafficStyle(Lcom/amap/api/maps/model/MyTrafficStyle;)V
.end method

.method public abstract setOnCameraChangeListener(Lcom/amap/api/maps/AMap$OnCameraChangeListener;)V
.end method

.method public abstract setOnIndoorBuildingActiveListener(Lcom/amap/api/maps/AMap$OnIndoorBuildingActiveListener;)V
.end method

.method public abstract setOnInfoWindowClickListener(Lcom/amap/api/maps/AMap$OnInfoWindowClickListener;)V
.end method

.method public abstract setOnMapClickListener(Lcom/amap/api/maps/AMap$OnMapClickListener;)V
.end method

.method public abstract setOnMapLongClickListener(Lcom/amap/api/maps/AMap$OnMapLongClickListener;)V
.end method

.method public abstract setOnMapTouchListener(Lcom/amap/api/maps/AMap$OnMapTouchListener;)V
.end method

.method public abstract setOnMaploadedListener(Lcom/amap/api/maps/AMap$OnMapLoadedListener;)V
.end method

.method public abstract setOnMarkerClickListener(Lcom/amap/api/maps/AMap$OnMarkerClickListener;)V
.end method

.method public abstract setOnMarkerDragListener(Lcom/amap/api/maps/AMap$OnMarkerDragListener;)V
.end method

.method public abstract setOnMyLocationChangeListener(Lcom/amap/api/maps/AMap$OnMyLocationChangeListener;)V
.end method

.method public abstract setOnPOIClickListener(Lcom/amap/api/maps/AMap$OnPOIClickListener;)V
.end method

.method public abstract setOnPolylineClickListener(Lcom/amap/api/maps/AMap$OnPolylineClickListener;)V
.end method

.method public abstract setRenderFps(I)V
.end method

.method public abstract setRunLowFrame(Z)V
.end method

.method public abstract setTrafficEnabled(Z)V
.end method

.method public abstract setVisibilityEx(I)V
.end method

.method public abstract setZOrderOnTop(Z)V
.end method

.method public abstract setZoomScaleParam(F)V
.end method

.method public abstract stopAnimation()V
.end method
