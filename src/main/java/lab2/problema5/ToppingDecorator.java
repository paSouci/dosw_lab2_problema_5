package lab2.problema5;

public abstract class ToppingDecorator implements Cafe {
	protected Cafe cafeDecorado;
	public ToppingDecorator(Cafe cafe) { this.cafeDecorado = cafe; }
}
