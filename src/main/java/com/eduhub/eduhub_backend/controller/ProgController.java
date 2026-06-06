package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.component.ProgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProgController {
    @Autowired
    ProgService progService;
    public ProgController (ProgService progService){
        this.progService=progService;
    }
    @GetMapping("get-prog")
    public String getProg(){
        return progService.getProg();
    }
}
