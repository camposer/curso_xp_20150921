package web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HistoriaUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	// http://localhost:8080/xperience/historia-usuario/mostrar.do
	@RequestMapping("/mostrar")
	public String mostrar(Model model) {
		List<HistoriaUsuario> historiasUsuario =
				historiaUsuarioService.obtenerListadoOrdenadoHistoriasUsuario();
		
		model.addAttribute("historiasUsuario", historiasUsuario);
		
		return "/WEB-INF/jsp/historia-usuario/mostrarHistoriasUsuario.jsp";
	}
	
//	// http://localhost:8080/xperience/historia-usuario/mostrar.do
//		@RequestMapping("/mostrar")
//		public String mostrar(Model model) {
//			List<HistoriaUsuario> historiasUsuario =
//					historiaUsuarioService.obtenerListadoOrdenadoHistoriasUsuario();
//			
//			model.addAttribute("historiasUsuario", historiasUsuario);
//			
//			return "/WEB-INF/jsp/historia-usuario/mostrarHistoriasUsuario.jsp";
//		}




	/**
	 * Mostrar formulario de alta de historia de usuario
	 * @param request
	 * @param response
	 * @return
	 */
	// http://localhost:8080/xperience/historia-usuario/agregar.do
	@RequestMapping("/agregar")
	public String agregar(HttpServletRequest request, HttpServletResponse response) {
		
		return "/WEB-INF/jsp/historia-usuario/agregar.jsp";
	}
	
	/**
	 * Dar de alta de historia de usuario y volver a listado de historias
	 * @param request
	 * @param response
	 * @return
	 */
	// http://localhost:8080/xperience/historia-usuario/agregar.do
	@RequestMapping("/agregarHistoria")
	public String agregarHistoria(HttpServletRequest request, HttpServletResponse response) {
		
		request.getAttribute("");
		
		HistoriaUsuario hu = new HistoriaUsuario();
		
		//historiaUsuarioService.agregarHistoriaUsuario(hu);
		
		return "/WEB-INF/jsp/historia-usuario/index.jsp";
	}
}
