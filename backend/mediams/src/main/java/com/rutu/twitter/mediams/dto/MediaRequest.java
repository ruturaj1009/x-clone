package com.rutu.twitter.mediams.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediaRequest {
    @NotNull(message = "user id can not be null")
    private Long userId;
    @NotNull(message = "media type can not be null")
    private MediaType mediaType;
}
