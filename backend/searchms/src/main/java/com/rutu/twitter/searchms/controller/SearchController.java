package com.rutu.twitter.searchms.controller;

import com.rutu.twitter.searchms.dto.EntityType;
import com.rutu.twitter.searchms.dto.SearchDTO;
import com.rutu.twitter.searchms.exception.BaseException;
import com.rutu.twitter.searchms.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchService searchService;

    @PostMapping
    public ResponseEntity<SearchDTO> createSearchIndex(@RequestBody SearchDTO searchDTO) {
        return ResponseEntity.ok(searchService.createSearch(searchDTO));
    }

    @PostMapping("/index")
    public ResponseEntity<SearchDTO> indexEntity(@RequestParam EntityType entityType,
                                                    @RequestParam Long referenceId,
                                                    @RequestParam String keyword) {
        return ResponseEntity.ok(searchService.saveSearchEntry(entityType, referenceId, keyword));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SearchDTO> getSearchIndexById(@PathVariable Long id) throws BaseException {
        SearchDTO searchDTO = searchService.getSearchById(id);
        if (searchDTO != null) {
            return ResponseEntity.ok(searchDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/entity-type/{entityType}")
    public ResponseEntity<List<SearchDTO>> getSearchIndicesByEntityType(@PathVariable EntityType entityType) {
        return ResponseEntity.ok(searchService.getSearchByEntityType(entityType));
    }

    @GetMapping("/reference-id/{referenceId}")
    public ResponseEntity<List<SearchDTO>> getSearchIndicesByReferenceId(@PathVariable Long referenceId) {
        return ResponseEntity.ok(searchService.getSearchByReferenceId(referenceId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SearchDTO> updateSearchIndex(@PathVariable Long id, @RequestBody SearchDTO searchDTO) {
        SearchDTO updatedSearchDTO = searchService.updateSearch(id, searchDTO);
        if (updatedSearchDTO != null) {
            return ResponseEntity.ok(updatedSearchDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSearchIndex(@PathVariable Long id) {
        searchService.deleteSearch(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/{searchTerm}")
    public ResponseEntity<List<SearchDTO>> fullTextSearch(@PathVariable String searchTerm) {
        return ResponseEntity.ok(searchService.fullTextSearch(searchTerm));
    }
}
