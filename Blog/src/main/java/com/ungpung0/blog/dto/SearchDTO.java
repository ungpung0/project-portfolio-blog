package com.ungpung0.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Builder
@AllArgsConstructor
@Data
public class SearchDTO {

    private int pageCurrent;
    private int pageSize;

    public SearchDTO() {
        this.pageCurrent = 1;
        this.pageSize = 10;
    }

    public Pageable getPageable(Sort sort) {
        return PageRequest.of(pageCurrent - 1, pageSize, sort);
    }

}
