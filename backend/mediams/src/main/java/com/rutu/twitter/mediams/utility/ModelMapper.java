package com.rutu.twitter.mediams.utility;

import com.rutu.twitter.mediams.dto.MediaDTO;
import com.rutu.twitter.mediams.entity.Media;

public class ModelMapper {
    public static MediaDTO getMediaDTO(Media media) {
        return MediaDTO.builder()
                .id(media.getId())
                .userId(media.getUserId())
                .mediaUrl(media.getMediaUrl())
                .mediaType(media.getMediaType())
                .uploadedAt(media.getUploadedAt())
                .build();
    }

    public static Media getMedia(MediaDTO mediaDTO) {
        return Media.builder()
                .id(mediaDTO.getId())
                .userId(mediaDTO.getUserId())
                .mediaUrl(mediaDTO.getMediaUrl())
                .mediaType(mediaDTO.getMediaType())
                .uploadedAt(mediaDTO.getUploadedAt())
                .build();
    }
}
