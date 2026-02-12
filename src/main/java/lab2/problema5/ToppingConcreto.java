package lab2.problema5;

class ToppingConcreto extends ToppingDecorator {
	private String nombre;
	private double precio;

	public ToppingConcreto(Cafe cafe, String nombre, double precio) {
		super(cafe);
		this.nombre = nombre;
		this.precio = precio;
	}

	@Override
	public String getDescripcion() { return cafeDecorado.getDescripcion() + " + " + nombre; }
	@Override
	public double getPrecio() { return cafeDecorado.getPrecio() + precio; }
}
