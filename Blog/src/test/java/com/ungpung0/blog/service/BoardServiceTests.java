package com.ungpung0.blog.service;

import com.ungpung0.blog.dto.BoardDTO;
import com.ungpung0.blog.dto.PageRequestDTO;
import com.ungpung0.blog.dto.PageResultDTO;
import com.ungpung0.blog.entity.BoardEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

        boardService.doWrite(boardDTO);
    }

    @Test
    public void pagingListTest() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().pageCurr(1).pageSize(10).build();

        PageResultDTO<BoardDTO, BoardEntity> pageResultDTO = boardService.getList(pageRequestDTO);

        System.out.println("===== PageResultDTO =====");
        System.out.println("PREV : " + pageResultDTO.isPrevious());
        System.out.println("NEXT : " + pageResultDTO.isNext());
        System.out.println("TOTAL : " + pageResultDTO.getPageTotal());

        System.out.println("===== Pages Data =====");
        for(BoardDTO boardDTO : pageResultDTO.getPageDTOList())
            System.out.println(boardDTO);

        System.out.println("===== Pages Index Number =====");
        pageResultDTO.getPageList().forEach(i -> System.out.println(i));
    }

}
