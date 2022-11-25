package com.ungpung0.blog.controller;

import com.ungpung0.blog.dto.BoardDTO;
import com.ungpung0.blog.dto.PageRequestDTO;
import com.ungpung0.blog.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Log4j2
public class BoardController {
    private final BoardService boardService;

    @GetMapping({"/"})
    public String goLists() {
        return "redirect:/board/lists";
    }
    @GetMapping("/lists")
    public void getLists(PageRequestDTO pageRequestDTO, Model model) {
        log.info("LOG: Entering lists Page...");

        model.addAttribute("result", boardService.getList(pageRequestDTO));
    }

    @GetMapping("/write")
    public void goWrite() {
        log.info("LOG: Entering Register Page...");
    }

    @PostMapping("/write")
    public String doWrite(BoardDTO boardDTO) {
        log.info("LOG: Insert Board to DB...");

        boardService.doWrite(boardDTO);

        return "redirect:/board/lists";
    }

}
