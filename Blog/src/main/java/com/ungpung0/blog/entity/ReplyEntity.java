package com.ungpung0.blog.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "REPLY")
public class ReplyEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REPLY_ID")
    private Long replyId;

    @Column(name = "REPLY_CONTENT")
    private String replyContent;

    @Column(name = "REPLY_AUTHOR")
    private String replyAuthor;

    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private BoardEntity board;
}
