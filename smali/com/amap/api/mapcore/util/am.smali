.class public Lcom/amap/api/mapcore/util/am;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amap/api/mapcore/util/am$a;
    }
.end annotation


# instance fields
.field private final a:Landroid/content/Context;

.field private final b:Lcom/amap/api/mapcore/util/am$a;

.field private c:Z

.field private d:Landroid/view/MotionEvent;

.field private e:Landroid/view/MotionEvent;

.field private f:F

.field private g:F

.field private h:F

.field private i:F

.field private j:F

.field private k:F

.field private l:F

.field private m:F

.field private n:F

.field private o:F

.field private p:F

.field private q:J

.field private final r:F

.field private s:F

.field private t:F

.field private u:Z

.field private v:Z

.field private w:I

.field private x:I

.field private y:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/amap/api/mapcore/util/am$a;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-static {p1}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v0

    iput-object p1, p0, Lcom/amap/api/mapcore/util/am;->a:Landroid/content/Context;

    iput-object p2, p0, Lcom/amap/api/mapcore/util/am;->b:Lcom/amap/api/mapcore/util/am$a;

    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledEdgeSlop()I

    move-result v0

    int-to-float v0, v0

    iput v0, p0, Lcom/amap/api/mapcore/util/am;->r:F

    return-void
.end method

.method private static a(Landroid/view/MotionEvent;I)F
    .locals 2

    if-gez p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    if-nez p1, :cond_1

    invoke-virtual {p0}, Landroid/view/MotionEvent;->getRawX()F

    move-result v0

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Landroid/view/MotionEvent;->getRawX()F

    move-result v0

    invoke-virtual {p0}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    sub-float/2addr v0, v1

    invoke-virtual {p0, p1}, Landroid/view/MotionEvent;->getX(I)F

    move-result v1

    add-float/2addr v0, v1

    goto :goto_0
.end method

.method private a(Landroid/view/MotionEvent;II)I
    .locals 10

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v2

    invoke-virtual {p1, p2}, Landroid/view/MotionEvent;->findPointerIndex(I)I

    move-result v3

    const/4 v1, -0x1

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v2, :cond_1

    if-eq v0, p3, :cond_0

    if-eq v0, v3, :cond_0

    iget v4, p0, Lcom/amap/api/mapcore/util/am;->r:F

    iget v5, p0, Lcom/amap/api/mapcore/util/am;->s:F

    iget v6, p0, Lcom/amap/api/mapcore/util/am;->t:F

    invoke-static {p1, v0}, Lcom/amap/api/mapcore/util/am;->a(Landroid/view/MotionEvent;I)F

    move-result v7

    invoke-static {p1, v0}, Lcom/amap/api/mapcore/util/am;->b(Landroid/view/MotionEvent;I)F

    move-result v8

    cmpl-float v9, v7, v4

    if-ltz v9, :cond_0

    cmpl-float v4, v8, v4

    if-ltz v4, :cond_0

    cmpg-float v4, v7, v5

    if-gtz v4, :cond_0

    cmpg-float v4, v8, v6

    if-gtz v4, :cond_0

    :goto_1
    return v0

    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    move v0, v1

    goto :goto_1
.end method

.method private static b(Landroid/view/MotionEvent;I)F
    .locals 2

    if-gez p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    if-nez p1, :cond_1

    invoke-virtual {p0}, Landroid/view/MotionEvent;->getRawY()F

    move-result v0

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Landroid/view/MotionEvent;->getRawY()F

    move-result v0

    invoke-virtual {p0}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    sub-float/2addr v0, v1

    invoke-virtual {p0, p1}, Landroid/view/MotionEvent;->getY(I)F

    move-result v1

    add-float/2addr v0, v1

    goto :goto_0
.end method

.method private b(Landroid/view/MotionEvent;)V
    .locals 14

    const/high16 v13, 0x3f000000    # 0.5f

    const/high16 v1, -0x40800000    # -1.0f

    iget-object v0, p0, Lcom/amap/api/mapcore/util/am;->e:Landroid/view/MotionEvent;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amap/api/mapcore/util/am;->e:Landroid/view/MotionEvent;

    invoke-virtual {v0}, Landroid/view/MotionEvent;->recycle()V

    :cond_0
    invoke-static {p1}, Landroid/view/MotionEvent;->obtain(Landroid/view/MotionEvent;)Landroid/view/MotionEvent;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/api/mapcore/util/am;->e:Landroid/view/MotionEvent;

    iput v1, p0, Lcom/amap/api/mapcore/util/am;->l:F

    iput v1, p0, Lcom/amap/api/mapcore/util/am;->m:F

    iput v1, p0, Lcom/amap/api/mapcore/util/am;->n:F

    iget-object v0, p0, Lcom/amap/api/mapcore/util/am;->d:Landroid/view/MotionEvent;

    iget v1, p0, Lcom/amap/api/mapcore/util/am;->w:I

    invoke-virtual {v0, v1}, Landroid/view/MotionEvent;->findPointerIndex(I)I

    move-result v1

    iget v2, p0, Lcom/amap/api/mapcore/util/am;->x:I

    invoke-virtual {v0, v2}, Landroid/view/MotionEvent;->findPointerIndex(I)I

    move-result v2

    iget v3, p0, Lcom/amap/api/mapcore/util/am;->w:I

    invoke-virtual {p1, v3}, Landroid/view/MotionEvent;->findPointerIndex(I)I

    move-result v3

    iget v4, p0, Lcom/amap/api/mapcore/util/am;->x:I

    invoke-virtual {p1, v4}, Landroid/view/MotionEvent;->findPointerIndex(I)I

    move-result v4

    if-ltz v1, :cond_1

    if-ltz v2, :cond_1

    if-ltz v3, :cond_1

    if-gez v4, :cond_3

    :cond_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amap/api/mapcore/util/am;->v:Z

    iget-boolean v0, p0, Lcom/amap/api/mapcore/util/am;->c:Z

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/amap/api/mapcore/util/am;->b:Lcom/amap/api/mapcore/util/am$a;

    invoke-interface {v0, p0}, Lcom/amap/api/mapcore/util/am$a;->c(Lcom/amap/api/mapcore/util/am;)V

    :cond_2
    :goto_0
    return-void

    :cond_3
    invoke-virtual {v0, v1}, Landroid/view/MotionEvent;->getX(I)F

    move-result v5

    invoke-virtual {v0, v1}, Landroid/view/MotionEvent;->getY(I)F

    move-result v6

    invoke-virtual {v0, v2}, Landroid/view/MotionEvent;->getX(I)F

    move-result v7

    invoke-virtual {v0, v2}, Landroid/view/MotionEvent;->getY(I)F

    move-result v8

    invoke-virtual {p1, v3}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    invoke-virtual {p1, v3}, Landroid/view/MotionEvent;->getY(I)F

    move-result v10

    invoke-virtual {p1, v4}, Landroid/view/MotionEvent;->getX(I)F

    move-result v11

    invoke-virtual {p1, v4}, Landroid/view/MotionEvent;->getY(I)F

    move-result v12

    sub-float v5, v7, v5

    sub-float v6, v8, v6

    sub-float v7, v11, v9

    sub-float v8, v12, v10

    iput v5, p0, Lcom/amap/api/mapcore/util/am;->h:F

    iput v6, p0, Lcom/amap/api/mapcore/util/am;->i:F

    iput v7, p0, Lcom/amap/api/mapcore/util/am;->j:F

    iput v8, p0, Lcom/amap/api/mapcore/util/am;->k:F

    mul-float v5, v7, v13

    add-float/2addr v5, v9

    iput v5, p0, Lcom/amap/api/mapcore/util/am;->f:F

    mul-float v5, v8, v13

    add-float/2addr v5, v10

    iput v5, p0, Lcom/amap/api/mapcore/util/am;->g:F

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getEventTime()J

    move-result-wide v6

    invoke-virtual {v0}, Landroid/view/MotionEvent;->getEventTime()J

    move-result-wide v8

    sub-long/2addr v6, v8

    iput-wide v6, p0, Lcom/amap/api/mapcore/util/am;->q:J

    invoke-virtual {p1, v3}, Landroid/view/MotionEvent;->getPressure(I)F

    move-result v3

    invoke-virtual {p1, v4}, Landroid/view/MotionEvent;->getPressure(I)F

    move-result v4

    add-float/2addr v3, v4

    iput v3, p0, Lcom/amap/api/mapcore/util/am;->o:F

    invoke-virtual {v0, v1}, Landroid/view/MotionEvent;->getPressure(I)F

    move-result v1

    invoke-virtual {v0, v2}, Landroid/view/MotionEvent;->getPressure(I)F

    move-result v0

    add-float/2addr v0, v1

    iput v0, p0, Lcom/amap/api/mapcore/util/am;->p:F

    goto :goto_0
.end method

.method private j()V
    .locals 4

    const/4 v3, 0x0

    const/4 v2, -0x1

    const/4 v1, 0x0

    iget-object v0, p0, Lcom/amap/api/mapcore/util/am;->d:Landroid/view/MotionEvent;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amap/api/mapcore/util/am;->d:Landroid/view/MotionEvent;

    invoke-virtual {v0}, Landroid/view/MotionEvent;->recycle()V

    iput-object v3, p0, Lcom/amap/api/mapcore/util/am;->d:Landroid/view/MotionEvent;

    :cond_0
    iget-object v0, p0, Lcom/amap/api/mapcore/util/am;->e:Landroid/view/MotionEvent;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amap/api/mapcore/util/am;->e:Landroid/view/MotionEvent;

    invoke-virtual {v0}, Landroid/view/MotionEvent;->recycle()V

    iput-object v3, p0, Lcom/amap/api/mapcore/util/am;->e:Landroid/view/MotionEvent;

    :cond_1
    iput-boolean v1, p0, Lcom/amap/api/mapcore/util/am;->u:Z

    iput-boolean v1, p0, Lcom/amap/api/mapcore/util/am;->c:Z

    iput v2, p0, Lcom/amap/api/mapcore/util/am;->w:I

    iput v2, p0, Lcom/amap/api/mapcore/util/am;->x:I

    iput-boolean v1, p0, Lcom/amap/api/mapcore/util/am;->v:Z

    return-void
.end method


# virtual methods
.method public a()F
    .locals 1

    iget v0, p0, Lcom/amap/api/mapcore/util/am;->f:F

    return v0
.end method

.method public a(Landroid/view/MotionEvent;)Z
    .locals 14

    const/4 v0, -0x1

    const/16 v8, 0x8

    const/high16 v12, -0x40800000    # -1.0f

    const/4 v4, 0x1

    const/4 v2, 0x0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v1

    and-int/lit16 v1, v1, 0xff

    if-nez v1, :cond_0

    invoke-direct {p0}, Lcom/amap/api/mapcore/util/am;->j()V

    :cond_0
    iget-boolean v3, p0, Lcom/amap/api/mapcore/util/am;->v:Z

    if-eqz v3, :cond_3

    move v4, v2

    :cond_1
    :goto_0
    move v2, v4

    :cond_2
    :goto_1
    return v2

    :cond_3
    iget-boolean v3, p0, Lcom/amap/api/mapcore/util/am;->c:Z

    if-nez v3, :cond_1a

    packed-switch v1, :pswitch_data_0

    :pswitch_0
    goto :goto_0

    :pswitch_1
    invoke-virtual {p1, v2}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v0

    iput v0, p0, Lcom/amap/api/mapcore/util/am;->w:I

    iput-boolean v4, p0, Lcom/amap/api/mapcore/util/am;->y:Z

    goto :goto_0

    :pswitch_2
    invoke-direct {p0}, Lcom/amap/api/mapcore/util/am;->j()V

    goto :goto_0

    :pswitch_3
    iget-object v1, p0, Lcom/amap/api/mapcore/util/am;->a:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v3, v1, Landroid/util/DisplayMetrics;->widthPixels:I

    int-to-float v3, v3

    iget v5, p0, Lcom/amap/api/mapcore/util/am;->r:F

    sub-float/2addr v3, v5

    iput v3, p0, Lcom/amap/api/mapcore/util/am;->s:F

    iget v1, v1, Landroid/util/DisplayMetrics;->heightPixels:I

    int-to-float v1, v1

    iget v3, p0, Lcom/amap/api/mapcore/util/am;->r:F

    sub-float/2addr v1, v3

    iput v1, p0, Lcom/amap/api/mapcore/util/am;->t:F

    iget-object v1, p0, Lcom/amap/api/mapcore/util/am;->d:Landroid/view/MotionEvent;

    if-eqz v1, :cond_4

    iget-object v1, p0, Lcom/amap/api/mapcore/util/am;->d:Landroid/view/MotionEvent;

    invoke-virtual {v1}, Landroid/view/MotionEvent;->recycle()V

    :cond_4
    invoke-static {p1}, Landroid/view/MotionEvent;->obtain(Landroid/view/MotionEvent;)Landroid/view/MotionEvent;

    move-result-object v1

    iput-object v1, p0, Lcom/amap/api/mapcore/util/am;->d:Landroid/view/MotionEvent;

    const-wide/16 v6, 0x0

    iput-wide v6, p0, Lcom/amap/api/mapcore/util/am;->q:J

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v1, v8, :cond_9

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionIndex()I

    move-result v1

    iget v3, p0, Lcom/amap/api/mapcore/util/am;->w:I

    invoke-virtual {p1, v3}, Landroid/view/MotionEvent;->findPointerIndex(I)I

    move-result v3

    invoke-virtual {p1, v1}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v5

    iput v5, p0, Lcom/amap/api/mapcore/util/am;->x:I

    if-ltz v3, :cond_5

    if-ne v3, v1, :cond_2b

    :cond_5
    if-ne v3, v1, :cond_8

    :goto_2
    invoke-direct {p0, p1, v0, v3}, Lcom/amap/api/mapcore/util/am;->a(Landroid/view/MotionEvent;II)I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v3

    iput v3, p0, Lcom/amap/api/mapcore/util/am;->w:I

    move v13, v1

    move v1, v0

    move v0, v13

    :goto_3
    iput-boolean v2, p0, Lcom/amap/api/mapcore/util/am;->y:Z

    invoke-direct {p0, p1}, Lcom/amap/api/mapcore/util/am;->b(Landroid/view/MotionEvent;)V

    iget v3, p0, Lcom/amap/api/mapcore/util/am;->r:F

    iget v6, p0, Lcom/amap/api/mapcore/util/am;->s:F

    iget v7, p0, Lcom/amap/api/mapcore/util/am;->t:F

    invoke-static {p1, v1}, Lcom/amap/api/mapcore/util/am;->a(Landroid/view/MotionEvent;I)F

    move-result v5

    invoke-static {p1, v1}, Lcom/amap/api/mapcore/util/am;->b(Landroid/view/MotionEvent;I)F

    move-result v8

    invoke-static {p1, v0}, Lcom/amap/api/mapcore/util/am;->a(Landroid/view/MotionEvent;I)F

    move-result v9

    invoke-static {p1, v0}, Lcom/amap/api/mapcore/util/am;->b(Landroid/view/MotionEvent;I)F

    move-result v10

    cmpg-float v11, v5, v3

    if-ltz v11, :cond_6

    cmpg-float v11, v8, v3

    if-ltz v11, :cond_6

    cmpl-float v5, v5, v6

    if-gtz v5, :cond_6

    cmpl-float v5, v8, v7

    if-lez v5, :cond_a

    :cond_6
    move v5, v4

    :goto_4
    cmpg-float v8, v9, v3

    if-ltz v8, :cond_7

    cmpg-float v3, v10, v3

    if-ltz v3, :cond_7

    cmpl-float v3, v9, v6

    if-gtz v3, :cond_7

    cmpl-float v3, v10, v7

    if-lez v3, :cond_b

    :cond_7
    move v3, v4

    :goto_5
    if-eqz v5, :cond_c

    if-eqz v3, :cond_c

    iput v12, p0, Lcom/amap/api/mapcore/util/am;->f:F

    iput v12, p0, Lcom/amap/api/mapcore/util/am;->g:F

    iput-boolean v4, p0, Lcom/amap/api/mapcore/util/am;->u:Z

    goto/16 :goto_0

    :cond_8
    iget v0, p0, Lcom/amap/api/mapcore/util/am;->x:I

    goto :goto_2

    :cond_9
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v0

    if-lez v0, :cond_2a

    invoke-virtual {p1, v4}, Landroid/view/MotionEvent;->findPointerIndex(I)I

    move-result v0

    iget v1, p0, Lcom/amap/api/mapcore/util/am;->w:I

    invoke-virtual {p1, v1}, Landroid/view/MotionEvent;->findPointerIndex(I)I

    move-result v1

    invoke-virtual {p1, v0}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v3

    iput v3, p0, Lcom/amap/api/mapcore/util/am;->x:I

    goto :goto_3

    :cond_a
    move v5, v2

    goto :goto_4

    :cond_b
    move v3, v2

    goto :goto_5

    :cond_c
    if-eqz v5, :cond_d

    invoke-virtual {p1, v0}, Landroid/view/MotionEvent;->getX(I)F

    move-result v1

    iput v1, p0, Lcom/amap/api/mapcore/util/am;->f:F

    invoke-virtual {p1, v0}, Landroid/view/MotionEvent;->getY(I)F

    move-result v0

    iput v0, p0, Lcom/amap/api/mapcore/util/am;->g:F

    iput-boolean v4, p0, Lcom/amap/api/mapcore/util/am;->u:Z

    goto/16 :goto_0

    :cond_d
    if-eqz v3, :cond_e

    invoke-virtual {p1, v1}, Landroid/view/MotionEvent;->getX(I)F

    move-result v0

    iput v0, p0, Lcom/amap/api/mapcore/util/am;->f:F

    invoke-virtual {p1, v1}, Landroid/view/MotionEvent;->getY(I)F

    move-result v0

    iput v0, p0, Lcom/amap/api/mapcore/util/am;->g:F

    iput-boolean v4, p0, Lcom/amap/api/mapcore/util/am;->u:Z

    goto/16 :goto_0

    :cond_e
    iput-boolean v2, p0, Lcom/amap/api/mapcore/util/am;->u:Z

    iget-object v0, p0, Lcom/amap/api/mapcore/util/am;->b:Lcom/amap/api/mapcore/util/am$a;

    invoke-interface {v0, p0}, Lcom/amap/api/mapcore/util/am$a;->b(Lcom/amap/api/mapcore/util/am;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/amap/api/mapcore/util/am;->c:Z

    goto/16 :goto_0

    :pswitch_4
    iget-boolean v0, p0, Lcom/amap/api/mapcore/util/am;->u:Z

    if-eqz v0, :cond_1

    iget v0, p0, Lcom/amap/api/mapcore/util/am;->r:F

    iget v5, p0, Lcom/amap/api/mapcore/util/am;->s:F

    iget v7, p0, Lcom/amap/api/mapcore/util/am;->t:F

    iget v1, p0, Lcom/amap/api/mapcore/util/am;->w:I

    invoke-virtual {p1, v1}, Landroid/view/MotionEvent;->findPointerIndex(I)I

    move-result v6

    iget v1, p0, Lcom/amap/api/mapcore/util/am;->x:I

    invoke-virtual {p1, v1}, Landroid/view/MotionEvent;->findPointerIndex(I)I

    move-result v3

    invoke-static {p1, v6}, Lcom/amap/api/mapcore/util/am;->a(Landroid/view/MotionEvent;I)F

    move-result v1

    invoke-static {p1, v6}, Lcom/amap/api/mapcore/util/am;->b(Landroid/view/MotionEvent;I)F

    move-result v8

    invoke-static {p1, v3}, Lcom/amap/api/mapcore/util/am;->a(Landroid/view/MotionEvent;I)F

    move-result v9

    invoke-static {p1, v3}, Lcom/amap/api/mapcore/util/am;->b(Landroid/view/MotionEvent;I)F

    move-result v10

    cmpg-float v11, v1, v0

    if-ltz v11, :cond_f

    cmpg-float v11, v8, v0

    if-ltz v11, :cond_f

    cmpl-float v1, v1, v5

    if-gtz v1, :cond_f

    cmpl-float v1, v8, v7

    if-lez v1, :cond_11

    :cond_f
    move v1, v4

    :goto_6
    cmpg-float v8, v9, v0

    if-ltz v8, :cond_10

    cmpg-float v0, v10, v0

    if-ltz v0, :cond_10

    cmpl-float v0, v9, v5

    if-gtz v0, :cond_10

    cmpl-float v0, v10, v7

    if-lez v0, :cond_12

    :cond_10
    move v0, v4

    :goto_7
    if-eqz v1, :cond_29

    iget v5, p0, Lcom/amap/api/mapcore/util/am;->x:I

    invoke-direct {p0, p1, v5, v6}, Lcom/amap/api/mapcore/util/am;->a(Landroid/view/MotionEvent;II)I

    move-result v5

    if-ltz v5, :cond_29

    invoke-virtual {p1, v5}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v1

    iput v1, p0, Lcom/amap/api/mapcore/util/am;->w:I

    invoke-static {p1, v5}, Lcom/amap/api/mapcore/util/am;->a(Landroid/view/MotionEvent;I)F

    invoke-static {p1, v5}, Lcom/amap/api/mapcore/util/am;->b(Landroid/view/MotionEvent;I)F

    move v6, v5

    move v5, v2

    :goto_8
    if-eqz v0, :cond_28

    iget v1, p0, Lcom/amap/api/mapcore/util/am;->w:I

    invoke-direct {p0, p1, v1, v3}, Lcom/amap/api/mapcore/util/am;->a(Landroid/view/MotionEvent;II)I

    move-result v1

    if-ltz v1, :cond_28

    invoke-virtual {p1, v1}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v0

    iput v0, p0, Lcom/amap/api/mapcore/util/am;->x:I

    invoke-static {p1, v1}, Lcom/amap/api/mapcore/util/am;->a(Landroid/view/MotionEvent;I)F

    invoke-static {p1, v1}, Lcom/amap/api/mapcore/util/am;->b(Landroid/view/MotionEvent;I)F

    move v0, v2

    :goto_9
    if-eqz v5, :cond_13

    if-eqz v0, :cond_13

    iput v12, p0, Lcom/amap/api/mapcore/util/am;->f:F

    iput v12, p0, Lcom/amap/api/mapcore/util/am;->g:F

    goto/16 :goto_0

    :cond_11
    move v1, v2

    goto :goto_6

    :cond_12
    move v0, v2

    goto :goto_7

    :cond_13
    if-eqz v5, :cond_14

    invoke-virtual {p1, v1}, Landroid/view/MotionEvent;->getX(I)F

    move-result v0

    iput v0, p0, Lcom/amap/api/mapcore/util/am;->f:F

    invoke-virtual {p1, v1}, Landroid/view/MotionEvent;->getY(I)F

    move-result v0

    iput v0, p0, Lcom/amap/api/mapcore/util/am;->g:F

    goto/16 :goto_0

    :cond_14
    if-eqz v0, :cond_15

    invoke-virtual {p1, v6}, Landroid/view/MotionEvent;->getX(I)F

    move-result v0

    iput v0, p0, Lcom/amap/api/mapcore/util/am;->f:F

    invoke-virtual {p1, v6}, Landroid/view/MotionEvent;->getY(I)F

    move-result v0

    iput v0, p0, Lcom/amap/api/mapcore/util/am;->g:F

    goto/16 :goto_0

    :cond_15
    iput-boolean v2, p0, Lcom/amap/api/mapcore/util/am;->u:Z

    iget-object v0, p0, Lcom/amap/api/mapcore/util/am;->b:Lcom/amap/api/mapcore/util/am$a;

    invoke-interface {v0, p0}, Lcom/amap/api/mapcore/util/am$a;->b(Lcom/amap/api/mapcore/util/am;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/amap/api/mapcore/util/am;->c:Z

    goto/16 :goto_0

    :pswitch_5
    iget-boolean v1, p0, Lcom/amap/api/mapcore/util/am;->u:Z

    if-eqz v1, :cond_1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v3

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v1, v8, :cond_27

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionIndex()I

    move-result v1

    :goto_a
    invoke-virtual {p1, v1}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v5

    const/4 v6, 0x2

    if-le v3, v6, :cond_17

    iget v0, p0, Lcom/amap/api/mapcore/util/am;->w:I

    if-ne v5, v0, :cond_16

    iget v0, p0, Lcom/amap/api/mapcore/util/am;->x:I

    invoke-direct {p0, p1, v0, v1}, Lcom/amap/api/mapcore/util/am;->a(Landroid/view/MotionEvent;II)I

    move-result v0

    if-ltz v0, :cond_1

    invoke-virtual {p1, v0}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v0

    iput v0, p0, Lcom/amap/api/mapcore/util/am;->w:I

    goto/16 :goto_0

    :cond_16
    iget v0, p0, Lcom/amap/api/mapcore/util/am;->x:I

    if-ne v5, v0, :cond_1

    iget v0, p0, Lcom/amap/api/mapcore/util/am;->w:I

    invoke-direct {p0, p1, v0, v1}, Lcom/amap/api/mapcore/util/am;->a(Landroid/view/MotionEvent;II)I

    move-result v0

    if-ltz v0, :cond_1

    invoke-virtual {p1, v0}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v0

    iput v0, p0, Lcom/amap/api/mapcore/util/am;->x:I

    goto/16 :goto_0

    :cond_17
    iget v1, p0, Lcom/amap/api/mapcore/util/am;->w:I

    if-ne v5, v1, :cond_18

    iget v1, p0, Lcom/amap/api/mapcore/util/am;->x:I

    :goto_b
    invoke-virtual {p1, v1}, Landroid/view/MotionEvent;->findPointerIndex(I)I

    move-result v1

    if-gez v1, :cond_19

    iput-boolean v4, p0, Lcom/amap/api/mapcore/util/am;->v:Z

    iget-boolean v0, p0, Lcom/amap/api/mapcore/util/am;->c:Z

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/amap/api/mapcore/util/am;->b:Lcom/amap/api/mapcore/util/am$a;

    invoke-interface {v0, p0}, Lcom/amap/api/mapcore/util/am$a;->c(Lcom/amap/api/mapcore/util/am;)V

    goto/16 :goto_1

    :cond_18
    iget v1, p0, Lcom/amap/api/mapcore/util/am;->w:I

    goto :goto_b

    :cond_19
    invoke-virtual {p1, v1}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v2

    iput v2, p0, Lcom/amap/api/mapcore/util/am;->w:I

    iput-boolean v4, p0, Lcom/amap/api/mapcore/util/am;->y:Z

    iput v0, p0, Lcom/amap/api/mapcore/util/am;->x:I

    invoke-virtual {p1, v1}, Landroid/view/MotionEvent;->getX(I)F

    move-result v0

    iput v0, p0, Lcom/amap/api/mapcore/util/am;->f:F

    invoke-virtual {p1, v1}, Landroid/view/MotionEvent;->getY(I)F

    move-result v0

    iput v0, p0, Lcom/amap/api/mapcore/util/am;->g:F

    goto/16 :goto_0

    :cond_1a
    packed-switch v1, :pswitch_data_1

    :pswitch_6
    goto/16 :goto_0

    :pswitch_7
    invoke-direct {p0}, Lcom/amap/api/mapcore/util/am;->j()V

    goto/16 :goto_0

    :pswitch_8
    iget-object v1, p0, Lcom/amap/api/mapcore/util/am;->b:Lcom/amap/api/mapcore/util/am$a;

    invoke-interface {v1, p0}, Lcom/amap/api/mapcore/util/am$a;->c(Lcom/amap/api/mapcore/util/am;)V

    iget v1, p0, Lcom/amap/api/mapcore/util/am;->w:I

    iget v3, p0, Lcom/amap/api/mapcore/util/am;->x:I

    invoke-direct {p0}, Lcom/amap/api/mapcore/util/am;->j()V

    invoke-static {p1}, Landroid/view/MotionEvent;->obtain(Landroid/view/MotionEvent;)Landroid/view/MotionEvent;

    move-result-object v5

    iput-object v5, p0, Lcom/amap/api/mapcore/util/am;->d:Landroid/view/MotionEvent;

    iget-boolean v5, p0, Lcom/amap/api/mapcore/util/am;->y:Z

    if-eqz v5, :cond_1d

    :goto_c
    iput v1, p0, Lcom/amap/api/mapcore/util/am;->w:I

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v1, v8, :cond_1e

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionIndex()I

    move-result v1

    invoke-virtual {p1, v1}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v1

    iput v1, p0, Lcom/amap/api/mapcore/util/am;->x:I

    :goto_d
    iput-boolean v2, p0, Lcom/amap/api/mapcore/util/am;->y:Z

    iget v1, p0, Lcom/amap/api/mapcore/util/am;->w:I

    invoke-virtual {p1, v1}, Landroid/view/MotionEvent;->findPointerIndex(I)I

    move-result v1

    if-ltz v1, :cond_1b

    iget v2, p0, Lcom/amap/api/mapcore/util/am;->w:I

    iget v3, p0, Lcom/amap/api/mapcore/util/am;->x:I

    if-ne v2, v3, :cond_1c

    :cond_1b
    iget v2, p0, Lcom/amap/api/mapcore/util/am;->w:I

    iget v3, p0, Lcom/amap/api/mapcore/util/am;->x:I

    if-ne v2, v3, :cond_1f

    :goto_e
    invoke-direct {p0, p1, v0, v1}, Lcom/amap/api/mapcore/util/am;->a(Landroid/view/MotionEvent;II)I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v0

    iput v0, p0, Lcom/amap/api/mapcore/util/am;->w:I

    :cond_1c
    invoke-direct {p0, p1}, Lcom/amap/api/mapcore/util/am;->b(Landroid/view/MotionEvent;)V

    iget-object v0, p0, Lcom/amap/api/mapcore/util/am;->b:Lcom/amap/api/mapcore/util/am$a;

    invoke-interface {v0, p0}, Lcom/amap/api/mapcore/util/am$a;->b(Lcom/amap/api/mapcore/util/am;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/amap/api/mapcore/util/am;->c:Z

    goto/16 :goto_0

    :cond_1d
    move v1, v3

    goto :goto_c

    :cond_1e
    invoke-virtual {p1, v4}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v1

    iput v1, p0, Lcom/amap/api/mapcore/util/am;->x:I

    goto :goto_d

    :cond_1f
    iget v0, p0, Lcom/amap/api/mapcore/util/am;->x:I

    goto :goto_e

    :pswitch_9
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v1

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v0, v8, :cond_26

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionIndex()I

    move-result v0

    :goto_f
    invoke-virtual {p1, v0}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v3

    const/4 v5, 0x2

    if-le v1, v5, :cond_24

    iget v1, p0, Lcom/amap/api/mapcore/util/am;->w:I

    if-ne v3, v1, :cond_22

    iget v1, p0, Lcom/amap/api/mapcore/util/am;->x:I

    invoke-direct {p0, p1, v1, v0}, Lcom/amap/api/mapcore/util/am;->a(Landroid/view/MotionEvent;II)I

    move-result v0

    if-ltz v0, :cond_21

    iget-object v1, p0, Lcom/amap/api/mapcore/util/am;->b:Lcom/amap/api/mapcore/util/am$a;

    invoke-interface {v1, p0}, Lcom/amap/api/mapcore/util/am$a;->c(Lcom/amap/api/mapcore/util/am;)V

    invoke-virtual {p1, v0}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v0

    iput v0, p0, Lcom/amap/api/mapcore/util/am;->w:I

    iput-boolean v4, p0, Lcom/amap/api/mapcore/util/am;->y:Z

    invoke-static {p1}, Landroid/view/MotionEvent;->obtain(Landroid/view/MotionEvent;)Landroid/view/MotionEvent;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/api/mapcore/util/am;->d:Landroid/view/MotionEvent;

    invoke-direct {p0, p1}, Lcom/amap/api/mapcore/util/am;->b(Landroid/view/MotionEvent;)V

    iget-object v0, p0, Lcom/amap/api/mapcore/util/am;->b:Lcom/amap/api/mapcore/util/am$a;

    invoke-interface {v0, p0}, Lcom/amap/api/mapcore/util/am$a;->b(Lcom/amap/api/mapcore/util/am;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/amap/api/mapcore/util/am;->c:Z

    :cond_20
    :goto_10
    iget-object v0, p0, Lcom/amap/api/mapcore/util/am;->d:Landroid/view/MotionEvent;

    invoke-virtual {v0}, Landroid/view/MotionEvent;->recycle()V

    invoke-static {p1}, Landroid/view/MotionEvent;->obtain(Landroid/view/MotionEvent;)Landroid/view/MotionEvent;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/api/mapcore/util/am;->d:Landroid/view/MotionEvent;

    invoke-direct {p0, p1}, Lcom/amap/api/mapcore/util/am;->b(Landroid/view/MotionEvent;)V

    :goto_11
    if-eqz v2, :cond_1

    invoke-direct {p0, p1}, Lcom/amap/api/mapcore/util/am;->b(Landroid/view/MotionEvent;)V

    iget v0, p0, Lcom/amap/api/mapcore/util/am;->w:I

    if-ne v3, v0, :cond_25

    iget v0, p0, Lcom/amap/api/mapcore/util/am;->x:I

    :goto_12
    invoke-virtual {p1, v0}, Landroid/view/MotionEvent;->findPointerIndex(I)I

    move-result v1

    invoke-virtual {p1, v1}, Landroid/view/MotionEvent;->getX(I)F

    move-result v2

    iput v2, p0, Lcom/amap/api/mapcore/util/am;->f:F

    invoke-virtual {p1, v1}, Landroid/view/MotionEvent;->getY(I)F

    move-result v1

    iput v1, p0, Lcom/amap/api/mapcore/util/am;->g:F

    iget-object v1, p0, Lcom/amap/api/mapcore/util/am;->b:Lcom/amap/api/mapcore/util/am$a;

    invoke-interface {v1, p0}, Lcom/amap/api/mapcore/util/am$a;->c(Lcom/amap/api/mapcore/util/am;)V

    invoke-direct {p0}, Lcom/amap/api/mapcore/util/am;->j()V

    iput v0, p0, Lcom/amap/api/mapcore/util/am;->w:I

    iput-boolean v4, p0, Lcom/amap/api/mapcore/util/am;->y:Z

    goto/16 :goto_0

    :cond_21
    move v2, v4

    goto :goto_10

    :cond_22
    iget v1, p0, Lcom/amap/api/mapcore/util/am;->x:I

    if-ne v3, v1, :cond_20

    iget v1, p0, Lcom/amap/api/mapcore/util/am;->w:I

    invoke-direct {p0, p1, v1, v0}, Lcom/amap/api/mapcore/util/am;->a(Landroid/view/MotionEvent;II)I

    move-result v0

    if-ltz v0, :cond_23

    iget-object v1, p0, Lcom/amap/api/mapcore/util/am;->b:Lcom/amap/api/mapcore/util/am$a;

    invoke-interface {v1, p0}, Lcom/amap/api/mapcore/util/am$a;->c(Lcom/amap/api/mapcore/util/am;)V

    invoke-virtual {p1, v0}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v0

    iput v0, p0, Lcom/amap/api/mapcore/util/am;->x:I

    iput-boolean v2, p0, Lcom/amap/api/mapcore/util/am;->y:Z

    invoke-static {p1}, Landroid/view/MotionEvent;->obtain(Landroid/view/MotionEvent;)Landroid/view/MotionEvent;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/api/mapcore/util/am;->d:Landroid/view/MotionEvent;

    invoke-direct {p0, p1}, Lcom/amap/api/mapcore/util/am;->b(Landroid/view/MotionEvent;)V

    iget-object v0, p0, Lcom/amap/api/mapcore/util/am;->b:Lcom/amap/api/mapcore/util/am$a;

    invoke-interface {v0, p0}, Lcom/amap/api/mapcore/util/am$a;->b(Lcom/amap/api/mapcore/util/am;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/amap/api/mapcore/util/am;->c:Z

    goto :goto_10

    :cond_23
    move v2, v4

    goto :goto_10

    :cond_24
    move v2, v4

    goto :goto_11

    :cond_25
    iget v0, p0, Lcom/amap/api/mapcore/util/am;->w:I

    goto :goto_12

    :pswitch_a
    iget-object v0, p0, Lcom/amap/api/mapcore/util/am;->b:Lcom/amap/api/mapcore/util/am$a;

    invoke-interface {v0, p0}, Lcom/amap/api/mapcore/util/am$a;->c(Lcom/amap/api/mapcore/util/am;)V

    invoke-direct {p0}, Lcom/amap/api/mapcore/util/am;->j()V

    goto/16 :goto_0

    :pswitch_b
    invoke-direct {p0, p1}, Lcom/amap/api/mapcore/util/am;->b(Landroid/view/MotionEvent;)V

    iget v0, p0, Lcom/amap/api/mapcore/util/am;->o:F

    iget v1, p0, Lcom/amap/api/mapcore/util/am;->p:F

    div-float/2addr v0, v1

    const v1, 0x3f2b851f    # 0.67f

    cmpl-float v0, v0, v1

    if-lez v0, :cond_1

    iget-object v0, p0, Lcom/amap/api/mapcore/util/am;->b:Lcom/amap/api/mapcore/util/am$a;

    invoke-interface {v0, p0}, Lcom/amap/api/mapcore/util/am$a;->a(Lcom/amap/api/mapcore/util/am;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amap/api/mapcore/util/am;->d:Landroid/view/MotionEvent;

    invoke-virtual {v0}, Landroid/view/MotionEvent;->recycle()V

    invoke-static {p1}, Landroid/view/MotionEvent;->obtain(Landroid/view/MotionEvent;)Landroid/view/MotionEvent;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/api/mapcore/util/am;->d:Landroid/view/MotionEvent;

    goto/16 :goto_0

    :cond_26
    move v0, v2

    goto/16 :goto_f

    :cond_27
    move v1, v2

    goto/16 :goto_a

    :cond_28
    move v1, v3

    goto/16 :goto_9

    :cond_29
    move v5, v1

    goto/16 :goto_8

    :cond_2a
    move v0, v2

    move v1, v2

    goto/16 :goto_3

    :cond_2b
    move v0, v1

    move v1, v3

    goto/16 :goto_3

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_2
        :pswitch_4
        :pswitch_0
        :pswitch_0
        :pswitch_3
        :pswitch_5
    .end packed-switch

    :pswitch_data_1
    .packed-switch 0x1
        :pswitch_7
        :pswitch_b
        :pswitch_a
        :pswitch_6
        :pswitch_8
        :pswitch_9
    .end packed-switch
.end method

.method public b()F
    .locals 1

    iget v0, p0, Lcom/amap/api/mapcore/util/am;->g:F

    return v0
.end method

.method public c()F
    .locals 2

    iget v0, p0, Lcom/amap/api/mapcore/util/am;->l:F

    const/high16 v1, -0x40800000    # -1.0f

    cmpl-float v0, v0, v1

    if-nez v0, :cond_0

    iget v0, p0, Lcom/amap/api/mapcore/util/am;->j:F

    iget v1, p0, Lcom/amap/api/mapcore/util/am;->k:F

    mul-float/2addr v0, v0

    mul-float/2addr v1, v1

    add-float/2addr v0, v1

    float-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v0

    double-to-float v0, v0

    iput v0, p0, Lcom/amap/api/mapcore/util/am;->l:F

    :cond_0
    iget v0, p0, Lcom/amap/api/mapcore/util/am;->l:F

    return v0
.end method

.method public d()F
    .locals 1

    iget v0, p0, Lcom/amap/api/mapcore/util/am;->j:F

    return v0
.end method

.method public e()F
    .locals 1

    iget v0, p0, Lcom/amap/api/mapcore/util/am;->k:F

    return v0
.end method

.method public f()F
    .locals 2

    iget v0, p0, Lcom/amap/api/mapcore/util/am;->m:F

    const/high16 v1, -0x40800000    # -1.0f

    cmpl-float v0, v0, v1

    if-nez v0, :cond_0

    iget v0, p0, Lcom/amap/api/mapcore/util/am;->h:F

    iget v1, p0, Lcom/amap/api/mapcore/util/am;->i:F

    mul-float/2addr v0, v0

    mul-float/2addr v1, v1

    add-float/2addr v0, v1

    float-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v0

    double-to-float v0, v0

    iput v0, p0, Lcom/amap/api/mapcore/util/am;->m:F

    :cond_0
    iget v0, p0, Lcom/amap/api/mapcore/util/am;->m:F

    return v0
.end method

.method public g()F
    .locals 1

    iget v0, p0, Lcom/amap/api/mapcore/util/am;->h:F

    return v0
.end method

.method public h()F
    .locals 1

    iget v0, p0, Lcom/amap/api/mapcore/util/am;->i:F

    return v0
.end method

.method public i()F
    .locals 2

    iget v0, p0, Lcom/amap/api/mapcore/util/am;->n:F

    const/high16 v1, -0x40800000    # -1.0f

    cmpl-float v0, v0, v1

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/amap/api/mapcore/util/am;->c()F

    move-result v0

    invoke-virtual {p0}, Lcom/amap/api/mapcore/util/am;->f()F

    move-result v1

    div-float/2addr v0, v1

    iput v0, p0, Lcom/amap/api/mapcore/util/am;->n:F

    :cond_0
    iget v0, p0, Lcom/amap/api/mapcore/util/am;->n:F

    return v0
.end method
