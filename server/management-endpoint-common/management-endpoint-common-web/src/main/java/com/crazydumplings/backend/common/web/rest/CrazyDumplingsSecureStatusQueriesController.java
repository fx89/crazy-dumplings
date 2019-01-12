package com.crazydumplings.backend.common.web.rest;

import static com.crazydumplings.backend.utils.SecurityUtils.getCurrentUserId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crazydumplings.backend.security.SecurityService;
import com.crazydumplings.backend.security.model.User;

@Controller
@RequestMapping("/status/secure")
public class CrazyDumplingsSecureStatusQueriesController {

    @Autowired
    private SecurityService securityService;

    @GetMapping("/userDetails")
    @ResponseBody
    public User getUserDetails() {
        return securityService.getUser(getCurrentUserId());
    }
}
