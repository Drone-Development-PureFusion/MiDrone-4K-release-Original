.class public Lcom/amap/api/services/core/l;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amap/api/services/core/l$a;
    }
.end annotation


# static fields
.field public static a:Lcom/amap/api/services/core/ad;

.field private static b:Lcom/amap/api/services/core/l;

.field private static c:Landroid/content/Context;


# instance fields
.field private d:Lcom/amap/api/services/core/l$a;

.field private e:Landroid/os/HandlerThread;


# direct methods
.method private constructor <init>(Landroid/content/Context;)V
    .locals 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lcom/amap/api/services/core/m;

    const-string v1, "manifestThread"

    invoke-direct {v0, p0, v1}, Lcom/amap/api/services/core/m;-><init>(Lcom/amap/api/services/core/l;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amap/api/services/core/l;->e:Landroid/os/HandlerThread;

    sput-object p1, Lcom/amap/api/services/core/l;->c:Landroid/content/Context;

    const/4 v0, 0x0

    invoke-static {v0}, Lcom/amap/api/services/core/c;->a(Z)Lcom/amap/api/services/core/ad;

    move-result-object v0

    sput-object v0, Lcom/amap/api/services/core/l;->a:Lcom/amap/api/services/core/ad;

    :try_start_0
    iget-object v0, p0, Lcom/amap/api/services/core/l;->e:Landroid/os/HandlerThread;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->start()V

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    new-instance v1, Lcom/amap/api/services/core/l$a;

    invoke-direct {v1, p0, v0}, Lcom/amap/api/services/core/l$a;-><init>(Lcom/amap/api/services/core/l;Landroid/os/Looper;)V

    iput-object v1, p0, Lcom/amap/api/services/core/l;->d:Lcom/amap/api/services/core/l$a;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "ManifestConfig"

    const-string v2, "ManifestConfig"

    invoke-static {v0, v1, v2}, Lcom/amap/api/services/core/d;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method static synthetic a()Landroid/content/Context;
    .locals 1

    sget-object v0, Lcom/amap/api/services/core/l;->c:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic a(Lcom/amap/api/services/core/l;)Lcom/amap/api/services/core/l$a;
    .locals 1

    iget-object v0, p0, Lcom/amap/api/services/core/l;->d:Lcom/amap/api/services/core/l$a;

    return-object v0
.end method

.method public static a(Landroid/content/Context;)Lcom/amap/api/services/core/l;
    .locals 1

    sget-object v0, Lcom/amap/api/services/core/l;->b:Lcom/amap/api/services/core/l;

    if-nez v0, :cond_0

    new-instance v0, Lcom/amap/api/services/core/l;

    invoke-direct {v0, p0}, Lcom/amap/api/services/core/l;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amap/api/services/core/l;->b:Lcom/amap/api/services/core/l;

    :cond_0
    sget-object v0, Lcom/amap/api/services/core/l;->b:Lcom/amap/api/services/core/l;

    return-object v0
.end method
