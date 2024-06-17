import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Potitos {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numeropotitos;
        int cantidadPotitos= 0;

        do {
                numeropotitos = entrada.nextInt();
                entrada.nextLine();
                if (numeropotitos == 0){
                    break;
                }
                cantidadPotitos += numeropotitos;

                ArrayList<String> ingredientesGustan = new ArrayList<>();


                for (int i = 0; i < numeropotitos; i++) {
                    String frase = entrada.nextLine();

                    if (frase.startsWith("SI:")) {
                        String[] frasePartida = frase.substring(3).trim().split("\\s+");
                        for (String ingrediente : frasePartida) {
                            ingredientesGustan.add(ingrediente);
                        }
                    } else if (frase.startsWith("NO:")) {
                        String[] frasePartida = frase.substring(3).trim().split("\\s+");
                        ArrayList<String> noGustan = new ArrayList<>();
                        for (String ingrediente : frasePartida) {
                            if (!ingredientesGustan.contains(ingrediente)) {
                                noGustan.add(ingrediente);
                            }
                        }
                        for (String nogustan : noGustan) {
                            System.out.println(nogustan);
                        }
                    }
            }
        }while (cantidadPotitos ==25 || numeropotitos ==0);
    }
}

