package com.autonavi.amap.mapcore.interfaces;

import android.location.Location;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CustomRenderer;
import com.amap.api.maps.InfoWindowAnimationManager;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.Projection;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.AMapGestureListener;
import com.amap.api.maps.model.Arc;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.GroundOverlay;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.IndoorBuildingInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.NavigateArrow;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.autonavi.amap.mapcore.MapConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public interface IAMap {
    Arc addArc(ArcOptions arcOptions);

    Circle addCircle(CircleOptions circleOptions);

    GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions);

    Marker addMarker(MarkerOptions markerOptions);

    ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> arrayList, boolean z);

    NavigateArrow addNavigateArrow(NavigateArrowOptions navigateArrowOptions);

    Polygon addPolygon(PolygonOptions polygonOptions);

    Polyline addPolyline(PolylineOptions polylineOptions);

    Text addText(TextOptions textOptions);

    TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions);

    void animateCamera(CameraUpdate cameraUpdate);

    void animateCameraWithCallback(CameraUpdate cameraUpdate, AMap.CancelableCallback cancelableCallback);

    void animateCameraWithDurationAndCallback(CameraUpdate cameraUpdate, long j, AMap.CancelableCallback cancelableCallback);

    Pair<Float, LatLng> calculateZoomToSpanLevel(int i, int i2, int i3, int i4, LatLng latLng, LatLng latLng2);

    void clear();

    void clear(boolean z);

    void destroy();

    Projection getAMapProjection();

    UiSettings getAMapUiSettings();

    float getCameraAngle();

    CameraPosition getCameraPosition();

    InfoWindowAnimationManager getInfoWindowAnimationManager();

    Handler getMainHandler();

    MapConfig getMapConfig();

    int getMapHeight();

    void getMapPrintScreen(AMap.onMapPrintScreenListener onmapprintscreenlistener);

    List<Marker> getMapScreenMarkers();

    void getMapScreenShot(AMap.OnMapScreenShotListener onMapScreenShotListener);

    int getMapTextZIndex();

    int getMapType();

    int getMapWidth();

    float getMaxZoomLevel();

    float getMinZoomLevel();

    Location getMyLocation();

    float getScalePerPixel();

    View getView();

    float getZoomToSpanLevel(LatLng latLng, LatLng latLng2);

    boolean isIndoorEnabled();

    boolean isMaploaded();

    boolean isMyLocationEnabled();

    boolean isTrafficEnabled();

    void moveCamera(CameraUpdate cameraUpdate);

    void onActivityPause();

    void onActivityResume();

    void onChangeFinish();

    void onFling();

    void reloadMap();

    void removecache();

    void removecache(AMap.OnCacheRemoveListener onCacheRemoveListener);

    void resetMinMaxZoomPreference();

    void set3DBuildingEnabled(boolean z);

    void setAMapGestureListener(AMapGestureListener aMapGestureListener);

    void setCenterToPixel(int i, int i2);

    void setCustomRenderer(CustomRenderer customRenderer);

    void setIndoorBuildingInfo(IndoorBuildingInfo indoorBuildingInfo);

    void setIndoorEnabled(boolean z);

    void setInfoWindowAdapter(AMap.InfoWindowAdapter infoWindowAdapter);

    void setLoadOfflineData(boolean z);

    void setLocationSource(LocationSource locationSource);

    void setMapStatusLimits(LatLngBounds latLngBounds);

    void setMapTextEnable(boolean z);

    void setMapTextZIndex(int i);

    void setMapType(int i);

    void setMaskLayerParams(int i, int i2, int i3, int i4, int i5, long j);

    void setMaxZoomLevel(float f);

    void setMinZoomLevel(float f);

    void setMyLocationEnabled(boolean z);

    void setMyLocationRotateAngle(float f);

    void setMyLocationStyle(MyLocationStyle myLocationStyle);

    void setMyLocationType(int i);

    void setMyTrafficStyle(MyTrafficStyle myTrafficStyle);

    void setOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener);

    void setOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener);

    void setOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener);

    void setOnMapClickListener(AMap.OnMapClickListener onMapClickListener);

    void setOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener);

    void setOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener);

    void setOnMaploadedListener(AMap.OnMapLoadedListener onMapLoadedListener);

    void setOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener);

    void setOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener);

    void setOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener);

    void setOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener);

    void setOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener);

    void setRenderFps(int i);

    void setRunLowFrame(boolean z);

    void setTrafficEnabled(boolean z);

    void setVisibilityEx(int i);

    void setZOrderOnTop(boolean z);

    void setZoomScaleParam(float f);

    void stopAnimation();
}
