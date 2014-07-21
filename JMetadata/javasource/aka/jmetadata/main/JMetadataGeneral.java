package aka.jmetadata.main;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import aka.jmetadata.main.constants.Commons;
import aka.jmetadata.main.constants.General;
import aka.jmetadata.main.constants.InfoKind;
import aka.jmetadata.main.constants.StreamKind;
import aka.jmetadata.main.helper.DateHelper;
import aka.jmetadata.main.mediainfo.MediaInfo;
import aka.swissknife.data.TextUtils;

/**
 * A test for the various media information functions.
 * <p>
 * For regular media files (like ".mpg" or ".avi") the track information is available after the media has been parsed (or played).
 * </p>
 * <p>
 * For DVD media files (like ".iso" files) the track information is not available after the media has been parsed, a video output must have been created, and even then the video track width/height
 * might not be available until a short time later.
 * </p>
 * <p>
 * In all cases, the other functions for title, video, audio and chapter descriptions require that a video output has been created before they return valid information.
 * </p>
 *
 * @author Charlotte
 */
public final class JMetadataGeneral extends AbstractJMetadata {

    /**
     * Constructor.
     *
     * @param mediaInfo
     */
    public JMetadataGeneral(@Nonnull final MediaInfo mediaInfo) {
        super(mediaInfo);
    }

    /**
     * Get the number of video stream of the file.
     *
     * @return number of streams
     */
    public int getNumVideoStreams() {
        return getMediaInfo().getStreamCount(StreamKind.Video);
    }

    /**
     * Get the number of audio stream of the file.
     *
     * @return number of streams
     */
    public int getNumAudioStreams() {
        return getMediaInfo().getStreamCount(StreamKind.Audio);
    }

    /**
     * Get the number of subtitle stream of the file.
     *
     * @return number of streams
     */
    public int getNumSubtitleStreams() {
        return getMediaInfo().getStreamCount(StreamKind.Text);
    }

    /**
     * Get the duration of the media, in milliseconds.
     *
     * @return duration in milliseconds
     */
    public Double getDuration() {
        Double result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, General.DURATION, InfoKind.Text, InfoKind.Name);
        if (TextUtils.isDigit(value)) {
            result = Double.valueOf(value);
        }

        return result;
    }

    /**
     * Get the size of the file in bytes.
     *
     * @return size in bytes
     */
    public Long getFileSize() {
        Long result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, General.FILESIZE, InfoKind.Text, InfoKind.Name);
        if (TextUtils.isDigit(value)) {
            result = Long.valueOf(value);
        }

        return result;
    }

    /**
     * Get the format version use of the file.
     *
     * @return format version use
     */
    @Nullable
    public String getFormatVersion() {
        return getMediaInfo().get(StreamKind.General, 0, General.FORMAT_VERSION, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get number of streams of this kind available.
     *
     * @return number of streams of this kind available
     */
    @Nullable
    public Integer getStreamCount() {
        Integer result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, Commons.STREAMCOUNT, InfoKind.Text, InfoKind.Name);
        if (TextUtils.isDigit(value)) {
            result = Integer.valueOf(value);
        }
        return result;
    }

    /**
     * Get stream type name.
     *
     * @return stream type name
     */
    @Nullable
    public String getStreamKind() {
        return getMediaInfo().get(StreamKind.General, 0, General.STREAMKIND, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get stream type name.
     *
     * @return stream type name
     */
    @Nullable
    public String getStreamKindString() {
        return getMediaInfo().get(StreamKind.General, 0, General.STREAM_KIND_STRING, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get number of the stream (base=0).
     *
     * @return number of the stream (base=0)
     */
    @Nullable
    public Integer getStreamKindID() {
        Integer result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, General.STREAM_KIND_ID, InfoKind.Text, InfoKind.Name);
        if (TextUtils.isDigit(value)) {
            result = Integer.valueOf(value);
        }
        return result;
    }

    /**
     * When multiple streams, number of the stream (base=1).
     *
     * @return number of the stream (base=1)
     */
    @Nullable
    public Integer getStreamKindPosition() {
        Integer result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, General.STREAM_KIND_POS, InfoKind.Text, InfoKind.Name);
        if (TextUtils.isDigit(value)) {
            result = Integer.valueOf(value);
        }
        return result;
    }

    /**
     * Get the ID for this stream in this file.
     *
     * @return ID for this stream in this file
     */
    @Nullable
    public Integer getID() {
        Integer result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, General.ID, InfoKind.Text, InfoKind.Name);
        if (TextUtils.isDigit(value)) {
            result = Integer.valueOf(value);
        }
        return result;
    }

    /**
     * Get stream order in the file, whatever is the kind of stream (base=0).
     *
     * @return stream order in the file
     */
    @Nullable
    public Integer getStreamKindOrder() {
        Integer result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, General.STREAMORDER, InfoKind.Text, InfoKind.Name);
        if (TextUtils.isDigit(value)) {
            result = Integer.valueOf(value);
        }
        return result;
    }

    /**
     * Get stream order in the file, whatever is the kind of stream (base=0).
     *
     * @return stream order in the file
     */
    @Nullable
    public String getIDString() {
        return getMediaInfo().get(StreamKind.General, 0, General.ID_STRING, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get the unique ID for this stream, should be copied with stream copy.
     *
     * @return unique ID for this stream
     */
    @Nullable
    public BigInteger getUniqueID() {
        BigInteger result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, General.UNIQUE_ID, InfoKind.Text, InfoKind.Name);
        if (TextUtils.isDigit(value)) {
            result = new BigInteger(value);
        }
        return result;
    }

    /**
     * Get the unique ID for this stream, should be copied with stream copy.
     *
     * @return unique ID for this stream
     */
    @Nullable
    public String getUniqueIDString() {
        return getMediaInfo().get(StreamKind.General, 0, General.UNIQUE_ID_STRING, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get the menu ID for this stream in this file.
     *
     * @return menu ID for this stream in this file
     */
    @Nullable
    public Integer getMenuID() {
        Integer result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, General.MENUID, InfoKind.Text, InfoKind.Name);
        if (TextUtils.isDigit(value)) {
            result = new Integer(value);
        }
        return result;
    }

    /**
     * Get the menu ID for this stream in this file.
     *
     * @return menu ID for this stream in this file
     */
    @Nullable
    public String getMenuIDString() {
        return getMediaInfo().get(StreamKind.General, 0, General.MENUID_STRING, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get the bit rate of all streams in bps.
     *
     * @return bit rate in bps
     */
    @Nullable
    public Long getOverallBitRate() {
        Long result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, General.OVERALLBITRATE, InfoKind.Text, InfoKind.Name);
        if (TextUtils.isDigit(value)) {
            result = Long.valueOf(value);
        }

        return result;
    }

    /**
     * Get number of general streams.
     *
     * @return number of general streams
     */
    @Nullable
    public Integer getGeneralCount() {
        Integer result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, General.GENERALCOUNT, InfoKind.Text, InfoKind.Name);
        if (TextUtils.isDigit(value)) {
            result = new Integer(value);
        }
        return result;
    }

    /**
     * Get number of video streams.
     *
     * @return number of video streams
     */
    @Nullable
    public Integer getVideoCount() {
        Integer result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, General.VIDEOCOUNT, InfoKind.Text, InfoKind.Name);
        if (TextUtils.isDigit(value)) {
            result = new Integer(value);
        }
        return result;
    }

    /**
     * Get number of audio streams.
     *
     * @return number of audio streams
     */
    @Nullable
    public Integer getAudioCount() {
        Integer result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, General.AUDIOCOUNT, InfoKind.Text, InfoKind.Name);
        if (TextUtils.isDigit(value)) {
            result = new Integer(value);
        }
        return result;
    }

    /**
     * Get number of text streams.
     *
     * @return number of text streams
     */
    @Nullable
    public Integer getTextCount() {
        Integer result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, General.TEXTCOUNT, InfoKind.Text, InfoKind.Name);
        if (TextUtils.isDigit(value)) {
            result = new Integer(value);
        }
        return result;
    }

    /**
     * Get number of chapters streams.
     *
     * @return number of chapters streams
     */
    @Nullable
    public Integer getChaptersCount() {
        Integer result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, General.CHAPTERSCOUNT, InfoKind.Text, InfoKind.Name);
        if (TextUtils.isDigit(value)) {
            result = new Integer(value);
        }
        return result;
    }

    /**
     * Get number of image streams.
     *
     * @return number of image streams
     */
    @Nullable
    public Integer getImageCount() {
        Integer result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, General.IMAGECOUNT, InfoKind.Text, InfoKind.Name);
        if (TextUtils.isDigit(value)) {
            result = new Integer(value);
        }
        return result;
    }

    /**
     * Get number of menu streams.
     *
     * @return number of menu streams
     */
    @Nullable
    public Integer getMenuCount() {
        Integer result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, General.MENUCOUNT, InfoKind.Text, InfoKind.Name);
        if (TextUtils.isDigit(value)) {
            result = new Integer(value);
        }
        return result;
    }

    /**
     * Get video Codecs in this file.
     *
     * @return video Codecs in this file
     */
    @Nonnull
    public List<String> getVideoFormatList() {
        List<String> result = new ArrayList<>();
        final String value = getMediaInfo().get(StreamKind.General, 0, General.VIDEO_FORMAT_LIST, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            assert value != null;
            result = splitValues(value, "/");
        }

        return result;
    }

    /**
     * Get video Codecs in this file with popular name (hint).
     *
     * @return video Codecs in this file
     */
    @Nonnull
    public List<String> getVideoFormatWithHintList() {
        List<String> result = new ArrayList<>();
        final String value = getMediaInfo().get(StreamKind.General, 0, General.VIDEO_FORMAT_WITH_HINT_LIST, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            assert value != null;
            result = splitValues(value, "/");
        }

        return result;
    }

    /**
     * Get video languages in this file, full names.
     *
     * @return video languages in this file
     */
    @Nonnull
    public List<String> getVideoLanguageList() {
        List<String> result = new ArrayList<>();
        final String value = getMediaInfo().get(StreamKind.General, 0, General.VIDEO_LANGUAGE_LIST, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            assert value != null;
            result = splitValues(value, "/");
        }

        return result;
    }

    /**
     * Get audio Codecs in this file.
     *
     * @return audio Codecs in this file
     */
    @Nonnull
    public List<String> getAudioFormatList() {
        List<String> result = new ArrayList<>();
        final String value = getMediaInfo().get(StreamKind.General, 0, General.AUDIO_FORMAT_LIST, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            assert value != null;
            result = splitValues(value, "/");
        }

        return result;
    }

    /**
     * Get audio Codecs in this file with popular name (hint).
     *
     * @return audio Codecs in this file
     */
    @Nonnull
    public List<String> getAudioFormatWithHintList() {
        List<String> result = new ArrayList<>();
        final String value = getMediaInfo().get(StreamKind.General, 0, General.AUDIO_FORMAT_WITH_HINT_LIST, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            assert value != null;
            result = splitValues(value, "/");
        }

        return result;
    }

    /**
     * Get audio languages in this file, full names.
     *
     * @return audio languages in this file
     */
    @Nonnull
    public List<String> getAudioLanguageList() {
        List<String> result = new ArrayList<>();
        final String value = getMediaInfo().get(StreamKind.General, 0, General.AUDIO_LANGUAGE_LIST, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            assert value != null;
            result = splitValues(value, "/");
        }

        return result;
    }

    /**
     * Get text Codecs in this file.
     *
     * @return text Codecs in this file
     */
    @Nonnull
    public List<String> getTextFormatList() {
        List<String> result = new ArrayList<>();
        final String value = getMediaInfo().get(StreamKind.General, 0, General.TEXT_FORMAT_LIST, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            assert value != null;
            result = splitValues(value, "/");
        }

        return result;
    }

    /**
     * Get text Codecs in this file with popular name (hint).
     *
     * @return text Codecs in this file
     */
    @Nonnull
    public List<String> getTextFormatWithHintList() {
        List<String> result = new ArrayList<>();
        final String value = getMediaInfo().get(StreamKind.General, 0, General.TEXT_FORMAT_WITH_HINT_LIST, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            assert value != null;
            result = splitValues(value, "/");
        }

        return result;
    }

    /**
     * Get text languages in this file, full names.
     *
     * @return text languages in this file
     */
    @Nonnull
    public List<String> getTextLanguageList() {
        List<String> result = new ArrayList<>();
        final String value = getMediaInfo().get(StreamKind.General, 0, General.TEXT_LANGUAGE_LIST, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            assert value != null;
            result = splitValues(value, "/");
        }

        return result;
    }

    /**
     * Get chapters Codecs in this file.
     *
     * @return chapters Codecs in this file
     */
    @Nonnull
    public List<String> getChaptersFormatList() {
        List<String> result = new ArrayList<>();
        final String value = getMediaInfo().get(StreamKind.General, 0, General.CHAPTERS_FORMAT_LIST, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            assert value != null;
            result = splitValues(value, "/");
        }

        return result;
    }

    /**
     * Get chapters Codecs in this file with popular name (hint).
     *
     * @return chapters Codecs in this file
     */
    @Nonnull
    public List<String> getChaptersFormatWithHintList() {
        List<String> result = new ArrayList<>();
        final String value = getMediaInfo().get(StreamKind.General, 0, General.CHAPTERS_FORMAT_WITH_HINT_LIST, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            assert value != null;
            result = splitValues(value, "/");
        }

        return result;
    }

    /**
     * Get chapters languages in this file, full names.
     *
     * @return chapters languages in this file
     */
    @Nonnull
    public List<String> getChaptersLanguageList() {
        List<String> result = new ArrayList<>();
        final String value = getMediaInfo().get(StreamKind.General, 0, General.CHAPTERS_LANGUAGE_LIST, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            assert value != null;
            result = splitValues(value, "/");
        }

        return result;
    }

    /**
     * Get image Codecs in this file.
     *
     * @return image Codecs in this file
     */
    @Nonnull
    public List<String> getImageFormatList() {
        List<String> result = new ArrayList<>();
        final String value = getMediaInfo().get(StreamKind.General, 0, General.IMAGE_FORMAT_LIST, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            assert value != null;
            result = splitValues(value, "/");
        }

        return result;
    }

    /**
     * Get image Codecs in this file with popular name (hint).
     *
     * @return image Codecs in this file
     */
    @Nonnull
    public List<String> getImageFormatWithHintList() {
        List<String> result = new ArrayList<>();
        final String value = getMediaInfo().get(StreamKind.General, 0, General.IMAGE_FORMAT_WITH_HINT_LIST, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            assert value != null;
            result = splitValues(value, "/");
        }

        return result;
    }

    /**
     * Get image languages in this file, full names.
     *
     * @return image languages in this file
     */
    @Nonnull
    public List<String> getImageLanguageList() {
        List<String> result = new ArrayList<>();
        final String value = getMediaInfo().get(StreamKind.General, 0, General.IMAGE_LANGUAGE_LIST, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            assert value != null;
            result = splitValues(value, "/");
        }

        return result;
    }

    /**
     * Get menu Codecs in this file.
     *
     * @return menu Codecs in this file
     */
    @Nonnull
    public List<String> getMenuFormatList() {
        List<String> result = new ArrayList<>();
        final String value = getMediaInfo().get(StreamKind.General, 0, General.MENU_FORMAT_LIST, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            assert value != null;
            result = splitValues(value, "/");
        }

        return result;
    }

    /**
     * Get menu Codecs in this file with popular name (hint).
     *
     * @return menu Codecs in this file
     */
    @Nonnull
    public List<String> getMenuFormatWithHintList() {
        List<String> result = new ArrayList<>();
        final String value = getMediaInfo().get(StreamKind.General, 0, General.MENU_FORMAT_WITH_HINT_LIST, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            assert value != null;
            result = splitValues(value, "/");
        }

        return result;
    }

    /**
     * Get menu languages in this file, full names.
     *
     * @return menu languages in this file
     */
    @Nonnull
    public List<String> getMenuLanguageList() {
        List<String> result = new ArrayList<>();
        final String value = getMediaInfo().get(StreamKind.General, 0, General.MENU_LANGUAGE_LIST, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            assert value != null;
            result = splitValues(value, "/");
        }

        return result;
    }

    /**
     * Get the complete name (Folder+Name+Extension).
     *
     * @return complete name
     */
    @Nullable
    public String getCompleteName() {
        return getMediaInfo().get(StreamKind.General, 0, General.COMPLETE_NAME, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get the folder name only.
     *
     * @return folder name
     */
    @Nullable
    public String getFolderName() {
        return getMediaInfo().get(StreamKind.General, 0, General.FOLDER_NAME, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get the file name only.
     *
     * @return file name
     */
    @Nullable
    public String getFileName() {
        return getMediaInfo().get(StreamKind.General, 0, General.FILE_NAME, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get the file extension only.
     *
     * @return file extension
     */
    @Nullable
    public String getFileExtension() {
        return getMediaInfo().get(StreamKind.General, 0, General.FILE_EXTENSION, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get info about this Format.
     *
     * @return info about this Format
     */
    @Nullable
    public String getFormatInfo() {
        return getMediaInfo().get(StreamKind.General, 0, General.FORMAT_INFO, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get link to a description of this format.
     *
     * @return link to a description of this format
     * @throws MalformedURLException if no protocol is specified or an unknown protocol is found.
     */
    @Nullable
    public URL getFormatURL() throws MalformedURLException {
        URL result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, General.FORMAT_URL, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            result = new URL(value);
        }

        return result;
    }

    /**
     * Get known extensions of this format.
     *
     * @return known extensions of this format
     */
    @Nonnull
    public List<String> getFormatExtensionsList() {
        List<String> result = new ArrayList<>();
        final String value = getMediaInfo().get(StreamKind.General, 0, General.FORMAT_EXTENSIONS, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            assert value != null;
            result = splitValues(value, " ");
        }

        return result;
    }

    /**
     * Get commercial name used by vendor for theses settings or Format field if there is no difference.
     *
     * @return commercial name
     */
    @Nullable
    public String getFormatCommercial() {
        return getMediaInfo().get(StreamKind.General, 0, General.FORMAT_COMMERCIAL, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get commercial name used by vendor for theses settings or Format field if there is no difference.
     *
     * @return commercial name
     */
    @Nullable
    public String getFormatCommercialIfAny() {
        return getMediaInfo().get(StreamKind.General, 0, General.FORMAT_COMMERCIAL_IF_ANY, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get profile of the Format.
     *
     * @return profile of the Format
     */
    @Nullable
    public String getFormatProfile() {
        return getMediaInfo().get(StreamKind.General, 0, General.FORMAT_PROFILE, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get compression method used.
     *
     * @return compression method
     */
    @Nullable
    public String getFormatCompression() {
        return getMediaInfo().get(StreamKind.General, 0, General.FORMAT_COMPRESSION, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get settings needed for decoder used.
     *
     * @return settings
     */
    @Nullable
    public String getFormatSettings() {
        return getMediaInfo().get(StreamKind.General, 0, General.FORMAT_SETTINGS, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get Internet Media Type (aka MIME Type, Content-Type).
     *
     * @return Internet Media Type
     */
    @Nullable
    public String getInternetMediaType() {
        return getMediaInfo().get(StreamKind.General, 0, General.INTERNET_MEDIA_TYPE, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get codec ID (final found in some containers).
     *
     * @return codec ID
     */
    @Nullable
    public Integer getCodecID() {
        Integer result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, General.CODEC_ID, InfoKind.Text, InfoKind.Name);
        if (TextUtils.isDigit(value)) {
            result = new Integer(value);
        }
        return result;
    }

    /**
     * Get codec ID (final found in some containers).
     *
     * @return codec ID
     */
    @Nullable
    public String getCodecIDString() {
        return getMediaInfo().get(StreamKind.General, 0, General.CODEC_ID_STRING, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get info about this codec.
     *
     * @return info about this codec
     */
    @Nullable
    public String getCodecIDInfo() {
        return getMediaInfo().get(StreamKind.General, 0, General.CODEC_ID_INFO, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get hint/popular name for this codec.
     *
     * @return hint/popular name
     */
    @Nullable
    public String getCodecIDHint() {
        return getMediaInfo().get(StreamKind.General, 0, General.CODEC_ID_HINT, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get link to more details about this codec ID.
     *
     * @return link to more details
     * @throws MalformedURLException if no protocol is specified or an unknown protocol is found
     */
    @Nullable
    public URL getCodecIDURL() throws MalformedURLException {
        URL result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, General.CODEC_ID_URL, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            result = new URL(value);
        }

        return result;
    }

    /**
     * Get manual description given by the container.
     *
     * @return manual description
     */
    @Nullable
    public String getCodecIDDescription() {
        return getMediaInfo().get(StreamKind.General, 0, General.CODEC_ID_DESCRIPTION, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Is the audio and video muxed ?
     *
     * @return <code>true</code> if Audio and video are muxed
     */
    public boolean isInterleaved() {
        final String value = getMediaInfo().get(StreamKind.General, 0, General.INTERLEAVED, InfoKind.Text, InfoKind.Name);
        return "Yes".equals(value);
    }

    /**
     * Get file size (final with measure).
     *
     * @return file size
     */
    @Nullable
    public String getFilesizeString() {
        return getMediaInfo().get(StreamKind.General, 0, General.FILESIZE_STRING, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get file size (final with measure, 1 digit mini).
     *
     * @return file size
     */
    @Nullable
    public String getFilesizeString1Digits() {
        return getMediaInfo().get(StreamKind.General, 0, General.FILESIZE_STRING1, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get file size (final with measure, 2 digit mini).
     *
     * @return file size
     */
    @Nullable
    public String getFilesizeString2Digits() {
        return getMediaInfo().get(StreamKind.General, 0, General.FILESIZE_STRING2, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get file size (final with measure, 3 digit mini).
     *
     * @return file size
     */
    @Nullable
    public String getFilesizeString3Digits() {
        return getMediaInfo().get(StreamKind.General, 0, General.FILESIZE_STRING3, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get file size (final with measure, 4 digit mini).
     *
     * @return file size
     */
    @Nullable
    public String getFilesizeString4Digits() {
        return getMediaInfo().get(StreamKind.General, 0, General.FILESIZE_STRING4, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get play time in format : XXx YYy only, YYy omitted if zero.
     *
     * @return play time
     */
    @Nullable
    public String getDurationString() {
        return getMediaInfo().get(StreamKind.General, 0, General.DURATION_STRING, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get play time in format : HHh MMmn SSs MMMms, XX omited if zero.
     *
     * @return play time
     */
    @Nullable
    public String getDurationStringType1() {
        return getMediaInfo().get(StreamKind.General, 0, General.DURATION_STRING1, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get play time in format : XXx YYy only, YYy omited if zero.
     *
     * @return play time
     */
    @Nullable
    public String getDurationStringType2() {
        return getMediaInfo().get(StreamKind.General, 0, General.DURATION_STRING2, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get play time in format : HH:MM:SS.MMM.
     *
     * @return play time
     */
    @Nullable
    public String getDurationStringType3() {
        return getMediaInfo().get(StreamKind.General, 0, General.DURATION_STRING3, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get duration start.
     *
     * @return duration start
     */
    @Nullable
    public String getDurationStart() {
        return getMediaInfo().get(StreamKind.General, 0, General.DURATION_START, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get duration end.
     *
     * @return duration end
     */
    @Nullable
    public String getDurationEnd() {
        return getMediaInfo().get(StreamKind.General, 0, General.DURATION_END, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get bit rate mode of all streams (VBR, CBR).
     *
     * @return bit rate
     */
    @Nullable
    public Long getOverallBitRateMode() {
        Long result = null;
        final String bitRate = getMediaInfo().get(StreamKind.General, 0, General.OVERALLBITRATE_MODE, InfoKind.Text, InfoKind.Name);
        if (TextUtils.isDigit(bitRate)) {
            result = Long.valueOf(bitRate);
        }

        return result;
    }

    /**
     * Get bit rate mode of all streams (VBR, CBR).
     *
     * @return bit rate
     */
    @Nullable
    public String getOverallBitRateModeString() {
        return getMediaInfo().get(StreamKind.General, 0, General.OVERALLBITRATE_MODE_STRING, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get bit rate of all streams (with measure).
     *
     * @return bit rate
     */
    @Nullable
    public String getOverallBitRateString() {
        return getMediaInfo().get(StreamKind.General, 0, General.OVERALLBITRATE_STRING, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get minimum Bit rate in bps.
     *
     * @return minimum bit rate
     */
    @Nullable
    public Long getOverallBitRateMinimum() {
        Long result = null;
        final String bitRate = getMediaInfo().get(StreamKind.General, 0, General.OVERALLBITRATE_MINIMUM, InfoKind.Text, InfoKind.Name);
        if (TextUtils.isDigit(bitRate)) {
            result = Long.valueOf(bitRate);
        }

        return result;
    }

    /**
     * Get maximum Bit rate in bps.
     *
     * @return maximum bit rate
     */
    @Nullable
    public Long getOverallBitRateMaximum() {
        Long result = null;
        final String bitRate = getMediaInfo().get(StreamKind.General, 0, General.OVERALLBITRATE_MAXIMUM, InfoKind.Text, InfoKind.Name);
        if (TextUtils.isDigit(bitRate)) {
            result = Long.valueOf(bitRate);
        }

        return result;
    }

    /**
     * Get nominal Bit rate in bps.
     *
     * @return nominal bit rate
     */
    @Nullable
    public Long getOverallBitRateNominal() {
        Long result = null;
        final String bitRate = getMediaInfo().get(StreamKind.General, 0, General.OVERALLBITRATE_NOMINAL, InfoKind.Text, InfoKind.Name);
        if (TextUtils.isDigit(bitRate)) {
            result = Long.valueOf(bitRate);
        }

        return result;
    }

    /**
     * Get minimum Bit rate in bps (with measurement).
     *
     * @return minimum bit rate
     */
    @Nullable
    public String getOverallBitRateMinimumString() {
        return getMediaInfo().get(StreamKind.General, 0, General.OVERALLBITRATE_MINIMUM_STRING, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get maximum Bit rate in bps (with measurement).
     *
     * @return maximum bit rate
     */
    @Nullable
    public String getOverallBitRateMaximumString() {
        return getMediaInfo().get(StreamKind.General, 0, General.OVERALLBITRATE_MAXIMUM_STRING, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get nominal Bit rate in bps (with measurement).
     *
     * @return nominal bit rate
     */
    @Nullable
    public String getOverallBitRateNominalString() {
        return getMediaInfo().get(StreamKind.General, 0, General.OVERALLBITRATE_NOMINAL_STRING, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get stream size.
     *
     * @return stream size
     */
    @Nullable
    public Long getStreamsize() {
        Long result = null;
        final String bitRate = getMediaInfo().get(StreamKind.General, 0, General.STREAMSIZE, InfoKind.Text, InfoKind.Name);
        if (TextUtils.isDigit(bitRate)) {
            result = Long.valueOf(bitRate);
        }

        return result;
    }

    /**
     * Get stream size with measurements.
     *
     * @return stream size
     */
    @Nullable
    public String getStreamsizeString() {
        return getMediaInfo().get(StreamKind.General, 0, General.STREAMSIZE_STRING, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get stream size with measurements.
     *
     * @return stream size
     */
    @Nullable
    public String getStreamsizeStringType1() {
        return getMediaInfo().get(StreamKind.General, 0, General.STREAMSIZE_STRING1, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get stream size with measurements.
     *
     * @return stream size
     */
    @Nullable
    public String getStreamsizeStringType2() {
        return getMediaInfo().get(StreamKind.General, 0, General.STREAMSIZE_STRING2, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get stream size with measurements.
     *
     * @return stream size
     */
    @Nullable
    public String getStreamsizeStringType3() {
        return getMediaInfo().get(StreamKind.General, 0, General.STREAMSIZE_STRING3, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get stream size with measurements.
     *
     * @return stream size
     */
    @Nullable
    public String getStreamsizeStringType4() {
        return getMediaInfo().get(StreamKind.General, 0, General.STREAMSIZE_STRING4, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get stream size with measurements.
     *
     * @return stream size
     */
    @Nullable
    public String getStreamsizeStringType5() {
        return getMediaInfo().get(StreamKind.General, 0, General.STREAMSIZE_STRING5, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get stream size divided by file size.
     *
     * @return stream size
     */
    @Nullable
    public Double getStreamsizeProportion() {
        Double result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, General.STREAMSIZE_PROPORTION, InfoKind.Text, InfoKind.Name);
        if (TextUtils.isDigit(value)) {
            result = Double.valueOf(value);
        }

        return result;
    }

    /**
     * Is it streamable ?
     *
     * @return <code>true</code> if streamable
     */
    public boolean isStreamable() {
        final String value = getMediaInfo().get(StreamKind.General, 0, General.ISSTREAMABLE, InfoKind.Text, InfoKind.Name);
        return "Yes".equals(value);
    }

    /**
     * Get the time/date/year that the recording began.
     *
     * @return the time/date/year
     * @throws ParseException if the beginning of the specified string cannot be parsed.
     */
    @Nullable
    public Date getRecordedDate() throws ParseException {
        Date result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, General.RECORDED_DATE, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            assert value != null;
            result = DateHelper.parse(value);
        }
        return result;
    }

    /**
     * Get the time/date/year that the encoding of this item was completed began.
     *
     * @return the time/date/year
     * @throws ParseException if the beginning of the specified string cannot be parsed.
     */
    @Nullable
    public Date getEncodedDate() throws ParseException {
        Date result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, General.ENCODED_DATE, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            assert value != null;
            result = DateHelper.parse(value);
        }
        return result;
    }

    /**
     * Get the time/date/year that the tags were done for this item.
     *
     * @return the time/date/year
     * @throws ParseException if the beginning of the specified string cannot be parsed.
     */
    @Nullable
    public Date getTaggedDate() throws ParseException {
        Date result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, General.TAGGED_DATE, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            assert value != null;
            result = DateHelper.parse(value);
        }
        return result;
    }

    /**
     * Get the time/date/year that the composition of the music/script began.
     *
     * @return the time/date/year
     * @throws ParseException if the beginning of the specified string cannot be parsed.
     */
    @Nullable
    public Date getWrittenDate() throws ParseException {
        Date result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, General.WRITTEN_DATE, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            assert value != null;
            result = DateHelper.parse(value);
        }
        return result;
    }

    /**
     * Get time that the file was created on the file system.
     *
     * @return time
     * @throws ParseException if the beginning of the specified string cannot be parsed.
     */
    @Nullable
    public Date getFileCreatedDate() throws ParseException {
        Date result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, General.FILE_CREATED_DATE, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            assert value != null;
            result = DateHelper.parse(value);
        }
        return result;
    }

    /**
     * Get time that the file was modified on the file system.
     *
     * @return time
     * @throws ParseException if the beginning of the specified string cannot be parsed.
     */
    @Nullable
    public Date getFileModifiedDate() throws ParseException {
        Date result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, General.FILE_MODIFIED_DATE, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            assert value != null;
            result = DateHelper.parse(value);
        }
        return result;
    }

    /**
     * Get the name of the software package used to create the file, such as Microsoft WaveEdit.
     *
     * @return name of the software package
     */
    @Nullable
    public String getEncodedApplication() {
        return getMediaInfo().get(StreamKind.General, 0, General.ENCODED_APPLICATION, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get link of the software package used to create the file, such as Microsoft WaveEdit.
     *
     * @return link of the software package used to create the file, such as Microsoft WaveEdit.
     * @throws MalformedURLException if no protocol is specified or an unknown protocol is found.
     */
    @Nullable
    public URL getEncodedApplicationURL() throws MalformedURLException {
        URL result = null;
        final String value = getMediaInfo().get(StreamKind.General, 0, General.ENCODED_APPLICATION_URL, InfoKind.Text, InfoKind.Name);
        if (!TextUtils.isEmpty(value)) {
            result = new URL(value);
        }

        return result;
    }

    /**
     * Get software used to create the file.
     *
     * @return software used to create the file
     */
    @Nullable
    public String getEncodedLibrary() {
        return getMediaInfo().get(StreamKind.General, 0, General.ENCODED_LIBRARY, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get software used to create the file.
     *
     * @return software used to create the file
     */
    @Nullable
    public String getEncodedLibraryString() {
        return getMediaInfo().get(StreamKind.General, 0, General.ENCODED_LIBRARY_STRING, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get name of the the encoding-software.
     *
     * @return name of the the encoding-software
     */
    @Nullable
    public String getEncodedLibraryName() {
        return getMediaInfo().get(StreamKind.General, 0, General.ENCODED_LIBRARY_NAME, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get version of the the encoding-software.
     *
     * @return version of the the encoding-software
     */
    @Nullable
    public String getEncodedLibraryVersion() {
        return getMediaInfo().get(StreamKind.General, 0, General.ENCODED_LIBRARY_VERSION, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get release date of the the encoding-software.
     *
     * @return release date of the the encoding-software
     */
    @Nullable
    public String getEncodedLibraryDate() {
        return getMediaInfo().get(StreamKind.General, 0, General.ENCODED_LIBRARY_DATE, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get parameters used by the software.
     *
     * @return parameters used by the software
     */
    @Nullable
    public String getEncodedLibrarySettings() {
        return getMediaInfo().get(StreamKind.General, 0, General.ENCODED_LIBRARY_SETTINGS, InfoKind.Text, InfoKind.Name);
    }

    /**
     * Get format used
     *
     * @return format
     */
    @Nullable
    public String getFormat() {
        return getMediaInfo().get(StreamKind.General, 0, General.FORMAT, InfoKind.Text, InfoKind.Name);
    }
}