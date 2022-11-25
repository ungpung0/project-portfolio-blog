package com.ungpung0.blog.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDTO {
    private Long boardId;

    private String boardTitle;

    private String boardContent;

    private String boardAuthor;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;
}
