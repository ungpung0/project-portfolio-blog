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
public class PageRequestDTO {
    private int pageCurr;

    private int pageSize;

    public PageRequestDTO() {
        this.pageCurr = 1;
        this.pageSize = 10;
    }

    public Pageable getPageable(Sort sort) {
        return PageRequest.of(pageCurr - 1, pageSize, sort.descending());
    }
}
