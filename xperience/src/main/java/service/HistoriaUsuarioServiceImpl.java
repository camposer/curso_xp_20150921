package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import model.HistoriaUsuario;
import repository.HistoriaUsuarioRepository;

@Service
public class HistoriaUsuarioServiceImpl implements HistoriaUsuarioService {
	@Autowired
	private HistoriaUsuarioRepository historiaUsuarioRepository; 

	@Override
	public List<HistoriaUsuario> obtenerHistoriasUsuario() {
		return historiaUsuarioRepository.findAll();
	}

	@Override
	public List<HistoriaUsuario> obtenerListadoOrdenadoHistoriasUsuario() {
		Sort sort = new Sort(Sort.Direction.ASC,"orden");
		return historiaUsuarioRepository.findAll(sort);
		//return historiaUsuarioRepository.findAll();
	}

	@Override
	public List<HistoriaUsuario> cambiarOrdenHistoriasUsuario(int ordenAnt,
			int OrdenNuevo) {
		List<HistoriaUsuario> list = obtenerListadoOrdenadoHistoriasUsuario();
		HistoriaUsuario huToMove = list.get(ordenAnt);
		huToMove.setOrden(OrdenNuevo);
		List<HistoriaUsuario> listAux = new ArrayList();
		HistoriaUsuario huAux=null;
		for (int i = 0; i < list.size(); i++) {
			huAux = list.get(i);
			int ordenaux=huAux.getOrden();
			if (huAux!=huToMove){
				if (i == OrdenNuevo -1) {
					listAux.add (huToMove);
					listAux.add (huAux);
				}else {
					huAux.setOrden(ordenaux++);
					listAux.add(huAux);
				}
			}
			
		}
		return listAux;
	}

}
