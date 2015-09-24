package web.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import model.Actividad;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import service.ActividadService;

@RunWith(MockitoJUnitRunner.class)
public class ActividadControllerTest extends ControllerTest {

	private MockMvc mockMvc;

	private Actividad actividadOrigen;

	private Actividad actividadNoExistente;

	@Mock
	private ActividadService actividadServiceMock;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(
				new ActividadController(actividadServiceMock))

		.build();

		actividadOrigen = new Actividad();
		actividadOrigen.setDescripcion("actividad1");

		actividadNoExistente = new Actividad();
		actividadNoExistente.setId(500);
	}

	@Test
	public void modificarActividad() throws Exception {

		Actividad actividadModificada = new Actividad();
		actividadModificada.setDescripcion("descripcionModificada");

		when(actividadServiceMock.modificarActividad(actividadOrigen))
				.thenReturn(actividadModificada);

		mockMvc.perform(
				post("/actividad/modificar.do").contentType(
						MediaType.APPLICATION_FORM_URLENCODED).sessionAttr(
						"actividadModificar", actividadOrigen))
				.andExpect(status().isOk())
				.andExpect(forwardedUrl("/WEB-INF/jsp/actividad/list.jsp"))
				.andExpect(
						model().attribute(
								"actividadModificada",
								hasProperty("descripcion",
										is("descripcionModificada"))));
		verify(actividadServiceMock, times(1)).modificarActividad(
				actividadOrigen);
		verifyNoMoreInteractions(actividadServiceMock);

	}

	@Test
	public void modificarActividadNoExistente() throws Exception {

		Actividad actividadModificada = new Actividad();
		actividadModificada.setDescripcion("descripcionModificada");

		when(actividadServiceMock.modificarActividad(actividadNoExistente))
				.thenReturn(null);

		mockMvc.perform(
				post("/actividad/modificar.do").contentType(
						MediaType.APPLICATION_FORM_URLENCODED).sessionAttr(
						"actividadModificar", actividadNoExistente))
				.andExpect(status().isOk())
				.andExpect(forwardedUrl("/WEB-INF/jsp/error.jsp"));
		verify(actividadServiceMock, times(1)).modificarActividad(
				actividadNoExistente);
		verifyNoMoreInteractions(actividadServiceMock);

	}

	@Test
	public void mostrarPaginaModificarActividad() throws Exception {
		int id = 23;

		when(actividadServiceMock.obtenerActividad(id)).thenReturn(
				actividadOrigen);

		mockMvc.perform(
				get("/actividad/mostrarModificar").param("id",
						String.valueOf(id)))
				.andExpect(status().isOk())
				.andExpect(
						model().attribute(
								"actividadModificar",
										hasProperty("descripcion", is("actividad1"))
										))
				.andExpect(forwardedUrl("/WEB-INF/jsp/actividad/modificar.jsp"));

		verify(actividadServiceMock, times(1)).obtenerActividad(id);
		verifyNoMoreInteractions(actividadServiceMock);

	}

	@Test
	public void mostrarPaginaModificarActividad_actividadNoExiste()
			throws Exception {
		int id = 24;

		when(actividadServiceMock.obtenerActividad(id)).thenReturn(null);

		mockMvc.perform(
				get("/actividad/mostrarModificar").param("id",
						String.valueOf(id))).andExpect(status().isOk())
				.andExpect(forwardedUrl("/WEB-INF/jsp/error.jsp"));

		verify(actividadServiceMock, times(1)).obtenerActividad(id);
		verifyNoMoreInteractions(actividadServiceMock);

	}

}
