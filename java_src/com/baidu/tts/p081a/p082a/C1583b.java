package com.baidu.tts.p081a.p082a;

import android.util.Log;
import com.baidu.speechsynthesizer.utility.SpeechDecoder;
import com.baidu.tts.tools.CommonUtility;
/* renamed from: com.baidu.tts.a.a.b */
/* loaded from: classes.dex */
public class C1583b implements AbstractC1584c<byte[], byte[]> {
    @Override // com.baidu.tts.p081a.p082a.AbstractC1584c
    /* renamed from: a */
    public void mo15406a() {
    }

    @Override // com.baidu.tts.p081a.p082a.AbstractC1584c
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public byte[] mo15405a(byte[] bArr) {
        byte[] shortArrayToByteArray;
        int length = bArr.length;
        byte[] bArr2 = new byte[0];
        short[] sArr = new short[(length * 50) / 2];
        int[] iArr = new int[1];
        try {
            if (new SpeechDecoder().decode(bArr, length, sArr, iArr, length * 50, 0) != 0) {
                Log.e("AudioDecoderAdapter", "ret != 0");
                shortArrayToByteArray = bArr2;
            } else {
                int i = iArr[0] / 2;
                short[] sArr2 = new short[i];
                System.arraycopy(sArr, 0, sArr2, 0, i);
                shortArrayToByteArray = CommonUtility.shortArrayToByteArray(sArr2);
            }
            return shortArrayToByteArray;
        } catch (Exception e) {
            e.printStackTrace();
            return bArr2;
        }
    }
}
