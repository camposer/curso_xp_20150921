package exception;

public class NaturalInvalidoException extends ServiceException {
	private static final long serialVersionUID = 6921533568788442775L;
	private int valor;
	
	public NaturalInvalidoException(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}
