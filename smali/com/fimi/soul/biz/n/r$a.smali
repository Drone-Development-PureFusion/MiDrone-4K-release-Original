.class Lcom/fimi/soul/biz/n/r$a;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/fimi/soul/biz/n/r;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "a"
.end annotation


# instance fields
.field final synthetic a:Lcom/fimi/soul/biz/n/r;

.field private b:I

.field private c:Ljava/lang/String;

.field private d:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/fimi/soul/biz/n/r;ILjava/lang/String;Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/fimi/soul/biz/n/r$a;->a:Lcom/fimi/soul/biz/n/r;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p2, p0, Lcom/fimi/soul/biz/n/r$a;->b:I

    iput-object p3, p0, Lcom/fimi/soul/biz/n/r$a;->c:Ljava/lang/String;

    iput-object p4, p0, Lcom/fimi/soul/biz/n/r$a;->d:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    iget-object v0, p0, Lcom/fimi/soul/biz/n/r$a;->a:Lcom/fimi/soul/biz/n/r;

    invoke-static {v0}, Lcom/fimi/soul/biz/n/r;->a(Lcom/fimi/soul/biz/n/r;)Landroid/os/Handler;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Handler;->obtainMessage()Landroid/os/Message;

    move-result-object v1

    const/4 v0, 0x0

    iget v2, p0, Lcom/fimi/soul/biz/n/r$a;->b:I

    if-nez v2, :cond_0

    iget-object v0, p0, Lcom/fimi/soul/biz/n/r$a;->a:Lcom/fimi/soul/biz/n/r;

    invoke-static {v0}, Lcom/fimi/soul/biz/n/r;->c(Lcom/fimi/soul/biz/n/r;)Lcom/fimi/soul/biz/k/o;

    move-result-object v0

    iget-object v2, p0, Lcom/fimi/soul/biz/n/r$a;->c:Ljava/lang/String;

    iget-object v3, p0, Lcom/fimi/soul/biz/n/r$a;->d:Ljava/lang/String;

    iget-object v4, p0, Lcom/fimi/soul/biz/n/r$a;->a:Lcom/fimi/soul/biz/n/r;

    invoke-static {v4}, Lcom/fimi/soul/biz/n/r;->b(Lcom/fimi/soul/biz/n/r;)Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v0, v2, v3, v4}, Lcom/fimi/soul/biz/k/o;->a(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)Lcom/fimi/soul/entity/PlaneMsg;

    move-result-object v0

    :cond_0
    iget v2, p0, Lcom/fimi/soul/biz/n/r$a;->b:I

    const/4 v3, 0x1

    if-ne v2, v3, :cond_1

    iget-object v0, p0, Lcom/fimi/soul/biz/n/r$a;->a:Lcom/fimi/soul/biz/n/r;

    invoke-static {v0}, Lcom/fimi/soul/biz/n/r;->c(Lcom/fimi/soul/biz/n/r;)Lcom/fimi/soul/biz/k/o;

    move-result-object v0

    iget-object v2, p0, Lcom/fimi/soul/biz/n/r$a;->a:Lcom/fimi/soul/biz/n/r;

    invoke-static {v2}, Lcom/fimi/soul/biz/n/r;->b(Lcom/fimi/soul/biz/n/r;)Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/fimi/soul/biz/k/o;->a(Landroid/content/Context;)Lcom/fimi/soul/entity/PlaneMsg;

    move-result-object v0

    :cond_1
    iget v2, p0, Lcom/fimi/soul/biz/n/r$a;->b:I

    iput v2, v1, Landroid/os/Message;->what:I

    iput-object v0, v1, Landroid/os/Message;->obj:Ljava/lang/Object;

    iget-object v0, p0, Lcom/fimi/soul/biz/n/r$a;->a:Lcom/fimi/soul/biz/n/r;

    invoke-static {v0}, Lcom/fimi/soul/biz/n/r;->a(Lcom/fimi/soul/biz/n/r;)Landroid/os/Handler;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    return-void
.end method
