	package com.ProyectoSamuelDeportes.samuel.app.controller;
	
	import java.util.List;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	
	import com.ProyectoSamuelDeportes.samuel.app.variables.Asociacion;
	import com.ProyectoSamuelDeportes.samuel.app.variables.Club;
	import com.ProyectoSamuelDeportes.samuel.app.variables.Competiciones;
	import com.ProyectoSamuelDeportes.samuel.app.variables.Entrenadores;
	import com.ProyectoSamuelDeportes.samuel.app.variables.Jugadores;
	import com.ProyectoSamuelDeportes.samuel.app.repositorio.AsociacionRepositorio;
	import com.ProyectoSamuelDeportes.samuel.app.repositorio.ClubRepositorio;
	import com.ProyectoSamuelDeportes.samuel.app.repositorio.CompeticionesRepositorio;
	import com.ProyectoSamuelDeportes.samuel.app.repositorio.EntrenadoresRepositorio;
	import com.ProyectoSamuelDeportes.samuel.app.repositorio.JugadoresRepositorio;
	
	@Controller
	public class ClubController {
	
	    @Autowired
	    private ClubRepositorio clubRepositorio;
	
	    @Autowired
	    private EntrenadoresRepositorio entrenadoresRepositorio;
	
	    @Autowired
	    private AsociacionRepositorio asociacionRepositorio;
	
	    @Autowired
	    private CompeticionesRepositorio competicionesRepositorio;
	
	    @Autowired
	    private JugadoresRepositorio jugadoresRepositorio;
	
	    @GetMapping({ "/verClub", "/mostrarclub", "/listarclub" })
	    public String listarClub(Model model) {
	        List<Club> listaClub = clubRepositorio.findAll();
	        model.addAttribute("listaClub", listaClub);
	
	        return "verClub";
	    }
	
	    @GetMapping("/verClub/formClub")
	    public String mostrarFormulario(Model model) {
	        model.addAttribute("club", new Club());
	
	        List<Entrenadores> listaEntrenadores = entrenadoresRepositorio.findAll();
	        model.addAttribute("listaEntrenadores", listaEntrenadores);
	
	        List<Jugadores> listaJugadores = jugadoresRepositorio.findAll();
	        model.addAttribute("listaJugadores", listaJugadores);
	
	        List<Asociacion> listaAsociacion = asociacionRepositorio.findAll();
	        model.addAttribute("listaAsociacion", listaAsociacion);
	
	        List<Competiciones> listaCompeticiones = competicionesRepositorio.findAll();
	        model.addAttribute("listaCompeticiones", listaCompeticiones);
	
	        return "formClub";
	    }
	
	    @PostMapping("/guardarClub")
	    public String guardarClub(@ModelAttribute("club") Club club) {
	        clubRepositorio.save(club);
	        return "redirect:/verClub";
	    }
	    
	    @GetMapping("/club/editar/{id}")
	    public String modificarClub(@PathVariable("id") Integer id, Model model) {
	        Club club = clubRepositorio.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid club Id:" + id));
	        model.addAttribute("club", club);
	
	        List<Entrenadores> listaEntrenadores = entrenadoresRepositorio.findAll();
	        model.addAttribute("listaEntrenadores", listaEntrenadores);
	
	        List<Jugadores> listaJugadores = jugadoresRepositorio.findAll();
	        model.addAttribute("listaJugadores", listaJugadores);
	
	        List<Asociacion> listaAsociacion = asociacionRepositorio.findAll();
	        model.addAttribute("listaAsociacion", listaAsociacion);
	
	        List<Competiciones> listaCompeticiones = competicionesRepositorio.findAll();
	        model.addAttribute("listaCompeticiones", listaCompeticiones);
	
	        return "formClub";
	    }
	
	    @GetMapping("/club/eliminar/{id}")
	    public String eliminarClub(@PathVariable("id") Integer id) {
	        clubRepositorio.deleteById(id);
	        return "redirect:/verClub";
	    }
	
	}
