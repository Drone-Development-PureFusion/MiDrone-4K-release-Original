.class public Lcom/amap/api/mapcore/util/cb;
.super Lcom/amap/api/mapcore/util/bz;


# direct methods
.method public constructor <init>(ILcom/amap/api/mapcore/util/aw;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/amap/api/mapcore/util/bz;-><init>(ILcom/amap/api/mapcore/util/aw;)V

    return-void
.end method


# virtual methods
.method public c()V
    .locals 1

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cb;->b:Lcom/amap/api/mapcore/util/aw;

    invoke-virtual {v0}, Lcom/amap/api/mapcore/util/aw;->e()V

    return-void
.end method

.method public g()V
    .locals 2

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cb;->b:Lcom/amap/api/mapcore/util/aw;

    iget-object v0, v0, Lcom/amap/api/mapcore/util/aw;->g:Lcom/amap/api/mapcore/util/ca;

    invoke-virtual {p0, v0}, Lcom/amap/api/mapcore/util/cb;->b(Lcom/amap/api/mapcore/util/ca;)V

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cb;->b:Lcom/amap/api/mapcore/util/aw;

    iget-object v1, p0, Lcom/amap/api/mapcore/util/cb;->b:Lcom/amap/api/mapcore/util/aw;

    iget-object v1, v1, Lcom/amap/api/mapcore/util/aw;->g:Lcom/amap/api/mapcore/util/ca;

    invoke-virtual {v0, v1}, Lcom/amap/api/mapcore/util/aw;->a(Lcom/amap/api/mapcore/util/ca;)V

    iget-object v0, p0, Lcom/amap/api/mapcore/util/cb;->b:Lcom/amap/api/mapcore/util/aw;

    invoke-virtual {v0}, Lcom/amap/api/mapcore/util/aw;->d()V

    return-void
.end method
