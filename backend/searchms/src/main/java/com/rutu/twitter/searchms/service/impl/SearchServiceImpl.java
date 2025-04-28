package com.rutu.twitter.searchms.service.impl;


import com.rutu.twitter.searchms.dto.EntityType;
import com.rutu.twitter.searchms.dto.SearchDTO;
import com.rutu.twitter.searchms.entity.Search;
import com.rutu.twitter.searchms.exception.BaseException;
import com.rutu.twitter.searchms.repository.SearchRepository;
import com.rutu.twitter.searchms.service.SearchService;
import com.rutu.twitter.searchms.utility.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("searchService")
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchRepository searchRepository;

    @Override
    public SearchDTO createSearch(SearchDTO searchDTO) {
        Search search = ModelMapper.getSearch(searchDTO);
        Search savedSearch = searchRepository.save(search);
        return ModelMapper.getSearchDTO(savedSearch);
    }

    @Override
    public SearchDTO saveSearchEntry(EntityType entityType, Long referenceId, String keyword) {
        Search searchEntity = Search.builder()
                .entityType(entityType)
                .referenceId(referenceId)
                .keyword(keyword)
                .build();
        return ModelMapper.getSearchDTO(searchRepository.save(searchEntity));
    }

    @Override
    public SearchDTO getSearchById(Long id) throws BaseException {
        return searchRepository.findById(id)
                .map(ModelMapper::getSearchDTO)
                .orElseThrow(() -> new BaseException("result not found"));
    }

    @Override
    public List<SearchDTO> getSearchByEntityType(EntityType entityType) {
        return searchRepository.findByEntityType(entityType).stream()
                .map(ModelMapper::getSearchDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SearchDTO> getSearchByReferenceId(Long referenceId) {
        return searchRepository.findByReferenceId(referenceId).stream()
                .map(ModelMapper::getSearchDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SearchDTO updateSearch(Long id, SearchDTO searchDTO) {
        if (searchRepository.existsById(id)) {
            Search search = ModelMapper.getSearch(searchDTO);
            search.setId(id);
            Search updatedSearch = searchRepository.save(search);
            return ModelMapper.getSearchDTO(updatedSearch);
        }
        return null;
    }

    @Override
    public void deleteSearch(Long id) {
        searchRepository.deleteById(id);
    }

    @Override
    public List<SearchDTO> fullTextSearch(String searchTerm) {
        return searchRepository.findByKeywordContainingIgnoreCase(searchTerm).stream()
                .map(ModelMapper::getSearchDTO)
                .collect(Collectors.toList());
    }
}

