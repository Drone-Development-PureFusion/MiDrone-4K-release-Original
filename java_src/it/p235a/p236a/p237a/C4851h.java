package it.p235a.p236a.p237a;

import it.p235a.p236a.AbstractC4866h;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/* renamed from: it.a.a.a.h */
/* loaded from: classes2.dex */
public class C4851h extends AbstractC4866h {

    /* renamed from: d */
    private String f20712d;

    /* renamed from: e */
    private int f20713e;

    /* renamed from: f */
    private String f20714f;

    /* renamed from: g */
    private String f20715g;

    public C4851h(String str, int i) {
        this(str, i, null, null);
    }

    public C4851h(String str, int i, String str2, String str3) {
        this.f20712d = str;
        this.f20713e = i;
        this.f20714f = str2;
        this.f20715g = str3;
    }

    /* renamed from: a */
    private int m3126a(InputStream inputStream) {
        int read = inputStream.read();
        if (read < 0) {
            throw new IOException("SOCKS5Connector: connection closed by the proxy");
        }
        return read;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Socket m3125a(String str, int i, boolean z) {
        InputStream inputStream;
        Socket socket;
        OutputStream outputStream;
        Socket socket2;
        OutputStream outputStream2;
        OutputStream outputStream3 = null;
        boolean z2 = false;
        if (this.f20714f != null && this.f20715g != null) {
            z2 = true;
        }
        try {
            socket = z ? b(this.f20712d, this.f20713e) : a(this.f20712d, this.f20713e);
            try {
                inputStream = socket.getInputStream();
                try {
                    try {
                        outputStream2 = socket.getOutputStream();
                    } catch (IOException e) {
                        e = e;
                        outputStream = null;
                        outputStream3 = inputStream;
                        socket2 = socket;
                    }
                    try {
                        outputStream2.write(5);
                        if (z2) {
                            outputStream2.write(1);
                            outputStream2.write(2);
                        } else {
                            outputStream2.write(1);
                            outputStream2.write(0);
                        }
                        if (m3126a(inputStream) != 5) {
                            throw new IOException("SOCKS5Connector: invalid proxy response");
                        }
                        int m3126a = m3126a(inputStream);
                        if (z2) {
                            if (m3126a != 2) {
                                throw new IOException("SOCKS5Connector: proxy doesn't support username/password authentication method");
                            }
                            byte[] bytes = this.f20714f.getBytes("UTF-8");
                            byte[] bytes2 = this.f20715g.getBytes("UTF-8");
                            int length = bytes.length;
                            int length2 = bytes2.length;
                            if (length > 255) {
                                throw new IOException("SOCKS5Connector: username too long");
                            }
                            if (length2 > 255) {
                                throw new IOException("SOCKS5Connector: password too long");
                            }
                            outputStream2.write(1);
                            outputStream2.write(length);
                            outputStream2.write(bytes);
                            outputStream2.write(length2);
                            outputStream2.write(bytes2);
                            if (m3126a(inputStream) != 1) {
                                throw new IOException("SOCKS5Connector: invalid proxy response");
                            }
                            if (m3126a(inputStream) != 0) {
                                throw new IOException("SOCKS5Connector: authentication failed");
                            }
                        } else if (m3126a != 0) {
                            throw new IOException("SOCKS5Connector: proxy requires authentication");
                        }
                        outputStream2.write(5);
                        outputStream2.write(1);
                        outputStream2.write(0);
                        outputStream2.write(3);
                        byte[] bytes3 = str.getBytes("UTF-8");
                        if (bytes3.length > 255) {
                            throw new IOException("SOCKS5Connector: domain name too long");
                        }
                        outputStream2.write(bytes3.length);
                        outputStream2.write(bytes3);
                        outputStream2.write(i >> 8);
                        outputStream2.write(i);
                        if (m3126a(inputStream) != 5) {
                            throw new IOException("SOCKS5Connector: invalid proxy response");
                        }
                        switch (m3126a(inputStream)) {
                            case 0:
                                inputStream.skip(1L);
                                int m3126a2 = m3126a(inputStream);
                                if (m3126a2 == 1) {
                                    inputStream.skip(4L);
                                } else if (m3126a2 == 3) {
                                    inputStream.skip(m3126a(inputStream));
                                } else if (m3126a2 != 4) {
                                    throw new IOException("SOCKS5Connector: invalid proxy response");
                                } else {
                                    inputStream.skip(16L);
                                }
                                inputStream.skip(2L);
                                return socket;
                            case 1:
                                throw new IOException("SOCKS5Connector: general failure");
                            case 2:
                                throw new IOException("SOCKS5Connector: connection not allowed by ruleset");
                            case 3:
                                throw new IOException("SOCKS5Connector: network unreachable");
                            case 4:
                                throw new IOException("SOCKS5Connector: host unreachable");
                            case 5:
                                throw new IOException("SOCKS5Connector: connection refused by destination host");
                            case 6:
                                throw new IOException("SOCKS5Connector: TTL expired");
                            case 7:
                                throw new IOException("SOCKS5Connector: command not supported / protocol error");
                            case 8:
                                throw new IOException("SOCKS5Connector: address type not supported");
                            default:
                                throw new IOException("SOCKS5Connector: invalid proxy response");
                        }
                    } catch (IOException e2) {
                        e = e2;
                        outputStream = outputStream2;
                        outputStream3 = inputStream;
                        socket2 = socket;
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            socket = socket2;
                            inputStream = outputStream3;
                            outputStream3 = outputStream;
                            if (outputStream3 != null) {
                                try {
                                    outputStream3.close();
                                } catch (Throwable th2) {
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable th3) {
                                }
                            }
                            if (socket != null) {
                                try {
                                    socket.close();
                                } catch (Throwable th4) {
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    if (outputStream3 != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (socket != null) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                outputStream = null;
                socket2 = socket;
            } catch (Throwable th6) {
                th = th6;
                inputStream = null;
            }
        } catch (IOException e4) {
            e = e4;
            outputStream = null;
            socket2 = null;
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
            socket = null;
        }
    }

    @Override // it.p235a.p236a.AbstractC4866h
    /* renamed from: c */
    public Socket mo3004c(String str, int i) {
        return m3125a(str, i, false);
    }

    @Override // it.p235a.p236a.AbstractC4866h
    /* renamed from: d */
    public Socket mo3003d(String str, int i) {
        return m3125a(str, i, true);
    }
}
