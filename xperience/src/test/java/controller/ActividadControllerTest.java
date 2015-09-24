package controller;

import static org.junit.Assert.*;

import java.net.URI;
import java.util.List;

import model.Actividad;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.mock.http.client.MockClientHttpRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.samples.context.WebContextLoader;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import repository.ActividadRepository;
import service.ActividadService;
import config.DatabaseConfig;
import config.PropertyConfig;
import web.controller.ActividadController;

import javax.annotation.Resource;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:mvc-servlet.xml" } )
@ActiveProfiles("test")
//@ContextConfiguration(loader = WebContextLoader.class, classes = {ExampleApplicationContext.class})
//@ContextConfiguration(loader = WebContextLoader.class, locations = {"classpath:exampleApplicationContext.xml"})
public class ActividadControllerTest {
 
	@Autowired
	private ActividadService actividadService;
	
    @Autowired
    private WebApplicationContext webAppContext;
 
    private MockMvc mockMvc;
 
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
    }
 
    //Add tests here
    @Test
    public void agregarActividad() {
    	try {
    		MockHttpServletRequestBuilder get = MockMvcRequestBuilders.get("/actividad/crear");
			ResultActions result = mockMvc.perform(get);
			result.andExpect(MockMvcResultMatchers.status().isOk());
			
    		MockHttpServletRequestBuilder post = MockMvcRequestBuilders.post("/actividad/crear");
    		post.param("titulo", "Primera actividad");
    		post.param("descripcion", "Actividad importante que hay que realizar");
    		post.param("esfuerzo", "5");
    		post.param("prioridad", "2");
    		post.param("estatus", "0");
    		post.param("historiausuarioid", "0");
    		post.param("usuarioid", "0");
			result = mockMvc.perform(post);
			result.andExpect(MockMvcResultMatchers.status().isOk());
			
			List<Actividad> actividades = actividadService.obtenerActividades();
			assertEquals(1, actividades.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}