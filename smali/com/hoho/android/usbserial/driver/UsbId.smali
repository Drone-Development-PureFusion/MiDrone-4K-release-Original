.class public final Lcom/hoho/android/usbserial/driver/UsbId;
.super Ljava/lang/Object;


# static fields
.field public static final ARDUINO_LEONARDO:I = 0x8036

.field public static final ARDUINO_MEGA_2560:I = 0x10

.field public static final ARDUINO_MEGA_2560_R3:I = 0x42

.field public static final ARDUINO_MEGA_ADK:I = 0x3f

.field public static final ARDUINO_MEGA_ADK_R3:I = 0x44

.field public static final ARDUINO_SERIAL_ADAPTER:I = 0x3b

.field public static final ARDUINO_SERIAL_ADAPTER_R3:I = 0x44

.field public static final ARDUINO_UNO:I = 0x1

.field public static final ARDUINO_UNO_R3:I = 0x43

.field public static final ATMEL_LUFA_CDC_DEMO_APP:I = 0x2044

.field public static final FTDI_FT231X:I = 0x6015

.field public static final FTDI_FT232R:I = 0x6001

.field public static final LEAFLABS_MAPLE:I = 0x4

.field public static final PROLIFIC_PL2303:I = 0x2303

.field public static final SILAB_CP2102:I = 0xea60

.field public static final VAN_OOIJEN_TECH_TEENSYDUINO_SERIAL:I = 0x483

.field public static final VENDOR_ARDUINO:I = 0x2341

.field public static final VENDOR_ATMEL:I = 0x3eb

.field public static final VENDOR_FTDI:I = 0x403

.field public static final VENDOR_LEAFLABS:I = 0x1eaf

.field public static final VENDOR_PROLIFIC:I = 0x67b

.field public static final VENDOR_SILAB:I = 0x10c4

.field public static final VENDOR_VAN_OOIJEN_TECH:I = 0x16c0


# direct methods
.method private constructor <init>()V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/IllegalAccessError;

    const-string v1, "Non-instantiable class."

    invoke-direct {v0, v1}, Ljava/lang/IllegalAccessError;-><init>(Ljava/lang/String;)V

    throw v0
.end method
