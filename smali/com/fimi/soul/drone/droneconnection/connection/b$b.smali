.class final enum Lcom/fimi/soul/drone/droneconnection/connection/b$b;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/fimi/soul/drone/droneconnection/connection/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "b"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/fimi/soul/drone/droneconnection/connection/b$b;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lcom/fimi/soul/drone/droneconnection/connection/b$b;

.field public static final enum b:Lcom/fimi/soul/drone/droneconnection/connection/b$b;

.field public static final enum c:Lcom/fimi/soul/drone/droneconnection/connection/b$b;

.field public static final enum d:Lcom/fimi/soul/drone/droneconnection/connection/b$b;

.field private static final synthetic e:[Lcom/fimi/soul/drone/droneconnection/connection/b$b;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    new-instance v0, Lcom/fimi/soul/drone/droneconnection/connection/b$b;

    const-string v1, "IDLE"

    invoke-direct {v0, v1, v2}, Lcom/fimi/soul/drone/droneconnection/connection/b$b;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/fimi/soul/drone/droneconnection/connection/b$b;->a:Lcom/fimi/soul/drone/droneconnection/connection/b$b;

    new-instance v0, Lcom/fimi/soul/drone/droneconnection/connection/b$b;

    const-string v1, "RELAYCONNECT"

    invoke-direct {v0, v1, v3}, Lcom/fimi/soul/drone/droneconnection/connection/b$b;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/fimi/soul/drone/droneconnection/connection/b$b;->b:Lcom/fimi/soul/drone/droneconnection/connection/b$b;

    new-instance v0, Lcom/fimi/soul/drone/droneconnection/connection/b$b;

    const-string v1, "HANDSHAKE"

    invoke-direct {v0, v1, v4}, Lcom/fimi/soul/drone/droneconnection/connection/b$b;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/fimi/soul/drone/droneconnection/connection/b$b;->c:Lcom/fimi/soul/drone/droneconnection/connection/b$b;

    new-instance v0, Lcom/fimi/soul/drone/droneconnection/connection/b$b;

    const-string v1, "RCCONNECTED"

    invoke-direct {v0, v1, v5}, Lcom/fimi/soul/drone/droneconnection/connection/b$b;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/fimi/soul/drone/droneconnection/connection/b$b;->d:Lcom/fimi/soul/drone/droneconnection/connection/b$b;

    const/4 v0, 0x4

    new-array v0, v0, [Lcom/fimi/soul/drone/droneconnection/connection/b$b;

    sget-object v1, Lcom/fimi/soul/drone/droneconnection/connection/b$b;->a:Lcom/fimi/soul/drone/droneconnection/connection/b$b;

    aput-object v1, v0, v2

    sget-object v1, Lcom/fimi/soul/drone/droneconnection/connection/b$b;->b:Lcom/fimi/soul/drone/droneconnection/connection/b$b;

    aput-object v1, v0, v3

    sget-object v1, Lcom/fimi/soul/drone/droneconnection/connection/b$b;->c:Lcom/fimi/soul/drone/droneconnection/connection/b$b;

    aput-object v1, v0, v4

    sget-object v1, Lcom/fimi/soul/drone/droneconnection/connection/b$b;->d:Lcom/fimi/soul/drone/droneconnection/connection/b$b;

    aput-object v1, v0, v5

    sput-object v0, Lcom/fimi/soul/drone/droneconnection/connection/b$b;->e:[Lcom/fimi/soul/drone/droneconnection/connection/b$b;

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

.method public static valueOf(Ljava/lang/String;)Lcom/fimi/soul/drone/droneconnection/connection/b$b;
    .locals 1

    const-class v0, Lcom/fimi/soul/drone/droneconnection/connection/b$b;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/fimi/soul/drone/droneconnection/connection/b$b;

    return-object v0
.end method

.method public static values()[Lcom/fimi/soul/drone/droneconnection/connection/b$b;
    .locals 1

    sget-object v0, Lcom/fimi/soul/drone/droneconnection/connection/b$b;->e:[Lcom/fimi/soul/drone/droneconnection/connection/b$b;

    invoke-virtual {v0}, [Lcom/fimi/soul/drone/droneconnection/connection/b$b;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/fimi/soul/drone/droneconnection/connection/b$b;

    return-object v0
.end method
