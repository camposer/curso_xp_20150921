package configTest;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import service.ActividadService;

@Configuration
public class TestContext {
	
	@Bean
    public ActividadService todoService() {
        return Mockito.mock(ActividadService.class);
    }

}
