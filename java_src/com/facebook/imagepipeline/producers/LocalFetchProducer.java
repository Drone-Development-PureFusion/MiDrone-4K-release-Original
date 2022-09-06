package com.facebook.imagepipeline.producers;

import android.os.Build;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public abstract class LocalFetchProducer implements Producer<EncodedImage> {
    private final boolean mDecodeFileDescriptorEnabledForKitKat;
    private final Executor mExecutor;
    private final PooledByteBufferFactory mPooledByteBufferFactory;

    /* JADX INFO: Access modifiers changed from: protected */
    public LocalFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, boolean z) {
        this.mExecutor = executor;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mDecodeFileDescriptorEnabledForKitKat = z && Build.VERSION.SDK_INT == 19;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public EncodedImage getByteBufferBackedEncodedImage(InputStream inputStream, int i) {
        CloseableReference closeableReference = null;
        try {
            closeableReference = i < 0 ? CloseableReference.m13749of(this.mPooledByteBufferFactory.mo21792newByteBuffer(inputStream)) : CloseableReference.m13749of(this.mPooledByteBufferFactory.mo21793newByteBuffer(inputStream, i));
            return new EncodedImage(closeableReference);
        } finally {
            Closeables.closeQuietly(inputStream);
            CloseableReference.closeSafely(closeableReference);
        }
    }

    protected abstract EncodedImage getEncodedImage(ImageRequest imageRequest);

    /* JADX INFO: Access modifiers changed from: protected */
    public EncodedImage getEncodedImage(InputStream inputStream, int i) {
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        return (!this.mDecodeFileDescriptorEnabledForKitKat || !(inputStream instanceof FileInputStream) || maxMemory < Math.min(maxMemory - (runtime.totalMemory() - runtime.freeMemory()), 8388608L) * 64) ? getByteBufferBackedEncodedImage(inputStream, i) : getInputStreamBackedEncodedImage(new File(inputStream.toString()), i);
    }

    protected EncodedImage getInputStreamBackedEncodedImage(final File file, int i) {
        return new EncodedImage(new Supplier<FileInputStream>() { // from class: com.facebook.imagepipeline.producers.LocalFetchProducer.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            /* renamed from: get */
            public FileInputStream mo21803get() {
                try {
                    return new FileInputStream(file);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }, i);
    }

    protected abstract String getProducerName();

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        ProducerListener listener = producerContext.getListener();
        String id = producerContext.getId();
        final ImageRequest imageRequest = producerContext.getImageRequest();
        final StatefulProducerRunnable<EncodedImage> statefulProducerRunnable = new StatefulProducerRunnable<EncodedImage>(consumer, listener, getProducerName(), id) { // from class: com.facebook.imagepipeline.producers.LocalFetchProducer.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void disposeResult(EncodedImage encodedImage) {
                EncodedImage.closeSafely(encodedImage);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.executors.StatefulRunnable
            /* renamed from: getResult */
            public EncodedImage mo21805getResult() {
                EncodedImage encodedImage = LocalFetchProducer.this.getEncodedImage(imageRequest);
                if (encodedImage == null) {
                    return null;
                }
                encodedImage.parseMetaData();
                return encodedImage;
            }
        };
        producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.LocalFetchProducer.2
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                statefulProducerRunnable.cancel();
            }
        });
        this.mExecutor.execute(statefulProducerRunnable);
    }
}
