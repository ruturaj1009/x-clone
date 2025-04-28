package com.rutu.twitter.searchms.utility;

import com.rutu.twitter.searchms.dto.SearchDTO;
import com.rutu.twitter.searchms.entity.Search;


public class ModelMapper {
    public static SearchDTO getSearchDTO(Search search) {
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setId(search.getId());
        searchDTO.setEntityType(search.getEntityType());
        searchDTO.setReferenceId(search.getReferenceId());
        searchDTO.setKeyword(search.getKeyword());
        searchDTO.setCreatedAt(search.getCreatedAt());
        searchDTO.setUpdatedAt(search.getUpdatedAt());
        return searchDTO;
    }

    public static Search getSearch(SearchDTO searchDTO) {
        Search search = new Search();
        search.setId(searchDTO.getId());
        search.setEntityType(searchDTO.getEntityType());
        search.setReferenceId(searchDTO.getReferenceId());
        search.setKeyword(searchDTO.getKeyword());
        search.setCreatedAt(searchDTO.getCreatedAt());
        search.setUpdatedAt(searchDTO.getUpdatedAt());
        return search;
    }
}