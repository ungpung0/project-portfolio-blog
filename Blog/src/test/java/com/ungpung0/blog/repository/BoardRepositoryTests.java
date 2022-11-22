package com.ungpung0.blog.repository;

import com.ungpung0.blog.dto.BoardDTO;
import com.ungpung0.blog.dto.PageRequestDTO;
import com.ungpung0.blog.dto.PageResultDTO;
import com.ungpung0.blog.entity.BoardEntity;
import com.ungpung0.blog.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

@SpringBootTest
public class BoardRepositoryTests {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardService boardService;

    @Test
    @Transactional
    @Commit
    public void insertBoard() {
        IntStream.rangeClosed(1, 25).forEach(i -> {
            BoardEntity board = BoardEntity.builder()
                    .boardTitle("Dummy Title" + i)
                    .boardContent("Dummy Content" + i)
                    .boardAuthor("Dummy Author")
                    .build();

            boardRepository.save(board);
        });
    }

    @Test
    public void pagingTest() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().pageCurr(1).pageSize(10).build();

        PageResultDTO<BoardDTO, BoardEntity> pageResultDTO = boardService.getList(pageRequestDTO);

        for(BoardDTO boardDTO : pageResultDTO.getPageDTOList()) {
            System.out.println(boardDTO);
        }
    }
}
