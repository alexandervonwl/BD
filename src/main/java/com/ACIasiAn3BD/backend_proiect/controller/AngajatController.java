package com.ACIasiAn3BD.backend_proiect.controller;


import com.ACIasiAn3BD.backend_proiect.dao.AngajatDAO;
import com.ACIasiAn3BD.backend_proiect.model.Angajat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AngajatController {

    @Autowired
    private AngajatDAO angajatDAO;

    @RequestMapping("/companie/angajat")
    public String viewHomePage(Model model){
        List<Angajat> listAngajat = angajatDAO.getAll();

        model.addAttribute("listAngajat", listAngajat);
        return "angajat";
    }

    @RequestMapping("/companie/angajat/nou")
    public String showNewForm(Model model) {
        Angajat angajat = new Angajat();
        model.addAttribute("angajat", angajat);

        return "angajat_nou";
    }

    @RequestMapping(value = "/companie/angajat/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("angajat") Angajat angajat) {

        angajatDAO.save(angajat);

        return "redirect:/";
    }

    @RequestMapping("/companie/angajat/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("angajat_edit");
        Angajat angajat = angajatDAO.get(id);
        mav.addObject("angajat", angajat);

        return mav;
    }

    @RequestMapping(value = "/companie/angajat/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("angajat") Angajat angajat) {
        angajatDAO.update(angajat);

        return "redirect:/";
    }

    @RequestMapping("companie/angajat/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        angajatDAO.delete(id);
        return "redirect:/";
    }
}
