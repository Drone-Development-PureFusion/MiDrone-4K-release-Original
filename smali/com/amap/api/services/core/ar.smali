.class public Lcom/amap/api/services/core/ar;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/amap/api/services/core/ap;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amap/api/services/core/ap",
        "<",
        "Lcom/amap/api/services/core/as;",
        ">;"
    }
.end annotation


# static fields
.field private static final b:Ljava/lang/String;

.field private static final c:Ljava/lang/String;

.field private static final d:Ljava/lang/String;


# instance fields
.field private a:Lcom/amap/api/services/core/as;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    sget-object v0, Lcom/amap/api/services/core/ah;->o:Ljava/lang/String;

    sput-object v0, Lcom/amap/api/services/core/ar;->b:Ljava/lang/String;

    sget-object v0, Lcom/amap/api/services/core/ah;->p:Ljava/lang/String;

    sput-object v0, Lcom/amap/api/services/core/ar;->c:Ljava/lang/String;

    sget-object v0, Lcom/amap/api/services/core/ah;->q:Ljava/lang/String;

    sput-object v0, Lcom/amap/api/services/core/ar;->d:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amap/api/services/core/ar;->a:Lcom/amap/api/services/core/as;

    return-void
.end method


# virtual methods
.method public a(Landroid/database/Cursor;)Lcom/amap/api/services/core/as;
    .locals 8

    const/4 v0, 0x0

    const/4 v2, 0x1

    const/4 v1, 0x0

    const/4 v3, 0x1

    :try_start_0
    invoke-interface {p1, v3}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    const/4 v4, 0x2

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    const/4 v4, 0x3

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v6

    if-nez v3, :cond_1

    move v4, v0

    :goto_0
    if-nez v5, :cond_2

    move v3, v0

    :goto_1
    if-nez v6, :cond_0

    move v2, v0

    :cond_0
    new-instance v0, Lcom/amap/api/services/core/as;

    invoke-direct {v0}, Lcom/amap/api/services/core/as;-><init>()V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    :try_start_1
    invoke-virtual {v0, v4}, Lcom/amap/api/services/core/as;->a(Z)V

    invoke-virtual {v0, v2}, Lcom/amap/api/services/core/as;->c(Z)V

    invoke-virtual {v0, v3}, Lcom/amap/api/services/core/as;->b(Z)V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_1

    :goto_2
    return-object v0

    :cond_1
    move v4, v2

    goto :goto_0

    :cond_2
    move v3, v2

    goto :goto_1

    :catch_0
    move-exception v0

    move-object v7, v0

    move-object v0, v1

    move-object v1, v7

    :goto_3
    invoke-virtual {v1}, Ljava/lang/Throwable;->printStackTrace()V

    goto :goto_2

    :catch_1
    move-exception v1

    goto :goto_3
.end method

.method public a()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcom/amap/api/services/core/ah;->e:Ljava/lang/String;

    return-object v0
.end method

.method public a(Lcom/amap/api/services/core/as;)V
    .locals 0

    iput-object p1, p0, Lcom/amap/api/services/core/ar;->a:Lcom/amap/api/services/core/as;

    return-void
.end method

.method public bridge synthetic a(Ljava/lang/Object;)V
    .locals 0

    check-cast p1, Lcom/amap/api/services/core/as;

    invoke-virtual {p0, p1}, Lcom/amap/api/services/core/ar;->a(Lcom/amap/api/services/core/as;)V

    return-void
.end method

.method public b()Landroid/content/ContentValues;
    .locals 4

    const/4 v0, 0x0

    :try_start_0
    iget-object v1, p0, Lcom/amap/api/services/core/ar;->a:Lcom/amap/api/services/core/as;

    if-nez v1, :cond_0

    :goto_0
    return-object v0

    :cond_0
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    :try_start_1
    sget-object v0, Lcom/amap/api/services/core/ar;->b:Ljava/lang/String;

    iget-object v2, p0, Lcom/amap/api/services/core/ar;->a:Lcom/amap/api/services/core/as;

    invoke-virtual {v2}, Lcom/amap/api/services/core/as;->a()Z

    move-result v2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    sget-object v0, Lcom/amap/api/services/core/ar;->c:Ljava/lang/String;

    iget-object v2, p0, Lcom/amap/api/services/core/ar;->a:Lcom/amap/api/services/core/as;

    invoke-virtual {v2}, Lcom/amap/api/services/core/as;->b()Z

    move-result v2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    sget-object v0, Lcom/amap/api/services/core/ar;->d:Ljava/lang/String;

    iget-object v2, p0, Lcom/amap/api/services/core/ar;->a:Lcom/amap/api/services/core/as;

    invoke-virtual {v2}, Lcom/amap/api/services/core/as;->c()Z

    move-result v2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_1

    move-object v0, v1

    goto :goto_0

    :catch_0
    move-exception v1

    :goto_1
    invoke-virtual {v1}, Ljava/lang/Throwable;->printStackTrace()V

    goto :goto_0

    :catch_1
    move-exception v0

    move-object v3, v0

    move-object v0, v1

    move-object v1, v3

    goto :goto_1
.end method

.method public synthetic b(Landroid/database/Cursor;)Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/amap/api/services/core/ar;->a(Landroid/database/Cursor;)Lcom/amap/api/services/core/as;

    move-result-object v0

    return-object v0
.end method
