package com.budymann.example.aspectorientedprogramming.controller;

import com.budymann.example.aspectorientedprogramming.service.PrototypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    PrototypeService prototypeService;

    @RequestMapping(value={"/message"})
    @ResponseBody
    public String getMessage(){
        prototypeService.printMyName("Icecold");
        return "Sent mock event";
    }
}
