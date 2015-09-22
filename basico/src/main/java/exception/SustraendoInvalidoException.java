package exception;

public class SustraendoInvalidoException extends ServiceException {
	private static final long serialVersionUID = 2648029568073850569L;
	private int sustraendo;
	
	public SustraendoInvalidoException(int sustraendo) {
		this.sustraendo = sustraendo;
	}

	public int getSustraendo() {
		return sustraendo;
	}

	public void setSustraendo(int sustraendo) {
		this.sustraendo = sustraendo;
	}
}
