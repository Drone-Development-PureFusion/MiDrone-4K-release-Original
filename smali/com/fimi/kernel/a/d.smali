.class public Lcom/fimi/kernel/a/d;
.super Ljava/lang/Object;


# instance fields
.field public a:Ljava/lang/String;

.field public b:Ljava/lang/String;

.field public c:Ljava/lang/String;

.field public d:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/fimi/kernel/a/d;->a:Ljava/lang/String;

    iput-object p2, p0, Lcom/fimi/kernel/a/d;->b:Ljava/lang/String;

    iput-object p3, p0, Lcom/fimi/kernel/a/d;->c:Ljava/lang/String;

    iput-object p4, p0, Lcom/fimi/kernel/a/d;->d:Ljava/lang/String;

    return-void
.end method
