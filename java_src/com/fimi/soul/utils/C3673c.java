package com.fimi.soul.utils;

import android.content.Context;
import android.widget.ImageView;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.entity.WifiDistanceFile;
import com.fimi.soul.service.CameraSocketService;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashMap;
import org.codehaus.jackson.smile.SmileConstants;
import p004b.p005a.p006a.p028b.p051m.p052a.C0477f;
/* renamed from: com.fimi.soul.utils.c */
/* loaded from: classes.dex */
public class C3673c {

    /* renamed from: a */
    public static final int f14892a = 58880;

    /* renamed from: b */
    public static final int f14893b = 58885;

    /* renamed from: c */
    public static final int f14894c = 58887;

    /* renamed from: d */
    public static Object f14895d = new Object();

    /* renamed from: a */
    public static int m7501a(byte[] bArr, int i) {
        return (bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) | ((bArr[i + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8);
    }

    /* renamed from: a */
    public static WifiDistanceFile m7506a(File file) {
        String replace;
        if (file.exists()) {
            HashMap hashMap = new HashMap();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                String str = "/media";
                WifiDistanceFile wifiDistanceFile = new WifiDistanceFile(str);
                wifiDistanceFile.setType(0);
                wifiDistanceFile.setParentStrDir("/");
                hashMap.put(str, wifiDistanceFile);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        return wifiDistanceFile;
                    }
                    C2353b.m12509a("line=" + readLine, C3673c.class);
                    String[] m7505a = m7505a(readLine);
                    if (m7505a.length <= 1 || readLine.startsWith("/")) {
                        replace = "/media/:".equalsIgnoreCase(readLine) ? "/media" : readLine.replace(":", "");
                    } else {
                        WifiDistanceFile wifiDistanceFile2 = new WifiDistanceFile(m7505a[2]);
                        wifiDistanceFile2.setSize(Long.parseLong(m7505a[1]));
                        wifiDistanceFile2.setParentStrDir(str);
                        if (m7505a[0].startsWith(C0477f.f1054a)) {
                            wifiDistanceFile.setType(0);
                            hashMap.put(str + "/" + m7505a[2], wifiDistanceFile2);
                        } else {
                            wifiDistanceFile.setType(0);
                        }
                        WifiDistanceFile wifiDistanceFile3 = (WifiDistanceFile) hashMap.get(str);
                        if (wifiDistanceFile3 != null) {
                            wifiDistanceFile3.addFile(wifiDistanceFile2);
                            wifiDistanceFile2.setParentDir(wifiDistanceFile3);
                        } else {
                            wifiDistanceFile2.setParentDir(null);
                        }
                        replace = str;
                    }
                    str = replace;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: a */
    public static void m7509a(Context context, String str, ImageView imageView) {
        if (C3658ar.m7605a(str, context.getResources().getStringArray(C2300R.array.fileEndingImage))) {
            imageView.setImageResource(C2300R.C2301drawable.file_icon_picture);
        } else if (C3658ar.m7605a(str, context.getResources().getStringArray(C2300R.array.fileEndingAudio))) {
            imageView.setImageResource(C2300R.C2301drawable.file_icon_mp3);
        } else if (C3658ar.m7605a(str, context.getResources().getStringArray(C2300R.array.fileEndingVideo))) {
            imageView.setImageResource(C2300R.C2301drawable.file_icon_video);
        } else {
            imageView.setImageResource(C2300R.C2301drawable.file);
        }
    }

    /* renamed from: a */
    public static void m7508a(DataOutputStream dataOutputStream, String str) {
        m7507a(dataOutputStream, str.getBytes());
    }

    /* renamed from: a */
    public static void m7507a(DataOutputStream dataOutputStream, byte[] bArr) {
        synchronized (f14895d) {
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.write(bArr);
                    dataOutputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m7504a(String str, long j, DataInputStream dataInputStream, CameraSocketService cameraSocketService, boolean z) {
        C2353b.m12509a("localFile=" + str + "fileLenth=" + j, C3673c.class);
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        byte[] bArr = new byte[8192];
        long j2 = 0;
        long currentTimeMillis = System.currentTimeMillis();
        cameraSocketService.m7875a(4, z, "0");
        while (true) {
            int read = dataInputStream.read(bArr);
            if (read < 0) {
                break;
            }
            fileOutputStream.write(bArr, 0, read);
            fileOutputStream.flush();
            j2 += read;
            long j3 = (100 * j2) / j;
            if (j2 >= j) {
                cameraSocketService.m7875a(4, z, "100");
                break;
            } else if (System.currentTimeMillis() - currentTimeMillis > 2000 && cameraSocketService != null) {
                currentTimeMillis = System.currentTimeMillis();
                cameraSocketService.m7875a(4, z, j3 + "");
            }
        }
        fileOutputStream.close();
        C2353b.m12509a("receiveFileName readlen" + j2, CameraSocketService.class);
    }

    /* renamed from: a */
    public static void m7502a(byte[] bArr) {
        MulticastSocket multicastSocket;
        try {
            multicastSocket = new MulticastSocket();
        } catch (IOException e) {
            e.printStackTrace();
            multicastSocket = null;
        }
        try {
            InetAddress byName = InetAddress.getByName("224.0.0.1");
            if (!byName.isMulticastAddress()) {
                return;
            }
            DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length, byName, (int) f14892a);
            if (multicastSocket == null) {
                return;
            }
            try {
                multicastSocket.send(datagramPacket);
                multicastSocket.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (UnknownHostException e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: a */
    private static String[] m7505a(String str) {
        String[] strArr = new String[3];
        String[] split = str.split(" ");
        if (split.length > 9) {
            String str2 = "";
            int i = 0;
            for (int i2 = 0; i2 < split.length; i2++) {
                if (!"".equalsIgnoreCase(split[i2])) {
                    i++;
                    if (i == 1) {
                        strArr[0] = split[i2];
                    } else if (i == 5) {
                        strArr[1] = split[i2];
                    } else if (i >= 9) {
                        str2 = "".equalsIgnoreCase(str2) ? str2 + split[i2] : str2 + " " + split[i2];
                    }
                }
            }
            strArr[2] = str2;
            return strArr;
        }
        return split;
    }

    /* renamed from: b */
    public static int m7500b(byte[] bArr, int i) {
        return (bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) | ((bArr[i + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | ((bArr[i + 2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 16) | ((bArr[i + 3] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 24);
    }

    /* renamed from: a */
    public void m7503a(String str, String str2, int i) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket((int) f14893b);
            InetAddress byName = InetAddress.getByName(str2);
            byte[] bytes = str.getBytes();
            datagramSocket.send(new DatagramPacket(bytes, bytes.length, byName, i));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }
}
