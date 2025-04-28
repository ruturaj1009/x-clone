package com.rutu.twitter.searchms.repository;

import com.rutu.twitter.searchms.dto.EntityType;
import com.rutu.twitter.searchms.entity.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SearchRepository extends JpaRepository<Search, Long> {

    @Query(value = "SELECT * FROM search_index WHERE MATCH (keyword) AGAINST (:searchTerm IN NATURAL LANGUAGE MODE)", nativeQuery = true)
    List<Search> fullTextSearch(String searchTerm);

    List<Search> findByEntityType(EntityType entityType);

    List<Search> findByReferenceId(Long referenceId);

    List<Search> findByKeywordContainingIgnoreCase(String keyword);
}