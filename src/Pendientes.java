import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pendientes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numPendientes = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Integer> pendientes = new ArrayList<>();

        while (numPendientes != 0) {
            String linea = scanner.nextLine();
            String[] numeros = linea.split("\\s+");

            for (String numero : numeros) {
                    int num = Integer.parseInt(numero);
                    pendientes.add(num);
            }
            numPendientes = scanner.nextInt();
            scanner.nextLine();
        }

        Map<Integer, Integer> pareja = new HashMap<>();
        for (int pendiente : pendientes) {
            pareja.put(pendiente, pareja.getOrDefault(pendiente, 0) + 1);
        }

        int contador = 0;
        for (int parejas : pareja.values()) {
            if (parejas > 1) {
                contador += parejas / 2;
            }
        }

        System.out.println(contador);

    }
}
