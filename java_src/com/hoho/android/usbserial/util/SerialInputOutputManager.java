package com.hoho.android.usbserial.util;

import android.util.Log;
import com.hoho.android.usbserial.driver.UsbSerialDriver;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class SerialInputOutputManager implements Runnable {
    private static final int BUFSIZ = 4096;
    private static final boolean DEBUG = true;
    private static final int READ_WAIT_MILLIS = 200;
    private static final String TAG = SerialInputOutputManager.class.getSimpleName();
    private final UsbSerialDriver mDriver;
    private Listener mListener;
    private final ByteBuffer mReadBuffer;
    private State mState;
    private final ByteBuffer mWriteBuffer;

    /* loaded from: classes.dex */
    public interface Listener {
        void onNewData(byte[] bArr);

        void onRunError(Exception exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum State {
        STOPPED,
        RUNNING,
        STOPPING;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static State[] valuesCustom() {
            State[] valuesCustom = values();
            int length = valuesCustom.length;
            State[] stateArr = new State[length];
            System.arraycopy(valuesCustom, 0, stateArr, 0, length);
            return stateArr;
        }
    }

    public SerialInputOutputManager(UsbSerialDriver usbSerialDriver) {
        this(usbSerialDriver, null);
    }

    public SerialInputOutputManager(UsbSerialDriver usbSerialDriver, Listener listener) {
        this.mReadBuffer = ByteBuffer.allocate(4096);
        this.mWriteBuffer = ByteBuffer.allocate(4096);
        this.mState = State.STOPPED;
        this.mDriver = usbSerialDriver;
        this.mListener = listener;
    }

    private synchronized State getState() {
        return this.mState;
    }

    private void step() {
        int read = this.mDriver.read(this.mReadBuffer.array(), 200);
        if (read > 0) {
            Log.d(TAG, "Read data len=" + read);
            Listener listener = getListener();
            if (listener != null) {
                byte[] bArr = new byte[read];
                this.mReadBuffer.get(bArr, 0, read);
                listener.onNewData(bArr);
            }
            this.mReadBuffer.clear();
        }
        byte[] bArr2 = null;
        synchronized (this.mWriteBuffer) {
            if (this.mWriteBuffer.position() > 0) {
                read = this.mWriteBuffer.position();
                bArr2 = new byte[read];
                this.mWriteBuffer.rewind();
                this.mWriteBuffer.get(bArr2, 0, read);
                this.mWriteBuffer.clear();
            }
        }
        if (bArr2 != null) {
            Log.d(TAG, "Writing data len=" + read);
            this.mDriver.write(bArr2, 200);
        }
    }

    public synchronized Listener getListener() {
        return this.mListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            if (getState() != State.STOPPED) {
                throw new IllegalStateException("Already running.");
            }
            this.mState = State.RUNNING;
        }
        Log.i(TAG, "Running ..");
        while (getState() == State.RUNNING) {
            try {
                try {
                    step();
                } catch (Exception e) {
                    Log.w(TAG, "Run ending due to exception: " + e.getMessage(), e);
                    Listener listener = getListener();
                    if (listener != null) {
                        listener.onRunError(e);
                    }
                    synchronized (this) {
                        this.mState = State.STOPPED;
                        Log.i(TAG, "Stopped.");
                        return;
                    }
                }
            } catch (Throwable th) {
                synchronized (this) {
                    this.mState = State.STOPPED;
                    Log.i(TAG, "Stopped.");
                    throw th;
                }
            }
        }
        Log.i(TAG, "Stopping mState=" + getState());
        synchronized (this) {
            this.mState = State.STOPPED;
            Log.i(TAG, "Stopped.");
        }
    }

    public synchronized void setListener(Listener listener) {
        this.mListener = listener;
    }

    public synchronized void stop() {
        if (getState() == State.RUNNING) {
            Log.i(TAG, "Stop requested");
            this.mState = State.STOPPING;
        }
    }

    public void writeAsync(byte[] bArr) {
        synchronized (this.mWriteBuffer) {
            this.mWriteBuffer.put(bArr);
        }
    }
}
