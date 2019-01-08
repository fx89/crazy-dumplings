package com.crazydumplings.backend.common.web.rest;

import static com.crazydumplings.backend.utils.SecurityUtils.getCurrentUserId;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Allows callers to make queries for status-related information that can be accessed without having to be logged in. This kind of information
 * is considered to be open information, as opposed to secure information. An example of such open information would be whether or not the
 * current user is logged in (i.e. has a user id). <br />
 * <br />
 * See also: {@link com.crazydumplings.backend.common.web.rest.CrazyDumplingsSecureStatusQueriesController}
 */
@Controller
@RequestMapping("/status/open")
public class CrazyDumplingsOpenStatusQueriesController {

    @GetMapping("/userid")
    @ResponseBody
    public Long getUserId() {
        try {
            return getCurrentUserId();
        } catch (Exception exc) {
            return -1L;
        }
    }
}
