.class public final Lcom/xiaomi/infra/galaxy/fds/android/util/Consts;
.super Ljava/lang/Object;


# static fields
.field public static APPLICATION_OCTET_STREAM:Ljava/lang/String; = null

.field public static final ESTIMATED_OBJECT_SIZE:Ljava/lang/String; = "x-xiaomi-estimated-object-size"

.field public static final EXPIRES:Ljava/lang/String; = "Expires"

.field public static final GALAXY_ACCESS_KEY_ID:Ljava/lang/String; = "GalaxyAccessKeyId"

.field public static final SIGNATURE:Ljava/lang/String; = "Signature"

.field public static final XIAOMI_HEADER_PREFIX:Ljava/lang/String; = "x-xiaomi-"

.field public static final XIAOMI_META_HEADER_PREFIX:Ljava/lang/String; = "x-xiaomi-meta-"


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-string v0, "application/octet-stream"

    sput-object v0, Lcom/xiaomi/infra/galaxy/fds/android/util/Consts;->APPLICATION_OCTET_STREAM:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
