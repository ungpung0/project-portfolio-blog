package com.ungpung0.blog.dto;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public class SearchResultDTO {
    private List<SearchDTO> searchDTOList;

    public SearchResultDTO(Page<EN> searchResult, Function<EN, DTO> function) {
        searchDTOList = searchResult.stream().map(function).collect(Collectors.toList());
    }
}
