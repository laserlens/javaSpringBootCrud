package com.astontech.hr.controllers;

import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Adrian.Flak on 6/27/2017.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    String index() {
        return "index";
    }

}