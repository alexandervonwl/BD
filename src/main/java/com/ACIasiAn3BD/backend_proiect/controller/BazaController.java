package com.ACIasiAn3BD.backend_proiect.controller;


import com.ACIasiAn3BD.backend_proiect.dao.BazaDAO;
import com.ACIasiAn3BD.backend_proiect.model.Baza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BazaController {

    @Autowired
    private BazaDAO bazaDAO;

    @RequestMapping("/companie/baza")
    public String viewHomePage(Model model){
        List<Baza> listBaza = bazaDAO.getAll();
        model.addAttribute("listBaza", listBaza);
        return "baza";
    }

    @RequestMapping("/companie/baza/nou")
    public String showNewForm(Model model) {
        Baza baza = new Baza();
        model.addAttribute("baza", baza);

        return "baza_nou";
    }

    @RequestMapping(value = "/companie/baza/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("baza") Baza baza) {

        bazaDAO.save(baza);

        return "redirect:/";
    }

    @RequestMapping("/companie/baza/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") String nume) {
        ModelAndView mav = new ModelAndView("baza_edit");
        Baza baza = bazaDAO.get(nume);
        mav.addObject("baza", baza);

        return mav;
    }

    @RequestMapping(value = "/companie/baza/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("baza") Baza baza) {
        bazaDAO.update(baza);

        return "redirect:/";
    }

    @RequestMapping("/companie/baza/delete/{id}")
    public String delete(@PathVariable(name = "id") String nume) {
        bazaDAO.delete(nume);
        return "redirect:/";
    }
}