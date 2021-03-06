package com.ACIasiAn3BD.backend_proiect.controller;


import com.ACIasiAn3BD.backend_proiect.dao.AvionDAO;
import com.ACIasiAn3BD.backend_proiect.model.Avion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AvionController {

    @Autowired
    private AvionDAO avionDAO;

    @RequestMapping("/companie/avion")
    public String viewHomePage(Model model){
        List<Avion> listAvion = avionDAO.getAll();
        model.addAttribute("listAvion", listAvion);
        return "avion";
    }

    @RequestMapping("/companie/avion/nou")
    public String showNewForm(Model model) {
        Avion avion = new Avion();
        model.addAttribute("avion", avion);

        return "avion_nou";
    }

    @RequestMapping(value = "companie/avion/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("avion") Avion avion) {

        avionDAO.save(avion);

        return "redirect:/";
    }

    @RequestMapping("companie/avion/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("avion_edit");
        Avion avion = avionDAO.get(id);
        mav.addObject("avion", avion);

        return mav;
    }

    @RequestMapping(value = "companie/avion/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("avion") Avion avion) {
        avionDAO.update(avion);

        return "redirect:/";
    }

    @RequestMapping("companie/avion/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {

        avionDAO.delete(id);
        return "redirect:/";
    }
}
