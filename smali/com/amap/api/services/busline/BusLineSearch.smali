.class public Lcom/amap/api/services/busline/BusLineSearch;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amap/api/services/busline/BusLineSearch$OnBusLineSearchListener;
    }
.end annotation


# instance fields
.field private a:Landroid/content/Context;

.field private b:Lcom/amap/api/services/busline/BusLineSearch$OnBusLineSearchListener;

.field private c:Lcom/amap/api/services/busline/BusLineQuery;

.field private d:Lcom/amap/api/services/busline/BusLineQuery;

.field private e:I

.field private f:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/amap/api/services/busline/BusLineResult;",
            ">;"
        }
    .end annotation
.end field

.field private g:Landroid/os/Handler;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/amap/api/services/busline/BusLineQuery;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amap/api/services/busline/BusLineSearch;->f:Ljava/util/ArrayList;

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amap/api/services/busline/BusLineSearch;->g:Landroid/os/Handler;

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/api/services/busline/BusLineSearch;->a:Landroid/content/Context;

    iput-object p2, p0, Lcom/amap/api/services/busline/BusLineSearch;->c:Lcom/amap/api/services/busline/BusLineQuery;

    invoke-virtual {p2}, Lcom/amap/api/services/busline/BusLineQuery;->clone()Lcom/amap/api/services/busline/BusLineQuery;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/api/services/busline/BusLineSearch;->d:Lcom/amap/api/services/busline/BusLineQuery;

    invoke-static {}, Lcom/amap/api/services/core/p;->a()Lcom/amap/api/services/core/p;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/api/services/busline/BusLineSearch;->g:Landroid/os/Handler;

    return-void
.end method

.method static synthetic a(Lcom/amap/api/services/busline/BusLineSearch;)Lcom/amap/api/services/busline/BusLineSearch$OnBusLineSearchListener;
    .locals 1

    iget-object v0, p0, Lcom/amap/api/services/busline/BusLineSearch;->b:Lcom/amap/api/services/busline/BusLineSearch$OnBusLineSearchListener;

    return-object v0
.end method

.method private a(Lcom/amap/api/services/busline/BusLineResult;)V
    .locals 3

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amap/api/services/busline/BusLineSearch;->f:Ljava/util/ArrayList;

    const/4 v0, 0x0

    :goto_0
    iget v1, p0, Lcom/amap/api/services/busline/BusLineSearch;->e:I

    if-ge v0, v1, :cond_0

    iget-object v1, p0, Lcom/amap/api/services/busline/BusLineSearch;->f:Ljava/util/ArrayList;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    iget v0, p0, Lcom/amap/api/services/busline/BusLineSearch;->e:I

    if-ltz v0, :cond_1

    iget-object v0, p0, Lcom/amap/api/services/busline/BusLineSearch;->c:Lcom/amap/api/services/busline/BusLineQuery;

    invoke-virtual {v0}, Lcom/amap/api/services/busline/BusLineQuery;->getPageNumber()I

    move-result v0

    invoke-direct {p0, v0}, Lcom/amap/api/services/busline/BusLineSearch;->a(I)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amap/api/services/busline/BusLineSearch;->f:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/amap/api/services/busline/BusLineSearch;->c:Lcom/amap/api/services/busline/BusLineQuery;

    invoke-virtual {v1}, Lcom/amap/api/services/busline/BusLineQuery;->getPageNumber()I

    move-result v1

    invoke-virtual {v0, v1, p1}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    :cond_1
    return-void
.end method

.method private a(I)Z
    .locals 1

    iget v0, p0, Lcom/amap/api/services/busline/BusLineSearch;->e:I

    if-ge p1, v0, :cond_0

    if-ltz p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method static synthetic b(Lcom/amap/api/services/busline/BusLineSearch;)Landroid/os/Handler;
    .locals 1

    iget-object v0, p0, Lcom/amap/api/services/busline/BusLineSearch;->g:Landroid/os/Handler;

    return-object v0
.end method

.method private b(I)Lcom/amap/api/services/busline/BusLineResult;
    .locals 2

    invoke-direct {p0, p1}, Lcom/amap/api/services/busline/BusLineSearch;->a(I)Z

    move-result v0

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "page out of range"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iget-object v0, p0, Lcom/amap/api/services/busline/BusLineSearch;->f:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amap/api/services/busline/BusLineResult;

    return-object v0
.end method


# virtual methods
.method public getQuery()Lcom/amap/api/services/busline/BusLineQuery;
    .locals 1

    iget-object v0, p0, Lcom/amap/api/services/busline/BusLineSearch;->c:Lcom/amap/api/services/busline/BusLineQuery;

    return-object v0
.end method

.method public searchBusLine()Lcom/amap/api/services/busline/BusLineResult;
    .locals 3

    iget-object v0, p0, Lcom/amap/api/services/busline/BusLineSearch;->a:Landroid/content/Context;

    invoke-static {v0}, Lcom/amap/api/services/core/l;->a(Landroid/content/Context;)Lcom/amap/api/services/core/l;

    iget-object v0, p0, Lcom/amap/api/services/busline/BusLineSearch;->c:Lcom/amap/api/services/busline/BusLineQuery;

    iget-object v1, p0, Lcom/amap/api/services/busline/BusLineSearch;->d:Lcom/amap/api/services/busline/BusLineQuery;

    invoke-virtual {v0, v1}, Lcom/amap/api/services/busline/BusLineQuery;->weakEquals(Lcom/amap/api/services/busline/BusLineQuery;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amap/api/services/busline/BusLineSearch;->c:Lcom/amap/api/services/busline/BusLineQuery;

    invoke-virtual {v0}, Lcom/amap/api/services/busline/BusLineQuery;->clone()Lcom/amap/api/services/busline/BusLineQuery;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/api/services/busline/BusLineSearch;->d:Lcom/amap/api/services/busline/BusLineQuery;

    const/4 v0, 0x0

    iput v0, p0, Lcom/amap/api/services/busline/BusLineSearch;->e:I

    iget-object v0, p0, Lcom/amap/api/services/busline/BusLineSearch;->f:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amap/api/services/busline/BusLineSearch;->f:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    :cond_0
    iget v0, p0, Lcom/amap/api/services/busline/BusLineSearch;->e:I

    if-nez v0, :cond_2

    new-instance v1, Lcom/amap/api/services/core/b;

    iget-object v0, p0, Lcom/amap/api/services/busline/BusLineSearch;->a:Landroid/content/Context;

    iget-object v2, p0, Lcom/amap/api/services/busline/BusLineSearch;->c:Lcom/amap/api/services/busline/BusLineQuery;

    invoke-virtual {v2}, Lcom/amap/api/services/busline/BusLineQuery;->clone()Lcom/amap/api/services/busline/BusLineQuery;

    move-result-object v2

    invoke-direct {v1, v0, v2}, Lcom/amap/api/services/core/b;-><init>(Landroid/content/Context;Ljava/lang/Object;)V

    invoke-virtual {v1}, Lcom/amap/api/services/core/b;->g()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    invoke-static {v1, v0}, Lcom/amap/api/services/busline/BusLineResult;->a(Lcom/amap/api/services/core/b;Ljava/util/ArrayList;)Lcom/amap/api/services/busline/BusLineResult;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amap/api/services/busline/BusLineResult;->getPageCount()I

    move-result v1

    iput v1, p0, Lcom/amap/api/services/busline/BusLineSearch;->e:I

    invoke-direct {p0, v0}, Lcom/amap/api/services/busline/BusLineSearch;->a(Lcom/amap/api/services/busline/BusLineResult;)V

    :cond_1
    :goto_0
    return-object v0

    :cond_2
    iget-object v0, p0, Lcom/amap/api/services/busline/BusLineSearch;->c:Lcom/amap/api/services/busline/BusLineQuery;

    invoke-virtual {v0}, Lcom/amap/api/services/busline/BusLineQuery;->getPageNumber()I

    move-result v0

    invoke-direct {p0, v0}, Lcom/amap/api/services/busline/BusLineSearch;->b(I)Lcom/amap/api/services/busline/BusLineResult;

    move-result-object v0

    if-nez v0, :cond_1

    new-instance v1, Lcom/amap/api/services/core/b;

    iget-object v0, p0, Lcom/amap/api/services/busline/BusLineSearch;->a:Landroid/content/Context;

    iget-object v2, p0, Lcom/amap/api/services/busline/BusLineSearch;->c:Lcom/amap/api/services/busline/BusLineQuery;

    invoke-direct {v1, v0, v2}, Lcom/amap/api/services/core/b;-><init>(Landroid/content/Context;Ljava/lang/Object;)V

    invoke-virtual {v1}, Lcom/amap/api/services/core/b;->g()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    invoke-static {v1, v0}, Lcom/amap/api/services/busline/BusLineResult;->a(Lcom/amap/api/services/core/b;Ljava/util/ArrayList;)Lcom/amap/api/services/busline/BusLineResult;

    move-result-object v0

    iget-object v1, p0, Lcom/amap/api/services/busline/BusLineSearch;->f:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/amap/api/services/busline/BusLineSearch;->c:Lcom/amap/api/services/busline/BusLineQuery;

    invoke-virtual {v2}, Lcom/amap/api/services/busline/BusLineQuery;->getPageNumber()I

    move-result v2

    invoke-virtual {v1, v2, v0}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public searchBusLineAsyn()V
    .locals 2

    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/amap/api/services/busline/BusLineSearch$1;

    invoke-direct {v1, p0}, Lcom/amap/api/services/busline/BusLineSearch$1;-><init>(Lcom/amap/api/services/busline/BusLineSearch;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    return-void
.end method

.method public setOnBusLineSearchListener(Lcom/amap/api/services/busline/BusLineSearch$OnBusLineSearchListener;)V
    .locals 0

    iput-object p1, p0, Lcom/amap/api/services/busline/BusLineSearch;->b:Lcom/amap/api/services/busline/BusLineSearch$OnBusLineSearchListener;

    return-void
.end method

.method public setQuery(Lcom/amap/api/services/busline/BusLineQuery;)V
    .locals 1

    iget-object v0, p0, Lcom/amap/api/services/busline/BusLineSearch;->c:Lcom/amap/api/services/busline/BusLineQuery;

    invoke-virtual {v0, p1}, Lcom/amap/api/services/busline/BusLineQuery;->weakEquals(Lcom/amap/api/services/busline/BusLineQuery;)Z

    move-result v0

    if-nez v0, :cond_0

    iput-object p1, p0, Lcom/amap/api/services/busline/BusLineSearch;->c:Lcom/amap/api/services/busline/BusLineQuery;

    invoke-virtual {p1}, Lcom/amap/api/services/busline/BusLineQuery;->clone()Lcom/amap/api/services/busline/BusLineQuery;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/api/services/busline/BusLineSearch;->d:Lcom/amap/api/services/busline/BusLineQuery;

    :cond_0
    return-void
.end method
