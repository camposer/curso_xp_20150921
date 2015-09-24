package web.controller;

import java.util.ArrayList;
import java.util.List;

import model.Actividad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import service.ActividadService;

@Controller
@RequestMapping("/actividad*")

@SessionAttributes("actividadModificar")
public class ActividadController {
	
	private final ActividadService actividadService;

	@Autowired
	public ActividadController(ActividadService actividadService) {
		this.actividadService = actividadService;
	}
	
	@RequestMapping(value="mostrarModificar", method= RequestMethod.GET)
	public String cargarModificarActividad(@RequestParam("id") String id, Model model){
		
		Actividad actividadModificada = actividadService.obtenerActividad(Integer.valueOf(id).intValue());
		if(actividadModificada == null)
			return "/WEB-INF/jsp/error.jsp";
		
		model.addAttribute("actividadModificar", actividadModificada);
		List<Integer> lista = new ArrayList<Integer>();
		lista.add(1);
		lista.add(2);
		model.addAttribute("listaUsuarios",lista);
		
		
		List<Short> estados = new ArrayList<Short>();
		estados.add((short)1);
		estados.add((short)2);
		estados.add((short)3);
		estados.add((short)4);
	
		model.addAttribute("estados", estados);
		
		return "/WEB-INF/jsp/actividad/modificar.jsp";
	}

	@RequestMapping(value = "modificar", method = RequestMethod.POST)
	public String modificarActividad(@ModelAttribute("actividadModificar") Actividad actividad, Model model) {
		
		Actividad actividadModificada = actividadService.modificarActividad(actividad);
		if(actividadModificada == null)
			return "/WEB-INF/jsp/error.jsp";
		
		model.addAttribute("actividadModificada", actividadModificada);
		return "/WEB-INF/jsp/actividad/list.jsp";
	}
	
	// http://localhost:8080/xperience/actividad/crear-actividad.do
	@RequestMapping("crear")
	public String agregar(@ModelAttribute Actividad actividad) {
		System.out.println(actividad.getTitulo());
		if (actividad.getTitulo().length()!=0) {
			actividadService.agregarActividad(actividad);
		}
		return "/WEB-INF/jsp/actividad/crear.jsp";
	}
	
	
}
