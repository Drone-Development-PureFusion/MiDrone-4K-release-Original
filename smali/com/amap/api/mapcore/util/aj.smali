.class public abstract Lcom/amap/api/mapcore/util/aj;
.super Ljava/lang/Object;


# instance fields
.field protected final a:Landroid/content/Context;

.field protected b:Z

.field protected c:Landroid/view/MotionEvent;

.field protected d:Landroid/view/MotionEvent;

.field protected e:F

.field protected f:F

.field protected g:J


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/amap/api/mapcore/util/aj;->a:Landroid/content/Context;

    return-void
.end method

.method public static c(Landroid/view/MotionEvent;)Landroid/graphics/PointF;
    .locals 5

    const/4 v1, 0x0

    invoke-virtual {p0}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v3

    const/4 v0, 0x0

    move v2, v1

    :goto_0
    if-ge v0, v3, :cond_0

    invoke-virtual {p0, v0}, Landroid/view/MotionEvent;->getX(I)F

    move-result v4

    add-float/2addr v2, v4

    invoke-virtual {p0, v0}, Landroid/view/MotionEvent;->getY(I)F

    move-result v4

    add-float/2addr v1, v4

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    new-instance v0, Landroid/graphics/PointF;

    int-to-float v4, v3

    div-float/2addr v2, v4

    int-to-float v3, v3

    div-float/2addr v1, v3

    invoke-direct {v0, v2, v1}, Landroid/graphics/PointF;-><init>(FF)V

    return-object v0
.end method


# virtual methods
.method protected a()V
    .locals 2

    const/4 v1, 0x0

    iget-object v0, p0, Lcom/amap/api/mapcore/util/aj;->c:Landroid/view/MotionEvent;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amap/api/mapcore/util/aj;->c:Landroid/view/MotionEvent;

    invoke-virtual {v0}, Landroid/view/MotionEvent;->recycle()V

    iput-object v1, p0, Lcom/amap/api/mapcore/util/aj;->c:Landroid/view/MotionEvent;

    :cond_0
    iget-object v0, p0, Lcom/amap/api/mapcore/util/aj;->d:Landroid/view/MotionEvent;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amap/api/mapcore/util/aj;->d:Landroid/view/MotionEvent;

    invoke-virtual {v0}, Landroid/view/MotionEvent;->recycle()V

    iput-object v1, p0, Lcom/amap/api/mapcore/util/aj;->d:Landroid/view/MotionEvent;

    :cond_1
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amap/api/mapcore/util/aj;->b:Z

    return-void
.end method

.method protected abstract a(ILandroid/view/MotionEvent;)V
.end method

.method public a(Landroid/view/MotionEvent;)Z
    .locals 2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    and-int/lit16 v0, v0, 0xff

    iget-boolean v1, p0, Lcom/amap/api/mapcore/util/aj;->b:Z

    if-nez v1, :cond_0

    invoke-virtual {p0, v0, p1}, Lcom/amap/api/mapcore/util/aj;->a(ILandroid/view/MotionEvent;)V

    :goto_0
    const/4 v0, 0x1

    return v0

    :cond_0
    invoke-virtual {p0, v0, p1}, Lcom/amap/api/mapcore/util/aj;->b(ILandroid/view/MotionEvent;)V

    goto :goto_0
.end method

.method public b()J
    .locals 2

    iget-wide v0, p0, Lcom/amap/api/mapcore/util/aj;->g:J

    return-wide v0
.end method

.method protected abstract b(ILandroid/view/MotionEvent;)V
.end method

.method protected b(Landroid/view/MotionEvent;)V
    .locals 7

    const/4 v6, 0x0

    iget-object v0, p0, Lcom/amap/api/mapcore/util/aj;->c:Landroid/view/MotionEvent;

    iget-object v1, p0, Lcom/amap/api/mapcore/util/aj;->d:Landroid/view/MotionEvent;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amap/api/mapcore/util/aj;->d:Landroid/view/MotionEvent;

    invoke-virtual {v1}, Landroid/view/MotionEvent;->recycle()V

    const/4 v1, 0x0

    iput-object v1, p0, Lcom/amap/api/mapcore/util/aj;->d:Landroid/view/MotionEvent;

    :cond_0
    invoke-static {p1}, Landroid/view/MotionEvent;->obtain(Landroid/view/MotionEvent;)Landroid/view/MotionEvent;

    move-result-object v1

    iput-object v1, p0, Lcom/amap/api/mapcore/util/aj;->d:Landroid/view/MotionEvent;

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getEventTime()J

    move-result-wide v2

    invoke-virtual {v0}, Landroid/view/MotionEvent;->getEventTime()J

    move-result-wide v4

    sub-long/2addr v2, v4

    iput-wide v2, p0, Lcom/amap/api/mapcore/util/aj;->g:J

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x8

    if-lt v1, v2, :cond_1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionIndex()I

    move-result v1

    invoke-virtual {p1, v1}, Landroid/view/MotionEvent;->getPressure(I)F

    move-result v1

    iput v1, p0, Lcom/amap/api/mapcore/util/aj;->e:F

    invoke-virtual {v0}, Landroid/view/MotionEvent;->getActionIndex()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/view/MotionEvent;->getPressure(I)F

    move-result v0

    iput v0, p0, Lcom/amap/api/mapcore/util/aj;->f:F

    :goto_0
    return-void

    :cond_1
    invoke-virtual {p1, v6}, Landroid/view/MotionEvent;->getPressure(I)F

    move-result v1

    iput v1, p0, Lcom/amap/api/mapcore/util/aj;->e:F

    invoke-virtual {v0, v6}, Landroid/view/MotionEvent;->getPressure(I)F

    move-result v0

    iput v0, p0, Lcom/amap/api/mapcore/util/aj;->f:F

    goto :goto_0
.end method
