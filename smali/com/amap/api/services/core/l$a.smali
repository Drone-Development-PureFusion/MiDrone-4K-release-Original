.class Lcom/amap/api/services/core/l$a;
.super Landroid/os/Handler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amap/api/services/core/l;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "a"
.end annotation


# instance fields
.field a:Ljava/lang/String;

.field final synthetic b:Lcom/amap/api/services/core/l;


# direct methods
.method public constructor <init>(Lcom/amap/api/services/core/l;Landroid/os/Looper;)V
    .locals 1

    iput-object p1, p0, Lcom/amap/api/services/core/l$a;->b:Lcom/amap/api/services/core/l;

    invoke-direct {p0, p2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    const-string v0, "handleMessage"

    iput-object v0, p0, Lcom/amap/api/services/core/l$a;->a:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 3

    if-nez p1, :cond_0

    :goto_0
    return-void

    :cond_0
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    goto :goto_0

    :pswitch_0
    :try_start_0
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Lcom/amap/api/services/core/o;

    if-nez v0, :cond_1

    new-instance v0, Lcom/amap/api/services/core/o;

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lcom/amap/api/services/core/o;-><init>(ZZ)V

    :cond_1
    invoke-static {}, Lcom/amap/api/services/core/l;->a()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amap/api/services/core/o;->a()Z

    move-result v2

    invoke-static {v2}, Lcom/amap/api/services/core/c;->a(Z)Lcom/amap/api/services/core/ad;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amap/api/services/core/ay;->a(Landroid/content/Context;Lcom/amap/api/services/core/ad;)Lcom/amap/api/services/core/ay;

    invoke-virtual {v0}, Lcom/amap/api/services/core/o;->a()Z

    move-result v0

    invoke-static {v0}, Lcom/amap/api/services/core/c;->a(Z)Lcom/amap/api/services/core/ad;

    move-result-object v0

    sput-object v0, Lcom/amap/api/services/core/l;->a:Lcom/amap/api/services/core/ad;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    const-string v1, "ManifestConfig"

    iget-object v2, p0, Lcom/amap/api/services/core/l$a;->a:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/amap/api/services/core/d;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x3
        :pswitch_0
    .end packed-switch
.end method
