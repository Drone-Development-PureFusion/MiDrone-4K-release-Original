.class public final Lcom/amap/api/maps/UiSettings;
.super Ljava/lang/Object;


# instance fields
.field private final a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;


# direct methods
.method public constructor <init>(Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    return-void
.end method


# virtual methods
.method public getLogoMarginRate(I)F
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0, p1}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->getLogoMarginRate(I)F
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    return v0

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public getLogoPosition()I
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->getLogoPosition()I
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    return v0

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public getZoomPosition()I
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->getZoomPosition()I
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    return v0

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public isCompassEnabled()Z
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->isCompassEnabled()Z
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    return v0

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public isIndoorSwitchEnabled()Z
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->isIndoorSwitchEnabled()Z
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    return v0

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public isMyLocationButtonEnabled()Z
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->isMyLocationButtonEnabled()Z
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    return v0

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public isRotateGesturesEnabled()Z
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->isRotateGesturesEnabled()Z
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    return v0

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public isScaleControlsEnabled()Z
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->isScaleControlsEnabled()Z
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    return v0

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public isScrollGesturesEnabled()Z
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->isScrollGesturesEnabled()Z
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    return v0

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public isTiltGesturesEnabled()Z
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->isTiltGesturesEnabled()Z
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    return v0

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public isZoomControlsEnabled()Z
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->isZoomControlsEnabled()Z
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    return v0

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public isZoomGesturesEnabled()Z
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->isZoomGesturesEnabled()Z
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    return v0

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public setAllGesturesEnabled(Z)V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0, p1}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->setAllGesturesEnabled(Z)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public setCompassEnabled(Z)V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0, p1}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->setCompassEnabled(Z)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public setIndoorSwitchEnabled(Z)V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0, p1}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->setIndoorSwitchEnabled(Z)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public final setLogoBottomMargin(I)V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0, p1}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->setLogoBottomMargin(I)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public final setLogoLeftMargin(I)V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0, p1}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->setLogoLeftMargin(I)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public final setLogoMarginRate(IF)V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0, p1, p2}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->setLogoMarginRate(IF)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public setLogoPosition(I)V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0, p1}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->setLogoPosition(I)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public setMyLocationButtonEnabled(Z)V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0, p1}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->setMyLocationButtonEnabled(Z)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public setRotateGesturesEnabled(Z)V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0, p1}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->setRotateGesturesEnabled(Z)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public setScaleControlsEnabled(Z)V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0, p1}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->setScaleControlsEnabled(Z)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public setScrollGesturesEnabled(Z)V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0, p1}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->setScrollGesturesEnabled(Z)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public setTiltGesturesEnabled(Z)V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0, p1}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->setTiltGesturesEnabled(Z)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public setZoomControlsEnabled(Z)V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0, p1}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->setZoomControlsEnabled(Z)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public setZoomGesturesEnabled(Z)V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0, p1}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->setZoomGesturesEnabled(Z)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public setZoomInByScreenCenter(Z)V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0, p1}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->setZoomInByScreenCenter(Z)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method

.method public setZoomPosition(I)V
    .locals 2

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/maps/UiSettings;->a:Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;

    invoke-interface {v0, p1}, Lcom/autonavi/amap/mapcore/interfaces/IUiSettings;->setZoomPosition(I)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    new-instance v1, Lcom/amap/api/maps/model/RuntimeRemoteException;

    invoke-direct {v1, v0}, Lcom/amap/api/maps/model/RuntimeRemoteException;-><init>(Landroid/os/RemoteException;)V

    throw v1
.end method
