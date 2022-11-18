package com.ungpung0.blog.repository;

import com.ungpung0.blog.entity.BoardEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

@SpringBootTest
public class BoardRepositoryTests {
    @Autowired
    private BoardRepository boardRepository;

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
}
