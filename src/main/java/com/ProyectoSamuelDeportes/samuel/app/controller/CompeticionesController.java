package com.ProyectoSamuelDeportes.samuel.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ProyectoSamuelDeportes.samuel.app.variables.Competiciones;
import com.ProyectoSamuelDeportes.samuel.app.repositorio.CompeticionesRepositorio;

@Controller
@RequestMapping("/verCompeticiones")
public class CompeticionesController {

    @Autowired
    private CompeticionesRepositorio competicionesRepositorio;

    @GetMapping
    public String listarCompeticiones(Model model) {
        List<Competiciones> listaCompeticiones = competicionesRepositorio.findAll();
        model.addAttribute("listaCompeticiones", listaCompeticiones);
        return "verCompeticiones";
    }

    @GetMapping("/formCompeticion")
    public String mostrarFormulario(Model model) {
        model.addAttribute("competicion", new Competiciones());
        return "formCompeticiones";
    }

    @PostMapping("/guardarCompeticion")
    public String guardarCompeticion(@ModelAttribute("competicion") Competiciones competicion) {
        competicionesRepositorio.save(competicion);
        return "redirect:/verCompeticiones";
    }

    @GetMapping("/editar/{id}")
    public String editarCompeticion(@PathVariable("id") Integer id, Model model) {
        Competiciones competicion = competicionesRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Competición inválida: " + id));
        model.addAttribute("competicion", competicion);
        return "formCompeticiones";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCompeticion(@PathVariable("id") Integer id) {
        competicionesRepositorio.deleteById(id);
        return "redirect:/verCompeticiones";
    }
}
