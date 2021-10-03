package com.tfalc.cepapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CityCepController {

    @Autowired


    //Loads index.html page
    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

    //GET Method
    @GetMapping
    public void getCityCep(){
        return;
    }

    //POST method
    @PostMapping
    public void SetCityCep() {
        return;
    }

    @PutMapping
    public void updateCityCep(){
        return;
    }

    @DeleteMapping
    public void deleteCityCep(){
        return;
    }

}
