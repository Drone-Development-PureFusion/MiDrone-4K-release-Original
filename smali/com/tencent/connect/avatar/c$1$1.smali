.class Lcom/tencent/connect/avatar/c$1$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/tencent/connect/avatar/c$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/tencent/connect/avatar/c$1;


# direct methods
.method constructor <init>(Lcom/tencent/connect/avatar/c$1;)V
    .locals 0

    iput-object p1, p0, Lcom/tencent/connect/avatar/c$1$1;->a:Lcom/tencent/connect/avatar/c$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    iget-object v0, p0, Lcom/tencent/connect/avatar/c$1$1;->a:Lcom/tencent/connect/avatar/c$1;

    iget-object v0, v0, Lcom/tencent/connect/avatar/c$1;->a:Lcom/tencent/connect/avatar/c;

    invoke-virtual {v0}, Lcom/tencent/connect/avatar/c;->clearAnimation()V

    iget-object v0, p0, Lcom/tencent/connect/avatar/c$1$1;->a:Lcom/tencent/connect/avatar/c$1;

    iget-object v0, v0, Lcom/tencent/connect/avatar/c$1;->a:Lcom/tencent/connect/avatar/c;

    invoke-static {v0}, Lcom/tencent/connect/avatar/c;->a(Lcom/tencent/connect/avatar/c;)V

    return-void
.end method
