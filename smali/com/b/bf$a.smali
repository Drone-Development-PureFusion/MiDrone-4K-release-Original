.class public Lcom/b/bf$a;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/b/bf;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "a"
.end annotation


# instance fields
.field final synthetic a:Lcom/b/bf;

.field private b:Lcom/autonavi/aps/amapapi/model/AmapLoc;

.field private c:Ljava/lang/String;


# direct methods
.method protected constructor <init>(Lcom/b/bf;)V
    .locals 1

    const/4 v0, 0x0

    iput-object p1, p0, Lcom/b/bf$a;->a:Lcom/b/bf;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/b/bf$a;->b:Lcom/autonavi/aps/amapapi/model/AmapLoc;

    iput-object v0, p0, Lcom/b/bf$a;->c:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public a()Lcom/autonavi/aps/amapapi/model/AmapLoc;
    .locals 1

    iget-object v0, p0, Lcom/b/bf$a;->b:Lcom/autonavi/aps/amapapi/model/AmapLoc;

    return-object v0
.end method

.method public a(Lcom/autonavi/aps/amapapi/model/AmapLoc;)V
    .locals 0

    iput-object p1, p0, Lcom/b/bf$a;->b:Lcom/autonavi/aps/amapapi/model/AmapLoc;

    return-void
.end method

.method public a(Ljava/lang/String;)V
    .locals 2

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/b/bf$a;->c:Ljava/lang/String;

    :goto_0
    return-void

    :cond_0
    const-string v0, "##"

    const-string v1, "#"

    invoke-virtual {p1, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/b/bf$a;->c:Ljava/lang/String;

    goto :goto_0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/b/bf$a;->c:Ljava/lang/String;

    return-object v0
.end method
