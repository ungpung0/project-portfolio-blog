package com.ungpung0.blog.service;

import com.ungpung0.blog.dto.BoardDTO;
import com.ungpung0.blog.dto.PageRequestDTO;
import com.ungpung0.blog.dto.PageResultDTO;
import com.ungpung0.blog.entity.BoardEntity;
import com.ungpung0.blog.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

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

    @Override
    public PageResultDTO<BoardDTO, BoardEntity> getList(PageRequestDTO pageRequestDTO) {
        Pageable pageable = pageRequestDTO.getPageable(Sort.by("boardId").descending());

        Page<BoardEntity> pagingResult = boardRepository.findAll(pageable);

        Function<BoardEntity, BoardDTO> function = (boardEntity -> entityToDTO(boardEntity));

        return new PageResultDTO<>(pagingResult, function);
    }
}
