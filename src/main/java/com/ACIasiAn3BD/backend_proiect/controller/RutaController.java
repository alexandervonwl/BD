package com.ACIasiAn3BD.backend_proiect.controller;


import com.ACIasiAn3BD.backend_proiect.dao.*;
import com.ACIasiAn3BD.backend_proiect.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RutaController {

    @Autowired
    private RutaDAO rutaDAO;

    @Autowired
    private AvionDAO avionDAO;

    @Autowired
    private AngajatDAO angajatDAO;

    @Autowired
    private BazaDAO bazaDAO;

    @RequestMapping("/companie/ruta")
    public String viewHomePage(Model model){
        List<Ruta> listRuta = rutaDAO.getAll();
        model.addAttribute("listRuta", listRuta);

        return "ruta";
    }

    @RequestMapping("/companie/ruta/nou")
    public String showNewForm(Model model) {
        Ruta_Frontend ruta_frontend = new Ruta_Frontend();
        model.addAttribute("ruta", ruta_frontend);

        List<Avion> listAvion = avionDAO.getAll();
        model.addAttribute("listAvion", listAvion);

        List<Baza> listBaza = bazaDAO.getAll();
        model.addAttribute("listBaza", listBaza);

        List<Angajat> listAngajat = angajatDAO.getAll();
        model.addAttribute("listAngajat", listAngajat);

        return "ruta_nou";
    }

    @RequestMapping(value = "companie/ruta/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("ruta_frontend") Ruta_Frontend ruta_frontend) {

        rutaDAO.save(ruta_frontend);

        return "redirect:/";
    }

    @RequestMapping("companie/ruta/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("ruta_edit");
        Ruta ruta = rutaDAO.get(id);
        /*Avion_Ruta_FK avion_ruta_fk = avion_ruta_dao.getARR(id);
        Ruta_Angajat_FK ruta_angajat_fk = ruta_angajat_dao.getRAR(id);

         */
        mav.addObject("ruta", ruta);

        return mav;
    }

    @RequestMapping(value = "companie/ruta/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("ruta") Ruta ruta) {
        rutaDAO.update(ruta);

        return "redirect:/";
    }

    @RequestMapping("companie/ruta/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        rutaDAO.delete(id);
        return "redirect:/";
    }
}
