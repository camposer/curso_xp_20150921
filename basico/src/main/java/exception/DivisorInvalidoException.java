package exception;

public class DivisorInvalidoException extends ServiceException {
	private static final long serialVersionUID = 7365851178915094546L;
	private int divisor;
	
	public DivisorInvalidoException(int divisor) {
		this.divisor = divisor;
	}

	public int getDivisor() {
		return divisor;
	}

	public void setDivisor(int divisor) {
		this.divisor = divisor;
	}}
