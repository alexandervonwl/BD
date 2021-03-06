package com.ACIasiAn3BD.backend_proiect.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class GeneralController {

    @RequestMapping("/")
    public String viewHomePage(Model model){
        return "index";
    }

    @RequestMapping("/companie")
    public String viewCompaniePage(Model model){
        return "companie";
    }
}