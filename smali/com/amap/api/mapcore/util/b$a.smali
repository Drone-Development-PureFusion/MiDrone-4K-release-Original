.class abstract Lcom/amap/api/mapcore/util/b$a;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amap/api/mapcore/util/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x40a
    name = "a"
.end annotation


# instance fields
.field b:Z

.field c:Lcom/amap/api/mapcore/util/i$a;

.field d:Lcom/amap/api/mapcore/util/i$c;

.field e:Lcom/amap/api/mapcore/util/i$b;


# direct methods
.method private constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amap/api/mapcore/util/b$a;->b:Z

    return-void
.end method

.method synthetic constructor <init>(Lcom/amap/api/mapcore/util/b$1;)V
    .locals 0

    invoke-direct {p0}, Lcom/amap/api/mapcore/util/b$a;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amap/api/mapcore/util/b$a;->b:Z

    return-void
.end method
