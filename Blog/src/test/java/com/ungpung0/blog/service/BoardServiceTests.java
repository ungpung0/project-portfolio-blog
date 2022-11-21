package com.ungpung0.blog.service;

import com.ungpung0.blog.dto.BoardDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void registerTest() {
        BoardDTO boardDTO = BoardDTO.builder()
                .boardTitle("Dummy Title26")
                .boardContent("Dummy Content26")
                .boardAuthor("Dummy Author")
                .build();

        boardService.register(boardDTO);
    }

}
