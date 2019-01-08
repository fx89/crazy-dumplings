package com.crazydumplings.backend.common.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class CrazyDumplingsDefaultHttpResponsesController {
    @GetMapping("")
    @ResponseBody
    public String rootResponse() {
        return "ok";
    }

    @GetMapping("error")
    @ResponseBody
    public String errorResponse() {
        return "error";
    }
}
