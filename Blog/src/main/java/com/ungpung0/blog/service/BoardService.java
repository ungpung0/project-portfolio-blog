package com.ungpung0.blog.service;

import com.ungpung0.blog.dto.BoardDTO;
import com.ungpung0.blog.dto.PageRequestDTO;
import com.ungpung0.blog.dto.PageResultDTO;
import com.ungpung0.blog.entity.BoardEntity;

public interface BoardService {
    void doWrite(BoardDTO boardDTO);

    PageResultDTO<BoardDTO, BoardEntity> getList(PageRequestDTO pageRequestDTO);
    default BoardEntity dtoToEntity(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.builder()
                .boardId(boardDTO.getBoardId())
                .boardTitle(boardDTO.getBoardTitle())
                .boardContent(boardDTO.getBoardContent())
                .boardAuthor(boardDTO.getBoardAuthor())
                .build();

        return boardEntity;
    }

    default BoardDTO entityToDTO(BoardEntity boardEntity) {
        BoardDTO boardDTO = BoardDTO.builder()
                .boardId(boardEntity.getBoardId())
                .boardTitle(boardEntity.getBoardTitle())
                .boardContent(boardEntity.getBoardContent())
                .boardAuthor(boardEntity.getBoardAuthor())
                .createdDate(boardEntity.getCreatedDate())
                .modifiedDate(boardEntity.getModifiedDate())
                .build();

        return boardDTO;
    }
}
