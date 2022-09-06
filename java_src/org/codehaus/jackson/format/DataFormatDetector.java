package org.codehaus.jackson.format;

import java.io.InputStream;
import java.util.Collection;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.format.InputAccessor;
/* loaded from: classes2.dex */
public class DataFormatDetector {
    public static final int DEFAULT_MAX_INPUT_LOOKAHEAD = 64;
    protected final JsonFactory[] _detectors;
    protected final int _maxInputLookahead;
    protected final MatchStrength _minimalMatch;
    protected final MatchStrength _optimalMatch;

    public DataFormatDetector(Collection<JsonFactory> collection) {
        this((JsonFactory[]) collection.toArray(new JsonFactory[collection.size()]));
    }

    public DataFormatDetector(JsonFactory... jsonFactoryArr) {
        this(jsonFactoryArr, MatchStrength.SOLID_MATCH, MatchStrength.WEAK_MATCH, 64);
    }

    private DataFormatDetector(JsonFactory[] jsonFactoryArr, MatchStrength matchStrength, MatchStrength matchStrength2, int i) {
        this._detectors = jsonFactoryArr;
        this._optimalMatch = matchStrength;
        this._minimalMatch = matchStrength2;
        this._maxInputLookahead = i;
    }

    private DataFormatMatcher _findFormat(InputAccessor.Std std) {
        MatchStrength matchStrength;
        JsonFactory jsonFactory;
        JsonFactory jsonFactory2;
        JsonFactory[] jsonFactoryArr = this._detectors;
        int length = jsonFactoryArr.length;
        int i = 0;
        JsonFactory jsonFactory3 = null;
        MatchStrength matchStrength2 = null;
        while (true) {
            if (i >= length) {
                matchStrength = matchStrength2;
                jsonFactory = jsonFactory3;
                break;
            }
            jsonFactory = jsonFactoryArr[i];
            std.reset();
            matchStrength = jsonFactory.hasFormat(std);
            if (matchStrength == null) {
                jsonFactory2 = jsonFactory3;
            } else if (matchStrength.ordinal() < this._minimalMatch.ordinal()) {
                jsonFactory2 = jsonFactory3;
            } else if (jsonFactory3 != null && matchStrength2.ordinal() >= matchStrength.ordinal()) {
                jsonFactory2 = jsonFactory3;
            } else if (matchStrength.ordinal() >= this._optimalMatch.ordinal()) {
                break;
            } else {
                matchStrength2 = matchStrength;
                jsonFactory2 = jsonFactory;
            }
            i++;
            jsonFactory3 = jsonFactory2;
        }
        return std.createMatcher(jsonFactory, matchStrength);
    }

    public DataFormatMatcher findFormat(InputStream inputStream) {
        return _findFormat(new InputAccessor.Std(inputStream, new byte[this._maxInputLookahead]));
    }

    public DataFormatMatcher findFormat(byte[] bArr) {
        return _findFormat(new InputAccessor.Std(bArr));
    }

    public DataFormatDetector withMaxInputLookahead(int i) {
        return i == this._maxInputLookahead ? this : new DataFormatDetector(this._detectors, this._optimalMatch, this._minimalMatch, i);
    }

    public DataFormatDetector withMinimalMatch(MatchStrength matchStrength) {
        return matchStrength == this._minimalMatch ? this : new DataFormatDetector(this._detectors, this._optimalMatch, matchStrength, this._maxInputLookahead);
    }

    public DataFormatDetector withOptimalMatch(MatchStrength matchStrength) {
        return matchStrength == this._optimalMatch ? this : new DataFormatDetector(this._detectors, matchStrength, this._minimalMatch, this._maxInputLookahead);
    }
}
