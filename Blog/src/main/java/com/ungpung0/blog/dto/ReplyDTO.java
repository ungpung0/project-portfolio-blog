package com.ungpung0.blog.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReplyDTO {
    private Long replyId;

    private String replyContent;

    private String replyAuthor;
}
