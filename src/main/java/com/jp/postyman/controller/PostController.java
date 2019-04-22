package com.jp.postyman.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class PostController {
    // JUST FOR TESTING
    @RequestMapping(method = RequestMethod.GET, value = "/posts")
    public String string() {
        return "Working.";
    }
}
