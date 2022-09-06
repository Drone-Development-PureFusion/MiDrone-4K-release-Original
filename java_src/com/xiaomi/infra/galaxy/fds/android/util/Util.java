package com.xiaomi.infra.galaxy.fds.android.util;

import android.webkit.MimeTypeMap;
import com.xiaomi.infra.galaxy.fds.android.exception.GalaxyFDSClientException;
import com.xiaomi.infra.galaxy.fds.android.model.FDSObject;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public class Util {
    private static final int BUFFER_SIZE = 4096;
    private static final ThreadLocal<SimpleDateFormat> DATE_FOPMAT = new ThreadLocal<SimpleDateFormat>() { // from class: com.xiaomi.infra.galaxy.fds.android.util.Util.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat;
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0079 A[Catch: IOException -> 0x0086, TRY_LEAVE, TryCatch #1 {IOException -> 0x0086, blocks: (B:32:0x0074, B:34:0x0079), top: B:31:0x0074 }] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void downloadObjectToFile(FDSObject fDSObject, File file, boolean z) {
        ?? r1;
        File parentFile = file.getParentFile();
        if (!z && parentFile != null && (r1 = parentFile.exists()) == 0) {
            parentFile.mkdirs();
        }
        byte[] bArr = new byte[4096];
        InputStream objectContent = fDSObject.getObjectContent();
        try {
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file, z));
                while (true) {
                    try {
                        int read = objectContent.read(bArr, 0, 4096);
                        if (read == -1) {
                            try {
                                break;
                            } catch (IOException e) {
                                return;
                            }
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                    } catch (IOException e2) {
                        e = e2;
                        throw new GalaxyFDSClientException("Unable to store object[" + fDSObject.getBucketName() + "/" + fDSObject.getObjectName() + "] content to disk:" + e.getMessage(), e);
                    }
                }
                objectContent.close();
                if (bufferedOutputStream == null) {
                    return;
                }
                bufferedOutputStream.close();
            } catch (Throwable th) {
                th = th;
                try {
                    objectContent.close();
                    if (r1 != 0) {
                        r1.close();
                    }
                } catch (IOException e3) {
                }
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
        } catch (Throwable th2) {
            th = th2;
            r1 = 0;
            objectContent.close();
            if (r1 != 0) {
            }
            throw th;
        }
    }

    public static String formatDateString(Date date) {
        return DATE_FOPMAT.get().format(date);
    }

    public static String getMimeType(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf > 0 && lastIndexOf + 1 < name.length()) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(name.substring(lastIndexOf + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        return Consts.APPLICATION_OCTET_STREAM;
    }

    public static String getStackTrace(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        exc.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static Date parseDate(String str) {
        return DATE_FOPMAT.get().parse(str);
    }
}
