package web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.HistoriaUsuario;
import model.Sprint;
import service.HistoriaUsuarioService;
import service.SprintService;

@Controller
@RequestMapping("/sprint*")
public class SprintController {
	@Autowired
	private SprintService sprintService;

	// http://localhost:8080/xperience/sprint.do
	@RequestMapping("")
	public String index(Model model) {
		List<Sprint> sprints =
				sprintService.obtenerSprints();
		
		model.addAttribute("sprint", sprints);
		
		return "/WEB-INF/jsp/sprint/index.jsp";
	}


	// http://localhost:8080/xperience/sprint/agregar.do
	@RequestMapping("/agregar")
	public String agregar() {
		// TODO Implementar!
		return null;
	}
	
	// http://localhost:8080/xperience/sprint/listarActividades.do
	@RequestMapping("/listarActividades")
	public String listarActividades(@RequestParam int idSprint) {
		Sprint sprint =
				sprintService.obtenerSprintById(idSprint);
		
		//sprint.
		
		//model.addAttribute("historiasUsuario", historiasUsuario);

		
		return "/WEB-INF/jsp/historia-usuario/ListarActividades.jsp";
	}
	
	// http://localhost:8080/xperience/sprint/details.do?sprintId=1
	@RequestMapping("/details")
	public String sprintDetail (Model model, @RequestParam("sprintId") int sprintId) {
		
		Sprint sprint = sprintService.obtenerSprintById(sprintId);
		
		model.addAttribute("sprintDetail", sprint);
		
		return "/WEB-INF/jsp/sprint/sprintDetail.jsp";
	}
	
}
