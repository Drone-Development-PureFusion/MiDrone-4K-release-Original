.class public Lcom/baidu/tts/g/b/a;
.super Ljava/lang/Object;


# instance fields
.field private a:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Landroid/content/Context;",
            ">;"
        }
    .end annotation
.end field

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/ref/WeakReference;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Landroid/content/Context;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/baidu/tts/g/b/a;->a:Ljava/lang/ref/WeakReference;

    return-void
.end method

.method private c()Landroid/content/Context;
    .locals 1

    iget-object v0, p0, Lcom/baidu/tts/g/b/a;->a:Ljava/lang/ref/WeakReference;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/baidu/tts/g/b/a;->a:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    goto :goto_0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/baidu/tts/g/b/a;->b:Ljava/lang/String;

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/baidu/tts/g/b/a;->c()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/baidu/android/common/util/CommonParam;->getCUID(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/baidu/tts/g/b/a;->b:Ljava/lang/String;

    :cond_0
    iget-object v0, p0, Lcom/baidu/tts/g/b/a;->b:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/baidu/tts/g/b/a;->c:Ljava/lang/String;

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/baidu/tts/g/b/a;->c()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/baidu/tts/tools/ResourceTools;->getAppFilesDirPath(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "baidu_tts_license"

    invoke-static {v0, v1}, Lcom/baidu/tts/tools/FileTools;->jointPathAndName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/baidu/tts/g/b/a;->c:Ljava/lang/String;

    :cond_0
    iget-object v0, p0, Lcom/baidu/tts/g/b/a;->c:Ljava/lang/String;

    return-object v0
.end method
