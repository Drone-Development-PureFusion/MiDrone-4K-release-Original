.class public final enum Lcom/fimi/b/b/a;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/fimi/b/b/a;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lcom/fimi/b/b/a;

.field public static final enum b:Lcom/fimi/b/b/a;

.field public static final enum c:Lcom/fimi/b/b/a;

.field public static final enum d:Lcom/fimi/b/b/a;

.field private static final synthetic e:[Lcom/fimi/b/b/a;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    new-instance v0, Lcom/fimi/b/b/a;

    const-string v1, "FIND_ONLINE_FIRMWARE"

    invoke-direct {v0, v1, v2}, Lcom/fimi/b/b/a;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/fimi/b/b/a;->a:Lcom/fimi/b/b/a;

    new-instance v0, Lcom/fimi/b/b/a;

    const-string v1, "FIND_NEW_FIRMWARE"

    invoke-direct {v0, v1, v3}, Lcom/fimi/b/b/a;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/fimi/b/b/a;->b:Lcom/fimi/b/b/a;

    new-instance v0, Lcom/fimi/b/b/a;

    const-string v1, "FLIGHT"

    invoke-direct {v0, v1, v4}, Lcom/fimi/b/b/a;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/fimi/b/b/a;->c:Lcom/fimi/b/b/a;

    new-instance v0, Lcom/fimi/b/b/a;

    const-string v1, "SETTING"

    invoke-direct {v0, v1, v5}, Lcom/fimi/b/b/a;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/fimi/b/b/a;->d:Lcom/fimi/b/b/a;

    const/4 v0, 0x4

    new-array v0, v0, [Lcom/fimi/b/b/a;

    sget-object v1, Lcom/fimi/b/b/a;->a:Lcom/fimi/b/b/a;

    aput-object v1, v0, v2

    sget-object v1, Lcom/fimi/b/b/a;->b:Lcom/fimi/b/b/a;

    aput-object v1, v0, v3

    sget-object v1, Lcom/fimi/b/b/a;->c:Lcom/fimi/b/b/a;

    aput-object v1, v0, v4

    sget-object v1, Lcom/fimi/b/b/a;->d:Lcom/fimi/b/b/a;

    aput-object v1, v0, v5

    sput-object v0, Lcom/fimi/b/b/a;->e:[Lcom/fimi/b/b/a;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/fimi/b/b/a;
    .locals 1

    const-class v0, Lcom/fimi/b/b/a;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/fimi/b/b/a;

    return-object v0
.end method

.method public static values()[Lcom/fimi/b/b/a;
    .locals 1

    sget-object v0, Lcom/fimi/b/b/a;->e:[Lcom/fimi/b/b/a;

    invoke-virtual {v0}, [Lcom/fimi/b/b/a;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/fimi/b/b/a;

    return-object v0
.end method
