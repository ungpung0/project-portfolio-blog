package com.ungpung0.blog.dto;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class PageResultDTO<DTO, ENTITY> {
    private List<DTO> pageDTOList;

    private int pageCurrent;

    private int pageTotal;

    private int pageSize;

    private int indexStart;

    private int indexEnd;

    private boolean previous;

    private boolean next;

    private List<Integer> pageList;

    public PageResultDTO(Page<ENTITY> pageResult, Function<ENTITY, DTO> function) {
        pageDTOList = pageResult.stream().map(function).collect(Collectors.toList());

        pageTotal = pageResult.getTotalPages();

        pagingList(pageResult.getPageable());
    }

    private void pagingList(Pageable pageable) {
        this.pageCurrent = pageable.getPageNumber() + 1;
        int calculate = (int)(Math.ceil(pageCurrent / 10.0)) * 10;

        this.pageSize = pageable.getPageSize();

        indexStart = calculate - 9;

        indexEnd = pageTotal > calculate ? calculate : pageTotal;

        previous = indexStart > 1;

        next = pageTotal > calculate;

        pageList = IntStream.rangeClosed(indexStart, indexEnd).boxed().collect(Collectors.toList());
    }
}
