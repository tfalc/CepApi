package com.tfalc.cepapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CityCepController {

    @Autowired
    private CityCep cityCep;

    //Loads index.html page
    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

    //GET Method
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView ListCep() {
        ModelAndView modelAndView = new ModelAndView("lista-cep.html");
        modelAndView.addObject("City", cityCep.findAll());
    }

    //POST method
    @RequestMapping(method = RequestMethod.POST)
    public void SetCityCep() {

    }

}
