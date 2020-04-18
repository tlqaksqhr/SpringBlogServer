package com.semtax.application.dto;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
public class PagingDTO {

    private Long id;
    private String title;
    private String createdBy;
    private LocalDateTime createdTime;

    public PagingDTO(Long id, String title, String createdBy, LocalDateTime createdTime) {
        this.id = id;
        this.title = title;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
    }
}
