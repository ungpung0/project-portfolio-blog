package com.ungpung0.blog.service;

import com.ungpung0.blog.dto.BoardDTO;
import com.ungpung0.blog.entity.BoardEntity;
import com.ungpung0.blog.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImplement implements BoardService {
    private final BoardRepository boardRepository;
    @Override
    public void register(BoardDTO boardDTO) {
        BoardEntity boardEntity = dtoToEntity(boardDTO);

        boardRepository.save(boardEntity);

        log.info("LOG: Register Succeed");
    }
}
