package com.cookmates.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePagination {
    private boolean status;
    private String message;
    private int totalPages;
    private int totalElements;
    private Object data;

}
