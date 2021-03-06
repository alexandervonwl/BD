package com.ACIasiAn3BD.backend_proiect.controller;


import com.ACIasiAn3BD.backend_proiect.dao.AvionDAO;
import com.ACIasiAn3BD.backend_proiect.dao.BazaDAO;
import com.ACIasiAn3BD.backend_proiect.dao.RutaDAO;
import com.ACIasiAn3BD.backend_proiect.dao.ZborDAO;
import com.ACIasiAn3BD.backend_proiect.model.Avion;
import com.ACIasiAn3BD.backend_proiect.model.Baza;
import com.ACIasiAn3BD.backend_proiect.model.Ruta;
import com.ACIasiAn3BD.backend_proiect.model.Zbor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ZborController {

    @Autowired
    private ZborDAO zborDAO;

    @Autowired
    private RutaDAO rutaDAO;

    @Autowired
    private AvionDAO avionDAO;

    @Autowired
    private BazaDAO bazaDAO;

    @RequestMapping("/client")
    public String viewClientPage(Model model){
        List<Zbor> listZbor = zborDAO.getAll();
        model.addAttribute("listZbor", listZbor);
        return "client";
    }

    @RequestMapping("/companie/zbor")
    public String viewZborPage(Model model){
        List<Zbor> listZbor = zborDAO.getAll();
        //List<String> listOraseDecolare =  zborDAO.getOraseDecolare();
        model.addAttribute("listZbor", listZbor);
        //model.addAttribute("listOraseDecolare", listOraseDecolare);
        return "zbor";
    }

    @RequestMapping("/companie/zbor/nou")
    public String showNewForm(Model model) {
        Zbor zbor = new Zbor();
        model.addAttribute("zbor", zbor);

        List<Ruta> listRuta = rutaDAO.getAll();
        model.addAttribute("listRuta", listRuta);

        List<Avion> listAvion = avionDAO.getAll();
        model.addAttribute("listAvion", listAvion);

        List<Baza> listBaza = bazaDAO.getAll();
        model.addAttribute("listBaza", listBaza);

        return "zbor_nou";
    }

    @RequestMapping(value = "companie/zbor/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("zbor") Zbor zbor) {

        zborDAO.save(zbor);

        return "redirect:/";
    }

    @RequestMapping("companie/zbor/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("zbor_edit");
        Zbor zbor = zborDAO.get(id);
        mav.addObject("zbor", zbor);

        List<Ruta> listRuta = rutaDAO.getAll();
        mav.addObject("listRuta", listRuta);

        List<Avion> listAvion = avionDAO.getAll();
        mav.addObject("listAvion", listAvion);

        List<Baza> listBaza = bazaDAO.getAll();
        mav.addObject("listBaza", listBaza);

        return mav;
    }

    @RequestMapping(value = "companie/zbor/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("zbor") Zbor zbor) {
        zborDAO.update(zbor);

        return "redirect:/";
    }

    @RequestMapping("companie/zbor/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        zborDAO.delete(id);
        return "redirect:/";
    }
}
