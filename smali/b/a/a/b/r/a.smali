.class public final enum Lb/a/a/b/r/a;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lb/a/a/b/r/a;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lb/a/a/b/r/a;

.field public static final enum b:Lb/a/a/b/r/a;

.field public static final enum c:Lb/a/a/b/r/a;

.field public static final enum d:Lb/a/a/b/r/a;

.field public static final enum e:Lb/a/a/b/r/a;

.field private static final synthetic f:[Lb/a/a/b/r/a;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    new-instance v0, Lb/a/a/b/r/a;

    const-string v1, "NOT_FOUND"

    invoke-direct {v0, v1, v2}, Lb/a/a/b/r/a;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lb/a/a/b/r/a;->a:Lb/a/a/b/r/a;

    new-instance v0, Lb/a/a/b/r/a;

    const-string v1, "AS_BASIC_PROPERTY"

    invoke-direct {v0, v1, v3}, Lb/a/a/b/r/a;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lb/a/a/b/r/a;->b:Lb/a/a/b/r/a;

    new-instance v0, Lb/a/a/b/r/a;

    const-string v1, "AS_COMPLEX_PROPERTY"

    invoke-direct {v0, v1, v4}, Lb/a/a/b/r/a;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lb/a/a/b/r/a;->c:Lb/a/a/b/r/a;

    new-instance v0, Lb/a/a/b/r/a;

    const-string v1, "AS_BASIC_PROPERTY_COLLECTION"

    invoke-direct {v0, v1, v5}, Lb/a/a/b/r/a;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lb/a/a/b/r/a;->d:Lb/a/a/b/r/a;

    new-instance v0, Lb/a/a/b/r/a;

    const-string v1, "AS_COMPLEX_PROPERTY_COLLECTION"

    invoke-direct {v0, v1, v6}, Lb/a/a/b/r/a;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lb/a/a/b/r/a;->e:Lb/a/a/b/r/a;

    const/4 v0, 0x5

    new-array v0, v0, [Lb/a/a/b/r/a;

    sget-object v1, Lb/a/a/b/r/a;->a:Lb/a/a/b/r/a;

    aput-object v1, v0, v2

    sget-object v1, Lb/a/a/b/r/a;->b:Lb/a/a/b/r/a;

    aput-object v1, v0, v3

    sget-object v1, Lb/a/a/b/r/a;->c:Lb/a/a/b/r/a;

    aput-object v1, v0, v4

    sget-object v1, Lb/a/a/b/r/a;->d:Lb/a/a/b/r/a;

    aput-object v1, v0, v5

    sget-object v1, Lb/a/a/b/r/a;->e:Lb/a/a/b/r/a;

    aput-object v1, v0, v6

    sput-object v0, Lb/a/a/b/r/a;->f:[Lb/a/a/b/r/a;

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

.method public static valueOf(Ljava/lang/String;)Lb/a/a/b/r/a;
    .locals 1

    const-class v0, Lb/a/a/b/r/a;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lb/a/a/b/r/a;

    return-object v0
.end method

.method public static values()[Lb/a/a/b/r/a;
    .locals 1

    sget-object v0, Lb/a/a/b/r/a;->f:[Lb/a/a/b/r/a;

    invoke-virtual {v0}, [Lb/a/a/b/r/a;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lb/a/a/b/r/a;

    return-object v0
.end method
