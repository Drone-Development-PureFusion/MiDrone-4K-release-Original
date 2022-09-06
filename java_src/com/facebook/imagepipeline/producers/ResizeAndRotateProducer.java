package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteBufferOutputStream;
import com.facebook.imagepipeline.nativecode.JpegTranscoder;
import com.facebook.imagepipeline.producers.JobScheduler;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class ResizeAndRotateProducer implements Producer<EncodedImage> {
    @VisibleForTesting
    static final int DEFAULT_JPEG_QUALITY = 85;
    private static final String FRACTION_KEY = "Fraction";
    @VisibleForTesting
    static final int MAX_JPEG_SCALE_NUMERATOR = 8;
    @VisibleForTesting
    static final int MIN_TRANSFORM_INTERVAL_MS = 100;
    private static final String ORIGINAL_SIZE_KEY = "Original size";
    private static final String PRODUCER_NAME = "ResizeAndRotateProducer";
    private static final String REQUESTED_SIZE_KEY = "Requested size";
    private static final float ROUNDUP_FRACTION = 0.6666667f;
    private final Executor mExecutor;
    private final Producer<EncodedImage> mInputProducer;
    private final PooledByteBufferFactory mPooledByteBufferFactory;

    /* loaded from: classes.dex */
    private class TransformingConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        private boolean mIsCancelled = false;
        private final JobScheduler mJobScheduler;
        private final ProducerContext mProducerContext;

        public TransformingConsumer(final Consumer<EncodedImage> consumer, ProducerContext producerContext) {
            super(consumer);
            this.mProducerContext = producerContext;
            this.mJobScheduler = new JobScheduler(ResizeAndRotateProducer.this.mExecutor, new JobScheduler.JobRunnable() { // from class: com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.JobRunnable
                public void run(EncodedImage encodedImage, boolean z) {
                    TransformingConsumer.this.doTransform(encodedImage, z);
                }
            }, 100);
            this.mProducerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer.2
                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    TransformingConsumer.this.mJobScheduler.clearJob();
                    TransformingConsumer.this.mIsCancelled = true;
                    consumer.onCancellation();
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onIsIntermediateResultExpectedChanged() {
                    if (TransformingConsumer.this.mProducerContext.isIntermediateResultExpected()) {
                        TransformingConsumer.this.mJobScheduler.scheduleJob();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.io.InputStream] */
        public void doTransform(EncodedImage encodedImage, boolean z) {
            Map<String, String> map;
            InputStream inputStream = 0;
            this.mProducerContext.getListener().onProducerStart(this.mProducerContext.getId(), ResizeAndRotateProducer.PRODUCER_NAME);
            ImageRequest imageRequest = this.mProducerContext.getImageRequest();
            PooledByteBufferOutputStream mo21795newOutputStream = ResizeAndRotateProducer.this.mPooledByteBufferFactory.mo21795newOutputStream();
            try {
                try {
                    int scaleNumerator = ResizeAndRotateProducer.getScaleNumerator(imageRequest, encodedImage);
                    map = getExtraMap(encodedImage, imageRequest, scaleNumerator);
                    try {
                        JpegTranscoder.transcodeJpeg(encodedImage.getInputStream(), mo21795newOutputStream, ResizeAndRotateProducer.getRotationAngle(imageRequest, encodedImage), scaleNumerator, 85);
                        CloseableReference m13749of = CloseableReference.m13749of(mo21795newOutputStream.mo21797toByteBuffer());
                        try {
                            EncodedImage encodedImage2 = new EncodedImage(m13749of);
                            encodedImage2.setImageFormat(ImageFormat.JPEG);
                            encodedImage2.parseMetaData();
                            this.mProducerContext.getListener().onProducerFinishWithSuccess(this.mProducerContext.getId(), ResizeAndRotateProducer.PRODUCER_NAME, map);
                            getConsumer().onNewResult(encodedImage2, z);
                            EncodedImage.closeSafely(encodedImage2);
                        } finally {
                            CloseableReference.closeSafely(m13749of);
                        }
                    } catch (Exception e) {
                        e = e;
                        this.mProducerContext.getListener().onProducerFinishWithFailure(this.mProducerContext.getId(), ResizeAndRotateProducer.PRODUCER_NAME, e, map);
                        getConsumer().onFailure(e);
                    }
                } finally {
                    Closeables.closeQuietly((InputStream) inputStream);
                    mo21795newOutputStream.close();
                }
            } catch (Exception e2) {
                e = e2;
                map = inputStream;
            }
        }

        private Map<String, String> getExtraMap(EncodedImage encodedImage, ImageRequest imageRequest, int i) {
            if (!this.mProducerContext.getListener().requiresExtraMap(this.mProducerContext.getId())) {
                return null;
            }
            return ImmutableMap.m13827of(ResizeAndRotateProducer.ORIGINAL_SIZE_KEY, encodedImage.getWidth() + "x" + encodedImage.getHeight(), ResizeAndRotateProducer.REQUESTED_SIZE_KEY, imageRequest.getResizeOptions() != null ? imageRequest.getResizeOptions().width + "x" + imageRequest.getResizeOptions().height : "Unspecified", ResizeAndRotateProducer.FRACTION_KEY, i > 0 ? i + "/8" : "", "queueTime", String.valueOf(this.mJobScheduler.getQueuedTime()));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(@Nullable EncodedImage encodedImage, boolean z) {
            if (this.mIsCancelled) {
                return;
            }
            if (encodedImage == null) {
                if (!z) {
                    return;
                }
                getConsumer().onNewResult(null, true);
                return;
            }
            TriState shouldTransform = ResizeAndRotateProducer.shouldTransform(this.mProducerContext.getImageRequest(), encodedImage);
            if (!z && shouldTransform == TriState.UNSET) {
                return;
            }
            if (shouldTransform != TriState.YES) {
                getConsumer().onNewResult(encodedImage, z);
            } else if (!this.mJobScheduler.updateJob(encodedImage, z)) {
            } else {
                if (!z && !this.mProducerContext.isIntermediateResultExpected()) {
                    return;
                }
                this.mJobScheduler.scheduleJob();
            }
        }
    }

    public ResizeAndRotateProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, Producer<EncodedImage> producer) {
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        this.mPooledByteBufferFactory = (PooledByteBufferFactory) Preconditions.checkNotNull(pooledByteBufferFactory);
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
    }

    @VisibleForTesting
    static float determineResizeRatio(ResizeOptions resizeOptions, int i, int i2) {
        if (resizeOptions == null) {
            return 1.0f;
        }
        float max = Math.max(resizeOptions.width / i, resizeOptions.height / i2);
        if (i * max > 2048.0f) {
            max = 2048.0f / i;
        }
        return ((float) i2) * max > 2048.0f ? 2048.0f / i2 : max;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getRotationAngle(ImageRequest imageRequest, EncodedImage encodedImage) {
        boolean z = false;
        if (!imageRequest.getAutoRotateEnabled()) {
            return 0;
        }
        int rotationAngle = encodedImage.getRotationAngle();
        if (rotationAngle == 0 || rotationAngle == 90 || rotationAngle == 180 || rotationAngle == 270) {
            z = true;
        }
        Preconditions.checkArgument(z);
        return rotationAngle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getScaleNumerator(ImageRequest imageRequest, EncodedImage encodedImage) {
        ResizeOptions resizeOptions = imageRequest.getResizeOptions();
        if (resizeOptions == null) {
            return 8;
        }
        int rotationAngle = getRotationAngle(imageRequest, encodedImage);
        boolean z = rotationAngle == 90 || rotationAngle == 270;
        int roundNumerator = roundNumerator(determineResizeRatio(resizeOptions, z ? encodedImage.getHeight() : encodedImage.getWidth(), z ? encodedImage.getWidth() : encodedImage.getHeight()));
        if (roundNumerator > 8) {
            return 8;
        }
        if (roundNumerator >= 1) {
            return roundNumerator;
        }
        return 1;
    }

    @VisibleForTesting
    static int roundNumerator(float f) {
        return (int) (ROUNDUP_FRACTION + (8.0f * f));
    }

    private static boolean shouldResize(int i) {
        return i < 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState shouldTransform(ImageRequest imageRequest, EncodedImage encodedImage) {
        if (encodedImage == null || encodedImage.getImageFormat() == ImageFormat.UNKNOWN) {
            return TriState.UNSET;
        }
        if (encodedImage.getImageFormat() != ImageFormat.JPEG) {
            return TriState.NO;
        }
        return TriState.valueOf(getRotationAngle(imageRequest, encodedImage) != 0 || shouldResize(getScaleNumerator(imageRequest, encodedImage)));
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.mInputProducer.produceResults(new TransformingConsumer(consumer, producerContext), producerContext);
    }
}
