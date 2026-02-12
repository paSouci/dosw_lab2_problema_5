package lab2.problema5;

import java.util.*;
import java.util.stream.Collectors;

public class App {
	private static void test () {
		Scanner sc = new Scanner(System.in);
		List<Cafe> pedidoTotal = new ArrayList<>();

		Map<Integer, String> nombres = Map.of(1, "Leche", 2, "Chocolate", 3, "Caramelo", 4, "Crema Batida", 5, "Menta");
		Map<Integer, Double> precios = Map.of(1, 1000.0, 2, 1500.0, 3, 1200.0, 4, 2000.0, 5, 1300.0);

		System.out.print("Número de cafés: ");
		int numCafes = sc.nextInt();

		for (int i = 1; i <= numCafes; i++) {
			Cafe miCafe = new CafeBase();
			System.out.println("\nCafé " + i);
			System.out.print("Seleccione toppings (ej: 1,3,6): ");
			String[] ops = sc.next().split(",");

			for (String op : ops) {
				int choice = Integer.parseInt(op.trim());
				if (choice == 6) {
					System.out.print("Nombre nuevo topping: ");
					String n = sc.next();
					System.out.print("Precio: ");
					double p = sc.nextDouble();
					miCafe = new ToppingConcreto(miCafe, n, p);
				} else if (nombres.containsKey(choice)) {
					miCafe = new ToppingConcreto(miCafe, nombres.get(choice), precios.get(choice));
				}
			}
			pedidoTotal.add(miCafe);
		}

		System.out.println("\nDOSW COMPANY\n--- RESUMEN DE CAFE PERSONALIZADO");
		pedidoTotal.forEach(c -> System.out.println("Ingredientes: " + c.getDescripcion() + "\nPrecio: $" + c.getPrecio() + "\n-"));

		double totalGeneral = pedidoTotal.stream().mapToDouble(Cafe::getPrecio).sum();
		System.out.println("Total a pagar por todos los cafés: $" + totalGeneral + "\n¡Disfrute su café!");
	}

	public static void main(String[] args) {
		test();
	}
}
