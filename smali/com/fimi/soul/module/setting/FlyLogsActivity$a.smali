.class Lcom/fimi/soul/module/setting/FlyLogsActivity$a;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/fimi/soul/module/setting/FlyLogsActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "a"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcom/fimi/soul/module/setting/f;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/fimi/soul/module/setting/FlyLogsActivity;


# direct methods
.method constructor <init>(Lcom/fimi/soul/module/setting/FlyLogsActivity;)V
    .locals 0

    iput-object p1, p0, Lcom/fimi/soul/module/setting/FlyLogsActivity$a;->a:Lcom/fimi/soul/module/setting/FlyLogsActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/fimi/soul/module/setting/f;Lcom/fimi/soul/module/setting/f;)I
    .locals 4

    invoke-virtual {p2}, Lcom/fimi/soul/module/setting/f;->y()J

    move-result-wide v0

    invoke-virtual {p1}, Lcom/fimi/soul/module/setting/f;->y()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    invoke-virtual {p1}, Lcom/fimi/soul/module/setting/f;->y()J

    move-result-wide v0

    invoke-virtual {p2}, Lcom/fimi/soul/module/setting/f;->y()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-nez v0, :cond_1

    const/4 v0, 0x0

    goto :goto_0

    :cond_1
    const/4 v0, -0x1

    goto :goto_0
.end method

.method public synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    check-cast p1, Lcom/fimi/soul/module/setting/f;

    check-cast p2, Lcom/fimi/soul/module/setting/f;

    invoke-virtual {p0, p1, p2}, Lcom/fimi/soul/module/setting/FlyLogsActivity$a;->a(Lcom/fimi/soul/module/setting/f;Lcom/fimi/soul/module/setting/f;)I

    move-result v0

    return v0
.end method
