package com.rutu.twitter.searchms.service;

import com.rutu.twitter.searchms.dto.EntityType;
import com.rutu.twitter.searchms.dto.SearchDTO;
import com.rutu.twitter.searchms.exception.BaseException;

import java.util.List;

public interface SearchService {
    SearchDTO createSearch(SearchDTO searchDTO);

    SearchDTO getSearchById(Long id) throws BaseException;

    List<SearchDTO> getSearchByEntityType(EntityType entityType);

    List<SearchDTO> getSearchByReferenceId(Long referenceId);

    SearchDTO updateSearch(Long id, SearchDTO searchDTO);

    void deleteSearch(Long id);

    List<SearchDTO> fullTextSearch(String searchTerm);

    SearchDTO saveSearchEntry(EntityType entityType, Long referenceId, String keyword);
}
