package com.ACIasiAn3BD.backend_proiect.controller;


import com.ACIasiAn3BD.backend_proiect.dao.AngajatDAO;
import com.ACIasiAn3BD.backend_proiect.dao.EchipajDAO;
import com.ACIasiAn3BD.backend_proiect.dao.ZborDAO;
import com.ACIasiAn3BD.backend_proiect.model.Angajat;
import com.ACIasiAn3BD.backend_proiect.model.Echipaj;
import com.ACIasiAn3BD.backend_proiect.model.Ruta;
import com.ACIasiAn3BD.backend_proiect.model.Zbor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EchipajController {

    @Autowired
    private EchipajDAO echipajDAO;

    @Autowired
    private AngajatDAO angajatDAO;

    @Autowired
    private ZborDAO zborDAO;

    @RequestMapping("/companie/echipaj")
    public String viewHomePage(Model model){
        List<Echipaj> listEchipaj = echipajDAO.getAll();
        model.addAttribute("listEchipaj", listEchipaj);
        return "echipaj";
    }

    @RequestMapping("/companie/echipaj/nou")
    public String showNewForm(Model model) {
        Echipaj echipaj = new Echipaj();
        model.addAttribute("echipaj", echipaj);

        List<Angajat> listPilot = angajatDAO.getP();
        model.addAttribute("listPilot", listPilot);

        List<Angajat> listCoPilot = angajatDAO.getCP();
        model.addAttribute("listCoPilot", listCoPilot);

        List<Angajat> listSteward = angajatDAO.getS();
        model.addAttribute("listSteward", listSteward);

        List<Zbor> listZbor = zborDAO.getAll();
        model.addAttribute("listZbor", listZbor);

        return "echipaj_nou";
    }

    @RequestMapping(value = "/companie/echipaj/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("echipaj") Echipaj echipaj) {

        echipajDAO.save(echipaj);

        return "redirect:/";
    }

    @RequestMapping("/companie/echipaj/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("echipaj_edit");
        Echipaj echipaj = echipajDAO.get(id);
        mav.addObject("echipaj", echipaj);

        List<Angajat> listPilot = angajatDAO.getP();
        mav.addObject("listPilot", listPilot);

        List<Angajat> listCoPilot = angajatDAO.getCP();
        mav.addObject("listCoPilot", listCoPilot);

        List<Angajat> listSteward = angajatDAO.getS();
        mav.addObject("listSteward", listSteward);

        List<Zbor> listZbor = zborDAO.getAll();
        mav.addObject("listZbor", listZbor);


        return mav;
    }

    @RequestMapping(value = "/companie/echipaj/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("echipaj") Echipaj echipaj) {
        echipajDAO.update(echipaj);

        return "redirect:/";
    }

    @RequestMapping("/companie/echipaj/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        echipajDAO.delete(id);
        return "redirect:/";
    }
}