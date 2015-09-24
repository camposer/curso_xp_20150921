package web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Proyecto;
import service.ProyectoService;

@Controller
@RequestMapping("/Proyecto*")
public class ProyectoController {
	@Autowired
	private ProyectoService ProyectoService;

	// http://localhost:8080/xperience/historia-usuario.do
	@RequestMapping("")
	public String index(Model model) {
		List<Proyecto> historiasUsuario =
				ProyectoService.obtenerProyecto();
		
		model.addAttribute("Proyecto", historiasUsuario);
		
		return "/WEB-INF/jsp/Proyecto/index.jsp";
	}


	// http://localhost:8080/xperience/historia-usuario/agregar.do
	@RequestMapping("/agregar")
	public String agregar() {
		// TODO Implementar!
		return null;
	}
}
