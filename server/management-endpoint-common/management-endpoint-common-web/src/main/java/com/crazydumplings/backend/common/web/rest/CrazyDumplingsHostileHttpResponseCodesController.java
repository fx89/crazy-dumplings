package com.crazydumplings.backend.common.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CrazyDumplingsHostileHttpResponseCodesController {

    @RequestMapping(method = RequestMethod.GET, path = "/403")
    public String accessDenied() {
        return "NOT AUTHORIZED";
    }
}
