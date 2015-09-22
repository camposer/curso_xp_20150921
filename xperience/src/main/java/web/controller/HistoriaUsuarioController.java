package web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.HistoriaUsuario;
import service.HistoriaUsuarioService;

@Controller
@RequestMapping("/historia-usuario*")
public class HistoriaUsuarioController {
	@Autowired
	private HistoriaUsuarioService historiaUsuarioService;

	// http://localhost:8080/xperience/historia-usuario.do
	@RequestMapping("")
	public String index(Model model) {
		List<HistoriaUsuario> historiasUsuario =
				historiaUsuarioService.obtenerHistoriasUsuario();
		
		model.addAttribute("historiasUsuario", historiasUsuario);
		
		return "/WEB-INF/jsp/historia-usuario/index.jsp";
	}


	// http://localhost:8080/xperience/historia-usuario/agregar.do
	@RequestMapping("/agregar")
	public String agregar() {
		// TODO Implementar!
		return null;
	}
}
