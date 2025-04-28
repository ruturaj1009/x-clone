package com.rutu.twitter.mediams.service.impl;

import com.rutu.twitter.mediams.dto.MediaDTO;
import com.rutu.twitter.mediams.entity.Media;
import com.rutu.twitter.mediams.exception.BaseException;
import com.rutu.twitter.mediams.repository.MediaRepository;
import com.rutu.twitter.mediams.utility.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("mediaService")
public class MediaServiceImpl implements com.rutu.twitter.mediams.service.MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    @Override
    public MediaDTO createMedia(MediaDTO mediaDTO) {
        Media media = ModelMapper.getMedia(mediaDTO);
        Media savedMedia = mediaRepository.save(media);
        return ModelMapper.getMediaDTO(savedMedia);
    }

    @Override
    public MediaDTO getMediaById(Long id) throws BaseException {
        return mediaRepository.findById(id)
                .map(ModelMapper::getMediaDTO)
                .orElseThrow(() -> new BaseException("Media not found"));
    }

    @Override
    public MediaDTO updateMedia(Long id, MediaDTO mediaDTO) {
        if (mediaRepository.existsById(id)) {
            Media media = ModelMapper.getMedia(mediaDTO);
            media.setId(id);
            Media updatedMedia = mediaRepository.save(media);
            return ModelMapper.getMediaDTO(updatedMedia);
        }
        return null;
    }

    @Override
    public void deleteMedia(Long id) {
        mediaRepository.deleteById(id);
    }
}
