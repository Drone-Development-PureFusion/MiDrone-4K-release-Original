.class Lcom/mob/tools/gui/BitmapProcessor$WorkerThread$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/mob/tools/network/RawNetworkCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/mob/tools/gui/BitmapProcessor$WorkerThread;->doTask(Lcom/mob/tools/gui/BitmapProcessor$ImageReq;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/mob/tools/gui/BitmapProcessor$WorkerThread;

.field final synthetic val$md5:Ljava/lang/String;

.field final synthetic val$req:Lcom/mob/tools/gui/BitmapProcessor$ImageReq;

.field final synthetic val$saveAsPng:Z


# direct methods
.method constructor <init>(Lcom/mob/tools/gui/BitmapProcessor$WorkerThread;Ljava/lang/String;ZLcom/mob/tools/gui/BitmapProcessor$ImageReq;)V
    .locals 0

    iput-object p1, p0, Lcom/mob/tools/gui/BitmapProcessor$WorkerThread$1;->this$0:Lcom/mob/tools/gui/BitmapProcessor$WorkerThread;

    iput-object p2, p0, Lcom/mob/tools/gui/BitmapProcessor$WorkerThread$1;->val$md5:Ljava/lang/String;

    iput-boolean p3, p0, Lcom/mob/tools/gui/BitmapProcessor$WorkerThread$1;->val$saveAsPng:Z

    iput-object p4, p0, Lcom/mob/tools/gui/BitmapProcessor$WorkerThread$1;->val$req:Lcom/mob/tools/gui/BitmapProcessor$ImageReq;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onResponse(Ljava/io/InputStream;)V
    .locals 5

    const/4 v4, 0x0

    new-instance v0, Lcom/mob/tools/gui/BitmapProcessor$PatchInputStream;

    invoke-direct {v0, p1}, Lcom/mob/tools/gui/BitmapProcessor$PatchInputStream;-><init>(Ljava/io/InputStream;)V

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/mob/tools/utils/BitmapHelper;->getBitmap(Ljava/io/InputStream;I)Landroid/graphics/Bitmap;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->isRecycled()Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    iget-object v0, p0, Lcom/mob/tools/gui/BitmapProcessor$WorkerThread$1;->this$0:Lcom/mob/tools/gui/BitmapProcessor$WorkerThread;

    invoke-static {v0, v4}, Lcom/mob/tools/gui/BitmapProcessor$WorkerThread;->access$1302(Lcom/mob/tools/gui/BitmapProcessor$WorkerThread;Lcom/mob/tools/gui/BitmapProcessor$ImageReq;)Lcom/mob/tools/gui/BitmapProcessor$ImageReq;

    :goto_0
    return-void

    :cond_1
    if-eqz v0, :cond_3

    invoke-static {}, Lcom/mob/tools/gui/BitmapProcessor;->access$1100()Ljava/io/File;

    move-result-object v1

    if-eqz v1, :cond_2

    new-instance v1, Ljava/io/File;

    invoke-static {}, Lcom/mob/tools/gui/BitmapProcessor;->access$1100()Ljava/io/File;

    move-result-object v2

    iget-object v3, p0, Lcom/mob/tools/gui/BitmapProcessor$WorkerThread$1;->val$md5:Ljava/lang/String;

    invoke-direct {v1, v2, v3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iget-object v2, p0, Lcom/mob/tools/gui/BitmapProcessor$WorkerThread$1;->this$0:Lcom/mob/tools/gui/BitmapProcessor$WorkerThread;

    iget-boolean v3, p0, Lcom/mob/tools/gui/BitmapProcessor$WorkerThread$1;->val$saveAsPng:Z

    invoke-static {v2, v0, v1, v3}, Lcom/mob/tools/gui/BitmapProcessor$WorkerThread;->access$1400(Lcom/mob/tools/gui/BitmapProcessor$WorkerThread;Landroid/graphics/Bitmap;Ljava/io/File;Z)V

    :cond_2
    invoke-static {}, Lcom/mob/tools/gui/BitmapProcessor;->access$600()Lcom/mob/tools/gui/CachePool;

    move-result-object v1

    iget-object v2, p0, Lcom/mob/tools/gui/BitmapProcessor$WorkerThread$1;->val$req:Lcom/mob/tools/gui/BitmapProcessor$ImageReq;

    invoke-static {v2}, Lcom/mob/tools/gui/BitmapProcessor$ImageReq;->access$000(Lcom/mob/tools/gui/BitmapProcessor$ImageReq;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lcom/mob/tools/gui/CachePool;->put(Ljava/lang/Object;Ljava/lang/Object;)Z

    iget-object v1, p0, Lcom/mob/tools/gui/BitmapProcessor$WorkerThread$1;->val$req:Lcom/mob/tools/gui/BitmapProcessor$ImageReq;

    invoke-static {v1, v0}, Lcom/mob/tools/gui/BitmapProcessor$ImageReq;->access$1000(Lcom/mob/tools/gui/BitmapProcessor$ImageReq;Landroid/graphics/Bitmap;)V

    :cond_3
    iget-object v0, p0, Lcom/mob/tools/gui/BitmapProcessor$WorkerThread$1;->this$0:Lcom/mob/tools/gui/BitmapProcessor$WorkerThread;

    invoke-static {v0, v4}, Lcom/mob/tools/gui/BitmapProcessor$WorkerThread;->access$1302(Lcom/mob/tools/gui/BitmapProcessor$WorkerThread;Lcom/mob/tools/gui/BitmapProcessor$ImageReq;)Lcom/mob/tools/gui/BitmapProcessor$ImageReq;

    goto :goto_0
.end method
