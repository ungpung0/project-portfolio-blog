package com.ungpung0.blog.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@Log4j2
public class BoardController {

    @GetMapping({"/", "/lists"})
    public String lists() {
        log.info("Log: Entering lists Page...");

        return "/board/lists";
    }
}
