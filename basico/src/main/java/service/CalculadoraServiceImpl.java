package service;

import exception.DivisorInvalidoException;
import exception.NaturalInvalidoException;
import exception.ResultadoInvalidoException;
import exception.SustraendoInvalidoException;

public class CalculadoraServiceImpl implements CalculadoraService {

	@Override
	public int sumar(int a, int b) {
		validarNatutal(a);
		validarNatutal(b);
		
		long c = (long)a + b;
		if (c > Integer.MAX_VALUE)
			throw new ResultadoInvalidoException();
		
		return (int)c;
	}

	private void validarNatutal(int a) {
		if (a < 0)
			throw new NaturalInvalidoException(a);
	}

	@Override
	public int restar(int a, int b) {
		validarNatutal(a);
		validarNatutal(b);
		
		if (a < b)
			throw new SustraendoInvalidoException(b);
		
		return a - b;
	}

	@Override
	public int multiplicar(int a, int b) {
		validarNatutal(a);
		validarNatutal(b);
		
		long c = (long)a * b;
		if (c > Integer.MAX_VALUE)
			throw new ResultadoInvalidoException();
		
		return (int)c;
	}

	@Override
	public int dividir(int a, int b) {
		validarNatutal(a);
		validarNatutal(b);
		
		if (b == 0)
			throw new DivisorInvalidoException(b);
		
		if (a % b != 0)
			throw new ResultadoInvalidoException();
		
		return a / b;
	}

}








