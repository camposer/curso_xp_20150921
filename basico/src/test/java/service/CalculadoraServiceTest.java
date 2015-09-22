package service;

import org.junit.Assert;
import org.junit.Test;

import exception.DivisorInvalidoException;
import exception.NaturalInvalidoException;
import exception.ResultadoInvalidoException;
import exception.SustraendoInvalidoException;

public class CalculadoraServiceTest {
	private CalculadoraService calculadoraService;
	
	public CalculadoraServiceTest() {
		calculadoraService = CalculadoraServiceFactory.createCalculadoraService();
	}
	
	@Test
	public void sumar() {
		Assert.assertEquals(4, calculadoraService.sumar(2, 2));
	}

	@Test(expected = NaturalInvalidoException.class)
	public void enteroInvalido() {
		calculadoraService.sumar(-2, 2);
	}

	@Test(expected = ResultadoInvalidoException.class)
	public void sumarResultadoInvalido() {
		calculadoraService.sumar(Integer.MAX_VALUE, 1);
	}

	@Test
	public void restar() {
		Assert.assertEquals(0, calculadoraService.restar(2, 2));
	}

	@Test(expected = SustraendoInvalidoException.class)
	public void restarSustraendoInvalido() {
		calculadoraService.restar(2, 3);
	}

	@Test
	public void multiplicar() {
		Assert.assertEquals(6, calculadoraService.multiplicar(3, 2));
	}

	@Test(expected = ResultadoInvalidoException.class)
	public void multiplicarResultadoInvalido() {
		calculadoraService.multiplicar(Integer.MAX_VALUE, 2);
	}

	@Test
	public void dividir() {
		Assert.assertEquals(1, calculadoraService.dividir(2, 2));
	}

	@Test(expected = DivisorInvalidoException.class)
	public void dividirDivisorInvalido() {
		calculadoraService.dividir(2, 0);
	}

	@Test(expected = ResultadoInvalidoException.class)
	public void dividirResultadoInvalido() {
		calculadoraService.dividir(3, 2);
	}
}






