.class Lcom/amap/api/mapcore/util/de$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/amap/api/maps/model/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amap/api/mapcore/util/de;->c(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Z

.field final synthetic b:Lcom/amap/api/mapcore/util/de;


# direct methods
.method constructor <init>(Lcom/amap/api/mapcore/util/de;Z)V
    .locals 0

    iput-object p1, p0, Lcom/amap/api/mapcore/util/de$1;->b:Lcom/amap/api/mapcore/util/de;

    iput-boolean p2, p0, Lcom/amap/api/mapcore/util/de$1;->a:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd()V
    .locals 2

    iget-object v0, p0, Lcom/amap/api/mapcore/util/de$1;->b:Lcom/amap/api/mapcore/util/de;

    invoke-static {v0}, Lcom/amap/api/mapcore/util/de;->a(Lcom/amap/api/mapcore/util/de;)Lcom/amap/api/mapcore/util/di;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amap/api/mapcore/util/de$1;->b:Lcom/amap/api/mapcore/util/de;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/amap/api/mapcore/util/de;->a(Lcom/amap/api/mapcore/util/de;Z)Z

    iget-object v0, p0, Lcom/amap/api/mapcore/util/de$1;->b:Lcom/amap/api/mapcore/util/de;

    invoke-static {v0}, Lcom/amap/api/mapcore/util/de;->a(Lcom/amap/api/mapcore/util/de;)Lcom/amap/api/mapcore/util/di;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amap/api/mapcore/util/di;->d()V

    iget-object v0, p0, Lcom/amap/api/mapcore/util/de$1;->b:Lcom/amap/api/mapcore/util/de;

    iget-boolean v1, p0, Lcom/amap/api/mapcore/util/de$1;->a:Z

    invoke-static {v0, v1}, Lcom/amap/api/mapcore/util/de;->b(Lcom/amap/api/mapcore/util/de;Z)V

    :cond_0
    return-void
.end method

.method public onAnimationStart()V
    .locals 0

    return-void
.end method