package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessorRunner;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes.dex */
public class PostprocessorProducer implements Producer<CloseableReference<CloseableImage>> {
    @VisibleForTesting
    static final String NAME = "PostprocessorProducer";
    @VisibleForTesting
    static final String POSTPROCESSOR = "Postprocessor";
    private final PlatformBitmapFactory mBitmapFactory;
    private final Executor mExecutor;
    private final Producer<CloseableReference<CloseableImage>> mInputProducer;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean mIsClosed;
        private final ProducerListener mListener;
        private final Postprocessor mPostprocessor;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private CloseableReference<CloseableImage> mSourceImageRef = null;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean mIsLast = false;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean mIsDirty = false;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean mIsPostProcessingRunning = false;

        public PostprocessorConsumer(Consumer<CloseableReference<CloseableImage>> consumer, ProducerListener producerListener, String str, Postprocessor postprocessor, ProducerContext producerContext) {
            super(consumer);
            this.mListener = producerListener;
            this.mRequestId = str;
            this.mPostprocessor = postprocessor;
            producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.1
                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    PostprocessorConsumer.this.maybeNotifyOnCancellation();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRunningAndStartIfDirty() {
            boolean runningIfDirtyAndNotRunning;
            synchronized (this) {
                this.mIsPostProcessingRunning = false;
                runningIfDirtyAndNotRunning = setRunningIfDirtyAndNotRunning();
            }
            if (runningIfDirtyAndNotRunning) {
                submitPostprocessing();
            }
        }

        private boolean close() {
            boolean z = true;
            synchronized (this) {
                if (this.mIsClosed) {
                    z = false;
                } else {
                    CloseableReference<CloseableImage> closeableReference = this.mSourceImageRef;
                    this.mSourceImageRef = null;
                    this.mIsClosed = true;
                    CloseableReference.closeSafely(closeableReference);
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void doPostprocessing(CloseableReference<CloseableImage> closeableReference, boolean z) {
            Preconditions.checkArgument(CloseableReference.isValid(closeableReference));
            if (!shouldPostprocess(closeableReference.get())) {
                maybeNotifyOnNewResult(closeableReference, z);
                return;
            }
            this.mListener.onProducerStart(this.mRequestId, PostprocessorProducer.NAME);
            CloseableReference<CloseableImage> closeableReference2 = null;
            try {
                closeableReference2 = postprocessInternal(closeableReference.get());
                this.mListener.onProducerFinishWithSuccess(this.mRequestId, PostprocessorProducer.NAME, getExtraMap(this.mListener, this.mRequestId, this.mPostprocessor));
                maybeNotifyOnNewResult(closeableReference2, z);
            } catch (Exception e) {
                this.mListener.onProducerFinishWithFailure(this.mRequestId, PostprocessorProducer.NAME, e, getExtraMap(this.mListener, this.mRequestId, this.mPostprocessor));
                maybeNotifyOnFailure(e);
            } finally {
                CloseableReference.closeSafely(closeableReference2);
            }
        }

        private Map<String, String> getExtraMap(ProducerListener producerListener, String str, Postprocessor postprocessor) {
            if (!producerListener.requiresExtraMap(str)) {
                return null;
            }
            return ImmutableMap.m13830of(PostprocessorProducer.POSTPROCESSOR, postprocessor.getName());
        }

        private synchronized boolean isClosed() {
            return this.mIsClosed;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void maybeNotifyOnCancellation() {
            if (close()) {
                getConsumer().onCancellation();
            }
        }

        private void maybeNotifyOnFailure(Throwable th) {
            if (close()) {
                getConsumer().onFailure(th);
            }
        }

        private void maybeNotifyOnNewResult(CloseableReference<CloseableImage> closeableReference, boolean z) {
            if ((z || isClosed()) && (!z || !close())) {
                return;
            }
            getConsumer().onNewResult(closeableReference, z);
        }

        private CloseableReference<CloseableImage> postprocessInternal(CloseableImage closeableImage) {
            CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableImage;
            CloseableReference<Bitmap> process = this.mPostprocessor.process(closeableStaticBitmap.getUnderlyingBitmap(), PostprocessorProducer.this.mBitmapFactory);
            try {
                return CloseableReference.m13749of(new CloseableStaticBitmap(process, closeableImage.getQualityInfo(), closeableStaticBitmap.getRotationAngle()));
            } finally {
                CloseableReference.closeSafely(process);
            }
        }

        private synchronized boolean setRunningIfDirtyAndNotRunning() {
            boolean z = true;
            synchronized (this) {
                if (this.mIsClosed || !this.mIsDirty || this.mIsPostProcessingRunning || !CloseableReference.isValid(this.mSourceImageRef)) {
                    z = false;
                } else {
                    this.mIsPostProcessingRunning = true;
                }
            }
            return z;
        }

        private boolean shouldPostprocess(CloseableImage closeableImage) {
            return closeableImage instanceof CloseableStaticBitmap;
        }

        private void submitPostprocessing() {
            PostprocessorProducer.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.2
                @Override // java.lang.Runnable
                public void run() {
                    CloseableReference closeableReference;
                    boolean z;
                    synchronized (PostprocessorConsumer.this) {
                        closeableReference = PostprocessorConsumer.this.mSourceImageRef;
                        z = PostprocessorConsumer.this.mIsLast;
                        PostprocessorConsumer.this.mSourceImageRef = null;
                        PostprocessorConsumer.this.mIsDirty = false;
                    }
                    if (CloseableReference.isValid(closeableReference)) {
                        try {
                            PostprocessorConsumer.this.doPostprocessing(closeableReference, z);
                        } finally {
                            CloseableReference.closeSafely(closeableReference);
                        }
                    }
                    PostprocessorConsumer.this.clearRunningAndStartIfDirty();
                }
            });
        }

        private void updateSourceImageRef(@Nullable CloseableReference<CloseableImage> closeableReference, boolean z) {
            synchronized (this) {
                if (this.mIsClosed) {
                    return;
                }
                CloseableReference<CloseableImage> closeableReference2 = this.mSourceImageRef;
                this.mSourceImageRef = CloseableReference.cloneOrNull(closeableReference);
                this.mIsLast = z;
                this.mIsDirty = true;
                boolean runningIfDirtyAndNotRunning = setRunningIfDirtyAndNotRunning();
                CloseableReference.closeSafely(closeableReference2);
                if (!runningIfDirtyAndNotRunning) {
                    return;
                }
                submitPostprocessing();
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onCancellationImpl() {
            maybeNotifyOnCancellation();
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onFailureImpl(Throwable th) {
            maybeNotifyOnFailure(th);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, boolean z) {
            if (CloseableReference.isValid(closeableReference)) {
                updateSourceImageRef(closeableReference, z);
            } else if (!z) {
            } else {
                maybeNotifyOnNewResult(null, true);
            }
        }
    }

    /* loaded from: classes.dex */
    class RepeatedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> implements RepeatedPostprocessorRunner {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean mIsClosed;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private CloseableReference<CloseableImage> mSourceImageRef;

        private RepeatedPostprocessorConsumer(PostprocessorConsumer postprocessorConsumer, RepeatedPostprocessor repeatedPostprocessor, ProducerContext producerContext) {
            super(postprocessorConsumer);
            this.mIsClosed = false;
            this.mSourceImageRef = null;
            repeatedPostprocessor.setCallback(this);
            producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.PostprocessorProducer.RepeatedPostprocessorConsumer.1
                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    if (RepeatedPostprocessorConsumer.this.close()) {
                        RepeatedPostprocessorConsumer.this.getConsumer().onCancellation();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean close() {
            boolean z = true;
            synchronized (this) {
                if (this.mIsClosed) {
                    z = false;
                } else {
                    CloseableReference<CloseableImage> closeableReference = this.mSourceImageRef;
                    this.mSourceImageRef = null;
                    this.mIsClosed = true;
                    CloseableReference.closeSafely(closeableReference);
                }
            }
            return z;
        }

        private void setSourceImageRef(CloseableReference<CloseableImage> closeableReference) {
            synchronized (this) {
                if (this.mIsClosed) {
                    return;
                }
                CloseableReference<CloseableImage> closeableReference2 = this.mSourceImageRef;
                this.mSourceImageRef = CloseableReference.cloneOrNull(closeableReference);
                CloseableReference.closeSafely(closeableReference2);
            }
        }

        private void updateInternal() {
            synchronized (this) {
                if (this.mIsClosed) {
                    return;
                }
                CloseableReference<CloseableImage> cloneOrNull = CloseableReference.cloneOrNull(this.mSourceImageRef);
                try {
                    getConsumer().onNewResult(cloneOrNull, false);
                } finally {
                    CloseableReference.closeSafely(cloneOrNull);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onCancellationImpl() {
            if (close()) {
                getConsumer().onCancellation();
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onFailureImpl(Throwable th) {
            if (close()) {
                getConsumer().onFailure(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, boolean z) {
            if (!z) {
                return;
            }
            setSourceImageRef(closeableReference);
            updateInternal();
        }

        @Override // com.facebook.imagepipeline.request.RepeatedPostprocessorRunner
        public synchronized void update() {
            updateInternal();
        }
    }

    /* loaded from: classes.dex */
    class SingleUsePostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        private SingleUsePostprocessorConsumer(PostprocessorConsumer postprocessorConsumer) {
            super(postprocessorConsumer);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, boolean z) {
            if (!z) {
                return;
            }
            getConsumer().onNewResult(closeableReference, z);
        }
    }

    public PostprocessorProducer(Producer<CloseableReference<CloseableImage>> producer, PlatformBitmapFactory platformBitmapFactory, Executor executor) {
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
        this.mBitmapFactory = platformBitmapFactory;
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        ProducerListener listener = producerContext.getListener();
        Postprocessor postprocessor = producerContext.getImageRequest().getPostprocessor();
        PostprocessorConsumer postprocessorConsumer = new PostprocessorConsumer(consumer, listener, producerContext.getId(), postprocessor, producerContext);
        this.mInputProducer.produceResults(postprocessor instanceof RepeatedPostprocessor ? new RepeatedPostprocessorConsumer(postprocessorConsumer, (RepeatedPostprocessor) postprocessor, producerContext) : new SingleUsePostprocessorConsumer(postprocessorConsumer), producerContext);
    }
}
