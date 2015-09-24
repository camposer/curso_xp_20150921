package service;

import java.util.List;

import model.HistoriaUsuario;

public interface HistoriaUsuarioService {

	List<HistoriaUsuario> obtenerHistoriasUsuario();
	
	List<HistoriaUsuario> obtenerListadoOrdenadoHistoriasUsuario();
	
	List<HistoriaUsuario> cambiarOrdenHistoriasUsuario(int ordenAnt, int OrderNuevo);

}
