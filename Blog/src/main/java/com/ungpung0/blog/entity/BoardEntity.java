package com.ungpung0.blog.entity;

import javax.persistence.*;

@Entity
@Table(name = "BOARD")
public class BoardEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long boardId;

    @Column(name = "BOARD_TITLE")
    private String boardTitle;

    @Column(name = "BOARD_CONTENT")
    private String boardContent;

    @Column(name = "BOARD_AUTHOR")
    private String boardAuthor;

}
