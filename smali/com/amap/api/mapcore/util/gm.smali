.class Lcom/amap/api/mapcore/util/gm;
.super Lcom/amap/api/mapcore/util/hd;


# instance fields
.field private a:Lcom/amap/api/mapcore/util/gi;


# direct methods
.method constructor <init>(Lcom/amap/api/mapcore/util/gi;)V
    .locals 0

    invoke-direct {p0}, Lcom/amap/api/mapcore/util/hd;-><init>()V

    iput-object p1, p0, Lcom/amap/api/mapcore/util/gm;->a:Lcom/amap/api/mapcore/util/gi;

    return-void
.end method


# virtual methods
.method public a()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x0

    return-object v0
.end method

.method public b()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x0

    return-object v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/amap/api/mapcore/util/gm;->a:Lcom/amap/api/mapcore/util/gi;

    invoke-virtual {v0}, Lcom/amap/api/mapcore/util/gi;->a()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
