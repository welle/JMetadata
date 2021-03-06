package aka.jmetadata.main.constants.codecs;

import aka.jmetadata.main.constants.codecs.interfaces.CodecEnum;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * AudioReal constants parameters.
 *
 * @author Welle Charlotte
 */
public enum AudioRealCodecIdEnum implements CodecEnum {

    /**
     * 14.4.
     */
    _144("_14.4", "VSELP", "Real Player 1"),

    /**
     * 14_4.
     */
    _14_4("_14_4", "VSELP", "Real Player 1"),

    /**
     * 28.8.
     */
    _288("_28.8", "G.728", "Real Player 2"),

    /**
     * 28_8.
     */
    _28_8("_28_8", "G.728", "Real Player 2"),

    /**
     * atrc.
     */
    ATRC("atrc", "Atrac", "Real Player 8"),

    /**
     * audio/X-MP3-draft-00.
     */
    AUDIO_X_MP3_DRAFT_00("audio/X-MP3-draft-00", "MPEG Audio"),

    /**
     * audio/x-ralf-mpeg4.
     */
    AUDIO_X_RALF_MPEG4("audio/x-ralf-mpeg4", "RealAudio Lossless", "Real Audio Lossless Format, Real Player 10", "Lossless"),

    /**
     * audio/x-ralf-mpeg4-generic.
     */
    AUDIO_X_RALF_MPEG4_GENERIC("audio/x-ralf-mpeg4-generic", "RealAudio Lossless", "Real Audio Lossless Format, Real Player 10", "Lossless"),

    /**
     * cook.
     */
    COOK("cook", "Cooker", "Based on G.722.1, Real Player 6"),

    /**
     * dnet.
     */
    DNET("dnet", "AC-3", "Real Player 3"),

    /**
     * lpcJ.
     */
    LPCJ("lpcJ", "VSELP", "Real Player 1"),

    /**
     * raac.
     */
    RAAC("raac", "AAC", "Real Player 9", "LC"),

    /**
     * racp.
     */
    RACP("racp", "AAC", "Real Player 10", "HE-AAC"),

    /**
     * rtrc.
     */
    RTRC("rtrc", "RealAudio 8"),

    /**
     * sipr.
     */
    SIPR("sipr", "ACELP", "Real Player 4"),

    /**
     * whrl.
     */
    WHRL("whrl", "RealAudio Multi-Channel", "Real Audio Multi-Channel");

    @NonNull
    private final List<@NonNull String> codecIDList;

    AudioRealCodecIdEnum(@NonNull final String @NonNull... codecIdParam) {
        this.codecIDList = Arrays.asList(codecIdParam);
    }

    @Override
    public List<@NonNull String> getValues() {
        return this.codecIDList;
    }

    /**
     * Get AudioRealCodecIdEnum corresponding to given string.
     *
     * @param param
     * @return corresponding AudioRealEnum
     */
    @Nullable
    public static final AudioRealCodecIdEnum getAudioRealCodecIdEnum(@Nullable final String param) {
        AudioRealCodecIdEnum result = null;
        if (param != null) {
            final String trimmedParam = param.trim().toLowerCase();
            if (trimmedParam.length() > 0) {
                for (final AudioRealCodecIdEnum codecEnum : AudioRealCodecIdEnum.values()) {
                    final List<@NonNull String> values = codecEnum.getValues();
                    for (final String expectedCodec : values) {
                        if (trimmedParam.equals(expectedCodec)) {
                            result = codecEnum;
                            // found, just break
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

}
