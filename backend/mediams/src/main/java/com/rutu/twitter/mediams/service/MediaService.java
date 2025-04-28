package com.rutu.twitter.mediams.service;

import com.rutu.twitter.mediams.dto.MediaDTO;
import com.rutu.twitter.mediams.exception.BaseException;

public interface MediaService {
    MediaDTO createMedia(MediaDTO mediaDTO);

    MediaDTO getMediaById(Long id) throws BaseException;

    MediaDTO updateMedia(Long id, MediaDTO mediaDTO);

    void deleteMedia(Long id);
}
