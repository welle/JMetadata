package aka.jmetadata.main;

import javax.annotation.Nonnull;

import aka.jmetadata.main.constants.InfoKind;
import aka.jmetadata.main.constants.StreamKind;
import aka.jmetadata.main.constants.Text;
import aka.jmetadata.main.mediainfo.MediaInfo;

/**
 * A test for the various media information functions.
 * <p>
 * For regular media files (like ".mpg" or ".avi") the track information is available after the media has been parsed (or played).
 * <p>
 * For DVD media files (like ".iso" files) the track information is not available after the media has been parsed, a video output must have been created, and even then the video track width/height
 * might not be available until a short time later.
 * <p>
 * In all cases, the other functions for title, video, audio and chapter descriptions require that a video output has been created before they return valid information.
 */
public final class JMetadataSubtitle {

    private final MediaInfo mediaInfo;
    private final int streamNumber;

    /**
     * Constructor.
     *
     * @param mediaInfo herited from JMetadata
     * @param streamNumber streamNumber to parse
     */
    public JMetadataSubtitle(@Nonnull final MediaInfo mediaInfo, final int streamNumber) {
        this.mediaInfo = mediaInfo;
        this.streamNumber = streamNumber;
    }

    /**
     * Get the format use of the subtitle
     *
     * @return format use
     */
    public String getFormat() {
        return this.mediaInfo.get(StreamKind.Text, this.streamNumber, Text.Format, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get the Codec ID (found in some containers) use of the subtitle
     *
     * @return Codec ID
     */
    public String getCodecID() {
        return this.mediaInfo.get(StreamKind.Text, this.streamNumber, Text.CodecID, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get the Info about codec ID use of the subtitle
     *
     * @return Info about codec ID
     */
    public String getCodecIDInfo() {
        return this.mediaInfo.get(StreamKind.Text, this.streamNumber, Text.CodecID_Info, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get the Name of the track of the subtitle
     *
     * @return Name of the track
     */
    public String getName() {
        return this.mediaInfo.get(StreamKind.Text, this.streamNumber, Text.Title, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get the Language use of the subtitle
     *
     * @return Language
     */
    public String getLanguage() {
        return this.mediaInfo.get(StreamKind.Text, this.streamNumber, Text.Language, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Set if that track should be used if no language found matches the user preference.
     *
     * @return true if that track should be used if no language found matches the user preference.
     */
    public String isDefault() {
        return this.mediaInfo.get(StreamKind.Text, this.streamNumber, Text.Default, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Set if that track should be used if no language found matches the user preference.
     *
     * @return true if that track should be used if no language found matches the user preference.
     */
    public String isForced() {
        return this.mediaInfo.get(StreamKind.Text, this.streamNumber, Text.Forced, InfoKind.Text, InfoKind.Name);
    }
}
