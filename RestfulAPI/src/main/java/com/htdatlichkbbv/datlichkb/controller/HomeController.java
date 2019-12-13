package com.htdatlichkbbv.datlichkb.controller;

import com.htdatlichkbbv.datlichkb.utils.Constant;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Constant.URL_INDEX)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HomeController {

    @GetMapping(value = "")
    public String home() {
        return "home";
    }
}
