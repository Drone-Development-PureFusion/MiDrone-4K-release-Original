.class public Lcom/amap/api/mapcore/util/cm;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/amap/api/mapcore/util/cp;


# instance fields
.field a:Lcom/autonavi/amap/mapcore/FPointBounds;

.field private b:Lcom/amap/api/mapcore/util/l;

.field private c:Lcom/amap/api/maps/model/BitmapDescriptor;

.field private d:Lcom/amap/api/maps/model/LatLng;

.field private e:F

.field private f:F

.field private g:Lcom/amap/api/maps/model/LatLngBounds;

.field private h:F

.field private i:F

.field private j:Z

.field private k:F

.field private l:F

.field private m:F

.field private n:Ljava/lang/String;

.field private o:Ljava/nio/FloatBuffer;

.field private p:Ljava/nio/FloatBuffer;

.field private q:I

.field private r:Z

.field private s:Z

.field private t:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Float;",
            ">;"
        }
    .end annotation
.end field

.field private u:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Float;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/amap/api/mapcore/util/l;)V
    .locals 4

    const/4 v3, 0x0

    const/4 v2, 0x0

    const/high16 v1, 0x3f000000    # 0.5f

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amap/api/mapcore/util/cm;->j:Z

    const/4 v0, 0x0

    iput v0, p0, Lcom/amap/api/mapcore/util/cm;->k:F

    iput v1, p0, Lcom/amap/api/mapcore/util/cm;->l:F

    iput v1, p0, Lcom/amap/api/mapcore/util/cm;->m:F

    iput-object v3, p0, Lcom/amap/api/mapcore/util/cm;->o:Ljava/nio/FloatBuffer;

    iput-boolean v2, p0, Lcom/amap/api/mapcore/util/cm;->r:Z

    iput-boolean v2, p0, Lcom/amap/api/mapcore/util/cm;->s:Z

    iput-object v3, p0, Lcom/amap/api/mapcore/util/cm;->a:Lcom/autonavi/amap/mapcore/FPointBounds;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amap/api/mapcore/util/cm;->t:Ljava/util/List;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amap/api/mapcore/util/cm;->u:Ljava/util/List;

    iput-object p1, p0, Lcom/amap/api/mapcore/util/cm;->b:Lcom/amap/api/mapcore/util/l;

    :try_start_0
    invoke-virtual {p0}, Lcom/amap/api/mapcore/util/cm;->getId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/api/mapcore/util/cm;->n:Ljava/lang/String;
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "GroundOverlayDelegateImp"

    const-string v2, "create"

    invoke-static {v0, v1, v2}, Lcom/amap/api/mapcore/util/fo;->b(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Landroid/os/RemoteException;->printStackTrace()V

    goto :goto_0
.end method

.method private a(Lcom/autonavi/amap/mapcore/DPoint;DDDDLcom/autonavi/amap/mapcore/FPoint;)V
    .locals 14

    iget v2, p0, Lcom/amap/api/mapcore/util/cm;->l:F

    float-to-double v2, v2

    mul-double v2, v2, p6

    sub-double v2, p2, v2

    const/high16 v4, 0x3f800000    # 1.0f

    iget v5, p0, Lcom/amap/api/mapcore/util/cm;->m:F

    sub-float/2addr v4, v5

    float-to-double v4, v4

    mul-double v4, v4, p8

    sub-double v4, v4, p4

    iget v6, p0, Lcom/amap/api/mapcore/util/cm;->h:F

    neg-float v6, v6

    float-to-double v6, v6

    const-wide v8, 0x3f91df46a2529d37L    # 0.01745329251994329

    mul-double/2addr v6, v8

    iget-wide v8, p1, Lcom/autonavi/amap/mapcore/DPoint;->x:D

    invoke-static {v6, v7}, Ljava/lang/Math;->cos(D)D

    move-result-wide v10

    mul-double/2addr v10, v2

    invoke-static {v6, v7}, Ljava/lang/Math;->sin(D)D

    move-result-wide v12

    mul-double/2addr v12, v4

    add-double/2addr v10, v12

    add-double/2addr v8, v10

    double-to-float v8, v8

    move-object/from16 v0, p10

    iput v8, v0, Lcom/autonavi/amap/mapcore/FPoint;->x:F

    iget-wide v8, p1, Lcom/autonavi/amap/mapcore/DPoint;->y:D

    invoke-static {v6, v7}, Ljava/lang/Math;->cos(D)D

    move-result-wide v10

    mul-double/2addr v4, v10

    invoke-static {v6, v7}, Ljava/lang/Math;->sin(D)D

    move-result-wide v6

    mul-double/2addr v2, v6

    sub-double v2, v4, v2

    add-double/2addr v2, v8

    double-to-float v2, v2

    move-object/from16 v0, p10

    iput v2, v0, Lcom/autonavi/amap/mapcore/FPoint;->y:F

    return-void
.end method

.method private a(Ljavax/microedition/khronos/opengles/GL10;ILjava/nio/FloatBuffer;Ljava/nio/FloatBuffer;)V
    .locals 8

    const/16 v7, 0x1406

    const/16 v6, 0xbe2

    const/16 v5, 0xde1

    const/4 v4, 0x0

    const/high16 v3, 0x3f800000    # 1.0f

    if-eqz p3, :cond_0

    if-nez p4, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    invoke-interface {p1, v6}, Ljavax/microedition/khronos/opengles/GL10;->glEnable(I)V

    const/16 v0, 0x2300

    const/16 v1, 0x2200

    const/high16 v2, 0x46040000    # 8448.0f

    invoke-interface {p1, v0, v1, v2}, Ljavax/microedition/khronos/opengles/GL10;->glTexEnvf(IIF)V

    const/4 v0, 0x1

    const/16 v1, 0x303

    invoke-interface {p1, v0, v1}, Ljavax/microedition/khronos/opengles/GL10;->glBlendFunc(II)V

    iget v0, p0, Lcom/amap/api/mapcore/util/cm;->k:F

    sub-float v0, v3, v0

    invoke-interface {p1, v3, v3, v3, v0}, Ljavax/microedition/khronos/opengles/GL10;->glColor4f(FFFF)V

    invoke-interface {p1, v5}, Ljavax/microedition/khronos/opengles/GL10;->glEnable(I)V

    const v0, 0x8074

    invoke-interface {p1, v0}, Ljavax/microedition/khronos/opengles/GL10;->glEnableClientState(I)V

    const v0, 0x8078

    invoke-interface {p1, v0}, Ljavax/microedition/khronos/opengles/GL10;->glEnableClientState(I)V

    invoke-interface {p1, v5, p2}, Ljavax/microedition/khronos/opengles/GL10;->glBindTexture(II)V

    const/4 v0, 0x3

    invoke-interface {p1, v0, v7, v4, p3}, Ljavax/microedition/khronos/opengles/GL10;->glVertexPointer(IIILjava/nio/Buffer;)V

    const/4 v0, 0x2

    invoke-interface {p1, v0, v7, v4, p4}, Ljavax/microedition/khronos/opengles/GL10;->glTexCoordPointer(IIILjava/nio/Buffer;)V

    const/4 v0, 0x6

    const/4 v1, 0x4

    invoke-interface {p1, v0, v4, v1}, Ljavax/microedition/khronos/opengles/GL10;->glDrawArrays(III)V

    const v0, 0x8074

    invoke-interface {p1, v0}, Ljavax/microedition/khronos/opengles/GL10;->glDisableClientState(I)V

    const v0, 0x8078

    invoke-interface {p1, v0}, Ljavax/microedition/khronos/opengles/GL10;->glDisableClientState(I)V

    invoke-interface {p1, v5}, Ljavax/microedition/khronos/opengles/GL10;->glDisable(I)V

    invoke-interface {p1, v6}, Ljavax/microedition/khronos/opengles/GL10;->glDisable(I)V

    goto :goto_0
.end method

.method private e()V
    .locals 13

    const/high16 v12, 0x3f800000    # 1.0f

    const-wide v6, 0x3f91df46a2529d37L    # 0.01745329251994329

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->d:Lcom/amap/api/maps/model/LatLng;

    if-nez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    iget v0, p0, Lcom/amap/api/mapcore/util/cm;->e:F

    float-to-double v0, v0

    const-wide v2, 0x41584dae328f5c29L    # 6371000.79

    iget-object v4, p0, Lcom/amap/api/mapcore/util/cm;->d:Lcom/amap/api/maps/model/LatLng;

    iget-wide v4, v4, Lcom/amap/api/maps/model/LatLng;->latitude:D

    mul-double/2addr v4, v6

    invoke-static {v4, v5}, Ljava/lang/Math;->cos(D)D

    move-result-wide v4

    mul-double/2addr v2, v4

    mul-double/2addr v2, v6

    div-double/2addr v0, v2

    iget v2, p0, Lcom/amap/api/mapcore/util/cm;->f:F

    float-to-double v2, v2

    const-wide v4, 0x40fb25af0c031ddeL    # 111194.94043265979

    div-double/2addr v2, v4

    new-instance v4, Lcom/amap/api/maps/model/LatLngBounds;

    new-instance v5, Lcom/amap/api/maps/model/LatLng;

    iget-object v6, p0, Lcom/amap/api/mapcore/util/cm;->d:Lcom/amap/api/maps/model/LatLng;

    iget-wide v6, v6, Lcom/amap/api/maps/model/LatLng;->latitude:D

    iget v8, p0, Lcom/amap/api/mapcore/util/cm;->m:F

    sub-float v8, v12, v8

    float-to-double v8, v8

    mul-double/2addr v8, v2

    sub-double/2addr v6, v8

    iget-object v8, p0, Lcom/amap/api/mapcore/util/cm;->d:Lcom/amap/api/maps/model/LatLng;

    iget-wide v8, v8, Lcom/amap/api/maps/model/LatLng;->longitude:D

    iget v10, p0, Lcom/amap/api/mapcore/util/cm;->l:F

    float-to-double v10, v10

    mul-double/2addr v10, v0

    sub-double/2addr v8, v10

    invoke-direct {v5, v6, v7, v8, v9}, Lcom/amap/api/maps/model/LatLng;-><init>(DD)V

    new-instance v6, Lcom/amap/api/maps/model/LatLng;

    iget-object v7, p0, Lcom/amap/api/mapcore/util/cm;->d:Lcom/amap/api/maps/model/LatLng;

    iget-wide v8, v7, Lcom/amap/api/maps/model/LatLng;->latitude:D

    iget v7, p0, Lcom/amap/api/mapcore/util/cm;->m:F

    float-to-double v10, v7

    mul-double/2addr v2, v10

    add-double/2addr v2, v8

    iget-object v7, p0, Lcom/amap/api/mapcore/util/cm;->d:Lcom/amap/api/maps/model/LatLng;

    iget-wide v8, v7, Lcom/amap/api/maps/model/LatLng;->longitude:D

    iget v7, p0, Lcom/amap/api/mapcore/util/cm;->l:F

    sub-float v7, v12, v7

    float-to-double v10, v7

    mul-double/2addr v0, v10

    add-double/2addr v0, v8

    invoke-direct {v6, v2, v3, v0, v1}, Lcom/amap/api/maps/model/LatLng;-><init>(DD)V

    invoke-direct {v4, v5, v6}, Lcom/amap/api/maps/model/LatLngBounds;-><init>(Lcom/amap/api/maps/model/LatLng;Lcom/amap/api/maps/model/LatLng;)V

    iput-object v4, p0, Lcom/amap/api/mapcore/util/cm;->g:Lcom/amap/api/maps/model/LatLngBounds;

    invoke-direct {p0}, Lcom/amap/api/mapcore/util/cm;->g()V

    goto :goto_0
.end method

.method private f()V
    .locals 14

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->g:Lcom/amap/api/maps/model/LatLngBounds;

    if-nez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->g:Lcom/amap/api/maps/model/LatLngBounds;

    iget-object v0, v0, Lcom/amap/api/maps/model/LatLngBounds;->southwest:Lcom/amap/api/maps/model/LatLng;

    iget-object v1, p0, Lcom/amap/api/mapcore/util/cm;->g:Lcom/amap/api/maps/model/LatLngBounds;

    iget-object v1, v1, Lcom/amap/api/maps/model/LatLngBounds;->northeast:Lcom/amap/api/maps/model/LatLng;

    new-instance v2, Lcom/amap/api/maps/model/LatLng;

    iget-wide v4, v0, Lcom/amap/api/maps/model/LatLng;->latitude:D

    const/high16 v3, 0x3f800000    # 1.0f

    iget v6, p0, Lcom/amap/api/mapcore/util/cm;->m:F

    sub-float/2addr v3, v6

    float-to-double v6, v3

    iget-wide v8, v1, Lcom/amap/api/maps/model/LatLng;->latitude:D

    iget-wide v10, v0, Lcom/amap/api/maps/model/LatLng;->latitude:D

    sub-double/2addr v8, v10

    mul-double/2addr v6, v8

    add-double/2addr v4, v6

    iget-wide v6, v0, Lcom/amap/api/maps/model/LatLng;->longitude:D

    iget v3, p0, Lcom/amap/api/mapcore/util/cm;->l:F

    float-to-double v8, v3

    iget-wide v10, v1, Lcom/amap/api/maps/model/LatLng;->longitude:D

    iget-wide v12, v0, Lcom/amap/api/maps/model/LatLng;->longitude:D

    sub-double/2addr v10, v12

    mul-double/2addr v8, v10

    add-double/2addr v6, v8

    invoke-direct {v2, v4, v5, v6, v7}, Lcom/amap/api/maps/model/LatLng;-><init>(DD)V

    iput-object v2, p0, Lcom/amap/api/mapcore/util/cm;->d:Lcom/amap/api/maps/model/LatLng;

    const-wide v2, 0x41584dae328f5c29L    # 6371000.79

    iget-object v4, p0, Lcom/amap/api/mapcore/util/cm;->d:Lcom/amap/api/maps/model/LatLng;

    iget-wide v4, v4, Lcom/amap/api/maps/model/LatLng;->latitude:D

    const-wide v6, 0x3f91df46a2529d37L    # 0.01745329251994329

    mul-double/2addr v4, v6

    invoke-static {v4, v5}, Ljava/lang/Math;->cos(D)D

    move-result-wide v4

    mul-double/2addr v2, v4

    iget-wide v4, v1, Lcom/amap/api/maps/model/LatLng;->longitude:D

    iget-wide v6, v0, Lcom/amap/api/maps/model/LatLng;->longitude:D

    sub-double/2addr v4, v6

    mul-double/2addr v2, v4

    const-wide v4, 0x3f91df46a2529d37L    # 0.01745329251994329

    mul-double/2addr v2, v4

    double-to-float v2, v2

    iput v2, p0, Lcom/amap/api/mapcore/util/cm;->e:F

    const-wide v2, 0x41584dae328f5c29L    # 6371000.79

    iget-wide v4, v1, Lcom/amap/api/maps/model/LatLng;->latitude:D

    iget-wide v0, v0, Lcom/amap/api/maps/model/LatLng;->latitude:D

    sub-double v0, v4, v0

    mul-double/2addr v0, v2

    const-wide v2, 0x3f91df46a2529d37L    # 0.01745329251994329

    mul-double/2addr v0, v2

    double-to-float v0, v0

    iput v0, p0, Lcom/amap/api/mapcore/util/cm;->f:F

    invoke-direct {p0}, Lcom/amap/api/mapcore/util/cm;->g()V

    goto :goto_0
.end method

.method private g()V
    .locals 39

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amap/api/mapcore/util/cm;->g:Lcom/amap/api/maps/model/LatLngBounds;

    if-nez v2, :cond_0

    :goto_0
    return-void

    :cond_0
    const/16 v2, 0xc

    new-array v2, v2, [F

    new-instance v8, Lcom/autonavi/amap/mapcore/FPoint;

    invoke-direct {v8}, Lcom/autonavi/amap/mapcore/FPoint;-><init>()V

    new-instance v14, Lcom/autonavi/amap/mapcore/FPoint;

    invoke-direct {v14}, Lcom/autonavi/amap/mapcore/FPoint;-><init>()V

    new-instance v20, Lcom/autonavi/amap/mapcore/FPoint;

    invoke-direct/range {v20 .. v20}, Lcom/autonavi/amap/mapcore/FPoint;-><init>()V

    new-instance v26, Lcom/autonavi/amap/mapcore/FPoint;

    invoke-direct/range {v26 .. v26}, Lcom/autonavi/amap/mapcore/FPoint;-><init>()V

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amap/api/mapcore/util/cm;->b:Lcom/amap/api/mapcore/util/l;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amap/api/mapcore/util/cm;->g:Lcom/amap/api/maps/model/LatLngBounds;

    iget-object v4, v4, Lcom/amap/api/maps/model/LatLngBounds;->southwest:Lcom/amap/api/maps/model/LatLng;

    iget-wide v4, v4, Lcom/amap/api/maps/model/LatLng;->latitude:D

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/amap/api/mapcore/util/cm;->g:Lcom/amap/api/maps/model/LatLngBounds;

    iget-object v6, v6, Lcom/amap/api/maps/model/LatLngBounds;->southwest:Lcom/amap/api/maps/model/LatLng;

    iget-wide v6, v6, Lcom/amap/api/maps/model/LatLng;->longitude:D

    invoke-interface/range {v3 .. v8}, Lcom/amap/api/mapcore/util/l;->a(DDLcom/autonavi/amap/mapcore/FPoint;)V

    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/amap/api/mapcore/util/cm;->b:Lcom/amap/api/mapcore/util/l;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amap/api/mapcore/util/cm;->g:Lcom/amap/api/maps/model/LatLngBounds;

    iget-object v3, v3, Lcom/amap/api/maps/model/LatLngBounds;->southwest:Lcom/amap/api/maps/model/LatLng;

    iget-wide v10, v3, Lcom/amap/api/maps/model/LatLng;->latitude:D

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amap/api/mapcore/util/cm;->g:Lcom/amap/api/maps/model/LatLngBounds;

    iget-object v3, v3, Lcom/amap/api/maps/model/LatLngBounds;->northeast:Lcom/amap/api/maps/model/LatLng;

    iget-wide v12, v3, Lcom/amap/api/maps/model/LatLng;->longitude:D

    invoke-interface/range {v9 .. v14}, Lcom/amap/api/mapcore/util/l;->a(DDLcom/autonavi/amap/mapcore/FPoint;)V

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/amap/api/mapcore/util/cm;->b:Lcom/amap/api/mapcore/util/l;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amap/api/mapcore/util/cm;->g:Lcom/amap/api/maps/model/LatLngBounds;

    iget-object v3, v3, Lcom/amap/api/maps/model/LatLngBounds;->northeast:Lcom/amap/api/maps/model/LatLng;

    iget-wide v0, v3, Lcom/amap/api/maps/model/LatLng;->latitude:D

    move-wide/from16 v16, v0

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amap/api/mapcore/util/cm;->g:Lcom/amap/api/maps/model/LatLngBounds;

    iget-object v3, v3, Lcom/amap/api/maps/model/LatLngBounds;->northeast:Lcom/amap/api/maps/model/LatLng;

    iget-wide v0, v3, Lcom/amap/api/maps/model/LatLng;->longitude:D

    move-wide/from16 v18, v0

    invoke-interface/range {v15 .. v20}, Lcom/amap/api/mapcore/util/l;->a(DDLcom/autonavi/amap/mapcore/FPoint;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amap/api/mapcore/util/cm;->b:Lcom/amap/api/mapcore/util/l;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amap/api/mapcore/util/cm;->g:Lcom/amap/api/maps/model/LatLngBounds;

    iget-object v3, v3, Lcom/amap/api/maps/model/LatLngBounds;->northeast:Lcom/amap/api/maps/model/LatLng;

    iget-wide v0, v3, Lcom/amap/api/maps/model/LatLng;->latitude:D

    move-wide/from16 v22, v0

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amap/api/mapcore/util/cm;->g:Lcom/amap/api/maps/model/LatLngBounds;

    iget-object v3, v3, Lcom/amap/api/maps/model/LatLngBounds;->southwest:Lcom/amap/api/maps/model/LatLng;

    iget-wide v0, v3, Lcom/amap/api/maps/model/LatLng;->longitude:D

    move-wide/from16 v24, v0

    invoke-interface/range {v21 .. v26}, Lcom/amap/api/mapcore/util/l;->a(DDLcom/autonavi/amap/mapcore/FPoint;)V

    new-instance v3, Lcom/autonavi/amap/mapcore/FPointBounds$Builder;

    invoke-direct {v3}, Lcom/autonavi/amap/mapcore/FPointBounds$Builder;-><init>()V

    invoke-virtual {v3, v8}, Lcom/autonavi/amap/mapcore/FPointBounds$Builder;->include(Lcom/autonavi/amap/mapcore/FPoint;)Lcom/autonavi/amap/mapcore/FPointBounds$Builder;

    move-object/from16 v0, v26

    invoke-virtual {v3, v0}, Lcom/autonavi/amap/mapcore/FPointBounds$Builder;->include(Lcom/autonavi/amap/mapcore/FPoint;)Lcom/autonavi/amap/mapcore/FPointBounds$Builder;

    invoke-virtual {v3, v14}, Lcom/autonavi/amap/mapcore/FPointBounds$Builder;->include(Lcom/autonavi/amap/mapcore/FPoint;)Lcom/autonavi/amap/mapcore/FPointBounds$Builder;

    move-object/from16 v0, v20

    invoke-virtual {v3, v0}, Lcom/autonavi/amap/mapcore/FPointBounds$Builder;->include(Lcom/autonavi/amap/mapcore/FPoint;)Lcom/autonavi/amap/mapcore/FPointBounds$Builder;

    invoke-virtual {v3}, Lcom/autonavi/amap/mapcore/FPointBounds$Builder;->build()Lcom/autonavi/amap/mapcore/FPointBounds;

    move-result-object v3

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/amap/api/mapcore/util/cm;->a:Lcom/autonavi/amap/mapcore/FPointBounds;

    move-object/from16 v0, p0

    iget v3, v0, Lcom/amap/api/mapcore/util/cm;->h:F

    const/4 v4, 0x0

    cmpl-float v3, v3, v4

    if-eqz v3, :cond_1

    iget v3, v14, Lcom/autonavi/amap/mapcore/FPoint;->x:F

    iget v4, v8, Lcom/autonavi/amap/mapcore/FPoint;->x:F

    sub-float/2addr v3, v4

    float-to-double v0, v3

    move-wide/from16 v34, v0

    iget v3, v14, Lcom/autonavi/amap/mapcore/FPoint;->y:F

    move-object/from16 v0, v20

    iget v4, v0, Lcom/autonavi/amap/mapcore/FPoint;->y:F

    sub-float/2addr v3, v4

    float-to-double v0, v3

    move-wide/from16 v36, v0

    new-instance v29, Lcom/autonavi/amap/mapcore/DPoint;

    invoke-direct/range {v29 .. v29}, Lcom/autonavi/amap/mapcore/DPoint;-><init>()V

    iget v3, v8, Lcom/autonavi/amap/mapcore/FPoint;->x:F

    float-to-double v4, v3

    move-object/from16 v0, p0

    iget v3, v0, Lcom/amap/api/mapcore/util/cm;->l:F

    float-to-double v6, v3

    mul-double v6, v6, v34

    add-double/2addr v4, v6

    move-object/from16 v0, v29

    iput-wide v4, v0, Lcom/autonavi/amap/mapcore/DPoint;->x:D

    iget v3, v8, Lcom/autonavi/amap/mapcore/FPoint;->y:F

    float-to-double v4, v3

    const/high16 v3, 0x3f800000    # 1.0f

    move-object/from16 v0, p0

    iget v6, v0, Lcom/amap/api/mapcore/util/cm;->m:F

    sub-float/2addr v3, v6

    float-to-double v6, v3

    mul-double v6, v6, v36

    sub-double/2addr v4, v6

    move-object/from16 v0, v29

    iput-wide v4, v0, Lcom/autonavi/amap/mapcore/DPoint;->y:D

    const-wide/16 v30, 0x0

    const-wide/16 v32, 0x0

    move-object/from16 v28, p0

    move-object/from16 v38, v8

    invoke-direct/range {v28 .. v38}, Lcom/amap/api/mapcore/util/cm;->a(Lcom/autonavi/amap/mapcore/DPoint;DDDDLcom/autonavi/amap/mapcore/FPoint;)V

    const-wide/16 v32, 0x0

    move-object/from16 v28, p0

    move-wide/from16 v30, v34

    move-object/from16 v38, v14

    invoke-direct/range {v28 .. v38}, Lcom/amap/api/mapcore/util/cm;->a(Lcom/autonavi/amap/mapcore/DPoint;DDDDLcom/autonavi/amap/mapcore/FPoint;)V

    move-object/from16 v28, p0

    move-wide/from16 v30, v34

    move-wide/from16 v32, v36

    move-object/from16 v38, v20

    invoke-direct/range {v28 .. v38}, Lcom/amap/api/mapcore/util/cm;->a(Lcom/autonavi/amap/mapcore/DPoint;DDDDLcom/autonavi/amap/mapcore/FPoint;)V

    const-wide/16 v30, 0x0

    move-object/from16 v28, p0

    move-wide/from16 v32, v36

    move-object/from16 v38, v26

    invoke-direct/range {v28 .. v38}, Lcom/amap/api/mapcore/util/cm;->a(Lcom/autonavi/amap/mapcore/DPoint;DDDDLcom/autonavi/amap/mapcore/FPoint;)V

    :cond_1
    const/4 v3, 0x0

    iget v4, v8, Lcom/autonavi/amap/mapcore/FPoint;->x:F

    aput v4, v2, v3

    const/4 v3, 0x1

    iget v4, v8, Lcom/autonavi/amap/mapcore/FPoint;->y:F

    aput v4, v2, v3

    const/4 v3, 0x2

    const/4 v4, 0x0

    aput v4, v2, v3

    const/4 v3, 0x3

    iget v4, v14, Lcom/autonavi/amap/mapcore/FPoint;->x:F

    aput v4, v2, v3

    const/4 v3, 0x4

    iget v4, v14, Lcom/autonavi/amap/mapcore/FPoint;->y:F

    aput v4, v2, v3

    const/4 v3, 0x5

    const/4 v4, 0x0

    aput v4, v2, v3

    const/4 v3, 0x6

    move-object/from16 v0, v20

    iget v4, v0, Lcom/autonavi/amap/mapcore/FPoint;->x:F

    aput v4, v2, v3

    const/4 v3, 0x7

    move-object/from16 v0, v20

    iget v4, v0, Lcom/autonavi/amap/mapcore/FPoint;->y:F

    aput v4, v2, v3

    const/16 v3, 0x8

    const/4 v4, 0x0

    aput v4, v2, v3

    const/16 v3, 0x9

    move-object/from16 v0, v26

    iget v4, v0, Lcom/autonavi/amap/mapcore/FPoint;->x:F

    aput v4, v2, v3

    const/16 v3, 0xa

    move-object/from16 v0, v26

    iget v4, v0, Lcom/autonavi/amap/mapcore/FPoint;->y:F

    aput v4, v2, v3

    const/16 v3, 0xb

    const/4 v4, 0x0

    aput v4, v2, v3

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amap/api/mapcore/util/cm;->o:Ljava/nio/FloatBuffer;

    if-nez v3, :cond_2

    invoke-static {v2}, Lcom/amap/api/mapcore/util/eh;->a([F)Ljava/nio/FloatBuffer;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/amap/api/mapcore/util/cm;->o:Ljava/nio/FloatBuffer;

    goto/16 :goto_0

    :cond_2
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amap/api/mapcore/util/cm;->o:Ljava/nio/FloatBuffer;

    invoke-static {v2, v3}, Lcom/amap/api/mapcore/util/eh;->a([FLjava/nio/FloatBuffer;)Ljava/nio/FloatBuffer;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/amap/api/mapcore/util/cm;->o:Ljava/nio/FloatBuffer;

    goto/16 :goto_0
.end method

.method private h()V
    .locals 5

    const/4 v4, 0x0

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->c:Lcom/amap/api/maps/model/BitmapDescriptor;

    if-nez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->c:Lcom/amap/api/maps/model/BitmapDescriptor;

    invoke-virtual {v0}, Lcom/amap/api/maps/model/BitmapDescriptor;->getWidth()I

    move-result v0

    iget-object v1, p0, Lcom/amap/api/mapcore/util/cm;->c:Lcom/amap/api/maps/model/BitmapDescriptor;

    invoke-virtual {v1}, Lcom/amap/api/maps/model/BitmapDescriptor;->getHeight()I

    move-result v1

    iget-object v2, p0, Lcom/amap/api/mapcore/util/cm;->c:Lcom/amap/api/maps/model/BitmapDescriptor;

    invoke-virtual {v2}, Lcom/amap/api/maps/model/BitmapDescriptor;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v2

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v2

    iget-object v3, p0, Lcom/amap/api/mapcore/util/cm;->c:Lcom/amap/api/maps/model/BitmapDescriptor;

    invoke-virtual {v3}, Lcom/amap/api/maps/model/BitmapDescriptor;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v3

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    int-to-float v0, v0

    int-to-float v3, v3

    div-float/2addr v0, v3

    int-to-float v1, v1

    int-to-float v2, v2

    div-float/2addr v1, v2

    const/16 v2, 0x8

    new-array v2, v2, [F

    const/4 v3, 0x0

    aput v4, v2, v3

    const/4 v3, 0x1

    aput v1, v2, v3

    const/4 v3, 0x2

    aput v0, v2, v3

    const/4 v3, 0x3

    aput v1, v2, v3

    const/4 v1, 0x4

    aput v0, v2, v1

    const/4 v0, 0x5

    aput v4, v2, v0

    const/4 v0, 0x6

    aput v4, v2, v0

    const/4 v0, 0x7

    aput v4, v2, v0

    invoke-static {v2}, Lcom/amap/api/mapcore/util/eh;->a([F)Ljava/nio/FloatBuffer;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/api/mapcore/util/cm;->p:Ljava/nio/FloatBuffer;

    goto :goto_0
.end method


# virtual methods
.method public a(FF)V
    .locals 2

    iput p1, p0, Lcom/amap/api/mapcore/util/cm;->l:F

    iput p2, p0, Lcom/amap/api/mapcore/util/cm;->m:F

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->b:Lcom/amap/api/mapcore/util/l;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lcom/amap/api/mapcore/util/l;->setRunLowFrame(Z)V

    return-void
.end method

.method public a(Ljavax/microedition/khronos/opengles/GL10;)V
    .locals 6

    const/4 v5, 0x0

    const/4 v4, 0x0

    const/4 v3, 0x1

    iget-boolean v0, p0, Lcom/amap/api/mapcore/util/cm;->j:Z

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->d:Lcom/amap/api/maps/model/LatLng;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->g:Lcom/amap/api/maps/model/LatLngBounds;

    if-eqz v0, :cond_1

    :cond_0
    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->c:Lcom/amap/api/maps/model/BitmapDescriptor;

    if-nez v0, :cond_2

    :cond_1
    :goto_0
    return-void

    :cond_2
    iget-boolean v0, p0, Lcom/amap/api/mapcore/util/cm;->r:Z

    if-nez v0, :cond_4

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->c:Lcom/amap/api/maps/model/BitmapDescriptor;

    invoke-virtual {v0}, Lcom/amap/api/maps/model/BitmapDescriptor;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    if-eqz v0, :cond_3

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->isRecycled()Z

    move-result v1

    if-nez v1, :cond_3

    iget v1, p0, Lcom/amap/api/mapcore/util/cm;->q:I

    if-nez v1, :cond_6

    new-array v1, v3, [I

    aput v4, v1, v4

    invoke-interface {p1, v3, v1, v4}, Ljavax/microedition/khronos/opengles/GL10;->glGenTextures(I[II)V

    aget v1, v1, v4

    iput v1, p0, Lcom/amap/api/mapcore/util/cm;->q:I

    :goto_1
    iget v1, p0, Lcom/amap/api/mapcore/util/cm;->q:I

    invoke-static {p1, v1, v0, v3}, Lcom/amap/api/mapcore/util/eh;->b(Ljavax/microedition/khronos/opengles/GL10;ILandroid/graphics/Bitmap;Z)I

    :cond_3
    iput-boolean v3, p0, Lcom/amap/api/mapcore/util/cm;->r:Z

    :cond_4
    iget v0, p0, Lcom/amap/api/mapcore/util/cm;->e:F

    cmpl-float v0, v0, v5

    if-nez v0, :cond_5

    iget v0, p0, Lcom/amap/api/mapcore/util/cm;->f:F

    cmpl-float v0, v0, v5

    if-eqz v0, :cond_1

    :cond_5
    iget v0, p0, Lcom/amap/api/mapcore/util/cm;->q:I

    iget-object v1, p0, Lcom/amap/api/mapcore/util/cm;->o:Ljava/nio/FloatBuffer;

    iget-object v2, p0, Lcom/amap/api/mapcore/util/cm;->p:Ljava/nio/FloatBuffer;

    invoke-direct {p0, p1, v0, v1, v2}, Lcom/amap/api/mapcore/util/cm;->a(Ljavax/microedition/khronos/opengles/GL10;ILjava/nio/FloatBuffer;Ljava/nio/FloatBuffer;)V

    iput-boolean v3, p0, Lcom/amap/api/mapcore/util/cm;->s:Z

    goto :goto_0

    :cond_6
    new-array v1, v3, [I

    iget v2, p0, Lcom/amap/api/mapcore/util/cm;->q:I

    aput v2, v1, v4

    invoke-interface {p1, v3, v1, v4}, Ljavax/microedition/khronos/opengles/GL10;->glDeleteTextures(I[II)V

    goto :goto_1
.end method

.method public a()Z
    .locals 7

    const/4 v1, 0x0

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->a:Lcom/autonavi/amap/mapcore/FPointBounds;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->b:Lcom/amap/api/mapcore/util/l;

    invoke-interface {v0}, Lcom/amap/api/mapcore/util/l;->p()[Lcom/autonavi/amap/mapcore/FPoint;

    move-result-object v2

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->t:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->u:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    move v0, v1

    :goto_0
    array-length v3, v2

    if-ge v0, v3, :cond_0

    aget-object v3, v2, v0

    iget-object v4, p0, Lcom/amap/api/mapcore/util/cm;->t:Ljava/util/List;

    iget v5, v3, Lcom/autonavi/amap/mapcore/FPoint;->x:F

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    invoke-interface {v4, v0, v5}, Ljava/util/List;->add(ILjava/lang/Object;)V

    iget-object v4, p0, Lcom/amap/api/mapcore/util/cm;->u:Ljava/util/List;

    iget v3, v3, Lcom/autonavi/amap/mapcore/FPoint;->y:F

    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    invoke-interface {v4, v0, v3}, Ljava/util/List;->add(ILjava/lang/Object;)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->t:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->min(Ljava/util/Collection;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Float;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v2

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->t:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->max(Ljava/util/Collection;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Float;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v3

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->u:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->min(Ljava/util/Collection;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Float;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v4

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->u:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->max(Ljava/util/Collection;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Float;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v0

    new-instance v5, Lcom/amap/api/mapcore/util/ed;

    invoke-direct {v5, v2, v3, v4, v0}, Lcom/amap/api/mapcore/util/ed;-><init>(FFFF)V

    new-instance v0, Lcom/amap/api/mapcore/util/ed;

    iget-object v2, p0, Lcom/amap/api/mapcore/util/cm;->a:Lcom/autonavi/amap/mapcore/FPointBounds;

    iget-object v2, v2, Lcom/autonavi/amap/mapcore/FPointBounds;->southwest:Lcom/autonavi/amap/mapcore/FPoint;

    iget v2, v2, Lcom/autonavi/amap/mapcore/FPoint;->x:F

    iget-object v3, p0, Lcom/amap/api/mapcore/util/cm;->a:Lcom/autonavi/amap/mapcore/FPointBounds;

    iget-object v3, v3, Lcom/autonavi/amap/mapcore/FPointBounds;->northeast:Lcom/autonavi/amap/mapcore/FPoint;

    iget v3, v3, Lcom/autonavi/amap/mapcore/FPoint;->x:F

    iget-object v4, p0, Lcom/amap/api/mapcore/util/cm;->a:Lcom/autonavi/amap/mapcore/FPointBounds;

    iget-object v4, v4, Lcom/autonavi/amap/mapcore/FPointBounds;->southwest:Lcom/autonavi/amap/mapcore/FPoint;

    iget v4, v4, Lcom/autonavi/amap/mapcore/FPoint;->y:F

    iget-object v6, p0, Lcom/amap/api/mapcore/util/cm;->a:Lcom/autonavi/amap/mapcore/FPointBounds;

    iget-object v6, v6, Lcom/autonavi/amap/mapcore/FPointBounds;->northeast:Lcom/autonavi/amap/mapcore/FPoint;

    iget v6, v6, Lcom/autonavi/amap/mapcore/FPoint;->y:F

    invoke-direct {v0, v2, v3, v4, v6}, Lcom/amap/api/mapcore/util/ed;-><init>(FFFF)V

    invoke-static {v0, v5}, Lcom/amap/api/mapcore/util/eh;->a(Lcom/amap/api/mapcore/util/ed;Lcom/amap/api/mapcore/util/ed;)Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v1, 0x1

    :cond_1
    return v1
.end method

.method public b()Z
    .locals 1

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amap/api/mapcore/util/cm;->s:Z

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->d:Lcom/amap/api/maps/model/LatLng;

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/amap/api/mapcore/util/cm;->f()V

    :goto_0
    const/4 v0, 0x1

    return v0

    :cond_0
    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->g:Lcom/amap/api/maps/model/LatLngBounds;

    if-nez v0, :cond_1

    invoke-direct {p0}, Lcom/amap/api/mapcore/util/cm;->e()V

    goto :goto_0

    :cond_1
    invoke-direct {p0}, Lcom/amap/api/mapcore/util/cm;->g()V

    goto :goto_0
.end method

.method public c()Z
    .locals 1

    iget-boolean v0, p0, Lcom/amap/api/mapcore/util/cm;->s:Z

    return v0
.end method

.method public d()V
    .locals 1

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amap/api/mapcore/util/cm;->r:Z

    iput v0, p0, Lcom/amap/api/mapcore/util/cm;->q:I

    return-void
.end method

.method public destroy()V
    .locals 3

    :try_start_0
    invoke-virtual {p0}, Lcom/amap/api/mapcore/util/cm;->remove()V

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->c:Lcom/amap/api/maps/model/BitmapDescriptor;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->c:Lcom/amap/api/maps/model/BitmapDescriptor;

    invoke-virtual {v0}, Lcom/amap/api/maps/model/BitmapDescriptor;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amap/api/mapcore/util/cm;->c:Lcom/amap/api/maps/model/BitmapDescriptor;

    :cond_0
    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->p:Ljava/nio/FloatBuffer;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->p:Ljava/nio/FloatBuffer;

    invoke-virtual {v0}, Ljava/nio/FloatBuffer;->clear()Ljava/nio/Buffer;

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amap/api/mapcore/util/cm;->p:Ljava/nio/FloatBuffer;

    :cond_1
    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->o:Ljava/nio/FloatBuffer;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->o:Ljava/nio/FloatBuffer;

    invoke-virtual {v0}, Ljava/nio/FloatBuffer;->clear()Ljava/nio/Buffer;

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amap/api/mapcore/util/cm;->o:Ljava/nio/FloatBuffer;

    :cond_2
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amap/api/mapcore/util/cm;->d:Lcom/amap/api/maps/model/LatLng;

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amap/api/mapcore/util/cm;->g:Lcom/amap/api/maps/model/LatLngBounds;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "GroundOverlayDelegateImp"

    const-string v2, "destroy"

    invoke-static {v0, v1, v2}, Lcom/amap/api/mapcore/util/fo;->b(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    goto :goto_0
.end method

.method public equalsRemote(Lcom/autonavi/amap/mapcore/interfaces/IOverlay;)Z
    .locals 2

    invoke-virtual {p0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-interface {p1}, Lcom/autonavi/amap/mapcore/interfaces/IOverlay;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amap/api/mapcore/util/cm;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getBearing()F
    .locals 1

    iget v0, p0, Lcom/amap/api/mapcore/util/cm;->h:F

    return v0
.end method

.method public getBounds()Lcom/amap/api/maps/model/LatLngBounds;
    .locals 1

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->g:Lcom/amap/api/maps/model/LatLngBounds;

    return-object v0
.end method

.method public getHeight()F
    .locals 1

    iget v0, p0, Lcom/amap/api/mapcore/util/cm;->f:F

    return v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->n:Ljava/lang/String;

    if-nez v0, :cond_0

    const-string v0, "GroundOverlay"

    invoke-static {v0}, Lcom/amap/api/mapcore/util/j;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/api/mapcore/util/cm;->n:Ljava/lang/String;

    :cond_0
    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->n:Ljava/lang/String;

    return-object v0
.end method

.method public getPosition()Lcom/amap/api/maps/model/LatLng;
    .locals 1

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->d:Lcom/amap/api/maps/model/LatLng;

    return-object v0
.end method

.method public getTransparency()F
    .locals 1

    iget v0, p0, Lcom/amap/api/mapcore/util/cm;->k:F

    return v0
.end method

.method public getWidth()F
    .locals 1

    iget v0, p0, Lcom/amap/api/mapcore/util/cm;->e:F

    return v0
.end method

.method public getZIndex()F
    .locals 1

    iget v0, p0, Lcom/amap/api/mapcore/util/cm;->i:F

    return v0
.end method

.method public hashCodeRemote()I
    .locals 1

    invoke-super {p0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    return v0
.end method

.method public isAboveMaskLayer()Z
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public isVisible()Z
    .locals 1

    iget-boolean v0, p0, Lcom/amap/api/mapcore/util/cm;->j:Z

    return v0
.end method

.method public remove()V
    .locals 2

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->b:Lcom/amap/api/mapcore/util/l;

    invoke-virtual {p0}, Lcom/amap/api/mapcore/util/cm;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amap/api/mapcore/util/l;->a(Ljava/lang/String;)Z

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->b:Lcom/amap/api/mapcore/util/l;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lcom/amap/api/mapcore/util/l;->setRunLowFrame(Z)V

    return-void
.end method

.method public setAboveMaskLayer(Z)V
    .locals 0

    return-void
.end method

.method public setBearing(F)V
    .locals 6

    const/high16 v1, 0x43b40000    # 360.0f

    rem-float v0, p1, v1

    add-float/2addr v0, v1

    rem-float/2addr v0, v1

    iget-boolean v1, p0, Lcom/amap/api/mapcore/util/cm;->r:Z

    if-eqz v1, :cond_0

    iget v1, p0, Lcom/amap/api/mapcore/util/cm;->h:F

    sub-float/2addr v1, v0

    invoke-static {v1}, Ljava/lang/Math;->abs(F)F

    move-result v1

    float-to-double v2, v1

    const-wide v4, 0x3e7ad7f29abcaf48L    # 1.0E-7

    cmpl-double v1, v2, v4

    if-lez v1, :cond_0

    iput v0, p0, Lcom/amap/api/mapcore/util/cm;->h:F

    invoke-direct {p0}, Lcom/amap/api/mapcore/util/cm;->g()V

    :goto_0
    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->b:Lcom/amap/api/mapcore/util/l;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lcom/amap/api/mapcore/util/l;->setRunLowFrame(Z)V

    return-void

    :cond_0
    iput v0, p0, Lcom/amap/api/mapcore/util/cm;->h:F

    goto :goto_0
.end method

.method public setDimensions(F)V
    .locals 2

    const/4 v0, 0x0

    cmpg-float v0, p1, v0

    if-gtz v0, :cond_0

    const-string v0, "GroundOverlayDelegateImp"

    const-string v1, "Width must be non-negative"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    :cond_0
    iget-boolean v0, p0, Lcom/amap/api/mapcore/util/cm;->r:Z

    if-eqz v0, :cond_1

    iget v0, p0, Lcom/amap/api/mapcore/util/cm;->e:F

    cmpl-float v0, v0, p1

    if-eqz v0, :cond_1

    iput p1, p0, Lcom/amap/api/mapcore/util/cm;->e:F

    iput p1, p0, Lcom/amap/api/mapcore/util/cm;->f:F

    invoke-direct {p0}, Lcom/amap/api/mapcore/util/cm;->e()V

    :goto_0
    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->b:Lcom/amap/api/mapcore/util/l;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lcom/amap/api/mapcore/util/l;->setRunLowFrame(Z)V

    return-void

    :cond_1
    iput p1, p0, Lcom/amap/api/mapcore/util/cm;->e:F

    iput p1, p0, Lcom/amap/api/mapcore/util/cm;->f:F

    goto :goto_0
.end method

.method public setDimensions(FF)V
    .locals 2

    const/4 v1, 0x0

    cmpg-float v0, p1, v1

    if-lez v0, :cond_0

    cmpg-float v0, p2, v1

    if-gtz v0, :cond_1

    :cond_0
    const-string v0, "GroundOverlayDelegateImp"

    const-string v1, "Width and Height must be non-negative"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    :cond_1
    iget-boolean v0, p0, Lcom/amap/api/mapcore/util/cm;->r:Z

    if-eqz v0, :cond_2

    iget v0, p0, Lcom/amap/api/mapcore/util/cm;->e:F

    cmpl-float v0, v0, p1

    if-eqz v0, :cond_2

    iget v0, p0, Lcom/amap/api/mapcore/util/cm;->f:F

    cmpl-float v0, v0, p2

    if-eqz v0, :cond_2

    iput p1, p0, Lcom/amap/api/mapcore/util/cm;->e:F

    iput p2, p0, Lcom/amap/api/mapcore/util/cm;->f:F

    invoke-direct {p0}, Lcom/amap/api/mapcore/util/cm;->e()V

    :goto_0
    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->b:Lcom/amap/api/mapcore/util/l;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lcom/amap/api/mapcore/util/l;->setRunLowFrame(Z)V

    return-void

    :cond_2
    iput p1, p0, Lcom/amap/api/mapcore/util/cm;->e:F

    iput p2, p0, Lcom/amap/api/mapcore/util/cm;->f:F

    goto :goto_0
.end method

.method public setImage(Lcom/amap/api/maps/model/BitmapDescriptor;)V
    .locals 2

    const/4 v1, 0x0

    iput-object p1, p0, Lcom/amap/api/mapcore/util/cm;->c:Lcom/amap/api/maps/model/BitmapDescriptor;

    invoke-direct {p0}, Lcom/amap/api/mapcore/util/cm;->h()V

    iget-boolean v0, p0, Lcom/amap/api/mapcore/util/cm;->r:Z

    if-eqz v0, :cond_0

    iput-boolean v1, p0, Lcom/amap/api/mapcore/util/cm;->r:Z

    :cond_0
    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->b:Lcom/amap/api/mapcore/util/l;

    invoke-interface {v0, v1}, Lcom/amap/api/mapcore/util/l;->setRunLowFrame(Z)V

    return-void
.end method

.method public setPosition(Lcom/amap/api/maps/model/LatLng;)V
    .locals 2

    iput-object p1, p0, Lcom/amap/api/mapcore/util/cm;->d:Lcom/amap/api/maps/model/LatLng;

    invoke-direct {p0}, Lcom/amap/api/mapcore/util/cm;->e()V

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->b:Lcom/amap/api/mapcore/util/l;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lcom/amap/api/mapcore/util/l;->setRunLowFrame(Z)V

    return-void
.end method

.method public setPositionFromBounds(Lcom/amap/api/maps/model/LatLngBounds;)V
    .locals 2

    iput-object p1, p0, Lcom/amap/api/mapcore/util/cm;->g:Lcom/amap/api/maps/model/LatLngBounds;

    invoke-direct {p0}, Lcom/amap/api/mapcore/util/cm;->f()V

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->b:Lcom/amap/api/mapcore/util/l;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lcom/amap/api/mapcore/util/l;->setRunLowFrame(Z)V

    return-void
.end method

.method public setTransparency(F)V
    .locals 2

    const/4 v0, 0x0

    cmpg-float v0, p1, v0

    if-gez v0, :cond_0

    const-string v0, "GroundOverlayDelegateImp"

    const-string v1, "Transparency must be in the range [0..1]"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    :cond_0
    iput p1, p0, Lcom/amap/api/mapcore/util/cm;->k:F

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->b:Lcom/amap/api/mapcore/util/l;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lcom/amap/api/mapcore/util/l;->setRunLowFrame(Z)V

    return-void
.end method

.method public setVisible(Z)V
    .locals 2

    iput-boolean p1, p0, Lcom/amap/api/mapcore/util/cm;->j:Z

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->b:Lcom/amap/api/mapcore/util/l;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lcom/amap/api/mapcore/util/l;->setRunLowFrame(Z)V

    return-void
.end method

.method public setZIndex(F)V
    .locals 2

    iput p1, p0, Lcom/amap/api/mapcore/util/cm;->i:F

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->b:Lcom/amap/api/mapcore/util/l;

    invoke-interface {v0}, Lcom/amap/api/mapcore/util/l;->r()V

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cm;->b:Lcom/amap/api/mapcore/util/l;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lcom/amap/api/mapcore/util/l;->setRunLowFrame(Z)V

    return-void
.end method
