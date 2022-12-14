.class public Lcom/amap/api/services/poisearch/PoiSearch;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amap/api/services/poisearch/PoiSearch$OnPoiSearchListener;,
        Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;,
        Lcom/amap/api/services/poisearch/PoiSearch$Query;
    }
.end annotation


# static fields
.field public static final CHINESE:Ljava/lang/String; = "zh-CN"

.field public static final ENGLISH:Ljava/lang/String; = "en"

.field private static i:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/amap/api/services/poisearch/PoiResult;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private a:Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;

.field private b:Lcom/amap/api/services/poisearch/PoiSearch$Query;

.field private c:Landroid/content/Context;

.field private d:Lcom/amap/api/services/poisearch/PoiSearch$OnPoiSearchListener;

.field private e:Ljava/lang/String;

.field private f:Lcom/amap/api/services/poisearch/PoiSearch$Query;

.field private g:Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;

.field private h:I

.field private j:Landroid/os/Handler;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/amap/api/services/poisearch/PoiSearch$Query;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-string v0, "zh-CN"

    iput-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->e:Ljava/lang/String;

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->j:Landroid/os/Handler;

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->c:Landroid/content/Context;

    invoke-virtual {p0, p2}, Lcom/amap/api/services/poisearch/PoiSearch;->setQuery(Lcom/amap/api/services/poisearch/PoiSearch$Query;)V

    invoke-static {}, Lcom/amap/api/services/core/p;->a()Lcom/amap/api/services/core/p;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->j:Landroid/os/Handler;

    return-void
.end method

.method static synthetic a(Lcom/amap/api/services/poisearch/PoiSearch;)Landroid/os/Handler;
    .locals 1

    iget-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->j:Landroid/os/Handler;

    return-object v0
.end method

.method private a(Lcom/amap/api/services/poisearch/PoiResult;)V
    .locals 2

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amap/api/services/poisearch/PoiSearch;->i:Ljava/util/HashMap;

    iget-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->b:Lcom/amap/api/services/poisearch/PoiSearch$Query;

    if-eqz v0, :cond_0

    if-nez p1, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->h:I

    if-lez v0, :cond_0

    iget v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->h:I

    iget-object v1, p0, Lcom/amap/api/services/poisearch/PoiSearch;->b:Lcom/amap/api/services/poisearch/PoiSearch$Query;

    invoke-virtual {v1}, Lcom/amap/api/services/poisearch/PoiSearch$Query;->getPageNum()I

    move-result v1

    if-le v0, v1, :cond_0

    sget-object v0, Lcom/amap/api/services/poisearch/PoiSearch;->i:Ljava/util/HashMap;

    iget-object v1, p0, Lcom/amap/api/services/poisearch/PoiSearch;->b:Lcom/amap/api/services/poisearch/PoiSearch$Query;

    invoke-virtual {v1}, Lcom/amap/api/services/poisearch/PoiSearch$Query;->getPageNum()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method private a()Z
    .locals 1

    iget-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->b:Lcom/amap/api/services/poisearch/PoiSearch$Query;

    invoke-static {v0}, Lcom/amap/api/services/poisearch/PoiSearch$Query;->a(Lcom/amap/api/services/poisearch/PoiSearch$Query;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amap/api/services/core/d;->a(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->b:Lcom/amap/api/services/poisearch/PoiSearch$Query;

    invoke-static {v0}, Lcom/amap/api/services/poisearch/PoiSearch$Query;->b(Lcom/amap/api/services/poisearch/PoiSearch$Query;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amap/api/services/core/d;->a(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private a(I)Z
    .locals 1

    iget v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->h:I

    if-gt p1, v0, :cond_0

    if-ltz p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method static synthetic a(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 1

    invoke-static {p0, p1}, Lcom/amap/api/services/poisearch/PoiSearch;->b(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method static synthetic b(Lcom/amap/api/services/poisearch/PoiSearch;)Lcom/amap/api/services/poisearch/PoiSearch$OnPoiSearchListener;
    .locals 1

    iget-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->d:Lcom/amap/api/services/poisearch/PoiSearch$OnPoiSearchListener;

    return-object v0
.end method

.method private b()Z
    .locals 3

    const/4 v0, 0x0

    invoke-virtual {p0}, Lcom/amap/api/services/poisearch/PoiSearch;->getBound()Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;

    move-result-object v1

    if-nez v1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    invoke-virtual {v1}, Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;->getShape()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Bound"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0
.end method

.method private static b(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 1

    if-nez p0, :cond_0

    if-nez p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    if-eqz p0, :cond_1

    if-eqz p1, :cond_1

    invoke-virtual {p0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public getBound()Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;
    .locals 1

    iget-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->a:Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;

    return-object v0
.end method

.method public getLanguage()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->e:Ljava/lang/String;

    return-object v0
.end method

.method protected getPageLocal(I)Lcom/amap/api/services/poisearch/PoiResult;
    .locals 2

    invoke-direct {p0, p1}, Lcom/amap/api/services/poisearch/PoiSearch;->a(I)Z

    move-result v0

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "page out of range"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    sget-object v0, Lcom/amap/api/services/poisearch/PoiSearch;->i:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amap/api/services/poisearch/PoiResult;

    return-object v0
.end method

.method public getQuery()Lcom/amap/api/services/poisearch/PoiSearch$Query;
    .locals 1

    iget-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->b:Lcom/amap/api/services/poisearch/PoiSearch$Query;

    return-object v0
.end method

.method public searchPOI()Lcom/amap/api/services/poisearch/PoiResult;
    .locals 5

    iget-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->c:Landroid/content/Context;

    invoke-static {v0}, Lcom/amap/api/services/core/l;->a(Landroid/content/Context;)Lcom/amap/api/services/core/l;

    invoke-direct {p0}, Lcom/amap/api/services/poisearch/PoiSearch;->b()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/amap/api/services/poisearch/PoiSearch;->a()Z

    move-result v0

    if-nez v0, :cond_0

    new-instance v0, Lcom/amap/api/services/core/AMapException;

    const-string v1, "\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException"

    invoke-direct {v0, v1}, Lcom/amap/api/services/core/AMapException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iget-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->b:Lcom/amap/api/services/poisearch/PoiSearch$Query;

    iget-object v1, p0, Lcom/amap/api/services/poisearch/PoiSearch;->e:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amap/api/services/poisearch/PoiSearch$Query;->setQueryLanguage(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->b:Lcom/amap/api/services/poisearch/PoiSearch$Query;

    iget-object v1, p0, Lcom/amap/api/services/poisearch/PoiSearch;->f:Lcom/amap/api/services/poisearch/PoiSearch$Query;

    invoke-virtual {v0, v1}, Lcom/amap/api/services/poisearch/PoiSearch$Query;->queryEquals(Lcom/amap/api/services/poisearch/PoiSearch$Query;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->a:Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;

    if-eqz v0, :cond_2

    :cond_1
    iget-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->b:Lcom/amap/api/services/poisearch/PoiSearch$Query;

    iget-object v1, p0, Lcom/amap/api/services/poisearch/PoiSearch;->f:Lcom/amap/api/services/poisearch/PoiSearch$Query;

    invoke-virtual {v0, v1}, Lcom/amap/api/services/poisearch/PoiSearch$Query;->queryEquals(Lcom/amap/api/services/poisearch/PoiSearch$Query;)Z

    move-result v0

    if-nez v0, :cond_4

    iget-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->a:Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;

    iget-object v1, p0, Lcom/amap/api/services/poisearch/PoiSearch;->g:Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;

    invoke-virtual {v0, v1}, Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_4

    :cond_2
    const/4 v0, 0x0

    iput v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->h:I

    iget-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->b:Lcom/amap/api/services/poisearch/PoiSearch$Query;

    invoke-virtual {v0}, Lcom/amap/api/services/poisearch/PoiSearch$Query;->clone()Lcom/amap/api/services/poisearch/PoiSearch$Query;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->f:Lcom/amap/api/services/poisearch/PoiSearch$Query;

    iget-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->a:Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->a:Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;

    invoke-virtual {v0}, Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;->clone()Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;

    move-result-object v0

    iput-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->g:Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;

    :cond_3
    sget-object v0, Lcom/amap/api/services/poisearch/PoiSearch;->i:Ljava/util/HashMap;

    if-eqz v0, :cond_4

    sget-object v0, Lcom/amap/api/services/poisearch/PoiSearch;->i:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    :cond_4
    const/4 v0, 0x0

    iget-object v1, p0, Lcom/amap/api/services/poisearch/PoiSearch;->a:Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;

    if-eqz v1, :cond_5

    iget-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->a:Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;

    invoke-virtual {v0}, Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;->clone()Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;

    move-result-object v0

    :cond_5
    iget v1, p0, Lcom/amap/api/services/poisearch/PoiSearch;->h:I

    if-nez v1, :cond_6

    new-instance v1, Lcom/amap/api/services/poisearch/j;

    iget-object v2, p0, Lcom/amap/api/services/poisearch/PoiSearch;->c:Landroid/content/Context;

    new-instance v3, Lcom/amap/api/services/core/s;

    iget-object v4, p0, Lcom/amap/api/services/poisearch/PoiSearch;->b:Lcom/amap/api/services/poisearch/PoiSearch$Query;

    invoke-virtual {v4}, Lcom/amap/api/services/poisearch/PoiSearch$Query;->clone()Lcom/amap/api/services/poisearch/PoiSearch$Query;

    move-result-object v4

    invoke-direct {v3, v4, v0}, Lcom/amap/api/services/core/s;-><init>(Lcom/amap/api/services/poisearch/PoiSearch$Query;Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;)V

    invoke-direct {v1, v2, v3}, Lcom/amap/api/services/poisearch/j;-><init>(Landroid/content/Context;Lcom/amap/api/services/core/s;)V

    iget-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->b:Lcom/amap/api/services/poisearch/PoiSearch$Query;

    invoke-static {v0}, Lcom/amap/api/services/poisearch/PoiSearch$Query;->c(Lcom/amap/api/services/poisearch/PoiSearch$Query;)I

    move-result v0

    invoke-virtual {v1, v0}, Lcom/amap/api/services/poisearch/j;->a(I)V

    iget-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->b:Lcom/amap/api/services/poisearch/PoiSearch$Query;

    invoke-static {v0}, Lcom/amap/api/services/poisearch/PoiSearch$Query;->d(Lcom/amap/api/services/poisearch/PoiSearch$Query;)I

    move-result v0

    invoke-virtual {v1, v0}, Lcom/amap/api/services/poisearch/j;->b(I)V

    invoke-virtual {v1}, Lcom/amap/api/services/poisearch/j;->g()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    invoke-static {v1, v0}, Lcom/amap/api/services/poisearch/PoiResult;->a(Lcom/amap/api/services/poisearch/j;Ljava/util/ArrayList;)Lcom/amap/api/services/poisearch/PoiResult;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amap/api/services/poisearch/PoiSearch;->a(Lcom/amap/api/services/poisearch/PoiResult;)V

    :goto_0
    return-object v0

    :cond_6
    iget-object v1, p0, Lcom/amap/api/services/poisearch/PoiSearch;->b:Lcom/amap/api/services/poisearch/PoiSearch$Query;

    invoke-virtual {v1}, Lcom/amap/api/services/poisearch/PoiSearch$Query;->getPageNum()I

    move-result v1

    invoke-virtual {p0, v1}, Lcom/amap/api/services/poisearch/PoiSearch;->getPageLocal(I)Lcom/amap/api/services/poisearch/PoiResult;

    move-result-object v1

    if-nez v1, :cond_7

    new-instance v1, Lcom/amap/api/services/poisearch/j;

    iget-object v2, p0, Lcom/amap/api/services/poisearch/PoiSearch;->c:Landroid/content/Context;

    new-instance v3, Lcom/amap/api/services/core/s;

    iget-object v4, p0, Lcom/amap/api/services/poisearch/PoiSearch;->b:Lcom/amap/api/services/poisearch/PoiSearch$Query;

    invoke-virtual {v4}, Lcom/amap/api/services/poisearch/PoiSearch$Query;->clone()Lcom/amap/api/services/poisearch/PoiSearch$Query;

    move-result-object v4

    invoke-direct {v3, v4, v0}, Lcom/amap/api/services/core/s;-><init>(Lcom/amap/api/services/poisearch/PoiSearch$Query;Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;)V

    invoke-direct {v1, v2, v3}, Lcom/amap/api/services/poisearch/j;-><init>(Landroid/content/Context;Lcom/amap/api/services/core/s;)V

    iget-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->b:Lcom/amap/api/services/poisearch/PoiSearch$Query;

    invoke-static {v0}, Lcom/amap/api/services/poisearch/PoiSearch$Query;->c(Lcom/amap/api/services/poisearch/PoiSearch$Query;)I

    move-result v0

    invoke-virtual {v1, v0}, Lcom/amap/api/services/poisearch/j;->a(I)V

    iget-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->b:Lcom/amap/api/services/poisearch/PoiSearch$Query;

    invoke-static {v0}, Lcom/amap/api/services/poisearch/PoiSearch$Query;->d(Lcom/amap/api/services/poisearch/PoiSearch$Query;)I

    move-result v0

    invoke-virtual {v1, v0}, Lcom/amap/api/services/poisearch/j;->b(I)V

    invoke-virtual {v1}, Lcom/amap/api/services/poisearch/j;->g()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    invoke-static {v1, v0}, Lcom/amap/api/services/poisearch/PoiResult;->a(Lcom/amap/api/services/poisearch/j;Ljava/util/ArrayList;)Lcom/amap/api/services/poisearch/PoiResult;

    move-result-object v0

    sget-object v1, Lcom/amap/api/services/poisearch/PoiSearch;->i:Ljava/util/HashMap;

    iget-object v2, p0, Lcom/amap/api/services/poisearch/PoiSearch;->b:Lcom/amap/api/services/poisearch/PoiSearch$Query;

    invoke-static {v2}, Lcom/amap/api/services/poisearch/PoiSearch$Query;->c(Lcom/amap/api/services/poisearch/PoiSearch$Query;)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    :cond_7
    move-object v0, v1

    goto :goto_0
.end method

.method public searchPOIAsyn()V
    .locals 1

    new-instance v0, Lcom/amap/api/services/poisearch/PoiSearch$1;

    invoke-direct {v0, p0}, Lcom/amap/api/services/poisearch/PoiSearch$1;-><init>(Lcom/amap/api/services/poisearch/PoiSearch;)V

    invoke-virtual {v0}, Lcom/amap/api/services/poisearch/PoiSearch$1;->start()V

    return-void
.end method

.method public searchPOIDetail(Ljava/lang/String;)Lcom/amap/api/services/poisearch/PoiItemDetail;
    .locals 3

    iget-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->c:Landroid/content/Context;

    invoke-static {v0}, Lcom/amap/api/services/core/l;->a(Landroid/content/Context;)Lcom/amap/api/services/core/l;

    new-instance v0, Lcom/amap/api/services/poisearch/i;

    iget-object v1, p0, Lcom/amap/api/services/poisearch/PoiSearch;->c:Landroid/content/Context;

    iget-object v2, p0, Lcom/amap/api/services/poisearch/PoiSearch;->e:Ljava/lang/String;

    invoke-direct {v0, v1, p1, v2}, Lcom/amap/api/services/poisearch/i;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/amap/api/services/poisearch/i;->g()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amap/api/services/poisearch/PoiItemDetail;

    return-object v0
.end method

.method public searchPOIDetailAsyn(Ljava/lang/String;)V
    .locals 1

    new-instance v0, Lcom/amap/api/services/poisearch/PoiSearch$2;

    invoke-direct {v0, p0, p1}, Lcom/amap/api/services/poisearch/PoiSearch$2;-><init>(Lcom/amap/api/services/poisearch/PoiSearch;Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/amap/api/services/poisearch/PoiSearch$2;->start()V

    return-void
.end method

.method public setBound(Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;)V
    .locals 0

    iput-object p1, p0, Lcom/amap/api/services/poisearch/PoiSearch;->a:Lcom/amap/api/services/poisearch/PoiSearch$SearchBound;

    return-void
.end method

.method public setLanguage(Ljava/lang/String;)V
    .locals 1

    const-string v0, "en"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "en"

    iput-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->e:Ljava/lang/String;

    :goto_0
    return-void

    :cond_0
    const-string v0, "zh-CN"

    iput-object v0, p0, Lcom/amap/api/services/poisearch/PoiSearch;->e:Ljava/lang/String;

    goto :goto_0
.end method

.method public setOnPoiSearchListener(Lcom/amap/api/services/poisearch/PoiSearch$OnPoiSearchListener;)V
    .locals 0

    iput-object p1, p0, Lcom/amap/api/services/poisearch/PoiSearch;->d:Lcom/amap/api/services/poisearch/PoiSearch$OnPoiSearchListener;

    return-void
.end method

.method public setQuery(Lcom/amap/api/services/poisearch/PoiSearch$Query;)V
    .locals 0

    iput-object p1, p0, Lcom/amap/api/services/poisearch/PoiSearch;->b:Lcom/amap/api/services/poisearch/PoiSearch$Query;

    return-void
.end method
