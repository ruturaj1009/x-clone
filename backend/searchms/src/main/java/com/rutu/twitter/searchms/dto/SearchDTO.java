package com.rutu.twitter.searchms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchDTO {

    private Long id;
    private EntityType entityType;
    private Long referenceId;
    private String keyword;
    private Instant createdAt;
    private Instant updatedAt;
}
